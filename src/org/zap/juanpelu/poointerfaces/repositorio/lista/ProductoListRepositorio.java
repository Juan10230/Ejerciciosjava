package org.zap.juanpelu.poointerfaces.repositorio.lista;

import org.zap.juanpelu.poointerfaces.modelo.Cliente;
import org.zap.juanpelu.poointerfaces.modelo.Producto;
import org.zap.juanpelu.poointerfaces.repositorio.AbstractListRepositorio;
import org.zap.juanpelu.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractListRepositorio <Producto> {


    @Override
    public void editarCliente(Producto producto) {
        Producto p = porID(producto.getIdCliente());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) {
        List<Producto> listaOrdenada = new ArrayList<>(this.dataSource);
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

    public static int ordenar(String campo,Producto a, Producto b) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getIdCliente().compareTo(b.getIdCliente());
            case "Descripcion" -> resultado = a.getDescripcion().compareTo(b.getDescripcion());
            case "Precio" -> resultado = a.getPrecio().compareTo(b.getPrecio());
        }
        return resultado;
    }


}
