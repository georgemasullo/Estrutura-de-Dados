package AVL;

public class Node{
	private int key;
	private Node left;
	private Node right;
	private Node father;
	private int altura = 0;
	private int bal;
	
	public Node getFather() {
		return father;
	}
	public void setFather(Node father) {
		this.father = father;
	}
	public Node(int key,int altura){
		this.key = key;
		this.left = null;
		this.right = null;
		this.altura = altura;
		
	}
	public Node(int key,int altura, Node node){
		this.key = key;
		this.left = null;
		this.right = null;
		this.altura = altura;
		this.father = node;
	}
	public Node(int key){
		this.key = key;
		this.left = null;
		this.right = null;
		this.altura++;
	}
	public Node(int key, Node node){
		this.key = key;
		this.left = null;
		this.right = null;
		this.altura++;
		this.father = node;
	}
	public Node(int key, Node left, Node right){
		this.key = key;
		this.left = left;
		this.right = right;
		
	}
	public void setAltura(int value){
		this.altura = value;
	}
	public void setLeft(Node node){
		this.left = node;
	}
	public void setRight(Node node){
		this.right = node;
	}
	public void setKey(int key){
		this.key = key;
	}
	public Node getLeft(){
		return this.left;
	}
	public Node getRight(){
		return this.right;
	}
	public int getKey(){
		return this.key;
	}
	public int getAltura(){
		return this.altura;
	}
	public void visita(){
		System.out.println("Chave: "+this.key+"  Bal: "+this.bal);
	}
	
	public int getBal() {
		return bal;
	}
	public void setBal(int bal) {
		this.bal = bal;
	}
}