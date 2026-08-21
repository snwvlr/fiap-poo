package br.com.fiapride.main;

import br.com.fiapride.model.Passageiro;
import br.com.fiapride.model.PowerBank;

public class SistemaPrincipal {

	public static void main(String[] args) {
		Passageiro passageiro1 = new Passageiro("Ana Silva", "222");
		System.out.println("Recarga passageiro 1");
		passageiro1.adicionarSaldo(50.0);

		Passageiro passageiro2 = new Passageiro("Carlos Souza", "333");
		System.out.println("Recarga passageiro 2");
		passageiro2.adicionarSaldo(12.5);

		System.out.println("--- Sistema FiapRide ---");
		System.out.println("Passageiro: " + passageiro1.nome + " | Saldo: R$ " + passageiro1.saldo + " | CPF: " + passageiro1.cpf);
		System.out.println("Passageiro: " + passageiro2.nome + " | Saldo: R$ " + passageiro2.saldo + " | CPF: " + passageiro2.cpf);

		System.out.println("Pagando viagem do passageiro 1");
		passageiro1.pagarViagem(20);
		System.out.println("Pagando viagem do passageiro 2");
		passageiro2.pagarViagem(20);

		System.out.println();
		System.out.println("--- Meu objeto: PowerBank ---");

		PowerBank meuPowerBank = new PowerBank("Samsung 20000mAh", 40);
		System.out.println("Criei o " + meuPowerBank.modelo + " com " + meuPowerBank.cargaAtual + "% de bateria.");

		System.out.println();
		System.out.println("Testes com valores válidos:");
		meuPowerBank.carregarBateria(30);
		meuPowerBank.conectarDispositivo();
		meuPowerBank.consumirBateria(20);
		meuPowerBank.desconectarDispositivo();

		System.out.println();
		System.out.println("Testes com valores inválidos:");
		meuPowerBank.carregarBateria(-15);
		meuPowerBank.consumirBateria(10);
		meuPowerBank.desconectarDispositivo();

		meuPowerBank.conectarDispositivo();
		meuPowerBank.conectarDispositivo();
		meuPowerBank.carregarBateria(60);
		meuPowerBank.consumirBateria(500);

		System.out.println("Estado preservado: " + meuPowerBank.cargaAtual + "% de bateria.");

		System.out.println();
		System.out.println("Teste do limite de 100%:");
		meuPowerBank.desconectarDispositivo();
		meuPowerBank.carregarBateria(999);
	}
}