package org.zap.juanpelu.poointerfaces.repositorio;

public interface FullRepositorio<T> extends OrdenableRepositorio<T>,
                                         CrudRepositorio<T>,
                                         PaginableRepositorio<T>,
                                         ContableRepositorio
{


}
