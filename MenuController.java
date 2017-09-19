import java.util.Scanner;

/**
 * This class controls the Gym application. It displays the following basic menu for the Gym and processes the user input.
 * 
 * <pre>
 * Gym Menu
 * ---------
 * 
 * 1) Add a member
 * 2) List all members
 * 3) Remove a member (by index)
 * 4) Number of members in the gym
 * ---------
 * 5) List gym details
 * 6) List members with ideal starting weight
 * 7) List members with a specific BMI category
 * 8) List all members stats imperically and metrically
 * 0) Exit
 * ==>>
 * </pre>
 * 
 * @author Paddy Murphy 
 * @version 23.0 (21.02.2017)
 */
public class MenuController
{
   private Scanner input;
   private Gym gym;
   
   /**
    * <pre>
    * The default constructor. The constructor creates an instance of the Scanner class. It also asks the user to enter the gym name, manager name and
    * gym phone number. These details are used to create an instance of the Gym. The final task in the constructor is to run the menu.
    * </pre>
    */
   public MenuController()
   {
       input = new Scanner(System.in);
       
       System.out.println("Please enter the Gym...");
       System.out.print("\tName: ");
       String gymName = input.nextLine();
       
       System.out.print("\tManager Name: ");
       String managerName = input.nextLine();
       
       System.out.print("\tPhone Number: ");
       String phoneNumber = input.nextLine();
       
       gym = new Gym(gymName, managerName, phoneNumber);
       runMenu();
   }
   
   /*
    * 
    * mainMenu() - This method displays the main menu for the application,
    * reads the menu option that the user entered and returns it.
    * 
    * 
    * @return       the users menu choice
    */
   private int mainMenu()
   {
       System.out.println("\fGym Menu");
       System.out.println("---------");
       System.out.println("  1) Add a member");
       System.out.println("  2) List all members");
       System.out.println("  3) Remove a member (by index)");
       System.out.println("  4) Number of members in the gym");
       System.out.println("---------");
       System.out.println("  5) List gym details");
       System.out.println("  6) List members with ideal starting weight");
       System.out.println("  7) List members with a specific BMI category");
       System.out.println("  8) List all member stats imperically and metrically");
       System.out.println("  0) Exit");
       System.out.print("==>> ");
       int option = input.nextInt();
       //input.nextLine();
       return option;
   }
    
   /*
    * This is the method that controls the loop
    */
   private void runMenu()
   {
       int option = mainMenu();
       while (option != 0)
       {
           switch (option)
           {
               case 1:  addMember();
               break;
               case 2:  System.out.println(gym.listMembers());
               break;
               case 3:  
               if (gym.numberOfMembers() > 0)
               {
                   System.out.print(gym.listMembers());
                   System.out.print("Index of member to delete ==> ");
                   int index = input.nextInt();
                   if( index >= gym.numberOfMembers())
                   {
                        System.out.println("There is no member for this index number");
                   }
                   else
                   {
                       gym.remove(index);
                       System.out.print("Member deleted\n");
                   }
               }
               else
               {
                   System.out.print("There are no members in the gym\n");
               }
               break;
               case 4:  System.out.println("Number of members: " + gym.numberOfMembers());
               break;
               case 5:  System.out.println(gym.toString());
               break;
               case 6:  System.out.println(gym.listMembersWithIdealWeight());
               break;
               //this is printing out all members whether they ar in the BMI category or not.
               case 7:  System.out.print("Please enter a specific BMI category: ");
                        input.nextLine();
                        String category = input.nextLine();
                        //input.nextLine();
                        System.out.println(gym.listBySpecificBMICategory(category));
               break;
               case 8:  System.out.println(gym.listMemberDetailsImperialAndMetric());
               break;
               default:  System.out.println("Invalid option entered: " + option);
               break;
           }
           System.out.println("\nPress Enter to continue...");
           input.nextLine();
           input.nextLine();
           option = mainMenu();
       }
       System.out.println("Exiting...bye");
       System.exit(0);
   }
   
   private void addMember()
   {
       input.nextLine();
       System.out.println("Please enter the following member details...");
       
       System.out.print("\tId (between 100001 and 999999): ");
       int memberId = input.nextInt();
       input.nextLine();
       
       System.out.print("\tName (max 30 chars): ");
       String memberName = input.nextLine();
       
       System.out.print("\tAddress: ");
       String memberAddress = input.nextLine();
       
       System.out.print("\tHeight (between 1 and 3 metres): ");
       double height = input.nextDouble();
       
       System.out.print("\tStarting weight (between 35kg and 250kg): ");
       double startingWeight = input.nextDouble();
       input.nextLine();
       
       System.out.print("\tGender (M/F): ");
       String gender = input.nextLine();
       
       gym.add(new Member(memberId, memberName, memberAddress, height, startingWeight, gender));
   }
}
