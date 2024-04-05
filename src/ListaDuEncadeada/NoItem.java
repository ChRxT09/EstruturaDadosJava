package ListaDuEncadeada;

public class NoItem<N> {
	private N info;
	private NoItem<N> prox, ant;
	
	
	
	public NoItem(N info) {
		this.info = info;
	}
	
	public NoItem(N info, NoItem<N> prox, NoItem<N> ant) {
		this.info = info;
		this.prox = prox;
		this.ant = ant;
		
	}
	public N getInfo() {
		return info;
	}
	public void setInfo(N info) {
		this.info = info;
	}
	public NoItem<N> getProx() {
		return prox;
	}
	public void setProx(NoItem<N> prox) {
		this.prox = prox;
	}
	public NoItem<N> getAnt() {
		return ant;
	}
	public void setAnt(NoItem<N> ant) {
		this.ant = ant;
	}

	@Override
	public String toString() {
		return "NoItem [info=" + info + ", prox=" + prox + ", ant=" + ant + "]";
	}
	
}
