package p1;

import java.util.Scanner;
//时间复杂度为2^n
class Fbonacii {
    public static long cole(int n){
        if(n==1||n==2){
            return 1;
        }else{
            return cole(n-1)+cole(n-2);
        }
    }
}
class Fibonacii extends Thread{
    private int n;

    public Fibonacii(int n) {
        this.n = n;
    }


    @Override
    public void run() {
        long result=Fbonacii.cole(n);
        System.out.printf("第%d的值为%d%n",n,result);
    }
}
public class ThreadDemo2{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(true) {
            System.out.println("要计算第几项的值");
            int n = scanner.nextInt();
            Thread thread=new Fibonacii(n);
            thread.start();
        }
    }
}
