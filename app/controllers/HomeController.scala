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
import play.api.i18n.Messages.Implicits._
import forms.AppForm
import forms.LoginForm
import model.db.collections.Account
import model.db.collections.Application

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page and other pages.
 */
//@Singleton
class HomeController @Inject() (cc: ControllerComponents) extends AbstractController(cc) with I18nSupport {

  //Setup an application logger
  val appLogger: Logger = Logger("application")

  def landing() = Action { implicit request: Request[AnyContent] =>   
    Ok(views.html.landing("Homepage"))
  }


  def loadPage(page: String) = Action { implicit request: Request[AnyContent] =>
    appLogger.debug(s"Loading page: $page")
    val username = request.session.get("username")
    appLogger.debug(s"getting username: $username")
    val acct = Try(Some(Account.findRecord(username.get))).getOrElse(None)
    
    page match {
      case "form"                    => Ok(views.html.form(AppForm.form, "Form", acct))
      case "department"              => Ok(views.html.department("Department", acct))
      case "coordinator"             => {
        val res = Application.findEmail(username.get)
        appLogger.info("Result is: " + res)
        Ok(views.html.coordinator("Coordinator", acct, res))
      }
      case "advisor"             => {
        val res = Application.findAdvisorEmail(username.get)
        appLogger.info("Result is: " + res)
        Ok(views.html.advisor("Advisor", acct, res))
      }
//      case "review"                  => {
//        val res = Try(Some(Application.findRecord(username.get))).getOrElse(None)
//        Ok(views.html.review(res, "Review", acct))
//      }
      case "login"                   => Ok(views.html.login(LoginForm.form,"Login"))
      case "dashboard"               => {
        
        //only logged-in users can view dashboard
        var res = Try(Some(Application.findRecord(username.get))).getOrElse(None)
        
          if (username != None) {
          var res = Try(Some(Application.findRecord(username.get))).getOrElse(None)
          appLogger.info("Application Info: " + res)
          
          Ok(views.html.index("Dashboard", acct, res))
        } else {
          Ok(views.html.landing("Homepage"))
        }
      }
      case "academicrequirement"     => Ok(views.html.academicrequirement("Academic Requirement"))
      case _                         => Ok(views.html.landing("Homepage"))
    }
  }
  

}
