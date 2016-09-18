package ca.davidpriest.addtoolbarbutton

class buttonAction(val document: String) {

  import buttonAction._

  def classAction =
    "\nin classAction:" +
      "\n  file path : " + document +
      "\n  objectVal = '" + objectVal + "'" +
      "\n  " + objectAction
}

object buttonAction {

  val objectVal: String = "object value"

  def objectAction =
    "in objectAction: objectVal = '" + objectVal + "'"

  def apply(document: String) = {
    new buttonAction(document)
    "buttonAction apply"
  }
}
