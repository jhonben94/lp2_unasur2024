package py.edu.unasur.services;

import java.util.Arrays;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import py.edu.unasur.models.resutls.ResultadoEncontrarValores;

@ApplicationScoped
public class ServiciosBasicosService{
    
    public Integer retornatInger(){
        return 6;
    }

    public void procesarInformacionCompleja(Integer personaId){
        //buscar en base de datos en la tabla personas where id = personaId
        //actualizar fecha de ultima actualizacion
        // etc
        // etc
    }
    public ResultadoEncontrarValores procesarBusqueda(){
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
        if(respuesta.getMenor().equals(1)){
            respuesta.setMenor(5);
        }
        return respuesta;
    }
}