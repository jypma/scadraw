package com.npmjs.twojs

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}
import org.scalajs.dom.raw.HTMLElement
import org.scalajs.dom.raw.Element

@JSImport("two.js", "default")
@js.native
class Two() extends js.Object {
  def this(params: ConstructorParams) = this()
  def appendTo(domElement: Element): this.type = js.native
  def makeCircle(x: Double, y: Double, radius: Double): Circle = js.native
  def makeRectangle(x: Double, y: Double, width: Double, height: Double): Rectangle = js.native
  def update(): this.type = js.native
}

object Two {

}
