package projeto_final_bloco_01.model;

public class Produtos {

	private int id;
	private int tipo; 
	private String descricao;
	private String artesao;
	private float preco;
	
	public Produtos(int id, int tipo, String descricao, String artesao, float preco) {
		this.id = id;
		this.tipo = tipo;
		this.descricao = descricao;
		this.artesao = artesao;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getArtesao() {
		return artesao;
	}

	public void setArtesao(String artesao) {
		this.artesao = artesao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	
	public void visualizar() {
		
		String tipo = " ";
		switch(this.tipo) {
		case 1 -> tipo = "Decoração";
		case 2 -> tipo = "Bijuteria";
		default -> tipo = "Inválido";
		}
		
		System.out.println("\n********************************************");
		System.out.println("Dados do Produto");
		System.out.println("********************************************");
		System.out.printf("Id do Produto: %d%n", this.id);
		System.out.printf("Tipo de Produto: %s%n", tipo);
		System.out.printf("Descrição do Produto: %s%n", this.descricao);
		System.out.printf("Artesão: %s%n", this.artesao);
		System.out.printf("Valor do Produto: R$ %.2f%n", this.preco);
	}
	
	
}
