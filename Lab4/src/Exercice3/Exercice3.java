package Exercice3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Exercice3
{
    public static void main(String[] args)
    {
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
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
