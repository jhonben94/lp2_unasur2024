package  py.edu.unasur.services;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import py.edu.unasur.models.GastosArchivo;
import py.edu.unasur.repositories.GastosArchivoRepository;

@ApplicationScoped
public class GastosArchivoService{

    
    private final GastosArchivoRepository repository;
    
    public GastosArchivoService(GastosArchivoRepository repository){
        this.repository = repository;
    }

    public GastosArchivo obtenerUnArchivo(Integer id){
        GastosArchivo data = repository.findById(id);
        return data;
    }
    public List<GastosArchivo> listar(){
        return repository.findAll();
    }
    public void guardarUnArhivo(GastosArchivo param){
        repository.guardarDato(param);
    }
    public void eliminarArchivo(Integer id){
        repository.delete(id);
    }
}