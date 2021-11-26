package com.npmjs.twojs

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("two.js", "Anchor")
@js.native
class Anchor protected () extends Vector {
  def this(x: Double, y: Double, lx: Double, ly: Double, rx: Double, ry: Double, command: String) = this()
  def this(x: Double, y: Double, lx: Double, ly: Double, rx: Double, ry: Double, command: Commands) = this()

  var command: Commands /*| String*/ = js.native

  var controls: js.UndefOr[Anchor.Controls] = js.native

  def ignore(): this.type = js.native

  def listen(): this.type = js.native
}

object Anchor {

  trait Controls  {
    var left: Vector
    var right: Vector
  }
  object Controls {
     def apply(left: Vector, right: Vector): Controls = {
      val __obj = js.Dynamic.literal(left = left.asInstanceOf[js.Any], right = right.asInstanceOf[js.Any])
      __obj.asInstanceOf[Controls]
    }
  }

  @JSImport("two.js", "Anchor")
  @js.native
  val ^ : js.Any = js.native

  /* static member */
  def AppendCurveProperties(): Unit = ^.asInstanceOf[js.Dynamic].applyDynamic("AppendCurveProperties")().asInstanceOf[Unit]
}
