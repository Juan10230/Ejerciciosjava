package org.zap.juanpelu.poointerfaces.modelo;

import java.util.Objects;

public class Producto extends BaseEntidad{
    private String descripcion;
    private Double precio;

    public Producto(String descripcion, Double precio) {
        super();
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    @Override
    public String toString() {
        return  "descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", idCliente=" + idCliente;
    }


}
