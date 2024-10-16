package  py.edu.unasur.repositories;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.enterprise.context.ApplicationScoped;
import py.edu.unasur.models.GastosArchivo;

@ApplicationScoped
public class GastosArchivoRepository {
    private static final String FILE_PATH = "src/main/resources/data.json";
    private GastosArchivo gasto;
    private ObjectMapper mapper;
    private List<GastosArchivo> lista;
    
    public GastosArchivoRepository(){
        mapper = new ObjectMapper();
        lista = cargarDato();
    }

    public List<GastosArchivo> cargarDato(){
        try {
            File data = new File(FILE_PATH); 
            if (data.exists()) {
                return mapper.readValue(data, new TypeReference<List<GastosArchivo>>() 
                {});

            }else{
                return new ArrayList<>();
            }
            
        } catch (IOException e) {
            return new ArrayList<>();
        }
    
    }

    public void guardarDato(GastosArchivo param){
        try {
            List<GastosArchivo> newLista = this.lista;
            GastosArchivo busquedaGasto = findById(param.getId());
            if (busquedaGasto==null) {
                newLista.add(param);
                mapper.writeValue(new File(FILE_PATH), newLista);
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GastosArchivo findById(Integer id){
        return lista.stream()
        .filter( gasto -> gasto.getId().equals(id))
        .findFirst()
        .orElse(null); 
    }

    public List<GastosArchivo> findAll(){
        return  new ArrayList<>(lista);
    }

    public void delete(Integer id){
        lista = lista.stream()
        .filter(gasto -> !gasto.getId().equals(id))
        .collect(Collectors.toList());
        try {
            mapper.writeValue(new File(FILE_PATH), lista);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}