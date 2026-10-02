package DSA.multithreading;

public class PrintOddEvenUsing2Thread {
   int n =10;
   volatile static int counter=1;

    public PrintOddEvenUsing2Thread(int n) {
        this.n = n;
    }
//synchronised is used
    public  synchronized void odd() throws InterruptedException {
        while(counter<=n){
            if(counter%2==1){
                System.out.println("odd : " + counter);
                counter++;
                notifyAll();
            }
            else{
                wait();
            }

        }
    }
    public synchronized void even() throws InterruptedException {
        while(counter<=n){
            if(counter%2==0){
                System.out.println("even : " + counter);
                counter++;
                notifyAll();
            }
            else{
                wait();
            }
        }
    }

    public static void main(String[] args) {

        PrintOddEvenUsing2Thread poe = new PrintOddEvenUsing2Thread(10);


        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    poe.odd();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }
        });

        Thread t2 = new Thread(new Runnable() {

            public void run() {
                try {
                    poe.even();
                } catch (InterruptedException e) {}
            }
        });


        t1.start();
        t2.start();
    }

}
