import java.util.Scanner;

public class java_dowhile {
    public static void main(String[] args) {
        String pw = "123";
        Scanner scan = new Scanner(System.in);
        String input;

        do {
            System.out.println("비밀번호를 입력하세요");
            input = scan.nextLine();
        }while (input.equals(pw)!=true);
        System.out.println("로그인 성공");
    }
}
