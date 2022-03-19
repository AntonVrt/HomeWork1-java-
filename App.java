import q1.MyDate;

public class App {
    public static void main(String[] args) throws Exception {
    MyDate date=new MyDate();
    MyDate date1=new MyDate(28,2,2000);
    MyDate date2=new MyDate(1,3,2000);
    // date.printDate();
    // date.printMonthName();
    // System.out.println(date.getMonthDay());
    // date.printFormatDate("ddMMyyyy");
    System.out.println(date1.compareDate(date2));
    }
}
