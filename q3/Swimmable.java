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
    public abstract int getEAT_DISTANCE();

    public String toString()
    {
        return "typs:"+getAnimalName()+"\n"+"color:"+getColor()+"\n"+ "size:"+getSize()+"\n"+"EatCount:"+getEatCount()+"\n"+"horSpeed:"+
        this.horSpeed+"\n"+"verSpeed:"+this.verSpeed+"\n"+ "EAT_DISTANCE:" + getEAT_DISTANCE();
    }
    // public abstract boolean equals(Fish other);
    
}
