
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(topic: String)(implicit messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main(topic)/*3.13*/{_display_(Seq[Any](format.raw/*3.14*/("""
	"""),format.raw/*4.2*/("""<a href="#" class="navbar-nav-link d-flex align-items-center dropdown-toggle" data-toggle="dropdown">
       <img src=""""),_display_(/*5.19*/routes/*5.25*/.Assets.versioned("images/placeholders/placeholder.jpg")),format.raw/*5.81*/("""" class="rounded-circle mr-2" height="34" alt="">
       <span>"""),_display_(/*6.15*/messages("identity")),format.raw/*6.35*/("""</span>
   </a>
""")))}/*8.2*/{_display_(Seq[Any](format.raw/*8.3*/("""
  """),format.raw/*9.3*/("""<div class="content">
    <!-- Stats with progress -->
    <div class="mb-3 pt-2">
      <h6 class="mb-0 font-weight-semibold">
        Process Completion Status
      </h6>
    </div>

    <div class="row">
      

      <div class="col-sm-6 col-xl-3">
        <!-- Orders processed -->
        <div class="card card-body text-center bg-teal-400 has-bg-image">
          <div class="svg-center position-relative" id="progress_icon_three"></div>
          <h2 class="progress-percentage mt-2 mb-1 font-weight-semibold">"""),_display_(/*24.75*/messages("percentage")),format.raw/*24.97*/("""</h2>

          Application Processed
          <div class="font-size-sm opacity-75">"""),_display_(/*27.49*/messages("task_complete_count")),format.raw/*27.80*/(""" """),format.raw/*27.81*/("""tasks completed</div>
        </div>
        <!-- /orders processed -->
      </div>
    </div>

    <div class="mb-3 pt-2">
      <h6 class="mb-0 font-weight-semibold">
        Current Application
      </h6>
    </div>
    <div>
      <div class="card">
        <div class="card-header header-elements-sm-inline">
          <h6 class="card-title">Task Completion Details</h6>
        </div>

        

        <div class="card-body d-md-flex align-items-md-center justify-content-md-between flex-md-wrap">
          <div class="d-flex align-items-center mb-3 mb-md-0">
            <a href="#" class="btn bg-transparent border-indigo-400 text-indigo-400 rounded-round border-2 btn-icon">
              <i class="icon-spinner11"></i>
            </a>
            <div class="ml-3">
              <h5 class="font-weight-semibold mb-0">"""),_display_(/*52.54*/messages("application_date")),format.raw/*52.82*/("""</h5>
              <span class="text-muted">application date</span>
            </div>
          </div>

          <div class="d-flex align-items-center mb-3 mb-md-0 ">
            <a href="#" class="btn bg-transparent border-indigo-400 text-indigo-400 rounded-round border-2 btn-icon">
              <i class="icon-alarm-add"></i>
            </a>
            <div class="ml-3">
              <h5 class="font-weight-semibold mb-0">"""),_display_(/*62.54*/messages("task_total_count")),format.raw/*62.82*/("""</h5>
              <span class="text-muted">total tasks</span>
            </div>
          </div>
          <div class="d-flex align-items-center mb-3 mb-md-0 ">
            
            <div class="ml-3">
              
            </div>
          </div>

        </div>

        <div class="table-responsive">
          <table class="table text-nowrap">
            <thead>
              <tr>
                <th style="width: 50px">Status</th>
                <th style="width: 300px;">Responsible User</th>
                <th>Description</th>
              </tr>
            </thead>
            <tbody>
              <tr class="table-active table-border-double">
                <td colspan="3">Future Tasks</td>
                <td></td>
              </tr>

              <tr>
                <td class="text-center">
                  <span class="badge badge-mark border-success mr-1"></span>
                  <div class="font-size-sm text-muted line-height-1">pending</div>
                </td>
                <td>
                  <div class="d-flex align-items-center">
                    <div class="mr-3">
                      <a href="#" class="btn bg-teal-400 rounded-round btn-icon btn-sm">
                        <span class="letter-icon"></span>
                      </a>
                    </div>
                    <div>
                      <a href="#" class="text-default font-weight-semibold letter-icon-title">Annabelle Doney</a>
                    </div>
                  </div>
                </td>
                <td>
                  <a href="#" class="text-default">
                    <div class="font-weight-semibold">Workaround for OS X selects printing bug</div>
                  </a>
                </td>
                <td></td>
              </tr>

              <tr class="table-active table-border-double">
                <td colspan="3">Resolved tasks</td>
                <td class="text-right">
                </td>
              </tr>

              <tr>
                <td class="text-center">
                  <i class="icon-checkmark3 text-success"></i>
                  <div class="font-size-sm text-muted line-height-1">resolved</div>
                </td>
                <td>
                  <div class="d-flex align-items-center">
                    <div class="mr-3">
                      <a href="#" class="btn bg-success-400 rounded-round btn-icon btn-sm">
                        <span class="letter-icon"></span>
                      </a>
                      
                    </div>
                    <div>
                      <a href="#" class="text-default font-weight-semibold letter-icon-title">Alan Macedo</a>
                    </div>
                  </div>
                </td>
                <td>
                  <a href="#" class="text-default">
                    <div class="font-weight-semibold">Workaround for OS X selects printing bug</div>
                  </a>
                </td>
                <td class="text-center"></td>
              </tr>

              <tr class="table-active table-border-double">
                <td colspan="3">Closed tasks</td>
                <td class="text-right"></td>
              </tr>

              <tr>
                <td class="text-center">
                  <i class="icon-cross2 text-danger-400"></i>
                  <div class="text-muted font-size-sm">Closed</div>
                </td>
                <td>
                  <div class="d-flex align-items-center">
                    <div class="mr-3">
                      <a href="#">
                        <img src=""""),_display_(/*161.36*/routes/*161.42*/.Assets.versioned("images/placeholders/placeholder.jpg")),format.raw/*161.98*/("""" class="rounded-circle" width="32" height="32" alt="">
                      </a>
                    </div>
                    <div>
                      <a href="#" class="text-default font-weight-semibold">Mitchell Sitkin</a>
                      
                    </div>
                  </div>
                </td>
                <td>
                  <a href="#" class="text-default">
                    <div class="font-weight-semibold">Workaround for OS X selects printing bug</div>
                  </a>
                </td>
                <td class="text-center"></td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      <!-- /support tickets -->
    </div>
  
  </div>

""")))}),format.raw/*186.2*/("""
"""))
      }
    }
  }

  def render(topic:String,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(topic)(messages)

  def f:((String) => (Messages) => play.twirl.api.HtmlFormat.Appendable) = (topic) => (messages) => apply(topic)(messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-11-12T11:26:29.732
                  SOURCE: C:/Users/zeeyi/Desktop/Fall-2020/Scala Codes/internship/app/views/index.scala.html
                  HASH: fcf03b35df0a59891d54934b46b26a268a067e38
                  MATRIX: 738->1|876->46|903->48|922->59|960->60|988->62|1134->182|1148->188|1224->244|1314->308|1354->328|1388->345|1425->346|1454->349|2001->869|2044->891|2158->978|2210->1009|2239->1010|3101->1845|3150->1873|3611->2307|3660->2335|7339->5986|7355->5992|7433->6048|8203->6787
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|29->5|29->5|29->5|30->6|30->6|32->8|32->8|33->9|48->24|48->24|51->27|51->27|51->27|76->52|76->52|86->62|86->62|185->161|185->161|185->161|210->186
                  -- GENERATED --
              */
          