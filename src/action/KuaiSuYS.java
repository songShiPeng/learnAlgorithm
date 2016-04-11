package action;

import java.util.Arrays;
import java.util.Scanner;

public class KuaiSuYS {

	/**
	 * @param args
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
			b[i]=a[i];
		}
		int l=b[0];
		int max=0;
		Arrays.sort(a);
		int num=0;
		for(int i=0;i<a.length;i++){
			if(b[i]>max)
				max=b[i];
			if(a[i]==b[i]&&b[i]==max){
				num++;
			}
			else
				b[i]=0;
		}
		System.out.println(num);
		int pnum=0;
		if(l==0){
			System.out.print(0+" ");
			pnum++;
		}
		else if(b[0]!=0){
			System.out.print(b[0]+" ");
			pnum++;
		}
		int d;
		for( d=1;d<n;d++){
			if(b[d]!=0){
				if(pnum<num){
					System.out.print(b[d]+" ");
					pnum++;
				}
				else
					System.out.print(b[d]);
			}
			
		}
		
	}

}
