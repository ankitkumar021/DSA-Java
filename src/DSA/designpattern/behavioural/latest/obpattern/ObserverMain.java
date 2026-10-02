package DSA.designpattern.behavioural.latest.obpattern;

//How the Observer Pattern Follows SOLID Principles
// Single Responsibility Principle (SRP):
//The subject manages state and notifications, while individual observers handle their own
//reactions to changes.
//Open/Closed Principle (OCP):
//You can introduce new types of observers without modifying the existing subject code
public class ObserverMain {
    public static void main(String[] args) {
        WeatherStationSubject weatherStationSubject = new WeatherStationSubject();

        Observer phoneDisplay = new PhoneDisplayObserver();
        Observer tvDisplay = new TVDisplayObserver();

        // Register observers
        weatherStationSubject.addObserver(phoneDisplay);
        weatherStationSubject.addObserver(tvDisplay);

        // Simulating weather changes
        weatherStationSubject.setWeather("Sunny");
        weatherStationSubject.setWeather("Rainy");
        weatherStationSubject.setWeather("Cloudy");

        // Remove one observer
        weatherStationSubject.removeObserver(tvDisplay);

        // Notify remaining observer
        weatherStationSubject.setWeather("Windy");

    }

}
