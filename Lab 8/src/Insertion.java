
public class Insertion implements Comparable<Integer>{
	 
	    public static void insertionSort(int array[]) {  
	        int n = array.length;  
	        for (int j = 1; j < n; j++) {  
	            int key = array[j];  
	            int i = j-1;  
	            while ( (i > -1) && ( array [i] > key ) ) {  
	                array [i+1] = array [i];  
	                i--;  
	            }  
	            array[i+1] = key;  
	        }  
	    }  
	       
	    public static void main(String a[]){    
	    	
	       
	         System.out.println(Algorithms.algorithm0(5));
	         System.out.println(Algorithms.algorithm1(6));
	         System.out.println(Algorithms.algorithm2(9));
	         System.out.println(Algorithms.algorithm3(15));
	         System.out.println(Algorithms.algorithm4(15));
	         
	         int[] arr1 = {9,14,3,2,43,11,58,22};    
	         System.out.println("Before Insertion Sort");    
	         for(int i:arr1){    
	             System.out.print(i+" ");    
	         }    
	         System.out.println();    
	             
	         insertionSort(arr1);//sorting array using insertion sort    
	            
	         System.out.println("After Insertion Sort");    
	         for(int i:arr1){    
	             System.out.print(i+" ");    
	         }    
	         
	        }    
	    

		@Override
		public int compareTo(Integer o) {
			// TODO Auto-generated method stub
			return 0;
		}    
	}    



	
