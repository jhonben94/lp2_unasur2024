package  py.edu.unasur.resources;

import java.util.List;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import py.edu.unasur.models.GastosArchivo;
import py.edu.unasur.services.GastosArchivoService;

@Path("repository-example")
public  class RepositoryExampleResource {
    private final GastosArchivoService service;
    
    public RepositoryExampleResource(GastosArchivoService service){
        this.service = service;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public GastosArchivo ejemploDeRepository(@PathParam("id")Integer id) {
        return this.service.obtenerUnArchivo(id);
    }
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void eliminarDatoArchivo(@PathParam("id")Integer id) {
        this.service.eliminarArchivo(id);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<GastosArchivo> listarDatosRepository() {
        return this.service.listar();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response guardarDatoRepository(GastosArchivo param) {
            this.service.guardarUnArhivo(param);
        return Response.ok().build();
    }

}