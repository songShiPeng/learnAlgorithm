package action;

import java.util.Scanner;

public class SuShuKeJi {

	/**@author 宋世鹏
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int num=1;
		System.out.print(2+" ");
		for(int i=3;i<m;i+=2){
			if(check(i)){
				System.out.print(i+" ");
				num++;
				if(num%10==0)
					System.out.println();
			}
		}
		System.out.println();
		System.out.println(num);
		return ;
				
	}
	public static boolean check(int a){
		int linShi=a/2+1;
		for(int i=2;i<linShi;i++){
			if(a%i==0)
				return false;
		}
		
		return true;
	}

}
