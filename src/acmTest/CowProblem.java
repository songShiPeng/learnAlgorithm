package acmTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 有一头母牛，它每年年初生一头小母牛。每头小母牛从第四个年头开始，每年年初也生一头小母牛。请编程实现在第n年的时候，共有多少头母牛？
 * @author 宋世鹏
 */
public class CowProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int canProcreate=1;//可以生的母牛数量
		Map<Integer,Integer> cowMap=new HashMap<Integer,Integer>();//不可以生的母牛
		List<Integer> resultList=new ArrayList<Integer>();
		Scanner sc=new Scanner(System.in);
		int temp;//用来存放临时信息
		//while(sc.hasNext()){
		while(true){
			int n=sc.nextInt();
			if(n==0)
				break;
			cowMap.put(1,0);
			cowMap.put(2,0);
			cowMap.put(3,0);
			cowMap.put(4,0);
			
			for(int i=1;i<n;i++){
				temp=cowMap.get(1);
				canProcreate+=temp;
				cowMap.put(1,cowMap.get(2));
				cowMap.put(2, cowMap.get(3));
				cowMap.put(3, canProcreate);
				
			}
			resultList.add(canProcreate+cowMap.get(1)+cowMap.get(2)+cowMap.get(3)+cowMap.get(4));
			System.out.println(canProcreate+cowMap.get(1)+cowMap.get(2)+cowMap.get(3)+cowMap.get(4));
			canProcreate=1;
		}
//		for(int i=0;i<resultList.size();i++)
//			System.out.println(resultList.get(i));
	}

}
