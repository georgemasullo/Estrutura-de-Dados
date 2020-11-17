package AVL;

public class AVL{
	private Boolean h;
	private Node root;
	
	public Node inicio(int key, Node f){
		Node node = new Node(key);
		node.setBal(0);
		return node;
	}
	
	public void inserir(int key){
		this.root = insere(key,this.root,null);		
	}
	public Node insere(int key,Node node, Node fth){
		if(node == null){
			if(this.root == null){
				root = inicio(key,fth);
				h = true;
				return root;
			}else{
				node = inicio(key,fth);
				h = true;
				return node;
			}
		}
		if(key == node.getKey()){
			return node;
		}else if( key < node.getKey()){
			node.setLeft(this.insere(key,node.getLeft(),node));
			int bal = node.getBal();
			if(this.h){
				if(bal == 1){
					node.setBal(0);
					h = false;
				}else if(bal == 0){
					node.setBal(-1);
				}else if(bal == -1){
					node = this.caso1(node);
				}
			}
			return node;
		}else if(key > node.getKey()){
			node.setRight(this.insere(key,node.getRight(),node));
			int bal = node.getBal();
			if(this.h){
				if(bal == -1){
					node.setBal(0);
					h = false;
				}else if(bal == 0){
					node.setBal(1);
				}else if(bal == 1){
					node = this.caso2(node);
				}
			}
			return node;
		}
		
		return this.root;
	}
	
	private Node caso1(Node pt){
		Node ptu = pt.getLeft();
		if(ptu.getBal() == -1){
			pt.setLeft(ptu.getRight());
			ptu.setRight(pt);
			pt.setBal(0);
			pt = ptu;
		}else{
			Node ptv = ptu.getRight();
			ptu.setRight(ptv.getLeft());
			ptv.setLeft(ptu);
			pt.setLeft(ptv.getRight());
			ptv.setRight(pt);
			if(ptv.getBal() == -1){
				pt.setBal(1);
			}else{
				pt.setBal(0);
			}
			if(ptv.getBal() == 1){
				pt.setBal(-1);
			}else{
				ptu.setBal(0);
			}
			pt = ptv;
		}
		this.h = false;
		pt.setBal(0);
		return pt;
	}
	private Node caso2(Node pt){
		Node ptu = pt.getRight();
		if(ptu.getBal() == 1){
			pt.setRight(ptu.getLeft());
			ptu.setLeft(pt);
			pt.setBal(0);
			pt = ptu;
		}else{
			Node ptv = ptu.getLeft();
			ptu.setLeft(ptv.getRight());
			ptv.setRight(ptu);
			pt.setRight(ptv.getLeft());
			ptv.setLeft(pt);
			if(ptv.getBal() == 1){
				pt.setBal(-1);
			}else{
				pt.setBal(0);
			}
			if(ptv.getBal() == -1){
				pt.setBal(1);
			}else{
				ptu.setBal(0);
			}
			pt = ptv;
		}
		this.h= false;
		pt.setBal(0);
		return pt;
	}

	
	public void remover(int chave) {
		h = false;
		root = this.remove(root, chave);
	}

	private Node remove(Node node, int key){
		if(node == null){
			return null;
		}else if (key < node.getKey()){
			node.setLeft(this.remove(node.getLeft(),key));
			if(this.h){
				if(node.getBal() == -1){
					node.setBal(0);
				}else if(node.getBal() == 0){
					node.setBal(1);
					h = false;
				}else if(node.getBal() == 1){
					node = this.caso2(node);
					h = true;
				}
			}
			return node;
		} else if(key > node.getKey()){
			node.setRight(this.remove(node.getRight(),key));
			if(this.h){
				if(node.getBal() == 1){
					node.setBal(0);
				}else if(node.getBal() == 0){
					node.setBal(1);
					h = false;
				}else if(node.getBal() == -1){
					node = this.caso1(node);
					h = true;
				}
			}
			return node;
		}else{
			if (node.getRight() == null) {
				if (node.getLeft() != null) {
					node.getLeft().setFather(node.getFather());
				}
				h = true;
				return node = node.getLeft();
			}
			else if (node.getLeft() == null) {
				if (node.getRight() != null){
					node.getRight().setFather(node.getFather());
				}
				h = true;
				return node = node.getRight();
			}
			else{
				node.setLeft(buscaRemove(node.getLeft(), node));
				if(this.h){
					if(node.getBal() == -1){
						node.setBal(0);
					}else if(node.getBal() == 0){
						node.setBal(1);
						h = false;
					}else if(node.getBal() == 1){
						node = this.caso2(node);
						h = true;
					}
				}
				return node;
			}
		}
	}

	private Node buscaRemove(Node node, Node chave){
		Node noderm;
		int bal;
		if(node.getRight() != null){
			node.setRight(buscaRemove(node.getRight(),chave));
			bal = node.getBal();
			if(this.h){
				if(bal == 1){
					node.setBal(0);
				}else if(bal == 0){
					node.setBal(1);
					h = false;
				}else if(bal == -1){
					node = this.caso1(node);
					h = true;
				}
			}
		} else {
			chave.setKey(node.getKey());
			noderm = node;
			node = node.getLeft();
			if(node != null){
				node.setFather(noderm.getFather());
			}
			h = true;
		}
		return node;
	}
	public void imprimi(){
		this.pos(root,root,"raiz");
	}
	private void pos(Node p,Node pai,String x){
		if(p!=null){
			System.out.println(x+"---"+p.getKey()+"---"+pai.getKey());
		}
		if(p.getLeft()!=null){
			pos(p.getLeft(),p,"esq");
		}
		if(p.getRight()!=null){
			pos(p.getRight(),p,"dir");
		}
	}
}