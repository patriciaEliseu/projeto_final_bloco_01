package projeto_final_bloco_01.model;

public class Bijuteria extends Produtos {
	
	private String genero;
	
	public Bijuteria(int id, int tipo, String descricao, String artesao, float preco, String genero) {
		super(id, tipo, descricao, artesao, preco);
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void visualizarGenero() {
		super.visualizarTipo();
		System.out.printf("Nome do Gênero: %s\n", this.genero);
	}
	
}
