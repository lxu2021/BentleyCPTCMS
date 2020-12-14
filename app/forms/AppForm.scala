package forms

import play.api.data.Form
import play.api.data.Forms._
import play.api.data.format.Formats._

object AppForm {
  
  val form = Form[Data](
      mapping(
          "id"-> optional(text),
          "name" -> nonEmptyText,
          "email" -> email,
          "international" -> boolean,
          "major" -> nonEmptyText,
          "concentration" -> optional(text),
          "studentId" -> nonEmptyText,
          "gpa" -> optional(of(doubleFormat)), 
          "company" -> nonEmptyText,
          "position" -> nonEmptyText,
          "start" -> date,
          "end" -> date,
          "credit_type" -> nonEmptyText,
          "course" ->nonEmptyText,
          "description" -> nonEmptyText,
          "coordinator_status" -> nonEmptyText,
          "coordinator_email" -> optional(text),
          "coordinator_comment" -> nonEmptyText,
          "advisor_status" -> nonEmptyText,
          "advisor_email" -> optional(text),
          "advisor_comment" -> nonEmptyText,
          "dean_status" -> nonEmptyText
          )(Data.apply)(Data.unapply)
        )
  
  case class Data(
        id: Option[String],
        name: String,
        email: String,
        international: Boolean,
        major: String,
        concentration: Option[String],
        studentId:String,
        gpa: Option[Double],
        company: String,
        position: String,
        start: java.util.Date,
        end: java.util.Date,
        credit_type: String,
        course: String,
        description: String,
        coordinator_status: String,
        coordinator_email: Option[String],
        coordinator_comment: String,
        advisor_status: String,
        advisor_email: Option[String],
        advisor_comment: String,
        dean_status:String
        )
  
}