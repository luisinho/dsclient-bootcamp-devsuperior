package com.devsuperior.dsclient.dto;

import java.io.Serializable;
import java.time.Instant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.devsuperior.dsclient.entities.Client;

public class ClientDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "{name.not.blank}")
	private String name;

	@NotBlank(message = "{cpf.not.blank}")
	private String cpf;

	@NotNull(message = "{income.not.blank}")
	private Double income;

	@NotNull(message = "{birthDate.not.blank}")
	private Instant birthDate;

	@NotNull(message = "{children.not.blank}")
	private Integer children;

	public ClientDTO() {

	}

    public ClientDTO(Client entity) {

    	this.id = entity.getId();
		this.name = entity.getName();
		this.cpf =  entity.getCpf();
		this.income = entity.getIncome();
		this.birthDate = entity.getBirthDate();
		this.children = entity.getChildren();

	}

	public ClientDTO(Long id, String name, String cpf, Double income, Instant birthDate, Integer children) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Instant getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}
}
