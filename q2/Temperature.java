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
    public String toString() {
        String s = "";
        if (this.scale < 0)
            s += "-";
        else
            s+= "+";
        s += this.scale + "°" + "C" + " ";   
        s += this.scale_date.toString();
        return s.toString();
      }

    public void printTemp()
    {
        String s = "";
        if (this.scale < 0)
            s += "-";
        else
            s+= "+";
        s += this.scale + "°" + "C" + " "; 
        System.out.println(s);
    }

    public void printTempFull()
    {
        System.out.println(this.toString());
    }
    public Temperature compareTemp(Temperature other)
    {
        if(this.scale >= other.scale)
        {
            return this;
        }
        else
            return other;

    }
    public boolean equals(Object other) {
        if (other instanceof Temperature)
        {   
            if (this.scale == ((Temperature) other).scale && this.scale_date.equals(((Temperature) other).scale_date))
                return true;
            else
                return false;
        }

        return false;
      }

      
}
