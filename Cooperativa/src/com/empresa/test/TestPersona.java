package com.empresa.test;

import java.util.ArrayList;
import java.util.List;

import com.empresa.entities.Beneficiario;
import com.empresa.entities.Cliente;
import com.empresa.entities.Direccion;
import com.empresa.entities.Persona;
import com.empresa.entities.Referencia;
import com.empresa.entities.Telefono;
import com.persona.dao.PersonaDao;

public class TestPersona {
	public static void main(String[] args) {
		Persona persona = new Persona();//Cliente
		persona.setNombre("Luis");
		persona.setApellido("Escobar");
		persona.setNumeroDocumento("d2-f23fsdf2343");
		
		List<Cliente> cliList = new ArrayList<Cliente>();
		Cliente cli = new Cliente();
		cli.setEsMiembro("1");
		cli.setPersona(persona);
		cliList.add(cli);
		
		List<Telefono> telList = new ArrayList<Telefono>();
		Telefono telCli = new Telefono();
		telCli.setTelefono("23233-2323233");
		telCli.setPersona(persona);
		telList.add(telCli);
		telCli = new Telefono();
		telCli.setTelefono("24244-2424244");
		telCli.setPersona(persona);
		telList.add(telCli);
		
		List<Direccion> dirList = new ArrayList<Direccion>();
		Direccion dir = new Direccion();
		dir.setDireccion("direccion uno");
		dir.setPersona(persona);
		dirList.add(dir);
		
		persona.setDireccions(dirList);
		persona.setTelefonos(telList);
		persona.setClientes(cliList);
		
		//guardando persona
		
		PersonaDao perDao = new PersonaDao();
		Persona perRest = perDao.insertPersona(persona);
		System.out.println("id persona insertada"+perRest.getIdPersona());
		
		//beneficiaros
		List<Beneficiario> benList = new ArrayList<Beneficiario>();
		Beneficiario ben = new Beneficiario();
		Persona perBen = new Persona();
		perBen.setNombre("Ben Nombre 1");
		perBen.setApellido("Ben apellido 1");
		perBen.setNumeroDocumento("111111111111");
		Persona respuestaPerBen = perDao.insertPersona(perBen);
		ben.setPersona(respuestaPerBen);
		ben.setCliente(persona.getClientes().get(0));
		ben.setParentesco("padre");
		ben.setPorcentaje(100);
		benList.add(ben);
		cli.setBeneficiarios(benList);
		String respuestaBen = perDao.insertBeneficiarios(benList);
		System.out.println("Respuesta beneficiarios: "+respuestaBen);
		
		//Referencias
		List<Referencia> refList = new ArrayList<Referencia>();
		Referencia ref = new Referencia();
		Persona perRef = new Persona();
		perRef.setNombre("Ref nombres 1");
		perRef.setApellido("Ref ape 1");
		perRef.setNumeroDocumento("888888888-8");
		Persona respuestaPerRef = perDao.insertPersona(perRef);
		ref.setPersona(respuestaPerRef);
		ref.setCliente(persona.getClientes().get(0));
		refList.add(ref);
		cli.setReferencias(refList);
		String respuestaRef = perDao.insertReferencias(refList);
		System.out.println("Respuesta referencia"+respuestaRef);
		
		
	}
}
