package utilities;

import java.security.*;
import java.util.Base64;

public class SignatureExample {

    public static void main(String[] args) throws Exception {

        String data = "OscarinElmasCrack";

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

        keyPairGenerator.initialize(2048);

        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        PrivateKey privateKey = keyPair.getPrivate();

        PublicKey publicKey = keyPair.getPublic();

        Signature signature = Signature.getInstance("SHA256withRSA");

        signature.initSign(privateKey);

        signature.update(data.getBytes());

        byte[] digitalSignature = signature.sign();

        Signature verification = Signature.getInstance("SHA256withRSA");

        verification.initVerify(publicKey);

        verification.update(data.getBytes());

        boolean isVerified = verification.verify(digitalSignature);

        System.out.println("Texto original: " + data);

        System.out.println("Firma digital: " + Base64.getEncoder().encodeToString(digitalSignature));

        System.out.println("La firma es válida: " + isVerified);

    }
}
