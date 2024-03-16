package ListaContigua;
import Item.*;

public class ListaContigua {
	public Item[] lista;
	private int quant = 0;
	
	// Construtor vazio que deve instanciar o vetor com tamanho 10
	public ListaContigua() {
		this.lista = new Item[10];
	}
	// Construtor que recebe o tamanho do vetor e instancia
	public ListaContigua(int tamanho) {
		this.lista = new Item[tamanho];
	}
	
	private Item[] resize() {
		return new Item[(int)(getTamanho() * 1.5)];
	}
	
	private void setLista(Item[] lista) {
		this.lista = lista;
	}
	// Para ACESSAR o tamanho da lista.
	public int getTamanho() {
		return this.lista.length;
	}
	private void setItem(Item item, int k ) {
		this.lista[k] = item;
//		this.quant++;
	}
	// Para ACESSAR a quantidade de elementos da lista
	public int getQuant() {
		return quant;
	}
	// Para DEVOLVER se a lista está vazia
	public boolean eVazia() {
		return this.quant == 0;
	}
	// Para DEVOLVER se a lista está cheia
	public boolean eCheia() {
		return this.quant == getTamanho();
	}
	// Para ACESSAR o k–ésimo elemento da lista, com o objetivo de obter e/ou alterar
	// o dado nele contido. Você deve considerar que essa posição pode não existir.
	public Item getKesimoItem(int k) {
		if(k < getTamanho()) {
			return this.lista[k];
		} else {
			throw new Error("O indice informado é maior que o tamanho da lista");
		}
	}
	// Para INSERIR um novo elemento na k-ésima posição da lista. Nesse caso, todos
	// os elementos, desta posição em diante, devem ser deslocados para a posição
	// seguinte. Se o vetor estiver cheio, aumente o tamanho do vetor em 50%
	public void inserirItem(Item item, int k) {
		if(getKesimoItem(k) == null) {
			setItem(item, k);
		} else if(eCheia()) {
			Item[] lista = resize();
			for(int i = 0; i < k; i++) {
				lista[i] = getKesimoItem(i);
			}
			for(int i = getQuant(); i > k; i--) {
				lista[i] = getKesimoItem(i - 1);
			}
			setLista(lista);
			setItem(item,  k);
		} else {
			for(int i = getQuant(); i > k; i--) {
				setItem(getKesimoItem(i-1), i);
			}
			setItem(item,  k);
		}
		this.quant++;
	}
	// Para INSERIR um novo elemento no início da lista. Nesse caso, todos os
	// elementos devem ser deslocados para a posição seguinte. Se o vetor estiver
	// cheio, aumente o tamanho do vetor em 50%
	public void inserirInicio(Item item) {
		inserirItem(item, 0);
	}
	// Para INSERIR um novo elemento após o último nó da lista. Se o vetor estiver
	// cheio, aumente o tamanho do vetor em 50%
	public void inserirFim(Item item) {
		if(eCheia()) {
			Item[] lista = resize();
			for(int i = 0; i < getTamanho(); i++) {
				lista[i] = getKesimoItem(i);
			}
			setLista(lista);
			inserirFim(item);
		} else {
			this.inserirItem(item,getQuant());
		}
	}
	// Para PESQUISAR um determinado elemento da lista (pelo código), retornando
	// sua posição ou -1 se ele não estiver na lista.
	public int pesquisarIndice(int codigo) {
		for(int i = 0; i < getTamanho(); i++) {
			if(getKesimoItem(i).getCodigo() == codigo) {
				return i;
			}
		}
		return -1;
	}
	// Para PESQUISAR um determinado e	lemento da lista (pelo código), para retornar
	// o dado nele contido ou null caso não exista.
	public Item pesquisar(int codigo) {
		for(int i = 0; i < getTamanho(); i++) {
			Item item = getKesimoItem(i);
			if(item.getCodigo() == codigo) {
				return item;
			}
		}
		return null;
	}
}
