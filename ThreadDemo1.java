package p1;

public class ThreadDemo1 {
    private static class MyThread extends Thread{
        public void run(){
            while(true){
                System.out.println("method2");
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    //不是多线程，执行时会卡在死
    private static void method1(){
        while(true){
            System.out.println("method1");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    //是多线程，与主线程轮流输出
    private static void method2(){
        Thread thread=new MyThread();
        thread.start();
    }

    public static void main(String[] args) throws InterruptedException{
        method2();
        while(true){
            System.out.println("main");
            Thread.sleep(1000);
        }
    }
}
