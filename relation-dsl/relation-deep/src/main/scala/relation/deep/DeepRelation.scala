/* Generated by Purgatory 2014-2016 */

package relation.deep

import ch.epfl.data.sc.pardis
import pardis.ir._
import pardis.types.PardisTypeImplicits._
import pardis.effects._
import pardis.deep._
import pardis.deep.scalalib._
import pardis.deep.scalalib.collection._
import pardis.deep.scalalib.io._

import ch.epfl.data.sc.pardis.quasi.anf.{ BaseExt, BaseExtIR }
import ch.epfl.data.sc.pardis.quasi.TypeParameters.MaybeParamTag

trait ListOps extends Base  {  
  // Type representation
  val ListType = ListIRs.ListType
  type ListType[A] = ListIRs.ListType[A]
  implicit def typeList[A: TypeRep]: TypeRep[List[A]] = ListType(implicitly[TypeRep[A]])
  implicit class ListRep[A](self : Rep[List[A]])(implicit typeA : TypeRep[A]) {

  }
  object List {
     def apply[A](elems : Rep[A]*)(implicit typeA : TypeRep[A]) : Rep[List[A]] = listApplyObject[A](elems:_*)(typeA)
  }
  // constructors
   def __newList[A]()(implicit typeA : TypeRep[A]) : Rep[List[A]] = listNew[A]()(typeA)
  // IR defs
  val ListNew = ListIRs.ListNew
  type ListNew[A] = ListIRs.ListNew[A]
  val ListApplyObject = ListIRs.ListApplyObject
  type ListApplyObject[A] = ListIRs.ListApplyObject[A]
  // method definitions
   def listNew[A]()(implicit typeA : TypeRep[A]) : Rep[List[A]] = ListNew[A]()
   def listApplyObject[A](elems : Rep[A]*)(implicit typeA : TypeRep[A]) : Rep[List[A]] = {
    val elemsOutput = __liftSeq(elems.toSeq)
    ListApplyObject[A](elemsOutput)
  }
  type List[A] = scala.collection.immutable.List[A]
}
object ListIRs extends Base {
  // Type representation
  case class ListType[A](typeA: TypeRep[A]) extends TypeRep[List[A]] {
    def rebuild(newArguments: TypeRep[_]*): TypeRep[_] = ListType(newArguments(0).asInstanceOf[TypeRep[_]])
    val name = s"List[${typeA.name}]"
    val typeArguments = List(typeA)
  }
      implicit def typeList[A: TypeRep]: TypeRep[List[A]] = ListType(implicitly[TypeRep[A]])
  // case classes
  case class ListNew[A]()(implicit val typeA : TypeRep[A]) extends ConstructorDef[List[A]](List(typeA), "List", List(List())){
    override def curriedConstructor = (x: Any) => copy[A]()
  }

  case class ListApplyObject[A](elemsOutput : Rep[Seq[A]])(implicit val typeA : TypeRep[A]) extends FunctionDef[List[A]](None, "List.apply", List(List(__varArg(elemsOutput)))){
    override def curriedConstructor = (copy[A] _)
  }

  type List[A] = scala.collection.immutable.List[A]
}
trait ListImplicits extends ListOps { 
  // Add implicit conversions here!
}
trait ListComponent extends ListOps with ListImplicits {  }

trait ListPartialEvaluation extends ListComponent with BasePartialEvaluation {  
  // Immutable field inlining 

  // Mutable field inlining 
  // Pure function partial evaluation
}


// QUASI GENERATED CODE:

object ListQuasiNodes extends BaseExtIR {
  import ListIRs._
  // case classes
  case class ListNewExt[A]()(implicit val paramA : MaybeParamTag[A]) extends FunctionDef[ListNew[A], List[A]] {
    override def nodeUnapply(t: ListNew[A]): Option[Product] = (ListNew.unapply(t): Option[Product]) map { r =>
      paramA.define(t.typeA)
      r }
  }
  case class ListApplyObjectExt[A](elemsOutput : Rep[Seq[A]])(implicit val paramA : MaybeParamTag[A]) extends FunctionDef[ListApplyObject[A], List[A]] {
    override def nodeUnapply(t: ListApplyObject[A]): Option[Product] = (ListApplyObject.unapply(t): Option[Product]) map { r =>
      paramA.define(t.typeA)
      r }
  }
  type List[A] = scala.collection.immutable.List[A]
}

trait ListExtOps extends BaseExt {
  
  import ListQuasiNodes._
  import ch.epfl.data.sc.pardis.quasi.OverloadHackObj._
  implicit class ListRep[A](self : Rep[List[A]])(implicit paramA : MaybeParamTag[A]) {
  }
  object List {
     def apply[A](elems : Rep[A]*)(implicit paramA : MaybeParamTag[A]) : Rep[List[A]] = listApplyObject[A](elems:_*)(paramA)
  }
  // constructors
   def __newList[A]()(implicit paramA : MaybeParamTag[A]) : Rep[List[A]] = listNew[A]()(paramA)
  
  // method definitions
   def listNew[A]()(implicit paramA : MaybeParamTag[A]) : Rep[List[A]] = ListNewExt[A]()
   def listApplyObject[A](elems : Rep[A]*)(implicit paramA : MaybeParamTag[A]) : Rep[List[A]] = {
      val elemsOutput = __liftSeq(elems.toSeq)
      ListApplyObjectExt[A](elemsOutput)
    }
  type List[A] = scala.collection.immutable.List[A]
}

trait RowOps extends Base with ListOps with SchemaOps {  
  // Type representation
  val RowType = RowIRs.RowType
  implicit val typeRow: TypeRep[Row] = RowType
  implicit class RowRep(self : Rep[Row]) {
     def getField(fieldName : Rep[String]) : Rep[String] = rowGetField(self, fieldName)
     def values : Rep[List[String]] = row_Field_Values(self)
     def schema : Rep[Schema] = row_Field_Schema(self)
  }
  object Row {

  }
  // constructors
   def __newRow(schema : Rep[Schema], values : Rep[List[String]]) : Rep[Row] = rowNew(schema, values)
  // IR defs
  val RowNew = RowIRs.RowNew
  type RowNew = RowIRs.RowNew
  val RowGetField = RowIRs.RowGetField
  type RowGetField = RowIRs.RowGetField
  val Row_Field_Values = RowIRs.Row_Field_Values
  type Row_Field_Values = RowIRs.Row_Field_Values
  val Row_Field_Schema = RowIRs.Row_Field_Schema
  type Row_Field_Schema = RowIRs.Row_Field_Schema
  // method definitions
   def rowNew(schema : Rep[Schema], values : Rep[List[String]]) : Rep[Row] = RowNew(schema, values)
   def rowGetField(self : Rep[Row], fieldName : Rep[String]) : Rep[String] = RowGetField(self, fieldName)
   def row_Field_Values(self : Rep[Row]) : Rep[List[String]] = Row_Field_Values(self)
   def row_Field_Schema(self : Rep[Row]) : Rep[Schema] = Row_Field_Schema(self)
  type Row = relation.shallow.Row
}
object RowIRs extends Base {
  import ListIRs._
  import SchemaIRs._
  // Type representation
  case object RowType extends TypeRep[Row] {
    def rebuild(newArguments: TypeRep[_]*): TypeRep[_] = RowType
    val name = "Row"
    val typeArguments = Nil
  }
      implicit val typeRow: TypeRep[Row] = RowType
  // case classes
  case class RowNew(schema : Rep[Schema], values : Rep[List[String]]) extends ConstructorDef[Row](List(), "Row", List(List(schema,values))){
    override def curriedConstructor = (copy _).curried
  }

  case class RowGetField(self : Rep[Row], fieldName : Rep[String]) extends FunctionDef[String](Some(self), "getField", List(List(fieldName))){
    override def curriedConstructor = (copy _).curried
  }

  case class Row_Field_Values(self : Rep[Row]) extends FieldDef[List[String]](self, "values"){
    override def curriedConstructor = (copy _)
    override def isPure = true

    override def partiallyEvaluate(children: Any*): List[String] = {
      val self = children(0).asInstanceOf[Row]
      self.values
    }
    override def partiallyEvaluable: Boolean = true

  }

  case class Row_Field_Schema(self : Rep[Row]) extends FieldDef[Schema](self, "schema"){
    override def curriedConstructor = (copy _)
    override def isPure = true

    override def partiallyEvaluate(children: Any*): Schema = {
      val self = children(0).asInstanceOf[Row]
      self.schema
    }
    override def partiallyEvaluable: Boolean = true

  }

  type Row = relation.shallow.Row
}
trait RowImplicits extends RowOps { 
  // Add implicit conversions here!
}
trait RowComponent extends RowOps with RowImplicits {  }

trait RowPartialEvaluation extends RowComponent with BasePartialEvaluation {  
  // Immutable field inlining 
  override def row_Field_Values(self : Rep[Row]) : Rep[List[String]] = self match {
    case Def(node: RowNew) => node.values
    case _ => super.row_Field_Values(self)
  }
  override def row_Field_Schema(self : Rep[Row]) : Rep[Schema] = self match {
    case Def(node: RowNew) => node.schema
    case _ => super.row_Field_Schema(self)
  }

  // Mutable field inlining 
  // Pure function partial evaluation
}


// QUASI GENERATED CODE:

object RowQuasiNodes extends BaseExtIR {
  import RowIRs._
  import ListQuasiNodes._
  import SchemaQuasiNodes._
  // case classes
  case class RowNewExt(schema : Rep[Schema], values : Rep[List[String]]) extends FunctionDef[RowNew, Row] {
    override def nodeUnapply(t: RowNew): Option[Product] = (RowNew.unapply(t): Option[Product]) map { r =>
      r }
  }
  case class RowGetFieldExt(self : Rep[Row], fieldName : Rep[String]) extends FunctionDef[RowGetField, String] {
    override def nodeUnapply(t: RowGetField): Option[Product] = (RowGetField.unapply(t): Option[Product]) map { r =>
      r }
  }
  case class Row_Field_ValuesExt(self : Rep[Row]) extends FunctionDef[Row_Field_Values, List[String]] {
    override def nodeUnapply(t: Row_Field_Values): Option[Product] = (Row_Field_Values.unapply(t): Option[Product]) map { r =>
      r }
  }
  case class Row_Field_SchemaExt(self : Rep[Row]) extends FunctionDef[Row_Field_Schema, Schema] {
    override def nodeUnapply(t: Row_Field_Schema): Option[Product] = (Row_Field_Schema.unapply(t): Option[Product]) map { r =>
      r }
  }
  type Row = relation.shallow.Row
}

trait RowExtOps extends BaseExt with ListExtOps with SchemaExtOps {
  
  import RowQuasiNodes._
  import ch.epfl.data.sc.pardis.quasi.OverloadHackObj._
  import ListQuasiNodes._
  import SchemaQuasiNodes._
  implicit class RowRep(self : Rep[Row]) {
     def getField(fieldName : Rep[String]) : Rep[String] = rowGetField(self, fieldName)
     def values : Rep[List[String]] = row_Field_Values(self)
     def schema : Rep[Schema] = row_Field_Schema(self)
  }
  object Row {
  }
  // constructors
   def __newRow(schema : Rep[Schema], values : Rep[List[String]]) : Rep[Row] = rowNew(schema, values)
  
  // method definitions
   def rowNew(schema : Rep[Schema], values : Rep[List[String]]) : Rep[Row] = RowNewExt(schema, values)
   def rowGetField(self : Rep[Row], fieldName : Rep[String]) : Rep[String] = RowGetFieldExt(self, fieldName)
   def row_Field_Values(self : Rep[Row]) : Rep[List[String]] = Row_Field_ValuesExt(self)
   def row_Field_Schema(self : Rep[Row]) : Rep[Schema] = Row_Field_SchemaExt(self)
  type Row = relation.shallow.Row
}

trait SchemaOps extends Base with ListOps {  
  // Type representation
  val SchemaType = SchemaIRs.SchemaType
  implicit val typeSchema: TypeRep[Schema] = SchemaType
  implicit class SchemaRep(self : Rep[Schema]) {
     def columns : Rep[List[String]] = schema_Field_Columns(self)
  }
  object Schema {
     def apply(columns : Rep[String]*) : Rep[Schema] = schemaApplyObject(columns:_*)
  }
  // constructors
   def __newSchema(columns : Rep[List[String]]) : Rep[Schema] = schemaNew(columns)
  // IR defs
  val SchemaNew = SchemaIRs.SchemaNew
  type SchemaNew = SchemaIRs.SchemaNew
  val Schema_Field_Columns = SchemaIRs.Schema_Field_Columns
  type Schema_Field_Columns = SchemaIRs.Schema_Field_Columns
  val SchemaApplyObject = SchemaIRs.SchemaApplyObject
  type SchemaApplyObject = SchemaIRs.SchemaApplyObject
  // method definitions
   def schemaNew(columns : Rep[List[String]]) : Rep[Schema] = SchemaNew(columns)
   def schema_Field_Columns(self : Rep[Schema]) : Rep[List[String]] = Schema_Field_Columns(self)
   def schemaApplyObject(columns : Rep[String]*) : Rep[Schema] = {
    val columnsOutput = __liftSeq(columns.toSeq)
    SchemaApplyObject(columnsOutput)
  }
  type Schema = relation.shallow.Schema
}
object SchemaIRs extends Base {
  import ListIRs._
  // Type representation
  case object SchemaType extends TypeRep[Schema] {
    def rebuild(newArguments: TypeRep[_]*): TypeRep[_] = SchemaType
    val name = "Schema"
    val typeArguments = Nil
  }
      implicit val typeSchema: TypeRep[Schema] = SchemaType
  // case classes
  case class SchemaNew(columns : Rep[List[String]]) extends ConstructorDef[Schema](List(), "Schema", List(List(columns))){
    override def curriedConstructor = (copy _)
  }

  case class Schema_Field_Columns(self : Rep[Schema]) extends FieldDef[List[String]](self, "columns"){
    override def curriedConstructor = (copy _)
    override def isPure = true

    override def partiallyEvaluate(children: Any*): List[String] = {
      val self = children(0).asInstanceOf[Schema]
      self.columns
    }
    override def partiallyEvaluable: Boolean = true

  }

  case class SchemaApplyObject(columnsOutput : Rep[Seq[String]]) extends FunctionDef[Schema](None, "Schema.apply", List(List(__varArg(columnsOutput)))){
    override def curriedConstructor = (copy _)
  }

  type Schema = relation.shallow.Schema
}
trait SchemaImplicits extends SchemaOps { 
  // Add implicit conversions here!
}
trait SchemaComponent extends SchemaOps with SchemaImplicits {  }

trait SchemaPartialEvaluation extends SchemaComponent with BasePartialEvaluation {  
  // Immutable field inlining 
  override def schema_Field_Columns(self : Rep[Schema]) : Rep[List[String]] = self match {
    case Def(node: SchemaNew) => node.columns
    case _ => super.schema_Field_Columns(self)
  }

  // Mutable field inlining 
  // Pure function partial evaluation
}


// QUASI GENERATED CODE:

object SchemaQuasiNodes extends BaseExtIR {
  import SchemaIRs._
  import ListQuasiNodes._
  // case classes
  case class SchemaNewExt(columns : Rep[List[String]]) extends FunctionDef[SchemaNew, Schema] {
    override def nodeUnapply(t: SchemaNew): Option[Product] = (SchemaNew.unapply(t): Option[Product]) map { r =>
      r }
  }
  case class Schema_Field_ColumnsExt(self : Rep[Schema]) extends FunctionDef[Schema_Field_Columns, List[String]] {
    override def nodeUnapply(t: Schema_Field_Columns): Option[Product] = (Schema_Field_Columns.unapply(t): Option[Product]) map { r =>
      r }
  }
  case class SchemaApplyObjectExt(columnsOutput : Rep[Seq[String]]) extends FunctionDef[SchemaApplyObject, Schema] {
    override def nodeUnapply(t: SchemaApplyObject): Option[Product] = (SchemaApplyObject.unapply(t): Option[Product]) map { r =>
      r }
  }
  type Schema = relation.shallow.Schema
}

trait SchemaExtOps extends BaseExt with ListExtOps {
  
  import SchemaQuasiNodes._
  import ch.epfl.data.sc.pardis.quasi.OverloadHackObj._
  import ListQuasiNodes._
  implicit class SchemaRep(self : Rep[Schema]) {
     def columns : Rep[List[String]] = schema_Field_Columns(self)
  }
  object Schema {
     def apply(columns : Rep[String]*) : Rep[Schema] = schemaApplyObject(columns:_*)
  }
  // constructors
   def __newSchema(columns : Rep[List[String]]) : Rep[Schema] = schemaNew(columns)
  
  // method definitions
   def schemaNew(columns : Rep[List[String]]) : Rep[Schema] = SchemaNewExt(columns)
   def schema_Field_Columns(self : Rep[Schema]) : Rep[List[String]] = Schema_Field_ColumnsExt(self)
   def schemaApplyObject(columns : Rep[String]*) : Rep[Schema] = {
      val columnsOutput = __liftSeq(columns.toSeq)
      SchemaApplyObjectExt(columnsOutput)
    }
  type Schema = relation.shallow.Schema
}

trait RelationOps extends Base with RowOps with SchemaOps with ListOps {  
  // Type representation
  val RelationType = RelationIRs.RelationType
  implicit val typeRelation: TypeRep[Relation] = RelationType
  implicit class RelationRep(self : Rep[Relation]) {
     def select(p : Rep[(Row => Boolean)]) : Rep[Relation] = relationSelect(self, p)
     def project(schema : Rep[Schema]) : Rep[Relation] = relationProject(self, schema)
     def join(o : Rep[Relation], cond : Rep[((Row,Row) => Boolean)]) : Rep[Relation] = relationJoin(self, o, cond)
     def aggregate(key : Rep[Schema], agg : Rep[((Double,Row) => Double)]) : Rep[Relation] = relationAggregate(self, key, agg)
     def print : Rep[Unit] = relationPrint(self)
     def underlying : Rep[List[Row]] = relation_Field_Underlying(self)
  }
  object Relation {
     def scan(filename : Rep[String], schema : Rep[Schema], delimiter : Rep[String]) : Rep[Relation] = relationScanObject(filename, schema, delimiter)
  }
  // constructors
   def __newRelation(underlying : Rep[List[Row]]) : Rep[Relation] = relationNew(underlying)
  // IR defs
  val RelationNew = RelationIRs.RelationNew
  type RelationNew = RelationIRs.RelationNew
  val RelationSelect = RelationIRs.RelationSelect
  type RelationSelect = RelationIRs.RelationSelect
  val RelationProject = RelationIRs.RelationProject
  type RelationProject = RelationIRs.RelationProject
  val RelationJoin = RelationIRs.RelationJoin
  type RelationJoin = RelationIRs.RelationJoin
  val RelationAggregate = RelationIRs.RelationAggregate
  type RelationAggregate = RelationIRs.RelationAggregate
  val RelationPrint = RelationIRs.RelationPrint
  type RelationPrint = RelationIRs.RelationPrint
  val Relation_Field_Underlying = RelationIRs.Relation_Field_Underlying
  type Relation_Field_Underlying = RelationIRs.Relation_Field_Underlying
  val RelationScanObject = RelationIRs.RelationScanObject
  type RelationScanObject = RelationIRs.RelationScanObject
  // method definitions
   def relationNew(underlying : Rep[List[Row]]) : Rep[Relation] = RelationNew(underlying)
   def relationSelect(self : Rep[Relation], p : Rep[((Row) => Boolean)]) : Rep[Relation] = RelationSelect(self, p)
   def relationProject(self : Rep[Relation], schema : Rep[Schema]) : Rep[Relation] = RelationProject(self, schema)
   def relationJoin(self : Rep[Relation], o : Rep[Relation], cond : Rep[((Row,Row) => Boolean)]) : Rep[Relation] = RelationJoin(self, o, cond)
   def relationAggregate(self : Rep[Relation], key : Rep[Schema], agg : Rep[((Double,Row) => Double)]) : Rep[Relation] = RelationAggregate(self, key, agg)
   def relationPrint(self : Rep[Relation]) : Rep[Unit] = RelationPrint(self)
   def relation_Field_Underlying(self : Rep[Relation]) : Rep[List[Row]] = Relation_Field_Underlying(self)
   def relationScanObject(filename : Rep[String], schema : Rep[Schema], delimiter : Rep[String]) : Rep[Relation] = RelationScanObject(filename, schema, delimiter)
  type Relation = relation.shallow.Relation
}
object RelationIRs extends Base {
  import RowIRs._
  import SchemaIRs._
  import ListIRs._
  // Type representation
  case object RelationType extends TypeRep[Relation] {
    def rebuild(newArguments: TypeRep[_]*): TypeRep[_] = RelationType
    val name = "Relation"
    val typeArguments = Nil
  }
      implicit val typeRelation: TypeRep[Relation] = RelationType
  // case classes
  case class RelationNew(underlying : Rep[List[Row]]) extends ConstructorDef[Relation](List(), "Relation", List(List(underlying))){
    override def curriedConstructor = (copy _)
  }

  case class RelationSelect(self : Rep[Relation], p : Rep[((Row) => Boolean)]) extends FunctionDef[Relation](Some(self), "select", List(List(p))){
    override def curriedConstructor = (copy _).curried
  }

  case class RelationProject(self : Rep[Relation], schema : Rep[Schema]) extends FunctionDef[Relation](Some(self), "project", List(List(schema))){
    override def curriedConstructor = (copy _).curried
  }

  case class RelationJoin(self : Rep[Relation], o : Rep[Relation], cond : Rep[((Row,Row) => Boolean)]) extends FunctionDef[Relation](Some(self), "join", List(List(o,cond))){
    override def curriedConstructor = (copy _).curried
  }

  case class RelationAggregate(self : Rep[Relation], key : Rep[Schema], agg : Rep[((Double,Row) => Double)]) extends FunctionDef[Relation](Some(self), "aggregate", List(List(key,agg))){
    override def curriedConstructor = (copy _).curried
  }

  case class RelationPrint(self : Rep[Relation]) extends FunctionDef[Unit](Some(self), "print", List()){
    override def curriedConstructor = (copy _)
  }

  case class Relation_Field_Underlying(self : Rep[Relation]) extends FieldDef[List[Row]](self, "underlying"){
    override def curriedConstructor = (copy _)
    override def isPure = true

    override def partiallyEvaluate(children: Any*): List[Row] = {
      val self = children(0).asInstanceOf[Relation]
      self.underlying
    }
    override def partiallyEvaluable: Boolean = true

  }

  case class RelationScanObject(filename : Rep[String], schema : Rep[Schema], delimiter : Rep[String]) extends FunctionDef[Relation](None, "Relation.scan", List(List(filename,schema,delimiter))){
    override def curriedConstructor = (copy _).curried
  }

  type Relation = relation.shallow.Relation
}
trait RelationImplicits extends RelationOps { 
  // Add implicit conversions here!
}
trait RelationComponent extends RelationOps with RelationImplicits {  }

trait RelationPartialEvaluation extends RelationComponent with BasePartialEvaluation {  
  // Immutable field inlining 
  override def relation_Field_Underlying(self : Rep[Relation]) : Rep[List[Row]] = self match {
    case Def(node: RelationNew) => node.underlying
    case _ => super.relation_Field_Underlying(self)
  }

  // Mutable field inlining 
  // Pure function partial evaluation
}


// QUASI GENERATED CODE:

object RelationQuasiNodes extends BaseExtIR {
  import RelationIRs._
  import RowQuasiNodes._
  import SchemaQuasiNodes._
  import ListQuasiNodes._
  // case classes
  case class RelationNewExt(underlying : Rep[List[Row]]) extends FunctionDef[RelationNew, Relation] {
    override def nodeUnapply(t: RelationNew): Option[Product] = (RelationNew.unapply(t): Option[Product]) map { r =>
      r }
  }
  case class RelationSelectExt(self : Rep[Relation], p : Rep[((Row) => Boolean)]) extends FunctionDef[RelationSelect, Relation] {
    override def nodeUnapply(t: RelationSelect): Option[Product] = (RelationSelect.unapply(t): Option[Product]) map { r =>
      r }
  }
  case class RelationProjectExt(self : Rep[Relation], schema : Rep[Schema]) extends FunctionDef[RelationProject, Relation] {
    override def nodeUnapply(t: RelationProject): Option[Product] = (RelationProject.unapply(t): Option[Product]) map { r =>
      r }
  }
  case class RelationJoinExt(self : Rep[Relation], o : Rep[Relation], cond : Rep[((Row,Row) => Boolean)]) extends FunctionDef[RelationJoin, Relation] {
    override def nodeUnapply(t: RelationJoin): Option[Product] = (RelationJoin.unapply(t): Option[Product]) map { r =>
      r }
  }
  case class RelationAggregateExt(self : Rep[Relation], key : Rep[Schema], agg : Rep[((Double,Row) => Double)]) extends FunctionDef[RelationAggregate, Relation] {
    override def nodeUnapply(t: RelationAggregate): Option[Product] = (RelationAggregate.unapply(t): Option[Product]) map { r =>
      r }
  }
  case class RelationPrintExt(self : Rep[Relation]) extends FunctionDef[RelationPrint, Unit] {
    override def nodeUnapply(t: RelationPrint): Option[Product] = (RelationPrint.unapply(t): Option[Product]) map { r =>
      r }
  }
  case class Relation_Field_UnderlyingExt(self : Rep[Relation]) extends FunctionDef[Relation_Field_Underlying, List[Row]] {
    override def nodeUnapply(t: Relation_Field_Underlying): Option[Product] = (Relation_Field_Underlying.unapply(t): Option[Product]) map { r =>
      r }
  }
  case class RelationScanObjectExt(filename : Rep[String], schema : Rep[Schema], delimiter : Rep[String]) extends FunctionDef[RelationScanObject, Relation] {
    override def nodeUnapply(t: RelationScanObject): Option[Product] = (RelationScanObject.unapply(t): Option[Product]) map { r =>
      r }
  }
  type Relation = relation.shallow.Relation
}

trait RelationExtOps extends BaseExt with RowExtOps with SchemaExtOps with ListExtOps {
  
  import RelationQuasiNodes._
  import ch.epfl.data.sc.pardis.quasi.OverloadHackObj._
  import RowQuasiNodes._
  import SchemaQuasiNodes._
  import ListQuasiNodes._
  implicit class RelationRep(self : Rep[Relation]) {
     def select(p : Rep[(Row => Boolean)]) : Rep[Relation] = relationSelect(self, p)
     def project(schema : Rep[Schema]) : Rep[Relation] = relationProject(self, schema)
     def join(o : Rep[Relation], cond : Rep[((Row,Row) => Boolean)]) : Rep[Relation] = relationJoin(self, o, cond)
     def aggregate(key : Rep[Schema], agg : Rep[((Double,Row) => Double)]) : Rep[Relation] = relationAggregate(self, key, agg)
     def print : Rep[Unit] = relationPrint(self)
     def underlying : Rep[List[Row]] = relation_Field_Underlying(self)
  }
  object Relation {
     def scan(filename : Rep[String], schema : Rep[Schema], delimiter : Rep[String]) : Rep[Relation] = relationScanObject(filename, schema, delimiter)
  }
  // constructors
   def __newRelation(underlying : Rep[List[Row]]) : Rep[Relation] = relationNew(underlying)
  
  // method definitions
   def relationNew(underlying : Rep[List[Row]]) : Rep[Relation] = RelationNewExt(underlying)
   def relationSelect(self : Rep[Relation], p : Rep[((Row) => Boolean)]) : Rep[Relation] = RelationSelectExt(self, p)
   def relationProject(self : Rep[Relation], schema : Rep[Schema]) : Rep[Relation] = RelationProjectExt(self, schema)
   def relationJoin(self : Rep[Relation], o : Rep[Relation], cond : Rep[((Row,Row) => Boolean)]) : Rep[Relation] = RelationJoinExt(self, o, cond)
   def relationAggregate(self : Rep[Relation], key : Rep[Schema], agg : Rep[((Double,Row) => Double)]) : Rep[Relation] = RelationAggregateExt(self, key, agg)
   def relationPrint(self : Rep[Relation]) : Rep[Unit] = RelationPrintExt(self)
   def relation_Field_Underlying(self : Rep[Relation]) : Rep[List[Row]] = Relation_Field_UnderlyingExt(self)
   def relationScanObject(filename : Rep[String], schema : Rep[Schema], delimiter : Rep[String]) : Rep[Relation] = RelationScanObjectExt(filename, schema, delimiter)
  type Relation = relation.shallow.Relation
}


