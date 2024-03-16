package Testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Item.Item;
import ListaContigua.ListaContigua;

class TesteListaContigua {
	
	@Test
	void constructorTest() {
		ListaContigua lista = new ListaContigua(3);
		assertTrue(lista.eVazia());
		assertEquals(lista.getTamanho(), 3);
		
		lista = new ListaContigua();
		assertTrue(lista.eVazia());
		assertEquals(lista.getTamanho(), 10);
	}
	
	@Test
	void insertTest() {
		ListaContigua lista = new ListaContigua(2);
		Item item = new Item(1, "Test 1");
		lista.inserirItem(item, 0);
		
		assertEquals(lista.getKesimoItem(0), item);
		
		Item item2 = new Item(1, "Test 2");
		lista.inserirItem(item2 , 0);
		
		assertEquals(lista.getKesimoItem(0), item2);
		assertEquals(lista.getKesimoItem(1), item);
		assertEquals(lista.eCheia(), true);
		
		Item item3 = new Item(3, "Test 3");
		lista.inserirItem(item3, 0);
		assertEquals(lista.getTamanho(), 3);
		assertEquals(lista.getKesimoItem(0), item3);
		assertEquals(lista.getKesimoItem(1), item2);
		assertEquals(lista.getKesimoItem(2), item);
		assertEquals(lista.eCheia(), true);
		
		
		Item item4 = new Item(4, "Test 4");
		Item item5 = new Item(5, "Test 5");
		lista = null;
		lista = new ListaContigua(4);
		lista.inserirItem(item, 0);
		lista.inserirItem(item2 , 1);
		lista.inserirItem(item3, 2);
		lista.inserirFim(item4);
		
		assertTrue(lista.eCheia());
		
		lista.inserirFim(item5);
		
		assertEquals(lista.getQuant(), 5);
		assertEquals(lista.getTamanho(), 6);
		assertTrue(lista.getKesimoItem(3).equals(item4));
		assertTrue(lista.getKesimoItem(4).equals(item5));
	}
	
	@Test
	void searchTest() {
		Item item1 = new Item(1, "Test 1");
		Item item2 = new Item(2, "Test 2");
		Item item3 = new Item(3, "Test 3");
		Item item4 = new Item(4, "Test 4");
		Item item5 = new Item(5, "Test 5");
		
		ListaContigua lista = new ListaContigua(5);
		
		lista.inserirInicio(item5);
		lista.inserirInicio(item4);
		lista.inserirInicio(item3);
		lista.inserirInicio(item2);
		lista.inserirInicio(item1);
				
		assertEquals(lista.pesquisarIndice(1), 0);
		assertEquals(lista.pesquisarIndice(2), 1);
		assertEquals(lista.pesquisarIndice(3), 2);
		assertEquals(lista.pesquisarIndice(4), 3);
		assertEquals(lista.pesquisarIndice(5), 4);
		assertEquals(lista.pesquisarIndice(6), -1);
		
		assertEquals(lista.pesquisar(1), item1);
		assertEquals(lista.pesquisar(2), item2);
		assertEquals(lista.pesquisar(3), item3);
		assertEquals(lista.pesquisar(4), item4);
		assertEquals(lista.pesquisar(5), item5);
		assertEquals(lista.pesquisar(6), null);
	}
}
