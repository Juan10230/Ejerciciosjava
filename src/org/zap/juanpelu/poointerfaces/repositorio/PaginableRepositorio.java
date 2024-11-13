package org.zap.juanpelu.poointerfaces.repositorio;

import org.zap.juanpelu.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio<T> {
    List<T> listar(int desde, int hasta);


}
