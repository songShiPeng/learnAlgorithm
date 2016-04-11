package action;

import java.util.Scanner;

public class Fuermosi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String a=sc.nextLine();
		String b=sc.nextLine();
		String c=sc.nextLine();
		String d=sc.nextLine();
		String week[]=new String['G'+1];
		week['A']="MON";
		week['B']="TUE";
		week['C']="WED";
		week['D']="THU";
		week['E']="FRI";
		week['F']="SAT";
		week['G']="SUN";
		int hour[]=new int['N'+1];
		for(int i=0;i<=9;i++){
			hour[i]=String.valueOf(i).charAt(0);
		}
		for(int j='A',h=10;j<='N';j++,h++){
			hour[j]=h;
		}
		int r1[]=new int[2];
		int r2[]=new int[2];
		result(r1,a,b,0);
		result(r2,c,d,1);
		System.out.print(week[r1[0]]+" ");
		System.out.print(hour[r1[1]]+":");
		if(r2[0]<10)
			System.out.print("0");
		System.out.print(r2[0]);
		
	}
	public static void result(int r[],String a,String b,int c){
		char temp[]=a.toCharArray();
		char temp2[]=b.toCharArray();
		for(int i=0,n=0;i<temp.length;i++){
			if(n>1)
				continue;
			if(c==0&&n==0&&(temp[i]<'A'||temp[i]>'Z'))
				continue;
			else if(c==0&&n==1&&((temp[i]<'0'||temp[i]>'Z'||(temp[i]<'A'&&temp[i]>'9'))))
				continue;
			else if(c==1&&(n>1||(temp[i]<'A'||temp[i]>'z'||(temp[i]<'a'&&temp[i]>'Z'))))
				continue;
			for(int j=0;j<temp2.length;j++){
				
				
				if(temp[i]==temp2[j]){
					
					if(c==1&&n==0)
						r[n]=j;
					else
						r[n]=temp[i];
					n++;
					break;
				}
			}
		}
	}

}
