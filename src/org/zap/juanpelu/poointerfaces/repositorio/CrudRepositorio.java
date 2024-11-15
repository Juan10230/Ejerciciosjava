package org.zap.juanpelu.poointerfaces.repositorio;

import java.util.List;

public interface CrudRepositorio<T> {

    List<T> listaClientes();
    T porID(Integer id);
    void crearCliente(T objeto);
    void editarCliente(T objeto);
    void eliminarCliente(Integer id);

}
