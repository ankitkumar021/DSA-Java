package DSA.designpattern.behavioural.latest.obpattern;

// When the requirement is to have a one to many relation between objects
/*Twitter Follow, Unfollow and Post Tweet feature :
When the user(Observer) follows/unfollows and to whom it follows/unfollows(Subject).
Facebook News Feed :
When a user(Subject) has posted or commented or
liked some thing its starts showing in the Facebook news feed of its friends(Observer)
Cricket Score Updater :
When the cricket score is changed multiple apps(observer)
get notified by the Application(Subject).
Youtube Subscription :
When a user(Observer) subscribes to a Youtube channel(Subject)
all its subscribers get notified of any new post.
Group Chat Application : Group(Subject) and its members(Observer),
when some message is added to group its members instantly get updated.
Weather Forecasting
Stock Notification*/
//question on this design pattern is parking lot


/*2. Observer
The "Observer" interface defines a contract for objects that want to be notified
about changes in the subject ("WeatherStation" in this case).
It includes a method "update" that concrete observers must implement to receive
and handle updates.*/

public interface Observer {
    void update(String weather);
}
