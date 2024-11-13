package org.zap.juanpelu.genericsclas;

public class EjemploGenericos {
    public static void main(String[] args) {
        Camion<Animal> trasnporteCaballos = new Camion<>(3);
        trasnporteCaballos.add(new Animal("Duvalin","Caballo" ));
        trasnporteCaballos.add(new Animal("Legion","Caballo"));
        trasnporteCaballos.add(new Animal("Cafe","Caballo"));

        imprimir(trasnporteCaballos);
        Camion<Maquinaria> transmaquinas = new Camion<>(3);

        transmaquinas.add(new Maquinaria("escavadora"));
        transmaquinas.add(new Maquinaria("picadoira"));
        transmaquinas.add(new Maquinaria("Aplanadora"));

        imprimir(transmaquinas);
        Camion<Automovil> transautores = new Camion<>(3);

        transautores.add(new Automovil("Audi" ));
        transautores.add(new Automovil("Ford"));
        transautores.add(new Automovil("Tsuru"));

        imprimir(transautores);
    }
/*Usando Clases genericas*/
    public static<T> void imprimir (Camion<T> camion){

        for (T a:camion){

            if(a instanceof Animal) {
                /*La unica opcion es usando un cast para imprimir, ya que son clases genericos*/
                System.out.println("Nombre: " + (((Animal) a).getNombre()) + "   Tipo: " + ((Animal) a).getTipo());
            }else
            if (a instanceof Automovil){
                System.out.println("Auto: "+ ((Automovil)a).getMarca());
            }else
                if (a instanceof Maquinaria){
                    System.out.println("Tipo de maquinaria: " + ((Maquinaria)a).getTipo());
                }

        }

    }
}
