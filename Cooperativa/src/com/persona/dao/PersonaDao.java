package com.persona.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.empresa.entities.Beneficiario;
import com.empresa.entities.Persona;
import com.empresa.entities.Referencia;

public class PersonaDao {

	public Persona insertPersona(Persona per) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cooperativa"); 
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(per);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally {
			em.close();
			emf.close();
		}
		return per;
	}
	
	public String insertReferencias(List<Referencia> refs) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cooperativa"); 
		EntityManager em = emf.createEntityManager();
		String respuesta = "";
		try {
			em.getTransaction().begin();
			for(Referencia ref:refs) {
				em.persist(ref);				
			}
			em.getTransaction().commit();
			respuesta = "exito";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuesta;
	}
	
	public String insertBeneficiarios(List<Beneficiario> bens) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cooperativa"); 
		EntityManager em = emf.createEntityManager();
		String respuesta = "";
		try {
			em.getTransaction().begin();
			for(Beneficiario ben:bens) {
				em.persist(ben);				
			}
			em.getTransaction().commit();
			respuesta = "exito";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuesta;
	}
	
}
