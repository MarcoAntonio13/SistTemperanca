package model;

import java.util.List;

public class Fornecedor {
	private Integer id;
	private Integer cnpj;
	private String razaoSocial;
	private String telefone;
	private String email;
	private List<VendedorFornecedor> vendedores;

	public Fornecedor() {
		// TODO Auto-generated constructor stub
	}

	public Fornecedor(Integer id, Integer cnpj, String razaoSocial, String telefone, String email,
			List<VendedorFornecedor> vendedores) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.telefone = telefone;
		this.email = email;
		this.vendedores = vendedores;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCnpj() {
		return cnpj;
	}

	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<VendedorFornecedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(List<VendedorFornecedor> vendedores) {
		this.vendedores = vendedores;
	}

}
