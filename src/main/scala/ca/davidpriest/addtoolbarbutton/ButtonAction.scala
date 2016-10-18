package ca.davidpriest.addtoolbarbutton

class ButtonAction(val document: String) {

  import ButtonAction._

  def classAction =
    "\nin classAction:" +
      "\n  file path : " + document +
      "\n  objectVal = '" + objectVal + "'" +
      "\n  " + objectAction
}

object ButtonAction {

  val objectVal: String = "object value"

  def objectAction =
    "in objectAction: objectVal = '" + objectVal + "'"

  def apply(document: String) = {
    new ButtonAction(document)
    "buttonAction apply"
  }
}
