## `@GET` y `@POST` en Quarkus

En Quarkus, los métodos `@GET` y `@POST` son anotaciones de JAX-RS (Java API for RESTful Web Services) que se utilizan para definir endpoints de un servicio REST que responden a solicitudes HTTP GET y POST, respectivamente.

### `@GET`

La anotación `@GET` se utiliza para definir un endpoint que responde a solicitudes HTTP GET. Este tipo de solicitudes se usa principalmente para obtener datos del servidor sin modificar el estado del recurso.

**Ejemplo de uso de `@GET`:**

```java
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello, Quarkus!";
    }
}
