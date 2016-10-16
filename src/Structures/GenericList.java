package Structures;

import Structures.Nodo;


public class GenericList<T>{
	private Nodo<T> head;
	private int lenght;




	public GenericList(){
		this.head = null;
		this.lenght = 0;
	}
	
	
	
	public void addFirst(T dato){
		if(this.head == null){
			this.head = new Nodo<T>(dato);
		}
		else{
			Nodo<T> newNodo = new Nodo<T>(dato);
			newNodo.setNext(this.head);
			this.head = newNodo;
		}
		this.lenght++;
	}
	
	public void addLast(T data){	
		if(this.head == null){
			addFirst(data);
		}else{
			Nodo<T> temp = this.head;
			while(temp.getNext() != null){
				temp = temp.getNext();
			}
			Nodo<T> newNodo = new Nodo<T>(data);
			temp.setNext(newNodo);

			this.lenght++;
		}
	}

	public void deleteFirst(){
		if(this.head == null){
			System.out.println("La lista está vacía");
		}else{
			if(this.lenght>1){
			this.head = this.head.getNext();
			}else{
				this.head = null;
			}
		this.lenght--;
		}
	}
	
	public void deleteLast(){
		if(this.head == null){
			System.out.println("La lista está vacía");
		}else{
			if(this.lenght>1){
			Nodo <T> temp = this.head;
			while(temp.getNext().getNext()!= null){
				temp = temp.getNext();
			}
			temp.setNext(null);
		}else{
			this.head=null;
			}
			this.lenght--;
		}
	}

	public void deleteAt(int index){
		if(this.head == null){
			System.out.println("La lista está vacía");
		}
		else if(index == 0){deleteFirst();}
		else if(index == this.lenght-1){deleteLast();}
		else if(index >0 && index < this.lenght-1){
			Nodo<T> temp = this.head;
			for(int i = 0; i<this.lenght-1; i++){
				if(index == i+1){
					temp.setNext(temp.getNext().getNext());
					this.lenght--;
					break;
				}
				temp = temp.getNext();
			}
		}else{
			System.out.println("Index out of range");
		}
	}
	
	
	
	public void swap(int i, int j){
		if(i >=0 && i<this.lenght && j >=0 && j<this.lenght){
		T temp = getAt(i).getDato();
		setAt(i, getAt(j).getDato());
		setAt(j, temp);
		}
		else{
			System.out.println("Index out of range");
		}
			
	}
	
	
	public Nodo<T> getAt(int index){
		if(this.head == null){
			System.out.println("La lista está vacía");
		}
		else{
			if(index >=0 && index < this.lenght){
				Nodo<T> temp = this.head;
				for(int i=0; i<this.lenght; i++){
					if(index == i){
						return temp;
					}
					temp = temp.getNext();
				}

			}
		}
		return null;
	}
	
	
	public void setAt(int index, T dato){
		if(this.head == null){
			System.out.println("La lista está vacía");
		}
		else{
			if(index >=0 && index < this.lenght){
				Nodo<T> temp =this.head;
				for(int i=0; i<this.lenght; i++){
					if(index == i){
						temp.setDato(dato);
					}
					temp = temp.getNext();
				}
			}
		}
	}
	
	public int getLenght() {
		return lenght;
	}



	public void setLenght(int lenght) {
		this.lenght = lenght;
	}
	
	public Nodo<T> getHead() {
		return head;
	}



	public void setHead(Nodo<T> head) {
		this.head = head;
	}
	




	public void printList(){
		if(this.head==null){System.out.println("Lista Vacía");}
		else{
			Nodo<T> temp = this.head;
			while(temp != null){
				System.out.println(temp.getDato());
				temp = temp.getNext();
			}
				
			}
		}
		
	}


	
	

