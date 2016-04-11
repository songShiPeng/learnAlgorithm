package action;


public class DuiZhan {

	Integer b = new Integer(0);
	int[] c = new int[1];
	TTT t=new TTT();
	String dString=new String("ÄãºÃ");
	
	char[] e = new char[]{'w','e'};

	public static void main(String[] args) {

		DuiZhan bate = new DuiZhan();
		//bate.add(bate.b);
		//addS(bate.b);
		//bate.addShuZu(bate.c);
		//addShuZuS(bate.c);
		bate.addChar(bate.t);
		System.out.println(bate.t.a);
	}

	public void add(Integer a) {
		a++;
	}

	public void addShuZu(String dString) {
		dString="2";
	}
	
	public void addChar(TTT a) {
		a.a=1;
		
	}
	
	public void addString(int a[]) {
		a[0]++;
	}

	public static void addS(int a) {
		a++;
	}

	public static void addShuZuS(int a[]) {
		a[0]++;
	}
}
class TTT{
	int a=0;
}
