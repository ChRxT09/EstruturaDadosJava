package ListaDuEncadeada;

public class ListaDuEncadeada<N> {
	private NoItem<N> prim, ult;
	private int quant = 0;
	
	public ListaDuEncadeada(NoItem<N> prim, NoItem<N> ult, int quant) {
		this.prim = prim;
		this.ult = ult;
		this.quant = quant;
	}

	// ACESSAR a quantidade de elementos da lista
	public int getQuant() {
		return quant;
	}

	// DEVOLVER se a lista est� vazia
	public boolean eVazia() {
		return getQuant() == 0;
	}

	// INSERIR um novo elemento na k-�sima posi��o da lista
	public void inserirKesimaPosicao(NoItem<N> no, int k) {
		if (k > this.getQuant()) {
			throw new Error("O �ndice informado � inacess�vel");
		}
		NoItem<N> aux;
		if (k < this.getQuant()/2) {
			aux = this.getPrim();
			for (int i = 0; i < k-1; i++) {
				aux = aux.getProx();
			}
		} else {
			aux = this.getUlt();
			for (int i = this.getQuant(); i >= k-1; i--) {
				aux = aux.getAnt();
			}
		}
		no.setProx(aux.getProx());
		no.setAnt(aux);
		aux.setProx(no);
		no.getProx().setAnt(no);
		this.quant++;
		}
	
	// INSERIR um novo elemento no in�cio da lista
	public void inserirInicio(NoItem<N> no) {
		if (this.eVazia()) {
			this.setUlt(no);
		} else {
			no.setProx(this.getPrim());
			this.prim.setAnt(no);	
		}
		this.setPrim(no);
		this.quant++;
	}

	// INSERIR um novo elemento ap�s o �ltimo n� da lista
	public void inserirFim(NoItem<N> no) {
		if (this.eVazia()) {
			this.inserirInicio(no);
		} else {
			this.getUlt().setProx(no);
			no.setAnt(this.getUlt());
		}
		this.setUlt(no);
		this.quant++;
	}

	// PESQUISAR um determinado elemento da lista (pelo c�digo), retornando o
	// elemento ou null se ele n�o existir.
	/*public NoItem<N> pesquisar(int cod) {
		NoItem<N> aux = this.getPrim();
		while (aux != null) {
			if (aux.getItem().getCodigo() == cod) {
				return aux;
			} else {
				aux = aux.getProx();
			}
		}
		return aux;
	}*/

	// REMOVER o k-�simo n� da lista. Esse m�todo deve retornar o objeto que foi
	// removido ou null se n�o conseguir remover
	public NoItem<N> removerKesimo(int k) {
		if (eVazia()) {
			return null;
		}
		NoItem<N> aux;
		if (k < this.getQuant()/2) {
			aux = this.getPrim();
			for (int i = 0; i < k-1; i++) {
				aux = aux.getProx();
			}
		} else {
			aux = this.getUlt();
			for (int i = this.getQuant(); i >= k-1; i--) {
				aux = aux.getAnt();
			}	
		}
		aux.getAnt().setProx(aux.getProx());
		aux.getProx().setAnt(aux.getAnt());
		this.quant--;
		return aux;
	}

	// REMOVER o Primeiro n� da lista. Esse m�todo deve retornar o objeto que foi
	// removido ou null se n�o conseguir remover
	public NoItem<N> removerPrimeiro() {
		if (eVazia()) {
			return null;
		} else {
			NoItem<N> aux = this.getPrim();
			this.setPrim(aux.getProx());
			this.getPrim().setAnt(null);
			this.quant--;
			return aux;
		}
	}

	// REMOVER o �ltimo n� da lista. Esse m�todo deve retornar o objeto que foi
	// removido ou null se n�o conseguir remover
	public NoItem<N> removerUlt() {
		if (eVazia()) {
			return null;
		} else {
			NoItem<N> aux = this.getUlt();
			this.setUlt(aux.getAnt());
			this.getUlt().setProx(null);
			this.quant--;
			return aux;
		}
	}

	// CONCATENAR duas listas. A segunda lista ser� colocada ap�s o �ltimo
	// elemento da primeira
	public void concatenar(ListaDuEncadeada lista) {
		NoItem<N> aux = this.getUlt();
		aux.setProx(lista.getPrim());
		lista.getPrim().setAnt(aux);
		this.setUlt(lista.getUlt());
		this.quant = this.getQuant() + lista.getQuant();
	}

	// MOSTRAR o conte�do de todos os elementos da lista
	public String toString() {
		NoItem<N> aux = this.getPrim();
		String string = String.format("quant: %s ||", this.getQuant());
		while (aux != null) {
			string += String.format("[ %s ] =>", aux.getInfo().toString());
			aux = aux.getProx();
		}
		string += "[ NULL ]";
		return string;
	}

	public NoItem<N> getPrim() {
		return prim;
	}

	public void setPrim(NoItem<N> prim) {
		this.prim = prim;
	}

	public NoItem<N> getUlt() {
		return ult;
	}

	public void setUlt(NoItem<N> ult) {
		this.ult = ult;
	}
	
}
