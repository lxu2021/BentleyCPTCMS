package forms

import play.api.data.Form
import play.api.data.Forms._
import play.api.data.format.Formats._

//This form is used to update the Advisor's status on an application. Only available to advisors
object AdvisorForm {
  
  val form = Form[Data](
      mapping(
          "id"-> nonEmptyText,
          "advisor_status" -> nonEmptyText,
          "advisor_comment" -> nonEmptyText
          )(Data.apply)(Data.unapply)
        )
  
  case class Data(
        id: String,
        advisor_status: String,
        advisor_comment: String
        )
  
}