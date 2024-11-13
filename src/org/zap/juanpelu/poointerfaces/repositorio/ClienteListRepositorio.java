package org.zap.juanpelu.poointerfaces.repositorio;

import org.zap.juanpelu.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio implements FullRepositorio {

    private List<Cliente> dataSource;

    public ClienteListRepositorio() {
        this.dataSource = new ArrayList<>();
    }


    @Override
    public List<Cliente> listaClientes() {
        return dataSource;
    }

    @Override
    public Cliente porID(Integer id) {
        Cliente clienteE = null;

        for (Cliente cli : dataSource) {
            if (cli.getIdCliente() != null && cli.getIdCliente().equals(id)) {
                clienteE = cli;
                break;
            }
        }
        return clienteE;
    }

    @Override
    public void crearCliente(Cliente cliente) {
        this.dataSource.add(cliente);
    }

    @Override
    public void editarCliente(Cliente cliente) {
        Cliente cli = this.porID(cliente.getIdCliente());
        cli.setNombre(cliente.getNombre());
        cli.setApellido(cliente.getApellido());

    }

    @Override
    public void eliminarCliente(Integer id) {

        this.dataSource.remove(this.porID(id));

    }

/*Sobrecarga de metodos de la interfaz OrdenableRepositorio*/
    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort((a, b) -> {
            int resultado = 0;
            if (dir == Direccion.ASC) {
                resultado = ordenar(campo,a,b);
            } else if (dir == Direccion.DES) {
                resultado= ordenar(campo,b,a);
            }
            return resultado;
        });
        return listaOrdenada;
    }

    /*Sobrecarga de metodos de la interfaz OrdenableRepositorio*/
    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }


    @Override
    public int total() {
        return this.dataSource.size();
    }
}
