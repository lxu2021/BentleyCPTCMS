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

  /**
   * Logs a user in
   * modified by Prof. Matra
   */
  def loginAccount() = Action { implicit request =>
    LoginForm.form.bindFromRequest.fold(
      {
      formWithErrors => //Login fails
        appLogger.debug(s"Login Form Has Errors ${formWithErrors.toString()}")
        BadRequest(views.html.login(formWithErrors, "Login"))
    },
      form => { //Login succeeds

        //Check the login credentials against the DB
        if (Account.validateUser(form.email, form.password)) {
          appLogger.debug("Successful Login")
          val acc = Account.findRecord(form.email)
          val accType = acc.AccountType
          appLogger.debug(s"Account Type: $accType")
          
          //Check which type of user you are and store your email in an encrypted session cookie
          accType match {
            case "Student" => Redirect("/dashboard").withSession("username" -> acc.Email)
            case "Advisor" => Redirect("/advisor").withSession("username" -> acc.Email)
            case "Coordinator" => Redirect("/coordinator").withSession("username" -> acc.Email) 
            case _ => Redirect(routes.HomeController.landing()) //I dont know what type of user you are
          }
        } else {
          //Bad Login so redirect them back to the login page and flash a message
          appLogger.debug(s" Invalid user or password for account: ${form.email}")
          Redirect("/login").flashing("error" -> "Invalid username and/or password")
        }
      })
  }
  
  /**
   * Logs a user out, by invalidating their session
   * added by Prof. Matra
   */
  def logout = Action {
    Redirect(routes.HomeController.loadPage("login")).withNewSession
    
  }

}
