package q3;

public abstract class Swimmable {
    private int horSpeed;
    private int verSpeed;

    public Swimmable()
    {
        this.horSpeed=0;
        this.verSpeed=0;
    }
    public Swimmable(int horSpeed,int verSpeed)
    {
        this.horSpeed=horSpeed;
        this.verSpeed=verSpeed;
    }
    public void sethorSpeed(int horSpeed)
    {
        this.horSpeed = horSpeed;
    }

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
    
    // public abstract boolean equals(Fish other);
    
}
