package com.npmjs.twojs

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait BoundingClientRect {

  var bottom: Double

  var height: Double

  var left: Double

  var right: Double

  var top: Double

  var width: Double
}
object BoundingClientRect {

  def apply(bottom: Double, height: Double, left: Double, right: Double, top: Double, width: Double): BoundingClientRect = {
    val __obj = js.Dynamic.literal(bottom = bottom.asInstanceOf[js.Any], height = height.asInstanceOf[js.Any], left = left.asInstanceOf[js.Any], right = right.asInstanceOf[js.Any], top = top.asInstanceOf[js.Any], width = width.asInstanceOf[js.Any])
    __obj.asInstanceOf[BoundingClientRect]
  }
}
