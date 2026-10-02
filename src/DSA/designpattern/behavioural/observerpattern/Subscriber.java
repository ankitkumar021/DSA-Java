package DSA.designpattern.behavioural.observerpattern;

public class Subscriber implements ObserverI {
    public String name;//private
    public Channel channel = new Channel();//private

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(){
        System.out.println("Hey " + name + " video uploaded " + channel.title );
    }
    @Override
    public void subscribeChannel(Channel ch){
        channel=ch;
    }
}
