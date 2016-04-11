package action.ZhanDuiLie;

import java.util.Stack;

public class ZhanShuZu{
	private static  int []a=new int[1];
	private static int b=-1;
	public static void main(String [] args){
		push(4);
		push(5);
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
	}
	//压栈
	public static void push(int num){
		if(b+1==a.length)
			doubleArray();
		a[++b]=num;
	}
	//移除栈顶对象并返回当前值
	public static int pop(){
		if(b==-1)
			return 0;
		return a[b--];
	}
	//将数组翻倍
	public static void doubleArray(){
		int []newArray=new int[a.length*2];
		for(int i=0;i<a.length;i++){
			newArray[i]=a[i];
		}
		a=newArray;
	}
}
