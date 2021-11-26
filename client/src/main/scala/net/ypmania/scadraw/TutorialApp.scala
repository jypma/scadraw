package nl.ypmania.scadraw

import org.scalajs.dom
import com.npmjs.twojs.Two
import com.npmjs.twojs.ConstructorParams

object TutorialApp {
  def main(args: Array[String]): Unit = {
    println("Hello world!")

    val elem = dom.document.getElementById("drawing")
    val params = ConstructorParams()
    params.width = 200
    params.height = 200
    val two = new Two(params)
    two.appendTo(elem)

    var circle = two.makeCircle(72, 100, 50)
    var rect = two.makeRectangle(213, 100, 100, 100)
    circle.fill = "#FF8000"
    circle.stroke = "orangered"
    circle.linewidth = 5

    rect.fill = "rgb(0, 200, 255)"
    rect.opacity = 0.75
    rect.noStroke()

    two.update()
  }
}
