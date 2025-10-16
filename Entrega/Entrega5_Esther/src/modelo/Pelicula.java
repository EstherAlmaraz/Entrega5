package modelo;

public class Pelicula {
    private String titulo;
    private int anioEstreno;
    private int duracionMinutos;
    private float valoracion;
    private Director director;

    
    public Pelicula(String titulo, int anioEstreno, int duracionMinutos, float valoracion, Director director) {
        this.titulo = titulo;
        this.anioEstreno = anioEstreno;
        this.duracionMinutos = duracionMinutos;
        this.valoracion = valoracion;
        this.director = director;
    }

    public static Pelicula crearPeliculaDatosCrudos(String titulo, int anioEstreno, int duracionMinutos, float valoracion, String nombreDirector, String apellidosDirector, boolean oscarganado) {
        Director director = new Director(nombreDirector, apellidosDirector, oscarganado);

        Pelicula pelicula=new Pelicula(titulo, anioEstreno, duracionMinutos, valoracion, director);

        return pelicula;
    }

    public String obtenerPeliculaComoFila(float velocidad){
        return String.format ("|%10s|%10d|%10s %10s|%10s|%10d|%10.2f|%10.2f|",
        titulo,anioEstreno,director.getNombre(),director.getApellidos(),director.haGanadoOscar(),duracionMinutos,duracionMinutos/velocidad,valoracion);
    }

 






    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setAnioEstreno(int anioEstreno) {
        this.anioEstreno = anioEstreno;
    }
    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }
    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }
    public void setDirector(Director director) {
        this.director = director;
    }

    public String getTitulo() {
        return titulo;
    }
    public int getAnioEstreno() {
        return anioEstreno;
    }
    public int getDuracionMinutos() {
        return duracionMinutos;
    }
    public float getValoracion() {
        return valoracion;
    }
    public Director getDirector() {
        return director;
    }

    
}
