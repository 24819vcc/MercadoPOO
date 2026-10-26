package controleEstoque;

import produtos.Produto;

public class teste {

	public static void main(String[] args) {
		Estoque es= new Estoque();
		
		Produto arroz = new Produto("Arroz","231",12,4);
		
		
		
		es.adicionarEstoque(arroz);
		es.removerEstoque("231");
		System.out.println(es.buscarProdutoPorNome("arroz"));
	}

}
