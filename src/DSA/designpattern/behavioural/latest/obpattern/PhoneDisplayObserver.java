package DSA.designpattern.behavioural.latest.obpattern;

/*4. ConcreteObserver(PhoneDisplay)
"PhoneDisplay" is a concrete observer implementing the "Observer" interface.
It has a private field weather to store the latest weather.
The "update" method sets the new weather and calls the "display" method.
"display" prints the updated weather to the console.*/
public class PhoneDisplayObserver implements Observer {
    private String weather;

    @Override
    public void update(String weather) {
        this.weather=weather;
        display();
    }

    public void display(){
        System.out.println("Phone Weather display : " + weather);
    }
}
//similarly we can create different class like Phone display