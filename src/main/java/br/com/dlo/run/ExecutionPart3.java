package br.com.dlo.run;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.dlo.entitys.Aluno;
import br.com.dlo.entitys.Estado;
import br.com.dlo.util.JPAUtil;

public class ExecutionPart3 {

	public static void main(String[] args) throws SQLException {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("part2-DIO");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Integer estado = 1;
		String nome = "Daniel";

		Aluno alunoSQL;

		String sql = "SELECT * FROM ALUNO WHERE nome = :nome";

		alunoSQL = (Aluno) entityManager.createNativeQuery(sql, Aluno.class).setParameter("nome", nome)
				.getSingleResult();

		String sqlList = "SELECT * FROM ALUNO WHERE estado_id= :estado";
		@SuppressWarnings("unchecked")
		List<Aluno> alunosSQLList = entityManager.createNativeQuery(sqlList, Aluno.class).setParameter("estado", estado)
				.getResultList();

		System.out.println("Consulta aluno SQL " + " " + alunoSQL);
		alunosSQLList.forEach(Aluno -> System.out.println("Consulta aluno SQL List" + " ->  " + Aluno));

		String jpql = "select a from Aluno a where a.nome = :estado";

		Aluno alunoJPQL = entityManager.createQuery(jpql, Aluno.class).setParameter("nome", nome).getSingleResult();

		String jpqlList = "Select a from Aluno a";
		List<Aluno> alunoJPQLList = entityManager.createQuery(jpqlList, Aluno.class).getResultList();

		System.out.println("Consulta aluno SQL " + "  " + alunoJPQL);

		alunoJPQLList.forEach(Aluno -> System.out.println("Consulta aluno SQL List" + " ->  " + Aluno));

		String jpqlList2 = "Select a from Aluno a where a.estado.id= :estadoId";

		List<Aluno> alunoJPQLList2 = entityManager.createQuery(jpqlList2, Aluno.class).setParameter("estadoId", 2)
				.getResultList();

		System.out.println(alunoJPQLList2);

		Estado estado3 = JPAUtil.getEntityManager().find(Estado.class, 1);
		String jpqlList3 = "Select a from Aluno a where a.estado= :estado";

		List<Aluno> alunoJPQLList3 = JPAUtil.getEntityManager().createQuery(jpqlList3, Aluno.class)
				.setParameter("estado", estado3).getResultList();

		System.out.println(alunoJPQLList3);

	}

}
