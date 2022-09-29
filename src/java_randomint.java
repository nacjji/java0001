import java.util.Random;

public class java_randomint {
    public static void main(String[] args) {
        Random random = new Random();
        int randNum = random.nextInt(256);
        System.out.println(randNum);
    }
}
