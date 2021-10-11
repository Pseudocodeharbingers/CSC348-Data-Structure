public class Customer extends Hotel
{
     private int daySpend;
     private char roomType;
     private String dateIn;
     private String time;
     private String searchIC;
     
     public Customer()
     {
         super();
         daySpend = 0;
         roomType = ' ';
         dateIn = null ;
         time = null;
     }
     
     public Customer(String i, String n,int ds,char rt,String d,String t)
     {
         super(i,n);
         daySpend = ds;
         roomType = rt;
         dateIn = d;
         time = t;
     }
     
     public String getIc()
     {  
        return ic;
     }
     
      public String getName()
     {  
        return name;     
     }
    
     public int getDaySpend()
    {  
        return daySpend;
    }
    
    public char getroomType()
    {  
        return roomType;
    }
    
    public double calcPrice()
    {
        double price = 0.0;
        if(roomType == 'T' || roomType == 't')
            price = daySpend * 150.00;
        else if(roomType == 'F' || roomType == 'f')
            price = daySpend * 180.00;
        
         else if(roomType == 'S' || roomType == 's')
            price = daySpend * 100.00;
            
       return price;
    }
    
    public String getDateIn()
    {  
        return dateIn;
    }
    
    public String getTime()
    {  
        return time;
    }
    
    int count = 0 ;
    public String toString()
    {
        count++;
        return "\r\n\tIC Number - "+ic+"\r\n\tName      - "+name+"\r\n\tDay Spend - "+daySpend+"\r\n\tRoom Type - "+roomType+"\r\n\tDate In   - "+dateIn+"\r\n\tTime In   - "+time+"\r\n"; 
      
    }
    
}