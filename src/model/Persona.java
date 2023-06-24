package model;

public class Persona{

    public String nombre;
    public String apellido;
    public byte edad;


    public Persona(String nombre, String apellido, byte edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;

    }

    public Persona() {
        this.nombre = "";
        this.apellido = "";
        this.edad = 0;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }


    @Override
    public String toString() {
        return
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad
               ;
    }
}