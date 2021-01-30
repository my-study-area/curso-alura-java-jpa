package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TesteRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {

		Categoria categooria1 = new Categoria("Viagem");
		Categoria categooria2 = new Categoria("Negócios");
		
        Conta conta = new Conta();
        conta.setId(2L);
		
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setDescricao("Viagem à SP");
		movimentacao1.setData(LocalDate.now());
		movimentacao1.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao1.setValor(BigDecimal.valueOf(300.00));
		movimentacao1.setCategorias(Arrays.asList(categooria1, categooria2));
		movimentacao1.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setDescricao("Viagem à RJ");
		movimentacao2.setData(LocalDate.now());
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao2.setValor(BigDecimal.valueOf(300.00));
		movimentacao2.setCategorias(Arrays.asList(categooria1, categooria2));
		movimentacao2.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(categooria1);
		em.persist(categooria2);
		em.persist(movimentacao1);
		em.persist(movimentacao2);
		em.getTransaction().commit();
		em.close();
		
	}

}
