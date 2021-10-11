
public class Admin extends Hotel
{
    private String id;
    private String pass;
   
    
    public Admin()
    {
        super();
        id = null;
        pass = null;     
       
    }
    
    public Admin(String n,String ic,String i)
    {
        super(n,i);
        id = i;
     
    }
    
    public Admin(String p)
    {
        pass = p;
    }
    
    public void setAdmin(String i,String p)
    {
        id = i;
        pass = p;
    }
    
    public String getName()
    {  
        return name;     
    }
    public String getIc()
    {  
        return ic;
    }
    public String getId()
    {
        return id;
    }
    public String getpass()
    {
        return pass;
    }
    
 
}
