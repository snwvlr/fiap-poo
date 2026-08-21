package br.com.fiapride.model;

public class PowerBank {
	public String modelo;
	public int cargaAtual;
	public boolean emUso;

	public PowerBank(String modelo, int cargaInicial) {
		this.modelo = modelo;
		this.cargaAtual = cargaInicial;
		this.emUso = false;
	}

	public void carregarBateria(int minutosNaTomada) {
		if (minutosNaTomada <= 0) {
			System.out.println("Erro: O tempo de carga deve ser maior que zero.");
			return;
		}
		if (this.emUso) {
			System.out.println("Erro: Desconecte o dispositivo antes de carregar.");
			return;
		}
		this.cargaAtual += minutosNaTomada;
		if (this.cargaAtual > 100) {
			this.cargaAtual = 100;
		}
		System.out.println("Carga realizada. Bateria atual: " + this.cargaAtual + "%");
	}

	public void conectarDispositivo() {
		if (this.emUso) {
			System.out.println("Erro: Já existe um dispositivo conectado.");
			return;
		}
		if (this.cargaAtual < 5) {
			System.out.println("Erro: Bateria muito baixa para conectar um dispositivo.");
			return;
		}
		this.emUso = true;
		System.out.println("Dispositivo conectado. Bateria disponível: " + this.cargaAtual + "%");
	}

	public void consumirBateria(int minutosDeUso) {
		if (minutosDeUso <= 0) {
			System.out.println("Erro: O tempo de uso deve ser maior que zero.");
			return;
		}
		if (!this.emUso) {
			System.out.println("Erro: Conecte um dispositivo antes de usar o power bank.");
			return;
		}
		if (minutosDeUso > this.cargaAtual) {
			System.out.println("Erro: Bateria insuficiente para esse tempo de uso.");
			return;
		}
		this.cargaAtual -= minutosDeUso;
		System.out.println("Dispositivo carregado por " + minutosDeUso + " min. Bateria restante: " + this.cargaAtual + "%");
	}

	public void desconectarDispositivo() {
		if (!this.emUso) {
			System.out.println("Erro: Nenhum dispositivo está conectado.");
			return;
		}
		this.emUso = false;
		System.out.println("Dispositivo desconectado.");
	}
}