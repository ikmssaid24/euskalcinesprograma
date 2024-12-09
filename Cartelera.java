
public class Cartelera {
    private static Pelicula[] peliculasSeleccionadasSabado = new Pelicula[4];
    private static Pelicula[] peliculasSeleccionadasDomingo = new Pelicula[4];

    public void añadirSelecSabado(Pelicula peliculasSeleccionadasDomingo, int posicion) {
        this.peliculasSeleccionadasDomingo[posicion] = peliculasSeleccionadasDomingo;
    }

    public void añadirSelecDomingo(Pelicula peliculasSeleccionadasSabado, int posicion) {
        this.peliculasSeleccionadasSabado[posicion] = peliculasSeleccionadasSabado;
    }

    public Pelicula getPeliculaSelecSabado(int posicion){
        return peliculasSeleccionadasSabado[posicion];
    }

    public Pelicula getPeliculaSelecDomingo(int posicion){
        return peliculasSeleccionadasDomingo[posicion];
    }

    public static void mostrarCartelera() {
        System.out.println("---------------Sabado----------------");
        System.out.println("");
        System.out.println("Nombre      Duracion        Genero");
        for (int i = 0; i < peliculasSeleccionadasSabado.length; i++) {
            if (peliculasSeleccionadasSabado[i] != null) {
                System.out.println(peliculasSeleccionadasSabado[i].getNombre() + " "
                        + peliculasSeleccionadasSabado[i].getDuracion() + " "
                        + peliculasSeleccionadasSabado[i].getGenero());
            }
        }
        System.out.println("---------------Domingo----------------");
        System.out.println("");
        System.out.println("Nombre      Duracion        Genero");
        for (int i = 0; i < peliculasSeleccionadasDomingo.length; i++) {
            if (peliculasSeleccionadasDomingo[i] != null) {
                System.out.println(peliculasSeleccionadasDomingo[i].getNombre() + " "
                        + peliculasSeleccionadasDomingo[i].getDuracion() + " "
                        + peliculasSeleccionadasDomingo[i].getGenero());
            }
        }

    }
    public static Pelicula[] getPeliculasSeleccionadasSabado() {
        return peliculasSeleccionadasSabado;
    }
    public static Pelicula[] getPeliculasSeleccionadasDomingo() {
        return peliculasSeleccionadasDomingo;
    }

}
