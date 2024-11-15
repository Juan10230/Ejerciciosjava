import org.zap.juanpelu.poointerfaces.modelo.Cliente;
import org.zap.juanpelu.poointerfaces.repositorio.*;
import org.zap.juanpelu.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {


        FullRepositorio<Cliente> repo = new ClienteListRepositorio();

        repo.crearCliente(new Cliente("Juan","a"));
        repo.crearCliente(new Cliente("Flor","b"));
        repo.crearCliente(new Cliente("Luz","d"));
        repo.crearCliente(new Cliente("Andrea","c"));

        List<Cliente> clientes =  repo.listaClientes();
        clientes.forEach(System.out::println);

        List<Cliente> paginable =repo.listar(0,3);
        System.out.println("_______________________________________________");
        paginable.forEach(System.out::println);


        System.out.println("\nOrdenar_______________________________________________");

        List<Cliente> clientesOrdenASC = repo.listar("apellido", Direccion.ASC);


        for (Cliente cliente : clientesOrdenASC) {
            System.out.println(cliente);
        }

        System.out.println("______________EDITAR___________");
        Cliente beaActualizar = new Cliente("Flor","Jezabel");
        beaActualizar.setIdCliente(2);
        repo.editarCliente(beaActualizar);


        Cliente flor = repo.porID(2);
        System.out.println(flor);

        System.out.println("-----------------Nuevo orden----------------------");

        repo.listar("nombre",Direccion.ASC).forEach(System.out::println);

        System.out.println("Eliminar___________________________");
        repo.eliminarCliente(2);
        repo.listaClientes().forEach(System.out::println);

        System.out.println("==============Total==============\nRegistros:"
                + repo.total());
    }
}