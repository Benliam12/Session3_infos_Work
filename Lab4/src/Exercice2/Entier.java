package Exercice2;

import javax.swing.*;
import java.util.List;

public class Entier
{
    /**
     * Demande à l'utilisateur d'entrer un entier.
     * @param message Message demandé à l'utilisateur
     * @return Valeur en int entrée par l'utilisateur
     * @throws NumberFormatException Si l'utilisateur n'a pas entrer un entier valide.
     */
    public static int intInput(String message) throws NumberFormatException
    {
        String stringNombre = JOptionPane.showInputDialog(message);
        return Integer.parseInt(stringNombre);
    }

}
