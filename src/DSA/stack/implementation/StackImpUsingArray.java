package DSA.stack.implementation;

public class StackImpUsingArray {
    int top=-1;
    int capacity=10;
    int[] st = new int[capacity];
  public  static void main(String[] args) {
      StackImpUsingArray stackObj = new StackImpUsingArray();
      stackObj.push(1);
      stackObj.push(2);
      stackObj.push(3);
      // Testing top
      System.out.println("Top element: " + stackObj.top());

      // Testing size
      System.out.println("Stack size: " + stackObj.size());

      // Testing pop
      System.out.println("Popped element: " + stackObj.pop());

      // Checking top again
      System.out.println("Top element after pop: " + stackObj.top());

      // Checking size again
      System.out.println("Stack size after pop: " + stackObj.size());
      
  }
  public void push(int x){
      //checks if top exceeds the size of array
      if(top>=capacity-1){
          System.out.println("There is no enough space in array to store element ");
      }
      top++;
      st[top] = x;

  }
  public int pop(){
      if(top==-1){
          System.out.println("There is no element in the stack ");
      }
      return st[top--];
  }
  public int top(){
      if(top==-1){
          System.out.println("There is no element in the stack ");
      }
      return st[top];

  }
  public int size(){
      return top+1;
  }
}
