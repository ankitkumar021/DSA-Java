package DSA.designpattern.behavioural.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject {

    public List<Subscriber> list = new ArrayList<>();//private method
    String title;

    @Override
    public void subscribe(Subscriber sub){
        list.add(sub);
    }
    @Override
    public void unSubsribe(Subscriber sub){
        list.remove(sub);
    }
    @Override
    public void notifySubscriber(){
        for(Subscriber sub : list){
            sub.update();
        }
    }
    @Override
    public void upload(String title){
        this.title=title;
        notifySubscriber();
    }
}
