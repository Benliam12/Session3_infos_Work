/**
 * Created by Benliam12 on 2019-09-04.
 */
public class Student implements Comparable<Student>
{
    protected String name;
    protected int mark;

    public Student(String name, int mark)
    {
        this.name = name;
        this.mark = mark;
    }

    /**
     * Définit le nom de l'étudiant
     * @param name nom de l'étudiant
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Définit la note de l'étudiant
     * @param mark Note de l'étudiant
     */
    public void setMark(int mark)
    {
        this.mark = mark;
    }

    /**
     * @return Le nom de l'étudiant
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @return La note de l'étudiant
     */
    public int getMark()
    {
        return this.mark;
    }

    /**
     * Sert a ordonner les étudants en ordre alphabetique avec Collections.sort
     * @param o Autre étudiant
     * @return Value.
     * @see java.util.Collections
     */
    @Override
    public int compareTo(Student o) {
        return this.name.compareToIgnoreCase(o.getName());
    }
}
