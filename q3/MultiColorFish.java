package q3;

import java.util.Random;

public class MultiColorFish extends Fish {



    public MultiColorFish(int size, int x_front, int y_front, int verSpeed, int horSpeed, int col) {
        super(size, x_front, y_front, verSpeed, horSpeed, col);
    }

    public String getAnimalName() {return "MultiColorFish";}

    public void changeFish(int size){
        super.changeFish(size);
        Random rand = new Random();
        int col = rand.nextInt(1,9);
        super.changeColor(col);
    }
}
