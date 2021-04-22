import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class murex1 {
    static int[] freq(ArrayList<Integer> arr, int n)
    {
         
        // Sort the array
        Collections.sort(arr);
         int maxi=0;
        // find the max frequency using linear
        // traversal
        int max_count = 1, res = arr.get(0);
        int curr_count = 1;
         
        for (int i = 1; i < n; i++)
        {
            if (arr.get(i) == arr.get(i - 1))
                curr_count++;
            else
            {
                if (curr_count > max_count)
                {
                    max_count = curr_count;
                    res = arr.get(i - 1);
                    maxi=max_count;
                }
                curr_count = 1;
            }
        }
     
        // If last element is most frequent
        if (curr_count > max_count)
        {
            max_count = curr_count;
            res = arr.get(n - 1);
            maxi=max_count;
        }
        int[] ar = new int[2];
        ar[0]=res;
        ar[1]=maxi;
        return ar;
    }
     

  public static String Poker(ArrayList<Integer> a1, ArrayList<Integer> a2) {

        int[] arr1=new int[2];
        int[] arr2=new int[2];
        int max1 = Collections.max(a1);
        int max2=Collections.max(a2);
        int[] result = new int[5];
        arr1 = freq(a1,5);
        arr2 = freq(a2,5);
        if(arr1[1] > arr2[1]){
            result[0] = 1;
        }
        else if(arr2[1] > arr1[1]){
            result[0] = 2;
        }
        else{
            if(arr1[0]>arr2[0]){
                result[0]=1;
            }
            else if(arr2[0]>arr1[0]){
                result[0]=2;
            }
            else{
                result[0]=0;
            }
        }
        result[1]=arr1[1];
        result[2]=arr1[0];
        result[3]=arr2[1];
        result[4]=arr2[0];
       if(arr1[1]==0 && arr2[1]==0){
           if(max1>max2){
               result[0]=1;
           }
           else if(max1 < max2){
               result[0]=2;
           }
           else{
               result[0]=0;
           }
           result[1]=1;
           result[2]=max1;
           result[3]=1;
           result[4]=max2;
       }  
       if(arr1[1]==0 && arr2[1]!=0){
        result[0]=2;
        result[1]=1;
        result[2]=max1;
        result[3]=arr2[1];
        result[4]=arr2[0];
       }
       if(arr1[1]!=0 && arr2[1]==0){
        result[0]=1;
        result[1]=arr1[1];
        result[2]=arr1[0];
        result[3]=1;
        result[4]=max2;
       }
       
       StringBuilder sb = new StringBuilder();
       for (int i : result) 
       { 
           sb.append(i).append(", "); }
           String r = " ";
           r = "{" +sb.deleteCharAt(sb.length() - 2).toString()+"}";
          
           return r;

       
    }
    
  
  public static void main(String[] args) {

    // create an arraylist
    ArrayList<Integer> b1 = new ArrayList<>();
    b1.add(8);
    b1.add(5);
    b1.add(1);
    b1.add(4);
    b1.add(5);
    ArrayList<Integer> b2 = new ArrayList<>();
    b2.add(10);
    b2.add(9);
    b2.add(5);
    b2.add(6);
    b2.add(1);

    System.out.println(Poker(b1,b2));
    
  }
}