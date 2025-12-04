package BarangayManagementSystem;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Validations {
        public String validateGender(Scanner scan) {
        String gender = "";
        boolean isRunning = true;
        while (isRunning) {
         System.out.print("Enter your gender: ");
            gender = scan.nextLine();
            if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("m")) {
                gender = "Male";
                isRunning = false;
            }
            else if (gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("f")) {
                gender = "Female";
                isRunning = false;
            }
            else {
                System.out.println("Please entera a proper gender");
            }
        }
        return gender;
    }
    public String validateContactNumber(Scanner scan) {
        String contactNumber = "";
        boolean isRunning = true;
        while (isRunning) {
            System.out.print("Enter your Contact Number: ");
            contactNumber = scan.nextLine();
            // (Number.matches("^09\\d{9}$") || Number.matches("^\\+639\\d{9}$")
            if (!contactNumber.matches("^09\\d{9}$") || contactNumber.matches("^\\+639\\d{9}$")) {
                System.out.println("Invalid Philipphine Number Format, Please try again");
            }
            else {
                isRunning = false;
            }
        }
        return contactNumber;
    }

    public int validateAge(Scanner scan, String dateOfBirth) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM-d-yyyy"); 
    LocalDate birthDate = LocalDate.parse(dateOfBirth, formatter);
    LocalDate today = LocalDate.now();

    return Period.between(birthDate, today).getYears();
    
    }

    public String validateCivilStatus(Scanner scan) {
        while (true) {
            System.out.println("S - Single");
            System.out.println("M - Married");
            System.out.println("D - Divorced");
            System.out.println("W - Widowed");
            System.out.println("E - Seperated");
            System.out.println("C - Civil Partnership");
            System.out.print("Enter your Civil Status: ");
            String civilStatusChoice = scan.nextLine().trim().toUpperCase();
            switch (civilStatusChoice) {
                case "S" -> {return "Single";}
                case "M" -> {return "Married";}
                case "D" -> {return "Divorced";}
                case "W" -> {return "Widowed";}
                case "E" -> {return "Seperated";}
                case "C" -> {return "Civil Partnership";}
                default ->{ 
                    System.out.println("Please enter only from the choices given");
                    continue;
                }
            }
        }
     
    }

	public String validateDateOfBirth(Scanner scan) {
		boolean isRunning = true;
		String month = "";
		String day = "";
		String year = "";
		while (isRunning) {
			System.out.print("Enter the month of your birthday E.G 1 for january: ");

			try {
			byte monthchoose = scan.nextByte();
			 month= "";
			switch (monthchoose) {
			case 1 -> month = "January";
			case 2 -> month = "February";
			case 3 -> month = "March";
			case 4 -> month = "April";
			case 5 -> month = "May";
			case 6 -> month = "June";
			case 7 -> month = "July";
			case 8 -> month = "August";
			case 9 -> month = "September";
			case 10 -> month = "October";
			case 11 -> month = "November";
			case 12 -> month = "December";
			default -> {
				System.out.println("Please choose something properly");
				continue;
				}
			}
			System.out.print("Enter the date of your birth: ");
			byte dayscan = scan.nextByte();
			 day = "";
			if (dayscan <= 0 || dayscan > 31) {
				System.out.println("Please enter a proper date");
				continue;
			}
			else {
				day = Integer.toString(dayscan);
			}
			System.out.print("Enter the year of your Birth: ");
			int yearscan = scan.nextInt();
			 year = "";
			if (yearscan < 1950 || yearscan > 2007) {
				System.out.println("Please enter a proper birthyear");
				continue;
			}
			else {
				year = Integer.toString(yearscan);
			}
			}catch (Exception e) {
				System.out.println("Please enter a proper answer");
				scan.nextLine();
				continue;
			}
			isRunning = false;
		}
	
	
	return month + "-" + day + "-" +  year;
	}

        public String validatePassword(Scanner scan) {
		boolean isRunning = true;
		String password = "";
		while (isRunning) {
			System.out.print("Enter your password: ");
			password = scan.nextLine();
			if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")) {
				System.out.println("Please enter a proper password format must have \n Minimum 8 characters, at least 1 uppercase, 1 lowercase, 1 digit");
			}
			else {
				isRunning = false;
			}
		}
        return password;
    }
    public String validateEmail(Scanner scan) {
		boolean isRunning = true;
		String email = "";
		while (isRunning) {
			System.out.print("Enter your email: ");
			email = scan.nextLine();
			if (!email.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+mail\\.com$")) {
				System.out.println("Please enter a proper email format");
			}
			else {
				isRunning = false;
			}
		}
        return email;
    }
}
