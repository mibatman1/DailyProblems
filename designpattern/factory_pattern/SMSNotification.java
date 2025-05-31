package dailyproblems.designpattern.factory_pattern;

public class SMSNotification implements Notification{

    @Override
    public void notifyUser(String msg) {
        System.out.println("This is SMS Notification");
    }
}
