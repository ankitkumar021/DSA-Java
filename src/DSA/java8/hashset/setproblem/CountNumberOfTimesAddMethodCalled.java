package DSA.java8.hashset.setproblem;

import java.util.HashSet;

public class CountNumberOfTimesAddMethodCalled {
  public   static void main(String[] args) {
      CountHashSet<Integer> c = new CountHashSet<>();
      getCount(c);
      System.out.println("the number of times add called : -> " + c.getAllCount());
      System.out.println("the number of unique element in set : -> " + c.size());
    }
    //given
    public static void getCount(HashSet<Integer> set){
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(6);

    }

    static class CountHashSet<E> extends HashSet<E>{
        private int count =0;

        @Override
        public boolean add(E e) {
            // Increment the counter before calling the superclass method
            count++;
            return super.add(e);
        }
        public int getAllCount(){
            return count;
        }
    }

/*    //1 way in order to count the number of times add method is called
    //is take a variable and count it.


    public static void getCount(HashSet<Integer> set){
      int count=0;

        set.add(1);
        count++;
        set.add(2);
        count++;
        set.add(3);
        count++;
        set.add(4);
        count++;
        set.add(5);
        count++;
        set.add(6);
        count++;
        System.out.println(count);

    }*/

/*
    ❓ Why Do We Call super.add(e)?

    Because your overridden method must still perform the real HashSet insertion logic.

    If you do not call super.add(e):

    The element will never be inserted into the actual HashSet.

    Your set will remain empty.

    Methods like .size(), .contains(), iteration etc, will simply not work properly.

            ✔ HashSet’s real behavior (duplicate checking, hashing, bucket logic, rehashing) is inside HashSet.add().

    Your overridden method only counts calls;
super.add() does the real work.*/

/*
    ❗ What Happens If You Remove super.add(e)?

    Example:

    @Override
    public boolean add(E e) {
        count++;
        return true; // WRONG: never calls parent add
    }


    Result:

    Your counter increments (OK)

    But the element is never stored

c.size() will be 0

    The set is basically useless*/


}
