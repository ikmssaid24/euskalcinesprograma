package euskalcinesprograma;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Cartelera {
    private static ArrayList<Pelicula> peliculasSeleccionadasSabado = new ArrayList<Pelicula>();
    private static ArrayList<Pelicula> peliculasSeleccionadasDomingo = new ArrayList<Pelicula>();
    private static String generoSelecSabado="";
    private static String generoSelecDomingo="";
    private boolean fin=false;

    public void setGeneroSelecDomingo(String generoSelecDomingo) {
        this.generoSelecDomingo += generoSelecDomingo;
    }
    public void setGeneroSelecSabado(String generoSelecSabado) {
        this.generoSelecSabado += generoSelecSabado;
    }

    public String getGeneroSelecDomingo() {
        return generoSelecDomingo;
    }

    public String getGeneroSelecSabado() {
        return generoSelecSabado;
    }

    public void añadirSelecDomingo(Pelicula peliculasSeleccionadasDomingo) {
        this.peliculasSeleccionadasDomingo.add(peliculasSeleccionadasDomingo);
    }

    public void añadirSelecSabado(Pelicula peliculasSeleccionadasSabado) {
        this.peliculasSeleccionadasSabado.add(peliculasSeleccionadasSabado);
    }

    public Pelicula getPeliculaSelecSabado(int posicion) {
        return peliculasSeleccionadasSabado.get(posicion);
    }

    public Pelicula getPeliculaSelecDomingo(int posicion) {
        return peliculasSeleccionadasDomingo.get(posicion);
    }

    public static void mostrarCartelera() {
        System.out.println("---------------Sabado----------------");
        System.out.println("");
        System.out.println("Nombre      Duracion        Genero");
        for (int i = 0; i < peliculasSeleccionadasSabado.size(); i++) {

            System.out.println(peliculasSeleccionadasSabado.get(i).getNombre() + " "
                    + peliculasSeleccionadasSabado.get(i).getDuracion() + " "
                    + peliculasSeleccionadasSabado.get(i).getGenero());

        }
        System.out.println("---------------Domingo----------------");
        System.out.println("");
        System.out.println("Nombre      Duracion        Genero");
        for (int i = 0; i < peliculasSeleccionadasDomingo.size(); i++) {

            System.out.println(peliculasSeleccionadasDomingo.get(i).getNombre() + " "
                    + peliculasSeleccionadasDomingo.get(i).getDuracion() + " "
                    + peliculasSeleccionadasDomingo.get(i).getGenero());

        }

    }

    public static ArrayList<Pelicula> getPeliculasSeleccionadasDomingo() {
        return peliculasSeleccionadasDomingo;
    }

    public static ArrayList<Pelicula> getPeliculasSeleccionadasSabado() {
        return peliculasSeleccionadasSabado;
    }

    public void setFin(boolean fin) {
        this.fin = fin;
    }

    public static boolean estaDeAcuerdo() {
        Scanner sc=new Scanner(System.in);
		boolean ret = false;
		System.out.println("Se perderan los datos guardados... ");
		System.out.print("Estas de acuerdo? [s, n]: ");
		String opcion = sc.nextLine().trim().charAt(0) + "";
		ret = opcion.equalsIgnoreCase("n");
		return ret;
	}

    public static void mostrarFin() {
		try {
			System.out.println(" ");
			System.out.println("- Cambios confirmados -");
			System.out.println(" ");
			TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {
			// No hace falta poner nada aqui
		}
	}

    public static void resetear(Dia sabado, Dia domingo) {
		sabado.setTiempo(480);
		domingo.setTiempo(360);
		peliculasSeleccionadasSabado = new ArrayList<Pelicula>();
		peliculasSeleccionadasDomingo = new ArrayList<Pelicula>();
        generoSelecSabado="";
        generoSelecDomingo="";
        
	}
}
