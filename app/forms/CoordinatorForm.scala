package forms

import play.api.data.Form
import play.api.data.Forms._
import play.api.data.format.Formats._

object CoordinatorForm {
  
  val form = Form[Data](
      mapping(
          "id"-> nonEmptyText,
          "coordinator_status" -> nonEmptyText,
          )(Data.apply)(Data.unapply)
        )
  
  case class Data(
        id: String,
        coordinator_status: String,
        )
  
}