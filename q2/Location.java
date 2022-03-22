package q2;

public class Location 
{
    private String name;
    private Temperature temp[];

    public Location(String name)
    {
        this.name = name;
        this.temp = null;
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
    public String getname(){return this.name;}

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


    
}
