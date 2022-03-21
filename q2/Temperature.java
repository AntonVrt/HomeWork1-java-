package q2;

import q1.MyDate;

public class Temperature {
    private double scale;
    private MyDate scale_date;

    public Temperature(double scale, int d, int m, int y)
    {
        this.scale=scale;
        this.scale_date = new MyDate(d,m,y);
    }

    public Temperature(double scale)
    {
        this.scale=scale;
        this.scale_date = new MyDate();
    }

    public Temperature(Temperature other)
    {
        this.scale=other.scale;
        // this.scale_date = new MyDate(other.day,other.MyDate.getMonth());
    }

    
}
