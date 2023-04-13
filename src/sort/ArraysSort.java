package sort;

import java.util.Arrays;
import java.util.Random;

public class ArraysSort {
    Integer[] arrayForSearch = new Integer[10];
    Integer[] arrayForSort1 = new Integer[10];
    Integer[] arrayForSort2 = new Integer[100_000];
    Integer[] arrayForSort3 = new Integer[100_000];
    Random random = new Random();

    public void setArraysForSort() {
        for (int i = 0; i < arrayForSort1.length; i++) {
            arrayForSort1[i] = random.nextInt(30);
        }
//        arrayForSort2 = Arrays.copyOf(arrayForSort1, arrayForSort1.length);
//        arrayForSort3 = Arrays.copyOf(arrayForSort1, arrayForSort1.length);
        arrayForSearch = Arrays.copyOf(arrayForSort1, arrayForSort1.length);
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
    }

    public boolean binarySearch(Integer item) {
        System.out.println(Arrays.toString(arrayForSearch));
        int midIndex = arrayForSearch.length / 2;
        Integer midElement = arrayForSearch[midIndex];
        while (midIndex < arrayForSearch.length - 1) {
            if (item == midElement) {
                System.out.println(midIndex);
                return true;
            }
            if (midElement > arrayForSearch[midIndex + 1]) {
                midIndex = (arrayForSearch.length - midIndex) / 2;
                midElement = arrayForSearch[midIndex];
            } else {
                midIndex = midIndex / 2;
                midElement = arrayForSearch[midIndex];
            }
        }
        return false;
    }
}