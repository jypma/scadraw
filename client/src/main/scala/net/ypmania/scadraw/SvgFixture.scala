package net.ypmania.scadraw

import com.raquo.laminar.api.L.svg._ // get svg keys without the svg prefix
import com.raquo.laminar.api._ // get `L` and standard implicits like `textToNode`
import com.raquo.laminar.api.L.{Observer}
import org.scalajs.dom
import com.raquo.domtypes.jsdom.defs.events.TypedTargetMouseEvent

object SvgFixture {
  val clickObserver = Observer[dom.MouseEvent](onNext = ev => dom.console.log(ev.screenX))

  val dragBus = new L.EventBus[TypedTargetMouseEvent[dom.Element]]

  case class DragState(dragging: Boolean = false, dragX: Double = 0, dragY: Double = 0, x: Double = 0, y: Double = 0)
  val handleDrag = dragBus.events.foldLeft(DragState()) {
    case (dragState, event) if event.`type` == "mousedown" =>
      dragState.copy(dragging = true, dragX = event.screenX - dragState.x, dragY = event.screenY - dragState.y)
    case (dragState, event) if event.`type` == "mousemove" && dragState.dragging =>
      dragState.copy(dragging = true, x = (event.screenX - dragState.dragX), y = (event.screenY - dragState.dragY))
    case (dragState, event) if event.`type` == "mouseup" =>
      dragState.copy(dragging = false)
    case (dragState, _) =>
      dragState
  }

  val fixture = svg(
    L.onMouseDown --> dragBus,
    L.onMouseMove --> dragBus,
    L.onMouseUp --> dragBus,

    height := "800",
    width := "500",
    viewBox <-- handleDrag.map(s => s"${-s.x} ${-s.y} ${-s.x + 1000} ${-s.y + 1000}"),
    preserveAspectRatio := "xMinYMin slice",
    style := "border: 1px solid #cccccc;",
    rect(
      width := "100",
      height := "100",
      style := "fill:#FFFBB4; stroke-width:3; stroke:rgb(0,0,0)"
    )
  )
}
