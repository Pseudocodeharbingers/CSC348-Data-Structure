
public abstract class Hotel
{
    protected String ic;
    protected String name;
    
    public Hotel()
    {
        ic = null;
        name = null;
    }
    
    public Hotel(String i,String n)
    {
        ic = i;
        name = n;
    }

    public abstract String getIc();
    public abstract String getName();
}
