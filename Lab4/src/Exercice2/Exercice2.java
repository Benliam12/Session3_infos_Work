package Exercice2;

public class Exercice2
{
    public static void main(String[] args)
    {
        try {
            int age = Entier.intInput("Entrer votre âge: ");

            if(age >= 18)
                System.out.println("Vous pouvez entrer dans les bars à " + age + " ans");
            else
                System.out.println("Vous êtes un enfant =(");
        }
        catch (NumberFormatException e) {   	//Si la méthode n’a pu convertir en entier
            System.err.println("Veuillez saisir un entier.");
        }
    }
}
