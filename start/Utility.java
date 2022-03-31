package start;
import java.util.Random;
import q1.MyDate;
import q2.Temperature;
import q3.Swimmable;
import q2.Location;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * class  Utility:
 * contains static methods
 * 
 * @author Daniel Markov ,Anton Volkov 
 */

public class Utility {

    
    /** 
     * get's and array and return's the date that have 2 dates ahed in the array
     * @param array - MyDate[]
     * @return MyDate
     */
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

    
    /** 
     * return's the index of the Location with the higest temperature in the array
     * @param array
     * @return int
     */
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

    
    /** 
     * get's an array of Swimmable's and print's it
     * @param array
     */
    public static void printAquarium(Swimmable [] array)
    {
        System.out.println("Aquarium[type/color/actual size/eat count]:");
        final Object[][] table = new String[array.length][];
        for (int i=0;i<array.length;i++)
            table[i] = new String[] { array[i].getAnimalName(), array[i].getColor(), String.valueOf(array[i].getSize()), String.valueOf(array[i].getEatCount()) };

        for (final Object[] row : table) {
            System.out.format("%15s%15s%15s%15s%n", row);
        }
    }

    
    /** 
     * get's a food amount and feed's the swimmable's 
     * @param array
     * @param food
     */
    public static void feedAquaticAnimal(Swimmable [] array, int food)
    {
        Random rand = new Random();
        int section;
        for(int i = 0 ; i<food ; i++)
        {
            section =  rand.nextInt(array.length);
            array[section].eatInc();
        }
    }

    
    /** 
     * return's the number of Swimmable's that are smaller then the first Swimmable in the array
     * @param array
     * @return int
     */
    public static int countAquaticAnimal(Swimmable [] array)
    {
        int count = 0;
        for(int i=1 ; i < array.length-1;i++)
        {
            if(array[0].getSize()>array[i].getSize())
            {
                count++;
            }
        }
        return count;
    }

    
    /** 
     * sort's the Swimmable's array by size - usses mergesort nlogn
     * @param array
     */
    public static void sortAquaticAnimal(Swimmable [] array)
    {
        Swimmable[] temp = Utility.mergeSort(array,0,array.length-1);
        for(int i = 0 ; i<array.length; i++)
        {
            array[i] = temp[i];
        } 
    }

    
    /** 
     * mergeSort on the Swimmable's return's tje sorted array
     * @param arr
     * @param lo
     * @param hi
     * @return Swimmable[]
     */
    public static Swimmable[] mergeSort(Swimmable[] arr, int lo, int hi) {

		if (lo == hi) {
			Swimmable[] br = new Swimmable[1];
			br[0] = arr[lo];

			return br;
		}

		int mid = (lo + hi) / 2;

		Swimmable[] fh = mergeSort(arr, lo, mid);
		Swimmable[] sh = mergeSort(arr, mid + 1, hi);

		Swimmable[] merged = mergeTwoSortedArrays(fh, sh);

		return merged;
	}

    
    /** 
     * merge two sorted array's
     * @param one
     * @param two
     * @return Swimmable[]
     */
    public static Swimmable[] mergeTwoSortedArrays(Swimmable[] one, Swimmable[] two) {

		Swimmable[] sorted = new Swimmable[one.length + two.length];

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < one.length && j < two.length) {

			if (one[i].getSize() > two[j].getSize()) {
				sorted[k] = one[i];
				k++;
				i++;
			} else {
				sorted[k] = two[j];
				k++;
				j++;
			}
		}

		if (i == one.length) {

			while (j < two.length) {
				sorted[k] = two[j];
				k++;
				j++;
			}
		}

		if (j == two.length) {

			while (i < one.length) {
				sorted[k] = one[i];
				k++;
				i++;
			}
		}

		return sorted;

	}
}
