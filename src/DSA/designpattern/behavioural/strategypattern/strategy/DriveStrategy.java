package DSA.designpattern.behavioural.strategypattern.strategy;

/*Use Strategy Design Pattern when…
2:Behavior must be chosen at runtime Not fixed at compile time.*/

/*4️You want to follow Open/Closed Principle
Open for extension, closed for modification
Add new behavior without changing existing code
Example:
Add CryptoPayment
Add FestivalDiscount
Add NewCompressionAlgo*/


/*Scenario: Real-Time Payment Processing System
Problem
You’re building an e-commerce backend. Payments must be processed in real time,
but customers can pay using:

Credit Card
UPI
PayPal
Net Banking
You must not hard-code if/else logic everywhere because:
New payment methods will be added
Each payment has different rules
You want to switch behavior at runtime
This is a perfect fit for Strategy Pattern.*/

/*| Pattern      | When to Use                                     |
        | ------------ | ----------------------------------------------- |
        | **Strategy** | Dynamically swapping behavior on an existing object
                        Change algorithm dynamically                    |
        | **State**    | Object behavior changes based on internal state |
        | **Factory**  | Object creation logic                           |
        | **Template** | Same steps, different implementations           |*/

public interface DriveStrategy {
    public void drive();
}
