import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {
    public static void mostrarBienvenida() {
        try {
            System.out.println("--------------------------------");
            System.out.println("- Bienvenido a Cine Usurbil -");
            System.out.println("--------------------------------");
            System.out.println(" ");
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            // No hace falta poner nada aqui
        }
    }

    public static void pedirElLogin() {
        Scanner sc = new Scanner(System.in);
        String usuarioIntroducido = null;
        String claveIntroducida = null;
        boolean claveCorrecta = false;
        do {
            System.out.print("Usuario: ");
            usuarioIntroducido = sc.nextLine().trim();

            System.out.print("Clave: ");
            claveIntroducida = sc.nextLine().trim();

            if (("admin".equalsIgnoreCase(usuarioIntroducido))
                    && ("1234".equals(claveIntroducida))) {
                claveCorrecta = true;
            } else {
                System.out.println("Error!!! Usuario o Clave incorrectos");
            }

        } while (!claveCorrecta);
    }

    public static int mostrarMenuInicial() {
        Scanner sc = new Scanner(System.in);
        int ret = -1;
        do {
            try {
                System.out.println("- Menu Inicial -");
                System.out.println("----------------");
                System.out.println("1. Cargar peliculas");
                System.out.println("2. Añadir peliculas");
                System.out.println("3. Crear cartelera");
                System.out.println("0. Salir");
                System.out.println(" ");
                System.out.print("Escoge una opcion: ");
                ret = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Error!!! Opcion incorrecta");
                sc.nextLine();
                ret = -1;
            }
        } while ((ret < 0) || (ret > 3));
        return ret;
    }

    public static int mostrarMenuCartelera() {
        Scanner sc = new Scanner(System.in);
        int ret = -1;
        do {
            try {
                System.out.println("- Menu Inicial -");
                System.out.println("----------------");
                System.out.println("1. Drama");
                System.out.println("2. Comedia");
                System.out.println("3. Terror");
                System.out.println("4. Ciencia Ficcion");
                System.out.println("5. Ver Resumen");
                System.out.println("0. Salir");
                System.out.println(" ");
                System.out.print("Escoge una opcion: ");
                ret = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Error!!! Opcion incorrecta");
                sc.nextLine();
                ret = -1;
            }
        } while ((ret < 0) || (ret > 5));
        return ret;
    }

    // declarar dias
    private static Dia sabado = new Dia(480);
    private static Dia domingo = new Dia(360);

    // muestra el tiemop restante
    public static void mostrarTiempoRestante() {
        System.out.println(" ");
        System.out.println("Tiempo Restante del Sabado: " + sabado.getTiempo());
        System.out.println("Tiempo Restante del Domingo: " + domingo.getTiempo());
        System.out.println(" ");
    }

    static void añadirPeli(ArrayList<Pelicula> peliculas) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre de la peli: ");
        String nombre = sc.nextLine();
        System.out.println("Introduce la duracion de la peli: ");
        int duracion = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce el genero de la peli: ");
        String generoPeli = sc.nextLine().toLowerCase();
        Pelicula peli = new Pelicula(nombre, duracion, generoPeli);
        peliculas.add(peli);
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // mostrar bienvenido y esperar 3 segundos
        mostrarBienvenida();
        // pedir el login
        pedirElLogin();
        // declarar variavles y objetos
        ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
        Genero[] generos = new Genero[4];
        Genero drama = new Genero("drama");
        generos[0] = drama;
        Genero comedia = new Genero("comedia");
        generos[1] = comedia;
        Genero terror = new Genero("terror");
        generos[2] = terror;
        Genero ciencaFiccion = new Genero("ciencaficcion");
        generos[3] = ciencaFiccion;
        // mostrar el menu inicial y elegir una opcion
        while (true) {
            int opcionInicial = mostrarMenuInicial();
            switch (opcionInicial) {
                case 0:
                    break;
                case 1:

                    break;
                case 2:
                    añadirPeli(peliculas);
                    break;
                case 3:
                    int opcionCartelera = mostrarMenuCartelera();
                    int generoSeleccionado = opcionCartelera - 1;

                    break;

                default:
                    break;
            }
        }
    }
}
