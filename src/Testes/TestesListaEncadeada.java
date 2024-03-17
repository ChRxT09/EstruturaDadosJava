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
		
		// System.out.println(lista.toString());
		
		
		Item item0 = new Item(0, "teste");
		Item item1 = new Item(1, "teste");
		Item item2 = new Item(2, "teste");
		Item item3 = new Item(3, "teste");
		
		No<Item> no0 = new No<Item>(item0);
		No<Item> no1 = new No<Item>(item1);
		No<Item> no2 = new No<Item>(item2);
		No<Item> no3 = new No<Item>(item3);
		
		lista.inserirInicio(no0);
		
		assertFalse(lista.eVazia());
		assertEquals(no0, lista.getPrim());
		
		lista.inserirFim(no3);
		
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
		// System.out.println(lista.toString());

		assertEquals(no3, lista.removerUlt());
		// System.out.println(lista.toString());

		assertEquals(no1, lista.getPrim());
		assertEquals(no2, lista.getUlt());

		ListaEncadeada lista2 = new ListaEncadeada();

		No<Item> no4 = new No<Item>(item0);
		No<Item> no5 = new No<Item>(item1);
		No<Item> no6 = new No<Item>(item2);
		No<Item> no7 = new No<Item>(item3);


		lista2.inserirKesimaPosicao(no4, 0);
		lista2.inserirInicio(no5);
		lista2.inserirFim(no6);
		lista2.inserirKesimaPosicao(no7, 2);

		lista.concatenar(lista2);

		assertEquals(6, lista.getQuant());


	}

}
