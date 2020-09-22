package p1;

import java.util.Scanner;
class Fbonacii1 {
    public static long cole(int n){
        if(n==1||n==2){
            return 1;
        }else{
            return cole(n-1)+cole(n-2);
        }
    }
}
public class ThreadDemo3{
    private static class FibonaciiThread extends Thread{
        private int n;

        public FibonaciiThread(int n) {
            this.n=n;
        }

        @Override
        public void run() {
            long result=Fbonacii1.cole(n);
            System.out.printf("第%dFib(%d)=%d%n",n,n,result);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner=new Scanner(System.in);
        while(true){
            int n=scanner.nextInt();
            Thread thread=new FibonaciiThread(n);
            System.out.println("计算中：");
            thread.start();
            while(thread.isAlive()){
                Thread.sleep(1000);
                System.out.print(".");
            }
        }
    }
}
