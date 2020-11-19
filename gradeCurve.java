import java.util.*;
public class gradeCurve
{
   public static void main(String[] args)//Main method. Runs program initially once, 
                                        //and then as many times as user wants.
   {
      Scanner s = new Scanner(System.in);
      boolean runAgain = true;
      do
      {
         runProgram(s);
         runAgain = runAgain(s);
      }while(runAgain == true);
      System.out.println("Have a nice day!");
   }
////////////////////////////////////////////////////////////////////////////
   public static void runProgram(Scanner s)//This method compiles and runs the individual parts of the program.
   {
      displayIntro();
      int[] score = createArray(s);
      int best = bestGrade(score);
      outputResult(score, best);
   }
///////////////////////////////////////////////////////////////////////////
   public static boolean runAgain(Scanner s)//This method is robust, passes the Scanner class and 
                                           //determines whether or not to run the program again based on the user input.
   {
      s.nextLine();
      boolean runAgain = true;
      System.out.println("Do you have another test to run? ");
      String user = s.nextLine();
      while(!user.equalsIgnoreCase("yes") && !user.equalsIgnoreCase("no"))
      {
         System.out.println("Please enter yes or no: ");
         user = s.nextLine();
      }
      if(user.equalsIgnoreCase("yes"))
      {
         runAgain = true;
      }
      else if(user.equalsIgnoreCase("no"))
      {
         runAgain = false;
      }
      return runAgain;
   }

///////////////////////////////////////////////////////////////////////////
   public static int[] createArray(Scanner s)//This method creates the array, and calls the method 
                                            //validInput() to determine if the user's input is in fact valid.
   {
      int i = 0;
      int prompt = 0; 
      prompt = validInput(s, prompt);
      int[] score = new int[prompt];//Creates array.
      for(i = 0; i < prompt; i++)
      {
         System.out.print("Enter grade " + (i+1) + ": ");
         while(!s.hasNextInt())
         {
            System.out.print("Invalid, enter grade " + (i+1) + ": ");
            s.next();
         }
         score[i] = s.nextInt(); 
      }
      return score;//Returns the array score, to be used in other methods.
   }
///////////////////////////////////////////////////////////////////////////
   public static int validInput(Scanner s, int prompt)//This method determines if the user's 
                                                     //input is valid in the createArray() method.
   {
      System.out.println("Enter the number of students: ");
      while(!s.hasNextInt())
      {
         System.out.println("Ivalid, enter the number of students: ");
         s.next();
      }
      prompt = s.nextInt();
      return prompt;
   }
///////////////////////////////////////////////////////////////////////////
   public static int bestGrade(int[] score)//Determines which score in the array 
                                          //is of the highest value, and then returns that score.
   {
      int best = score[0];
      for(int i = 1; i < score.length; i++)
      {
         if(score[i] > best)//If the score at the index[i] is of a higher value 
                           //than the last recorded best score, then score[i] is set equal to best.
                            
            best = score[i];
      }
      return best;
   }
///////////////////////////////////////////////////////////////////////////
   public static void outputResult(int[] score, int best)//This method formats and outputs the results of the program.
   {
      System.out.println("\nHere are your results: ");
      System.out.printf("%s", "Student");
      System.out.printf("%10s", "Score");
      System.out.printf("%13s", "Grade\n");
      int individualScore = 0;
      String grade = "";
      for(int i = 0; i < score.length; i++)
      {
         individualScore = score[i];//This line sets individualScore to a value at each separate 
                                   //index of the array, and passes it to the letterGrade() method in the next line.
                                    
         grade = letterGrade(individualScore, best);//This line calls the method letterGrade() 
                                                   //in order to assign letter values to each score.
         System.out.printf("%7d", i+1);
         System.out.printf("%10d", score[i]);
         System.out.printf("%12s\n", grade);  
      }  
      System.out.println();
   }
///////////////////////////////////////////////////////////////////////////
   public static String letterGrade(int individualScore, int best)//This method accepts an individual score 
                                                                 //and compares it to the best score.
   {
      String grade = "";
      {
         if(individualScore >= (best-10))
         {
            grade = "A";
         }
         else if(individualScore >= (best-20))
         {
            grade = "B";
         }
         else if(individualScore >= (best-30))
         {
            grade = "C";
         }
         else if(individualScore >= (best-40))
         {
            grade = "D";
         }
         else
         {
            grade = "F";
         }
      }
      return grade;
   }
/////////////////////////////////////////////////////////////////////////
   public static void displayIntro()//This method displays the intro.
   {
      System.out.println();
      System.out.println("      Welcome to the Grading Program!      ");
      System.out.println("===========================================");
      System.out.println("You will be prompted to enter the number of");
      System.out.println("students that you have to grade. Next, you");
      System.out.println("will need to enter the scores. The results");
      System.out.println("will print in a table with the weighted grades.");
   }
}