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

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
//@Singleton
class HomeController @Inject() (cc: ControllerComponents) extends AbstractController(cc) with I18nSupport {

  //Setup an application logger
  val appLogger: Logger = Logger("application")

  def index() = Action { implicit request: Request[AnyContent] =>
    val messages: Messages = request.messages
    val title: String = messages("home.title") 
    val identity:String = messages("identity")
    
    Ok(views.html.index("Dashboard"))
  }

   def login() = Action { implicit request: Request[AnyContent] =>
     Ok(views.html.login("login"))
   }
   
   def formSubmit() = Action{implicit request =>
     AppForm.form.bindFromRequest.fold(
         formWithErrors => Ok(formWithErrors.toString),
//            BadRequest(views.html.form(formWithErrors)),
              
          form => {
//            val offer_ids = form.offer_ids.getOrElse("")
//            val offer_format = form.offer_format.getOrElse("")
//            
//            Application.createApp(
//                form.name, form.email, form.international, form.cpt, form.major, form.concentration,
//                form.gpa, form.school_start_season, form.school_start_year,form.school_end_season,
//                form.school_end_year, form.company, form.position, form.start, form.end,
//                form.offer_ids, form.offer_format, form.credit_type, form.description)
            Redirect("/")    
          })
   }

  def loadPage(page: String) = Action { implicit request: Request[AnyContent] =>
    appLogger.debug(s"Loading page: $page")
    
    page match {
      case "form"    => Ok(views.html.form(AppForm.form, "Form"))
      case _         => Ok(views.html.index("Dashboard"))
    }
  }

}
