
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object form extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Form[forms.AppForm.Data],String,RequestHeader,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(appForm: Form[forms.AppForm.Data], page: String)(implicit request: RequestHeader, messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import b4.vertical.fieldConstructor

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ b4.vertical.fieldConstructor() }};
Seq[Any](format.raw/*3.64*/("""

"""),_display_(/*5.2*/main(page)/*5.12*/{_display_(Seq[Any](format.raw/*5.13*/("""
	"""),format.raw/*6.2*/("""<a href="#" class="navbar-nav-link d-flex align-items-center dropdown-toggle" data-toggle="dropdown">
       <img src=""""),_display_(/*7.19*/routes/*7.25*/.Assets.versioned("images/placeholders/placeholder.jpg")),format.raw/*7.81*/("""" class="rounded-circle mr-2" height="34" alt="">
       <span>"""),_display_(/*8.15*/messages("identity")),format.raw/*8.35*/("""</span>
   </a>
""")))}/*10.2*/{_display_(Seq[Any](format.raw/*10.3*/("""
"""),format.raw/*11.1*/("""<div class="content">
	"""),_display_(/*12.3*/b4/*12.5*/.vertical.formCSRF(routes.HomeController.formSubmit(), 'id -> "appForm", 'class -> "wizard-form steps-validation wizard clearfix")/*12.135*/ {implicit vfc =>_display_(Seq[Any](format.raw/*12.152*/("""
		"""),format.raw/*13.3*/("""<div class="card" style="padding:30px;">
      		<div class="card-header bg-white header-elements-inline">
        			<h6 class="card-title">Application Form</h6>
        			<div class="header-elements">
         			<div class="list-icons">
            				<a class="list-icons-item" data-action="collapse"></a>
            				<a class="list-icons-item" data-action="reload"></a>
            				<a class="list-icons-item" data-action="remove"></a>
          			</div>
        			</div>
      		</div>
      		<br>
      		<h6>Personal data</h6>
      		<br>
      		<div class="row">
      			<div class="col-md-6">
        				<div class="form-group">
                			"""),_display_(/*30.21*/b4/*30.23*/.text(appForm("name"), '_label -> "Application name", 'class -> "form-control required", 'placeholder -> "John Doe")),format.raw/*30.139*/("""
        				"""),format.raw/*31.13*/("""</div>
       			</div>
				<div class="col-md-6">
					<div class="form-group">
						"""),_display_(/*35.8*/b4/*35.10*/.text(appForm("email"), '_label -> "Email address", 'class -> "form-control required", 'placeholder -> "your@email.com")),format.raw/*35.130*/("""
           			"""),format.raw/*36.15*/("""</div>
       			</div>
			</div>
          	<div class="row">
            		<div class="col-md-6">
              		<div class="form-group">
                			"""),_display_(/*42.21*/b4/*42.23*/.radio(appForm("international"), options = Seq("true" -> "Yes", "false" -> "No"), '_label -> "International Student?")),format.raw/*42.141*/("""              
              		"""),format.raw/*43.17*/("""</div>
            		</div>

            		<div class="col-md-6">
            			<div class="form-group">
                			"""),_display_(/*48.21*/b4/*48.23*/.radio(appForm("cpt"), options = Seq("true" -> "Yes", "false" -> "No"), '_label -> "Applying for CPT?")),format.raw/*48.126*/("""
                		"""),format.raw/*49.19*/("""</div>
            		</div>
			</div>
			
			<br>
			<h6>Education</h6>
        		<br>
          	<div class="row">
            		<div class="col-md-6">
              		<div class="form-group">
                			"""),_display_(/*59.21*/b4/*59.23*/.select(appForm("major"), options = Seq("0"-> "","1" -> "MBA", "2" -> "MSA", "3" -> "MSAA", "4" -> "MSBA", "5" -> "MSF", "6" -> "MSHFID", "7" -> "MST"), '_label -> "Major")),format.raw/*59.195*/("""
              		"""),format.raw/*60.17*/("""</div>
            		</div>

            		<div class="col-md-6">
              		<div class="form-group">
                			"""),_display_(/*65.21*/b4/*65.23*/.select(appForm("concentration"), options = Seq("0_2"-> "", "1_2" -> "Accountancy", "2_2" -> "Business Analytics", "3_2" -> "Finance", "4_2" -> "Information Systems and Technology", "5_2" -> "Law and Taxation", "6_2" -> "Leadership", "7_2" -> "Marketing"), '_label -> "MBA Concentration(if applicable)")),format.raw/*65.326*/("""
              		"""),format.raw/*66.17*/("""</div>
            		</div>
          	</div>

          	<div class="row">
            		<div class="col-md-6">
              		<div class="form-group">
                			"""),_display_(/*73.21*/b4/*73.23*/.text(appForm("gpa"), '_label -> "Overall GPA(out of 4.0)", 'class -> "form-control required", 'placeholder -> "4.0")),format.raw/*73.140*/("""
              		"""),format.raw/*74.17*/("""</div>
            		</div>

            		<div class="col-md-6">
              		<div class="row">
                			<div class="col-md-6">
                				"""),_display_(/*80.22*/b4/*80.24*/.date(appForm("school_start"), '_label -> "Program Start")),format.raw/*80.82*/("""
                			"""),format.raw/*81.20*/("""</div>
                			<div class="col-md-6">
                				"""),_display_(/*83.22*/b4/*83.24*/.date(appForm("school_end"), '_label -> "Expect Graduation")),format.raw/*83.84*/("""
                			"""),format.raw/*84.20*/("""</div>
              		</div>
            		</div>
          	</div>
			
			<br>
        		<h6>Internship Details</h6>
        		<br>
          	<div class="row">
            		<div class="col-md-6">
              		<div class="form-group">
                			"""),_display_(/*95.21*/helper/*95.27*/.inputText(appForm("company"), '_label -> "Company", 'class -> "form-control required", 'placeholder -> "company name")),format.raw/*95.146*/("""
              		"""),format.raw/*96.17*/("""</div>

              		<div class="form-group">
                			"""),_display_(/*99.21*/helper/*99.27*/.inputText(appForm("position"), '_label -> "Internship Position", 'class -> "form-control required", 'placeholder -> "Data Analytics Intern")),format.raw/*99.168*/("""
              		"""),format.raw/*100.17*/("""</div>

              		<div class="row">
                			<div class="col-md-6">
                  			"""),_display_(/*104.23*/b4/*104.25*/.date(appForm("start"), '_label -> "From")),format.raw/*104.67*/(""" 
                			"""),format.raw/*105.20*/("""</div>
                			<div class="col-md-6">
                  			"""),_display_(/*107.23*/b4/*107.25*/.date(appForm("end"), '_label -> "To")),format.raw/*107.63*/("""
                			"""),format.raw/*108.20*/("""</div>
              		</div>
            		</div>

            		<div class="col-md-6">
              		<div class="form-group">
              			"""),_display_(/*114.19*/b4/*114.21*/.radio(appForm("credit_type"), options = Seq("1-cred" -> "1 credit", "3-cred" -> "3 credits"), '_label -> "Which type of internship you apply for")),format.raw/*114.168*/("""
              		"""),format.raw/*115.17*/("""</div>
              		<div class="form-group">
                			"""),_display_(/*117.21*/b4/*117.23*/.textarea(appForm("description"), '_label -> "How this intenship related to your program", 'class -> "form-control", 'placeholder -> "It is a ...", 'rows -> "10", 'cols -> "4")),format.raw/*117.199*/("""
              		"""),format.raw/*118.17*/("""</div>

            		</div>
          	</div>
        </div>
         

  """)))}),format.raw/*125.4*/("""
 	"""),format.raw/*126.3*/("""</div>
          <!-- /wizard with validation -->
  <!-- /content area -->
""")))}),format.raw/*129.2*/("""
"""))
      }
    }
  }

  def render(appForm:Form[forms.AppForm.Data],page:String,request:RequestHeader,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(appForm,page)(request,messages)

  def f:((Form[forms.AppForm.Data],String) => (RequestHeader,Messages) => play.twirl.api.HtmlFormat.Appendable) = (appForm,page) => (request,messages) => apply(appForm,page)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-11-12T11:26:29.702
                  SOURCE: C:/Users/zeeyi/Desktop/Fall-2020/Scala Codes/internship/app/views/form.scala.html
                  HASH: c7aa67515ec489352eb32b7ed758fa90c40dcdd5
                  MATRIX: 776->1|951->105|1008->142|1040->166|1108->204|1136->207|1154->217|1192->218|1220->220|1366->340|1380->346|1456->402|1546->466|1586->486|1621->503|1659->504|1687->505|1737->529|1747->531|1887->661|1943->678|1973->681|2675->1356|2686->1358|2824->1474|2865->1487|2979->1575|2990->1577|3132->1697|3175->1712|3363->1873|3374->1875|3514->1993|3573->2024|3726->2150|3737->2152|3862->2255|3909->2274|4150->2488|4161->2490|4355->2662|4400->2679|4554->2806|4565->2808|4890->3111|4935->3128|5136->3302|5147->3304|5286->3421|5331->3438|5521->3601|5532->3603|5611->3661|5659->3681|5756->3751|5767->3753|5848->3813|5896->3833|6184->4094|6199->4100|6340->4219|6385->4236|6481->4305|6496->4311|6659->4452|6705->4469|6839->4575|6851->4577|6915->4619|6965->4640|7064->4711|7076->4713|7136->4751|7185->4771|7361->4919|7373->4921|7543->5068|7589->5085|7685->5153|7697->5155|7896->5331|7942->5348|8049->5424|8080->5427|8187->5503
                  LINES: 21->1|24->2|26->3|26->3|27->3|29->5|29->5|29->5|30->6|31->7|31->7|31->7|32->8|32->8|34->10|34->10|35->11|36->12|36->12|36->12|36->12|37->13|54->30|54->30|54->30|55->31|59->35|59->35|59->35|60->36|66->42|66->42|66->42|67->43|72->48|72->48|72->48|73->49|83->59|83->59|83->59|84->60|89->65|89->65|89->65|90->66|97->73|97->73|97->73|98->74|104->80|104->80|104->80|105->81|107->83|107->83|107->83|108->84|119->95|119->95|119->95|120->96|123->99|123->99|123->99|124->100|128->104|128->104|128->104|129->105|131->107|131->107|131->107|132->108|138->114|138->114|138->114|139->115|141->117|141->117|141->117|142->118|149->125|150->126|153->129
                  -- GENERATED --
              */
          