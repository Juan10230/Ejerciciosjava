package org.zap.juanpelu.poointerfaces.repositorio;
import org.zap.juanpelu.poointerfaces.modelo.BaseEntidad;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractListRepositorio<T extends BaseEntidad> implements FullRepositorio<T> {

    protected List<T> dataSource;

    public AbstractListRepositorio() {
        this.dataSource = new ArrayList<>();
    }


    @Override
    public List<T> listaClientes() {
        return dataSource;
    }

    @Override
    public T porID(Integer id) {
        T resultado = null;

        for (T cli : dataSource) {
            if (cli.getIdCliente() != null && cli.getIdCliente().equals(id)) {
                resultado = cli;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crearCliente(T t) {
        this.dataSource.add(t);
    }


    @Override
    public void eliminarCliente(Integer id) {

        this.dataSource.remove(this.porID(id));

    }

    /*Sobrecarga de metodos de la interfaz OrdenableRepositorio*/
    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }


    @Override
    public int total() {
        return this.dataSource.size();
    }
}
