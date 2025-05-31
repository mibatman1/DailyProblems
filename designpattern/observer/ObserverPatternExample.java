package dailyproblems.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

// Step 1: Define Observer Interface
interface Observer {
    void update(String news);
}

// Step 2: Concrete Observers (Subscribers)
class EmailSubscriber implements Observer {
    private String email;

    public EmailSubscriber(String email) {
        this.email = email;
    }

    public void update(String news) {
        System.out.println("Email sent to " + email + ": " + news);
    }
}

class MobileSubscriber implements Observer {
    private String phoneNumber;

    public MobileSubscriber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void update(String news) {
        System.out.println("SMS sent to " + phoneNumber + ": " + news);
    }
}

// Step 3: Subject (Observable)
class NewsAgency {
    private List<Observer> subscribers = new ArrayList<>();

    // Add Observer
    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }

    // Remove Observer
    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }

    // Notify all Observers
    public void publishNews(String news) {
        System.out.println("Breaking News: " + news);
        for (Observer subscriber : subscribers) {
            subscriber.update(news);
        }
    }
}

// Step 4: Usage
public class ObserverPatternExample {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();

        // Creating Subscribers
        Observer user1 = new EmailSubscriber("user1@example.com");
        Observer user2 = new MobileSubscriber("123-456-7890");

        // Subscribing to NewsAgency
        newsAgency.subscribe(user1);
        newsAgency.subscribe(user2);

        // Publishing News
        newsAgency.publishNews("New Java version released!");

        // Unsubscribing one user
        newsAgency.unsubscribe(user1);

        // Publishing another News
        newsAgency.publishNews("AI is taking over the world!");
    }
}

