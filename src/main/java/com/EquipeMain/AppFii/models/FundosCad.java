package com.EquipeMain.AppFii.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class FundosCad {
	
	@Id
	@NotEmpty
	private String idCodigo;
	@NotBlank
	private String cotas;
	
	private double proventos;
	
	private double cotacao;
	
	private double rentabilidade;
	
	private String setor;
	
	private double investido;

	public String getIdCodigo() {
		return idCodigo;
	}

	public void setIdCodigo(String idCodigo) {
		this.idCodigo = idCodigo;
	}

	public String getCotas() {
		return cotas;
	}

	public void setCotas(String cotas) {
		this.cotas = cotas;
	}

	public double getProventos() {
		return proventos;
	}

	public void setProventos(double proventos) {
		this.proventos = proventos;
	}

	public double getCotacao() {
		return cotacao;
	}

	public void setCotacao(double cotacao) {
		this.cotacao = cotacao;
	}

	public double getRentabilidade() {
		return rentabilidade;
	}

	public void setRentabilidade(double rentabilidade) {
		this.rentabilidade = rentabilidade;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public double getInvestido() {
		return investido;
	}

	public void setInvestido(double investido) {
		this.investido = investido;
	}
	
	@ManyToOne
	private Carteira carteira;
	
	
	
	
	

}
