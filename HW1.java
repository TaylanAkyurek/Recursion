import java.util.Random;
import java.util.Arrays;

public class HW1 {
	
	// This is the method that returns the count of 'a' chars in the matrix
	// Feel free to add a helper method for the recursive part of the algorithm

	public static int acount(char[][] mat) {
		int result = 0;

		// Your code goes here 
    for(int i=0;i<mat.length;i++){
      result+=binarySearchForA(mat[i]);
      
    }

		return result;
	}
  public static int binaryCount(char[] mat,int low, int high){
    int sumOfA=0;
    int mid = (low+high)/2;
    if(low==mid||high==mid){
 	  if(mat[low]=='a') {
 		  sumOfA++;
 	  }
 	  if(mat[high]=='a') {
  		 
 		  sumOfA++;
 	  }
   
    	return sumOfA;
    }
    
    if(mat[mid]=='a'){
    
    	if((high-low)/2==0) {
	    	sumOfA+=1;
	    }
    
    	sumOfA+=(high-low)/2;
    	sumOfA++;
    	
      return sumOfA+ binaryCount(mat, mid+1, high);
    }
    else if(mat[mid]=='b'){
    		  
    	return binaryCount(mat,low, mid);
    }
    return sumOfA;
  }
  public static int binarySearchForA(char[] mat){

    return binaryCount(mat,0,mat.length-1);
  }

	public static void main(String[] args) {
		// This method creates a test case for you
		int n = 5;
		Random rand = new Random();
		char[][] input = new char[n][n];
		for (int i = 0; i < n; i++) {
			int a_num = rand.nextInt(n);
			for (int j = 0; j < a_num; j++) {
				input[i][j] = 'a';
			}
			for (int j = a_num; j < n; j++) {
				input[i][j] = 'b';
			}
		}
		// Here you can see the matrix row by row 
		System.out.println(Arrays.deepToString(input));
		// Here you can see the result of your function
		System.out.println(acount(input));
	}

}
