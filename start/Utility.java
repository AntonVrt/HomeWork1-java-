package start;
import java.util.Random;
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
        System.out.println("Aquarium[type/color/actual size/eat count]:");
        final Object[][] table = new String[array.length][];
        for (int i=0;i<array.length;i++)
            table[i] = new String[] { array[i].getAnimalName(), array[i].getColor(), String.valueOf(array[i].getSize()), String.valueOf(array[i].getEatCount()) };

        for (final Object[] row : table) {
            System.out.format("%15s%15s%15s%15s%n", row);
        }
    }

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

    public static void sortAquaticAnimal(Swimmable [] array)
    {
        Swimmable[] temp = Utility.mergeSort(array,0,array.length-1);
        for(int i = 0 ; i<array.length; i++)
        {
            array[i] = temp[i];
        } 
    }

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
