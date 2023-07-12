import java.util.Scanner;
import database.*;
public class t3  {
    static Scanner sc=new Scanner(System.in);
          public static void main(String arg[]){
            user a=new user();
           Thread t=new Thread(a);
            t.start();        
        while(true)
        {
            System.out.println("1.Partner\n2.User\n3.exit");
            String select=sc.next();
            sc.nextLine();
            if(select.equals("3")){
                break;
                
            }
            switch(select){
                case "1":
                        System.out.println("1.Add new Restaurant \n2.View/Update your Restaurant");
                        select=sc.next();
                        sc.nextLine();
                        if(select.equals("1"))
                          a.addhotel();
                          else if(select.equals("2"))
                          a.display();
                    break;
            case "2":
        System.out.println("-------------------Food Ordering System-------------------");
                a.usershow();
                default:
                    break;
         }
        }
    }
}