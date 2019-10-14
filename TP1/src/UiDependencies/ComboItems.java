package UiDependencies;

/**
 * Used for {@link javax.swing.JComboBox} to put custom data in.
 * @param <T> type of stored data
 */
public class ComboItems<T>
{
    private String key;
    private T value;

    public ComboItems(String key, T value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return key;
    }

    /**
     * Return the linked data.
     * @return value of the comboItems
     */
    public T getValue()
    {
        return value;
    }
}