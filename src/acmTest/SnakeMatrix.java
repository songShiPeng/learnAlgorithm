package acmTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 蛇形矩阵的实现
 * @author 宋世鹏
 *
 */
public class SnakeMatrix {

	/**
	 * 本题要求将给定的N个正整数按非递增的顺序，填入“螺旋矩阵”。所谓“螺旋矩阵”，是指从左上角第1个格子开始，按顺时针螺旋方向填充。要求矩阵的规模为m行n列，满足条件：m*n等于N；m>=n；且m-n取所有可能值中的最小值。

输入格式：

输入在第1行中给出一个正整数N，第2行给出N个待填充的正整数。所有数字不超过104，相邻数字以空格分隔。

输出格式：

输出螺旋矩阵。每行n个数字，共m行。相邻数字以1个空格分隔，行末不得有多余空格。

输入样例：
12
37 76 20 98 76 42 53 95 60 81 58 93
输出样例：
98 95 93
42 37 81
53 20 76
58 60 76

	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int direction=0;//表示方向，0是向右，1是向下，2是向左，3是向上
		int n=1,m=num,cha=m-1;
		Integer scArray[]=new Integer[num];
		for(int i=2;i<num;i++){
			if(num%i==0&&(num/i)>i&&((num/i)-i)<cha){
				n=i;
				m=num/i;
				cha=m-n;
			}
		}
		for(int i=0;i<num;i++){
			scArray[i]=sc.nextInt();
		}
		compareDESC cmd=new compareDESC();
		Arrays.sort(scArray,cmd);
		System.out.println(m+" "+n);
		int a[][]=new int[m][n];//4行要把4当成第一个，每一行是一个数组
		int b=0,c=0;//代表二位数组的两个下标
		for(int i=0;i<num;i++){
			if(direction==0){
				a[b][c]=scArray[i];
				if(c+1>n-1||a[b][c+1]!=0){
					direction=1;
					b++;
					continue;
				}
				else{
					c++;
				}
			}
			else if(direction==1){
				a[b][c]=scArray[i];
				if(b+1>m-1||a[b+1][c]!=0){
					direction=2;
					c--;
					continue;
				}
				else{
					b++;
				}
			}
			else if(direction==2){
				a[b][c]=scArray[i];
				if(c==0||a[b][c-1]!=0){
					direction=3;
					b--;
					continue;
				}
				else{
					c--;
				}
			}
			else if(direction==3){
				a[b][c]=scArray[i];
				if(b==0||a[b-1][c]!=0){
					direction=0;
					c++;
					continue;
				}
				else{
					b--;
				}
			}
		}
		for(b=0;b<m;b++){
			for(c=0;c<n;c++){
				System.out.print(a[b][c]+" ");
			}
			System.out.println();
		}
	}
}
class compareDESC implements Comparator<Integer>{

	@Override
	public int compare(Integer arg0, Integer arg1) {
		// TODO Auto-generated method stub
		if(arg0<arg1)
			return 1;
		else if(arg0==arg1)
			return 0;
		return -1;
	}
	
}

