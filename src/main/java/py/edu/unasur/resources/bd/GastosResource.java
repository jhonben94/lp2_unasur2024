package py.edu.unasur.resources.bd;

import java.util.ArrayList;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import py.edu.unasur.models.Gasto;
import py.edu.unasur.repositories.GastosRepository;

@Path("/db/gastos")
public class GastosResource {

    @Inject
    private GastosRepository repository;

    @GET
    public List<Gasto> obtenerGastos() {
        return repository.listAll();
    }

    @GET
    @Path("proceso/{montoIni}/{montoFin}")
    public List<Gasto> obtenerGastosProceso(
            @PathParam("montoIni") Integer montoIni,
            @PathParam("montoFin") Integer montoFin) {
        List<Gasto> lista = repository.listAll();
        List<Gasto> listaAux = new ArrayList<>();
        for (Gasto item : lista) {
            if (item.getMonto() < montoFin && item.getMonto() > montoIni) {
                listaAux.add(item);
            }
        }
        return listaAux;
    }
}
