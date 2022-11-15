public class Ages {
    public static int[] ages() {

        int[] ages; //create an array of age options
        ages = new int[6]; //array will have 6 indices
        for (int j = 1; j <= 5; j++) {
            ages[j] = RandomAges(); //have each array index have a different element(age)
        }
        int[] age_list = ages;
        return age_list;
    }
    public static int RandomAges() { //generate random ages for partner selection
        int min = 1;
        int max = 99;//gen. random integer
        return (int) Math.floor(Math.random() * (max - min + 1) + min);

    } //make random number
}
