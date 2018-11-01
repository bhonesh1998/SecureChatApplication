package sample;

import java.io.*;
import java.nio.file.Files;

/**
 * Class to Save data into the File
 */
public class SaveKeyFile
{
    /**
     * Method Name : ReadFile
     * Purpose : Read the content from the file in byte form
     *
     * @param filename - file from which data to be recieved
     * @return - byte form of the file content
     */
    public static byte[] ReadFile(String filename)
    {
        byte[] readByte = null;
        try {
            // Get the file content in byte form
            readByte = Files.readAllBytes(new File(filename).toPath());
        } catch (Exception e) {
            System.out.println("ReadFile error");
        }// end try/catch

        // return byte form
        return readByte;

    }// end ReadFile(String)

    /**
     * Method Name : WriteFile
     * Purpose : byte form to be written into the file given
     *
     * @param filename - name of the file
     * @param bytecode - byte form to be written
     */
    public static void WriteFile(String filename, byte[] bytecode)
    {
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(filename);
            fos.write(bytecode);

            if (fos != null) fos.close();
        }
        catch (Exception e) {
            System.out.println("WriteFile error");
        }// try/catch

    }// end WriteFile(String, byte[])

}// end SaveKeyFile
