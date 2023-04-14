package sort;

import java.util.Arrays;
import java.util.Random;

public class ArraysSort {
    Integer[] arrayForSort1 = new Integer[10];
    Integer[] arrayForSort2 = new Integer[100_000];
    Integer[] arrayForSort3 = new Integer[10];
    Random random = new Random();

    public void setArraysForSort() {
        for (int i = 0; i < arrayForSort1.length; i++) {
            arrayForSort1[i] = random.nextInt(30);
        }
//        arrayForSort2 = Arrays.copyOf(arrayForSort1, arrayForSort1.length);
        arrayForSort3 = Arrays.copyOf(arrayForSort1, arrayForSort1.length);
        System.out.println(Arrays.toString(arrayForSort3));
    }

    public static void swapElements(Integer[] arrayForSort, int indexFirst, int indexSecond) {
        Integer tmp = arrayForSort[indexFirst];
        arrayForSort[indexFirst] = arrayForSort[indexSecond];
        arrayForSort[indexSecond] = tmp;
    }

    public void choiceSort() {
        for (int i = arrayForSort1.length - 1; i >= 0; i--) {
            Integer max = arrayForSort1[i];
            int maxIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arrayForSort1[j] > max) {
                    max = arrayForSort1[j];
                    maxIndex = j;
                }
            }
            swapElements(arrayForSort1, maxIndex, i);
        }
    }

    public void bubbleSort() {
        for (int i = arrayForSort2.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (arrayForSort2[j] > arrayForSort2[i]) {
                    swapElements(arrayForSort2, j, i);
                }
            }
        }
    }

    public void insertSort() {
        for (int i = 1; i < arrayForSort3.length; i++) {
            int temp = arrayForSort3[i];
            int j = i;
            while (j > 0 && arrayForSort3[j - 1] >= temp) {
                arrayForSort3[j] = arrayForSort3[j - 1];
                j--;
            }
            arrayForSort3[j] = temp;
        }
        System.out.println(Arrays.toString(arrayForSort3));
    }

    public boolean binarySearch(Integer item) {
        int minIndex = 0;
        int maxIndex = arrayForSort3.length - 1;
        while (minIndex <= maxIndex) {
            int midIndex = minIndex + (maxIndex - minIndex) / 2;
            if (item == arrayForSort3[midIndex]) {
                System.out.println(midIndex);
                return true;
            }
            if (arrayForSort3[midIndex] < item) {
                minIndex = midIndex + 1;
            } else {
                maxIndex = midIndex - 1;
            }
        }
        return false;
    }
}