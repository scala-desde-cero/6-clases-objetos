package app1

class Alumno (nombre: String, apellidos:String)
{
  var edad:Int=0
  def visualizar():Unit =
    {
      println(nombre)
      println(apellidos)
      println(edad)
    }
}



object Principal
{
  def main(arg: Array[String]): Unit = {
    var alumno1=new Alumno(nombre = "Patricia", apellidos = "Carrasco")
    println(alumno1)
    println(alumno1.toString)
    alumno1.edad=10
    alumno1.visualizar()
  }
}

