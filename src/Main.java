import model.Empleado;
import model.Estudiante;
import utilities.AES;
import utilities.RSA;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidKeySpecException, IOException, NoSuchProviderException {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do{
            System.out.println("Bienvenido al sistema de creación de contraseñas seguras");
            System.out.println("Manten tus contraseñas seguras y privadas");
            System.out.println("Ingrese el tipo de usuario que desea crear: 1,2,3 ");
            System.out.println("1. Estudiante");
            System.out.println("2. Empleado");
            System.out.println("3. Desencryptar contraseña AES/RSA ");
            System.out.println("4. Salir");
            opcion = sc.nextInt();

           switch (opcion) {

               case 1:
                   Estudiante estudiante = new Estudiante();
                   do {
                       System.out.println("Ingrese el nombre del estudiante");
                       String nombre = sc.next();
                       if (nombre.length() < 3) {
                           System.out.println("El nombre debe tener al menos 3 caracteres");

                       }
                       estudiante.setNombre(nombre);

                   } while (estudiante.getNombre().length() < 3);
                   do {
                       System.out.println("Ingrese el apellido del estudiante");
                       String apellido = sc.next();
                       if (apellido.length() < 3) {
                           System.out.println("El apellido debe tener al menos 3 caracteres");

                       }
                       estudiante.setApellido(apellido);

                   } while (estudiante.getApellido().length() < 3);

                   do {
                       System.out.println("Ingrese la edad del estudiante");
                       int edad = sc.nextInt();
                       if (edad < 18) {
                           System.out.println("El estudiante debe ser mayor de edad");

                       }
                       estudiante.setEdad((byte) edad);
                   } while (estudiante.getEdad() < 18);

                   do {
                       System.out.println("Ingrese la carrera del estudiante");
                       String carrera = sc.next();
                       if (carrera.length() < 3) {
                           System.out.println("La carrera debe tener al menos 3 caracteres");

                       }
                       estudiante.setCarrera(carrera);
                   } while (estudiante.getCarrera().length() < 3);

                   do {
                       System.out.println("Ingresa la matricula del estudiante");
                       String matricula = sc.next();
                       if (matricula.length() < 3) {
                           System.out.println("La matricula debe tener al menos 3 caracteres");

                       }
                       estudiante.setMatricula(matricula);
                   } while (estudiante.getMatricula().length() < 3);
                   int tipo;
                   do {
                       System.out.println("¿Que tipo de contraseña requieres?");
                       System.out.println("AES digite 1");
                       System.out.println("RSA digite 2");
                       tipo = sc.nextInt();
                   } while (1 == tipo && tipo == 2);

                   switch (tipo) {
                       case 1:
                           AES aes = new AES();
                           System.out.println("Ingrese la contraseña  a encriptar AES");
                           String password = sc.next();
                           estudiante.setPassword(password);
                           System.out.println("La contraseña del estudiante AES es: " + aes.encriptar(estudiante.getPassword()));
                           System.out.println("Tus datos son: " + estudiante.toString());
                           break;

                       case 2:

                           String password2 = "";
                           do {
                               System.out.println("Ingrese la contraseña a encriptar la contraseña debe tener al menos 8 caracteres");
                               password2 = sc.next();

                           } while (password2.length() < 8);
                           estudiante.setPassword(password2);
                           RSA rsa = new RSA();
                           rsa.genKeyPair(512);
                           String file_private = "/tmp/rsa.pri";
                           String file_public = "/tmp/rsa.pub";

                           rsa.saveToDiskPrivateKey("/tmp/rsa.pri");
                           rsa.saveToDiskPublicKey("/tmp/rsa.pub");

                           String secured = rsa.Encrypt(estudiante.getPassword());
                           System.out.println("La contraseña del estudiante es: " + secured);
                           System.out.println("Tus datos son: " + estudiante.toString());


                           break;


                       default:
                           System.out.println("Opción no válida");
                           break;
                   }
                   break;
               case 2:
                   Empleado empleado = new Empleado();
                    do {

                   System.out.println("Ingrese el nombre del empleado");
                   String nombre2 = sc.next();
                   if(nombre2 == null || nombre2.length() < 3){
                       System.out.println("El nombre debe tener al menos 3 caracteres");
                   }
                     empleado.setNombre(nombre2);
                     }while (empleado.getNombre().length() < 3);

                    do {
                        System.out.println("Ingrese el apellido del empleado");
                        String apellido2 = sc.next();
                        if (apellido2 == null || apellido2.length() < 3) {
                            System.out.println("El apellido debe tener al menos 3 caracteres");
                        }
                        empleado.setApellido(apellido2);
                    }while (empleado.getApellido().length() < 3);

                    do {

                        System.out.println("Ingrese la edad del empleado");
                        byte edad2 = sc.nextByte();

                        if (edad2 < 18) {
                            System.out.println("El empleado debe ser mayor de edad");
                        }

                        empleado.setEdad(edad2);
                    }while (empleado.getEdad() < 18);

                    do{
                   System.out.println("Ingrese el puesto del empleado");
                   String puesto = sc.next();
                     if(puesto == null || puesto.length() < 3){
                          System.out.println("El puesto debe tener al menos 3 caracteres");
                     }
                   empleado.setPuesto(puesto);
                    }while (empleado.getPuesto().length() < 3);

                    do{
                   System.out.println("Ingrese el salario del empleado");
                   double salario = sc.nextDouble();
                        if(salario < 0){
                            System.out.println("El salario debe ser mayor a 0");
                        }

                   empleado.setSueldo(salario);
                    }while (empleado.getSueldo() < 0);

                    do{
                   System.out.println("Ingrese la contraseña del empleado debe tener al menos 8 caracteres");
                   String password3 = sc.next();
                        if(password3 == null || password3.length() < 8){
                            System.out.println("La contraseña debe tener al menos 8 caracteres");
                        }
                   empleado.setPassword(password3);
                    }while (empleado.getPassword().length() < 8);

                    do{
                   System.out.println("¿Es activo el empleado?");
                   System.out.println("Si digite 1");
                   System.out.println("No digite 2");

                   int activo = sc.nextInt();
                        if (activo == 1) {
                            empleado.setActivo(true);
                        } else if (activo == 2){
                            empleado.setActivo(false);
                        } else {
                            System.out.println("Opción no válida");
                        }
                    }while (empleado.isActivo() == false && empleado.isActivo() == true);


                   System.out.println("¿Que tipo de contraseña requieres?");
                   System.out.println("AES digite 1");
                   System.out.println("RSA digite 2");
                   int tipo3 = sc.nextInt();  // 1 AES 2 RSA

                   switch (tipo3) {
                       case 1:
                           AES aes = new AES();
                           System.out.println("La contraseña del empleado es: " + aes.encriptar(empleado.getPassword()));
                           System.out.println("Tus datos son: " + empleado.toString());
                           break;

                       case 2:
                           RSA rsa = new RSA();
                           rsa.genKeyPair(512);
                           String file_private = "/tmp/rsa.pri";
                           String file_public = "/tmp/rsa.pub";

                           rsa.saveToDiskPrivateKey("/tmp/rsa.pri");
                           rsa.saveToDiskPublicKey("/tmp/rsa.pub");

                           String secured = rsa.Encrypt(empleado.getPassword());
                           System.out.println("La contraseña del estudiante es: " + secured);
                           System.out.println("Tus datos son: " + empleado.toString());
                   }

                   break;
               case 3:
                   String password = "";

                   System.out.println("Ingrese la contraseña a desencriptar");
                   password = sc.next();


                   int tipo2 = 0;
                   do{
                   System.out.println("¿Que tipo de contraseña requieres?");
                   System.out.println("AES digite 1");
                   System.out.println("RSA digite 2");
                    tipo2 = sc.nextInt();
                    if (tipo2 != 1 && tipo2 != 2){
                        System.out.println("Opción no válida");
                    }
                        }while (tipo2 != 1 && tipo2 != 2);


                   switch (tipo2) {
                       case 1:
                           AES aes = new AES();
                           System.out.println("La contraseña desencriptada AES es: " + aes.desencriptar(password));
                           break;

                       case 2:
                           RSA rsa = new RSA();
                           rsa.openFromDiskPrivateKey("/tmp/rsa.pri");
                           rsa.openFromDiskPublicKey("/tmp/rsa.pub");
                           String unsecure = rsa.Decrypt(password);
                           System.out.println("La contraseña desencriptada RSA  es: " + unsecure);

                           break;
                   }
               case 4:
                   System.out.println("Gracias por usar el sistema de encriptación");
                   System.out.println("Mantenga su contraseña segura");
                   System.exit(0);
                   break;

               default:
                   System.out.println("Opción no válida");
                   break;
           }


        }
        while (
                opcion != 4
        );
    }



    }
