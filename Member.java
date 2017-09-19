
/**
 * <pre>
 * This class is the template for a single Member.
 * 
 * The details stored for a member include:
 * 
 *      Member ID
 *      Member Name
 *      Member Address
 *      Height (in metres)
 *      Starting Weight (in kgs)
 *      
 * Along with the standard constructors, getters, setters and toString methods listed below,
 * there are specific methods that:
 * 
 *          - Convert the weight from KG's to Pounds
 *          - Convert the height from Metres to Inches
 *          - Determines if a start weight is ideal (based on the devine method)
 *          - Calculates the BMI for the member
 *          - Determines the BMI category based in their calculated BMI
 * </pre>
 * 
 * @author Paddy Murphy  
 * @version 23.0 (21.02.17)
 */
public class Member
{
    private int memberId;
    private String memberName;
    private String memberAddress;
    private double height;
    private double startingWeight;
    private String gender;

    /**
     * 
     * Constructor of objects of class Member.
     * 
     * 
     *       
     * @param <pre>memberID The member's id is 6 digits long i.e. between 100000 (exclusive) and 999999 (inclusive). If an invalid
     *member id is entered, set the member id to a default of 100000.
     *memberName - The member's name should be no more than 30 characters. If the entered name exceeds 30 characters,
     *the extra characters will be truncated and only the first 30 characters will be retained.
     *memberAddress - There is no validation on the member's address.
     *height - The member's height is measured in Metres. A minimum height of one metre (inclusive) is allowed and a
     *maximum height of three metres (inclusive).
     *startingWeight - The member's weight upon joining the gym (in Kgs). A minimum weight of 35Kg (inclusive) and a 
     *max of 250Kg (inclusive) is permitted in the gym.
     *gender - The member's gender i.e. can be either "M" or "F". If not specified, default to "Unspecified".</pre>
     *       
     */       
    public Member (int memberId, String memberName, String memberAddress, double height, double startingWeight, String gender)
    {
        if ((memberId > 100000) && (memberId <= 999999))
        {
            this.memberId = memberId;
        }
        else
        {
            this.memberId = 100000;
        }

        if (memberName.length() > 30)
        {
            this.memberName = memberName.substring(0, 30);
        }
        else
        {
            this.memberName = memberName;
        }

        this.memberAddress = memberAddress;

        if ((height >= 1) && (height <= 3))
        {
            this.height = height;
        }
        else
        {
            this.height = 0.0;
        }

        if ((startingWeight >= 35) && (startingWeight <= 250))
        {
            this.startingWeight = startingWeight;
        }
        else
        {
            this.startingWeight = 0.0;
        }
        
        gender = gender.toUpperCase();
        if ((gender.equals("F")) || (gender.equals("M")))
        {
            this.gender = gender;
        }
        else
        {
            this.gender =  "Unspecified";
        }
    }
    
    /**
     * This method calculates the BMI value for the member.
     * 
     * @return the BMI value for the member. The number returned is truncated to two decimal places.
     */
    public double calculateBMI()
    {

        //double bmi =  startingWeight / (height * height);
        //return toTwoDecimalPlaces(bmi);

        //shorter code - 1 line instead of 2 as above.
        return toTwoDecimalPlaces(startingWeight / (height * height));
        //truncate this to 2 decimal places;
    }
    
    /**
    * This method returns the member height converted from metres to inches.
    * 
    * @return member height converted from metres to inches using the formula: meters multiplied by 39.37. The number returned is truncated to two decimal places.
    */
    public double convertHeightMetresToInches()
    {
        //double heightToInches = height * 39.37;
        //return toTwoDecimalPlaces(heightToInches);
        return toTwoDecimalPlaces(height * 39.37);
        //truncate this to 2 decimal places;

    }
    
    /**
     * This method returns the member weight converted from KGs to pounds.
     * 
     * @return member weight converted from KGs to pounds. The number returned is truncated to two decimal places.
     */
    public double convertWeightKGtoPounds()
    {
        //double weightToPounds = startingWeight * 2.2;
        //return toTwoDecimalPlaces(weightToPounds);
        return toTwoDecimalPlaces(startingWeight * 2.2);
        //truncate this to 2 decimal places;
    }
    
    /**
     * The method truncates a double to 2 decimal places.
     */
    public double toTwoDecimalPlaces(double num)
    {
        return (int)(num * 100) / 100.0;
    }
    
    /**
     * This method determines the BMI category that the member belongs to.
     * 
     *  The category is determined by the magnitude of the members BMI according to the following:
     *  <pre>
     *  
     *      BMI less than    15   (exclusive)                      is "VERY SEVERELY UNDERWEIGHT"
     *      BMI between      15   (inclusive) and 16   (exclusive) is "SEVERELY UNDERWEIGHT"
     *      BMI between      16   (inclusive) and 18.5 (exclusive) is "UNDERWEIGHT"
     *      BMI between      18.5 (inclusive) and 25   (exclusive) is "NORMAL"
     *      BMI between      25   (inclusive) and 30   (exclusive) is "OVERWEIGHT"
     *      BMI between      30   (inclusive) and 35   (exclusive) is "MODERATELY OBESE"
     *      BMI between      35   (inclusive) and 40   (exclusive) is "SEVERELY OBESE"
     *      BMI greater then 40   (inclusive)                      is "VERY SEVERELY OBESE"
     * </pre>
     * 
     * @return <pre>The format of the String is similar to this (note the double quotes around the category):
     *      "NORMAL".</pre>
     */
    public String determineBMICategory()
    {
        if (calculateBMI() < 15)
        {
            return "VERY SEVERELY UNDERWEIGHT";
        }
        else if ((calculateBMI() >= 15) && (calculateBMI() < 16))
        {
            return "SEVERELY UNDERWEIGHT";
        }
        else if ((calculateBMI() >= 16) && (calculateBMI() < 18.5))
        {
            return "UNDERWEIGHT";
        }
        else if ((calculateBMI() >= 18.5) && (calculateBMI() < 25))
        {
            return "NORMAL";
        }
        else if ((calculateBMI() >= 25) && (calculateBMI() < 30))
        {
            return "OVERWEIGHT";
        }
        else if ((calculateBMI() >= 30) && (calculateBMI() < 35))
        {
            return "MODERATELY OBESE";
        }
        else if ((calculateBMI() >= 35) && (calculateBMI() < 40))
        {
            return "SEVERELY OBESE";
        }
        else //(calculateBMI() >= 40)
        {
            return "VERY SEVERELY OBESE";
        }
    }
    
    /**
     * Returns the member's height.
     * 
     * @return the member's height
     */
    public double getHeight()
    {
        return height;
    }

    /**
     * Returns the member's address.
     * 
     * @return the member's address
     */
    public String getMemberAddress()
    {
        return memberAddress;
    }

    /**
     * Returns the member's gender.
     * 
     * @return the member's gender
     */
    public String getMemberGender()
    {
        return gender;
    }

    /**
     * Returns the id for the member.
     * 
     * @return the member's id
     */
    public int getMemberId()
    {
        return memberId;
    }
    
    /**
     * Returns the member's name.
     * 
     * @return the member's name
     */
    public String getMemberName()
    {
        return memberName;
    }
    
    /**
     * Returns the member's starting weight.
     * 
     * @return the member's starting weight
     */
    public double getStartingWeight()
    {
        return startingWeight;
    }
    
    /**
     * <pre>
     * This method returns a boolean to indicate if the member has an ideal body weight based on the Devine formula.
     *  For males, an ideal body weight is:     50 kg + 2.3 kg for each inch over 5 feet.
     *  For females, an ideal body weight is:   45.5 kg for each inch over 5 feet.
     *  
     *  Note:   if no gender is specified, return the result of the female calculation.
     *  </pre>
     *  @return Returns true if the result of the devine formula is within 2 kgs (inclusive) of the starting weight; fals if it is outside this range.
     */
    public boolean isIdealBodyWeight()
    {
        double heightToInches = convertHeightMetresToInches();
        int fiveFeet = 60;
        double idealBodyWeight = 0.0;
        
        if(heightToInches <= fiveFeet)
        {
            if(gender.equals("M"))
            {
                idealBodyWeight = 50;
            }
            else
            {
                idealBodyWeight = 45.5;
            }
        }
        else
        {
            if(gender.equals("M"))
            {
                idealBodyWeight = 50 + (2.3 * (heightToInches - fiveFeet));
            }
            else
            {
                idealBodyWeight = 45.5 + (2.3 * (heightToInches - fiveFeet));
            }
        }

        if ((idealBodyWeight >= (startingWeight - 2)) && (idealBodyWeight <= (startingWeight + 2))) 
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Updates the member's gender field.
     * 
     * @param gender The member's gender i.e. can be either "M" or "F". All other values are ignored.
     */
    public void setGender (String gender)
    {
        gender = gender.toUpperCase();
        if ((gender.equals("F")) || (gender.equals("M")))
        {
            this.gender = gender;
        }
    }

    /**
     * Updates the member height field.
     * 
     * @param height The member's height is measured in Metres. A minimum height of one metre is allowed and a maximum height of three metres.
     */
    public void setHeight (double height)
    {
        if ((height >= 1) && (height <= 3))
        {
            this.height = height;
        }
    }

    /**
     * Updates the member address field.
     * 
     * @param memberAddress There is no validation on the member's address.
     */
    public void setMemberAddress (String memberAddress)
    {
        this.memberAddress = memberAddress;
    }

    /**
     * Updates the member id field.
     * 
     * @param memberID The member's id is 6 digits long i.e. between 100000 (exclusive) and 999999 (inclusive).
     */
    public void setMemberId (int memberId)
    {
        if ((memberId > 100000) && (memberId <= 999999))
        {
            this.memberId = memberId;
        }
    }

    /**
     * Updates the member name field.
     * 
     * @param memberName The member's name should be no more than 30 characters. If the name exceeds 30 characters, the extra characters will be truncated and only only the first 30 characters will be retained.
     */
    public void setMemberName (String memberName)
    {
        this.memberName = memberName;
        if (memberName.length() > 30)
        {
            this.memberName = memberName.substring(0, 30);
        }
    }

    /**
     * Updates the member starting weight field.
     * 
     * @param startingWeight The member's weight upon joining the gym (in kgs). A minimum weight of 35kg and a maximum of 250kg is permitted in the gym.
     */
    public void setStartingWeight (double startingWeight)
    {
        if ((startingWeight >= 35) && (startingWeight <= 250))
        {
            this.startingWeight = startingWeight;
        }      
    }

    /**
     * Returns a human-readable String representation of the object state. 
     * 
     * @return a string version of the Member object. The String returned is similar to this structure:
     * <pre>
     * 
     *    Member id: 123456, Name: Joe Soap, Address: 12 High Street, Waterford.
     *        Height: 2 metres, Starting Weight: 74 kgs, BMI of 18.5 (Normal).
     * </pre>
     */
    public String toString()
    {
        return  "Member id: " + memberId 
        + ", Name: " + memberName
        + ", Address: " + memberAddress
        + ".\n\tHeight: " + height 
        + " metres, Starting Weight: " + startingWeight
        + " kgs, BMI of " + calculateBMI() + " (" + determineBMICategory() + ")."; 
    }

}
