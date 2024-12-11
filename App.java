package euskalcinesprograma;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {
    // Metodo de Bienvenida
    public static void mostrarBienvenida() {
        try {
            System.out.println("--------------------------------");
            System.out.println("- Bienvenido a Cine Usurbil -");
            System.out.println("--------------------------------");
            System.out.println(" ");
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            // Excepcion en caso de error
        }
    }

    // Metodo  verificar Login
    public static boolean verificacionDelLogin(String usuario, String contraseña){
        if (("admin".equalsIgnoreCase(usuario))
        && ("1234".equalsIgnoreCase(contraseña))) {   //validacion usuario y contraseña para dar acceso (independientemente de mayus o minus)
    return true;
} else {
    System.out.println("Error!!! Usuario o Clave incorrectos"); //El usuario no tiene acceso
    return false;
}
    }
    //Metodo pedir login
    public static void pedirElLogin() {
        Scanner sc = new Scanner(System.in);
        String usuarioIntroducido = null; //inicializamos string vacios
        String claveIntroducida = null;
        do {
            System.out.print("Usuario: ");
            usuarioIntroducido = sc.nextLine().trim(); //solicita usuario

            System.out.print("Clave: ");
            claveIntroducida = sc.nextLine().trim(); //solicita contraseña

          
        } while (!verificacionDelLogin(usuarioIntroducido, claveIntroducida)); //conecta el metodo de pedir los datos el cual se repetira mientras los datos sean incorrectos
    }

    // Metodo carga de menu
    public static int mostrarMenuInicial() {
        Scanner sc = new Scanner(System.in);
        int ret = -1; //variable de opcion
        do {
            try {
                System.out.println("- Menu Inicial -");
                System.out.println("----------------");
                System.out.println("1. Cargar peliculas");
                System.out.println("2. Añadir peliculas");
                System.out.println("3. Crear cartelera");
                System.out.println("0. Salir");
                System.out.println(" ");
                System.out.print("Escoge una opcion: "); //opciones del menu
                ret = sc.nextInt(); //Ingresar opcion
                sc.nextLine(); //salto de linea
            } catch (Exception e) {
                System.out.println("Error!!! Opcion incorrecta"); //Excepcion cuando se elije una opcion diferente a las disponibles o distintos a un numero
                sc.nextLine(); //Correcion para ingresar bien los datos
                ret = -1;
            }
        } while ((ret < 0) || (ret > 3)); //limitamos el bucle a las opciones del menu
        return ret; //devolvemos la opcion elegida
    }

    // Metodo menu Cartelera de generos
    public static int mostrarMenuCartelera() {
        Scanner sc = new Scanner(System.in);
        int ret = -1; //variable de opcion
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
                System.out.println(" "); // Enseñamos las opciones disponibles segun su genero
                System.out.print("Escoge una opcion: ");
                ret = sc.nextInt(); //variable de opcion
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Error!!! Opcion incorrecta"); //se ingreso una opcion diferente a las disponibles o distinto a un numero
                sc.nextLine(); //Re ingresar opcions
                ret = -1;
            }
        } while ((ret < 0) || (ret > 5)); //limite del bucle segun las opciones disponibles
        return ret; //devolvemos la opcion elegida
    }

    // Metodo Cargar Peliculas
    static void CargarPeliculas(ArrayList<Pelicula> peliculas) {
        File ficheer = new File("C:\\Users\\gelaule\\Documents\\clase\\java\\src\\euskalcinesprograma\\fichero.txt"); //Creamos un archivo .txt el cual nos ingresa las peliculas guardadas
        Scanner sc = null;

        try {
            sc = new Scanner(ficheer);
        } catch (Exception e) {
            // TODO: handle exception
        }
        while (sc.hasNextLine()) {
            String string = sc.nextLine();
            String[] partes = string.split("-");

            String nombre = partes[0];
            int duracion = Integer.parseInt(partes[1]);
            String genero = partes[2];
            Pelicula pelicula = new Pelicula(nombre, duracion, genero);
            peliculas.add(pelicula);
        }
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
    
    //
    public static ArrayList<Pelicula> añadeArrayPelicula(ArrayList<Pelicula> peliculas, String nombre, int duracion,
            String generoPeli) {
        Pelicula peli = new Pelicula(nombre, duracion, generoPeli);
        peliculas.add(peli);
        return peliculas;
    }
//
    static void añadirPeli(ArrayList<Pelicula> peliculas) {
        boolean i = true;
        while (i) {
            try {
                Scanner sc = new Scanner(System.in);
                boolean a = true;
                String nombre = "";
                int duracion = 0;
                String generoPeli = "";
                while (a) {
                    System.out.println("Introduce el nombre de la peli: ");
                    nombre = sc.nextLine();
                    System.out.println("Introduce la duracion de la peli: ");
                    duracion = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introduce el genero de la peli: ");
                    generoPeli = sc.nextLine().toLowerCase();

                    if (generoPeli.equals("terror") || generoPeli.equals("drama") || generoPeli.equals("cienciaficcion")
                            || generoPeli.equals("comedia")) {
                        a = false;
                    } else {
                        System.out.println("\n Elija entre la 4 opciones \n Terror, Drama, Comedia,cienciaficcion");
                        System.out.println("Ingrese los datos correctamente...");
                        continue;

                    }

                }

                peliculas = añadeArrayPelicula(peliculas, nombre, duracion, generoPeli);
                i = false;
            } catch (Exception e) {
                System.out.println("Error, los datos introducidos son incorrectos, Intentelo de nuevo");
            }
        }
    }

    static int mostrarPeliculas(int generoSeleccionado, ArrayList<Pelicula> peliculas, Genero[] generos) {
        Scanner sc = new Scanner(System.in);
        int[] posibles = new int[peliculas.size()];
        int opcion = 0;
        System.out.println("Seleccione una pelicula o pulse -1 para volver atras:");
        try {
            while (true) {
                for (int i = 0; i < peliculas.size(); i++) {
                    if (peliculas.get(i).getGenero().equals(generos[generoSeleccionado].getNombre())) {
                        System.out.println(
                                i + "-" + peliculas.get(i).getNombre() + ": " + peliculas.get(i).getDuracion());
                        posibles[i] = 1;
                    }
                }
                opcion = sc.nextInt();
                if (opcion==-1) {
                    break;
                }
                if (posibles[opcion] != 1) {
                    System.out.println("Error la opcion introducida no esta entre las opciones disponibles");
                } else {
                    break;
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error, se ha introducido un valor incorrecto");
        }
        return opcion;

    }

    static boolean añadirACatelera(int peliculaSeleccionada, ArrayList<Pelicula> peliculas, Cartelera cartelera,
            Dia sabado, Dia domingo) {
                if (peliculaSeleccionada==-1) {
                    return false;
                }
        Pelicula i = peliculas.get(peliculaSeleccionada);
        if (sabado.getTiempo() < 60 || cartelera.getGeneroSelecSabado().contains(i.getGenero())) {
            if (domingo.getTiempo() < 60 || cartelera.getGeneroSelecDomingo().contains(i.getGenero())) {
                System.out.println(
                        "se ha acabdo el tiempo del sabado y domingo o ya se han elegido los 4 generos en esos dias");
                return true;
            } else {
                cartelera.añadirSelecDomingo(i);
                domingo.restar(peliculas.get(peliculaSeleccionada).getDuracion());
                cartelera.setGeneroSelecDomingo(peliculas.get(peliculaSeleccionada).getGenero());
            }
        } else {
            cartelera.añadirSelecSabado(i);
            sabado.restar(peliculas.get(peliculaSeleccionada).getDuracion());
            cartelera.setGeneroSelecSabado(peliculas.get(peliculaSeleccionada).getGenero());
        }
        return false;
    }

    public static void main(String[] args) {
        fin: while (true) {
            Cartelera cartelera = new Cartelera();
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
            Genero cienciaFiccion = new Genero("cienciaficcion");
            generos[3] = cienciaFiccion;
            // mostrar el menu inicial y elegir una opcion
            salir: while (true) {
                int opcionInicial = mostrarMenuInicial();
                switch (opcionInicial) {
                    case 0:
                        break fin;
                    case 1:
                        CargarPeliculas(peliculas);
                        break;
                    case 2:
                        añadirPeli(peliculas);
                        break;
                    case 3:
                        int opcionCartelera = mostrarMenuCartelera();
                        int generoSeleccionado = opcionCartelera - 1;

                        switch (opcionCartelera) {
                            case 0:
                                break;
                            case 1, 2, 3, 4:
                                boolean sabadoLleno = false;
                                if (sabado.getTiempo() < 60
                                        || cartelera.getPeliculasSeleccionadasSabado().size() == 4) {
                                    sabadoLleno = true;
                                }
                                if (cartelera.getGeneroSelecDomingo()
                                        .contains(generos[generoSeleccionado].getNombre())) {
                                    System.out.println(
                                            "este genero ya ha sido seleccionado para el domingo, porfabor elija otro");
                                    break;
                                } else if (cartelera.getGeneroSelecSabado()
                                        .contains(generos[generoSeleccionado].getNombre()) && sabadoLleno == false) {
                                    System.out.println(
                                            "este genero ya ha sido seleccionado para el sabado, porfabor elija otro");
                                    break;
                                }
                                if (añadirACatelera(mostrarPeliculas(generoSeleccionado, peliculas, generos), peliculas,
                                        cartelera, sabado, domingo)) {
                                    if (cartelera.estaDeAcuerdo()) {
                                        cartelera.resetear(sabado, domingo);
                                        System.out.println("-cambios eliminados-");
                                    } else {
                                        cartelera.resetear(sabado, domingo);
                                        cartelera.mostrarFin();
                                        break salir;

                                    }
                                }
                                break;
                            case 5:
                                mostrarTiempoRestante();
                                Cartelera.mostrarCartelera();
                                break;

                            default:
                                break;
                        }
                        break;

                    default:
                        break;
                }
            }
        }
    }

}
