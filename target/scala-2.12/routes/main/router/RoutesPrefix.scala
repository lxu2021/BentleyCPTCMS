// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/zeeyi/Desktop/Fall-2020/Scala Codes/internship/conf/routes
// @DATE:Thu Nov 12 11:26:29 EST 2020


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
