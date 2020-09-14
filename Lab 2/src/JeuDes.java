import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author William D'Anjou
 */
public class JeuDes
{
    private ArrayList<Player> players = new ArrayList<>();
    private int winScore;
    private int maxTurns;
    private int amountOfPlayer;

    private De de = new De(6);

    /**
     * Constructor of JeuDes class
     * @param amountOfPlayer Nombre de joueurs
     * @param winScore Score to win
     * @param maxTurns Maximum amount of turns to get the score
     */
    public JeuDes(int amountOfPlayer,int winScore, int maxTurns)
    {
        this.winScore = winScore;
        this.maxTurns = maxTurns;
        this.amountOfPlayer = amountOfPlayer;

        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("d MMMM yyyy", Locale.FRENCH);

        System.out.println("Bienvenue a ce jeu de dés, aujourd'hui nous somme le " + df.format(date));
    }

    /**
     * Reset le jeu, remet le pointage des joueurs a zero.
     */
    public void resetGame()
    {
        this.players.clear();
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i<amountOfPlayer; i++)
        {
            System.out.println("Entrer le nom du joueur " + (i+1));
            this.players.add(new Player(scanner.next()));
        }
    }

    /**
     * Methode utilise pour effectuer une partie
     */
    public void jouer()
    {
        int i;
        int lastThrow;

        ArrayList<Player> winPlayer = new ArrayList<Player>();

        for(i = 1; i<=this.maxTurns; i++)
        {
            System.out.println("Tour " + i);

            for(Player player : this.players)
            {
                lastThrow = this.de.throwDice();

                player.addScore(lastThrow);

                if(player.getScore() >= this.winScore) {
                    winPlayer.add(player);
                }

                System.out.printf("%5s %-25s %-5s %-25s %s%n", "", player.getName() + " a obtenu ",lastThrow, player.getName() + " a maintenant ",player.getScore() + " points.");
            }

            if(winPlayer.size() > 0)
                break;
        }

        // Si les joueurs n'obtiennent pas le score requis pour gagner
        if(winPlayer.size() == 0)
        {
            System.out.println("Aucun joueur n'a atteint le score requis pour gagner ;(");
            return;
        }

        if(winPlayer.size() > 1)
            System.out.println("Il y a plusieurs gagnants :");

        for(Player player: winPlayer)
        {
            System.out.println(player.getName() + " a gagné au " + i + "ème tours avec un total de "+ player.getScore() + " points.");
        }

    }
}
