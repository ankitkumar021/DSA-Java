package inteview.mock;

public class Example2 {
   public static void main(String[] args) {
       int n=100;
       print(n);

    }
    public static void print(int n){
       for(int i=1;i<n;i++){
           if(String.valueOf(i).contains("9")){
               System.out.println(i);
           }
       }
    }
}
