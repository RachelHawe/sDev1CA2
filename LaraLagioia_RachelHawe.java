/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laralagioia_rachelhawe;

/*
 * This program...
 * 25/11/2016
 * Lara Lagioia - X00141126 & Rachel Hawe - X00127602
 */

import java.util.Scanner;

public class LaraLagioia_RachelHawe {

    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        final int ATTEMPTS = 3;
        final char X_CHECK = 'X';
        final double FEES = 3000.00;
        final int GRANT_100 = 100;
        final int GRANT_75 = 75;
        final int GRANT_50 = 50;
        final int GRANT_0 = 0;

        String username, password, password1, studentName, studentNumber, choice2, categoryMoreGrants;
        int usernameAttempts, passwordAttempts, choice;
        int sDevMark, mathsMark, l2LMark, compArchMark;
        int studentsProcessed =0, grant =0, studentsInGrant =0, students100Grant =0, students75Grant = 0, students50Grant = 0, studentsNoGrant =0;
        double avarage=0, studentOverallAvarage =0, grantFees =0, nonGrantFees =0, fees=0;
        char choice2Char;

        //input username
        System.out.print("Please enter your username: ");
        username = user_input.next();

        usernameAttempts = 0;

        /* Check if the username is at least 6 charcters long and, if it exceeds 
         * three atempts to enter, terminates the program. 
         */
        while (username.length() < 6) {
            if (usernameAttempts == ATTEMPTS) {
                System.out.println("\nSorry, number of valid attempts exceeded. \nPlease, start again.");
                System.exit(0);
            }

            System.out.print("Username invalid. Please, re-enter: ");
            username = user_input.next();
            usernameAttempts++;
        }

        //input password
        System.out.print("\nPlease enter your password: ");
        password = user_input.next();
        System.out.print("Please re-enter your password: ");
        password1 = user_input.next();

        passwordAttempts = 1;

        /* Check if the two password match and, if it they don't, re-enter them 
         * up to three atempts in total. Otherwise, terminates the program. 
         */
        while (password.equals(password1) == false) {
            if (passwordAttempts == ATTEMPTS) {
                System.out.println("\nSorry, number of valid attempts exceeded. \nPlease, start again.");
                System.exit(0);
            }

            System.out.print("\nPasswords don't match. \nPlease, enter your password: ");
            password = user_input.next();
            System.out.print("Please re-enter your password: ");
            password1 = user_input.next();
            passwordAttempts++;
        }
  
        //display Menu and input choice
        do {
            System.out.println("\n+-----------------------------------------+");
            System.out.println("|        Student Finance System           |");
            System.out.println("| 1. Calculate Student Grant              |");
            System.out.println("| 2. Current Overall Student Average      |");
            System.out.println("| 3. Fee Data                             |");
            System.out.println("| 4. Grant Category Information           |");
            System.out.println("| 5. Exit                                 |");
            System.out.println("+-----------------------------------------+");
            System.out.print("\nPlease, enter your menu option: ");
            choice = user_input.nextInt();

            switch (choice) 
            {
                case 1: 
                {
                    System.out.println("Please Enter your Student Name: ");
                    studentName=user_input.next();
                    System.out.println("Please Enter your Student Number: ");
                    studentNumber=user_input.next();
                    
                    choice2=user_input.nextLine();
        
                    choice2Char=choice2.charAt(0);
                    
                    do
                    {
                        System.out.println("Please, enter the result for Software Development(0-100): ");
                        sDevMark=user_input.nextInt();
                        
                        System.out.println("Please, enter the result for Mathematics(0-100): ");
                        mathsMark=user_input.nextInt();
                        
                        System.out.println("Please, enter the result for Learning to Learn(0-100): ");
                        l2LMark=user_input.nextInt();
                        
                        System.out.println("Please, enter the result for Computer Architecture(0-100): ");
                        compArchMark=user_input.nextInt();
                        
                        avarage=((sDevMark + mathsMark + l2LMark + compArchMark)/4);
                        
                        studentsProcessed=(studentsProcessed + 1);
                        
                        studentOverallAvarage=(studentOverallAvarage+avarage/studentsProcessed);
                        
                        if (avarage>=90)
                        {
                            grant = GRANT_100*100;
                            students75Grant=students75Grant+1;
                            studentsInGrant=studentsInGrant+1;
                        }
                        else if (avarage >=70)
                        {
                            grant = GRANT_75*100;
                            students100Grant=students100Grant+1;
                            studentsInGrant=studentsInGrant+1;
                        }
                        else if (avarage >=50)
                        {
                            grant = GRANT_50*100;
                            students50Grant=students50Grant+1;
                            studentsInGrant=studentsInGrant+1;
                        }
                        else 
                        {
                            grant = 0;
                            studentsNoGrant=studentsNoGrant+1;
                            
                            fees= fees - grant;
                            grantFees = grantFees + grant;
                            nonGrantFees= nonGrantFees + fees;
                            
                            System.out.println("Student n=Name: " + studentName);
                            System.out.println("Student Number: " + studentNumber);
                            System.out.println("Average of Grades: " + avarage);
                            System.out.println("Percentage amount of grants alocated: " + grant + "%");
                            System.out.println("Fees due by the student: €" + fees);
                                 
                        }
                    }
                    
                    while(choice2Char.equals('X'));
                    
                    System.out.println(studentNumber + " is invalid. Please, try again with uppercase X: ");
                    System.out.println("Please Enter your Student Name: ");
                    studentName=user_input.next();
                        
                    
                    break;
                }

                case 2: 
                {
                    System.out.println("The current overall student avarage results is: " + studentOverallAvarage);
                                        
                    break;
                }

                case 3: 
                {
                    System.out.println("The overall fees paid by grant to the college is: €" + grantFees);
                    System.out.println("The overall fees paid by students to the college is: €" + nonGrantFees);
                    System.out.println("The total number of students processed is: " + studentsProcessed);
                    System.out.println("The total number of students in grant is: " + studentsInGrant);
                    
                    break;
                }

                case 4: 
                {
                    System.out.println("The number of Students in 100% grants is: " + students100Grant);
                    System.out.println("The number of Students in 75% grants is: " + students75Grant);
                    System.out.println("The number of Students in 50% grants is: " + students50Grant);
                    System.out.println("The number of Students not in grants is: " + studentsNoGrant);
                    
                    if (students100Grant > students75Grant)
                    {
                        //categoryMoreGrants= "100% grant given"
                    }   
                    else
                    {
                        //categoryMoreGrants="75% grant given"
                    }
                        
                        
                        
                        
                    break;
                }

                case 5: {  //exits switch and doesn't print the invalid choice option
                    break;
                }

                default: {
                    System.out.println("Invalid choice. Please, enter a valid option.");
                }
            }

        } while (choice != 5);

        System.out.println("\nThank you for using our system.");
    }
}
