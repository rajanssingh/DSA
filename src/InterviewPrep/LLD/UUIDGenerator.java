package InterviewPrep.LLD;

import java.security.SecureRandom;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UUIDGenerator {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private static final int ID_LENGTH = 36;

    private static final Random random = new Random();

    public static String generateUuidUsingStreams(){
        return IntStream.range(0, ID_LENGTH).parallel().mapToObj(i ->
            String.valueOf(CHARACTERS.charAt(random.nextInt(CHARACTERS.length()))))
                .collect(Collectors.joining());
    }

    public static String generateUuid(){
        StringBuilder sb = new StringBuilder(36);

        for(int i=0;i<ID_LENGTH;i++){
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateUuid());
        System.out.println("-----------------------------------------------------");
        System.out.println(generateUuidUsingStreams());
    }
}
