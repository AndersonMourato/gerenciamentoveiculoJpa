package br.com.concessionaria.dao.impl;

import java.util.List;

import br.com.concessionaria.conexao.Conexao;
import br.com.concessionaria.dao.interfac.IVendaDAO;
import br.com.concessionaria.model.Venda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class VendaDAO implements IVendaDAO{

	static final EntityManager em = Conexao.getConn();
	
	@Override
	public void save(Venda venda) {
		EntityTransaction transction = em.getTransaction();
		try {
			transction.begin();
			em.persist(venda);
			transction.commit();
		} catch (Exception e) {
			if (transction.isActive()) {
				transction.rollback();
			}
			e.printStackTrace();
		}
		
	}

	@Override
	public Venda findByString(String placa) {
		try {
			return em.createNamedQuery("findByVenda", Venda.class).setParameter("placa", placa).getSingleResult();
		} catch (Exception e) {
			 throw new NullPointerException("Venda não localizada!");
		}
	}

	@Override
	public void deleteString(Venda v) {
		EntityTransaction transction = em.getTransaction();
		try {
			transction.begin();
				em.remove(v);
			transction.commit();
		} catch (Exception e) {
			if (transction.isActive()) {
				transction.rollback();
			}
			e.getStackTrace();
		}
		
	}

	@Override
	public List<Venda> findAll(String nome) {
		try {
			return em.createNamedQuery("findByVendaNomeLoja", Venda.class).setParameter("nome", nome).getResultList();
		} catch (Exception e) {

			throw new NullPointerException("Não foi encontrada nenhuam venda na loja");
		}
	}

}
