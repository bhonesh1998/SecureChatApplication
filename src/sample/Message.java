package sample;

import java.io.Serializable;

/**
 * Make Serializable Object of the byte data
 */
public class Message implements Serializable
{
    private static final long serialVersionUID = 1L;
    private byte[] data;

    /**
     * Constructor Message
     * @param data
     */
    public Message (byte[] data)
    {
        this.data = data;
    }// end Message(byte[])

    /**
     * Method Name : getData()
     * Purpose : returns the byte array
     * @return
     */
    byte[] getData()
    {
        return data;
    }// end getData()

}// end Message() class