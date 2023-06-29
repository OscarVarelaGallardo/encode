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

                AES aes = new AES();

                String matriculaEncriptada = aes.encriptar(estudiante.getMatricula());
                estudiante.setMatricula(matriculaEncriptada);
                System.out.println("Cifrado con AES");
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

                empleado.setActivo(sc.nextLine().equals("si") ? true : false);

                System.out.println(empleado);

                String str = empleado.getClave();
                RSA rsa = new RSA();

                rsa.genKeyPair(512);


                String file_private = "/tmp/rsa.pri";
                String file_public = "/tmp/rsa.pub";

                rsa.saveToDiskPrivateKey("/tmp/rsa.pri");
                rsa.saveToDiskPublicKey("/tmp/rsa.pub");

                String secure = rsa.Encrypt(str);
                System.out.println("Cifrado RSAE ");
                System.out.println("\nCifrado:");
                System.out.println(secure);


                RSA rsa2 = new RSA();

                rsa2.openFromDiskPrivateKey("/tmp/rsa.pri");
                rsa2.openFromDiskPublicKey("/tmp/rsa.pub");

                String unsecure = rsa2.Decrypt(secure);

                System.out.println("\nDescifrado:");

                System.out.println(unsecure);





            }


        }   while (opcion != 3) ;
        System.out.println("Gracias por usar el programa de encriptacion AES y RSA");

    }

    }
