package dailyproblems.designpattern.factory_pattern;

import java.util.Locale;

public class NotificationFactory {
    public static final String SMS = "SMS";
    public static final String EMAIL = "EMAIL";

    public Notification createNotification(String type) {

        if (type == null || type.isEmpty()) 
        {
            return null;
        } 
        else 
        {
            switch (type.toUpperCase(Locale.ROOT)) 
            {
                case SMS:
                    return new SMSNotification();
                case EMAIL:
                    return new EmailNotification();
                default:
                    throw new IllegalArgumentException("Unknown Notification Type received");
            }
        }
    }
    
}
