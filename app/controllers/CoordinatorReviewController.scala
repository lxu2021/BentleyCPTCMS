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
import forms.CoordinatorForm
import forms.AppForm
import model.db.collections.Application
import model.db.collections.Account

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
//@Singleton
class CoordinatorReviewController @Inject() (cc: ControllerComponents) extends AbstractController(cc) with I18nSupport {
  
  //Setup an application logger
  val appLogger: Logger = Logger("form")
  
   //showing the views of the dean page and the student's applications which coordinator's email equal to the account email
  def review(id:String) = Action { implicit request: Request[AnyContent] =>

    val username = request.session.get("username")
    val acct = Try(Some(Account.findRecord(username.get))).getOrElse(None)
    val res = Try(Some(Application.findIdRecord(id))).getOrElse(None)
    
    Ok(views.html.coordinatorreview(res, "Coordinator Application Review",acct, AppForm.form))
  }
 
 //post the coordinator status to the application form
 def formSubmit() = Action{implicit request =>
     CoordinatorForm.form.bindFromRequest.fold(
         formWithErrors => Ok(formWithErrors.toString),
              
          form => {
            Application.coordinatorUpdate(form.id, form.coordinator_status, form.coordinator_comment)
            Redirect("/coordinator")    
          })
   }



}