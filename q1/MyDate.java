package q1;

import java.time.LocalDate;

public class MyDate {

  private int day;
  private int month;
  private int year;

  public MyDate() {
    LocalDate date = LocalDate.now();
    day = date.getDayOfMonth();
    month = date.getMonthValue();
    year = date.getYear();
  }

  public MyDate(int d, int m, int y) {

    LocalDate date = LocalDate.now();
    if (!isValid(y, m, d)) {
      this.year = date.getYear();
      this.month = date.getMonthValue();
      this.day = date.getDayOfMonth();
    } else {
      this.year = y;
      this.month = m;
      this.day = d;
    }
  }

  public boolean isValid(int year, int month, int day) {
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
        return (this.isLeapYear() ? day <= 29 : day <= 28);
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

  public MyDate(MyDate other) {
    day = other.day;
    month = other.month;
    year = other.year;

  }

  public int getDay() {
    return day;
  }

  public int getMonth() {
    return month;
  }

  public int getYear() {
    return year;
  }

  public MyDate setDay(int d) {
    if (isValid(year, month, d)) {
      day = d;
    }
    return this;
  }

  public MyDate setMonth(int m) {
    if (isValid(year, m, day)) {
      month = m;
    }
    return this;
  }

  public MyDate setYear(int y) {
    if (isValid(y, month, day)) {
      year = y;
    }
    return this;
  }

  /**
   * return a string representation
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

  public void printMonthName() {
    System.out.println(this.day + " " + this.getMonthName() + " " + this.year);
  }

  public int getMonthDay() {
    if (this.month == 2) { // February
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

  public int compareDate(MyDate other) {
    if (equals(other))
      return 0;
    /* year number *1000 > month number *100 > day number */
    if ((this.year * 1000 + this.month * 100 + this.day) - (other.year * 1000 + other.month * 100 + other.day) > 0) {
      return 1;
    }
    return -1;

  }

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
