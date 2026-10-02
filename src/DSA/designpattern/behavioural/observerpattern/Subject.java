package DSA.designpattern.behavioural.observerpattern;

public interface Subject {
    void subscribe(Subscriber sub);

    void unSubsribe(Subscriber sub);

    void notifySubscriber();

    void upload(String title);
}
