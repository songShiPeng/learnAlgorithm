package action;

import java.util.Scanner;
/**
 * 
 * @author 宋世鹏
 *
 */
public class ShuiBei {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b;
		Scanner sc=new Scanner(System.in);
		a=sc.nextInt();
		b=sc.nextInt();
		int c=jiSuan(a,b);
		if(c<1)
			System.out.println("不能分");
		else{
			
			System.out.println(c);
		}
			
	}
	public static int jiSuan(int a,int b){
		int zhi=0;
		if(a==b)
			return a;
		for(int i=1;i<a;i++){
			for(int j=1;j<=i;j++){
				for(int z=1;z<=j;z++){
					if(i+z+j==a){
						zhi++;
						System.out.println(i+ " "+j+" "+z);
					}
				}
			}
		}
		return zhi;
	}
}
