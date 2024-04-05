package ListaEncadeada;

import Item.Item;
import No.No;

public class ListaCircular {
	private No<Item> ult;
	private int quant;
	
	public ListaCircular() {}
	
	
	// ACESSAR a quantidade de elementos da lista
		public int getQuant() {
			return quant;
		}

		
		
		// DEVOLVER se a lista está vazia
		public boolean eVazia() {
			return getQuant() == 0;
		}

		// INSERIR um novo elemento no início da lista
		public void inserirInicio(No<Item> no) {
			if (this.eVazia()) {
				this.setUlt(no);
			} else {
				no.setProx(this.getUlt().getProx());
				this.getUlt().setProx(no);
			}
			this.quant++;
		}

		// INSERIR um novo elemento após o último nó da lista
		public void inserirFim(No<Item> no) {
			if (this.eVazia()) {
			this.setUlt(no);
			} else {
				no.setProx(this.getUlt());
				this.setUlt(no);
			}
			this.quant++;
		}

		// PESQUISAR um determinado elemento da lista (pelo código), retornando o
		// elemento ou null se ele não existir.
		public No<Item> pesquisar(int cod) {
			No<Item> aux = this.getUlt();
			while (!aux.equals(this.getUlt())) {
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

		// REMOVER o Primeiro nó da lista. Esse método deve retornar o objeto que foi
		// removido ou null se não conseguir remover
		public No<Item> removerPrimeiro() {
			if (eVazia()) {
				return null;
			} else {
				No<Item> aux = this.getUlt().getProx();
				this.getUlt().setProx(aux.getProx());
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
				No<Item> aux = this.getUlt().getProx();
				No<Item> ult = this.getUlt();
				while (!aux.getProx().equals(ult)) {
					aux = aux.getProx();
				}
				aux.setProx(getUlt().getProx());
				this.setUlt(aux);
				this.quant--;
				return ult;
			}
		}

		// MOSTRAR o conteúdo de todos os elementos da lista
		public String toString() {
			No<Item> aux = this.getUlt().getProx();
			String string = String.format("quant: %s ||", this.getQuant());
			while (!aux.equals(this.getUlt())) {
				string += String.format("[ %s ] =>", aux.getItem().toString());
				aux = aux.getProx();
			}
			string += String.format("[ %s ] =>", aux.getItem().toString());
			return string;
		}

	public No<Item> getUlt() {
		return ult;
	}
	public void setUlt(No<Item> ult) {
		this.ult = ult;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
}
