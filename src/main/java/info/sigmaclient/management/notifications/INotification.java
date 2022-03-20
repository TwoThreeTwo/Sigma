package info.sigmaclient.management.notifications;

public interface INotification {

    String getHeader();

    String getSubtext();

    long getStart();

    long getDisplayTime();

    Notifications.Type getType();

    float getX();

    void setX(int x);

    float getTarX();

    void setTarX(int x);

    float getTarY();

    long checkTime();

    float getY();

    void setY(int y);

    long getLast();

    void setLast(long last);

}
