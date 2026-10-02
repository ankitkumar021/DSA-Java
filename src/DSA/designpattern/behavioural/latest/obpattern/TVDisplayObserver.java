package DSA.designpattern.behavioural.latest.obpattern;

public class TVDisplayObserver implements Observer {
    private String weather;
    @Override
    public void update(String weather) {
        this.weather = weather;
        display();
    }

    private void display() {
        System.out.println("TV Display: Weather updated - " + weather);
    }

}
