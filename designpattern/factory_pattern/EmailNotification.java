package dailyproblems.designpattern.factory_pattern;

public class EmailNotification implements Notification{

    @Override
    public void notifyUser(String msg) {
        System.out.println("This is Email Notification");
    }
}
