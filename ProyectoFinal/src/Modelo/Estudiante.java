package Modelo;

public class Estudiante {

    private final String nombre;
    private final String apellidoP;
    private final String apellidoM;
    private final String genero;
    private final String Carrera;


    public Estudiante(String nombre, String apellidoP, String apellidoM, String genero, String carrera) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.genero = genero;
        this.Carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public String getGenero() {
        return genero;
    }

    public String getCarrera() {
        return Carrera;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", apellidoP='" + apellidoP + '\'' +
                ", apellidoM='" + apellidoM + '\'' +
                ", genero='" + genero + '\'' +
                ", Carrera='" + Carrera + '\'' +
                '}';
    }


}
