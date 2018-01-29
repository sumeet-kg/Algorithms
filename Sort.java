
public class Sort {

    boolean display = false;

    public void insertionSort(int[] arr) {
        //O(n^2) in worst case
        //O(n) for the best case
        int n = arr.length;
        System.out.printf("Unsorted Array: ");
        printArray(arr);
       // if(display) System.out.printf("\t---- Insertion Sort ----\n\n");
        for(int i = 1 ; i < n ;i++){
            int key = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
            //if(display) printArray(arr);
        }
        //if(display) System.out.printf("\n\t-----------End----------\n");
        System.out.printf("Sorted Array: ");
        printArray(arr);
    }
    
    public void  selectionSort(int[] arr){
        // nondecreasing order
        // O(n^2) in worst case
        for(int i = 0 ; i < n-1 ; i++){
            int index = i+1;
            for(int j = i+1;j < n; j++){
                if(arr[j] < arr[index]) index = j;
            }
            //swaping
            int temp = arr[i];
            arr[i] =arr[index];
            arr[index] = temp;
        }
    }

    public void mergeSort(in[] arr, int p, int r){
        if(p >=r ) return;
        int mid = (p+r)/2;
        mergeSort(arr, p, q);
        mergeSort(arr, q+1, r);
        merge(arr,p,q,r);
    }

    public void merge(int[] arr, int p ,int q, int r){
        int n1 = q-p+1, n2 = r-q;
        int[] B = new int[n1];
        int[] C = new int[n2];
        for(int i = p ; i <= q ;i++){
            B[i-p]=arr[i];
        }
        for(int i = q+1 ; i <= r ;i++){
            B[i-q-1]=arr[i];
        }
        int i=0,j=0;
        for( int k = p ; k < r ;k++){
            if(B[i] <= C[j]) {
                arr[k-1]=B[i];
                i++;
            }else {
                arr[k] = C[j];
                j++;
            }
        }

    }

    public void printArray(int[] arr){
        for(int i = 0 ; i <arr.length ; i++)
            System.out.printf("%d ",arr[i]);
        System.out.printf("\n");
    }

}