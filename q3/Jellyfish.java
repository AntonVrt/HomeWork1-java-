package q3;

public class Jellyfish extends Swimmable {
    private int EAT_DISTANCE = 4;
    private int size;
    private int col;
    private int eatCount;
    private int x_front;
    private int y_front;
    private int x_dir;
    private int y_dir;

    public Jellyfish(int size, int x_front, int y_front,int horSpeed, int verSpeed, int col)
    {
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

    public String getAnimalName() {return "Jellyfish";}

    public int getEatCount() {return this.eatCount;}

    public int getSize() {return this.size;}

    public void eatInc() 
    {
      this.eatCount+=1;
      if (this.eatCount>this.EAT_DISTANCE)
      {
        this.eatCount = 0;
        this.size++;
      }
    }

    public void changeJellyfish(int size){this.size=size;}

    public void changeColor()
    {
      this.col++;
      if(this.col >9)
        this.col =1;
    }

    
    public String toString() {
      return "typs:"+getAnimalName()+"\n"+"color:"+getColor()+"\n"+ "size:"+getSize()+"\n"+"EatCount:"+getEatCount()+"\n"+"horSpeed:"+
      super.gethorSpeed()+"\n"+"verSpeed:"+super.getverSpeed()+"\n"+ "EAT_DISTANCE:" + this.EAT_DISTANCE;
    }


    
}
