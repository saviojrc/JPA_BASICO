package br.com.dlo.entitys;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estado {

	public Estado() {

	}

	public Estado(Integer id, String nome, String sigla) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;

	}

	public Estado(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String sigla;

	@OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, orphanRemoval = true)

	private List<Aluno> alunos = new ArrayList<Aluno>();

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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	@Override
	public String toString() {
		return "Estado{" + "id=" + id + ", nome='" + nome + '\'' + ", sigla=" +"'"+ sigla +"'"+ '}';
	}

}
