package ch.epfl.data
package vector
package deep

import pardis.deep.scalalib._
import pardis.types.PardisTypeImplicits._
import pardis.deep.scalalib.collection._

trait VectorDSL extends VectorComponent with IntComponent with SeqComponent {
  case class Println(x: Rep[Any]) extends FunctionDef[Unit](None, "println", List(List(x))) {
    override def curriedConstructor = (copy _)
  }
  def println(x: Rep[Any]): Rep[Unit] = Println(x)
}

trait VectorDSLOpt extends VectorDSL with VectorOpt with IntPartialEvaluation
