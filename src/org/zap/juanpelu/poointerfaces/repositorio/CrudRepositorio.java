package org.zap.juanpelu.poointerfaces.repositorio;

import org.zap.juanpelu.poointerfaces.modelo.Cliente;

import java.util.List;

public interface CrudRepositorio {

    List<Cliente> listaClientes();
    Cliente porID(Integer id);
    void crearCliente(Cliente cliente);
    void editarCliente(Cliente cliente);
    void eliminarCliente(Integer id);

}
