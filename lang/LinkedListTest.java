
class Link{
	public int data;
	public Link next;
	public void display(){
		System.out.println(data);}
	}
class LinkedList{
	Link first=null;
	public void insert(int data){
		Link newLink=new Link();
		newLink.data=data;
		newLink.next=first;
		first=newLink;
		newLink.display();
	}
	public void delete(){ first=first.next; }
}
public class LinkedListTest {

	
	public static void main(String[] args) {
	LinkedList list=new LinkedList();
	list.insert(20);
	list.insert(30);
	list.insert(40);
	}

}
