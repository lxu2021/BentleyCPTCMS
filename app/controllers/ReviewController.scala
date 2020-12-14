package controllers

import javax.inject.Inject
import scala.util.Try
import scala.collection.mutable.ListBuffer
import play.api._
import play.api.mvc._
import play.api.i18n._
import play.api.data._
import play.api.data.Forms._
import play.api.i18n.{ Lang, Langs, I18nSupport, Messages, MessagesApi, MessagesProvider, MessagesImpl }
import forms.AppForm
import forms.ReviewForm
import model.db.collections.Application
import model.db.collections.Account

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
//@Singleton
class ReviewController @Inject() (cc: ControllerComponents) extends AbstractController(cc) with I18nSupport {

  //Setup an application logger
  val appLogger: Logger = Logger("form")
  //This prvoides aa general review page for student application. Fields on this page are not editable
  def review(id:String) = Action { implicit request: Request[AnyContent] =>

    val username = request.session.get("username")
    val acct = Try(Some(Account.findRecord(username.get))).getOrElse(None)
    val res = Try(Some(Application.findIdRecord(id))).getOrElse(None)
    Ok(views.html.review(res, "Review Submitted Application",acct))
  }
  
  
  // This provides the student a review page with the option to update existing application information
  def update(id:String) = Action { implicit request: Request[AnyContent] =>
    val username = request.session.get("username")
    val acct = Try(Some(Account.findRecord(username.get))).getOrElse(None)
    val res = Try(Some(Application.findIdRecord(id))).getOrElse(None)
    
    Ok(views.html.studentreview(res,"Advisor Application Review",acct, ReviewForm.form ))
  }
  
  
  
  
  
  //Submits the updated student application when a student updates their application. 
  //Only fields that are editable by the student are made available 
  //The student's application is identified by the unique application id ("id")
  def formSubmit() = Action{implicit request =>
     ReviewForm.form.bindFromRequest.fold(
         formWithErrors => Ok(formWithErrors.toString),
//            BadRequest(views.html.form(formWithErrors)),
              
          form => {
            Application.studentUpdate(form.id,form.name, form.email, form.international, form.major, form.concentration, form.studentId,
                form.gpa, form.company, form.position,form.credit_type, form.course, form.description,form.advisor_email)
            Redirect("/dashboard")    
          })
   }


}
