# 6-clases-objetos
1. [Intro a clases y objetos en scala](#schema1)
2. [Herencia en Scala](#schema2)
3. [Herencia Múltiple en Scala con Traits](#schema3)
4. [Modificadores de Acceso: private, public, protected](#schema4)
5. [Constructores](#schema5)
6. [Singleton Objects](#schema6)


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


<hr>

<a name="schema4"></a>

## 4. Modificadores de Acceso: private, public, protected


### **Public**
El modificador de acceso predeterminado en Scala es `public`. Si no especificas ningún modificador de acceso, el miembro será público y accesible desde cualquier parte del programa.

```scala
class Persona {
  var nombre: String = "John"
  def saludar(): Unit = {
    println(s"Hola, mi nombre es $nombre")
  }
}
```
En este ejemplo, tanto nombre como saludar son públicos y pueden ser accedidos desde cualquier parte del programa.

### **Private**
Un miembro `private` solo es accesible dentro de la clase o el trait donde está definido. Esto es útil para encapsular detalles de implementación y proteger la integridad del estado interno de un objeto.

```scala
class Persona {
  private var nombre: String = "John"
  def saludar(): Unit = {
    println(s"Hola, mi nombre es $nombre")
  }
  private def cambiarNombre(nuevoNombre: String): Unit = {
    nombre = nuevoNombre
  }
}
```
En este ejemplo, `nombre` y `cambiarNombre` son privados y no pueden ser accedidos desde fuera de la clase Persona.

### **Private[scope]**
Scala permite especificar el alcance de la visibilidad privada mediante `private[scope]`, donde `scope` puede ser un paquete o una clase. Esto permite un control más fino sobre quién puede acceder a los miembros privados.

```scala
package com.ejemplo

class Persona {
  private[ejemplo] var nombre: String = "John"
  private[ejemplo] def cambiarNombre(nuevoNombre: String): Unit = {
    nombre = nuevoNombre
  }
}
```
En este ejemplo, `nombre` y `cambiarNombre` son accesibles dentro del paquete `com.ejemplo`.

### **Protected**
Un miembro `protected` es accesible desde la clase donde está definido y desde cualquier clase derivada (subclase). Esto es útil cuando deseas permitir el acceso a los detalles de implementación solo a través de la herencia.

```scala
class Persona {
  protected var nombre: String = "John"
  protected def cambiarNombre(nuevoNombre: String): Unit = {
    nombre = nuevoNombre
  }
}

class Empleado extends Persona {
  def actualizarNombre(nuevoNombre: String): Unit = {
    cambiarNombre(nuevoNombre)
  }
}
```
En este ejemplo, `nombre` y `cambiarNombre` son protegidos, por lo que `Empleado`, que es una subclase de `Persona`, puede acceder y modificar `nombre`.

#### **Protected[scope]**

Similar a `private[scope]`, puedes especificar el alcance de la visibilidad protegida.

```scala
package com.ejemplo

class Persona {
  protected[ejemplo] var nombre: String = "John"
  protected[ejemplo] def cambiarNombre(nuevoNombre: String): Unit = {
    nombre = nuevoNombre
  }
}
```
En este caso, `nombre` y `cambiarNombre` son accesibles dentro del paquete `com.ejemplo` y por cualquier clase derivada dentro del mismo paquete.

### **Resumen**
- **Public**: Miembros accesibles desde cualquier parte del programa.
- **Private**: Miembros accesibles solo dentro de la clase o trait donde están definidos.
- **Protected**: Miembros accesibles dentro de la clase o trait y sus subclases.
- **Private[scope]** y **Protected[scope]**: Permiten especificar un alcance más fino para la visibilidad.



<hr>

<a name="schema5"></a>

## 5.Constructores


En Scala, los constructores son métodos especiales utilizados para inicializar objetos de una clase. Scala ofrece dos tipos de constructores: el constructor primario y los constructores secundarios.

### **Constructor Primario**
El constructor primario está integrado en la definición de la clase y se define junto con la declaración de la clase. Los parámetros del constructor primario se declaran directamente después del nombre de la clase y pueden tener modificadores de acceso (por ejemplo, val o var) para convertirlos en campos de la clase.


```scala
class Persona(val nombre: String, var edad: Int) {
  // Código adicional del cuerpo de la clase
  def saludar(): Unit = {
    println(s"Hola, mi nombre es $nombre y tengo $edad años")
  }
}

val persona = new Persona("John", 30)
persona.saludar() // Salida: Hola, mi nombre es John y tengo 30 años
```
En este ejemplo, `Persona` tiene un constructor primario con dos parámetros: `nombre` y `edad`. El uso de `val` y `var` en los parámetros hace que estos sean accesibles como campos de la clase.

### **Constructor Secundario**
Los constructores secundarios se definen dentro del cuerpo de la clase usando el método `this`. Los constructores secundarios pueden llamar al constructor primario o a otros constructores secundarios.

```scala
class Persona(val nombre: String, var edad: Int) {
  // Constructor secundario
  def this(nombre: String) = {
    this(nombre, 0) // Llama al constructor primario
    println("Constructor secundario llamado")
  }

  def saludar(): Unit = {
    println(s"Hola, mi nombre es $nombre y tengo $edad años")
  }
}

val persona1 = new Persona("John", 30)
val persona2 = new Persona("Jane")
persona1.saludar() // Salida: Hola, mi nombre es John y tengo 30 años
persona2.saludar() // Salida: Hola, mi nombre es Jane y tengo 0 años
```
En este ejemplo, `Persona` tiene un constructor secundario que solo toma un parámetro `nombre`. Este constructor secundario llama al constructor primario con un valor predeterminado para `edad`.

### **Inicialización de Campos**
Scala también permite la inicialización de campos dentro del cuerpo de la clase.

```scala
class Persona(val nombre: String, var edad: Int) {
  // Inicialización de campos
  val añoNacimiento: Int = 2024 - edad

  def saludar(): Unit = {
    println(s"Hola, mi nombre es $nombre y tengo $edad años")
  }
}

val persona = new Persona("John", 30)
println(persona.añoNacimiento) // Salida: 1994
```
### **Constructores y Herencia**
Cuando se trabaja con herencia, los constructores de la clase base se llaman antes de los constructores de la clase derivada. La clase derivada puede llamar al constructor de la clase base usando `super`.

```scala
class Persona(val nombre: String, var edad: Int) {
  def saludar(): Unit = {
    println(s"Hola, mi nombre es $nombre y tengo $edad años")
  }
}

class Empleado(nombre: String, edad: Int, val puesto: String) extends Persona(nombre, edad) {
  def trabajar(): Unit = {
    println(s"$nombre está trabajando como $puesto")
  }
}

val empleado = new Empleado("John", 30, "Ingeniero")
empleado.saludar()   // Salida: Hola, mi nombre es John y tengo 30 años
empleado.trabajar()  // Salida: John está trabajando como Ingeniero
```
### **Resumen**
- **Constructor Primario**: Definido junto con la declaración de la clase, puede tener modificadores de acceso.
- **Constructor Secundario**: Definido dentro del cuerpo de la clase usando el método this, puede llamar a otros constructores.
- **Inicialización de Campos**: Puede hacerse dentro del cuerpo de la clase.
- **Constructores y Herencia**: Los constructores de la clase base se llaman antes de los de la clase derivada, y super se usa para llamar al constructor de la clase base.

Los constructores en Scala proporcionan una forma flexible y poderosa de inicializar objetos, facilitando la creación y manipulación de instancias de clases de manera estructurada.


<hr>

<a name="schema6"></a>

## 6. Singleton Objects


En Scala, un objeto singleton es una forma especial de declarar una clase que solo tiene una única instancia. A diferencia de las clases normales, los objetos singleton se crean con la palabra clave `object` en lugar de `class`. Los objetos singleton son útiles para definir métodos y valores que no necesitan múltiples instancias y se utilizan frecuentemente para implementar patrones de diseño como el Singleton y el Factory.

### **Características de los Objetos Singleton**
1. **Única Instancia**: Solo existe una única instancia del objeto singleton.
2. **Sin Constructores**: Los objetos singleton no tienen constructores explícitos como las clases.
3. **Acceso Global**: Se puede acceder a ellos globalmente por su nombre, sin necesidad de instanciarlos.

```scala
object MiSingleton {
  val nombre = "Singleton"
  
  def saludar(): Unit = {
    println(s"Hola desde $nombre")
  }
}

MiSingleton.saludar()  // Salida: Hola desde Singleton
```
En este ejemplo, `MiSingleton` es un objeto singleton con un campo `nombre` y un método `saludar`. No es necesario crear una instancia de `MiSingleton` para acceder a `saludar` o `nombre`.

### **Uso de Objetos Singleton para Patrones de Diseño**
#### Patrón Singleton
El patrón Singleton asegura que una clase tenga solo una instancia y proporciona un punto de acceso global a ella. En Scala, esto se implementa fácilmente con un objeto singleton.

```scala
object Configuracion {
  private var configuracion: Map[String, String] = Map()

  def obtenerConfiguracion(clave: String): Option[String] = {
    configuracion.get(clave)
  }

  def establecerConfiguracion(clave: String, valor: String): Unit = {
    configuracion += (clave -> valor)
  }
}

// Uso
Configuracion.establecerConfiguracion("host", "localhost")
println(Configuracion.obtenerConfiguracion("host"))  // Salida: Some(localhost)
```
### **Compañero de Clase (Companion Object)**
En Scala, es común utilizar objetos singleton como compañeros de clase (companion objects). Un compañero de clase es un objeto que comparte el mismo nombre que una clase y puede acceder a sus miembros privados. Los compañeros de clase se utilizan para definir métodos y valores que están relacionados con la clase pero no requieren una instancia de ella.

```scala
class Persona(val nombre: String, val edad: Int)

object Persona {
  def aplicar(nombre: String, edad: Int): Persona = new Persona(nombre, edad)
}

// Uso
val persona = Persona.aplicar("John", 30)
println(persona.nombre)  // Salida: John
```
### **Resumen**
- **Objeto Singleton**: Una clase con una única instancia, creada con object.
- **Acceso Global**: Métodos y valores en un objeto singleton son accesibles globalmente.
- **Patrón Singleton**: Facilita la implementación del patrón Singleton.
- **Compañero de Clase**: Los objetos singleton pueden servir como compañeros de clase, definiendo métodos estáticos y accediendo a miembros privados.

Los objetos singleton son una característica poderosa en Scala que permiten una gestión eficaz de recursos y patrones de diseño.



