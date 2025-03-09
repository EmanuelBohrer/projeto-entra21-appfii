package com.EquipeMain.AppFii.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TabelaFun {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	private String codigo;
	
	
	private String setor;
	private double preco_atual;
	private float liquidez_diaria;
	private float dividendo;
	private float dy;
	private float dy_3m;
	private float dy_6m;
	private float dy_12m;
	private float dy_ano;
	private float rentab;
	private float variacao_preco;
	private float vpa;
	private float p_vpa;
	private float variacao;
	private float rent_patri;
	private float vacancia;
	private int quantidade;
	
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public double getPreco_atual() {
		return preco_atual;
	}
	public void setPreco_atual(double preco_atual) {
		this.preco_atual = preco_atual;
	}
	public float getLiquidez_diaria() {
		return liquidez_diaria;
	}
	public void setLiquidez_diaria(float liquidez_diaria) {
		this.liquidez_diaria = liquidez_diaria;
	}
	public float getDividendo() {
		return dividendo;
	}
	public void setDividendo(float dividendo) {
		this.dividendo = dividendo;
	}
	public float getDy() {
		return dy;
	}
	public void setDy(float dy) {
		this.dy = dy;
	}
	public float getDy_3m() {
		return dy_3m;
	}
	public void setDy_3m(float dy_3m) {
		this.dy_3m = dy_3m;
	}
	public float getDy_6m() {
		return dy_6m;
	}
	public void setDy_6m(float dy_6m) {
		this.dy_6m = dy_6m;
	}
	public float getDy_12m() {
		return dy_12m;
	}
	public void setDy_12m(float dy_12m) {
		this.dy_12m = dy_12m;
	}
	public float getDy_ano() {
		return dy_ano;
	}
	public void setDy_ano(float dy_ano) {
		this.dy_ano = dy_ano;
	}
	public float getRentab() {
		return rentab;
	}
	public void setRentab(float rentab) {
		this.rentab = rentab;
	}
	public float getVariacao_preco() {
		return variacao_preco;
	}
	public void setVariacao_preco(float variacao_preco) {
		this.variacao_preco = variacao_preco;
	}
	public float getVpa() {
		return vpa;
	}
	public void setVpa(float vpa) {
		this.vpa = vpa;
	}
	public float getP_vpa() {
		return p_vpa;
	}
	public void setP_vpa(float p_vpa) {
		this.p_vpa = p_vpa;
	}
	public float getVariacao() {
		return variacao;
	}
	public void setVariacao(float variacao) {
		this.variacao = variacao;
	}
	public float getRent_patri() {
		return rent_patri;
	}
	public void setRent_patri(float rent_patri) {
		this.rent_patri = rent_patri;
	}
	public float getVacancia() {
		return vacancia;
	}
	public void setVacancia(float vacancia) {
		this.vacancia = vacancia;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
	
	
	
	
	
	

}
