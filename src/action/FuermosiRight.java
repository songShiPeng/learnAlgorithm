package action;

import java.util.Scanner;

public class FuermosiRight {

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
			hour[i]=i;
		}
		for(int j='A',h=10;j<='N';j++,h++){
			hour[j]=h;
		}
		int r1[]=new int[2];
		int r2[]=new int[2];
		result(r1,a,b,0);
		result(r2,c,d,1);
		System.out.print(week[r1[0]]+" ");
		if(r1[1]<'A')
			System.out.print("0");
		System.out.print(hour[r1[1]<'A'?r1[1]-48:r1[1]]+":");
		if(r2[0]<10)
			System.out.print("0");
		System.out.print(r2[0]);
		
	}
	public static void result(int r[],String a,String b,int c){
		char temp[]=a.toCharArray();
		char temp2[]=b.toCharArray();
		for(int i=0,n=0;i<temp.length;i++){
			if(n>1)
				break;
			if(c==0&&n==0&&(temp[i]<'A'||temp[i]>'Z'))
				continue;
			else if(c==0&&n==1&&((temp[i]<'0'||temp[i]>'Z'||(temp[i]<'A'&&temp[i]>'9'))))
				continue;
			else if(c==1&&(n>1||(temp[i]<'A'||temp[i]>'z'||(temp[i]<'a'&&temp[i]>'Z'))))
				continue;
			
				
				
				if(temp[i]==temp2[i]){
					
					if(c==1&&n==0)
						r[n]=i;
					else
						r[n]=temp[i];
					n++;
					
				
			}
		}
	}

}
