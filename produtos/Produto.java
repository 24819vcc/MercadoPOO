package produtos;

public class Produto {
	private String nome;
	private String codigo;
	private double preco;
	private int qtdEstoque;
	
	public Produto(String nome,String codigo,double preco,int qtd) {
		this.nome=nome;
		this.codigo=codigo;
		this.preco=preco;
		this.qtdEstoque=qtd;
	}

	//gets
	public String getNome() {
		return nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public double getPreco() {
		return preco;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}
	
	//sets
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public void setPreco(double preco) {
		this.preco=preco;
	}
	public void adicionarEstoque(int n) {
		qtdEstoque+=n;
	}

}
