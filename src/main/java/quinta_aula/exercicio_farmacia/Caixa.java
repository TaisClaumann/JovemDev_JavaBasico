package quinta_aula.exercicio_farmacia;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Caixa {

	private List<Produto> produtos = new ArrayList<>();
	private List<Cliente> clientes = new ArrayList<>();

	public void cadastraProduto(Produto produto) {
		produtos.add(produto);
	}

	public void cadastraCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public void vendaSemPrescricao(Produto produto, Cliente cliente, int quantidade) {
		if (existeCliente(cliente) && existeProduto(produto)) {

			if (produto instanceof Medicamento) {
				Medicamento medicamento = (Medicamento) produto;
				if (!medicamento.isPrecisaReceita()) {
					medicamento.venda(cliente, quantidade);
				}

			} else if (produto instanceof EquipamentoMedico) {
				EquipamentoMedico equipamento = (EquipamentoMedico) produto;
				equipamento.venda(cliente, quantidade);
			} else {
				Perfumaria perfumaria = (Perfumaria) produto;
				perfumaria.venda(cliente, quantidade);
			}
		}
	}

	public void vendaSobPrescricao(Produto produto, Cliente cliente, int quantidade, String nomeMedico) {
		if (existeCliente(cliente) && existeProduto(produto)) {

			if (produto instanceof Medicamento) {
				Medicamento medicamento = (Medicamento) produto;
				if (medicamento.isPrecisaReceita()) {
					medicamento.vendaComPrescricao(cliente, quantidade, nomeMedico);
				}
			}
		}
	}

	public void debitoDeDivida(Cliente cliente, double valor) {
		if (existeCliente(cliente)) {
			cliente.debitoDivida(valor);
		}
	}

	public String getClientesDevedores() {
		String lista = "";

		for (Cliente cliente : clientes) {
			if (cliente.temDivida(cliente)) {
				lista += cliente;
			}
		}
		return lista;
	}

	public String getClientesSemDividas() {
		String lista = "";

		for (Cliente cliente : clientes) {
			if (!cliente.temDivida(cliente)) {
				lista += cliente;
			}
		}
		return lista;
	}

	public String listaMedicamentos() {
		String lista = "";

		for (Produto produto : produtos) {
			if (produto instanceof Medicamento) {
				Medicamento medicamento = (Medicamento) produto;
				lista += medicamento;
			}
		}
		return lista;
	}

	public String listaPerfumarias() {
		String lista = "";

		for (Produto produto : produtos) {
			if (produto instanceof Perfumaria) {
				Perfumaria perfumaria = (Perfumaria) produto;
				lista += perfumaria;
			}
		}
		return lista;
	}

	public String listaEquipMedicos() {
		String lista = "";

		for (Produto produto : produtos) {
			if (produto instanceof EquipamentoMedico) {
				EquipamentoMedico equipamento = (EquipamentoMedico) produto;
				lista += equipamento;
			}
		}
		return lista;
	}

	public boolean existeProduto(Produto produto) {
		return produtos.contains(produto);
	}

	public boolean existeCliente(Cliente cliente) {
		return clientes.contains(cliente);
	}

	public void clearData() {
		produtos.clear();
		clientes.clear();
	}
}
