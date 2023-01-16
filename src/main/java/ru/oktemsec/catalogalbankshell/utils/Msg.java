package ru.oktemsec.catalogalbankshell.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Msg
{
    static String cp = System.getProperty("console.encoding","Cp866");
    public static void print(String msg) throws IOException {
        msg += "\n";
        byte[] b;
        try { b = msg.getBytes(cp); }
        catch( UnsupportedEncodingException e )
        {
            b = msg.getBytes();       // В случае отсутствия нужной кодировки,
            // делаем преобразование по умолчанию
        }
        System.out.write(b);
    }
}
