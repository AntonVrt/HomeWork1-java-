package start;

import q1.MyDate;

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
}
