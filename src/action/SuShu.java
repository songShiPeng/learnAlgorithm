package action;

import java.util.Scanner;

public class SuShu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int num=0;
		int printNum=0;
		for(int i=2;;i++){
			if(check(i)){
				if(num<m-1){
					num++;
					continue;
				}
				if(num==n)
					break;
				printNum++;
				num++;
				if(printNum>0&&printNum%10==0)
					System.out.println(i);
				else if(num==n)
					System.out.print(i);
				else
					System.out.print(i+" ");
				
			}
		}
	}
	public static boolean check(int a){
		if(a==0||a==1)
			return false;
		if(a==2)
			return true;
		int linShi=a/2+1;
		for(int i=2;i<linShi;i++){
			if(a%i==0)
				return false;
		}
		return true;
	}

}
