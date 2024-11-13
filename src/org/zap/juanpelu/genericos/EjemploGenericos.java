package org.zap.juanpelu.genericos;

import org.zap.juanpelu.poointerfaces.modelo.Cliente;
import org.zap.juanpelu.poointerfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {

        List<Cliente> clientes= new ArrayList<>();
        clientes.add(new Cliente("Juan","Perez"));

        Cliente juan = clientes.get(0);

        Cliente[] clienteArray = {
                new Cliente("Ale","Rosas"),
                new Cliente("Juan","Perez"),
        };
        Integer[] enterosArray = {1, 2, 3, 4, 5};


        List<Cliente> clientes2 = fromArrayToList(clienteArray);
        List<Integer> enteros2 = fromArrayToList(enterosArray);


        clientes2.forEach(System.out::println);
        enteros2.forEach(System.out::println);

        System.out.println("=====================");
        List<String> nombres = fromArrayToList(new String[]{"Juan","Ale", "Lucy","Bea"},enterosArray);
        nombres.forEach(System.out::println);


        List<ClientePremium> clientesPremiumList = fromArrayToList(
                new ClientePremium[]{new ClientePremium("Pedro","Matias")});

        imprimirClientes(clientes);
        imprimirClientes(clientes2);
        imprimirClientes(clientesPremiumList);

        System.out.println("Maximo de 1,9 4 es:" + maximo(1,9,4));
        System.out.println("Maximo de 1.6,9.5 4.6 es:" + maximo(1.6,9.5,4.6));
        System.out.println("Maximo de maria, ale, juan es:" + maximo("Maria","ALe","Juan"));
    }
    public static <T>List<T> fromArrayToList(T[] clientes){

        return Arrays.asList(clientes);
    }
    public static <T extends Number>List<T> fromArrayToList(T[] clientes){

        return Arrays.asList(clientes);
    }
    public static <T extends Cliente & Comparable<T>>List<T> fromArrayToList(T[] clientes){

        return Arrays.asList(clientes);
    }

    public static <T,G>List<T> fromArrayToList(T[] clientes,G[] g){
        for (G elementos: g){
            System.out.println(elementos);
        }
        return Arrays.asList(clientes);
    }
/*Comodines de metodos genericos*/
    public static void imprimirClientes(List<? extends Cliente> cli ){

        cli.forEach(System.out::println);
    }
/*Tipos genericos en objetos de diferetes tipos*/
    public static <T extends Comparable<T>> T maximo(T a,T b, T c){
        T max = a;
        if (b.compareTo(max)>0 ){
            max = b;
        }
        if (c.compareTo(max)>0 ){
            max = c;
        }
        return max;
    }


}
