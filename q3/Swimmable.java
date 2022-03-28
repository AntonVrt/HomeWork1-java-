package q3;

public abstract class Swimmable {
    private int horSpeed;
    private int verSpeed;

    /**
	* this method is a default constructor method to build a new Swimmable .
	*/
    public Swimmable()
    {
        this.horSpeed=0;
        this.verSpeed=0;
    }

    /**
	* this method is a  constructor method to build a new Swimmable .
    * @param horSpeed 
    * @param verSpeed
	*/
    public Swimmable(int horSpeed,int verSpeed)
    {
        this.horSpeed=horSpeed;
        this.verSpeed=verSpeed;
    }
    
    /** 
     * set the horozantal speed
     * @param horSpeed
     */
    public void sethorSpeed(int horSpeed)
    {
        this.horSpeed = horSpeed;
    }

    
    /** 
     * set the vertical speed
     * @param verSpeed
     */
    public void setverSpeed(int verSpeed)
    {
        this.verSpeed = verSpeed;
    }

    public int gethorSpeed(){return this.horSpeed;}

    public int getverSpeed(){return this.verSpeed;}

    public abstract String getAnimalName();

    public abstract int getEatCount();

    public abstract int getSize();

    public abstract String getColor();

    public abstract void eatInc();
    

    public abstract String toString();
    
    public abstract boolean equals(Object other);
    
}
