package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String cnpj;
	private String razaoSocial;
	private Long telefone;
	private String email;
	
	@OneToMany
	private List<VendedorFornecedor> vendedores;

	public Fornecedor() {
		// TODO Auto-generated constructor stub
	}

	public Fornecedor(Integer id, String cnpj, String razaoSocial, Long telefone, String email,
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
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
	
	@Override
	public String toString() {
		return this.razaoSocial;
	}

}
