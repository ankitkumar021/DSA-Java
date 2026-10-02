package DSA.multithreading;

public class PrintSumOfEvenAndOddNumberUsing2Thread {
     int n =10;
     static volatile int counter = 1;
     private int evenSum = 0;
     private int oddSum = 0;

    public PrintSumOfEvenAndOddNumberUsing2Thread(int n) {
        this.n = n;
    }
    public synchronized void printOdd() throws InterruptedException {
        while(counter<=n){
            if(counter%2==1){
                oddSum = oddSum+counter;
                System.out.println("counter : " + counter + " oddSum : " +  oddSum);
                counter++;
                notifyAll();
            }
            wait();
        }
    }
    public synchronized void printEven() throws InterruptedException {
        while(counter<=n){
            if(counter%2==0){
                evenSum = evenSum+counter;
                System.out.println("counter : " + counter + " evenSum  : " +  evenSum);
                counter++;
                notifyAll();
            }
            else{
                wait();
            }
        }
    }

    public int getEvenSum() throws InterruptedException {
        return evenSum;

    }
    public int getOddSum() throws InterruptedException {
        return oddSum;

    }
    public static void main(String[] args) throws InterruptedException {
        PrintSumOfEvenAndOddNumberUsing2Thread p = new PrintSumOfEvenAndOddNumberUsing2Thread(10);
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run(){
                try {
                   p.printOdd();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run(){
                try {
                   p.printEven();
                } catch (InterruptedException e) {}

            }
        });


        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("oddSum : " + p.getOddSum());
        System.out.println("evenSum : " + p.getEvenSum());
        System.out.println("total sum :" + (p.getOddSum() + p.getEvenSum()));
        System.out.println("multiple sum :" + (p.getOddSum() * p.getEvenSum()));

    }
}
