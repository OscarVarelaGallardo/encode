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

                   System.out.println("Ingrese el nombre del estudiante");
                   String nombre = sc.next();
                   estudiante.setNombre(nombre);

                   System.out.println("Ingrese el apellido del estudiante");
                   String apellido = sc.next();
                   estudiante.setApellido(apellido);

                   System.out.println("Ingrese la edad del estudiante");
                   byte edad = sc.nextByte();
                   estudiante.setEdad(edad);

                   System.out.println("Ingrese la carrera del estudiante");
                   String carrera = sc.next();
                   estudiante.setCarrera(carrera);

                   System.out.println("Ingrese la matricula del estudiante");
                   String matricula = sc.next();
                   estudiante.setMatricula(matricula);

                   System.out.println("¿Que tipo de contraseña requieres?");
                   System.out.println("AES digite 1");
                   System.out.println("RSA digite 2");
                   int tipo = sc.nextInt();  // 1 AES 2 RSA

                     switch (tipo) {
                            case 1:
                                AES aes = new AES();
                                System.out.println("Ingrese la contraseña  a encriptar");
                                String password = sc.next();
                                estudiante.setPassword(password);
                                System.out.println("La contraseña del estudiante es: " + aes.encriptar(estudiante.getPassword()));
                                System.out.println("Tus datos son: " + estudiante.toString());
                                break;

                          case 2:

                                String password2 = "";
                                do{
                                    System.out.println("Ingrese la contraseña a encriptar la contraseña debe tener al menos 8 caracteres");
                                    password2 = sc.next();

                                }while(password2.length() < 8);
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

                    System.out.println("Ingrese el nombre del empleado");
                    String nombre2 = sc.next();
                    empleado.setNombre(nombre2);

                    System.out.println("Ingrese el apellido del empleado");
                    String apellido2 = sc.next();
                    empleado.setApellido(apellido2);

                    System.out.println("Ingrese la edad del empleado");
                    byte edad2 = sc.nextByte();
                    empleado.setEdad(edad2);

                    System.out.println("Ingrese el puesto del empleado");
                    String puesto = sc.next();
                    empleado.setPuesto(puesto);

                    System.out.println("Ingrese el salario del empleado");
                    double salario = sc.nextDouble();
                    empleado.setSueldo(salario);

                    System.out.println("Ingrese la contraseña del empleado");
                    String password3 = sc.next();
                    empleado.setPassword(password3);

                    System.out.println("¿Es activo el empleado?");
                    System.out.println("Si digite 1");
                    System.out.println("No digite 2");
                    int activo = sc.nextInt();

                    if (activo == 1) {
                        empleado.setActivo(true);
                    } else {
                        empleado.setActivo(false);
                    }

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
                            System.out.println("La contraseña del empleado es: " + rsa.encrypt(empleado.getPassword()));
                            System.out.println("Tus datos son: " + empleado.toString());
                            break;
                    }

                    break;
                case 3:
                    System.out.println("Ingrese la contraseña a desencriptar");
                    String password = sc.next();
                    System.out.println("¿Que tipo de contraseña requieres?");
                    System.out.println("AES digite 1");
                    System.out.println("RSA digite 2");
                    int tipo2 = sc.nextInt();  // 1 AES 2 RSA

                    switch (tipo2) {
                        case 1:
                            AES aes = new AES();
                            System.out.println("La contraseña desencriptada es: " + aes.desencriptar(password));
                            break;

                        case 2:
                            RSA rsa = new RSA();

                            rsa.openFromDiskPrivateKey("/tmp/rsa.pri");
                            rsa.openFromDiskPublicKey("/tmp/rsa.pub");
                            String unsecure = rsa.Decrypt(password);

                            System.out.println("La contraseña desencriptada es: " + unsecure);

                            break;
                    }
                case 4:
                    System.out.println("Gracias por usar el sistema");
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
