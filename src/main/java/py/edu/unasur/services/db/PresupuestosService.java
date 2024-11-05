package py.edu.unasur.services.db;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import py.edu.unasur.models.Presupuestos;
import py.edu.unasur.repositories.PresupuestosRespository;

@ApplicationScoped
public class PresupuestosService {

    private PresupuestosRespository respository;

    public PresupuestosService(PresupuestosRespository respository) {
        this.respository = respository;
    }

    public List<Presupuestos> listar() {
        return this.respository.findAll().list();
    }

    public Presupuestos obtenerById(Integer id) {
        return this.respository.findById(id.longValue());
    }

    @Transactional
    public Presupuestos agregar(Presupuestos param) {
        this.respository.persist(param);
        return param;
    }

    @Transactional
    public Presupuestos modificar(Presupuestos param) {
        if (!param.getNombresCliente().isEmpty()) {
            this.respository.update(" nombresCliente = ?1 where presupuestoId = ?2", param.getNombresCliente(),
                    param.getPresupuestoId());
        }
        return param;
    }

    @Transactional
    public Presupuestos modificarAlternativo(Integer id, Presupuestos param) {

        Presupuestos actual = this.respository.findById(id.longValue());
        if (param.getApellidoCliente() != null && !param.getApellidoCliente().isEmpty())
            actual.setApellidoCliente(param.getApellidoCliente());
        if (param.getNombresCliente() != null && !param.getNombresCliente().isEmpty())
            actual.setNombresCliente(param.getNombresCliente());

        this.respository.getEntityManager().merge(actual);

        return actual;
    }

    @Transactional
    public void eliminar(Integer id) {
        Presupuestos p = this.respository.findById(id.longValue());
        System.out.println("Descripcion de elemento eliminado: " + p.getDescripcion());
        this.respository.deleteById(id.longValue());
    }
}
