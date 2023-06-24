package service;
import model.Empleado;

public class EmpleadoService {
        public static double generarBono(Empleado empleado){
            double  bono = 0.0;
            if(empleado.getEdad()>55 && empleado.isActivo()){
                bono = empleado.getSueldo()*0.23;
            }

            return bono;
        };
    }

