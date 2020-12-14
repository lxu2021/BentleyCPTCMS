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
import forms.DeanForm
import forms.AppForm
import model.db.collections.Application
import model.db.collections.Account

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
//@Singleton
class DeanReviewController @Inject() (cc: ControllerComponents) extends AbstractController(cc) with I18nSupport {
  
  //Setup an application logger
  val appLogger: Logger = Logger("form")
  
  //showing the views of the dean page and the student's applications that are approved by the coordinator and the advisor
  def review(id:String) = Action { implicit request: Request[AnyContent] =>

    val username = request.session.get("username")
    val acct = Try(Some(Account.findRecord(username.get))).getOrElse(None)
    val res = Try(Some(Application.findIdRecord(id))).getOrElse(None)
    
    Ok(views.html.deanreview(res, "Dean Application Review",acct, AppForm.form))
  }
  
// showing the student's application to make a change on the status
 def update(id:String) = Action { implicit request: Request[AnyContent] =>

    val username = request.session.get("username")
    val acct = Try(Some(Account.findRecord(username.get))).getOrElse(None)
    val res = Try(Some(Application.findIdRecord(id))).getOrElse(None)
          
       Ok(views.html.deanreview(res, "Dean Form Update", acct, AppForm.form))
   }
 
 //post the dean status to the application form
 def formSubmit() = Action{implicit request =>
     DeanForm.form.bindFromRequest.fold(
         formWithErrors => Ok(formWithErrors.toString),
              
          form => {
            Application.deanUpdate(form.id, form.dean_status)
            Redirect("/dean")    
          })
   }



}