package helper;

public class Requirements {
    public void recursivePrint(){
        
    }
    public static void merge(int arr[], int l, int m, int r)
    {
        //Determine sizes of two subarrays to be merged.
        int n1 = m - l + 1;
        int n2 = r - m;
        //Create temporary arrays.
        int left[] = new int[n1];
        int right[] = new int[n2];
        //Copy data to temporary arrays.
        for (int i = 0; i < n1; i++)
            left[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            right[j] = arr[m + 1 + j];
        //Merge the temporary arrays in ascending order.
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2)
        {
            if (left[i] <= right[j])
            {
                arr[k] = left[i];
                i++;
            }
            else
            {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        //Copy remaining elements of the left array if any.
        while (i < n1)
        {
            arr[k] = left[i];
            i++;
            k++;
        }
        //Copy remaining elements of the right array if any.
        while (j < n2)
        {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
    public static void sort(int arr[], int l, int r)
    {
        if (l < r) {
            //Find the middle.
            int m =(l + r)/2;
            //Split the array recursively.
            sort(arr, l, m);
            sort(arr, m + 1, r);
            //Merge the sorted halves.
            merge(arr, l, m, r);
        }
    }
}
