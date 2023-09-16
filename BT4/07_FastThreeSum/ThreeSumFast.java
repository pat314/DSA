import java.util.*;

public class ThreeSumFast {
    
    public static int ThreeSum(int[] arr)
    {
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++)
        {
            int l = i+1;
            int r = arr.length - 1;

            while (l < r)
            {
                if (arr[i] + arr[l] + arr[r] == 0) {
                    count++;
                    l++;
                    r--;
                }
                else if (arr[i] + arr[l] + arr[r] < 0) l++;
                else r--;
            }
        }
        return count;
    }
    public static void main (String[] args) {
        int[] arr = {-1,  -2, -3, 0, 1, 2 ,3};
        System.out.print(ThreeSum(arr)) ;
    }
    
}
// -3 -2 -2- 1- 0 1 2 3 