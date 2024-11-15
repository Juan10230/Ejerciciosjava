package org.zap.juanpelu.poointerfaces.repositorio.lista;

import org.zap.juanpelu.poointerfaces.modelo.Cliente;
import org.zap.juanpelu.poointerfaces.repositorio.AbstractListRepositorio;
import org.zap.juanpelu.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public  class ClienteListRepositorio extends AbstractListRepositorio<Cliente> {

    @Override
    public void editarCliente(Cliente cliente) {
        Cliente cli = this.porID(cliente.getIdCliente());
        cli.setNombre(cliente.getNombre());
        cli.setApellido(cliente.getApellido());

    }


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

    public static int ordenar(String campo,Cliente a, Cliente b) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getIdCliente().compareTo(b.getIdCliente());
            case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }



}
