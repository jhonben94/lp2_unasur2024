package py.edu.unasur.repositories;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import py.edu.unasur.models.Gasto;

@ApplicationScoped
public class GastosRepository implements PanacheRepository<Gasto> {

}
