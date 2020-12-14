package forms

import play.api.data.Form
import play.api.data.Forms._
import play.api.data.format.Formats._

object DeanForm {
  
  val form = Form[Data](
      mapping(
          "id"-> nonEmptyText,
          "dean_status" -> nonEmptyText
          )(Data.apply)(Data.unapply)
        )
  
  case class Data(
        id: String,
        dean_status: String
        )
  
}