package modelo;

public class Videoteca {
    
    private Pelicula[] peliculas;
    private int contadorPeliculas;
    private float velocidad;

    public int getContadorPeliculas() {
        return contadorPeliculas;
    }

    public void setContadorPeliculas(int contadorPeliculas) {
        this.contadorPeliculas = contadorPeliculas;
    }

    public float getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }

    public int getContador() {
        return contadorPeliculas;
    }

    public void setContador(int contador) {
        this.contadorPeliculas = contador;
    }

    public Videoteca(int numPeliculas) {
        velocidad = 1.0f; // Velocidad por defecto
        contadorPeliculas = 0;
        peliculas = new Pelicula[numPeliculas];
        
    }

    //MÉTODOS DE LÓGICA DE NEGOCIO (CREW)
    public boolean addPelicula(Pelicula p){
        if(!isFull()){
            peliculas[contadorPeliculas]=p;
            contadorPeliculas++;
            return true;
        }else{
            return false;
        }
    }

    public boolean isFull(){
        if(peliculas.length==contadorPeliculas){
            return true;
        }else{
            return false;
        }

    }

    public Pelicula[] getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(Pelicula[] peliculas) {
        this.peliculas = peliculas;
    }

    public void resetearVideoteca(int numPeliculas) {
        peliculas = new Pelicula[numPeliculas];
        contadorPeliculas = 0;
    }
    
}
