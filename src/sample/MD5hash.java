package sample;

import java.security.*;

/**
 * MD5 hash generator class
 */
public class MD5hash
{
    /**
     * Method Name : getMD5
     * Purpose : Generate the MD5 String of the recieved message
     *
     * @param input - recieved message
     * @return - Generated MD5 Hash String
     *
     * @throws NoSuchAlgorithmException
     */
    public static String getMD5(String input) throws NoSuchAlgorithmException
    {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] data = input.getBytes();

        messageDigest.update(data, 0, data.length);

        byte[] mdbytes = messageDigest.digest();
        String hash = new String(mdbytes);
        return hash;
    }

}
