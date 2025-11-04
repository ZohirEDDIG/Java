public class Merge {
    // * Marge Sort idea is recursively divide array in 2, sort, recombine
    // * Time Complexity = O(nlogn)
    // * Space Complexity = O(n)
    
    public static void main(String[] args) {
        int[] array = {8, 2, 5, 3, 4, 7, 6, 1};

        mergeSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void mergeSort(int[] array) {
        int length = array.length;

        if (length < 2) return;

        int middle = length / 2;

        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0;
        int j = 0;

        for (;i < length; i ++) {
            if (i < middle) {
                leftArray[i] = array[i];
            } else {
              rightArray[j] = array[i];  
              j++;
            }
        }

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }

    public static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftSize = array.length / 2;
        int rightsize = array.length - leftSize;
        int i = 0, l = 0, r = 0;

        while (l < leftSize && r < rightsize) {
            if (leftArray[l] > rightArray[r]) {
                array[i] = rightArray[r];
                r ++;
            } else {
                array[i] = leftArray[l];
                l ++;  
            }
            i++;
        }

        while (l < leftSize) {
            array[i] = leftArray[l];
            l++;
            i++;
        }

        while (r < rightsize) {
            array[i] = rightArray[r];
            r++;
            i++;
        }
    }
}
