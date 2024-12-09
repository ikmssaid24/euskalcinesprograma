import java.util.ArrayList;

public class Genero {
    private String nombre;
    private ArrayList<Pelicula> peliculas;

    Genero(String nombre) {
        this.nombre = nombre;
    }

    public void setPeliculas(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
    
    public void añadirPelicula(Pelicula pelicula){
        peliculas.add(pelicula);
    }
    public String getNombre() {
        return nombre;
    }

}
