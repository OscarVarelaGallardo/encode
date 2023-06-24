package model;

public class Empleado extends Persona {

    private String clave;
    private double sueldo;

    public Empleado(final String nombre, final String apellido, final byte edad, final String clave, final double sueldo, final boolean activo) {
        super(nombre, apellido, edad);
        this.clave = clave;
        this.sueldo = sueldo;
        this.activo = activo;
    }

    public Empleado() {

    }

    public String getClave() {
        return clave;
    }

    public void setClave(final String clave) {
        this.clave = clave;
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

    private boolean activo;

    @Override
    public String toString() {
        return
                super.toString() +
                "Empleado{" +
                "clave='" + clave + '\'' +
                ", sueldo=" + sueldo +
                ", activo=" + activo +
                '}';
    }
}
