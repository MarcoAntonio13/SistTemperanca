package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String rua;
	private Integer numeroEstabeleciemnto;
	private String bairro;
	private Long cep;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}
	
	



	public Endereco(Integer id, String rua, Integer numeroEstabeleciemnto, String bairro, Long cep) {
		super();
		this.id = id;
		this.rua = rua;
		this.numeroEstabeleciemnto = numeroEstabeleciemnto;
		this.bairro = bairro;
		this.cep = cep;
	}





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}
	
	

	public Integer getNumeroEstabeleciemnto() {
		return numeroEstabeleciemnto;
	}


	public void setNumeroEstabeleciemnto(Integer numeroEstabeleciemnto) {
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Rua/Av.: "+this.rua+" N�mero: "+ this.numeroEstabeleciemnto+" Bairro: "+ this.bairro +" CEP: "+this.cep;
	}

}
