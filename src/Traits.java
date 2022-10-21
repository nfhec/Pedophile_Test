//create a list of traits someone can have, and randomly assign one.

public class Traits {
    public static String traits() {
        //initialize an array with traits.
            String[] trait_list = {null, "an alcoholic.", "kind.", " a people pleaser.", "depressed.", "abusive.", "crazy.", "a whore.", "honest.", "a leader.", "selfish.",
                    "irresponsible.", "humble", "rich!", "poor :(.", "shy.", "lazy.", " a dreamer!", "daring!", "simple.", "argumentative.", "a creative person!", "inventive."};
            return trait_list[Random()];  //return a trait from the array using a random number
    }

    public static String[] selections() {
     String[] selected;
     selected = new String[6];
     for (int t = 1; t <= 5; t++) {
        selected[t] = traits();
     }
     return selected;
    }


    public static int Random() { //gen. random int, to choose a random trait
        int min = 1;
        int max = 22;//gen. random integer
        return (int) Math.floor(Math.random() * (max - min + 1) + min);

    }
}
