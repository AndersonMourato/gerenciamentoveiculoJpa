package br.com.concessionaria.menuterminal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.concessionaria.conexao.Conexao;
import br.com.concessionaria.dao.impl.LojaDAO;
import br.com.concessionaria.model.Endereco;
import br.com.concessionaria.model.Loja;
import br.com.concessionaria.service.LojaService;


public class Lojas {
	private Menu menu = new Menu();
	private LojaDAO lojaDAO = new LojaDAO();
	private Conexao conn = new Conexao();
	private Scanner sc = new Scanner(System.in);
	
	public void init() throws SQLException {
		List<String> opcoes = new ArrayList<>();
		menu.setNome("LOJAS");
		opcoes.add("LISTAR LOJAS");
		opcoes.add("RETORNAR O MENU ANTERIOR");
		menu.setOpcoes(opcoes);
		
		boolean loop = true;
		while (loop) {	
			int op;
			op = menu.getMenu();
			switch(op) {
				case 0: listar();
					break;
				case 1: loop = false; 
					break;
				default: System.err.println("A opção informada é Invalida!");
			}
		}
	}
	
	public void initGerenciar() throws SQLException {
		List<String> opcoes = new ArrayList<>();
		menu.setNome("GERENCIAR LOJAS");
		opcoes.add("CADASTRAR LOJA");
		opcoes.add("EXCLUIR LOJA");
		opcoes.add("ALTERAR LOJA");
		opcoes.add("RETORNAR O MENU ANTERIOR");
		menu.setOpcoes(opcoes);
		
		boolean loop = true;
		while (loop) {	
			int op;
			op = menu.getMenu();
			switch(op) {
				case 0: cadastra();
					break;
				case 1: excluir();
					break;
				case 2: alterar();
					break;
				case 3: loop = false; 
					break;
				default: System.err.println("A opção informada é Invalida!");
			}
		}
	}
	
	public void listar() throws SQLException {
		System.err.println("Falta implementar o SERVICE e a logica de JEFFERSON");
	}
	
	public void cadastra() throws SQLException {
		LojaService lojaService = new LojaService();
		Loja loja = new Loja();
		Endereco end = new Endereco();
		
		System.out.print("NOME DA LOJA: ");
		loja.setNome(sc.nextLine());
		
		System.out.print("RUA: ");
		end.setLogradouro(sc.nextLine());
		
		System.out.print("NUMERO: ");
		loja.setNumEndereco(sc.nextLine());
		
		System.out.print("COMPLEMENTO: ");
		end.setComplemento(sc.nextLine());
		
		System.out.print("BAIRRO: ");
		end.setBairro(sc.nextLine());
		
		System.out.print("CIDADE: ");
		end.setCiade(sc.nextLine());
		
		System.out.print("UF: ");
		end.setUf(sc.nextLine());
		
		System.out.print("CEP: ");
		end.setCep(sc.nextLine());
		
			
		loja.setEndereco(end);
		lojaService.save(loja);
	}
	
	public void excluir() throws SQLException {
		System.err.println("Falta implementar o SERVICE e a logica de JEFFERSON");
	}
	
	public void alterar() throws SQLException {
		System.err.println("Falta implementar o SERVICE e a logica de JEFFERSON");
	}

}
