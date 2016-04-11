package action.ZhanDuiLie;

public class DuiLieArray {

	/**<li>功能描述：数组实现队列
	 * @author 宋世鹏
	 * @param args
	 * 
	 */
	
	static int back=-1;//尾部
	static int front=0;//头部.头部要比尾部大1，因为初始录入一个数后back会+1
	static int []a=new int[1];
	static int currentSize=0;//当前大小
	public static void main(String[] args) {
		enqueue(3);
		enqueue(4);
		enqueue(5);
		enqueue(6);
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
	}
	//添加
	public static void enqueue(int b){
		if(currentSize==a.length)
			doubleQueue();
		back=increment(back);
		a[back]=b;
		currentSize++;
	}
	//删除
	public static int dequeue(){
		if(currentSize==0)
			return 0;
		int linShi=a[front];
		front=increment(front);
		currentSize--;
		return linShi;
	}
	//置空
	public static void makeEmpty(){
		currentSize=0;
		back=-1;
		front=0;
	}
	//下移
	public static int increment(int x){
		if(++x==a.length)
			return 0;
		return x;
	}
	//双倍
	public static void doubleQueue(){
		int [] newArray=new int[a.length*2];
		for(int i=0;i<currentSize;i++,front=increment(front)){
			newArray[i]=a[front];
		}
		a=newArray;
		front=0;
		back=currentSize-1;
	}

}
