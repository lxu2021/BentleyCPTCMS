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
import forms.LoginForm
import model.db.collections.Account

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
//@Singleton
class LoginController @Inject() (cc: ControllerComponents) extends AbstractController(cc) with I18nSupport {

  //Setup an application logger
  val appLogger: Logger = Logger("application")
  
//  def read(email:String) = Action { implicit request: Request[AnyContent] =>
//
//    val res = Application.findRecord(email)
//    Ok(views.html.review(res, "Review Submitted Application"))
//  }

  def loginAccount() = Action{implicit request =>
     LoginForm.form.bindFromRequest.fold(
         formWithErrors => Ok(formWithErrors.toString),
//            BadRequest(views.html.form(formWithErrors)),
              
          form => {
            val acc = Account.findRecord(form.email)
            appLogger.debug(acc.toString)
            val accType = acc.AccountType
            accType match {
              case "student"  => Redirect("/dashboard")
              case "advisor"  => Redirect("/advisor")
              case _          => Redirect("/coordinator")   
            }
           }
          
      )
   }

}
