import java.util.Scanner;

public class java001 {
    public static void main(String[] args) {
        String name;
        int age;
        double height;
        String intro;
        String buffer;
        Scanner sc = new Scanner(System.in);
        System.out.println("이름:");
        name=sc.next();
        System.out.println("나이:");
        age = sc.nextInt();
        System.out.println("키:");
        height = sc.nextDouble();
        System.out.println("자기소개 :");
        buffer = sc.nextLine();
        intro = sc.nextLine();
        System.out.println("제이름은"+name+", 나이는"+age+", 키는"+height + ","+intro);
    }
}
