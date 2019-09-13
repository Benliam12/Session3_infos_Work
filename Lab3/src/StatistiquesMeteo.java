import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by Benliam12 on 2019-09-04.
 */
public class StatistiquesMeteo
{
    public static void main(String[] args)
    {
        String fileName = "Lab3/meteo.txt";
        String line;
        int amountLine = 0;

        ArrayList<Mois> mois = new ArrayList<>();

        try
        {
            FileReader file = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(file);
            while((line = bufferedReader.readLine()) != null) {

                if(amountLine%2 == 0)
                {
                    String[] data = line.split(" ");
                    int days = Integer.parseInt(data[1]);
                    int[] temperatures = new int[days];

                    for(int i =0; i<days; i++)
                    {
                        temperatures[i] = (Integer.parseInt(data[4+i]));
                    }

                    Mois month = new Mois(data[0], days, temperatures);
                    mois.add(month);
                    month.calculateAverageTemp();
                }
                else
                {
                    Mois month = mois.get(mois.size()-1);
                    String[] data = line.split(" ");
                    int[] precipitations = new int[month.getDays()];

                    for(int i =0; i<month.getDays(); i++)
                    {
                        precipitations[i] = (Integer.parseInt(data[2+i]));
                    }
                    month.setPrecipitations(precipitations);
                    month.calculateAveragePrecipitations();
                }
                amountLine++;
            }

            bufferedReader.close();
        } catch(FileNotFoundException ex) {
            System.out.println("Impossible d'ouvrir le fichier");
        }catch(Exception ex)
        {
            System.out.println("Autre Erreur!!!");
            ex.printStackTrace();
        }

        System.out.printf("%-25s %15s %15s%n", " " , "Moyenne des", "Moyenne des");
        System.out.printf("%-25s %15s %15s%n%n", "Mois" , "températures", "précipitations");

        for(Mois month : mois)
        {
            System.out.printf("%-25s %15.2f %15.2f%n",month.getName(), month.getAvgTemp(),month.getAvgPrecipitations());
        }
    }
}
