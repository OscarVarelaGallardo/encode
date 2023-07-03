package utilities;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class AES {
    private static final String clave = "ing-23IA-dma-920";

    private static final String algoritmo = "AES";

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

    public String encriptar(String matricula) {
        try {
            return cifrar(matricula);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String desencriptar(String matriculaEncriptada) {
        try {
            return descifrar(matriculaEncriptada);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
