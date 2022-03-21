package start;

import q1.MyDate;

public class Utility {

    public static MyDate threeDates(MyDate[] array) {
        int i = 0;
        while (i < array.length) {
            for (int j = 0; j < array.length; j++)
                if ((array[i].getDay() + array[i].getMonth() + array[i].getYear()) == (array[j].getDay()
                        + array[j].getMonth() + array[j].getYear() - 1)) {
                    for (int k = 0; k < array.length; k++)
                        if ((array[i].getDay() + array[i].getMonth() + array[i].getYear()) == (array[k].getDay()
                                + array[k].getMonth() + array[k].getYear() - 2))
                            return array[i];
                }
            i++;
        }
        System.out.println("There is no such date in the array");
        return null;

    }
}
