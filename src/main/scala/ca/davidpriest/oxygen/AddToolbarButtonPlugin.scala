package ca.davidpriest.oxygen

import ca.davidpriest.oxygen.AddToolbarButtonPlugin._
import ro.sync.exml.plugin.{Plugin, PluginDescriptor}

import scala.beans.BeanProperty

object AddToolbarButtonPlugin {

  @BeanProperty
  var instance: AddToolbarButtonPlugin = _
}

class AddToolbarButtonPlugin(descriptor: PluginDescriptor)
  extends Plugin(descriptor) {

  if (instance != null) {
    throw new IllegalStateException("Already instantiated!")
  }

  instance = this
}
