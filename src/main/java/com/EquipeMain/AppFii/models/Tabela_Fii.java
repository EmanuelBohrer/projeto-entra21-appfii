package com.EquipeMain.AppFii.models;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity


public class Tabela_Fii {
	
	
	
	
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private String CODIGO;
	private String SETOR;
	private double PRECO_ATUAL;
	private float LIQUIDEZ_DIARIA;
	private float DIVIDENDO;
	private float DY;
	private float DY_3M;
	private float DY_6M;
	private float DY_12M;
	private float DY_3M_PLUS;
	private float DY_6M_PLUS;
	private float DY_12M_PLUS;
	private float DY_ANO;
	private float VARIACAO_PRECO;
	private float RENTAB;
	private float RENTAB_PLUS;
	private float PATRIMONIO;
	private float VPA;
	private float P_VPA;
	private float DY_PLUS;
	private float VARIACAO;
	private float RENTAB_PATRIMONIO;
	private float RENTAB_PATRIMONIO_PLUS;
	private float VACANCIA;
	private float VACANCIA_PLUS;
	private int QUANTIDADE;
	
	

	public String getCODIGO() {
		return CODIGO;
	}

	public void setCODIGO(String CODIGO) {
		this.CODIGO = CODIGO;
	}
	
	public String getSETOR() {
		return SETOR;
	}

	public void setSETOR(String SETOR) {
		this.SETOR = SETOR;
	}

	public double getPRECO_ATUAL() {
		return PRECO_ATUAL;
	}

	public void setPRECO_ATUAL(double PRECO_ATUAL) {
		this.PRECO_ATUAL = PRECO_ATUAL;
	}

	public float getLIQUIDEZ_DIARIA() {
		return LIQUIDEZ_DIARIA;
	}

	public void setLIQUIDEZ_DIARIA(float LIQUIDEZ_DIARIA) {
		this.LIQUIDEZ_DIARIA = LIQUIDEZ_DIARIA;
	}

	public float getDIVIDENDO() {
		return DIVIDENDO;
	}

	public void setDIVIDENDO(float DIVIDENDO) {
		this.DIVIDENDO = DIVIDENDO;
	}

	public float getDY() {
		return DY;
	}

	public void setDY(float DY) {
		this.DY = DY;
	}

	public float getDY_3M() {
		return DY_3M;
	}

	public void setDY_3M(float DY_3M) {
		this.DY_3M = DY_3M;
	}

	public float getDY_6M() {
		return DY_6M;
	}

	public void setDY_6M(float DY_6M) {
		this.DY_6M = DY_6M;
	}

	public float getDY_12M() {
		return DY_12M;
	}

	public void setDY_12M(float DY_12M) {
		this.DY_12M = DY_12M;
	}

	public float getDY_3M_PLUS() {
		return DY_3M_PLUS;
	}

	public void setDY_3M_PLUS(float DY_3M_PLUS) {
		this.DY_3M_PLUS = DY_3M_PLUS;
	}

	public float getDY_6M_PLUS() {
		return DY_6M_PLUS;
	}

	public void setDY_6M_PLUS(float DY_6M_PLUS) {
		this.DY_6M_PLUS = DY_6M_PLUS;
	}

	public float getDY_12M_PLUS() {
		return DY_12M_PLUS;
	}

	public void setDY_12M_PLUS(float DY_12M_PLUS) {
		this.DY_12M_PLUS = DY_12M_PLUS;
	}

	public float getDY_ANO() {
		return DY_ANO;
	}

	public void setDY_ANO(float DY_ANO) {
		this.DY_ANO = DY_ANO;
	}

	public float getVARIACAO_PRECO() {
		return VARIACAO_PRECO;
	}

	public void setVARIACAO_PRECO(float VARIACAO_PRECO) {
		this.VARIACAO_PRECO = VARIACAO_PRECO;
	}

	public float getRENTAB() {
		return RENTAB;
	}

	public void setRENTAB(float RENTAB) {
		this.RENTAB = RENTAB;
	}

	public float getRENTAB_PLUS() {
		return RENTAB_PLUS;
	}

	public void setRENTAB_PLUS(float RENTAB_PLUS) {
		this.RENTAB_PLUS = RENTAB_PLUS;
	}

	public float getPATRIMONIO() {
		return PATRIMONIO;
	}

	public void setPATRIMONIO(float PATRIMONIO) {
		this.PATRIMONIO = PATRIMONIO;
	}

	public float getVPA() {
		return VPA;
	}

	public void setVPA(float VPA) {
		this.VPA = VPA;
	}

	public float getP_VPA() {
		return P_VPA;
	}

	public void setP_VPA(float P_VPA) {
		this.P_VPA = P_VPA;
	}

	public float getDY_PLUS() {
		return DY_PLUS;
	}

	public void setDY_PLUS(float DY_PLUS) {
		this.DY_PLUS = DY_PLUS;
	}

	public float getVARIACAO() {
		return VARIACAO;
	}

	public void setVARIACAO(float VARIACAO) {
		this.VARIACAO = VARIACAO;
	}

	public float getRENTAB_PATRIMONIO() {
		return RENTAB_PATRIMONIO;
	}

	public void setRENTAB_PATRIMONIO(float RENTAB_PATRIMONIO) {
		this.RENTAB_PATRIMONIO = RENTAB_PATRIMONIO;
	}

	public float getRENTAB_PATRIMONIO_PLUS() {
		return RENTAB_PATRIMONIO_PLUS;
	}

	public void setRENTAB_PATRIMONIO_PLUS(float RENTAB_PATRIMONIO_PLUS) {
		this.RENTAB_PATRIMONIO_PLUS = RENTAB_PATRIMONIO_PLUS;
	}

	public float getVACANCIA() {
		return VACANCIA;
	}

	public void setVACANCIA(float VACANCIA) {
		this.VACANCIA = VACANCIA;
	}

	public float getVACANCIA_PLUS() {
		return VACANCIA_PLUS;
	}

	public void setVACANCIA_PLUS(float VACANCIA_PLUS) {
		this.VACANCIA_PLUS = VACANCIA_PLUS;
	}

	public int getQUANTIDADE() {
		return QUANTIDADE;
	}

	public void setQUANTIDADE(int QUANTIDADE) {
		this.QUANTIDADE = QUANTIDADE;
	}

	public Tabela_Fii() {
		super();
	}

}