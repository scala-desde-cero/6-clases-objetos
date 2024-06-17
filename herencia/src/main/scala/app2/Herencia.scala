package app2

class Vehiculo {
  var cv:Int=0
  var bastidor:String=""
  def visualizarDatos():Unit=
    {
      println(s"Tiene $cv caballos y el número de bastidor es $bastidor")
    }
}

class Coche extends Vehiculo
{
  var ruedas:Int=0
  def verDatosCoche:Unit ={
    println(s"El vehículo tiene $ruedas ruedas")
  }
}

object Principal{
  def main(args:Array[String]):Unit ={
    var coche1=new Coche()
    coche1.ruedas=4
    coche1.cv=100
    coche1.bastidor="Malo"
    coche1.visualizarDatos()
    coche1.verDatosCoche
  }
}
