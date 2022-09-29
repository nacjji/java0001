import java.util.Random;
import java.util.Scanner;

public class java_numgame {
    public static void main(String[] args) {
        System.out.println("자. 0부터 256 사이의 숫자를 뽑겠습니다.");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("8회 이내에 숫자를 맞추면 성공!");
        Random random = new Random();
        int randNum = random.nextInt(256);
        Scanner scan = new Scanner(System.in);
        for (int i=0;i<8; i++){
            System.out.println(8-i + "번 남았습니다.");
            System.out.println("숫자를 입력하세요 : ");

            String input = scan.nextLine();
            int ans = Integer.parseInt(input);

            if (randNum == ans){
                System.out.println("정답입니다!");
                break;
            }else if (randNum > ans){
                System.out.println("업!");
            }else {
                System.out.println("다운!");
            }
            if (i==7){
                System.out.println("실패!");
                break;
            }
        }
        System.out.println("게임을 종료합니다.");
    }
}

