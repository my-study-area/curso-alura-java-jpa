package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamento {
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setTitular("Leonardo");
		conta.setAgencia(345);
		conta.setNumero(789);
		conta.setSaldo(300.0);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(LocalDate.now());
		movimentacao.setDescricao("churrascaria");
		movimentacao.setValor(BigDecimal.valueOf(200.0));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.persist(movimentacao);
		em.getTransaction().commit();
		
		em.close();
	}
}
