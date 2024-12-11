import java.util.ArrayList;

public class Cartelera {
    private static ArrayList<Pelicula> peliculasSeleccionadasSabado = new ArrayList<Pelicula>();
    private static ArrayList<Pelicula> peliculasSeleccionadasDomingo = new ArrayList<Pelicula>();
    private String generoSelecSabado="";
    private String generoSelecDomingo="";

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

}
