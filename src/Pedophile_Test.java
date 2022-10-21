import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

//Start program by getting players age
public class Pedophile_Test {
    static final String[] partner_traits = Traits.selections(); //new final array to store partner traits
    static final int[] partner_ages = Ages.ages(); //new final array to store partner ages
    static int Partner = 0; //store selected partners age
    static String Trait = null;

    public static void main (String[]args) {
        GetInput();
    }


    public static void GetInput() {
        System.out.println("What is your age(Must be an integer)-  ");
        var age = StoreAge(); // get the players age
        if (age > 100) { //make sure the input is a valid age
            System.out.println("That is too old, no one would be your partner at such an age. \nTry again.");
            GetInput();
        }
        else if (age < 1) {
            System.out.println("You cannot be younger than 1! Nice try, put your actual age in.");
            GetInput();
        }
        else { //check if the player is a minor or not.
            partner_choices();//have player see choices and select their partner
            if (age >= 18) {
                OverEqual();//execute endings using selected partner age
            }
            else{
                Under(); //execute endings using selected partner age
            }

        }

    }
    public static int StoreAge() { //store the players age to be used whenever
       final int age = GetAge();
       return age;
    }
    public static int GetAge() { // Let's get the players age
        int age = 0;
        try { // See if the input is a valid integer
            Scanner sc = new Scanner(System.in); //Standard intake (System.in)
            age = sc.nextInt();  //reads int input
             //set global age to the inputted age
        }
        catch (InputMismatchException ex) {     //If invalid response,  return :
            System.out.println("Invalid Input! Please try again!!");
            GetInput();

        }
        return age;
    } //get players age



    public static void OverEqual() {
        System.out.println("Congrats you are legal! Let's see how old your partner is!");
        System.out.print("Your partner is " + (Partner) + " years old! "); //print your partners age
        if (18 > Partner) { //Whether the partner is a minor
            System.out.println("You are a pedophile, you're going to jail!");
        }
        else
            System.out.println("You aren't a pedophile! You won't be going to jail!! ");
        repeat();

    }
    public static void Under() {
        System.out.println("You are a minor. Is your partner a pedophile!!?");
        System.out.print("Your partner is " + Partner + " years old!! ");
        if (18 <= Partner) { //Whether the partner is a minor
            System.out.println("Your partner is a MAJOR PEDO!!");
        }
        else
            System.out.println("No one here is a pedophile. Thank goodness. ");

        repeat();
    }


    public static void partner_choices() { //list options of partners
        System.out.println("What age should your partner be,");
        for (int i = 1; i <= 5; i++) { //Offer 5 random partner ages and traits
            System.out.println(i + ": " + partner_ages[i] + " Years old. They are also " + partner_traits[i]);

        }

        try { //make sure response is between one and five for the selection of their partner
            partner_selection();
        }
        catch (ArrayIndexOutOfBoundsException|InputMismatchException exception) {     //If invalid response, have player reselect their partner
            System.out.println("Invalid Input! Please try again!!");
            partner_selection();
            }
        }

        public static void partner_selection() {

            Scanner chosen_partner = new Scanner(System.in); //Player selects their partner from options

            System.out.println("Which partner do you want (1,2...)?");
            int choice = chosen_partner.nextInt(); //int choice is 1-5 on their partner selection
            Partner = partner_ages[choice]; //use their selection (1-5) to get the array element(age) and assign their partners final age to that
            Trait = partner_traits[choice]; //store the final partners trait to a global var
            if (Partner == 0) { //don't allow the player make their partner 0. if player inputs zero here it makes their partners age zero idk why. this stops it
                System.out.println("That is not a valid input please try again");
            }
            else {
                //continue when a valid input is given
            }
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
