package q3;

public class UnusualFish extends Fish {
    private int factor;

    public UnusualFish(int size, int x_front, int y_front, int verSpeed, int horSpeed, int col,int factor) {
        super(size, x_front, y_front, verSpeed, horSpeed, col);
        this.factor=factor;
    }

    public int getfactor() {return this.factor;}
    public void setfactor(int factor) {this.factor=factor;}

    public int getSize() {return this.factor*super.getSize();}
    public String getAnimalName() {return "UnusualFish";}

 
}
