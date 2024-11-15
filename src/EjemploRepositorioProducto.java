import org.zap.juanpelu.poointerfaces.modelo.Cliente;
import org.zap.juanpelu.poointerfaces.modelo.Producto;
import org.zap.juanpelu.poointerfaces.repositorio.Direccion;
import org.zap.juanpelu.poointerfaces.repositorio.FullRepositorio;
import org.zap.juanpelu.poointerfaces.repositorio.lista.ClienteListRepositorio;
import org.zap.juanpelu.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {


        FullRepositorio<Producto> repo = new ProductoListRepositorio();

        repo.crearCliente(new Producto("Mesa",18.23));
        repo.crearCliente(new Producto("Lampara",19.3));
        repo.crearCliente(new Producto("Sillom",5.5));
        repo.crearCliente(new Producto("Banco",10.4));

        List<Producto> productos =  repo.listaClientes();
        productos.forEach(System.out::println);

        List<Producto> paginable =repo.listar(0,3);
        System.out.println("_______________________________________________");
        paginable.forEach(System.out::println);


        System.out.println("\nOrdenar_______________________________________________");

        List<Producto> productosOrdenASC = repo.listar("Descripcion", Direccion.ASC);


        for (Producto p : productosOrdenASC) {
            System.out.println(p);
        }

        System.out.println("______________EDITAR___________");
        Producto lamparaActualizar = new Producto("Flor",18.5);
        lamparaActualizar.setIdCliente(2);
        repo.editarCliente(lamparaActualizar);


        Producto lampara = repo.porID(2);
        System.out.println(lampara);

        System.out.println("-----------------Nuevo orden----------------------");

        repo.listar("Precio",Direccion.ASC).forEach(System.out::println);

        System.out.println("Eliminar___________________________");
        repo.eliminarCliente(2);
        repo.listaClientes().forEach(System.out::println);

        System.out.println("==============Total==============\nRegistros:"
                + repo.total());
    }
}