import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelApp
{
  public static void main(String args[] )throws IOException
   {
    try {
         ArrayList ArrHotel = new ArrayList();
         LinkList ListHotel = new LinkList();
         Stack stackHotel = new Stack();
         Stack newStack = new Stack();
         BufferedReader inData = new BufferedReader(new FileReader("Reserved.txt")); 
         PrintWriter outData = new PrintWriter(new BufferedWriter(new FileWriter("Booked.txt"))); 
         
         Customer c;
         String ic,name,dateIn,time;
         int ns;
         char rt;
        
         Scanner sc = new Scanner(System.in);
         JOptionPane.showMessageDialog(null, " ", "\n\nFP Hotel System\n\n", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("fphotel.png"));
         String[] buttons = { "Yes", "No", "Cancel" };
         int ans = JOptionPane.showOptionDialog(null, "Do you want to enter the system?", "Admin Confirmation",
         JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[2]);
         
     
          if(ans == 0)
          {
           String nameSt = JOptionPane.showInputDialog("Enter your name ");
           String namet = nameSt;
      
           String ICSt = JOptionPane.showInputDialog("Enter IC number ");
           String icst = ICSt;
      
           String idSt = JOptionPane.showInputDialog("Enter ID number ");
           String idst = idSt;
     
           String outputStr = "+++++++++++++++++++++++++++++++++"+"\n   Name : "+namet+"\n   Ic Number : "+icst+"\n   ID Number : "+idst+"\n+++++++++++++++++++++++++++++++++";;
           JOptionPane.showMessageDialog(null,outputStr,"Admin Information",JOptionPane.INFORMATION_MESSAGE);
       
      
           Admin l1 = new Admin(namet,icst,idst);
          }
       
          else
          {
             System.exit(0);
          }
      
          
               String pass = JOptionPane.showInputDialog("Enter password " );
               String password = pass;
        
               Admin l1 = new Admin(password);
              while(ans == 0 && password.equalsIgnoreCase("123"))
              {              
                         Object msg[] = { 
                         new Object[] { "------------------------------------------------"+"\nCheck reserved customer detail", "Add new customer", "Search and Update details"+"\n------------------------------------------------" }};
                         Object type[] = { "Check", "Add", "Search" };
                         int option = JOptionPane.showOptionDialog(null, msg, "Choose one",
                         JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, type,
                         null);
                   
                   //Input data of reserved customer and insert into link list of type hotel to check reserved customer details
                   String in = inData.readLine();
                   while (in != null)
                   {
                       StringTokenizer st = new StringTokenizer (in, ",");
                       ic = st.nextToken();
                       name = st.nextToken();
                       ns = Integer.parseInt(st.nextToken());
                       rt = st.nextToken().charAt(0);
                       dateIn = st.nextToken();
                       time = st.nextToken();
            
                       c = new Customer(ic,name,ns,rt,dateIn,time);
                       ListHotel.insertAtBack(c);
                       ArrHotel.add(c);
                       stackHotel.push(c);
                       in = inData.readLine();
                  }
                    
                    //Check or remove reserved customer detail
                    Object data = ListHotel.getFirst();
                    if(option == 0)
                    {
                        int count = 1;
                        while(data!=null)
                        {
                            c = (Customer) data;
                            System.out.println("\r\n\t====================================================");
                            System.out.println("\r\n\tCustomer "+count+c.toString());
                            System.out.println("\r\n\t====================================================");
                            data = ListHotel.getNext();
                            count++;
                       }
                       
                       System.out.print("How many customer have already got room? (Eg : 01/02) - ");
                       int cremove = sc.nextInt();
                             
                       for(int j=0 ; j<cremove ; j++)
                       {
                           ListHotel.removeFromBack();
                           stackHotel.pop();
                       }
                       System.out.println(cremove+" customer has been sucessfully removed !");
                    }

                    //Add new customer to book room
                    else if(option == 1)
                   {
                     JOptionPane.showMessageDialog(null, " ", "Room Available", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("room.png"));
                    
                     System.out.print(       "\n\nHow many customer do you want to add ? (Eg : 10/20)     - ");
                     int countCust = sc.nextInt();
       
                     for(int i = 0 ; i<countCust ; i++)
                     {   
                        System.out.println("=========================================================================");
                        System.out.print("             Enter Customer's Identity Card (IC) Number : ");
                        ic = sc.next();
             
                        System.out.print("                                  Enter Customer's Name : ");
                        name = sc.next();
                        
                        System.out.print("Enter Customer's number of nights spend (Eg - 01/02/03) : ");
                        ns = sc.nextInt();
             
                        System.out.print("                     Enter Customer's room type (T/F/S) : ");
                        rt = sc.next().charAt(0);
            
                        System.out.print("                    Enter Customer's Date In (DD/MM/YY) : ");
                        dateIn = sc.next();
                   
                        System.out.print("                             Enter time in (HH:MM)PM/AM : ");
                        time = sc.next();
             
                        c = new Customer(ic,name,ns,rt,dateIn,time);
                        ListHotel.insertAtBack(c);
                        ArrHotel.add(c);
                        stackHotel.push(c);
                        System.out.println("\n=========================================================================");
                      
                     }
                     
                       //Using Link List to Display minimum and maximum payment made 
                       String[] button = { "Yes", "No"};
                       int option2 = JOptionPane.showOptionDialog(null, "Do you want to see the maximum and minimum payment made? ", "Admin Confirmation",
                       JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[1]);
                    if(option2 == 0)
                    {   double max = 0.0, min = 999;
                        String maxIc = " ", minIc = " ",maxName = " ", minName = " ";
                        data = ListHotel.getFirst();
                        while(data != null)
                        {
                            c = (Customer)data;
                            if(c.calcPrice()>max)
                            {
                                max = c.calcPrice();
                                maxIc = c.getIc();
                                maxName = c.getName();
                            }
            
                            if(c.calcPrice()<min)
                            {
                                min = c.calcPrice();
                                minIc = c.getIc();
                                minName = c.getName();
                            }   
                            data = ListHotel.getNext();
                        }  
        
                        System.out.println("The maximum price made is RM "+max+" by "+maxIc+" , "+maxName);
                        System.out.println("The minimum price made is RM "+min+" by "+minIc+" , "+minName);
                    }
      
                 }
                 
                 //search and update customer data
                  else if(option == 2)
                  { 
                          System.out.print("Enter customer's IC Number : ");
                          String searchIC = sc.next();
                          
                        for(int i=0 ; i<ArrHotel.size(); i++)
                        {
                             c = (Customer)ArrHotel.get(i);
                          
                             if(c.getIc().equalsIgnoreCase(searchIC))
                             {
                                
                                 System.out.println("=========================================================================");
                                 System.out.println("                      Update Customer's details");
                                 System.out.print("             Enter Customer's Identity Card (IC) Number : ");
                                 ic = sc.next();
             
                                 System.out.print("                                  Enter Customer's Name : ");
                                 name = sc.next();
                        
                                 System.out.print("Enter Customer's number of nights spend (Eg - 01/02/03) : ");
                                 ns = sc.nextInt();
             
                                 System.out.print("                     Enter Customer's room type (T/F/S) : ");
                                 rt = sc.next().charAt(0);
            
                                 System.out.print("                    Enter Customer's Date In (DD/MM/YY) : ");
                                 dateIn = sc.next();
                   
                                 System.out.print("                             Enter time in (HH:MM)PM/AM : ");
                                 time = sc.next();
             
                                 c = new Customer(ic,name,ns,rt,dateIn,time);
                                 ArrHotel.set(i,c);
                                 newStack.push(c);
                                 System.out.println("\n=========================================================================");
                             }
                       }
                       
                   while(!newStack.isEmpty())
                   {
                    c = (Customer) newStack.pop();
             
                    int day = Integer.parseInt(c.getDateIn().substring(0,2));
                    int month = Integer.parseInt(c.getDateIn().substring(3,5));
                    int year = Integer.parseInt(c.getDateIn().substring(6,8));
                    int newDay = day + c.getDaySpend();
                    int initialTime = Integer.parseInt(c.getTime().substring(0,2))+12;
                    outData.println("\n\t====================================================");
                    outData.println("\n\t Updated details of customer "+searchIC);
                    if(month == 2)
                    {
                        if(newDay <= 28)
                        { 
                            outData.println(c.toString()+"\n\tDate Out  - "+newDay+"/"+month+"/"+year);
                        }
                 
                        else
                        {
                            int newMonth = month+01;
                            outData.println(c.toString()+"\n\tDate Out   - "+c.getDaySpend()+"/"+newMonth+"/"+year);
                        }
                 
                    }
             
                    else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10)
                    {
                        if(newDay <= 31)
                        { 
                            outData.println(c.toString()+"\n\tDate Out  - "+newDay+"/"+month+"/"+year);
                        }
                 
                        else
                        {
                            int newMonth = month+01;
                            outData.println(c.toString()+"\n\tDate Out  - "+c.getDaySpend()+"/"+newMonth+"/"+year);
                        }
                    }
             
                    else if (month == 4 || month == 6 || month == 9 || month == 11)
                    {
                        if(newDay <= 30)
                        { 
                            outData.println(c.toString()+"\n\tDate Out  - "+newDay+"/"+month+"/"+year);
                        }
                 
                        else
                        {
                            int newMonth = month+01;
                            outData.println(c.toString()+"\n\tDate Out  - "+c.getDaySpend()+"/"+newMonth+"/"+year);
                        }
                    }
             
                    else if(month == 12)
                    {
                        if(newDay <= 31)
                        { 
                            outData.println(c.toString()+"\n\tDate Out  - "+newDay+"/"+month+"/"+year);
                        }
                 
                        else
                        {
                            int newYear = year+01;
                            int newMonth = month-11;
                            outData.println(c.toString()+"\n\tDate Out  - "+c.getDaySpend()+"/"+newMonth+"/"+newYear);
                        }
                    } 
            
                    if(initialTime<= 23)
                    {
                        outData.println("\n\tTime Out  - "+initialTime+":"+c.getTime().substring(3,5)+"PM");
                    }
                 
                    else 
                    {
                        int newTime = initialTime - 24;
                        outData.println("\n\tTime Out  - "+newTime+":"+c.getTime().substring(3,5)+"AM");
                    }
                 
                    outData.println("\tTotal     - RM"+c.calcPrice());     
                    outData.println("\n\t====================================================");
                    
                  }
                  
                   
                 }
        
                 String[] button = { "Yes", "No", "Cancel" };
                 ans = JOptionPane.showOptionDialog(null, "Do you want to re-enter the system?", "Admin Confirmation",
                 JOptionPane.PLAIN_MESSAGE, 0, null, buttons, buttons[2]);
              }
              
                  //Using Stack to check customer check out details and sort according to the latest customer
                  while(!stackHotel.isEmpty())
                   {
                    c = (Customer) stackHotel.pop();
             
                    int day = Integer.parseInt(c.getDateIn().substring(0,2));
                    int month = Integer.parseInt(c.getDateIn().substring(3,5));
                    int year = Integer.parseInt(c.getDateIn().substring(6,8));
                    int newDay = day + c.getDaySpend();
                    int initialTime = Integer.parseInt(c.getTime().substring(0,2))+12;
                    outData.println("\n\t====================================================");
           
                    if(month == 2)
                    {
                        if(newDay <= 28)
                        { 
                            outData.println(c.toString()+"\n\tDate Out  - "+newDay+"/"+month+"/"+year);
                        }
                 
                        else
                        {
                            int newMonth = month+01;
                            outData.println(c.toString()+"\n\tDate Out   - "+c.getDaySpend()+"/"+newMonth+"/"+year);
                        }
                 
                    }
             
                    else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10)
                    {
                        if(newDay <= 31)
                        { 
                            outData.println(c.toString()+"\n\tDate Out  - "+newDay+"/"+month+"/"+year);
                        }
                 
                        else
                        {
                            int newMonth = month+01;
                            outData.println(c.toString()+"\n\tDate Out   - "+c.getDaySpend()+"/"+newMonth+"/"+year);
                        }
                    }
             
                    else if (month == 4 || month == 6 || month == 9 || month == 11)
                    {
                        if(newDay <= 30)
                        { 
                            outData.println(c.toString()+"\n\tDate Out  - "+newDay+"/"+month+"/"+year);
                        }
                 
                        else
                        {
                            int newMonth = month+01;
                            outData.println(c.toString()+"\n\tDate Out  - "+c.getDaySpend()+"/"+newMonth+"/"+year);
                        }
                    }
             
                    else if(month == 12)
                    {
                        if(newDay <= 31)
                        { 
                            outData.println(c.toString()+"\n\tDate Out  - "+newDay+"/"+month+"/"+year);
                        }
                 
                        else
                        {
                            int newYear = year+01;
                            int newMonth = month-11;
                            outData.println(c.toString()+"\n\tDate Out  - "+c.getDaySpend()+"/"+newMonth+"/"+newYear);
                        }
                    } 
            
                    if(initialTime<= 23)
                    {
                        outData.println("\n\tTime Out  - "+initialTime+":"+c.getTime().substring(3,5)+"PM");
                    }
                 
                    else 
                    {
                        int newTime = initialTime - 24;
                        outData.println("\n\tTime Out  - "+newTime+":"+c.getTime().substring(3,5)+"AM");
                    }
                 
                    outData.println("\tTotal     - RM"+c.calcPrice());     
                    outData.println("\n\t====================================================");
                    
                  }
                  outData.close();
   
      }
  
        catch(IOException i)
        {
            System.out.println(i.getMessage());
        }
    }
  }

