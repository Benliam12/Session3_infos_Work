import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Benliam12 on 2019-09-04.
 */
public class Mois
{
    protected String name;
    protected int amountDays;
    protected int meteoData[][];
    protected double avgTemp = 0;
    protected double avgPrecipitations = 0;

    /**
     * @param name Nom du mois
     * @param amountDays Nombre du jours du mois
     * @param temperatures Tableau de temperature du mois
     */
    public Mois(String name, int amountDays, int[] temperatures)
    {
        this.name = name;
        this.amountDays = amountDays;
        this.meteoData = new int[2][amountDays];
        this.meteoData[0] = temperatures;
    }

    /**
     * @return Nombre de jours
     */
    public int getDays()
    {
        return this.amountDays;
    }

    /**
     * @return Nom du mois
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @return Temperature moyenne. Renvoie 0 par defaut.
     */
    public double getAvgTemp()
    {
        return this.avgTemp;
    }

    /**
     * @return Precipitations moyenne. Renvoie 0 par defaut.
     */
    public double getAvgPrecipitations() {
        return this.avgPrecipitations;
    }

    /**
     * Définit le nombre de jour du mois
     * @param days nombre de jours
     */
    public void setDays(int days)
    {
        this.amountDays = days;
    }

    /**
     * Définit le nom du mois
     * @param name nom du mois
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Définit un tableau de température durant le mois
     * @param temperature Tableau de températures
     */
    public void setTemperature(int[] temperature)
    {
        this.meteoData[0] = temperature;
    }

    /**
     * Définit un tableau de précipitation durant le mois
     * @param precipitations Tableau de précipitations
     */
    public void setPrecipitations(int[] precipitations)
    {
        this.meteoData[1] = precipitations;
    }

    /**
     * Calcule la température moyenne du mois
     */
    public void calculateAverageTemp()
    {
        int lenght = this.meteoData[0].length;
        for(int i=0; i<lenght; i++)
        {
            this.avgTemp += this.meteoData[0][i];
        }

        this.avgTemp /= lenght;
    }

    /**
     * Calcule les précipitations moyennes du mois
     */
    public void calculateAveragePrecipitations()
    {
        int lenght = this.meteoData[1].length;
        for(int i=0; i<lenght; i++)
        {
            this.avgPrecipitations += this.meteoData[1][i];
        }

        this.avgPrecipitations /= lenght;
    }

}
