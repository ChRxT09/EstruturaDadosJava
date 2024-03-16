package Item;

public class Item {
	private int codigo;
	private String nome;
	
	public Item(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String toString() {
		return String.format("{codigo: %1$2s, nome: %2$2s}", this.codigo, this.nome.toString());
	}
}
