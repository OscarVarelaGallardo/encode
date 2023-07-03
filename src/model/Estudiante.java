package model;



public class Estudiante extends Persona

{
    private String matricula;
    private String carrera;





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
                ", matricula='" + matricula + '\'' +
                ", carrera='" + carrera + '\''
                ;
    }


}
