package DSA.designpattern.creational.prototype;

public interface Prototype {
    Prototype clone();
}

//cloning using copy constructor
/*class Employee {
    int id;
    Address address;

    Employee(Employee other) {
        this.id = other.id;
        this.address = new Address(other.address);
    }
}*/
/*
HI sir I have a doubt.
In prototype, we have a complex object expensive to create,
thats why we don;t create it but clone it.
But in Student class,  within the overridden method we created new object with new();
so we are creating the new object with same data, everytime its requested.
so its again an expensive process to do and it defeats the purpose of having prototype.
I am really confused

7


Reply

2 replies

@RajuPotharaju-q8t
1 year ago
Creating an instance is not expensive but creating instance for first time
by making like db connection, loading data from db, etc are expensive.
Hence, we are cloning (non */


/*
//another doubt

In prototype design pattern,  can't we just write like -
Student cloneObj = obj

and it will copy all the properties of obj into cloneObj,
right or is it not a good practice?

Thank you sir for valuable content ❤❤




@ConceptAndCodingByShrayansh
2 years ago
It will be shallow copy. Means if original object change,
 prototype object will also change.Generally good way is deep copy.
 */


/*//another doubt
I have a question on prototype use case.
Agree that we dont have access to all data members in client code(main function).
But what our protoype is doing ? It just adds clone method inside the class and
creates new object taking existing object's data as it is.
Why not then copy constructor ? Both does not solve the same purpose ?


Very good question Ketan.
Understand with this 2 usecase:
1. In your client code, you exactly know the object for which you have to do the clone.
Ex: student which we have done. You can also do deep copy constructor.

2. But what if in case of Inheritance, (you have many children classes).
And in Client method you have interface Object and
you don't know exactly which child constructor you have to call.
In that case Prototype pattern helps.

So i would say, copy constructor is not scalable, and Prototype Pattern is scalable.

Let me know if it clarifies your doubt.*/

