package Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Item.Item;
import ListaEncadeada.ListaEncadeada;
import No.No;

class TestesListaEncadeada {
	
	@Test
	void test() {
		ListaEncadeada lista = new ListaEncadeada();
		assertTrue(lista.eVazia());
		assertNull(lista.getPrim());
		assertNull(lista.getUlt());
		
		System.out.println(lista.toString());
		
		
		Item item0 = new Item(0, "teste");
		Item item1 = new Item(1, "teste");
		Item item2 = new Item(2, "teste");
		Item item3 = new Item(3, "teste");
		
		No<Item> no0 = new No<Item>(item0);
		No<Item> no1 = new No<Item>(item1);
		No<Item> no2 = new No<Item>(item2);
		No<Item> no3 = new No<Item>(item3);
		
		lista.inserirInicio(no0);
		System.out.println(lista.toString());
		
		assertFalse(lista.eVazia());
		assertEquals(no0, lista.getPrim());
		
		lista.inserirFim(no3);
		// System.out.println(lista.toString());
		
		assertEquals(no3, lista.getUlt());
		assertEquals(2, lista.getQuant());
		
		lista.inserirKesimaPosicao(no1, 1);
		// System.out.println(lista.toString());
		
		assertEquals(no1, lista.pesquisar(1));
		assertEquals(3, lista.getQuant());
		
		lista.inserirKesimaPosicao(no2, 2);
		// System.out.println(lista.toString());
		
		assertEquals(no2, lista.pesquisar(2));
		assertEquals(4, lista.getQuant());
		
		assertEquals(no0, lista.removerPrimeiro());
		assertEquals(no3, lista.removerUlt());
		
		
	}

}
