package nl.ypmania.scadraw.data

case class Drawing(shapes: Map[String, Shape], dimensions: Map[String, Dimension]) {

}

case class ShapeRef(id: String)
case class DimensionRef(id: String)

sealed trait Anchor
case object Origin extends Anchor
case class Aligned(target: ShapeRef, alignment: Alignment, space: DimensionRef) extends Anchor

sealed trait Alignment
/** The object's top is aligned to the anchor's top, and space is horizontal between the elements */
case object HorizontalTop extends Alignment
/** The object's vertical center is aligned to the anchor's vertical center, and space is horizontal between the elements */
case object HorizontalCenter extends Alignment
/** The object's bottom is aligned to the anchor's bottom, and space is horizontal between the elements */
case object HorizontalBottom extends Alignment

/** The object's left is aligned to the anchor's left, and space is vertical between the elements */
case object VerticalLeft extends Alignment
/** The object's center is aligned to the anchor's center, and space is vertical between the elements */
case object VerticalCenter extends Alignment
/** The object's right is aligned to the anchor's right, and space is vertical between the elements */
case object VerticalRight extends Alignment

// Shapes always come from SVG:
// - Scaling style (direct / 9-point)
// - Designate one element as "scadraw:color" and set color there (e.g. screen blending mode)
// - Designate one element as "scadraw:text" and put text body there (no text attributes for now)
// - (optional) Designate one rectangle as "scadraw:bounds"
// - We put them into our main SVG by id

case class ShapeStyle(
  /** URIs are mapped to SVG definition, colors, drawing etc. directly in the UI for now */
  uri: String
)

case class Shape(
  id: String,
  style: ShapeStyle,
  anchor: Anchor,
  /** Overrides the scadraw:color on the base SVG (ignored if there is none) */
  color: Option[String],
  /** Can be empty, if there's no text */
  text: String
)

case class Dimension(millimeters: Double)

// TODO: Custom drawn shapes by 9-grid scaling
// TODO: Connector attachment for custom drawn shapes. Use https://github.com/thelonious/kld-intersections to calculate outer points of shape.
// TODO: Experiment with text on connector (at start, at end, and in the middle). How to position?
// TODO: Do connectors auto-half circle when intersecting?
sealed trait ConnectorStyle
/** Direct straight line */
case object Straight extends ConnectorStyle
/** Leaves at 45 degree towards destination, and then a spline control point in the exact middle */
case object Curved extends ConnectorStyle
