package action;

import java.util.Scanner;

public class ShuiBei2 {
	static int c=0;
	static int a,b;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		a=sc.nextInt();
		b=sc.nextInt();
		jiSuan(a-b+1,a/b+(a%b>0?1:0),1,a);
		if(c<1)
			System.out.println("不能分");
		else{
			
			System.out.println("共"+c+"种");
		}
	}
	
	public static void jiSuan(int max,int min,int diJi,int shengYu){
		if(max<min)
			return;
		if(max==min){
			//System.out.print(min+" ");
			c++;
			/**
			if(diJi++<=b){
				int linSheng=shengYu-min;
				for(int di=diJi;di<=b;di++){
					if(linSheng-b+diJi>=min){
						System.out.println(min+". ");
						linSheng-=min;
						continue;
					}
					else if(linSheng-b+diJi>=--min){
						System.out.println(min+". ");
						linSheng-=min;
						continue;
					}
					System.out.print(1+", ");
				}
				
			}
			*/
			//.out.println(" ");
			return;
			
		}
		for(int i=min;i<=max;i++){
			if(diJi==1)
				System.out.print("第");
			System.out.print(i+" ");
			int nextMax=(shengYu-i-b+diJi+1)>=i?i:(shengYu-i-b+diJi+1);
			int nextMin=(shengYu-i)/(b-diJi)+((shengYu-i)%(b-diJi)>0?1:0);
			int nextDiJi=diJi+1;
			int nextShengYu=shengYu-i;
			jiSuan(nextMax,nextMin,nextDiJi,nextShengYu);
		}
	}

}
