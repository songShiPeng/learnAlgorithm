package action.ChaZhi;

import java.util.Scanner;
import java.util.Arrays;
public class ChaZhi {
	public static void main(String [] args){
		int a[]={1,3,7,10,18,20,28,32,35,37};
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		//算法开始
		int low=0,high=a.length-1,next=0;
		while(low<=high){
			next=low+((num-a[low])/(a[high]-a[low]))*(high-low-1);
			if(a[next]<num){
				low=next+1;
			}
			else if(a[next]>num){
				high=next-1;
			}
			else{
				System.out.println(next);
				break;
			}
		}
	}
}
