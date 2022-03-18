package q1;
import java.time.LocalDate;
public class MyDate {

    private int day;
    private int month;
    private int year;

    public MyDate()
    {
        LocalDate date = LocalDate.now();
        day = date.getDayOfMonth();
        month = date.getMonthValue();
        year = date.getYear();
    } 
    public MyDate(int d, int m, int y){ 
        
        LocalDate date = LocalDate.now();
        if (!isValid(y, m, d))
        {
            this.year = date.getYear();
            this.month = date.getMonthValue();
            this.day = date.getDayOfMonth(); 
        }
        else
        {
        this.year = y;
        this.month = m;
        this.day = d;  
        }
    }
    public static boolean isValid(int year, int month, int day) {
        if (year < 0) return false;
        if ((month < 1) || (month > 12)) return false;
        if ((day < 1) || (day > 31)) return false;
        switch (month) {
            case 1: return true;
            case 2: return (isLeap(year) ? day <= 29 : day <= 28);
            case 3: return true;
            case 4: return day < 31;
            case 5: return true;
            case 6: return day < 31;
            case 7: return true;
            case 8: return true;
            case 9: return day < 31;
            case 10: return true;
            case 11: return day < 31;
            default: return true;
        }
    }

    public static boolean isLeap(int year) {
            if (year % 4 != 0) {
              return false;
            } else if (year % 400 == 0) {
              return true;
            } else if (year % 100 == 0) {
              return false;
            } else {
              return true;
            }        
    }    

    // public MyDate(MyDate other)
    // {
    //     day = other.day;
    //     month = other.month;
    //     year = other.year;

    // }

    
}
