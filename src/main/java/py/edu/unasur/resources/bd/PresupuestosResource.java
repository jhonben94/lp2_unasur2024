package py.edu.unasur.resources.bd;

import java.util.List;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import py.edu.unasur.models.Presupuestos;
import py.edu.unasur.services.db.PresupuestosService;

@Path("db/presupuestos")
public class PresupuestosResource {

    private PresupuestosService service;

    public PresupuestosResource(PresupuestosService service) {
        this.service = service;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Presupuestos> listar() {
        return this.service.listar();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Presupuestos obtenerById(@PathParam("id") Integer id) {
        return this.service.obtenerById(id);
    }

    @POST
    public Presupuestos guardar(Presupuestos param) {
        return this.service.agregar(param);
    }

    @PUT
    public Presupuestos modificar(Presupuestos param) {
        return this.service.modificar(param);
    }

    @PUT
    @Path("{id}")
    public Presupuestos modificarAlternativo(@PathParam("id") Integer id, Presupuestos param) {
        return this.service.modificarAlternativo(id, param);
    }

    @DELETE
    @Path("{id}")
    public void eliminar(@PathParam("id") Integer id) {
        this.service.eliminar(id);
    }

}
