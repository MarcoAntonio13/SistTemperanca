package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String rua;
	private int numeroEstabeleciemnto;
	private String bairro;
	private Long cep;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}
	
	public Endereco(String rua, int numeroEstabeleciemnto, String bairro, Long cep) {
		super();
		this.rua = rua;
		this.numeroEstabeleciemnto = numeroEstabeleciemnto;
		this.bairro = bairro;
		this.cep = cep;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumeroEstabeleciemnto() {
		return numeroEstabeleciemnto;
	}

	public void setNumeroEstabeleciemnto(int numeroEstabeleciemnto) {
		this.numeroEstabeleciemnto = numeroEstabeleciemnto;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

}
