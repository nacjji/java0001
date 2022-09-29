public class java_funtion {
    public static void main(String[] args) {
        sayHello();
        sayHelloTo("Heelae");
        printSum(3,5);
        int result = sum(3,4);
        System.out.println(result);
        int[] sumAndProduct = addAndMulti(3,4);
        System.out.println("sum : " + sumAndProduct[0]);
        System.out.println("multiply : " + sumAndProduct[1]);
        sayHola("희래");
    }

    public static boolean sayHola(String name){
        if (name.equals("바보")){
            System.out.println("욕하지마");
            return false;
        }
        System.out.println(name + "님 안녕하세요.");
            return true;
        }

    public static int[] addAndMulti(int a, int b){
        int sum = a+b;
        int product = a*b;
        int[] result = {sum,product};
        return result;
    }

    public static void printSum(int a, int b){
        System.out.println(a + "+" + b + "=" + sum(a,b));
    }

    public static int sum(int a, int b){
        return a + b;
    }



    public static void sayHelloTo(String name){
        System.out.println("Hello, " + name);
    }

    public static void sayHello(){
        System.out.println("Hello.");
    }
}
