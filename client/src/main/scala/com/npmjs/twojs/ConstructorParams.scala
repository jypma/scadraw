package com.npmjs.twojs

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait ConstructorParams extends js.Object {

  var autostart: js.UndefOr[Boolean] = js.undefined

  var fullscreen: js.UndefOr[Boolean] = js.undefined

  var height: js.UndefOr[Double] = js.undefined

  var ratio: js.UndefOr[Double] = js.undefined

  var `type`: js.UndefOr[Types] = js.undefined

  var width: js.UndefOr[Double] = js.undefined
}

object ConstructorParams {

  def apply(): ConstructorParams = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[ConstructorParams]
  }
}
