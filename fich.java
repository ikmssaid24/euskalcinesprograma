import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class fich {
    public static void main(String[] args) {
       
        File ficheer =new File("C:\\Users\\gelaule\\Documents\\clase\\java\\src\\fichero.txt");
        Scanner sc=null;
        String nombre;
        String genero;
        int duracion;
        ArrayList <Pelicula> peliculas=new ArrayList<Pelicula>();
      
        try {
             sc = new Scanner(ficheer);
        } catch (Exception e) {
            // TODO: handle exception
        }
        while (sc.hasNextLine()) {
            String string=sc.nextLine();
        String[]partes=string.split("-");

            nombre=partes[0];
            duracion=Integer.parseInt(partes[1]);
            genero=partes[2];
        Pelicula pelicula =new Pelicula(nombre, duracion, genero);
        peliculas.add(pelicula);
        }
        sc.close();
        //comentario adicional

    }
}