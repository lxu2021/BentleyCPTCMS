package forms

import play.api.data.Form
import play.api.data.Forms._
import play.api.data.format.Formats._
object ReviewForm {
  
  
 //Handles the form submission when a student reviews/update thier application. In this case, the application ID exists already.
 // Only fields that are editable by the student are made available
  val form = Form[Data](
      mapping(
          "id"-> nonEmptyText,
          "name" -> nonEmptyText,
          "email" -> email,
          "international" -> boolean,
          "major" -> nonEmptyText,
          "concentration" -> optional(text),
          "studentId" -> nonEmptyText,
          "gpa" -> optional(of(doubleFormat)), 
          "company" -> nonEmptyText,
          "position" -> nonEmptyText,
          "credit_type" -> nonEmptyText,
          "course" ->nonEmptyText,
          "description" -> nonEmptyText,
          "advisor_email" -> optional(text),
        
          )(Data.apply)(Data.unapply)
        )
  
  case class Data(
        id: String,
        name: String,
        email: String,
        international: Boolean,
        major: String,
        concentration: Option[String],
        studentId:String,
        gpa: Option[Double],
        company: String,
        position: String,
        credit_type: String,
        course: String,
        description: String,
        advisor_email: Option[String]
        )
  
}