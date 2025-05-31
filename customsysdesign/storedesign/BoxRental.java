package dailyproblems.customsysdesign.storedesign;

public class BoxRental 
{
    private int width;
    private int height;
    private int rent;
    private int duration;

    public BoxRental(int width, int height, int rent, int duration)
    {
        this.width=width;
        this.height=height;
        this.rent=rent;
        this.duration=duration;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getRent() {
        return rent;
    }

    public int getDuration() {
        return duration;
    }   
}
