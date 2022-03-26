package q3;


public class MultiColorFish extends Fish {



    public MultiColorFish(int size, int x_front, int y_front,int horSpeed, int verSpeed, int col) {
        super(size, x_front, y_front, verSpeed, horSpeed, col);
    }

    public String getAnimalName() {return "MultiColorFish";}

    public void changeFish(int size){
        super.changeFish(size);
        super.changeColor();
    }
}
