package py.edu.unasur.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import py.edu.unasur.models.Presupuestos;

@ApplicationScoped
public class PresupuestosRespository implements PanacheRepository<Presupuestos> {
}
