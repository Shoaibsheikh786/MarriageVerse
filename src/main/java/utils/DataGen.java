package utils;

import java.util.Random;

import com.github.javafaker.Faker;

public class DataGen {
	

	Faker faker=new Faker();
	
	
	public String getPincode() {
		
		Long pcode=faker.number().numberBetween(99999l, 999999l);
		return pcode.toString();
	}
	
	public String getFullName()
	{
		return faker.name().fullName();
	}
	
	public String getEmail()
	{
		String s= faker.internet().emailAddress();
	     s= s.replaceFirst("\\.", "");
	     return s;
	}
	
	public String getNumber()
	{      
		String ph=faker.number().digits(10);
		

		ph=ph.substring(0, 10);
		Character ch=ph.charAt(0);
		ph=ph.replace(String.valueOf(ch),"9");

		return ph;
	}
	public   String getPassword()
	{
		return faker.internet().password(8, 15)+"U@1";
	}
	
	public  String generateFakePan() {
        // Generate random characters for the PAN number
        StringBuilder panNumber = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            // Generate a random uppercase letter
            char randomChar = (char) (random.nextInt(26) + 'A');
            panNumber.append(randomChar);
        }
        // Generate random digits for the PAN number
        for (int i = 0; i < 4; i++) {
            // Generate a random digit between 0 and 9
            int randomDigit = random.nextInt(10);
            panNumber.append(randomDigit);
        }
        // Generate a random uppercase letter for the last character of the PAN number
        char lastChar = (char) (random.nextInt(26) + 'A');
        panNumber.append(lastChar);
        return panNumber.toString();
    }	
	public static int generateMonth() {
        Random random = new Random();
        return random.nextInt(12) + 1; // Generates a number between 1 and 12
    }
    
    // Method to generate a random day (1 to 31)
    public static int generateDay() {
        Random random = new Random();
        return random.nextInt(26) + 1; // Generates a number between 1 and 31
    }
    
    // Method to generate a random year from 1924 to 2023
    public static int generateYear() {
        Random random = new Random();
        return random.nextInt(2023 - 1924 + 1) + 1924; // Generates a number between 1924 and 2023
    }
    
    public String getFirstName()
    {
    	return faker.name().firstName();
    }
    
    public String getLastName()
    {
    	return faker.name().lastName();
    }
    
    public static int generateRandomReligion() {
        Random random = new Random();
        // Generates a number between 2 and 12 (inclusive)
        int num=random.nextInt(11) + 2;
        if(num==8||num==9||num==10||num==12||num==11)
        	return 5;
        return num;
    }
    
    public static int selectRandomSalary() {
        Random random = new Random();
        // Generates a number between 3 and 13 (inclusive)
        return random.nextInt(11) + 3;
    }
    
    public static int selectRandomOccupation() {
        Random random = new Random();
        // Generates a number between 3 and 13 (inclusive)
        return random.nextInt(11) + 3;
    }
    
    public static int selectRandomLanguage() {
        Random random = new Random();
        // Generates a number between 3 and 13 (inclusive)
        return random.nextInt(11) + 3;
    }
    
    //Generate city
    public static String generateThreeCharacters() {
    	
    	Faker faker=new Faker();
    	;
//        StringBuilder result = new StringBuilder(3);
//        Random random = new Random();
//
//        for (int i = 0; i < 3; i++) {
//            // Generate a random character between 'a' (97) and 'z' (122)
//            char randomChar = (char) (random.nextInt(26) + 'a');
//            result.append(randomChar);
//        }
         String  city=faker.address().city() ;
         
         
      //   System.out.println(city);
        return city.substring(0, 3);
    }
   


}
