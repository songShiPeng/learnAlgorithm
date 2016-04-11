package action.Tree;

import java.util.Comparator;

public class ChaZhaoTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySerchTree<JiBen> bt=new BinarySerchTree<JiBen>();
		bt.root=bt.insert(new JiBen("宋",1), bt.root);
		//为什么以后的不用bt.root=，因为引用类型传的参数不能是null
		bt.insert(new JiBen("宋",8), bt.root);
		bt.insert(new JiBen("宋",4), bt.root);
		bt.insert(new JiBen("宋",5), bt.root);
		bt.insert(new JiBen("宋",2), bt.root);
		bt.insert(new JiBen("宋",6), bt.root);
		bt.remove(new JiBen("宋",4), bt.root);
		bt.printlnTree(bt.root);
	}

}
class JiBen implements Comparable<JiBen>{
	protected String name;
	protected int id;
	public JiBen(String s,int i){
		this.name=s;
		this.id=i;
	}
	
	@Override
	public int compareTo(JiBen o) {
		// TODO Auto-generated method stub
		JiBen j1=o;
		if(id<j1.id)
			return -1;
		else if(id>j1.id)
			return 1;
		return 0;
	}
	
}
class BinaryNode2<T>{
	protected T element;
	protected BinaryNode2<T> left;
	protected BinaryNode2<T> right;
	public BinaryNode2(T element,BinaryNode2<T> left,BinaryNode2<T> right){
		this.element=element;
		this.left=left; 
		this.right=right;
	}
	
	
}
class BinarySerchTree<T extends Comparable<T>>{
	public BinarySerchTree(){
		this.root=null;
	}
	protected BinaryNode2<T> root=null;
	
	//查找
	public BinaryNode2<T> find(T t,BinaryNode2<T> node){
		while(node!=null){
			if(t.compareTo(node.element)<0){
				node=node.left;
			}
			else if(t.compareTo(node.element)>0){
				node=node.right;
			}
			else
				return node;
		}
		return null;
	}
	
	public BinaryNode2<T> findMin(BinaryNode2<T> node){
		if(node!=null){
			while(node.left!=null){
				node=node.left;
			}
		}
		return node;
	}
	
	public BinaryNode2<T> findMax(BinaryNode2<T> node){
		if(node!=null){
			while(node.right!=null){
				node=node.right;
			}
		}
		return node;
	}
	
	protected BinaryNode2<T> insert(T t,BinaryNode2<T> node){
		if(node==null)
			node= new BinaryNode2<T>(t,null,null);
		else if(t.compareTo(node.element)<0)
			node.left=insert(t,node.left);
		else if(t.compareTo(node.element)>0)
			node.right=insert(t,node.right);
		else{
		}
		return node;
	}
	
	protected BinaryNode2<T> removeMin(BinaryNode2<T> t){
		if(t==null){
			return null;
		}
		else if(t.left!=null){
			t.left=removeMin(t.left);
			return t;
		}
		else{
			return t.right;
		}
	}
	
	protected BinaryNode2<T> remove(T t,BinaryNode2<T> node){
		if(node==null){
			return null;
		}
		if(t.compareTo(node.element)<0){
			node.left=remove(t,node.left);
		}
		else if(t.compareTo(node.element)>0){
			node.right=remove(t,node.right);
		}
		else if(node.left!=null&&node.right!=null){//有两个孩子
			node.element=findMin(node.right).element;
			node.right=removeMin(node.right);
		}
		else{//一个或没有孩子
			node=(node.left==null)?node.left:node.right;
		}
		return node;
	}
	
	public void printlnTree(BinaryNode2<T> node){
		if(node!=null){
			if(node.left!=null)
				printlnTree(node.left);
			System.out.println(((JiBen)node.element).id);
			if(node.right!=null)
				printlnTree(node.right);
		}
	}
	
}
