package DSA.designpattern.behavioural.latest.stratpattern;
//strategy
//why use interface not the abstract class because
// the strategies don't necessarily share the state or implementation.
// they only need to follow the same contract
public interface PaymentStrategy {
    void pay(double amount);
}
