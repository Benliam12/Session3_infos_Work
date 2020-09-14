public class De
{
    /**
     * Nombre de face du dé
     */
    private int nbFace = 6;

    public De() {}

    public De(int nbFace){this.nbFace = nbFace;}

    /**
     *
     * @return Nombre de face du de
     */
    public int getNbFace() {
        return nbFace;
    }

    /**
     * Defini le nombre de face du de
     * @param nbFace Nombre de faces
     */
    public void setNbFace(int nbFace) {
        this.nbFace = nbFace;
    }

    /**
     * Lance le de
     * @return retourne une value entre 1 et le nombre de face du de.
     */
    public int throwDice()
    {
        return (int) Math.round(Math.random() * (this.nbFace-1)) + 1;
    }

}
