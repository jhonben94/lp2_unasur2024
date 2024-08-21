package main.java.py.edu.unasur.models.resutls;

import py.edu.unasur.models.resutls.TestResult;

public class ComplexResult {
    Double latitud;
    Double longitud;
    String direccion;
    Integer nroCasa;
    TestResult test;

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getNroCasa() {
        return nroCasa;
    }

    public void setNroCasa(Integer nroCasa) {
        this.nroCasa = nroCasa;
    }

}
