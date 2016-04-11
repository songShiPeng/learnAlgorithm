package action.TreeSetBiJiaoQi;
import java.util.*;
public class TreeSetBiJiaoQi {
	public static void main(String [] args){
		Set treeSet =new TreeSet(new TestComparetor());
		treeSet.add(new TestBig(8,"好"));
		treeSet.add(new TestBig(9,"不好"));
		Iterator it=treeSet.iterator();
		while(it.hasNext()){
			TestBig test=(TestBig) it.next();
			System.out.println(test.a+"  ");
		}
	}
}
//comparator类
class TestComparetor implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int a1=((TestBig)o1).a;
		int a2=((TestBig)o2).a;
		if(a1<a2)
			return 1;
		return -1;
	}
	
}
//用于比较大小的类
class TestBig{
	int a;
	String b;
	public TestBig(int a,String b){
		this.a=a;
		this.b=b;
	}
	public int getA(){
		return a;
	}
}