package model;

public class VendedorFornecedor {
	private Integer id;
	private Long telefone;
	private String nome;
	private String email;

	public VendedorFornecedor() {
		// TODO Auto-generated constructor stub
	}
	


	public VendedorFornecedor(Integer id, Long telefone, String nome, String email) {
		super();
		this.id = id;
		this.telefone = telefone;
		this.nome = nome;
		this.email = email;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public Long getTelefone() {
		return telefone;
	}



	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
