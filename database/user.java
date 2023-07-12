package database;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;
class hotellist {
    String hotelname;
    String address;
    String type;
    String status;
    ArrayList<menulist> menu=new ArrayList<>();
    hotellist( String hotelname,String address,String type,String status,ArrayList<menulist> menu){
        this.hotelname=hotelname;
        this.address=address;
        this.type=type;
        this.status=status;
        this.menu=menu; 
    }
    void show(){
        System.out.println("Dish\tprice\tquantity");
        for(int i=0;i<menu.size();i++){
            System.out.println(menu.get(i).name+"\t"+menu.get(i).price+"\t"+menu.get(i).quantity);
        }
    }
    void showuser(){
        System.out.println("Dish\tprice\tquantity");
        String s;
        for(int i=0;i<menu.size();i++){
            if(menu.get(i).quantity<=3&&menu.get(i).quantity>0)
                s="Only few left("+menu.get(i).quantity+")";
                else if(menu.get(i).quantity==0)
                s="Out of Stock";
                else 
                s="In Stock";
            System.out.println(menu.get(i).name+"\t"+menu.get(i).price+"\t"+s);
        }
    }
}
class menulist {
    String  name;
    Float price;
    int quantity;
    menulist(String name,float price,int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
}
 class Addhotels extends Thread {
    HashMap <String,ArrayList<hotellist>> city=new HashMap<>();
    Scanner ip=new Scanner(System.in);
    public void run(){
        city.put("Chennai",gethotel());
        city.put("Madurai",gethotel1());
    }
    ArrayList<menulist> add1(){
           ArrayList<menulist> menu=new ArrayList<>();
            menu.add(new menulist("idly",20,40));
            menu.add(new menulist("dosa",10,30));
            menu.add(new menulist("poori",25,0));
            menu.add(new menulist("pongal",50,3));
            menu.add(new menulist("vadaa",10,30));
         return menu;
        }
        ArrayList<menulist> add2(){
            ArrayList<menulist> menu=new ArrayList<>();
             menu.add(new menulist("Veg Friedrice",50,20));
             menu.add(new menulist("Egg Friedrice",60,2));
             menu.add(new menulist("Chicken rice",80,0));
             menu.add(new menulist("Veg Noodles",50,20));
             menu.add(new menulist("Egg Noodles",60,20));
             menu.add(new menulist("Chicken Noodles",80,1));
          return menu;
         }ArrayList<menulist> add3(){
            ArrayList<menulist> menu=new ArrayList<>();
             menu.add(new menulist("Veg Briyani",50,20));
             menu.add(new menulist("Egg Briyani",60,20));
             menu.add(new menulist("Chickem Briyani",70,2));
          return menu;
         }
        
         ArrayList<hotellist> gethotel(){
            ArrayList<hotellist> hotel=new ArrayList<>();
            hotel.add(new hotellist("hotel1", "123,XYZ Street,OMR Road", "   VEG  ","open",add1()));
            hotel.add(new hotellist("hotel2", "323,ABC Street,Adaiyar", "VEG/NON VEG","open",add2()));
                   
            return hotel;
         } 
          ArrayList<hotellist> gethotel1(){
            ArrayList<hotellist> hotel=new ArrayList<>();
           hotel.add(new hotellist("hotel1","767,QWE Street,Madurai", "VEG/NON VEG", "open", add3()));          
            return hotel;
         }
         
            
            ArrayList<menulist> addmenu(){
                ArrayList<menulist> menu1=new ArrayList<>();
                String dish;
                float price;
                int quantity;
                int end;
                System.out.println("Enter number of dish to be added :");
                end=ip.nextInt();
                int i=0;
                while(i<end){
                System.out.println("Enter Dish name :");
                dish=ip.next();
                System.out.println("Enter Price:");
                price=ip.nextFloat();
                System.out.println("Enter Quantity :");
                quantity=ip.nextInt();
                ip.nextLine();

                 menu1.add(new menulist(dish,price,quantity));
                 i++;
                }              
              return menu1;
             }
            public void addhotel(){
                System.out.println("Enter the city :");
                String c=ip.nextLine();
                String name,type,address,status;
                System.out.println("Enter the Restaurant Name :");
                name=ip.nextLine();
                System.out.println("Enter the Restaurant Address :");
                address=ip.nextLine();
                System.out.println("Enter the Restaurant type(Veg/Non Veg) :");
                type=ip.nextLine();
                System.out.println("Enter the Restaurant status :");
                status=ip.nextLine();
                if(city.containsKey(c))
                {    
                     city.get(c).add(new hotellist(name,address,type,status,addmenu()));
                }
                else{
                    ArrayList<hotellist> addhotel=new ArrayList<>();
                    addhotel.add(new hotellist(name,address,type,status,addmenu()));
                    city.put(c,addhotel);
                }
            }                 
}
 public class user extends Owner{
    String r;
    String c;
    String dishname;
    float p;
    int quantity;
    int l;
   
    public void usershow(){
        for(String key:city.keySet()){
            System.out.println(key);
        }
        System.out.println("enter the city :");
           c=ip.nextLine();
           // ArrayList<hotellist> h=a.city.get(c);
            System.out.println("------------------------Restaurants Near you------------------------");
            System.out.println("Restaurant Name\tType\t  Location\tStatus");
            System.out.println("--------------------------------------------------------------------");
            for(int i=0;i<city.get(c).size();i++){
                System.out.println(city.get(c).get(i).hotelname+"\t"+city.get(c).get(i).type+"\t"+city.get(c).get(i).address+"\t"+city.get(c).get(i).status);
            }
            
           System.out.println("--------------------------------------------------------------------");

            System.out.println("enter the hotel : ");
            r=ip.nextLine();
          
            for(int i=0;i<city.get(c).size();i++){
               if(city.get(c).get(i).hotelname.equals(r)){
               l=i;
               city.get(c).get(i).showuser();
               buy();                
            }     
        }

        }
        String name;
        String ph_no;
        String address;
        void userdetails(){
            System.out.println("Enter your Name :");
             name=ip.nextLine();
            System.out.println("Enter the phone number");
            ph_no=ip.nextLine();
            System.out.println("Enter Delivery Address:");
           address=ip.nextLine();
        }
        private void buy(){
        boolean flag=true;
            while(true){
            System.out.println("Enter the dish or(type 1 to exit):");
            dishname=ip.nextLine();
            if(dishname.equals("1")) break;
            for(int i=0;i<city.get(c).get(l).menu.size();i++){
                if(city.get(c).get(l).menu.get(i).name.equals(dishname)){
                 p=city.get(c).get(l).menu.get(i).price;
               
                 if(city.get(c).get(l).menu.get(i).quantity==0){
                    System.out.println("Sorry,Item not Available");
                    flag=false;
                    break;
                 }
                 System.out.println("Enter the quantity");
                 quantity=ip.nextInt();
               ip.nextLine();
                
                 if(city.get(c).get(l).menu.get(i).quantity<quantity)
                 {
                     System.out.println("Oops,Available Quantity is "+city.get(c).get(l).menu.get(i).quantity);
                     System.out.println("Change the quantity within the limit:");
                        quantity=ip.nextInt();
                        ip.nextLine();
                 }
                 
                 city.get(c).get(l).menu.get(i).quantity-=quantity;
                 break;
                
                }
            }if(flag==true)
                addbill(dishname,p,quantity);    
            }
        
            userdetails();
            applyoffer();
        
    }
       private void addbill(String d,Float p,int q){
            sum+=p*q;
            bill[n][0]=d;
            bill[n][1]=String.valueOf(p);
            bill[n][2]=String.valueOf(q);
            bill[n++][3]=String.valueOf(p*q);

        }    
        private String bill[][]=new String[50][4];
        private int n=0;
        private float sum=0;
        private int billno=1000;

       private void applyoffer(){
           String code="NIL";
           int discount=0;
            System.out.println("Do you have any Promocode?(y/n)");
            if(ip.nextLine().equals("y")){
            System.out.println("Enter the Code: ");
           code=ip.nextLine();
            if(Pattern.matches("[A-Z]+{3,6}[0-9]+{2,4}",code)){
                if(code.equals("GET100"))
                {    discount=100;
                    if(sum>500)
                    sum-=discount;
                    else
                        {
                            discount=0;
                            code="NIL";
                        System.out.println("NOT APPLICABLE");
                        }
                    showbill(code,discount);
                }
            else{
                    code="NIL";
                System.out.println("INVALID CODE");
                applyoffer();
                }
            }
            else{
                code="NIL";
                System.out.println("INVALID FORMAT");
                applyoffer();
                }
            }
            else
            showbill(code,discount);
            generateBill(code, discount);
        }
     private void showbill(String code,int discount){
            System.out.println("-----------------TOTAL ORDERS SUMMARY-------------------");
            System.out.println("--------------------------------------------------------");
            System.out.println("Bill no: "+ ++billno+"---------------BILL----------------------------");
            System.out.println("Dish Ordered\t|Price\t|Quantity,\t|Amount");
            System.out.println("--------------------------------------------------------");
            for(int i=0;i<n;i++){
                System.out.println(bill[i][0]+"  \t|   "+bill[i][1]+"\t|  "+bill[i][2]+"\t|  "+bill[i][3]);
            }
            System.out.println("--------------------------------------------------------");
            System.out.print("Applied PROMOCODE : "+code);
            System.out.println("\t\t\tTOTAL :Rs."+(sum+discount));
            System.out.println("Total Discount : "+discount);
            System.out.println("Total : Rs."+sum);
            System.out.println("--------------------------------------------------------");
            System.out.println("--------------------DELIVERY DETAILS------------------------");
            System.out.print("Name : "+name);
            System.out.println("\t\t\tDelivery Address : "+address);
            System.out.println("Contact Number : "+ph_no);
       }
       void generateBill(String code,int discount){
           File billgenerate=new File("D:\\tasks\\Java\\project\\Bill\\"+billno+".txt");
           try (FileWriter writer = new FileWriter(billgenerate)) {
               writer.write("Bill no: "+ billno+"---------------BILL----------------------------\n");
              writer.write("Dish Ordered\t|Price\t|Quantity,\t|Amount\n");
            writer.write("--------------------------------------------------------\n");
            for(int i=0;i<n;i++){
               writer.write(bill[i][0]+"  \t|   "+bill[i][1]+"\t|  "+bill[i][2]+"\t|  "+bill[i][3]+"\n");
            }
            writer.write("--------------------------------------------------------\n");
            writer.write("Applied PROMOCODE : "+code+"\t\t\tTOTAL :Rs."+(sum+discount)+"\nTotal Discount : "+discount
            +"\nTotal : Rs."+sum);
            writer.write("--------------------------------------------------------\n");
            writer.write("--------------------DELIVERY DETAILS------------------------\n");
            writer.write("Name : "+name+"\t\t\tDelivery Address : "+address+"\nContact Number : "+ph_no+"\n");
           

        } catch (IOException e) {
           
            e.printStackTrace();
        }
           
       }
 }
class Owner extends Addhotels{
          
        void Ownershow(){
                for(String key:city.keySet()){
                 System.out.println(key);
                }
                System.out.println("enter the city : ");
                    String c=ip.nextLine();
                    //ArrayList<hotellist> h=city.get(c);
                    System.out.println("Restaurant Name\tType\t Location\tStatus");
                    System.out.println("--------------------------------------------------------");
        
                    for(int i=0;i<city.get(c).size();i++){
                        System.out.println(city.get(c).get(i).hotelname+"\t"+city.get(c).get(i).type+"\t"+city.get(c).get(i).address+"\t"+city.get(c).get(i).status);
                    }
                    System.out.println("enter the hotel :");
                    String r=ip.nextLine();
                  
                    for(int i=0;i<city.get(c).size();i++){
                      if(city.get(c).get(i).hotelname.equals(r)){
                       city.get(c).get(i).show();               
                    }   
                }
            }
           private void update(){   
                for(String key:city.keySet()){
                    System.out.println(key);
                   }
                   System.out.println("enter the city : ");
                       String c=ip.nextLine();
                       //ArrayList<hotellist> h=city.get(c);
                       System.out.println("Restaurant Name\tType\t Location\tStatus");
                       System.out.println("--------------------------------------------------------");
                       for(int i=0;i<city.get(c).size();i++){
                           System.out.println(city.get(c).get(i).hotelname+"\t"+city.get(c).get(i).type+"\t"+city.get(c).get(i).address+"\t"+city.get(c).get(i).status);
                       }
                       System.out.println("enter the hotel :");
                       String r=ip.nextLine();
                    for(int i=0;i<city.get(c).size();i++){
                        if(city.get(c).get(i).hotelname.equals(r)){
                         city.get(c).get(i).show();               
                      }  
                    }
                       for(int i=0;i<city.get(c).size();i++){
                         if(city.get(c).get(i).hotelname.equals(r)){
                          
                            
                             System.out.println("1.Update price\n2.Update quantity\n3.Add dish");
                             String check=ip.nextLine();
                             switch (check) {
                                 case "1":
                                 System.out.println("Choose the item to be updated");
                                 String item=ip.nextLine();
                                    System.out.println("Enter new price :");
                                    float newprice=ip.nextFloat();
                                    ip.nextLine();
                                    for(int j=0;j<city.get(c).get(i).menu.size();j++){
                                    if(city.get(c).get(i).menu.get(i).name.equals(item)){
                                        city.get(c).get(i).menu.get(i).price=newprice;
                                        break; 
                                    }  
                                }  
                                    break;
                                 case "2":
                                     System.out.println("Choose the item to be updated");
                                     item=ip.nextLine();
                                    System.out.println("Enter new Quantity :");
                                    int newquantity=ip.nextInt();
                                    ip.nextLine();
                                    for(int j=0;j<city.get(c).get(i).menu.size();j++){
                                    if(city.get(c).get(i).menu.get(i).name.equals(item)){
                                        city.get(c).get(i).menu.get(i).quantity=newquantity;
                                        break;
                                    }  
                                } 
                                    case "3":
                                    System.out.println("Enter the item");
                                    String additem=ip.nextLine();  
                                    System.out.println("Enter the Price");
                                    Float addprice=ip.nextFloat();
                                    ip.nextLine();
                                    System.out.println("Enter the quantity");
                                    int addquantity=ip.nextInt();
                                    ip.nextLine();
                                    city.get(c).get(i).menu.add(new menulist(additem, addprice, addquantity));
                                    break;
                                                         
                                  
                                 default:
                                     break;
                             }
                             break;               
                       }   
                    }
             }          
            public void display(){
                System.out.println("1.view\n2.update");
                String option=ip.next();
                ip.nextLine();
                switch(option){
                    case "1":
                    System.out.println("---------------Choose your City-----------------");
                    System.out.println("------------------------------------------------");
                        Ownershow();
                        break;
                    case "2":
                           update();
                        break;
                    default:
                    break; 
           }
       } 
}