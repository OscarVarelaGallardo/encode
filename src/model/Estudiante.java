package model;


import utilities.AES;

public class Estudiante extends Persona

{
    private String matricula;
    private String carrera;



    public Estudiante(final String nombre, final String apellido, final byte edad, final String password, final String matricula, final String carrera) {
        super(nombre, apellido, edad ,password);
        this.matricula = matricula;
        this.carrera = carrera;
    }


    public Estudiante() {
        super();
        this.matricula = "";
        this.carrera = "";

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(final String matricula) {
        this.matricula = matricula;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(final String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {

        return
                super.toString() +
                "Estudiante{" +
                "matricula='" + matricula + '\'' +
                ", carrera='" + carrera + '\'' +
                '}';
    }


}
