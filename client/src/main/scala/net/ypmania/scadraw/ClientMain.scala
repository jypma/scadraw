package net.ypmania.scadraw

import org.scalajs.dom
import com.raquo.laminar.api.L._

object ClientMain {
  def main(args: Array[String]): Unit = {
    println("Hello world!")



    val appElement = div(
      h1("Hello"),
      "Current time is:",
      b("12:00"),
      SvgFixture.fixture
    )

    renderOnDomContentLoaded(dom.document.getElementById("drawing"), appElement)
  }
}
