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
            // No hace falta poner nada aqui
        }
    }

    // Metodo Login
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

    // Metodo carga de menu
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

    // Metodo Cartelera de generos
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

    // Metodo Cargar Peliculas
    static void CargarPeliculas(ArrayList<Pelicula> peliculas) {
        File ficheer = new File("C:\\Users\\gelaule\\Documents\\clase\\java\\src\\fichero.txt");
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

    static void añadirPeli(ArrayList<Pelicula> peliculas) {
        boolean i = true;
        while (i) {
            try {
                Scanner sc = new Scanner(System.in);
                boolean a=true;
                String nombre="";
                int duracion=0;
                String generoPeli="";
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
                            a=false;
                }else{
                    System.out.println("\n Elija entre la 4 opciones \n Terror, Drama, Comedia,cienciaficcion");
                            System.out.println("Ingrese los datos correctamente...");
                            continue;
                    
                    }
                
               }

                Pelicula peli = new Pelicula(nombre, duracion, generoPeli);
                peliculas.add(peli);
                i = false;
            } catch (Exception e) {
                System.out.println("Error, los datos introducidos son incorrectos, Intentelo de nuevo");
            }
        }
    }

    static int mostrarPeliculas(int generoSeleccionado, ArrayList<Pelicula> peliculas, Genero []generos){
        Scanner sc=new Scanner(System.in);
        int []posibles=new int[peliculas.size()];
        int opcion=0;
         try {
            while (true) {
                for (int i = 0; i < peliculas.size(); i++) {
                    if (peliculas.get(i).getGenero().equals(generos[generoSeleccionado].getNombre())) {
                        System.out.println(i+"-"+peliculas.get(i).getNombre()+": "+peliculas.get(i).getDuracion());
                        posibles[i]=1;
                    }
                }
                opcion=sc.nextInt();
                if (posibles[opcion]!=1) {
                    System.out.println("Error la opcion introducida no esta entre las opciones disponibles");
                }else{break;}
            }

         } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error, se ha introducido un valor incorrecto");
         }
         return opcion;
         
        
    }

    static void añadirACatelera(int peliculaSeleccionada, ArrayList<Pelicula> peliculas, Cartelera cartelera){
        for (int i = 0; i < cartelera.getPeliculasSeleccionadasSabado().length; i++) {
            if (cartelera.getPeliculaSelecSabado(i).getNombre()==null) {
                cartelera.añadirSelecSabado()
            }
        }
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
        salir: while (true) {
            int opcionInicial = mostrarMenuInicial();
            switch (opcionInicial) {
                case 0:
                    break salir;
                case 1:
                    CargarPeliculas(peliculas);
                    System.out.println(peliculas.get(0).getNombre());
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
                        case 1,2,3,4:

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
