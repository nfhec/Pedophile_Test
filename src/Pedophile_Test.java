import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

//Start program by getting players age
public class Pedophile_Test {
    public static void main (String[]args) {
        GetInput();

    }


    public static void GetInput() {
        System.out.println("What is your age(Must be an integer)-  ");
        var age = GetAge(); // get the players age
        if (age > 100) { //make sure the input is a valid age
            System.out.println("That is too old, no one would be your partner at such an age. \nTry again.");
            GetInput();
        }
        else if (age < 1) {
            System.out.println("You cannot be younger than 1! Nice try, put your actual age in.");
            GetInput();
        }
        else { //check if the player is a minor or not.
            if (age >= 18) {
                OverEqual();
            }
            else{
                Under();
            }

        }

    }

    public static int GetAge() { // Let's get the players age
        int a = 0;
        try { // See if the input is a valid integer
            Scanner sc = new Scanner(System.in); //Standard intake (System.in)
            a = sc.nextInt();  //reads int input

        }
        catch (InputMismatchException ex) {     //If invalid response,  return :
            System.out.println("Invalid Input! Please try again!!");
            GetInput();

        }
        return a;
    }

    public static void OverEqual() {
        System.out.println("Congrats you are legal! Let's see how old your partner is!");
        var Partners_Age = Age_Selection(); //Call and assign partners age to Partner_Age
        System.out.print("Your partner is " + (Partners_Age) + " years old! "); //print your partners age
        if (18 > Partners_Age) { //Whether the partner is a minor
            System.out.println("You are a pedophile, you're going to jail!");
        }
        else
            System.out.println("You aren't a pedophile! You won't be going to jail!! ");
        repeat();

    }
    public static void Under() {
        System.out.println("You are a minor. Is your partner a pedophile!!?");
        var Partners_Age = Age_Selection(); //Call and assign partners age to Partner_Age
        System.out.print("Your partner is " + Partners_Age + " years old!! ");
        if (18 <= Partners_Age) { //Whether the partner is a minor
            System.out.println("Your partner is a MAJOR PEDO!!");
        }
        else
            System.out.println("No one here is a pedophile. Thank goodness. ");

        repeat();
    }

    public static int RandomAges() { //generate random ages for partner selection
        int min = 1;
        int max = 99;//gen. random integer
        return (int) Math.floor(Math.random() * (max - min + 1) + min);

    }
    public static int Age_Selection() { //have your player select their partners age
        int Partner = 0; //create int to be modified and returned
        int[] ages; //create an array of age options
        ages = new int[6];
        for (int j = 1; j <= 5; j++) {
            ages[j] = RandomAges(); //have each array index have a different element(age)
        }
        System.out.println("What age should your partner be,"); //have player choose from 5 options
        for (int i = 1; i <= 5; i++) { //Offer 5 random partner ages
            System.out.println(i + ": " + ages[i] + " Years old. They are also " + Traits.traits());
        }
        try { //make sure response is between one and five for the selection of their partner
            Scanner chosen_partner = new Scanner(System.in); //Player selects their partner from options

            System.out.println("Which partner do you want (1,2...)?");
            int choice = chosen_partner.nextInt(); //int choice is 1-5 on their partner selection
            Partner = ages[choice]; //use their selection (1-5) to get the array element(age) and assign their partners final age to that
            if (Partner == 0) { //don't allow the player make their partner 0. if player inputs zero here it makes their partners age zero idk why this stop i
                System.out.println("That is not a valid input please try again");
                GetInput();
            }
            else return Partner;
        }
        catch (ArrayIndexOutOfBoundsException ex) {     //If invalid response, return :
            System.out.println("Invalid Input! Please try again!!");
            GetInput();
        }
        return Partner; //return final age to be called upon
    }

    //enable multiple responses without running twice
    public static void repeat() {
        String Yes = "y";
        String No = "n";
        System.out.println("Do you want to play again? (y/n)- ");
        Scanner YesNo = new Scanner(System.in); //get play again (y/n) input
        String b = YesNo.nextLine();

        if (Objects.equals(b, Yes)) {

            GetInput(); //Get players age to play another game
        }
        else if (Objects.equals(b, No)) {
            System.out.println("Thanks for playing!"); //end program
        }
        else {
            System.out.println("That is not a valid input");
            repeat(); //Rerun play again
        }



    }
}
