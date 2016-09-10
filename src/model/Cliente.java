package model;

public class Cliente {

	private Integer id;
	private Long cnpj;
	private Integer numeroEstabelecimento;
	private Integer cep;
	private String bairro;
	private String rua;
	private String razaoSocial;

	public Cliente() {

	}

	public Cliente(Integer id, Long cnpj, Integer numeroEstabelecimento, Integer cep, String bairro, String rua,
			String razaoSocial) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.numeroEstabelecimento = numeroEstabelecimento;
		this.cep = cep;
		this.bairro = bairro;
		this.rua = rua;
		this.razaoSocial = razaoSocial;
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

	public Integer getNumeroEstabelecimento() {
		return numeroEstabelecimento;
	}

	public void setNumeroEstabelecimento(Integer numeroEstabelecimento) {
		this.numeroEstabelecimento = numeroEstabelecimento;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

}
