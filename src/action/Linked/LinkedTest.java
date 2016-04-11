package action.Linked;

public class LinkedTest {
	//单链表，最简单，自己写的
	public static void main(String args[]){
		Linked2 liked=new Linked2();
		liked.addFirst(2);
		liked.addFirst(3);
		liked.addFirst(8);
		liked.addFirst(10);
		liked.insert(2, 77);
		liked.outLinked();
	}
}
class LinkedElement{
	public int info;
	public LinkedElement next;
	public LinkedElement(int i){
		this.info=i;
	}
}
class Linked2{
	LinkedElement head,tail,now=null,newElement;
	int num;
	public boolean isEmpty(){
		return head==null;
	}
	public Linked2(){
		head=tail=null;
	}
	public void addToHead(int a){
		head=new LinkedElement(a);
		if(tail==null) tail=head;
	}
	public void insert(int a,int i){
		if(head==null){
			addToHead(i);
		}
		else{
			now=head;
			for(int b=0;b<a;b++){
				if(now!=null){
					now=head.next;
				}
				else break;
			}
			newElement=new LinkedElement(i);
			newElement.next=now.next;
			now.next=newElement;
		}
	}
	public void deleteElement(int i){
		if(head==null){
			return;
		}
		else if(head==tail){
			head=tail=null;
		}
		
	}
	public void outLinked(){
		now=head;
		for(;now!=null;now=now.next){
			System.out.println(now.info);
		}
	}
	public void addFirst(int i){
		if(head==null)
			addToHead(i);
		else{
			newElement=new LinkedElement(i);
			newElement.next=head;
			head=newElement;
		}
	}
}