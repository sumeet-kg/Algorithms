
public class Search {

    public int binarySearch(int[] arr ,int x){

        int n = arr.length;
        int low = 0 , high = n-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid]==x) return mid;
            else if (arr[mid] > x) high = mid-1;
            else low = mid+1;
        }
        return -1;

    }

    public int recursiveBinarySearch(int[] arr,int low,int high ,int x){

        int mid = (low+high)/2;
        if(low > high) return -1;
        else {
            if(arr[mid]==x)return mid;
            else if(arr[mid]>x) return recursiveBinarySearch(arr, low, mid-1, x);
            else  return recursiveBinarySearch(arr, mid+1, high, x);
            
        }
    }

    


}