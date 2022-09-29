// 입력받고 홀짝수 판별

import java.util.Scanner;

public class java_if {
    public static void main(String[] args) {
        int num;
        Scanner nu = new Scanner(System.in);
        try {
            System.out.println(" 숫자를 입력하세요");
            num = nu.nextInt();
            if (num %2==0) {
                System.out.println("짝수");
            }else{
                System.out.println("홀수");
            }
        } catch (Exception e){
            System.out.println("숫자를 입력하세요");
        }
        }
    }

