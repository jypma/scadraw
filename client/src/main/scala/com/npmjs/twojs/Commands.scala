package com.npmjs.twojs

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
sealed trait Commands extends js.Any

@JSImport("two.js", "Commands")
@js.native
object Commands extends js.Object {

  @JSBracketAccess
  def apply(value: Double): js.UndefOr[Commands with Double] = js.native

  @js.native
  sealed trait arc
       extends Commands
  /* 3 */ val arc: Commands.arc with Double = js.native

  @js.native
  sealed trait close
       extends Commands
  /* 4 */ val close: Commands.close with Double = js.native

  @js.native
  sealed trait curve
       extends Commands
  /* 2 */ val curve: Commands.curve with Double = js.native

  @js.native
  sealed trait line
       extends Commands
  /* 1 */ val line: Commands.line with Double = js.native

  @js.native
  sealed trait move
       extends Commands
  /* 0 */ val move: Commands.move with Double = js.native
}
