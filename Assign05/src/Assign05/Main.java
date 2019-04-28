package Assign05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	BinaryTree t=new BinaryTree();
	Scanner kb= new Scanner(System.in);
	String str;
	public static void main(String[] args) {
		Main app=new Main();
		app.process_command();

	}

	private void process_command() {

		read();


		while(true) {
			System.out.print("$ ");
			str=kb.next();
			if(str.equalsIgnoreCase("find")) {

				find();

			}

			else if(str.equalsIgnoreCase("add")) {

				add();

			}
			else if(str.equals("delete")) {

				delete();
			}
			else if(str.equals("deleteall")) {

				deleteall();
			}

			else if(str.equals("size")) {

				size();
			}
			else if(str.equals("exit"))
			{
				break;
			}


		}

		kb.close();



	}

	private void find() {
		String findStr=kb.next();

		Node findNode=new Node();

		findNode=t.TreeSearch(t.root,findStr );

		if(findNode==null)
			System.out.println("Not Found");

		else
			System.out.println(findNode.word+": "+findNode.meaning);


	}

	private void read() { 
		try {
			Scanner sc=new Scanner(new File("shuffled_dict.txt"));
			while(sc.hasNext()) {

				String allstr=sc.nextLine();
				String w,c,mean;
				int i=allstr.indexOf("(");
				int j=allstr.indexOf(")");
				w=allstr.substring(0, i);
				w=w.replaceAll(" ", "");
				if((j-i)==1) //품사가 존재하지않으면
					c=" ";


				else 
					c=allstr.substring(i+1, j-1);

				if(j+2<=allstr.length())
					mean=allstr.substring(j+2, allstr.length());

				else mean=" ";

				Node node=new Node(w,c,mean);
				t.TreeInsert(t, node);



			}

			sc.close();

		} 
		catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	private void deleteall() {
		String Fname=kb.next();
		int cnt=0;
		try {
			Scanner Fin =new Scanner (new File(Fname));

			while(Fin.hasNext()) {
				String w=Fin.nextLine();
				w=w.replaceAll(" ", "");
				Node node=new Node(w," "," ");
				node=t.TreeSearch(t.root, w);
				if(node!=null)
				{
					t.TreeDelete(t, node);
					cnt++;
				}

			}
			System.out.println(cnt+" words were deleted successfully.");

			Fin.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}


	}

	private void size() {

		int allnode=t.size(t.root);
		System.out.println(allnode);

	}

	private void delete() {
		String toDelete=kb.next();
		Node node=new Node();
		node=t.TreeSearch(t.root, toDelete);
		if(node==null)
			System.out.println("Not Found");
		else {
			t.TreeDelete(t, node);
		} 




	}

	private void add() {

		System.out.print("word: ");
		String w=kb.next();
		String c=kb.nextLine();
		System.out.print("Class: ");
		c=kb.nextLine();

		System.out.print("meaning: ");
		String m=kb.next();

		Node node=new Node(w,c,m);
		t.TreeInsert(t, node);


	}

}