package action.Test;

public class TestYinYong {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shu s=new Shu();
		s.a=2;
		Change a=new Change();
		a.su=new Shu();
		a.change(a.su);
		System.out.println(a.su.a);
		
	}
	public static void change(Shu s){
		s.a=5;
	}

}
class Shu{
	
	int a;
	
}
class Change{
	Shu su;
	public void change(Shu s){
		if(s==null)
			s=new Shu();
		s.a=5;
	}
}