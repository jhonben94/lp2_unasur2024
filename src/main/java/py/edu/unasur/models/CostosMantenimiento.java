package py.edu.unasur.models;
public class CostosMantenimiento{
    String marca;
    Integer costoAceite;
    Integer manoDeObra;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getCostoAceite() {
        return costoAceite;
    }

    public void setCostoAceite(Integer costoAceite) {
        this.costoAceite = costoAceite;
    }

    public Integer getManoDeObra() {
        return manoDeObra;
    }

    public void setManoDeObra(Integer manoDeObra) {
        this.manoDeObra = manoDeObra;
    }
}