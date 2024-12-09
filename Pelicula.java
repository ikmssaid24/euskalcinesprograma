public class Pelicula {
    private String nombre;
    private int duracion;
    private String genero;

    Pelicula(String nombre, int duracion, String genero) {
        this.duracion = duracion;
        this.nombre = nombre;
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getGenero() {
        return genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}