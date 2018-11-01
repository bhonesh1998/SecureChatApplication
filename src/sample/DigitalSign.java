package sample;

import java.security.*;

public class DigitalSign {

    /**
     * Method Name : getSign
     * Purpose : Get the digital signature of the message recieved from server/client
     *
     * @param str - recieved message
     * @param pkey - Private key used for the RSA Encryption of the message recieved
     *
     * @return - digital signature in byte form
     *
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws SignatureException
     */
    public static byte[] getSign(String str,PrivateKey pkey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException{
        String md5hash= MD5hash.getMD5(str);
        byte[] data=md5hash.getBytes();
        Signature Sign=Signature.getInstance("SHA1withRSA");
        Sign.initSign(pkey,new SecureRandom());
        Sign.update(data);
        byte[] signByte=Sign.sign();
        return signByte;
    }// end getSign(String, PrivateKey)

    /**
     * Method Name : verifySign
     * Purpose : Check whether the recieved message and the digitalSignature created by the other end is same or not
     *
     * @param str - message to be verified
     * @param pkey - Public Key used for the RSA Decryption of the recieved message
     * @param data - digital signature created by the other end
     *
     * @return - true if the digital signature matched with the str messaged recieved
     *
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws SignatureException
     */
    public static boolean verifySign(String str,PublicKey pkey,byte[] data) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {

        String md5hash=MD5hash.getMD5(str);
        byte[] hash=md5hash.getBytes();
        Signature Sign=Signature.getInstance("SHA1withRSA");
        Sign.initVerify(pkey);
        Sign.update(hash);
        boolean result = Sign.verify(data);
        return result;
    }// end verifySign(String, PublicKey, byte[])
}
