import model.Empleado;
import model.Estudiante;
import utilities.AES;


import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("¿Eres estudiante o empleado?");
            System.out.println("Ingrese una opcion: ");
            System.out.println("1) Estudiante");
            System.out.println("2) Empleado");
            System.out.println("3) Salir");
            opcion = Integer.parseInt(sc.nextLine());
            if (opcion == 1) {
                Estudiante estudiante = new Estudiante();

                System.out.println("Ingrese su nombre: ");
                estudiante.setNombre(sc.nextLine());
                System.out.println("Ingrese su apellido: ");
                estudiante.setApellido(sc.nextLine());
                System.out.println("Ingrese su edad: ");
                estudiante.setEdad(Byte.parseByte(sc.nextLine()));
                System.out.println("Ingrese su matricula: ");
                estudiante.setMatricula(sc.nextLine());
                System.out.println("Ingrese su carrera: ");
                estudiante.setCarrera(sc.nextLine());
                //encriptar su matricula
                AES aes = new AES();
                String matriculaEncriptada = aes.encriptar(estudiante.getMatricula());
                estudiante.setMatricula(matriculaEncriptada);
                System.out.println("Matricula encriptada: " + matriculaEncriptada);
                System.out.println("Matricula desencriptada: " + aes.desencriptar(matriculaEncriptada));
                System.out.println(estudiante);
            }
            if (opcion == 2) {

                Empleado empleado = new Empleado();


                System.out.println("Ingrese su nombre: ");
                empleado.setNombre(sc.nextLine());
                System.out.println("Ingrese su apellido: ");
                empleado.setApellido(sc.nextLine());
                System.out.println("Ingrese su edad: ");
                empleado.setEdad(Byte.parseByte(sc.nextLine()));
                System.out.println("Ingrese su sueldo: ");
                empleado.setSueldo(Double.parseDouble(sc.nextLine()));
                System.out.println("Ingrese su clave");
                empleado.setClave((sc.nextLine()));
                System.out.println("¿Es activo?");
                //validar si la primera letra es si o no y convertirlo a booleano
                empleado.setActivo(sc.nextLine().equals("si") ? true : false);

                System.out.println(empleado);

                //encriptar su clave
                AES aes = new AES();
                String claveEncriptada = aes.encriptar(String.valueOf(empleado.getClave()));
                empleado.setClave((claveEncriptada));
                System.out.println("Clave encriptada: " + claveEncriptada);
                System.out.println("Clave desencriptada: " + aes.desencriptar(claveEncriptada));
                System.out.println(empleado);


            }


        }   while (opcion != 3) ;
        System.out.println("Gracias por usar el programa de encriptacion AES");

    }

    }
