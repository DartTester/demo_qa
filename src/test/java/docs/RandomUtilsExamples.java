package docs;

import static utils.RandomUtils.*;

public class RandomUtilsExamples {
    public static void main(String[] args) {
        System.out.println("Random string 4: " + getRandomString(4));
        System.out.println("Random message 10-100: " + getRandomMessage(10,100));
        System.out.println("Random int 1-2: " + getRandomInt(1,2));
        System.out.println("Random email: " + getRandomEmail());
    }
}
