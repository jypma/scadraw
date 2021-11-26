package com.npmjs.twojs

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("two.js", "Utils.Collection")
@js.native
class Collection[T] () extends js.Array[T]
