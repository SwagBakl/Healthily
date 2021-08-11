package utils;

import java.util.Random;

public class RandomGeneratorUtils {

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10000);
    }
}
