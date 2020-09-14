public class Player
{
    /**
     * Pointage du joueur
     */
    private int score;

    /**
     * Nom du joueur
     */
    private String name;

    /**
     * Cree l'objet Player
     * @param name Nom du joueur
     */
    public Player(String name)
    {
        this.name = name;
    }

    public Player(String name, int score)
    {
        this.name = name;
        this.score = score;
    }

    /**
     *
     * @return Score du joueur
     */
    public int getScore() {
        return score;
    }

    /**
     * Defini le score du joueur
     * @param score Score a mettre
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Ajouter un pointage au score du joueur
     * @param score Score a ajouter
     */
    public void addScore(int score)
    {
        this.score += score;
    }

    /**
     * Retourne le nom du joueur
     * @return Nom du joueur
     */
    public String getName() {
        return name;
    }

    /**
     * Defini le nom du joueur
     * @param name Nom du joueur
     */
    public void setName(String name) {
        this.name = name;
    }


}
