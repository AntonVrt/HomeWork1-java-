package q1;

import java.time.LocalDate;

/**
 * class  MyDate:
 * its job is to make a template for data object
 * 
 * @author Daniel Markov 318886637,Anton Volkov 323681031
 */

public class MyDate {

  private int day;
  private int month;
  private int year;

   /**
	 * this method is a constructor method to build a new date . it set's today's date
	 */
  public MyDate() {
    LocalDate date = LocalDate.now();
    day = date.getDayOfMonth();
    month = date.getMonthValue();
    year = date.getYear();
  }

  	/**
	 * this method is a constructor method to build a new date .
	 * @param d - the day of the date
	 * @param m - month of the date
	 * @param y - the year of the date
	 */
  public MyDate(int d, int m, int y) 
  {    
      this.year = y;
      this.month = m;
      this.day = d;
    if (!isValid(d, m, y)) { 
      LocalDate date = LocalDate.now();
      this.year = date.getYear();
      this.month = date.getMonthValue();
      this.day = date.getDayOfMonth();
    }
  }

  /** 
   * this method is a copy constructor method to build a new date .
   * @param other - other MyDate
  */
  public MyDate(MyDate other) {
    day = other.getDay();
    month = other.getMonth();
    year = other.getYear();

  }

  
  /** 
   * help function that gets day,month and year and determines if the date is a valid date
   * @param day
   * @param month
   * @param year
   * @return boolean
   */
  public boolean isValid(int day, int month, int year) {
    if (year < 0)
      return false;
    if ((month < 1) || (month > 12))
      return false;
    if ((day < 1) || (day > 31))
      return false;
    switch (month) {
      case 1:
        return true;
      case 2:
        return (isLeapYear() ? day <= 29 : day <= 28);
      case 3:
        return true;
      case 4:
        return day < 31;
      case 5:
        return true;
      case 6:
        return day < 31;
      case 7:
        return true;
      case 8:
        return true;
      case 9:
        return day < 31;
      case 10:
        return true;
      case 11:
        return day < 31;
      default:
        return true;
    }
  }

  
  /** 
   * this method determines if this date's year is a leap year
   * @return boolean
   */
  public boolean isLeapYear() {
    if (this.year % 4 != 0) {
      return false;
    } else if (this.year % 400 == 0) {
      return true;
    } else if (this.year % 100 == 0) {
      return false;
    } else {
      return true;
    }
  }

  
  /** 
   * get the day of the date
   * @return int
   */
  public int getDay() {
    return day;
  }

  
  /** 
   * get the month of the date
   * @return int
   */
  public int getMonth() {
    return month;
  }

  
  /** 
   * get the year of the date
   * @return int
   */
  public int getYear() {
    return year;
  }

  
  /** 
   * set the day of the date
   * @param d
   * @return MyDate
   */
  public MyDate setDay(int d) {
    if (isValid(d, month, year)) {
      this.day = d;
    }
    return this;
  }

  
  /** 
   * set the month of the date
   * @param m
   * @return MyDate
   */
  public MyDate setMonth(int m) {
    if (isValid(day, m, year)) {
      this.month = m;
    }
    return this;
  }

  
  /** 
   * set the year of the date
   * @param y
   * @return MyDate
   */
  public MyDate setYear(int y) {
    if (isValid(day, month, y)) {
      this.year = y;
    }
    return this;
  }

  /**
   * return a string representation of a data format: xx/xx/xx
   * 
   * @return
   */
  public String toString() {
    String s = "";
    if (this.day < 10)
      s += "0";
    s += this.day + "/";
    if (this.month < 10)
      s += "0";
    s += this.month + "/" + this.year;
    return s.toString();
  }

  public void printDate() {
    System.out.println(this.toString());
  }

  
  /** 
   * return the name of a month
   * @return String
   */
  public String getMonthName() {
    String MonthName = "";
    switch (month) {
      case 1:
        MonthName = "Jan";
        break;
      case 2:
        MonthName = "Feb";
        break;
      case 3:
        MonthName = "Mar";
        break;
      case 4:
        MonthName = "Apr";
        break;
      case 5:
        MonthName = "May";
        break;
      case 6:
        MonthName = "Jun";
        break;
      case 7:
        MonthName = "Jul";
        break;
      case 8:
        MonthName = "Aug";
        break;
      case 9:
        MonthName = "Sep";
        break;
      case 10:
        MonthName = "Oct";
        break;
      case 11:
        MonthName = "Nov";
        break;
      case 12:
        MonthName = "Dec";
        break;
    }
    return MonthName;
  }

    /** 
   * print's the date with the month name
   */
  public void printMonthName() {
    System.out.println(this.day + " " + this.getMonthName() + " " + this.year);
  }

  
  /** 
   * this method return's the number of days in the date month
   * @return int
   */
  public int getMonthDay() {
    if (this.month == 2) { 
      if (this.isLeapYear()) {
        return 29;
      } else {
        return 28;
      }
    } else if (month == 4 || month == 6 || month == 9 || month == 11) {
      return 30;
    } else {
      return 31;
    }
  }

  
  /** 
   * this method return's the next day date
   * @return MyDate
   */
  public MyDate nextDate() {
    int NewDay = this.day + 1;
    int NewMonth = this.month;
    int NewYear = this.year;
    if (this.month == 2) {
      if (this.isLeapYear()) {
        if (NewDay <= 29) {
          return new MyDate(NewDay, NewMonth, NewYear);
        } else {
          return NextMonthYear(NewDay, NewMonth, NewYear);
        }

      } else {
        if (NewDay <= 28) {
          return new MyDate(NewDay, NewMonth, NewYear);
        } else {
          return NextMonthYear(NewDay, NewMonth, NewYear);
        }
      }
    } else if (month == 4 || month == 6 || month == 9 || month == 11) {
      if (NewDay <= 30) {
        return new MyDate(NewDay, NewMonth, NewYear);
      } else {
        return NextMonthYear(NewDay, NewMonth, NewYear);
      }
    } else {
      if (NewDay <= 31) {
        return new MyDate(NewDay, NewMonth, NewYear);
      } else {
        return NextMonthYear(NewDay, NewMonth, NewYear);
      }

    }
  }

  
  /** 
   * this method get's a string format and print's the date by this format
   * available formats and examples:
   * 14/03/22 – "ddmmyy" 
      14/03/2022 – "ddmmyyyy" 
      03/14/2022 – "mmddyyyy" 
      2022/03/14 – "yyyymmdd" 
      14 Mar 2022 – "ddMMyyyy"
   * @param format
   */
  public void printFormatDate(String format) {
    String s = "";
    switch (format) {
      case "ddmmyyyy":
        this.printDate();
        break;

      case "ddmmyy":
        if (this.day < 10)
          s += "0";
        s += this.day + "/";
        if (this.month < 10)
          s += "0";
        s += this.month + "/" + (this.year % 100);

        break;

      case "mmddyyyy":
        if (this.month < 10)
          s += "0";
        s += this.month + "/";
        if (this.day < 10)
          s += "0";
        s += this.day + "/" + this.year;

        break;

      case "yyyymmdd":
        s += this.year + "/";
        if (this.month < 10)
          s += "0";
        s += this.month + "/";
        if (this.day < 10)
          s += "0";
        s += this.day;

        break;

      case "ddMMyyyy":
        if (this.day < 10)
          s += "0";
        s += this.day + " ";
        s += this.getMonthName() + " " + this.year;

        break;
    }
    if (format != "ddmmyyyy")
      System.out.println(s);
  }

  
  /** 
   * this method get's a date compare two date's return's 0 if they are the same, -1 if the this date is smaller then the other date and 1 if this date is bigger then the other date
   * @param other
   * @return int
   */
  public int compareDate(MyDate other) {
    if (equals(other))
      return 0;
    /* year number *1000 > month number *100 > day number */
    if ((this.year * 1000 + this.month * 100 + this.day) - (other.year * 1000 + other.month * 100 + other.day) > 0) {
      return 1;
    }
    return -1;
  }

  
  /** 
   * this method return's true if two dates are equal
   * @param other
   * @return boolean
   */
  public boolean equals(Object other) {
    if (other instanceof MyDate) {
      if (this.day == ((MyDate) other).day && this.month == ((MyDate) other).month
          && this.year == ((MyDate) other).year) {
        return true;
      }
      return false;
    }
    return false;
  }

  
  /** 
   * help function that gets day month and year, add's a month to the date and a year if needed
   * @param NewDay
   * @param NewMonth
   * @param NewYear
   * @return MyDate
   */
  public MyDate NextMonthYear(int NewDay, int NewMonth, int NewYear) {
    NewDay = 1;
    NewMonth++;
    if (NewMonth > 12) {
      NewMonth = 1;
      NewYear++;
    }
    return new MyDate(NewDay, NewMonth, NewYear);
  }

}
