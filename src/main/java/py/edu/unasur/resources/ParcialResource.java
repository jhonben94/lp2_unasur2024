package py.edu.unasur.resources;

import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import py.edu.unasur.models.resutls.ResultadoEncontrarValores;

/*
 *  Temario de paracial de prueba
 * Crear un recurso REST de tipo GET que reciba como parametros 2 numeros y retorne la suma de ambos
 *   GET
 *   /parcial/suma/{numero1}/{numero2}
 *   Dada la siguiente lista [12,31,1,2,31,1,123] encontrar el valor del menor, el mayor y el promedio de numero;
 * 
 */
@Path("/parcial") // /parcial
public class ParcialResource {
    @GET
    @Path("/suma/{numero1}/{numero2}")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer sumaDeDosNumeros(
            @PathParam("numero1") Integer numero1,
            @PathParam("numero2") Integer numero2) {
        return numero1 + numero2;
    }

    @GET
    @Path("encontrar-valores")
    public ResultadoEncontrarValores encontrarValoresEnLista() {
        List<Integer> numeros = Arrays.asList(12, 31, 1, 2, 31, 1, 123);
        ResultadoEncontrarValores respuesta = new ResultadoEncontrarValores();
        respuesta.setMayor(0);
        respuesta.setMenor(250);
        Integer sumatoria = 0;
        for (Integer valor : numeros) {
            if (respuesta.getMayor() < valor) {
                respuesta.setMayor(valor);
            }
            if (respuesta.getMenor() > valor) {
                respuesta.setMenor(valor);
            }
            sumatoria += valor;
        }
        Integer valorPromedio = sumatoria / numeros.size();
        respuesta.setPromedio(valorPromedio);

        return respuesta;
    }
}
