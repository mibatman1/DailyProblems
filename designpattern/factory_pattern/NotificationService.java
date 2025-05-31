package dailyproblems.designpattern.factory_pattern;

public class NotificationService 
{
    public static void main(String[] args) 
    {
        try 
        {
            NotificationFactory notificationFactory = new NotificationFactory();
            Notification smsNotification = notificationFactory.createNotification("Email");
            smsNotification.notifyUser("Hello");
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
}
