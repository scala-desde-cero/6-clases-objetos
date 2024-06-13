# 6-clases-objetos
1. [Intro a clases y objetos en scala](#schema1)


<hr>

<a name="schema1"></a>

## 1. Intro a clases y objetos en scala

### **Clases en Scala**
Las clases en Scala son plantillas para crear objetos (instancias). Una clase define un nuevo tipo de dato, especificando sus atributos (campos) y comportamientos (métodos).

#### **Definición de Clase**
```scala
class Persona(val nombre: String, val edad: Int) {
  def saludar(): Unit = {
    println(s"Hola, mi nombre es $nombre y tengo $edad años.")
  }
}
```
- **Constructor**: El constructor primario se define en la misma línea que el nombre de la clase. En este caso, `nombre` y `edad` son parámetros del constructor.
- **Campos**: Los parámetros `nombre` y `edad` son accesibles como campos debido a la palabra clave val.
- **Métodos**: saludar es un método de la clase Persona.
#### **Creación de Instancias**
```scala
val persona = new Persona("Juan", 30)
persona.saludar()  // Output: Hola, mi nombre es Juan y tengo 30 años.
```
- **Instanciación**: Se utiliza la palabra clave new para crear una instancia de la clase Persona.


### **Objetos en Scala**
Los objetos en Scala son instancias únicas (singleton) de clases. No puedes crear múltiples instancias de un objeto. Los objetos se usan para definir métodos y valores que pertenecen a la clase en sí, en lugar de a instancias individuales de la clase.

#### **Definición de Objeto**
```scala
object MiObjeto {
  def decirHola(): Unit = {
    println("Hola desde el objeto.")
  }
}
```
- **Singleton**: `MiObjeto` es una instancia única. No puedes crear más instancias de `MiObjeto`.
- **Métodos**: decirHola es un método que pertenece al objeto `MiObjeto`.
#### **Uso del Objeto**
```scala
MiObjeto.decirHola()  // Output: Hola desde el objeto.
```
- **Acceso Directo**: Se accede a los métodos y valores del objeto directamente mediante el nombre del objeto.
#### **Objetos de Compañía (Companion Objects)**
Un objeto de compañía es un objeto que comparte el mismo nombre que una clase y se define en el mismo archivo. Los objetos de compañía pueden acceder a los miembros privados de la clase y viceversa.

##### **Ejemplo de Objeto de Compañía**
```scala
class Persona(val nombre: String, val edad: Int)

object Persona {
  def crearBebe(nombre: String): Persona = {
    new Persona(nombre, 0)
  }
}
```
- Clase `Persona`: Define la estructura y comportamiento de las instancias.
- Objeto `Persona`: Define métodos de fábrica y otros métodos estáticos.
##### **Uso del Objeto de Compañía**
```scala
val bebe = Persona.crearBebe("Pequeño Juan")
println(bebe.nombre)  // Output: Pequeño Juan
println(bebe.edad)    // Output: 0
```
#### **Resumen**
- **Clases**: Plantillas para crear objetos, con atributos y métodos. Se instancian con `new`.
- **Objetos**: Instancias únicas (singleton) que pueden contener métodos y valores estáticos. No requieren new.
- **Objetos de Compañía**: Objetos que comparten el nombre con una clase y pueden acceder a los miembros privados de la clase.