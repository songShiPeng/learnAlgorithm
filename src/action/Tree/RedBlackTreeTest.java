package action.Tree;

import java.util.Queue;

public class RedBlackTreeTest {

	/**@author 宋世鹏
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedBlackTree<Integer> rbt=new RedBlackTree<Integer>();
		rbt.insert(1);
		rbt.insert(5);
		rbt.insert(3);
		rbt.insert(10);
		rbt.insert(2);
		rbt.insert(6);
		rbt.insert(12);
		rbt.insert(4);
		rbt.printTree(rbt.header.right);
		rbt.printTreeC(rbt.header.right);
	}

}
class RedBlackNode<T>{
	T element;
	RedBlackNode<T> left;
	RedBlackNode<T> right;
	int color;//黑色为1，红色为0，黑色必须为1
	RedBlackNode(T element){
		this(element,null,null);
	}
	RedBlackNode(T element,RedBlackNode<T> lt,RedBlackNode<T> rt){
		this.element=element;
		this.left=lt;
		this.right=rt;
		this.color=1;
	}
}
class RedBlackTree<T extends Comparable<T>>{
	private RedBlackNode<T> current;
	private RedBlackNode<T> parent;//父亲
	private RedBlackNode<T> grand;//祖父
	private RedBlackNode<T> great;//曾祖父
	 RedBlackNode<T> header;//伪根，右孩子指向真根
	private RedBlackNode<T> nullNode;
	private static final int BLACK=1;
	private static final int RED=0;
	//构造函数
	public RedBlackTree(){
		nullNode=new RedBlackNode<T>(null);
		nullNode.left=nullNode.right=nullNode;
		header=new RedBlackNode<T>(null);
		header.left=header.right=nullNode;
	}
	//输出树，中序
	public void printTree(RedBlackNode<T> root){
		if(!root.equals(nullNode)){
			printTree(root.left);
			System.out.println(root.element+" "+root.color);
			printTree(root.right);
		}
	}
	//输出树，层次，广度优先遍历
		public void printTreeC(RedBlackNode<T> root){
			System.out.println("-----------层次");
			if(!root.equals(nullNode)){
				ArrayQueue<RedBlackNode<T>> q=  new ArrayQueue<RedBlackNode<T>>();
			    q.enqueue(root);
			    int dangQian=1;
			    int cu=0;
			    int xiaYiCeng=0;
			    int feikong=0;
				while(true){
					RedBlackNode<T> element=q.dequeue();
					if(element==nullNode){
						System.out.print(" "+"   ");
					}
					else{
						if(element.color==0)
							System.out.print(element.element+"-r ");
						else if(element.color==1)
							System.out.print(element.element+"-b ");
					}
					cu++;
					if(cu%2==0)
						System.out.print("|");
					//if(element!=nullNode){
						q.enqueue(element.left);
						xiaYiCeng++;
					//}
					//if(element!=nullNode){
						q.enqueue(element.right);
						xiaYiCeng++;
					//}
						if(element.left!=nullNode)
							feikong++;
						if(element.right!=nullNode)
							feikong++;
					if(cu==dangQian){
						System.out.println();
						dangQian=xiaYiCeng;
						xiaYiCeng=0;
						cu=0;
						if(feikong==0)
							break;
						else
							feikong=0;
					}
					if(q.currentSize==0)
						break;
				}
			}
		}
	//查找方法
	public T find(T t){
		nullNode.element=t;//先把待查询的放入nullNode，最终找的的结果如果是nullNode就是没找到
		current=header.right;
		for(;;){
			if(t.compareTo(current.element)<0)
				current=current.left;
			else if(t.compareTo(current.element)>0)
				current=current.right;
			else if(current!=nullNode)//最终找的的结果如果是nullNode就是没找到
				return current.element;
			else
				return null;
		}
	}
	
	//插入
	public void insert(T t){
		current=parent=grand=header;
		nullNode.element=t;
		while(compare(t,current)!=0){
			great=grand;
			grand=parent;
			parent=current;
			current=compare(t,current)<0?current.left:current.right;
			if(current.left.color==RED&&current.right.color==RED)
				handleReorient(t);
		}
		if(current!=nullNode)//有与他相同的项
			return ;
		current=new RedBlackNode<T>(t,nullNode,nullNode);
		if(compare(t,parent)<0){
			parent.left=current;
		}
		else
			parent.right=current;
		handleReorient(t);//如果他的父亲是红色的，需要一次旋转
		System.out.println("------------插入"+current.element);
		printTree(this.header.right);
		System.out.println("------------------------");
	}
	//比较
	private final int compare(T t,RedBlackNode<T> node){
		if(node==header)
			return 1;
		else
			return t.compareTo(node.element);
	}
	
	//在节点有两个红孩子时或插入新节点调用
	private void handleReorient(T t){
		current.color=RED;
		current.left.color=BLACK;
		current.right.color=BLACK;
		if(parent.color==RED){
			grand.color=RED;
			if((compare(t,grand)<0)!=(compare(t,parent)<0)){//如果是curent是内部节点
				parent=rotate(t,grand);//交换parent与current
			}
			current=rotate(t,great);//交换grand与parrent
			current.color=BLACK;
			
		}
		header.right.color=BLACK;
	}
	//完成适当旋转的程序
	private RedBlackNode<T> rotate(T t,RedBlackNode<T> parent){
		if(compare(t,parent)<0){//current位于parent左节点
			return parent.left=compare(t,parent.left)<0?rotateWithLeftChild(parent.left):
				rotateWithRightChild(parent.left);
		}
		else
			return parent.right=compare(t,parent.right)<0?rotateWithLeftChild(parent.right):
				rotateWithRightChild(parent.right);
		
	}
	
	//以k2为根的单旋转
	private RedBlackNode<T> rotateWithLeftChild(RedBlackNode<T> k2){
		RedBlackNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
	}
	//以k1为根的单旋转
	private RedBlackNode<T> rotateWithRightChild(RedBlackNode<T> k1){
		RedBlackNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
	}
}

//队列
class ArrayQueue<T> {

	/**<li>功能描述：数组实现队列
	 * @author 宋世鹏
	 * @param args
	 * 
	 */
	
	 int back=-1;//尾部
	 int front=0;//头部.头部要比尾部大1，因为初始录入一个数后back会+1
	 T []a=(T[])new Object[10] ;
	 int currentSize=0;//当前大小
	
	//添加
	public  void enqueue(T b){
		if(currentSize==a.length)
			doubleQueue();
		back=increment(back);
		a[back]=b;
		currentSize++;
	}
	//删除
	public  T dequeue(){
		if(currentSize==0)
			return null;
		T linShi=a[front];
		front=increment(front);
		currentSize--;
		return linShi;
	}
	//置空
	public  void makeEmpty(){
		currentSize=0;
		back=-1;
		front=0;
	}
	//下移
	public  int increment(int x){
		if(++x==a.length)
			return 0;
		return x;
	}
	//双倍
	public  void doubleQueue(){
		T [] newArray=(T[])new Object[a.length*2];
		for(int i=0;i<currentSize;i++,front=increment(front)){
			newArray[i]=a[front];
		}
		a=newArray;
		front=0;
		back=currentSize-1;
	}

}

