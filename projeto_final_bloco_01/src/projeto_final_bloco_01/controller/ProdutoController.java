package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.List;

import projeto_final_bloco_01.model.Produtos;
import projeto_final_bloco_01.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

	private List<Produtos> listaProdutos = new ArrayList<Produtos>();
	int id = 0;

	@Override
	public void listarTodos() {
		for (var produto : listaProdutos) {
			produto.visualizar();
		}

	}

	@Override
	public void cadastrar(Produtos produto) {
		listaProdutos.add(produto);
		System.out.println("\nConta cadastrada com sucesso!");

	}

	@Override
	public void atualizar(Produtos produto) {
		
		var buscarProduto = buscarNaCollection(id);
		
		if(buscarProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscarProduto), produto);
			System.out.printf("\nO Produto id: %d foi atualizado com sucesso!%n", produto.getId());
		}else {
			System.out.printf("\nO produto id: %d não foi encontrado!%n", produto.getId());
		}		
		
	}

	@Override
	public void procurarPorId(int id) {
		
		var produto = buscarNaCollection(id);
		
		if(produto != null) {
			produto.visualizar();
		} else {
			System.out.printf("\nO produto id %d não foi encontrado!%n ", id);
		}

	}

	@Override
	public void deletar(int id) {
		var produto = buscarNaCollection(id);
		
		if(produto != null) {
			if (listaProdutos.remove(produto) == true) {
				System.out.printf("\nO produto id %d foi deletado com sucesso!%n ", id);
			}
			
		}else {
			System.out.printf("\nO produto id %d não foi encontrado!%n ", id);
		}

	}

	
	
	
	
	public int gerarId() {
		return ++id;
	}
	
	public Produtos buscarNaCollection(int id) {
		for(var produto : listaProdutos) {
			if(produto.getId() == id) {
				return produto;
			}
		}
		
		return null;
	}

}
