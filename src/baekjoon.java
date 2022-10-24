import java.util.Scanner;

public class baekjoon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int king = 1;
        int queen =1;
        int bis = 2;
        int kni =2;
        int loo =2;
        int pawn =8;
        king = king-sc.nextInt();
        queen = queen - sc.nextInt();
        bis= bis-sc.nextInt();
        kni = kni-sc.nextInt();
        loo = loo-sc.nextInt();
        pawn = pawn-sc.nextInt();

        System.out.print(king+" ");
        System.out.print(queen+" ");
        System.out.print(bis+" ");
        System.out.print(kni+" ");
        System.out.print(loo+" ");
        System.out.print(pawn+" ");
    }
}
