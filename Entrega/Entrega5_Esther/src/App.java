import com.coti.tools.DiaUtil;
import com.coti.tools.Esdia;
import modelo.Pelicula;
import modelo.Videoteca;

public class App {

    
    public static void main(String[] args) throws Exception {

        Videoteca videoteca=new Videoteca(4);
        boolean continuar=true;

        while(continuar){
        System.out.println("|----------------------------------------------|");
        System.out.println("| MI VIDEOTECA                                 |");
        System.out.println("|----------------------------------------------|");
        System.out.println("| 1) Nueva videoteca de películas              |");
        System.out.println("| 2) Configurar velocidad de reproducción      |");
        System.out.println("| 3) Añadir una nueva película a la videoteca  |");
        System.out.println("| 4) Mostrar información actual de películas   |");
        System.out.println("| 5) Salir (se borrará toda la información)    |");
        System.out.println("|----------------------------------------------|");
    //DiaUtil.clear();
        int opcion=Esdia.readInt("Seleccione una opción (1-5)", 1, 5);
        switch(opcion){
            case 1:
                int numPeliculas=Esdia.readInt("Introduzca el nuevo tamaño de videoteca", 1, 100);
                //videoteca.setPeliculas(new Pelicula[numPeliculas]);
                //videoteca.setContador(0);
                videoteca.resetearVideoteca(numPeliculas);

                System.out.println("Sus peliculas han sido borradas");
                System.out.printf("Nuevo tamaño: %d peliculas\n",numPeliculas);
                break;
            case 2:
                System.out.println("Has seleccionado la opción 2: Configurar velocidad de reproducción");
                float velocidadReproducción=Esdia.readInt("Introduzca la velocidad de reproducción",0,10); //Limito la velocidad de reproducción para un mínimo de 0 y un máximo de 10
                videoteca.setVelocidad(velocidadReproducción);
                System.out.printf("Velocidad de reproducción establecida a %.1f\n",velocidadReproducción);
                break;
            case 3:
            //Comprobar que no esté llena
                if(videoteca.isFull()){
                    System.err.println("La videoteca está llena. No se pueden añadir más películas.");
                }else{
                //Pedir todos los datos
                System.out.println("Introduzca los datos:");
                String titulo= Esdia.readString_ne("Título:");
                int anioEstreno= Esdia.readInt("Año de estreno:",1800,2025);
                int duracionMinutos= Esdia.readInt("Duración en minutos:",0,500);
                float valoracion= Esdia.readFloat("Valoración (0.0 - 10.0):", 0.0f, 10.0f);
                String nombre= Esdia.readString_ne("Nombre del director:");
                String apellidos= Esdia.readString_ne("Apellidos del director:");
                boolean oscarganado= Esdia.yesOrNo("¿Ha ganado un Oscar? (true/false):");

                //Llamar al metodo que añada una pelicula
                Pelicula p=Pelicula.crearPeliculaDatosCrudos(titulo, anioEstreno, duracionMinutos, valoracion, nombre, apellidos, oscarganado);

                
                // Informar al usuario si todo ha ido bien
                if(videoteca.addPelicula(p)){
                    System.out.println("Se ha añadido la película correctamente.");
                }else{
                    System.err.println("Ha habido un problema.");
                }}

                break;
            case 4:
        Pelicula[] pelis=videoteca.getPeliculas();
        // Cabecera: todas las etiquetas son Strings — usar %s para evitar IllegalFormatConversionException
        System.out.printf("|%10s|%10s|%10s %10s|%10s|%10s|%10s|%10s|%n",
            "TITULO","AÑO","NOMBRE","APELLIDOS","OSCAR","DURACION","TIEMPO1","VALORACION");
                for(Pelicula pelicula:pelis){
                    //OJO puede ser null
                    if(pelicula!=null){
                        System.out.println(pelicula.obtenerPeliculaComoFila(videoteca.getVelocidad()));
                    }
                }
                break;
            case 5:
                System.out.println("Gracias por usar la aplicaión. ¡Hasta luego!");
                // Borrar todas las películas de la videoteca antes de salir.
                videoteca.resetearVideoteca(videoteca.getPeliculas().length); 
                System.out.println("Todas las películas han sido borradas.");
                continuar=false;

                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción entre 1 y 5.");
                break;
        }
        }
    }

        
}
