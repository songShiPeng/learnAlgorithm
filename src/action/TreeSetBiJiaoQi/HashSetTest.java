package action.TreeSetBiJiaoQi;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args){
		Set<StudentInfo> stuSet=new HashSet<StudentInfo>();
		stuSet.add(new StudentInfo("song",1));
		stuSet.add(new StudentInfo("song",2));
		for(StudentInfo stu:stuSet){
			System.out.println(stu.name);
		}
	}
}
class StudentInfo implements Comparable<StudentInfo>{
	//equals 和 hashcode必须同时存在
	String name;
	int id;
	public  StudentInfo(String name,int id){
		this.name=name;
		this.id=id;
	}
	public boolean equals(Object o){
		if(this.name.equals(((StudentInfo)o).name)){
			return true;
		}
		else
			return false;
	}
	@Override
	public int compareTo(StudentInfo o) {
		if(this.name.equals(((StudentInfo)o).name)){
			return 0;
		}
		else
			return 1;
	}
	public int hashCode(){
		return name.hashCode();
	}
	
}