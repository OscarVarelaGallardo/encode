package utilities;// Importa la clase KeyPair del paquete java.security, que representa un par de claves pública y privada.

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.KeyPair;

// Importa la clase KeyPairGenerator del paquete java.security, que se utiliza para generar pares de claves. 

import java.security.KeyPairGenerator;

//Importa la clase PrivateKey del paquete java.security, que representa una clave privada. 

import java.security.PrivateKey;

// Importa la clase PublicKey del paquete java.security, que representa una clave pública. 

import java.security.PublicKey;

//Importa la clase Signature del paquete java.security, que se utiliza para generar y verificar firmas digitales. 

import java.security.Signature;

// Importa la clase Base64 del paquete java.util, que se utiliza para codificar y decodificar datos en formato Base64. 

import java.util.Base64;
import java.util.Scanner;


// Declara una clase pública llamada EjemploRSA

public class RSAE{

    // Declara una constante de tipo String llamada algorithm y la inicializa con el valor "RSA". 

    //Esta constante representa el algoritmo de criptografía RSA. 

    private static final String algoritmo = "RSA";

    // Declara una constante de tipo String llamada data y la inicializa con el valor "texto a cifrar". 

    //Esta constante representa los datos que se desean firmar y verificar. 

    private static final String dato = "texto a cifrar"; 

  

    /* 

    Declara un método estático llamado sign que toma como parámetros una PrivateKey y un arreglo de bytes data, y devuelve un arreglo de bytes. Este método se utiliza para firmar los datos utilizando la clave privada. 

    */

    public static byte[] firmar(PrivateKey llavePrivada, byte[] datos) throws Exception {

        // Crea una instancia de la clase Signature utilizando el algoritmo "SHA256withRSA". 

        // Esta instancia se utiliza para generar la firma digital. 

        Signature signature = Signature.getInstance("SHA256withRSA");

        // Inicializa la firma con la clave privada especificada. 

        signature.initSign(llavePrivada);

        //Actualiza la firma con los datos especificados. 

        signature.update(datos);

        // Genera la firma digital y la devuelve como un arreglo de bytes. 

        return signature.sign();

    } 

  

    /* 

    Declara un método estático llamado verify que toma como parámetros una PublicKey, un arreglo de bytes data y un arreglo de bytes signature, y devuelve un valor booleano. Este método se utiliza para verificar la firma digital utilizando la clave pública. 

    */

    public static boolean verificar(PublicKey llavePublica, byte[] datos, byte[] firma) throws Exception {

        // Crea una instancia de la clase Signature utilizando el algoritmo "SHA256withRSA". 

        //Esta instancia se utiliza para verificar la firma digital. 

        Signature sig = Signature.getInstance("SHA256withRSA");

        // Inicializa la verificación de la firma con la clave pública especificada. 

        sig.initVerify(llavePublica);

        // Actualiza la verificación con los datos especificados. 

        sig.update(datos);

        // Verifica la firma digital y devuelve true si la firma es válida, o false en caso contrario. 

        return sig.verify(firma);

    }



    // Declara el método main, que es el punto de entrada del programa. 

    public static void main(String[] args) throws Exception {

        // Crea una instancia de la clase KeyPairGenerator utilizando el algoritmo especificado en la constante `algorithm`. 

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algoritmo);

        // Inicializa el generador de pares de claves con una longitud de clave de 2048 bits. 

        keyPairGenerator.initialize(2048);

        // Genera un par de claves pública y privada utilizando el generador de pares de claves. 

        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Obtiene la clave privada del par de claves generado. 

        PrivateKey llavePrivada = keyPair.getPrivate();

        // Obtiene la clave pública del par de claves generado. 

        PublicKey llavePublica = keyPair.getPublic();



        System.out.println("Public Key: " + llavePublica);

        System.out.println("Private Key: " + llavePrivada);



        // Genera la firma digital de los datos utilizando la clave privada. 

        byte[] firma= firmar(llavePrivada, dato.getBytes());

        // Verifica la firma digital utilizando la clave pública y los datos originales. 

        boolean esVerificada = verificar(llavePublica, dato.getBytes(), firma);



        //Imprime el texto original. 

        System.out.println("Texto original: " + dato);

        // Imprime la firma digital codificada en formato Base64. 

        System.out.println("Firma digital: " + Base64.getEncoder().encodeToString(firma));

        //Imprime si la firma es válida o no. 

        System.out.println("La firma es válida: " + esVerificada);



    }


    public static class AES {

        private static final String clave = "ing-23IA-dma-920";

        private static final String algoritmo = "utilities.RSAE.AES";

        // Define el método que cifra los datos

        public static String cifrar(String dato) throws Exception {

            // Crea una instancia de SecretKeySpec utilizando

            // la clave secreta y el algoritmo especificados

            SecretKeySpec sks = new SecretKeySpec(clave.getBytes(), algoritmo);

            // Crea una instancia de Cipher utilizando el algoritmo especificado

            Cipher cip = Cipher.getInstance(algoritmo);

            // Inicializa el cifrador en modo de cifrado utilizando la clave secreta

            cip.init(Cipher.ENCRYPT_MODE, sks);

            // Cifra los datos utilizando el método doFinal de la clase Cipher

            // y los almacena en un arreglo de bytes

            byte[] datoEncriptado = cip.doFinal(dato.getBytes());

            // Codifica los datos cifrados en formato Base64 y

            // los devuelve como una cadena de texto

            return Base64.getEncoder().encodeToString(datoEncriptado);

        }

        // Define el método que descifra los datos cifrados

        public static String descifrar(String datoCifrado) throws Exception {

            // Crea una instancia de SecretKeySpec utilizando

            // la clave secreta y el algoritmo especificados

            SecretKeySpec sks = new SecretKeySpec(clave.getBytes(), algoritmo);

            // Crea una instancia de Cipher utilizando el algoritmo especificado

            Cipher cip = Cipher.getInstance(algoritmo);

            // Inicializa el cifrador en modo de descifrado utilizando la clave secreta

            cip.init(Cipher.DECRYPT_MODE, sks);

            // Descifra los datos utilizando el método doFinal de la calse Cipher

            // y los almacena en un arreglo de bytes

            byte[] datoDecifrado = cip.doFinal(Base64.getDecoder().decode(datoCifrado));

            // Convierte los datos descifrados de bytes a una cadena de texto y los devuelve

            return new String(datoDecifrado);

        }

        // El código principal de la clase

        public static void main(String[] args) throws Exception {

            // Define una cadena de texto original a cifrar

            // String original = "Prueba cifrar";

            // Crea una instancia de Scanner para acceder a teclado

            Scanner sca = new Scanner(System.in);

            // solicita la cadena desde teclado y almacena en variable original

            System.out.println("Ingresa cadena a cifrar:");

            String original = sca.nextLine();

            // Cifra la cadena de texto original utilizando el método cifrar

            // y almacena el resultado en una variable

            String cifrado = cifrar(original);

            // Descifra los datos cifrados utilizando el método descifrar y

            // almacena el resultado en una variable

            String descifrado = descifrar(cifrado);

            // Muestra en consola el texto original

            System.out.println("Texto original: " + original);

            // Muestra en consola el texto cifrado

            System.out.println("Texto cifrado: " + cifrado);

            // Muestra en consola el texto descifrado

            System.out.println("Texto descifrado: " + descifrado);

        }

    }
}