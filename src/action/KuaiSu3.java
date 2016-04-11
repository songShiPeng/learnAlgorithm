package action;

import java.util.Scanner;
/**
 * 
 * @author 宋世鹏
 *
 */
public class KuaiSu3 {

	/**
	 * 著名的快速排序算法里有一个经典的划分过程：我们通常采用某种方法取一个元素作为主元，通过交换，把比主元小的元素放到它的左边，比主元大的元素放到它的右边。 给定划分后的N个互不相同的正整数的排列，请问有多少个元素可能是划分前选取的主元？

例如给定N = 5, 排列是1、3、2、4、5。则：

1的左边没有元素，右边的元素都比它大，所以它可能是主元；
尽管3的左边元素都比它小，但是它右边的2它小，所以它不能是主元；
尽管2的右边元素都比它大，但其左边的3比它大，所以它不能是主元；
类似原因，4和5都可能是主元。
因此，有3个元素可能是主元。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		int b[]=new int[n];
		sc.nextLine();
		String str=sc.nextLine();
		String strArray[]=str.split(" ");
		for(int i=0;i<n;i++){
			a[i]=Integer.parseInt(strArray[i]);
		}
		int num=n;
		int left=0,right=1;
		int temp;
		for(int j=1;j<n;j++){
			if(a[right]>a[left]){
				left=right;
				right++;
			}
			else{
				num-=2;
				b[right]=1;
				b[left]=1;
				right++;
			}
		}
		right=n-1;left=n-2;
		for(int j=1;j<n;j++){
			if(a[right]>a[left]){
				right=left;
				left--;
			}
			else{
				b[right]=1;
				b[left]=1;
				left--;
			}
		}
		System.out.println(num);
		
		for(int d=0;d<n-1;d++){
			if(b[d]==0)
				System.out.print(a[d]+" ");
		}
		if(b[n-1]==0)
		System.out.print(a[n-1]);
	}

}
