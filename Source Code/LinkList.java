public class LinkList
{
    private Node first;
    private Node current;
    private Node last;
    
    public LinkList()
    {
        first = null;
        current = null;
        last = null;
    }
    
    public boolean isEmpty()
    {
        return (first==null);
    }
    
    public void insertAtFront(Customer insertItem)
    {
        Node newNode = new Node(insertItem);
        
        if(isEmpty())
        {
            first = newNode;
            last = newNode;
        }
        
        else
        {
            newNode.next = first;
            first = newNode;
        }
    }
    
    public void insertAtBack(Customer  insertItem)
    {
        Node newNode = new Node(insertItem);
        
        if(isEmpty())
        {
            first = newNode;
            last = newNode;
       
        }
        else
        {
            last.next = newNode;
            last = newNode;
        
        }
    }
    
    public Customer  removeFromFront()
    {
        Customer removeItem = null;
        
        if(isEmpty())
        {
            return removeItem;
        }
        
        removeItem = first.data;
        if( first == last )
        {
            first = null;
            last = null;
        }
        else
        {
            first = first.next;
        }
        return removeItem;
    }
    
    public Customer  removeFromBack()
    {
        Customer  removeItem = null;
        if(isEmpty())
        {
            return removeItem;
        }
        removeItem = last.data;
        if( first == last)
        {
            first = null;
            last = null;
        }
        else
        {
            current = first;
            while(current.next != last)
            {
                current = current.next;
            }      
                last = current;
                last.next = null;
        }
        return removeItem;
    }
    
    public Customer  getFirst()
    {
        if(isEmpty())
        {
            return null;
        }
        else
        {
            current = first;
            return current.data;
        }
    }
    
    public Customer  getNext()
    {
        if(current == last)
        {
            return null;
        }
        else
        {
            current = current.next;
            return current.data;
        }
    }
    
   
}
    

          


