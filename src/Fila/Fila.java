package Fila;

import Item.Item;

public class Fila {
	private Item[] fila;
	private int quant;
	private int prim = 0;
	private int ult = 0;
	
	public Fila(int tamanho) {
		this.fila = new Item[tamanho];
	}
	
	public Fila() {
		this.fila = new Item[10];
	}
	
	public int getSize() {
		return this.fila.length; 
	}
	
	public int getQuant() {
		return this.quant;
	}
	
	public boolean eCheia() {
		return this.getQuant() == this.getSize();
	}
	
	public boolean eVazia() {
		return this.getQuant() == 0;
	}
	
	public boolean queue(Item item) {
		if(this.eCheia()) {
			return false;
		}
		
		return true;
	}
	
}
