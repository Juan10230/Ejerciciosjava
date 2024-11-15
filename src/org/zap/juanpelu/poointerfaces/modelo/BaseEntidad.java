package org.zap.juanpelu.poointerfaces.modelo;

import java.util.Objects;

public class BaseEntidad {

    protected Integer idCliente;
    private static int ultimoID;


    public BaseEntidad() {
        this.idCliente = ultimoID++;
    }

    public Integer getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntidad base = (BaseEntidad) o;
        return Objects.equals(idCliente, base.idCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idCliente);
    }

}
