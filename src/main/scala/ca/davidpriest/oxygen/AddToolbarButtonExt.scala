package ca.davidpriest.oxygen

import java.awt.event.{ActionEvent, ActionListener}
import java.net.URL
import java.util
import javax.swing.{JButton, JComponent, JFrame, JOptionPane}

import ca.davidpriest.addtoolbarbutton.ButtonAction
import ro.sync.exml.plugin.workspace.WorkspaceAccessPluginExtension
import ro.sync.exml.workspace.api.PluginWorkspace
import ro.sync.exml.workspace.api.editor.WSEditor
import ro.sync.exml.workspace.api.listeners.WSEditorChangeListener
import ro.sync.exml.workspace.api.standalone.{StandalonePluginWorkspace, ToolbarComponentsCustomizer, ToolbarInfo}

class AddToolbarButtonExt extends WorkspaceAccessPluginExtension {

  private val demoButton: JButton = new JButton("Scala Button")
  // title not used?
  private var pluginWorkspaceAccess: StandalonePluginWorkspace = _
  private var currentEditor: WSEditor = _
  private var currentEditorLocation: String = _

  override def applicationStarted(
                                   pluginWorkspaceAccess: StandalonePluginWorkspace) {
    this.pluginWorkspaceAccess = pluginWorkspaceAccess
    checkCurrentEditorAndChangeButtonStatus()
    pluginWorkspaceAccess
      .addEditorChangeListener(new WSEditorChangeListener() {

        override def editorOpened(editorLocation: URL) {
          checkCurrentEditorAndChangeButtonStatus()
        }

        override def editorPageChanged(editorLocation: URL) {
          checkCurrentEditorAndChangeButtonStatus()
        }

        override def editorSelected(editorLocation: URL) {
          checkCurrentEditorAndChangeButtonStatus()
        }

        override def editorActivated(editorLocation: URL) {
          checkCurrentEditorAndChangeButtonStatus()
        }

        override def editorClosed(editorLocation: URL) {
          checkCurrentEditorAndChangeButtonStatus()
        }
      }, PluginWorkspace.MAIN_EDITING_AREA)

    pluginWorkspaceAccess.addToolbarComponentsCustomizer(
      new ToolbarComponentsCustomizer() {

        override def customizeToolbar(toolbarInfo: ToolbarInfo) {
          if (toolbarInfo.getToolbarID == "scalatoolbar") { // id from plugin.xml
            demoButton.addActionListener(new ActionListener() {

              def actionPerformed(e: ActionEvent) {

                val bAction = new ButtonAction(currentEditorLocation)

                JOptionPane.showMessageDialog(
                  new JFrame(),
                  "\n" + ButtonAction.objectAction +
                    "\n" + bAction.classAction,
                  "Scala Demo: Add Toolbar Button", // message dialog title bar label
                  JOptionPane.INFORMATION_MESSAGE)
              }
            })
            val comps = new util.ArrayList[JComponent]()
            comps.add(demoButton)
            toolbarInfo.setComponents(
              comps.toArray(Array.ofDim[JComponent](0)))
            toolbarInfo.setTitle("Scala Toolbar") // toolbar name used in 'Configure Toolbars...'
          }
        }
      })
  }

  private def checkCurrentEditorAndChangeButtonStatus() {
    this.currentEditor = pluginWorkspaceAccess.getCurrentEditorAccess(
      PluginWorkspace.MAIN_EDITING_AREA)
    if (currentEditor == null) {
      this.currentEditorLocation = null
      demoButton.setEnabled(false)
    } else {
      this.currentEditorLocation = currentEditor.getEditorLocation.toString
      if (currentEditorLocation.endsWith(".xsl")) {
        demoButton.setEnabled(true)
        demoButton.setText("Scala Toolbar Plugin Demo") // toolbar button label
      } else {
        demoButton.setEnabled(false)
      }
    }
  }

  override def applicationClosing(): Boolean = true
}
