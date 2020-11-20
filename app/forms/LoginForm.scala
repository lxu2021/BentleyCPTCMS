package forms

import play.api.data.Form
import play.api.data.Forms._
import play.api.data.format.Formats._

object LoginForm {
  
  val form = Form[Data](
      mapping(
          "id"-> optional(text),
          "username" -> nonEmptyText,
          "password" -> email
          )(Data.apply)(Data.unapply)
        )
  
  case class Data(
        id: Option[String],
        username: String,
        password: String
        )
  
}