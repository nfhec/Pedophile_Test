public class Lie_Chance {

    public static boolean lie_calc() { //true or false (whether partner lied about age, or didn't.)
        boolean liar = false;
        final int number = rand(); //make sure random number is only chosen once

            if (number == 1) { //5% chance the partner selected lies
                //if they lied...
                Pedophile_Test.Partner = partner_true();
                return true;

            }
            else {  //if not a liar run as usual
                return false;
            }

    }
    public static int rand() { //random number to create chance of lies

        int min = 1;
        int max = 20;//gen. random integer
        return (int) Math.floor(Math.random() * (max - min + 1) + min);

    }
    public static int partner_true() { //random number to create the actual partner age

        int min = 1;
        int max = 99;//gen. random integer
        return (int) Math.floor(Math.random() * (max - min + 1) + min);

    }
}

