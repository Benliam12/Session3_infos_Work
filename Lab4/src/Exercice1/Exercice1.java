package Exercice1;

import javax.swing.*;
import java.io.*;


public class Exercice1
{
    public static void main(String[] args)
    {
        int youBadAtEnteringGoodFile = 0;

        while(youBadAtEnteringGoodFile < 3)
        {
            String fileName = JOptionPane.showInputDialog("Veuillez entrer le nom du fichier :");
            fileName += ".txt";
            try
            {
                FileReader fileReader = new FileReader("Lab4/"+fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                FileWriter fileWriter = new FileWriter("Lab4/sortie"+fileName);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                String line;
                double sum =0;

                while((line = bufferedReader.readLine()) != null)
                {
                    String[] numbers = line.split(" ");
                    for(String number : numbers)
                    {
                        try
                        {
                            sum += Double.parseDouble(number);
                        } catch (NumberFormatException ex)
                        {
                            System.out.println(number + " n'est pas un nombre =(");
                        }
                    }
                }
                bufferedWriter.write(Double.toString(sum));
                bufferedWriter.close();
                break;
            }
            catch(IOException ex)
            {
                youBadAtEnteringGoodFile++;
                System.out.println("Veuillez entrer un fichier valide! (" + (3-youBadAtEnteringGoodFile) + " tentative(s) restante(s))");
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            System.out.println(fileName);
        }

        if(youBadAtEnteringGoodFile == 3)
            System.out.println("YOU BAD AF");
    }

}
