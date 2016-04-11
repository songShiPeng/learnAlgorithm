package action.Test;

import java.math.BigDecimal;
import java.util.Scanner;

public class TestBigDecimal {
	    public static void main(String [] args){
	        Scanner sc=new Scanner(System.in);
	        int b=sc.nextInt();
	        BigDecimal a[]=new BigDecimal[3];
	       
	        for(int j=0;j<b;j++){
	        	 int i=0;
	            while(i<3){
	                
	                 a[i]=sc.nextBigDecimal();
	                 i++;
	            }
	            if((a[0].add(a[1]).compareTo(a[2]))<0)
	                System.out.println("Case #"+j+1+": false");
	            else
	                System.out.println("Case #"+j+1+": true");
	        }
	    }
	
}
