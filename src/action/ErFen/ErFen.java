package action.ErFen;
import java.util.Scanner;
public class ErFen {
	public static void main(String [] args){
		int a[]={1,3,7,10,18,20,28,32,35,37};
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		//算法开始,优化前
		int low=0,high=a.length-1,mid=0;
		while(low<=high){
			mid=(low+high)/2;
			if(a[mid]<num){
				low=mid+1;
			}
			else if(a[mid]>num){
				high=mid-1;
			}
			else{
				System.out.println(mid);
				break;
			}
		}
	}
}
