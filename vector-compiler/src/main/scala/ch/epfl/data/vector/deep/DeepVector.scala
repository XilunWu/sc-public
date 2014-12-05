/* Generated by Purgatory 2014 */

package ch.epfl.data.vector.deep

import ch.epfl.data.pardis
import pardis.ir._
import pardis.types.PardisTypeImplicits._
import pardis.effects._
import pardis.deep._
import pardis.deep.scalalib._
import pardis.deep.scalalib.collection._
import pardis.deep.scalalib.io._
trait VectorOps extends Base {
  // Type representation
  case object VectorType extends TypeRep[Vector] {
    def rebuild(newArguments: TypeRep[_]*): TypeRep[_] = VectorType
    val name = "Vector"
    val typeArguments = Nil

    val typeTag = scala.reflect.runtime.universe.typeTag[Vector]
  }
  implicit val typeVector = VectorType
  implicit class VectorRep(self: Rep[Vector]) {
    def +(v2: Rep[Vector]): Rep[Vector] = vector$plus(self, v2)
    def *(v2: Rep[Vector]): Rep[Int] = vector$times(self, v2)
    def data: Rep[Seq[Int]] = vector_Field_Data(self)
  }
  object Vector {
    def zero(n: Rep[Int]): Rep[Vector] = vectorZeroObject(n)
    def apply(data: Rep[Seq[Int]]): Rep[Vector] = vectorApplyObject(data)
  }
  // constructors
  def __newVector(data: Rep[Seq[Int]]): Rep[Vector] = vectorNew(data)
  // case classes
  case class VectorNew(data: Rep[Seq[Int]]) extends ConstructorDef[Vector](List(), "Vector", List(List(data))) {
    override def curriedConstructor = (copy _)
  }

  case class Vector$plus(self: Rep[Vector], v2: Rep[Vector]) extends FunctionDef[Vector](Some(self), "+", List(List(v2))) {
    override def curriedConstructor = (copy _).curried
    override def isPure = true

    override def partialEvaluate(children: Any*): Vector = {
      val self = children(0).asInstanceOf[Vector]
      val v2 = children(1).asInstanceOf[Vector]
      self.$plus(v2)
    }
    override def partialEvaluable: Boolean = true

  }

  case class Vector$times(self: Rep[Vector], v2: Rep[Vector]) extends FunctionDef[Int](Some(self), "*", List(List(v2))) {
    override def curriedConstructor = (copy _).curried
    override def isPure = true

    override def partialEvaluate(children: Any*): Int = {
      val self = children(0).asInstanceOf[Vector]
      val v2 = children(1).asInstanceOf[Vector]
      self.$times(v2)
    }
    override def partialEvaluable: Boolean = true

  }

  case class Vector_Field_Data(self: Rep[Vector]) extends FieldDef[Seq[Int]](self, "data") {
    override def curriedConstructor = (copy _)
    override def isPure = true

    override def partialEvaluate(children: Any*): Seq[Int] = {
      val self = children(0).asInstanceOf[Vector]
      self.data
    }
    override def partialEvaluable: Boolean = true

  }

  case class VectorZeroObject(n: Rep[Int]) extends FunctionDef[Vector](None, "Vector.zero", List(List(n))) {
    override def curriedConstructor = (copy _)
    override def isPure = true

    override def partialEvaluate(children: Any*): Vector = {
      val n = children(0).asInstanceOf[Int]
      ch.epfl.data.vector.shallow.Vector.zero(n)
    }
    override def partialEvaluable: Boolean = true

  }

  case class VectorApplyObject(data: Rep[Seq[Int]]) extends FunctionDef[Vector](None, "Vector.apply", List(List(data))) {
    override def curriedConstructor = (copy _)
    override def isPure = true

    override def partialEvaluate(children: Any*): Vector = {
      val data = children(0).asInstanceOf[Seq[Int]]
      ch.epfl.data.vector.shallow.Vector.apply(data)
    }
    override def partialEvaluable: Boolean = true

  }

  // method definitions
  def vectorNew(data: Rep[Seq[Int]]): Rep[Vector] = VectorNew(data)
  def vector$plus(self: Rep[Vector], v2: Rep[Vector]): Rep[Vector] = Vector$plus(self, v2)
  def vector$times(self: Rep[Vector], v2: Rep[Vector]): Rep[Int] = Vector$times(self, v2)
  def vector_Field_Data(self: Rep[Vector]): Rep[Seq[Int]] = Vector_Field_Data(self)
  def vectorZeroObject(n: Rep[Int]): Rep[Vector] = VectorZeroObject(n)
  def vectorApplyObject(data: Rep[Seq[Int]]): Rep[Vector] = VectorApplyObject(data)
  type Vector = ch.epfl.data.vector.shallow.Vector
}
trait VectorImplicits extends VectorOps {
  // Add implicit conversions here!
}
trait VectorPartialEvaluation extends VectorComponent with BasePartialEvaluation {
  // Immutable field inlining 
  override def vector_Field_Data(self: Rep[Vector]): Rep[Seq[Int]] = self match {
    case Def(node: VectorNew) => node.data
    case _                    => super.vector_Field_Data(self)
  }

  // Mutable field inlining 
  // Pure function partial evaluation
}
trait VectorComponent extends VectorOps with VectorImplicits {}
