package forms

import play.api.data.Form
import play.api.data.Forms._
import play.api.data.format.Formats._

object LoginForm {
  
  val form = Form[Data](
      mapping(
          "id"-> optional(text),
          "email" -> email,
          "password" -> nonEmptyText
          )(Data.apply)(Data.unapply)
        )
  
  case class Data(
        id: Option[String],
        email: String,
        password: String
        )
  
}