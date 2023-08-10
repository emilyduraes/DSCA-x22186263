package ie.nci.CollaborativeDiagnosisService;

import java.util.Random;

public class PPSGenerator {

    public static String getRandomPPS(String[] arr){
        Random random = new Random();
        int randomIndex = random.nextInt(arr.length);
        return arr[randomIndex];
    }

}
