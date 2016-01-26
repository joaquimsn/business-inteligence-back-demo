package br.com.undefined.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Campanha implements Serializable {
	private static final long serialVersionUID = -226535293720997217L;
	
	private int idCampanha;
	private String nome;
	private Date inicio;
	private int duracao;
	
	public int getIdCampanha() {
		return idCampanha;
	}
	public void setIdCampanha(int idCampanha) {
		this.idCampanha = idCampanha;
	}
	public String getNome() {
		return nome;
	}
	public Date getInicio() {
		return inicio;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
}
