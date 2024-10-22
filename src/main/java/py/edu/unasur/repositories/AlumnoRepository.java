package  py.edu.unasur.repositories;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.enterprise.context.ApplicationScoped;
import py.edu.unasur.models.Alumno;

@ApplicationScoped
public class AlumnoRepository {
    private static final String FILE_PATH = "src/main/resources/alumno.json";
    private Alumno entityData;
    private ObjectMapper mapper;
    private List<Alumno> lista;
    
    public AlumnoRepository(){
        mapper = new ObjectMapper();
        lista = cargarDato();
    }

    public List<Alumno> cargarDato(){
        try {
            File data = new File(FILE_PATH); 
            if (data.exists()) {
                return mapper.readValue(data, new TypeReference<List<Alumno>>() 
                {});

            }else{
                return new ArrayList<>();
            }
            
        } catch (IOException e) {
            return new ArrayList<>();
        }
    
    }

    public void guardarDato(Alumno param){
        try {
            List<Alumno> newLista = this.lista;
            Alumno busqueda = findById(param.getId());
            if (busqueda ==null) {
                newLista.add(param);
                mapper.writeValue(new File(FILE_PATH), newLista);
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Alumno findById(Integer id){
        return lista.stream()
        .filter( item -> item.getId().equals(id))
        .findFirst()
        .orElse(null); 
    }

    public List<Alumno> findAll(){
        return  new ArrayList<>(lista);
    }

    public void delete(Integer id){
        lista = lista.stream()
        .filter(item -> !item.getId().equals(id))
        .collect(Collectors.toList());
        try {
            mapper.writeValue(new File(FILE_PATH), lista);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}