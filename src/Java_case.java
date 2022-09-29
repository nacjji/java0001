import java.util.Scanner;

public class Java_case {
    public static void main(String[] args) {
        System.out.println("저녁메뉴를 입력하세요. \n 1.순대국밥 \n 2.치킨 \n 3.피자");
        Scanner din = new Scanner(System.in);
        String name = din.nextLine();

        switch (name) {
            case "1":
                System.out.println("순대국밥 9000원");
                break;
            case "2" :
                System.out.println("치킨 18000원");
                break;
            case "3" :
                System.out.println("피자 23000원");
                break;
            default:
                System.out.println("그 메뉴는 없습니다.");
        }
    }
}

