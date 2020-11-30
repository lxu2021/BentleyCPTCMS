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
import model.db.collections.Application
import model.db.collections.Account

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
//@Singleton
class FormController @Inject() (cc: ControllerComponents) extends AbstractController(cc) with I18nSupport {

  //Setup an application logger
  val appLogger: Logger = Logger("form")
  
  def read(id:String) = Action { implicit request: Request[AnyContent] =>

//    val res = Application.findRecord(id)
    val username = request.session.get("username")
    val acct = Try(Some(Account.findRecord(username.get))).getOrElse(None)
    val res = Try(Some(Application.findRecord(username.get))).getOrElse(None)
    Ok(views.html.review(res, "Review Submitted Application",acct))
  }

    
    def formSubmit() = Action{implicit request =>
     AppForm.form.bindFromRequest.fold(
         formWithErrors => Ok(formWithErrors.toString),
//            BadRequest(views.html.form(formWithErrors)),
              
          form => {
            
            Application.createApplication(
                form.name, form.email, form.international, form.cpt, form.major, form.concentration, form.studentId,
                form.gpa, form.school_start,form.school_end, form.company, form.position, form.start, form.end, 
                form.credit_type, form.course, form.description)
            Redirect("/")    
          })
   }


}
