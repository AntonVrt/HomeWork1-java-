package start;

import q1.MyDate;
import q2.Temperature;
import q3.Swimmable;
import q2.Location;
import java.util.Dictionary;
import java.util.Hashtable;

public class Utility {

    public static MyDate threeDates(MyDate[] array) {
        boolean nextday=false;
        boolean nextnextday=false;


        for (int i = 0; i < array.length; i++)
        {    
            nextday=false;
            nextnextday=false;
            for (int j = 0; j < array.length; j++)
            {
                if (array[i].nextDate().equals(array[j]))
                    nextday=true;
                if (array[i].nextDate().nextDate().equals(array[j]))
                    nextnextday=true;
                if (nextday && nextnextday)
                    return array[i];

            }
        }
        return new MyDate();
    }

    public static int getMaxTemp (Location [] array)
    {
        int max=0;
        int i;
        for(i=1;i<array.length;i++)
        {
            if (array[i].getMax()!=null)
                if (array[i].getAverage()>array[max].getAverage())
                    max=i;
        }
        return max;
    }

    public static void printAquarium(Swimmable [] array)
    {
        final Object[][] table = new String[array.length][];
        for (int i=0;i<array.length;i++)
            table[i] = new String[] { array[i].getAnimalName(), array[i].getColor(), String.valueOf(array[i].getSize()), String.valueOf(array[i].getEatCount()) };

        for (final Object[] row : table) {
            System.out.format("%15s%15s%15s%15s%n", row);
        }
    }
}
