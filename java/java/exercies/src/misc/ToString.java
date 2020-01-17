package misc;

class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);    // Good example of left-padding with zeros
    }
}

public class ToString {
    public static void main(String[] args) {
        System.out.println("23:59:59");
        System.out.println(new Time(23, 59, 59));

        System.out.println("11:08:05");
        System.out.println(new Time(11, 8, 5));

        System.out.println("01:01:01");
        System.out.println(new Time(1, 1, 1));
    }
}