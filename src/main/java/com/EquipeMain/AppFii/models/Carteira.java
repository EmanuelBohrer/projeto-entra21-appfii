package com.EquipeMain.AppFii.models;




import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;


//CARTEIRA = EVENTO

@Entity
public class Carteira implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;
	@NotBlank
	private String nomeDaCarteira;
//	@NotBlank
//	private String local;
//	@NotBlank
//	private String data;
//	@NotBlank
//	private String horario;
	
	@OneToMany
	private List<FundosCad> fundosCad;
	
		
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNomeDaCarteira() {
		return nomeDaCarteira;
	}
	public void setNomeDaCarteira(String nomeDaCarteira) {
		this.nomeDaCarteira = nomeDaCarteira;
	}

	
	public List<FundosCad> getFundosCad() {
		return fundosCad;
	}
	public void setFundosCad(List<FundosCad> fundosCad) {
		this.fundosCad = fundosCad;
	}
	

	
}


