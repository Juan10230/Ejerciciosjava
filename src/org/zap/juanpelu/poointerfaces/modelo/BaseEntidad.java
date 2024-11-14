package org.zap.juanpelu.poointerfaces.modelo;

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



}
