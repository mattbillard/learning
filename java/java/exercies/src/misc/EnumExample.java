package misc;

public class EnumExample {
  Day day;

  public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY 
  }
  
  public EnumExample(Day day) {
      this.day = day;
  }
  
  public static void tellItLikeItIs(Day day) {
      switch (day) {
          case MONDAY:
              System.out.println("Mondays are bad.");
              break;
                  
          case FRIDAY:
              System.out.println("Fridays are better.");
              break;
                       
          case SATURDAY: case SUNDAY:
              System.out.println("Weekends are best.");
              break;
                      
          default:
              System.out.println("Midweek days are so-so.");
              break;
      }
  }
  
  public static void main(String[] args) {
      EnumExample.tellItLikeItIs(Day.MONDAY);
      EnumExample.tellItLikeItIs(Day.WEDNESDAY);
      EnumExample.tellItLikeItIs(Day.FRIDAY);
      EnumExample.tellItLikeItIs(Day.SATURDAY);
    //   EnumExample.tellItLikeItIs(Day.SUNDAY);
      
    //   (new EnumExample(Day.MONDAY)).tellItLikeItIs();
  }
}