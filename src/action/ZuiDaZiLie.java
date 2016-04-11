package action;
import java.util.*;

public class ZuiDaZiLie {
	/**
	 * 求任一数组的连续最大子列和
	 * @param args
	 */
	public static void main(String [] args){
		System.out.println("请输入数组长度");
		Scanner sc =new Scanner(System.in);
		int a=sc.nextInt();
		//System.out.println("请输入"+a+"个整数");
		int [] num=new int[a];
		for(int i=0;i<a;i++){
			num[i]=sc.nextInt();
		}
		//算法开始
		int maxSum=0,sum=0;
		for(int i=0;i<a;i++){
			sum=sum+num[i];
			if(sum>maxSum)
				maxSum=sum;
			if(sum<0)
				sum=0;
		}
		System.out.println(maxSum);
	}
}
