import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Benliam12 on 2019-09-04.
 */
public class CalculerNoteFinale
{
    public static void main(String[] args)
    {
        String line;
        String fileName = "Lab3/notes.txt";
        ArrayList<Student> students = new ArrayList<>();
        int nbEchec = 0;
        double groupeAvg =0;
        int nbAboveAvg = 0;
        Student bests = new Student("Aucun", 0);

        try
        {
            FileReader file = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(file);

            while((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(" ");
                double mark = Double.parseDouble(data[1]);
                students.add(new Student(data[0],(int)Math.round(mark)));
                groupeAvg += mark;
            }

            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Impossible d'ouvrir le fichier");
        }
        catch(Exception ex)
        {
            System.out.println("Autre Erreur!!!");
            ex.printStackTrace();
        }

        Collections.sort(students);

        String format = "%-45s %-20s%n";
        String formatNote = "%-45s      %-6s %-2s%n";
        String formatAffichage = "%-45s      %-6s%n";

        System.out.printf(format," ", "Statistiques du groupe");
        System.out.printf(format," ", "======================");
        System.out.printf(format,"Nom", "Note finale");

        groupeAvg /= students.size();

        for(Student student : students)
        {
            String echec = "";
            if(student.getMark() < 60)
            {
                echec = "EC";
                nbEchec++;
            }

            bests = (bests.getMark() < student.getMark()) ? student : bests;

            if(student.getMark() > groupeAvg)
            {
                nbAboveAvg++;
            }

            System.out.printf(formatNote, student.getName(),student.getMark(), echec);
        }

        System.out.println();
        System.out.printf(formatAffichage, "Nombre total d'étudiants: ", students.size());
        System.out.printf(formatAffichage, "Nombre total d'échec: ", nbEchec);
        System.out.printf("%-45s      %.1f%n", "Moyenne du groupe: ", groupeAvg);
        System.out.printf(formatAffichage, "Meilleur(e) étudiant(e):", bests.getName());
        System.out.printf(formatAffichage, "Nb. d'étudiants supp a la moyenne:", nbAboveAvg);
    }

}
