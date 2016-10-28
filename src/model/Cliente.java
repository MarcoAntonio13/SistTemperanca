package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Long cnpj;
	
	@OneToMany(fetch=FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.REMOVE, CascadeType.MERGE})
	private List<Endereco> enderecos;
	
	@OneToMany(mappedBy="cliente")
	@Cascade(CascadeType.REMOVE)
	private List<Venda> vendas;
	
	private String razaoSocial;
	private Long telefone;
	private String email;
	
	public Cliente() {

	}

	public Cliente(Long cnpj, List<Endereco> enderecos, String razaoSocial, Long telefone, String email) {
		super();
		this.cnpj = cnpj;
		this.enderecos = enderecos;
		this.razaoSocial = razaoSocial;
		this.telefone = telefone;
		this.email = email;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}


	public List<Endereco> getEnderecos() {
		return enderecos;
	}


	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.razaoSocial;
	}
	
	

}
