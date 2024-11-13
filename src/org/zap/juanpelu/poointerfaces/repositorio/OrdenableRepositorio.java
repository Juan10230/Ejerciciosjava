package org.zap.juanpelu.poointerfaces.repositorio;

import org.zap.juanpelu.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio<T> {
    List<T> listar(String campo, Direccion dir);


}
