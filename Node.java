import java.io.*;

public class Node  {
	
	private int data;
	private Node next;

	public Node(int d){
		data = d;
	}
	
	public Node(int d, Node n){
		data = d;
		next = n;
	}
	
	public int getData(){
		return data;
		}
	public Node getNext(){
		return next;
		}
	public void setNext(Node n){
		next = n;
		}

	
	public void printB() throws IOException, MyException{
		String filename="datas.txt";
		PrintWriter pws = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename))));
	printBackwards(pws);
	pws.close();
	}
	
	
	public int sum() throws MyException{
		// if the data is negative throw MyException
		if(data<0){
			throw new MyException();
		} 
		if(next==null){
			return this.data;
		}  // returns  sum that is calculated
		else return this.data + next.sum();
	}
		
		/*int result =0;
		while(temp!=null){
			result +=temp.getNext().getData();
		}*/
		
		/*if (result<0)
		{
			throw MyException();
		}
		return result;
		}
	}*/
	
	// takes in printwriter object
	public void printBackwards(PrintWriter p) throws MyException{
		
		if(data==9){
			throw new MyException();
		}
		 if(this.next==null){
			p.println(this.data);
		}else {
			next.printBackwards(p);
			p.println(this.data);
		}
	}
}
