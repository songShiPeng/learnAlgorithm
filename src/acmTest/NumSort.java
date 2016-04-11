package acmTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 输入一行数字，如果我们把这行数字中的‘5’都看成空格，那么就得到一行用空格分割的若干非负整数（可能有些整数以‘0’开头，这些头部的‘0’应该被忽略掉，除非这个整数就是由若干个‘0’组成的，这时这个整数就是0）。你的任务是：对这些分割得到的整数，依从小到大的顺序排序输出。
 * @author 14642
 *
 */
public class NumSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		List<String> list=new ArrayList<String>();
		String s;
		int d;
		String []array;
		String s2="";
		//int num=0;
		while(sc.hasNext()){
		//while(num<2){
			//num++;
			s=sc.nextLine();
			array=s.split("5");
			int [] i=new int[array.length];
			for(int j=0;j<i.length;j++)
				i[j]=Integer.parseInt(array[j]);
			Arrays.sort(i);
			for(int j=0;j<i.length-1;j++)
				s2+=(i[j]+" ");
			if(i.length-1>=0)
				s2+=(i[(i.length-1)<0?0:(i.length-1)]);
			list.add(s2);
			s2="";
		}
		Iterator<String> it=list.iterator();
		for(int i=0;i<list.size();i++)
			System.out.println(it.next());
	}

}
