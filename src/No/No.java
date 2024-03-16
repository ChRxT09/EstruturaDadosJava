package No;

public class No<T> {
	private No<T> prox;
	private T item;
	
	
	public No(T item) {
		this.item = item;
	}
	public No<T> getProx() {
		return prox;
	}

	public void setProx(No<T> prox) {
		this.prox = prox;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
	
	public String toString() {
		return item.toString();
	}
}
