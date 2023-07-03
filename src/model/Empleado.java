package model;

public class Empleado extends Persona {


    private double sueldo;

    private String puesto;

    public Empleado(final String nombre, final String apellido,final String puesto,  final byte edad, final String password,  final double sueldo, final boolean activo) {
        super(nombre, apellido, edad, password);

        this.sueldo = sueldo;
        this.activo = activo;

    }

    public Empleado() {

    }



    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(final double sueldo) {
        this.sueldo = sueldo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(final boolean activo) {
        this.activo = activo;
    }

    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(final String puesto) {
        this.puesto = puesto;
    }

    private boolean activo;

    @Override
    public String toString() {
        return
                super.toString() +
                "Empleado{"  +
                ", sueldo=" + sueldo +
                ", activo=" + activo +
                        ", puesto='" + puesto + '\'' +
                '}';
    }
}
