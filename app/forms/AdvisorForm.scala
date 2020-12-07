package forms

import play.api.data.Form
import play.api.data.Forms._
import play.api.data.format.Formats._

object AdvisorForm {
  
  val form = Form[Data](
      mapping(
          "id"-> nonEmptyText,
          "advisor_status" -> nonEmptyText,
          )(Data.apply)(Data.unapply)
        )
  
  case class Data(
        id: String,
        advisor_status: String,
        )
  
}