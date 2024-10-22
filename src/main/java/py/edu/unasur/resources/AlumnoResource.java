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
import py.edu.unasur.models.Alumno;
import py.edu.unasur.services.AlumnoService;
import py.edu.unasur.services.GastosArchivoService;

@Path("alumno")
public  class AlumnoResource {


    private final AlumnoService service;
    
    private final GastosArchivoService gastosArchivoService;
    
    public AlumnoResource(AlumnoService service, GastosArchivoService gastosArchivoService){
        this.gastosArchivoService = gastosArchivoService;
        this.service = service;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Alumno ejemploDeRepository(@PathParam("id")Integer id) {
        return this.service.obtener(id);
    }
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void eliminarDatoArchivo(@PathParam("id")Integer id) {
        this.service.eliminar(id);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Alumno> listarDatosRepository() {
        return this.service.listar();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response guardarDatoRepository(Alumno param) {
            this.service.guardar(param);
        return Response.ok().build();
    }

}