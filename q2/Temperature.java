package q2;

import q1.MyDate;

/**
 * class  Temperature:
 * its job is to make a template for Temperature object that contain's a sclae and a date
 * 
 * @author Daniel Markov 318886637,Anton Volkov 323681031
 */

public class Temperature {
    private double scale;
    private MyDate scale_date;

    /**
	* this method is a constructor method to build a new temperature .
    */
    public Temperature()
    {
        this.scale=0;
        this.scale_date = null;
    }
    
    /**
	 * this method is a constructor method to build a new temperature .
     * @param scale - the temperature's scale.
     * @param d - the day of the date
	 * @param m - month of the date
	 * @param y - the year of the date
	 */
    public Temperature(double scale, int d, int m, int y)
    {
        this.scale=scale;
        this.scale_date = new MyDate(d,m,y);
    }

    /**
	 * this method is a constructor method to build a new temperature . sets the current date to the date
     * @param scale - the temperature's scale.
	 */
    public Temperature(double scale)
    {
        this.scale=scale;
        this.scale_date = new MyDate();
    }

    /**
	 * this method is a copy constructor method to build a new temperature .
     * @param other - other Temperature
	 */
    public Temperature(Temperature other)
    {
        this.scale=other.getscale();
        this.scale_date = new MyDate(other.scale_date.getDay(),other.scale_date.getMonth(),other.scale_date.getYear());
    }

    /**
	 * this method return's the scale
	 */
    public double getscale(){return this.scale;}
    /**
	 * this method return's the date
	 */
    public MyDate getscale_date(){return this.scale_date;}

    
    /** 
     * this method set's the scale
     * @param scale
     */
    public void setscale(double scale)
    {
        this.scale = scale;
    }

    /** 
     * this method set's the date
     * @param date
     */
    public void setscale_date(MyDate date) 
    {
        this.scale_date = new MyDate(date);
    }

    /** 
     * return a string representation of a temperature format: +12.0°C 16/03/2022
     * @return String
     */
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

    /** 
     * print's the temperature +12.0°C 
     * @return String
     */
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

    /** 
     * prints a representation of a temperature format: +12.0°C 16/03/2022
     * @return String
     */
    public void printTempFull()
    {
        System.out.println(this.toString());
    }
    
    /** 
     * this method get's an other Temperature and compers two Temperature scales and return's the bigger one
     * @param other
     * @return Temperature
     */
    public Temperature compareTemp(Temperature other)
    {
        if(this.scale >= other.scale)
        {
            return this;
        }
        else
            return other;

    }
    
    /** 
     * this method get's an other Temperature and return true if this Temperature equal's to the other
     * @param other
     * @return boolean
     */
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
