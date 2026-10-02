package DSA.designpattern.creational.singleton;

public class Singleton {
    public static volatile Singleton instance;
    private Singleton(){}

    public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
}

//we can break singleton pattern while we deserialisation,reflection,cloning

/*reflection way to break it.


import java.lang.reflect.Constructor;

// Singleton class
class Singleton {
    // public instance initialized when loading the class
    public static Singleton instance = new Singleton();

    private Singleton()
    {
        // private constructor
    }
}

public class GFG {

    public static void main(String[] args)
    {
        Singleton instance1 = Singleton.instance;
        Singleton instance2 = null;
        try {
            Constructor[] constructors
                    = Singleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton
                // pattern
                constructor.setAccessible(true);
                instance2
                        = (Singleton)constructor.newInstance();
                break;
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("instance1.hashCode():- "
                + instance1.hashCode());
        System.out.println("instance2.hashCode():- "
                + instance2.hashCode());
    }
output:
instance1.hashCode():- 1995265320
instance2.hashCode():- 1746572565
} */

/*Overcome Cloning issue: To overcome this issue, override clone() method and
throw an exception from clone method that is CloneNotSupportedException.
Now, whenever user will try to create clone of singleton object,
it will throw an exception and hence our class remains singleton.*/

// Java code to explain overcome
// cloning issue with singleton

/*class SuperClass implements Cloneable {
    int i = 10;

    @Override
    protected Object clone()
            throws CloneNotSupportedException
    {
        return super.clone();
    }
}

// Singleton class
class Singleton extends SuperClass {

    // public instance initialized when loading the class
    public static Singleton instance = new Singleton();

    private Singleton()
    {
        // private constructor
    }

    @Override
    protected Object clone()
            throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }
}

public class GFG {

    // Main driver method
    public static void main(String[] args)
            throws CloneNotSupportedException
    {
        Singleton instance1 = Singleton.instance;
        Singleton instance2 = (Singleton)instance1.clone();

        System.out.println("instance1 hashCode:- "
                + instance1.hashCode());
        System.out.println("instance2 hashCode:- "
                + instance2.hashCode());
    }
}*/





//we can avoid using enum implementation of singleton pattern
// Source - https://stackoverflow.com/a/20422020
// Posted by Satheesh Cheveri, modified by community. See post 'Timeline' for change history
// Retrieved 2026-05-05, License - CC BY-SA 4.0

/*public static enum SingletonFactory {
    INSTANCE;
    public static SingletonFactory getInstance() {
        return INSTANCE;
    }
}*/
