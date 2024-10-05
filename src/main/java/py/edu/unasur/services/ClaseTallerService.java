
package  py.edu.unasur.services;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import py.edu.unasur.models.CostosMantenimiento;
import py.edu.unasur.models.resutls.MantenimientoResult;

@ApplicationScoped
public class ClaseTallerService {

    public MantenimientoResult calcularMantenimiento(String marca, Integer kilometraje){
        System.out.println(marca);
        System.out.println(kilometraje);
        List<CostosMantenimiento> listaMarcas = new ArrayList<>();
        CostosMantenimiento costoToyota = new CostosMantenimiento();
        costoToyota.setCostoAceite(350000);
        costoToyota.setManoDeObra(150000);
        costoToyota.setMarca("TOYOTA");
        
        CostosMantenimiento costoaAudi = new CostosMantenimiento();
        costoaAudi.setCostoAceite(650000);
        costoaAudi.setManoDeObra(200000);
        costoaAudi.setMarca("AUDI");
        CostosMantenimiento costoChevrolet = new CostosMantenimiento();
        costoChevrolet.setCostoAceite(250000);
        costoChevrolet.setManoDeObra(150000);
        costoChevrolet.setMarca("CHEVROLET");

        listaMarcas.add(costoaAudi);
        listaMarcas.add(costoToyota);
        listaMarcas.add(costoChevrolet);

        MantenimientoResult result = new MantenimientoResult();
        for (CostosMantenimiento costo : listaMarcas) {
            System.out.println(marca.equals(costo.getMarca()));
           if(marca.equals(costo.getMarca())){
                result.setManoDeObra( costo.getManoDeObra());
                result.setMarca(marca);
                result.setValorAceite(costo.getCostoAceite());
                result.setTotalMantenimiento( costo.getManoDeObra()+ costo.getCostoAceite());
                break;
           }
        }
        if (kilometraje<=10000 && result.getTotalMantenimiento()!=null) {
         
            Double valorCalculado = result.getTotalMantenimiento()*0.95;   
            result.setTotalMantenimiento( valorCalculado.intValue());
        }else if(kilometraje >=70000){
            Double valorCalculado = result.getTotalMantenimiento()*1.05;   
            result.setTotalMantenimiento( valorCalculado.intValue());
        }

        return result;

    }

}