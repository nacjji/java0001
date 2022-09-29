import java.util.Random;
import java.util.Scanner;

public class java_updownMethod {
    public static int randNum;
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Random random = new Random();
        randNum = random.nextInt(256);
        int attempt = 0;
        while (attempt < 8){
            boolean isCorrect = play();
            if (isCorrect) {
                break;
            }
            attempt = attempt +1;
            System.out.println(attempt + "회 시도")
            ;
        }
        System.out.println("게임 종료");

    }
    public static boolean play(){
        System.out.println("숫자 입력 : ");
        int input = scan.nextInt();
        if (input == randNum){
            System.out.println("정답");
            return true;
        }else if (input > randNum){
            System.out.println("다운");
        }else if (input < randNum){
            System.out.println("업");
        }
        return false;
    }
}
