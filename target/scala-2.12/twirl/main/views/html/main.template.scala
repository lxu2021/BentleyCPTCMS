
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(head:Html)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>"""),_display_(/*9.17*/title),format.raw/*9.22*/("""</title>

        <!-- Global stylesheets -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700,900" rel="stylesheet" type="text/css">
        <link href=""""),_display_(/*13.22*/routes/*13.28*/.Assets.versioned("css/icons/icomoon/styles.min.css")),format.raw/*13.81*/("""" rel="stylesheet" type="text/css">
        <link href=""""),_display_(/*14.22*/routes/*14.28*/.Assets.versioned("css/bootstrap.min.css")),format.raw/*14.70*/("""" rel="stylesheet" type="text/css">
        <link href=""""),_display_(/*15.22*/routes/*15.28*/.Assets.versioned("css/bootstrap_limitless.min.css")),format.raw/*15.80*/("""" rel="stylesheet" type="text/css">
        <link href=""""),_display_(/*16.22*/routes/*16.28*/.Assets.versioned("css/layout.min.css")),format.raw/*16.67*/("""" rel="stylesheet" type="text/css">
        <link href=""""),_display_(/*17.22*/routes/*17.28*/.Assets.versioned("css/components.min.css")),format.raw/*17.71*/("""" rel="stylesheet" type="text/css">
        <link href=""""),_display_(/*18.22*/routes/*18.28*/.Assets.versioned("css/colors.min.css")),format.raw/*18.67*/("""" rel="stylesheet" type="text/css">
        <!-- /global stylesheets -->

        <!-- Core JS files -->
        <script src=""""),_display_(/*22.23*/routes/*22.29*/.Assets.versioned("js/main/jquery.min.js")),format.raw/*22.71*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*23.23*/routes/*23.29*/.Assets.versioned("js/main/bootstrap.bundle.min.js")),format.raw/*23.81*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*24.23*/routes/*24.29*/.Assets.versioned("js/plugins/loaders/blockui.min.js")),format.raw/*24.83*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*25.23*/routes/*25.29*/.Assets.versioned("js/plugins/ui/ripple.min.js")),format.raw/*25.77*/("""" type="text/javascript"></script>
        <!-- /core JS files -->

        <!-- Theme JS files -->
        <script src=""""),_display_(/*29.23*/routes/*29.29*/.Assets.versioned("js/plugins/visualization/d3/d3.min.js")),format.raw/*29.87*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*30.23*/routes/*30.29*/.Assets.versioned("js/plugins/visualization/d3/d3_tooltip.js")),format.raw/*30.91*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*31.23*/routes/*31.29*/.Assets.versioned("js/plugins/forms/styling/switchery.min.js")),format.raw/*31.91*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*32.23*/routes/*32.29*/.Assets.versioned("js/plugins/ui/moment/moment.min.js")),format.raw/*32.84*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*33.23*/routes/*33.29*/.Assets.versioned("js/plugins/pickers/daterangepicker.js")),format.raw/*33.87*/("""" type="text/javascript"></script>

		<script src=""""),_display_(/*35.17*/routes/*35.23*/.Assets.versioned("js/demo_pages/form_wizard.js")),format.raw/*35.72*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*36.23*/routes/*36.29*/.Assets.versioned("js/demo_pages/widgets_stats.js")),format.raw/*36.80*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*37.23*/routes/*37.29*/.Assets.versioned("js/app.js")),format.raw/*37.59*/(""""></script>
        <script src=""""),_display_(/*38.23*/routes/*38.29*/.Assets.versioned("js/demo_pages/dashboard.js")),format.raw/*38.76*/(""" """),format.raw/*38.77*/("""type="text/javascript""></script>
        <script src=""""),_display_(/*39.23*/routes/*39.29*/.Assets.versioned("js/demo_charts/pages/dashboard/light/streamgraph.js")),format.raw/*39.101*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*40.23*/routes/*40.29*/.Assets.versioned("js/demo_charts/pages/dashboard/light/sparklines.js")),format.raw/*40.100*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*41.23*/routes/*41.29*/.Assets.versioned("js/demo_charts/pages/dashboard/light/lines.js")),format.raw/*41.95*/("""" type="text/javascript"></script>  
        <script src=""""),_display_(/*42.23*/routes/*42.29*/.Assets.versioned("js/demo_charts/pages/dashboard/light/areas.js")),format.raw/*42.95*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*43.23*/routes/*43.29*/.Assets.versioned("js/demo_charts/pages/dashboard/light/donus.js")),format.raw/*43.95*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*44.23*/routes/*44.29*/.Assets.versioned("js/demo_charts/pages/dashboard/light/bars.js")),format.raw/*44.94*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*45.23*/routes/*45.29*/.Assets.versioned("js/demo_charts/pages/dashboard/light/progress.js")),format.raw/*45.98*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*46.23*/routes/*46.29*/.Assets.versioned("js/demo_charts/pages/dashboard/light/heatmaps.js")),format.raw/*46.98*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*47.23*/routes/*47.29*/.Assets.versioned("js/demo_charts/pages/dashboard/light/pies.js")),format.raw/*47.94*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*48.23*/routes/*48.29*/.Assets.versioned("js/demo_charts/pages/dashboard/light/bullets.js")),format.raw/*48.97*/("""" type="text/javascript"></script>
        <!-- /theme JS files -->
        
        
    </head>
    
    <body >

        <!-- Main navbar -->
        <div class="navbar navbar-expand-md navbar-light navbar-static">

            <!-- Header with logos -->
            <div class="navbar-header navbar-dark d-none d-md-flex align-items-md-center">
                <div class="navbar-brand navbar-brand-md">
                    <a href="/" class="d-inline-block">
                        <img src=""""),_display_(/*63.36*/routes/*63.42*/.Assets.versioned("images/logo_light.png")),format.raw/*63.84*/("""" alt="">
                    </a>
                </div>
                
                <div class="navbar-brand navbar-brand-xs">
                    <a href="/" class="d-inline-block">
                        <img src=""""),_display_(/*69.36*/routes/*69.42*/.Assets.versioned("images/logo_icon_light.png")),format.raw/*69.89*/("""" alt="">
                    </a>
                </div>
            </div>
            <!-- /header with logos -->
        

            <!-- Mobile controls -->
            <div class="d-flex flex-1 d-md-none">
                <div class="navbar-brand mr-auto">
                    <a href="/" class="d-inline-block">
                        <img src=""""),_display_(/*80.36*/routes/*80.42*/.Assets.versioned("images/logo_dark.png")),format.raw/*80.83*/("""" alt="" width="300" height="95">
                    </a>
                </div>  

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-mobile">
                    <i class="icon-tree5"></i>
                </button>

                <button class="navbar-toggler sidebar-mobile-main-toggle" type="button">
                    <i class="icon-paragraph-justify3"></i>
                </button>
            </div>
            <!-- /mobile controls -->


            <!-- Navbar content -->
            <div class="collapse navbar-collapse" id="navbar-mobile">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a href="#" class="navbar-nav-link sidebar-control sidebar-main-toggle d-none d-md-block">
                            <i class="icon-paragraph-justify3"></i>
                        </a>
                    </li>
                </ul>

                <ul class="navbar-nav">

                    <li class="nav-item dropdown dropdown-user">
                        """),_display_(/*108.26*/head),format.raw/*108.30*/("""

                        """),format.raw/*110.25*/("""<div class="dropdown-menu dropdown-menu-right">
                            <a href="#" class="dropdown-item"><i class="icon-switch2"></i>Logout</a>
                        </div>
                    </li>
                </ul>
            </div>
            <!-- /navbar content -->
            
        </div>
        <!-- /main navbar -->

                        
        <!-- Page content -->
        <div class="page-content">

            <!-- Main sidebar -->
            <div class="sidebar sidebar-dark sidebar-main sidebar-expand-md">

                <!-- Sidebar mobile toggler -->
                <div class="sidebar-mobile-toggler text-center">
                    <a href="#" class="sidebar-mobile-main-toggle">
                        <i class="icon-arrow-left8"></i>
                    </a>
                    Navigation
                    <a href="#" class="sidebar-mobile-expand">
                        <i class="icon-screen-full"></i>
                        <i class="icon-screen-normal"></i>
                    </a>
                </div>
                <!-- /sidebar mobile toggler -->


                <!-- Sidebar content -->
                <div class="sidebar-content">
                    
                    <!-- User menu -->
                    <div class="sidebar-user-material">
                        <div class="sidebar-user-material-body">
                            <div class="card-body text-center">
                                <a href="#">
                                    <img src=""""),_display_(/*150.48*/routes/*150.54*/.Assets.versioned("images/placeholders/placeholder.jpg")),format.raw/*150.110*/("""" class="img-fluid rounded-circle shadow-1 mb-3" width="80" height="80" alt="">
                                </a>
                                <h6 class="mb-0 text-white text-shadow-dark">Lincoln Matra</h6>
                                <span class="font-size-sm text-white text-shadow-dark">Boston, MA</span>
                            </div>
                                                        
                        </div>
                    </div>
                    <!-- /user menu -->
                    
                    <!-- Main navigation -->
                    <div class="card card-sidebar-mobile">
                        <ul class="nav nav-sidebar" data-nav-type="accordion">

                            <li class="nav-item-header"><div class="text-uppercase font-size-xs line-height-xs">Navigation</div> <i class="icon-menu" title="Layout options"></i></li>
                            <li class="nav-item">
                                <a href="/" class="nav-link active">
                                    <i class="icon-home4"></i>
                                    <span>
                                        Dashboard
                                    </span>
                                </a>
                            </li>
                            <li class="nav-item nav-item-submenu">
                                <a href="/process" class="nav-link"><i class="icon-stack2"></i> <span>Process</span></a>
                            </li>
                            <li class="nav-item nav-item-submenu">
                                <a href="/department" class="nav-link"><i class="icon-page-break2"></i> <span>Department</span></a>
                            </li>
                            <li class="nav-item nav-item-submenu">
                                <a href="/form" class="nav-link"><i class="icon-indent-decrease2"></i> <span>Form</span></a>
                            </li>                                
                        </ul>
                    </div>
                    <!-- /main navigation -->
                </div>
                <!-- /sidebar content -->                
            </div>
            <!-- /main sidebar -->
            <!-- Main content -->
            <div class="content-wrapper">

                <!-- Page header -->
                <div class="page-header">
                    <div class="page-header-content header-elements-md-inline">
                        <div class="page-title d-flex">
                            <h4><i class="icon-arrow-left52 mr-2"></i> <span class="font-weight-semibold">Home</span> - Dashboard</h4>
                            <a href="#" class="header-elements-toggle text-default d-md-none"><i class="icon-more"></i></a>
                        </div>
                    </div>
                </div>
                <!-- /page header -->


                <!-- Content area -->
                """),_display_(/*205.18*/content),format.raw/*205.25*/("""

                """),format.raw/*207.17*/("""<!-- /content area -->


                <!-- Footer -->
                <div class="navbar navbar-expand-lg navbar-light">
                    <div class="text-center d-lg-none w-100">
                        <button type="button" class="navbar-toggler dropdown-toggle" data-toggle="collapse" data-target="#navbar-footer">
                            <i class="icon-unfold mr-2"></i>
                            Footer
                        </button>
                    </div>

                    <div class="navbar-collapse collapse" id="navbar-footer">
                        <span class="navbar-text">
                            &copy; 2020. <a href="#">Bentley Internship Application</a> by <p>Catherine X., Segunfunmi O., Ellis Y., Lares X</p>
                        </span>
                    </div>
                </div>
                <!-- /footer -->

            </div>
            <!-- /main content -->

        </div>
        <!-- /page content -->
                        
    </body>

</html>
"""))
      }
    }
  }

  def render(title:String,head:Html,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(head)(content)

  def f:((String) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (head) => (content) => apply(title)(head)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-11-12T11:26:29.766
                  SOURCE: C:/Users/zeeyi/Desktop/Fall-2020/Scala Codes/internship/app/views/main.scala.html
                  HASH: 8d340a813240f1f284938ff5b3b6401744bc2a86
                  MATRIX: 738->1|873->43|900->44|1174->292|1199->297|1419->490|1434->496|1508->549|1592->606|1607->612|1670->654|1754->711|1769->717|1842->769|1926->826|1941->832|2001->871|2085->928|2100->934|2164->977|2248->1034|2263->1040|2323->1079|2477->1206|2492->1212|2555->1254|2639->1311|2654->1317|2727->1369|2811->1426|2826->1432|2901->1486|2985->1543|3000->1549|3069->1597|3218->1719|3233->1725|3312->1783|3396->1840|3411->1846|3494->1908|3578->1965|3593->1971|3676->2033|3760->2090|3775->2096|3851->2151|3935->2208|3950->2214|4029->2272|4108->2324|4123->2330|4193->2379|4277->2436|4292->2442|4364->2493|4448->2550|4463->2556|4514->2586|4575->2620|4590->2626|4658->2673|4687->2674|4770->2730|4785->2736|4879->2808|4963->2865|4978->2871|5071->2942|5155->2999|5170->3005|5257->3071|5343->3130|5358->3136|5445->3202|5529->3259|5544->3265|5631->3331|5715->3388|5730->3394|5816->3459|5900->3516|5915->3522|6005->3591|6089->3648|6104->3654|6194->3723|6278->3780|6293->3786|6379->3851|6463->3908|6478->3914|6567->3982|7093->4481|7108->4487|7171->4529|7423->4754|7438->4760|7506->4807|7889->5163|7904->5169|7966->5210|9081->6297|9107->6301|9162->6327|10733->7870|10749->7876|10828->7932|13820->10896|13849->10903|13896->10921
                  LINES: 21->1|26->2|27->3|33->9|33->9|37->13|37->13|37->13|38->14|38->14|38->14|39->15|39->15|39->15|40->16|40->16|40->16|41->17|41->17|41->17|42->18|42->18|42->18|46->22|46->22|46->22|47->23|47->23|47->23|48->24|48->24|48->24|49->25|49->25|49->25|53->29|53->29|53->29|54->30|54->30|54->30|55->31|55->31|55->31|56->32|56->32|56->32|57->33|57->33|57->33|59->35|59->35|59->35|60->36|60->36|60->36|61->37|61->37|61->37|62->38|62->38|62->38|62->38|63->39|63->39|63->39|64->40|64->40|64->40|65->41|65->41|65->41|66->42|66->42|66->42|67->43|67->43|67->43|68->44|68->44|68->44|69->45|69->45|69->45|70->46|70->46|70->46|71->47|71->47|71->47|72->48|72->48|72->48|87->63|87->63|87->63|93->69|93->69|93->69|104->80|104->80|104->80|132->108|132->108|134->110|174->150|174->150|174->150|229->205|229->205|231->207
                  -- GENERATED --
              */
          