# Introducción a Quarkus y el Patrón Repository

## 1) ¿Qué es Quarkus?

Quarkus es un framework o plataforma que se utiliza para crear aplicaciones Java rápidas, eficientes y optimizadas para trabajar en la nube y con contenedores (como Docker y Kubernetes). A diferencia de otros frameworks, Quarkus está diseñado para iniciar más rápido y consumir menos memoria, lo que lo hace ideal para aplicaciones que deben ejecutarse en entornos modernos como microservicios y serverless.

En términos más sencillos, puedes pensar en Quarkus como una herramienta que ayuda a los desarrolladores a crear aplicaciones web y servicios ligeros y rápidos, mejorando su rendimiento, especialmente cuando se ejecutan en la nube.

## 2) Explicación del patrón Repository en Quarkus

El patrón **Repository** es una manera de organizar el acceso a los datos en una aplicación. En lugar de que la lógica de la aplicación se conecte directamente a la base de datos, el Repository actúa como un intermediario encargado de realizar las operaciones de lectura, escritura, actualización y eliminación de datos. Esto facilita el mantenimiento y prueba del código, ya que separa la lógica del negocio de la lógica de acceso a los datos.

### Implementación en Quarkus con Panache

En Quarkus, el patrón Repository puede implementarse usando **Panache**, una extensión que facilita el uso de la base de datos. Con Panache, puedes crear un Repository con unas pocas líneas de código para interactuar con la base de datos.

### Ejemplo básico:

#### 1. Crear una Entidad:
Primero, creamos una entidad, que es una clase que representa una tabla de la base de datos. Por ejemplo:

```java
@Entity
public class Producto {
    @Id
    @GeneratedValue
    public Long id;
    public String nombre;
    public Double precio;
}
