package DSA.designpattern.behavioural.latest.obpattern;

/*1. Subject
The "Subject" interface outlines the operations a subject (like "WeatherStation")
should support.
"addObserver" and "removeObserver" are for managing the list of observers.
"notifyObservers" is for informing observers about changes.*/
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}
