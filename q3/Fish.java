package q3;

import javax.lang.model.util.ElementScanner6;

public class Fish extends Swimmable {
    private int EAT_DISTANCE=10;
    private int size;
    private int col;
    private int eatCount;
    private int x_front;
    private int y_front;
    private int x_dir;
    private int y_dir;

    public Fish(int size, int x_front, int y_front,int verSpeed, int horSpeed, int col)
    {
        super(horSpeed,verSpeed);
        this.size=size;
        this.col=col;
        this.x_front=x_front;
        this.y_front=y_front;
        this.eatCount=0;
        this.x_dir=1;
        this.y_dir=1;
    }

    public String getColor()
    {
        String color = "";
        switch (this.col) {
          case 1:
            color = "Black";
            break;
          case 2:
            color = "Red";
            break;
          case 3:
            color = "Blue";
            break;
          case 4:
            color = "Green";
            break;
          case 5:
            color = "Cyan";
            break;
          case 6:
            color = "Orange";
            break;
          case 7:
            color = "Yellow";
            break;
          case 8:
            color = "Magenta";
            break;
          case 9:
            color = "Pink";
            break;
        }
        return color;
    }

    public String getAnimalName() {return "Fish";}

    public int getEatCount() {return this.eatCount;}

    public int getSize() {return this.size;}

    public int getx_front() {return this.x_front;}

    public int gety_front() {return this.y_front;}

    public int getx_dir() {return this.x_dir;}

    public int gety_dir() {return this.y_dir;}

    public void eatInc()
     {
      this.eatCount+=1;
      if (this.eatCount > this.EAT_DISTANCE)
      {
        this.eatCount = 0;
        this.size++;
      }
    }

    public void changeFish(int size){this.size=size;}

    public void changeColor()
    {
      this.col++;
      if(this.col >9)
        this.col =1;
    }


    public String toString()
    {
        return "typs:"+getAnimalName()+"\n"+"color:"+getColor()+"\n"+ "size:"+getSize()+"\n"+"EatCount:"+getEatCount()+"\n"+"horSpeed:"+
        super.gethorSpeed()+"\n"+"verSpeed:"+super.getverSpeed()+"\n"+ "EAT_DISTANCE:" + this.EAT_DISTANCE;
    }
    
    public boolean equals(Object other)
    {
      if(other instanceof Fish)
      {
        if(super.gethorSpeed() == ((Fish)other).gethorSpeed() && super.getverSpeed() == ((Fish)other).getverSpeed() && this.getColor().equals(((Fish)other).getColor()) == true && this.getSize() == ((Fish)other).getSize() && this.getEatCount() == ((Fish)other).getEatCount() && 
        this.getx_front() == ((Fish)other).getx_front() && this.gety_front() == ((Fish)other).gety_front() && this.getx_dir() == ((Fish)other).getx_dir() && this.gety_dir() == ((Fish)other).gety_dir())
          return true;
        else  
          return false;
      }
      else  
        return false;
    }


}
