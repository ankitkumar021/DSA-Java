package DSA.designpattern.behavioural.observerpattern;

public class SubscriberMain {
    public static void main(String[] args) {
        Channel code = new Channel();
        Subscriber s1 = new Subscriber("ankit");
        Subscriber s2 = new Subscriber("b");
        Subscriber s3 = new Subscriber("c");
        Subscriber s4 = new Subscriber("d");
        Subscriber s5 = new Subscriber("e");

        code.subscribe(s1);
        code.subscribe(s2);
        code.subscribe(s3);
        code.subscribe(s4);
        code.subscribe(s5);

        code.unSubsribe(s3);

        s1.subscribeChannel(code);
        s2.subscribeChannel(code);
        s3.subscribeChannel(code);
        s4.subscribeChannel(code);
        s5.subscribeChannel(code);

        code.upload("how to learn programming !! ");
    }
}
