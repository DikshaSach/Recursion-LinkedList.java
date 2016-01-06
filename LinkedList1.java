import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
public class LinkedList1 {

	private Node head;
	private int count;
	 public LinkedList1() {
			
		}
		
	
	public LinkedList1(int x){
		head = new Node(x);
		count =1;
	}
	public LinkedList1(Node n){
		head = n;
		count =1;
	}
	
	
	public void print(){
		Node current = head;
		while (current!=null){
			System.out.print(current.getData()+" ");
			current = current.getNext();
		}
		System.out.println();
	}
	
	public void insert(int x){
		if(head==null){
			head = new Node(x);
			return;
		}
		if(x<=head.getData()){
			head = new Node(x, head); // case 1
			return;
		}
		Node current = head;
		Node previous = head;
		while(current!=null){
			if(x>current.getData()){
				previous = current;
				current = current.getNext();
			} else {
				previous.setNext(new Node(x,current)); // case 2
				return;
			}
		}
		previous.setNext(new Node(x)); // case 3
		count++;
	}

	public boolean delete(int x){
		if(head.getData()==x){
			head = head.getNext(); // case 1
			count--;
			return true;
		}
		Node current = head.getNext();
		Node previous = head;
		while(current!=null){
			if(current.getData()==x){
				previous.setNext(previous.getNext().getNext()); // cases 2 & 3
				count--;
				return true;
			} else if(current.getData()>x){
				break;
			} else {
				previous = current;
				current = current.getNext();
			}
		} // while
		return false;
	}
	
	public void append(int x){ // adds it to the end of the array. (inserts node to last position instead of it being in order)
	
		Node current = head;
		while(current.getNext()!=null){
			current = current.getNext();
		}
		// Node temp = new Node(x);
		// current.setNext(temp);
		current.setNext(new Node(x));
		count++;
	}
	

	public void printB() throws IOException, MyException{
		PrintWriter prw = new PrintWriter(
						 new BufferedWriter(
						 new OutputStreamWriter(
						 new FileOutputStream("outputt.txt"))));
		head.printBackwards(prw);
		prw.flush();
		prw.close();

	}
	// takes in an int 
	public void sum(int x) throws  MyException, FileNotFoundException{
		
		PrintWriter pw = new PrintWriter(
						 new BufferedWriter(
						 new OutputStreamWriter(
						 new FileOutputStream("outputt.txt"))));
// handle if x is less than then just print out a 0
		if(x<1){
			pw.println(0);
			// if the x is greater than the amount of nodes in list throw an exception
		} else if(x>count) {
			pw.close();
			throw new MyException("There are not that many nodes");
		}
	
		 else {
			Node current = head;
			for(int i=1;i<x;i++){
				current=current.getNext();
			}
			pw.println(current.sum());
		}
		pw.flush();
		pw.close();
	}
	}
