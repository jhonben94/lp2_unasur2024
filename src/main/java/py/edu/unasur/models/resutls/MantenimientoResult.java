package py.edu.unasur.models.resutls;

public class MantenimientoResult {
    String marca;
    Integer manoDeObra;
    Integer valorAceite;
    Integer totalMantenimiento;

    public Integer getTotalMantenimiento() {
        return totalMantenimiento;
    }

    public void setTotalMantenimiento(Integer totalMantenimiento) {
        this.totalMantenimiento = totalMantenimiento;
    }

    public Integer getValorAceite() {
        return valorAceite;
    }

    public void setValorAceite(Integer valorAceite) {
        this.valorAceite = valorAceite;
    }

    public Integer getManoDeObra() {
        return manoDeObra;
    }

    public void setManoDeObra(Integer manoDeObra) {
        this.manoDeObra = manoDeObra;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    
}