package org.zap.juanpelu.poointerfaces.repositorio;

import java.util.List;

public interface CrudRepositorio<T> {

    List<T> listaClientes();
    T porID(Integer id);
    void crearCliente(T cliente);
    void editarCliente(T cliente);
    void eliminarCliente(Integer id);

}
