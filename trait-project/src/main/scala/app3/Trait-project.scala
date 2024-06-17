package app3

trait Trait1
{
  def Imprimir(nombre:String): Unit
  def Imprimir1:Unit={
    println("Metodo creado en el trait")
  }

}
trait  Trait2
{
  def Imprimir2:Unit={
     println("Metodo creado en el trait2")
  }
}

class Persona extends Trait1 with Trait2
{
  def Imprimir(nombre: String): Unit = {
    println(nombre.toUpperCase())
  }
  override def Imprimir1: Unit = {
    println("Estoy en la clase")
  }
  override def Imprimir2: Unit = {
    println("estoy en la clase 2")
  }
}

object Principal {
  def main(args: Array[String]): Unit = {
    var persona1=new Persona()
    persona1.Imprimir(nombre = "Patricia")
    persona1.Imprimir1
    persona1.Imprimir2
  }
}