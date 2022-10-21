public class Lie_Chance {
    public static int lie_calc() {
        final int number = rand();
            if (Pedophile_Test.StoreAge() >= 18) { // if players age is under 18 AND:
                if (number == 1) { //5% chance the partner selected lies
                    //if they lied...
                    return partner_true();
                }
                else
                    Pedophile_Test.OverEqual(); //if not run as usual

            }
            else {
                if (number == 1) { //5% chance the partner selected lies
                    //if they lied
                    return partner_true();
                }
                else
                    Pedophile_Test.Under(); //if not run as usual
            }
            return 0;
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

