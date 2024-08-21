# Sección 1: Introducción a Servicios en Quarkus

### ¿Qué es `@ApplicationScoped` en Quarkus?
`@ApplicationScoped` es una anotación en Quarkus que define un bean que vive durante el ciclo de vida de la aplicación. Esto significa que una única instancia del bean será compartida entre todas las peticiones y usuarios a lo largo de la vida de la aplicación.

### ¿Cómo funciona la inyección de dependencias en Quarkus?
La inyección de dependencias en Quarkus permite gestionar automáticamente la creación y el ciclo de vida de los objetos, facilitando la reutilización de código y el desacoplamiento de componentes. En Quarkus, esto se logra utilizando anotaciones como `@Inject`, `@ApplicationScoped`, `@Singleton`, entre otras, que indican cómo y cuándo se deben inyectar las dependencias.

### ¿Cuál es la diferencia entre `@ApplicationScoped`, `@RequestScoped`, y `@Singleton` en Quarkus?
- `@ApplicationScoped`: El bean vive durante todo el ciclo de vida de la aplicación, compartiendo una única instancia entre todas las solicitudes.
- `@RequestScoped`: El bean se crea para cada solicitud HTTP y se destruye una vez que la solicitud ha sido procesada.
- `@Singleton`: Similar a `@ApplicationScoped`, pero con la diferencia de que se sigue el ciclo de vida de la JVM en lugar de la aplicación. Es útil para casos donde se necesita asegurarse de que exista solo una instancia en todo el entorno de ejecución.

### ¿Cómo se define un servicio en Quarkus utilizando `@ApplicationScoped`?
Para definir un servicio en Quarkus utilizando `@ApplicationScoped`, se debe crear una clase de servicio y anotarla con `@ApplicationScoped`. Aquí hay un ejemplo:

```java
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyService {
    public String performAction() {
        return "Action performed!";
    }
}



# presupuesto-mensual

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/presupuesto-mensual-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- SmallRye OpenAPI ([guide](https://quarkus.io/guides/openapi-swaggerui)): Document your REST APIs with OpenAPI - comes with Swagger UI
- REST Jackson ([guide](https://quarkus.io/guides/rest#json-serialisation)): Jackson serialization support for Quarkus REST. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it

## Provided Code

### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
