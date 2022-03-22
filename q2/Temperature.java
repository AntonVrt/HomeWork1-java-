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
        this.scale=other.getscale();
        this.scale_date = new MyDate(other.scale_date.getDay(),other.scale_date.getMonth(),other.scale_date.getYear());
    }

    public double getscale(){return this.scale;}

    public MyDate getscale_date(){return this.scale_date;}

    public void setscale(double scale)
    {
        this.scale = scale;
    }

    public void setscale_date(MyDate date) 
    {
        this.scale_date = new MyDate(date);
    }

}
