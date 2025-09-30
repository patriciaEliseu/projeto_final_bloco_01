package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Produtos;



public interface ProdutoRepository {

	
	public void listarTodos();
	public void cadastrar(Produtos produto);
	public void atualizar(Produtos produto);
	public void procurarPorId(int id);
	public void deletar(int id);
	
}
