package q2;

import java.util.Arrays;
import java.util.List;

public class Location 
{
    private String name;
    private Temperature[] temp;

    public Location(String name)
    {
        this.name = name;
        this.temp=null;
    }
    public Location(Location other)
    {
        this.name = other.name;
        this.temp = new Temperature[other.temp.length];

        for(int i=0 ; i < other.temp.length ; i++)
        {
            this.temp[i] = new  Temperature(other.temp[i]);
        }
    }
    public String getName(){return this.name;}

    public Temperature[] gettemperature(){return this.temp;}

    public void setname(String name)
    {
        this.name = name;
    }

    public void settemperature(Temperature[] temperature)
    {
        this.temp = new Temperature[temperature.length];
        for(int i=0 ; i < temperature.length ; i++)
        {
            this.temp[i] = new  Temperature(temperature[i]);
        }
    }
    
    public void printLocation ()
    {
        String s=this.name;
        if (this.temp==null)
            s+=" no temperature measurements available.";
        else
        {
            s+=" temperature measurements:";
            for (Temperature t : this.temp)
                    s+=t.toString()+"|";
        }
        
        System.out.println(s);
    }

    public void printLocation (double range)
    {
        String s=this.name;
        if (this.temp==null)
            s+=" no temperature measurements available.";
        else
        {
            s+=" temperature measurements:";
            for (Temperature t : this.temp)
                if (t.getscale()<=this.getAverage()+range && t.getscale()>=this.getAverage()-range)
                    s+=t.toString()+"|";
        }
        
        System.out.println(s);
    }

    public double getAverage()
    {
        if (this.temp==null)
            return 0;
        
        double sum=0;
        double avg=0;
        for (int i=0;i<this.temp.length;i++)
            sum+=this.temp[i].getscale();
        avg=sum/this.temp.length;
        return avg;
    }

    public void addTemp (double t,int d,int m,int y)
    {
        if (this.temp!=null)
        {
            Temperature[] newtemp = new Temperature [temp.length+1];
            int i;
            for (i=0;i<temp.length;i++)
                newtemp[i]=temp[i];
            newtemp[i]=new Temperature(t,d,m,y);
            this.temp=newtemp;
        }
        else
        {
            Temperature[] newtemp = new Temperature [1];
            newtemp[0]=new Temperature(t,d,m,y);
            this.temp=newtemp;
        }
    }

    public void addTemp (double t)
    {
        if (this.temp!=null)
        {
            Temperature[] newtemp = new Temperature [temp.length+1];
            int i;
            for (i=0;i<temp.length;i++)
                newtemp[i]=temp[i];
            newtemp[i]=new Temperature(t);
            this.temp=newtemp;

        }
        else
        {
            Temperature[] newtemp = new Temperature [1];
            newtemp[0]=new Temperature(t);
            this.temp=newtemp;
        }
    }

    public Temperature getMax ()
    {
        if (this.temp==null)
            return null;
        Temperature max = this.temp[0];
        for (int i=1;i<this.temp.length;i++)
        {
            if (this.temp[i].getscale()>max.getscale())
                max=this.temp[i];
        }
        return max;
    }

    	/**
	 * this method return a string with the location name and Temperature array 
	 * @return location name and Temperature type array in a string form
	 */
	public String toString() 
	{
        String s="location name:"+this.name;
        if (this.temp==null)
            s+=" no temperature measurements available.";
        else
        {
            s+=" temperature measurements:";
            for (Temperature t : this.temp)
                    s+=t.toString()+"|";
        } 
        return s;
	}

    public boolean equals(Object other) 
    {
        if (other instanceof Location) {
            if (this.name!=((Location) other).name) {
              return false;
            }
            if ((this.temp==null &&  ((Location) other).temp!=null) || (this.temp!=null &&  ((Location) other).temp==null))
                return false;
            if (this.temp!=null && ((Location) other).temp!=null )
                if (this.temp.length==((Location) other).temp.length)
                    for(int i=0;i<this.temp.length;i++)
                        if (!(this.temp[i].equals(((Location) other).temp[i])))
                            return false;
          }
        return true;
    }
}
