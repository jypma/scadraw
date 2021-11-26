package com.npmjs.twojs

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
sealed trait Types extends js.Any

@JSImport("two.js", "Types")
@js.native
object Types extends js.Object {

  @JSBracketAccess
  def apply(value: Double): js.UndefOr[Types with Double] = js.native

  @js.native
  sealed trait canvas extends Types

  /* 2 */ val canvas: Types.canvas with Double = js.native

  @js.native
  sealed trait svg extends Types
  /* 0 */ val svg: Types.svg with Double = js.native

  @js.native
  sealed trait webgl extends Types
  /* 1 */ val webgl: Types.webgl with Double = js.native
}
