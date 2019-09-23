package UiDependencies;

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

    public String getKey()
    {
        return key;
    }

    public T getValue()
    {
        return value;
    }
}