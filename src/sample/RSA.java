package sample;

import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.*;

/**
 * RSA Algorithm Class to Generate Public and Private Key Pair
 */
public class RSA {

    Key publicKey;  // PublicKey Generated
    Key privateKey; // PrivateKey Generated

    /**
     * Method Name : createRSA
     * Purpose : Generate PublicKey and Private Key required for the RSA Encryption Decryption
     *
     * @throws NoSuchAlgorithmException
     * @throws GeneralSecurityException
     * @throws IOException
     */
    public void createRSA() throws NoSuchAlgorithmException, GeneralSecurityException, IOException{

        KeyPairGenerator kPairGen = KeyPairGenerator.getInstance("RSA");
        kPairGen.initialize(1024);
        KeyPair kPair = kPairGen.genKeyPair();
        publicKey = kPair.getPublic();      // Get PublicKey from the generated KeyPair
        System.out.println(publicKey);
        privateKey = kPair.getPrivate();    // Get PrivateKey from the generated KeyPair

        KeyFactory fact = KeyFactory.getInstance("RSA");
        RSAPublicKeySpec pub = fact.getKeySpec(kPair.getPublic(), RSAPublicKeySpec.class);
        RSAPrivateKeySpec priv = fact.getKeySpec(kPair.getPrivate(), RSAPrivateKeySpec.class);
        serializeToFile("public.key", pub.getModulus(), pub.getPublicExponent());       // Store PublicKey
        serializeToFile("private.key", priv.getModulus(), priv.getPrivateExponent());   // Store Privatekey

    }// end createRSA()

    /**
     * Method Name : serializeToFile
     * Purpose : Store Key in their respective file if not exist
     *
     * @param fileName - Filename
     * @param mod - Modulo value of the Key generated
     * @param exp - exponent value of the Key generated
     *
     * @throws IOException
     */
    public void serializeToFile(String fileName, BigInteger mod, BigInteger exp) throws IOException {
        ObjectOutputStream ObjOut = new ObjectOutputStream( new BufferedOutputStream(new FileOutputStream(fileName)));

        try {
            ObjOut.writeObject(mod);
            ObjOut.writeObject(exp);
            System.out.println("Key File Created: " + fileName);
        } catch (Exception e) {
            throw new IOException(" Error while writing the key object", e);
        } finally {
            ObjOut.close();
        }// end try/catch
    }// end serializeToFile(String, BigInteger, BigInteger)

}// end RSA class
