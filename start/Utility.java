package start;

import q1.MyDate;

public class Utility {

    public static MyDate threeDates(MyDate[] array) {
        int i = 0;
        while (i < array.length) {
            for (int j = 0; j < array.length; j++)
                if (array[i].nextDate().equals(array[j])) {
                    for (int k = 0; k < array.length; k++)
                        if ((array[j].nextDate().equals(array[k])))
                            return array[i];
                }
            i++;
        }
        System.out.println("There is no such date in the array");
        return null;

    }
}
