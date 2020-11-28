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
          "cpt" -> boolean,
          "major" -> nonEmptyText,
          "concentration" -> optional(text),
          "studentId" -> nonEmptyText,
          "gpa" -> optional(of(doubleFormat)),  
          "school_start" -> date,
          "school_end" -> date,
          "company" -> nonEmptyText,
          "position" -> nonEmptyText,
          "start" -> date,
          "end" -> date,
//          "offer_ids" -> optional(text),  
//          "offer_format" -> optional(text),
          "credit_type" -> nonEmptyText,
          "course" ->nonEmptyText,
          "description" -> nonEmptyText
          )(Data.apply)(Data.unapply)
        )
  
  case class Data(
        id: Option[String],
        name: String,
        email: String,
        international: Boolean,
        cpt: Boolean,
        major: String,
        concentration: Option[String],
        studentId:String,
        gpa: Option[Double],  
        school_start: java.util.Date,
        school_end: java.util.Date,
        company: String,
        position: String,
        start: java.util.Date,
        end: java.util.Date,
//        offer_ids: Option[String],  
//        offer_format: Option[String],
        credit_type: String,
        course: String,
        description: String)
  
}