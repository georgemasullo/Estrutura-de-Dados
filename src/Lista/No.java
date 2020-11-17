package Lista;

public class No<tipo> {
	private tipo item;
	private int pri;

	
	public No(int pri) {
		this.pri=pri;
	}

	public No() {
		// TODO Auto-generated constructor stub
	}

	public tipo getItem() {
		return this.item;
	}

	public void setItem(tipo item) {
		this.item = item;
	}

	public int getPri() {
		return pri;
	}

	public void setPri(int pri) {
		this.pri = pri;
	}
	public boolean equals(Object item) {
		if(item instanceof No){
			No aux=(No) item;
			if(aux.item==this.item && aux.pri==this.pri){
				return true;
			}
			return false;
		}
		return true;
	}
}
