package Exercice3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Exercice3
{
    public static void main(String[] args) {

        BufferedReader patate = null;
        try
        {
            if(args.length == 2)
            {
                String source = args[0];
                String target = args[1];

                FileOutputStream file = new FileOutputStream("Lab4/"+target);
                Files.copy(Paths.get("Lab4/"+source), file);
                file.close();

                System.out.println("CONGRADULATION");
            }
            else
            {
                System.out.println("Les arguments ne sont pas valide =(");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
