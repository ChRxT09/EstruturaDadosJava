package ListaEncadeada;

import Item.Item;
import No.No;

public class ListaEncadeada {
	private No<Item> prim;
	private No<Item> ult;
	private int quant = 0;

	// ACESSAR a quantidade de elementos da lista
	public int getQuant() {
		return quant;
	}

	// DEVOLVER se a lista está vazia
	public boolean eVazia() {
		return getQuant() == 0;
	}

	// INSERIR um novo elemento na k-ésima posição da lista
	public void inserirKesimaPosicao(No<Item> no, int k) {
		if (k > this.getQuant()) {
			throw new Error("O índice informado é inacessível");
		}
		if (k == 0) {
			this.inserirInicio(no);
		} else if (k == this.getQuant()) {
			this.inserirFim(no);
		} else {
			No<Item> aux = this.getPrim();
			for (int i = 0; i < k - 1; i++) {
				aux = aux.getProx();
			}
			no.setProx(aux.getProx());
			aux.setProx(no);
			this.quant++;
		}
	}

	// INSERIR um novo elemento no início da lista
	public void inserirInicio(No<Item> no) {
		if (this.eVazia()) {
			this.setPrim(no);
			this.setUlt(no);
		} else {
			no.setProx(this.getPrim());
			this.setPrim(no);
		}
		this.quant++;
	}

	// INSERIR um novo elemento após o último nó da lista
	public void inserirFim(No<Item> no) {
		if (this.eVazia()) {
			this.inserirInicio(no);
			this.setUlt(no);
		} else {
			this.getUlt().setProx(no);
			this.setUlt(no);
		}
		this.quant++;
	}

	// PESQUISAR um determinado elemento da lista (pelo código), retornando o
	// elemento ou null se ele não existir.
	public No<Item> pesquisar(int cod) {
		No<Item> aux = this.getPrim();
		while (aux != null) {
			if (aux.getItem().getCodigo() == cod) {
				return aux;
			} else {
				aux = aux.getProx();
			}
		}
		return aux;
	}

	// REMOVER um determinado nó da lista. Esse método deve retornar o objeto
	// que foi removido ou null se não conseguir remover
	public No<Item> removerNo() {

		return null;
	}

	// REMOVER o k-ésimo nó da lista. Esse método deve retornar o objeto que foi
	// removido ou null se não conseguir remover
	public No<Item> removerKesimo(int k) {
		if (k > this.getQuant()) {
			throw new Error("O índice informado é inacessível");
		}
		No<Item> antAux = this.pesquisarKesimo(k - 1);
		No<Item> aux = antAux.getProx();
		antAux.setProx(aux.getProx());
		return aux;
	}

	// REMOVER o Primeiro nó da lista. Esse método deve retornar o objeto que foi
	// removido ou null se não conseguir remover
	public No<Item> removerPrimeiro() {
		if (eVazia()) {
			return null;
		} else {
			No<Item> aux = this.getPrim();
			this.setPrim(aux.getProx());
			this.quant--;
			return aux;
		}
	}

	// REMOVER o último nó da lista. Esse método deve retornar o objeto que foi
	// removido ou null se não conseguir remover
	public No<Item> removerUlt() {
		if (eVazia()) {
			return null;
		} else {
			No<Item> aux = this.getPrim();
			No<Item> ult = this.getUlt();
			while (!aux.getProx().equals(ult)) {
				aux = aux.getProx();
			}
			aux.setProx(null);
			this.setUlt(aux);
			this.quant--;
			return ult;
		}
	}

	// CONCATENAR duas listas. A segunda lista será colocada após o último
	// elemento da primeira
	public void concatenar(ListaEncadeada lista) {
		No<Item> aux = this.getUlt();
		aux.setProx(lista.getPrim());
		this.setUlt(lista.getUlt());
		this.quant = this.getQuant() + lista.getQuant();
	}

	// MOSTRAR o conteúdo de todos os elementos da lista
	public String toString() {
		No<Item> aux = this.getPrim();
		String string = String.format("quant: %s ||", this.getQuant());
		while (aux != null) {
			string += String.format("[ %s ] =>", aux.getItem().toString());
			aux = aux.getProx();
		}
		string += "[ NULL ]";
		return string;
	}

	private No<Item> pesquisarKesimo(int k) {
		No<Item> aux = this.getPrim();
		int i = 0;
		while (i < k) {
			aux = aux.getProx();
			i++;
		}
		return aux;
	}

	public No<Item> getPrim() {
		return prim;
	}

	public void setPrim(No<Item> prim) {
		this.prim = prim;
	}

	public No<Item> getUlt() {
		return ult;
	}

	public void setUlt(No<Item> ult) {
		this.ult = ult;
	}
}
