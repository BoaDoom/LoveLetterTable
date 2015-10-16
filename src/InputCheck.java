
import java.util.*;
public class InputCheck{
  private static Scanner keyboardIn;
  public InputCheck(){
  }
  public static int check(String prompt, int min, int max, ArrayList<Integer> excluded){ //promt should be worded as "Select a number"
    keyboardIn = new Scanner(System.in);
    int testingNumber;
    String excludedString = new String();
    try{
      if (excluded.size() >= 1){   //if  the list of excluded is more than one number, create full name and list of excluded numbers
        excludedString = ", excluding options ";
        for(int i=0; i < excluded.size(); i++){
          excludedString = excludedString + Integer.toString(excluded.get(i)+1);
          if ((excluded.size()-1) != i){
            excludedString = excludedString + ", ";
          }
        }
      }
    }
    catch(Exception e){}
    excludedString = excludedString + ".\n";
    System.out.print(prompt + " (options " + min + "-" + max + ")" + excludedString);

    //checking for integer
    try{
      testingNumber = Integer.parseInt(keyboardIn.nextLine());
    }
    catch(Exception e){
      System.out.println("That was not even a whole number... try again");
      return check(prompt, min, max, excluded);
    }
    //checking for correct number of players
    if (testingNumber < min || testingNumber > max){
      System.out.println("That was not between " + min + " and " + max + "... try again");
      return check(prompt, min, max, excluded);
    }
    try{
      for(int i=0; i < excluded.size(); i++){
        if (excluded.get(i) == (testingNumber-1)){
          System.out.println("that selection is not possible with this card");
          return check(prompt, min, max, excluded);
        }
        else{
        }
      }
    }
    catch(Exception e){
    }
    return testingNumber;

  }


}
