package py.edu.unasur.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import py.edu.unasur.models.resutls.ResultadoEncontrarValores;
import py.edu.unasur.services.ServiciosBasicosService;

@Path("servicios")
public class ServiciosResource{
    @Inject
    private ServiciosBasicosService servicioInjectado;

    /// private ServiciosBasicosService servicioInjectado = new ServiciosBasicosService();

    private ServiciosBasicosService servicioUtilizandoConstructor;

    public ServiciosResource(ServiciosBasicosService servicioUtilizandoConstructor){
        this.servicioUtilizandoConstructor= servicioUtilizandoConstructor;
    }

    @GET
    @Path("/calculo-basico")
    //servicios/basico-calculo
    @Produces(MediaType.APPLICATION_JSON)
    public Integer sumaDeDosNumeros() {
        return 1;
    }

    @GET
    @Path("/constructor")
    //servicios/basico-calculo
    @Produces(MediaType.APPLICATION_JSON)
    public Integer servicioConConstructor() {
        return this.servicioUtilizandoConstructor.retornatInger();
    }

    @GET
    @Path("/inject")
    //servicios/basico-calculo
    @Produces(MediaType.APPLICATION_JSON)
    public Integer servicioConInject() {
        this.servicioInjectado = new ServiciosBasicosService();
        return this.servicioInjectado.retornatInger();
    }
    
    @GET
    @Path("/encontrar-valores")
    //servicios/basico-calculo
    @Produces(MediaType.APPLICATION_JSON)
    public ResultadoEncontrarValores encontrarValoresEnLista() {
        return this.servicioUtilizandoConstructor.procesarBusqueda();
    }
}