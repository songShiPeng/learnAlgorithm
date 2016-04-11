package acmTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 输入数据包含多个测试实例，每个测试实例占一行，每行的第一个数为n，表示本组数据一共有n个，接着是n个整数，你可以假设每组数据必定至少存在一个奇数。
 * @author 宋世鹏
 *
 */
public class JiShuJi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int ji=1,b,n,n2=0,i=0;
		List<Integer> c=new ArrayList<Integer>();
		String sb;
		int i2=0;
		while(sc.hasNextInt()){
			n=sc.nextInt();
			for(i=0;i<n;i++){
				b=sc.nextInt();
				if(b%2==1){
					ji*=b;
				}
			}
			c.add(ji);
			ji=1;
			i2++;
		}
		Iterator<Integer> it=c.iterator();
		for(i=0;i<c.size();i++)
			System.out.println(it.next());
	}

}
