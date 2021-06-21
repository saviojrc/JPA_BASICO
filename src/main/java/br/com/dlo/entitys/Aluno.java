package br.com.dlo.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, length = 90)
	private String nome;
	@Column(nullable = false)
	private Integer idade;
	@ManyToOne(fetch = FetchType.LAZY)
	private Estado estado;

	public Aluno() {

	}

	public Aluno(Integer id, String nome, Integer idade, Estado estado) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.estado = estado;
	}

	public Aluno(String nome, Integer idade, Estado estado) {
		this.nome = nome;
		this.idade = idade;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Aluno{" + "id=" + id + ", nome='" + nome + '\'' + ", idade=" + idade + ", estado='" + estado + '\''
				+ '}'+"\n";
	}

}
