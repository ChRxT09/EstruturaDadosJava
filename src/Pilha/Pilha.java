package Pilha;

import Item.Item;

public class Pilha {
	private int quant = 0;
	private Item[] pilha;
	
	public Pilha(int tamanho) {
		this.pilha = new Item[tamanho];
	}
	
	public Pilha() {
		this.pilha = new Item[10];	
	}

	public int getQuant() {
		return quant;
	}
	
	public int getSize() {
		return this.pilha.length;
	}
	public boolean eCheia() {
		return this.getQuant() == this.getSize();
	}
	
	public boolean eVazia() {
		return this.getQuant() == 0;
	}
	
	public boolean empilhar(Item item) {
		if(this.eCheia()) {
			return false;
		}
		this.pilha[this.quant++] = item;
		return true;
	}
	
	public Item desempilhar() {
		if(this.eVazia()) {
			return null;
		}
		Item item = this.pilha[this.quant--];
		return item;
	}
}
