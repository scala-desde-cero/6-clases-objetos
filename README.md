# 6-clases-objetos
1. [Intro a clases y objetos en scala](#schema1)
2. [Herencia en Scala](#schema2)
3. [Herencia Múltiple en Scala con Traits](#schema3)


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

<hr>

<a name="schema2"></a>

## 2. Herencia en Scala

La herencia es un mecanismo en programación orientada a objetos que permite a una clase derivar de otra clase, heredando sus campos y métodos. Scala soporta herencia simple, lo que significa que una clase puede heredar de una única superclase.

### **Clase Base y Clase Derivada**
- **Clase Base**: También conocida como superclase o clase padre. Define los campos y métodos que pueden ser heredados por otras clases.
- **Clase Derivada**: También conocida como subclase o clase hija. Hereda los campos y métodos de la clase base y puede añadir nuevos campos y métodos o sobrescribir los existentes.
### **Definición de Herencia**
```scala
class Animal(val nombre: String) {
  def hacerSonido(): Unit = {
    println("El animal hace un sonido")
  }
}

class Perro(nombre: String) extends Animal(nombre) {
  override def hacerSonido(): Unit = {
    println("El perro ladra")
  }
}
```
- `class Perro(nombre: String) extends Animal(nombre)`: La clase `Perro` hereda de la clase `Animal`.
- `override def hacerSonido(): Unit`: La clase `Perro` sobrescribe el método hacerSonido de la clase `Animal`.
### **Uso de la Herencia**
```scala
val miPerro = new Perro("Rex")
miPerro.hacerSonido()  // Output: El perro ladra
```
- Se crea una instancia de `Perro`, que tiene acceso a los métodos y campos de `Animal`.
### **Sobrescritura de Métodos**
En Scala, para sobrescribir un método de la clase base, se utiliza la palabra clave `override`.

```scala
class Animal {
  def hacerSonido(): Unit = {
    println("El animal hace un sonido")
  }
}

class Gato extends Animal {
  override def hacerSonido(): Unit = {
    println("El gato maúlla")
  }
}
```
### **Constructores en Herencia**
Cuando una clase derivada hereda de una clase base, debe llamar al constructor de la clase base. Esto se hace típicamente pasando los parámetros necesarios al constructor de la clase base.

```scala
class Animal(val nombre: String)

class Caballo(nombre: String, val velocidad: Int) extends Animal(nombre)
```
### **Clases Abstractas**
Scala permite definir clases abstractas que no pueden ser instanciadas directamente. Una clase abstracta puede contener métodos sin implementación, que deben ser implementados por las clases derivadas.

```scala
abstract class Vehiculo {
  def mover(): Unit
}

class Coche extends Vehiculo {
  def mover(): Unit = {
    println("El coche se mueve")
  }
}
```
### **Traits**
[Ejemplo con Traits](./trait-project/)

Los traits en Scala son similares a las interfaces en otros lenguajes, pero pueden contener implementación de métodos. Una clase puede extender múltiples traits, lo que permite una forma de herencia múltiple.

```scala
trait Volador {
  def volar(): Unit = {
    println("Volar")
  }
}

class Pajaro extends Animal("Pájaro") with Volador
```
### **Resumen**
- **Herencia**: Permite que una clase (subclase) herede de otra clase (superclase).
- **extends**: Palabra clave usada para indicar que una clase hereda de otra.
- **override**: Palabra clave para sobrescribir métodos de la clase base.
- **Clases Abstractas**: Clases que no pueden ser instanciadas y pueden contener métodos sin implementación.
- **Traits**: Similar a interfaces, pueden contener implementación y permiten herencia múltiple.

<hr>

<a name="schema3"></a>

## 3. Herencia Múltiple en Scala con Traits


Los traits en Scala son similares a las interfaces en otros lenguajes de programación, pero con la capacidad de contener implementaciones de métodos. Esto permite a los traits proporcionar un comportamiento reutilizable que puede ser mezclado en diferentes clases.

### **Ejemplo de Implementación**
Consideremos un ejemplo en el que tenemos dos traits `Autenticable` y `Autorizable`, y una clase `SistemaSeguridad` que hereda de ambos.

#### **Trait Autenticable**
```scala
// Archivo: src/main/scala/miapp/Autenticable.scala

package miapp

trait Autenticable {
  def autenticar(usuario: String, contrasena: String): Boolean = {
    // Lógica de autenticación
    usuario == "admin" && contrasena == "password"
  }
}
```
#### **Trait Autorizable**
```scala
// Archivo: src/main/scala/miapp/Autorizable.scala

package miapp

trait Autorizable {
  def autorizar(usuario: String, recurso: String): Boolean = {
    // Lógica de autorización
    usuario == "admin" && recurso == "confidencial"
  }
}
```

#### **Clase SistemaSeguridad**
```scala
// Archivo: src/main/scala/miapp/SistemaSeguridad.scala

package miapp

class SistemaSeguridad extends Autenticable with Autorizable {
  def verificarAcceso(usuario: String, contrasena: String, recurso: String): Boolean = {
    if (autenticar(usuario, contrasena) && autorizar(usuario, recurso)) {
      println(s"Acceso concedido a $usuario para $recurso")
      true
    } else {
      println(s"Acceso denegado a $usuario para $recurso")
      false
    }
  }
}
```
#### **Objeto Principal para Ejecutar el Código**
```scala
// Archivo: src/main/scala/miapp/Main.scala

package miapp

object Main extends App {
  val sistema = new SistemaSeguridad

  sistema.verificarAcceso("admin", "password", "confidencial")  // Debería conceder acceso
  sistema.verificarAcceso("user", "password", "confidencial")   // Debería denegar acceso
}
```
### **Explicación**
1. **Traits Definidos**: `Autenticable` y `Autorizable` son traits que definen métodos con lógica específica. Pueden ser mezclados en cualquier clase.

2.  **Clase que Mezcla Traits**: `SistemaSeguridad` es una clase que hereda de ambos traits utilizando la sintaxis `extends` y `with`. Esto permite que `SistemaSeguridad` tenga acceso a los métodos `autenticar` y `autorizar`.

3.  **Verificación de Acceso**: En la clase `SistemaSeguridad`, se define un método `verificarAcceso` que utiliza los métodos proporcionados por los traits para realizar una verificación completa de acceso.

4.  **Ejecución**: El objeto `Main` contiene el método `main` que se ejecuta al iniciar la aplicación. Crea una instancia de `SistemaSeguridad` y llama al método `verificarAcceso` con diferentes parámetros para demostrar el comportamiento.

### **Ventajas de Usar Traits para Herencia Múltiple**
- **Reutilización de Código**: Traits permiten reutilizar la lógica en múltiples clases sin duplicar el código.
- **Composición sobre Herencia**: En lugar de crear una jerarquía de clases complicada, puedes componer comportamiento de forma más flexible.
- **Separación de Responsabilidades**: Traits pueden ayudar a dividir el comportamiento en componentes más pequeños y manejables.
### **Consideraciones**
- **Conflictos de Métodos**: Si dos traits tienen métodos con el mismo nombre, necesitarás resolver el conflicto especificando qué implementación utilizarás.
- **Orden de Mezcla**: El orden en que mezclas los traits puede afectar el comportamiento del programa debido a la linealización de la herencia.
### **Resolución de Conflictos**
Si dos traits tienen métodos con el mismo nombre, puedes resolver el conflicto sobrescribiendo el método en la clase que mezcla los traits y especificando qué implementación utilizar:

```scala
trait A {
  def mensaje(): String = "Mensaje de A"
}

trait B {
  def mensaje(): String = "Mensaje de B"
}

class C extends A with B {
  override def mensaje(): String = super[B].mensaje()
}
```
En este ejemplo, `C` sobrescribe el método `mensaje` y especifica que debe usar la implementación de `B`.
### **Resumen**
Los traits en Scala son una herramienta poderosa para implementar herencia múltiple, permitiendo una composición flexible y reutilización de código, lo que facilita la creación de sistemas más modulares y mantenibles.