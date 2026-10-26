package controleEstoque;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer; 
import java.util.ArrayList;
import produtos.Produto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class Estoque {
	private ArrayList<Produto> produtos;

	public Estoque() {
		this.produtos = new ArrayList<>();
		carregarJson();
	}

	public void adicionarEstoque(Produto produto) {
		Produto produtoExiste=buscarProdutoPorNome(produto.getNome());

		if(produtoExiste!=null) {
			produtoExiste.adicionarEstoque(produto.getQtdEstoque());
		}else {
			produtos.add(produto);
		}salvarJson();
	}

	public void removerEstoque(String codigo){
		Produto produtoExiste=buscarPorCodigo(codigo);
			if(produtoExiste!=null) {
				produtos.remove(produtoExiste);
				salvarJson();
				}else {
					System.out.println(1);
				}
	}

	public Produto buscarPorCodigo(String codigo) {
		for(Produto produto : produtos) {
			if(produto.getCodigo().equals(codigo)) {
				return produto;
			}
		}
		return null;
	}

	public Produto buscarProdutoPorNome(String nome) {
		for (Produto produto : produtos) {
			if (produto.getNome().equalsIgnoreCase(nome)) {
				return produto;
			}
		}

		return null;
	}

	private void salvarJson() {
		Gson gson = new Gson();

		try(FileWriter writer = new FileWriter("src/estoque.json")){
			gson.toJson(produtos, writer);
		}catch (IOException e) {
			System.out.println("Erro ao salvar produtos.");
		}
	}

	private void carregarJson() {
		Gson gson = new Gson();
		try(FileReader reader= new FileReader("src/estoque.json")){
			Produto[] produtos = gson.fromJson(reader, Produto[].class);

			if(produtos!=null) {
				for(Produto produto: produtos) {
					this.produtos.add(produto);
				}
			}

		}catch (IOException e) {
			System.out.println("Erro ao carregar produtos.");
		}
	}
}
