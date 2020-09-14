import java.util.Scanner;

public class LancerJeu
{
    public static void main(String[] args)
    {
        JeuDes jeu = new JeuDes(2,21, 10);

        Scanner scanner = new Scanner(System.in);
        do {
            jeu.resetGame();
            jeu.jouer();

            System.out.println("\nTapez \"stop\" pour arrêter le programme. Sinon tapez autre chose pour recommencer une partie");
        } while(!scanner.next().equalsIgnoreCase("stop"));

        System.out.println("Au revoir =)");
    }
}
