import java.util.ArrayList;

/**
 * <pre>
 * This class handles a collection of Member classes.
 * 
 * The details stored for a gym include:
 *      Gym name
 *      Manager name
 *      Phone number
 *      An ArrayList collection of its Members
 *      
 * Along with the standard constructors , getters, setters, and toString methods listed below,
 * there are specific method that:
 * 
 *      - List all the members that have an ideal starting weight.
 *      - List all the members of a specific BMI category.
 *      - List all the members' weight and height both imperically and metrically.
 *      
 * </pre>
 * @author Paddy Murphy 
 * @version 23.0 (21.02.17)
 */
public class Gym
{
    private String gymName;
    private String managerName;
    private String phoneNumber;
    private ArrayList<Member> members;
    
    /**
     * <pre>
     * Constructor for objects of class Gym. Within this constructor, the phone number instance field is set to "unknown" and the members 
     * ArrayList is instantiated.
     * </pre>
     * @param 
     * <pre>gymName The gym name must be more than 30 characters. If the entered name exceeds 30 characters, the extra characters
     *will be truncated and only the first 30 characters will be retained.
     *managerName - No validation is performed an the manager name field.
     * </pre>
     */
    public Gym (String gymName, String managerName)
    {
       if (gymName.length() > 30)
       {
           this.gymName = gymName.substring(0, 30);
       }
       else
       {
           this.gymName = gymName;
       }
       this.managerName = managerName;
       this.phoneNumber = "unknown";
       members = new ArrayList<Member>();
    }
    
    /**
     * 
     * Constructor for objects of class Gym. Within this constructor, the members ArrayList is instantiated.
     * 
     * @param
     *<pre>gymName - The gym name must be no more than 30 characters. If the entered name exceeds 30 characters, the extra characters 
     *will be truncated and only the first 30 characters will be retained.
     *managerName - No validation is performed on the manager field.
     *phoneNumber - A check is done on the phone number to ensure that it is a number. If the phone number is not a number, it is set
     *to "unknown".
     * </pre>
     */
    public Gym (String gymName, String managerName, String phoneNumber)
    {
       if (gymName.length() > 30)
       {
           this.gymName = gymName.substring(0, 30);
       }
       else
       {
           this.gymName = gymName;
       }
       this.managerName = managerName;
       if ((phoneNumber.length() > 0) && (phoneNumber.matches("[0-9]+")))
       {
           this.phoneNumber = phoneNumber;
       }
       else
       {
           this.phoneNumber = "unknown";
       }
       members = new ArrayList<Member>(); 
    }
    
    /**
     * 
     * Adds a member to the gym collection.
     * 
     * @param member The member object that will be added to the gym collection.
     * 
     */
    public void add(Member member)
    {
        members.add(member);
    }
    
    /**
     * 
     * Returns the name of the gym.
     * 
     * @return the gym name
     * 
     */
    public String getGymName()
    {
        return gymName;
    }
    
    /**
     * 
     * Returns the name of the manager
     * 
     * @return the manager name
     */
    public String getManagerName()
    {
        return managerName;
    }
    
    /**
     * Returns the phone number of the gym
     * 
     * @return the gym phone number
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    /**
     * 
     * List all the members of a specific BMI category.
     * 
     * 
     * @param
     * <pre>category - The category you wish to search members by.
     *      
     * The specific categories are:
     *       "VERY SEVERELY UNDERWEIGHT"
     *       "SEVERELY UNDERWEIGHT"
     *       "UNDERWEIGHT"
     *       "NORMAL"
     *       "OVERWEIGHT"
     *       "MODERATELY OBESE"
     *       "SEVERELY OBESE"
     *       "VERY SEVERELY OBESE"
     *        
     * This method also allows you to search by any key words e.g. "OBESE" will return members in the following categories:
     *       "MODERATELY OBESE"
     *       "SEVERELY OBESE"
     *       "VERY SEVERELY OBESE"
     * Note:     In this situation, the members are not sorted by category, they are just displayed as is.
     * </pre>
     * @return
     * <pre>The list of members whose BMI falls into the category passed as a parameter.
     *      
     * If there are no members in the BMI category, the message
     *     "There are no members in the gym in this BMI category" should be returned.
     *              
     * If there are no members in the gym, the message
     *     "There are no members in the gym" should be returned.
     * </pre>
     */
    public String listBySpecificBMICategory(String category)
    {
        if (members.size() > 0)
        {
            String membersBMICategory = "";
            category = category.toUpperCase();
            //for (int index = 0; index < members.size(); index++)
            //Changed the above line of code to a For Each as it allows me to get rid of '.get(index)', thus making code shorter.
            for(Member member : members)
            {
                if (member.determineBMICategory().contains(category))
                {
                    membersBMICategory = membersBMICategory + member.toString() + "\n\n";
                }
            }
            if(membersBMICategory.equals(""))
            {
                return "There are no members in the gym in this category";
            }
            else
            {
                return membersBMICategory;
            }
        }
        else
        {
            return "there are no members in the gym";
        }
    }

    /**
     * List all the members' weight and height both imperically and metrically.
     * 
     * @return
     * <pre>Each member in the gym with the weight and height listed both imperically and metrically.
     *      
     * The format of the output is like so:
     *          
     *     Joe Soap:   xx kg (xxx lbs)       x.x metres (xx inches).
     *     Joan Soap:  xx kg (xxx lbs)       x.x metres (xx inches).
     *          
     * If there are no members in the gym, the message
     *     "There are no members in the gym" should be returned.
     *    </pre>
     */
    public String listMemberDetailsImperialAndMetric()
    {
        if (members.size() > 0)
        {
            String listOfMembersImpAndMet = "";
            //for (int index = 0; index < members.size(); index++)
            //Changed the above line of code to a For Each as it allows me to get rid of '.get(index)' below, thus making code shorter.
            for(Member member : members)
            {
                listOfMembersImpAndMet = listOfMembersImpAndMet + member.getMemberName() + ":\t" 
                                                                + member.getStartingWeight() + " kg (" 
                                                                + member.convertWeightKGtoPounds() + " lbs)\t" 
                                                                + member.getHeight() + " metres (" 
                                                                + member.convertHeightMetresToInches() + " inches).\n";
            }
            return listOfMembersImpAndMet;
        }
        else
        {
            return "There are no members in the gym";
        }
    }
    
    /**
     * Returns a String representing all the members stored in the gym collection.
     * 
     * @return
     *<pre>String representing all the members stored in the gym collection. The String returned is similar to this structure, with the preceeding number representing the index number of the 
     *member within the collection:
     *      
     *    0: member's toString() format
     *    1: member's toString() format
     *    2: member's toString() format
     */
    public String listMembers()
    {
        if (members.size() > 0)
        {
            String listOfMembers = "";
            for(int index = 0; index < members.size(); index++)
            {
                listOfMembers = listOfMembers + index + ": " + members.get(index).toString() + "\n\n";
                //listOfMembers = listOfMembers + member.toString() + "\n\n";
            }
            return listOfMembers;
            
        }
        else
        {
            return "There are no members in the gym";
        }
    }
    
    /**
     * List all the members that have an ideal starting weight.
     * 
     * @return 
     * <pre>The list of members (i.e use the toString method here) that have an ideal starting weight based on the devine method.
     *      
     * If there are no members with an ideal starting weight, the message
     *     "There are no members in the gym with an ideal weight" should be returned.
     *          
     * If there are no members in the gym, the message
     *     "There are no members in the gym" should be returned.
     * </pre>
     */
    public String listMembersWithIdealWeight()
    {
        if (members.size() > 0)
        {
            String membersIdealWeight = "";
            for (int index = 0; index < members.size(); index++)
            {
                if(members.get(index).isIdealBodyWeight() == true)
                {
                membersIdealWeight =  membersIdealWeight + members.get(index).toString() + "\n\n";
                }
            }
            if(membersIdealWeight.equals(""))
            {
                return "There are no members with an ideal weight";
            }
            else
            {
                return membersIdealWeight;
            }
        }
        else
        {
            return "there are no members in the gym";
        }
    }
    
    /**
     * Returns the number of members stored in the gym collection.
     * 
     * @return The number of member object currently stored in the gym collection.
     */
    public int numberOfMembers()
    {
        return members.size();
    }
    
    /**
     * Removes a member from the gym collection.
     * 
     * @param index The index number of the member that will be removed from the gym collection.
     */
    public void remove(int index)
    {
        if((index >= 0) && (index < members.size()))
        {
            members.remove(index);
        }
    }
    
    /**
     * 
     * Updates the gym name field
     * 
     * @param
     *<pre>gymName The gym name must be no more than 30 characters. If the entered name exceeds 30 characters, the extra characters will be
     *truncated and only the first 30 characters will be retained.
     * </pre>
     */
    public void setGymName(String gymName)
    {
       if (gymName.length() > 30)
       {
           this.gymName = gymName.substring(0, 30);
       }
       else
       {
           this.gymName = gymName;
       }
    }
    
    /**
     * 
     * Updates the manager name field
     * 
     * @param managerName No validation is performed in the manager name field.
     * 
     */
    public void setManagerName(String managerName)
    {
        this.managerName = managerName;
    }
    
    /**
     * 
     * Updates the manager name field
     * 
     * @param
     *<pre>phoneNumber A check is done on the phone number to ensure that it is a number. If the phone number is not a number, it is not
     *updated.</pre>
     * 
     */
    public void setPhoneNumber(String phoneNumber)
    {
        if ((phoneNumber.length() > 0) && (phoneNumber.matches("[0-9]+")))
       {
           this.phoneNumber = phoneNumber;
       }
    }
    
    /**
     * 
     * Returns a human-readable String representation of the object state.
     * 
     * @return <pre>a String version of the Gym object. The String returned is similar to this structure:
     *      
     *     Gym name: High Flyer Gym, Manager: Eddie the Eagle, Phone Number: 0519665654343.
     *          
     *     List of members in the gym:
     *     (list all of the members here)
     * </pre>
     */
    public String toString()
    {
        return "Gym Name: " + gymName
                + ", Manager: " + managerName
                + ", PhoneNumber: " + phoneNumber
                + ".\n\nList of members in the gym:\n" + listMembers();
    }
}
