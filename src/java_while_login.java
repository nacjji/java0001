import java.util.Scanner;

public class java_while_login {
    public static void main(String[] args) {
        String id = "jiwon";
        String pw = "123";
        Scanner inputid = new Scanner(System.in);
        Scanner inputpw = new Scanner(System.in);
        System.out.println("아이디를 입력하세요");
        while (true){
            String iid = inputid.nextLine();
            if (id.equals(iid)){
                System.out.println("패스워드를 입력하세요");
                String ppw = inputpw.nextLine();
                if (pw.equals(ppw)) {
                    System.out.println("로그인성공!");
                    break;
                }else {
                    System.out.println("패스워드 불일치!");
                    System.out.println("아이디 다시 입력하세요");
                }
            }else {
                System.out.println("아이디가 없습니다!");
                System.out.println("아이디를 다시 입력하세요");
            }
        }
    }
}
