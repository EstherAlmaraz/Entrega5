package modelo;

public class Director {
    private String nombre;
    private String apellidos;
    private boolean oscarganado;

    public Director(String nombre, String apellidos, boolean oscarganado) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.oscarganado = oscarganado;
    }

    public String haGanadoOscar(){
        if(oscarganado){
            return "Sí";
        }else{
            return "No";
        }
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setOscarganado(boolean oscarganado) {
        this.oscarganado = oscarganado;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public boolean isOscarganado() {
        return oscarganado;
    }

}
