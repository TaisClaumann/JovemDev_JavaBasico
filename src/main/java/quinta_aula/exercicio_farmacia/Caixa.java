package quinta_aula.exercicio_farmacia;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		return clientes.stream().filter(cliente -> cliente.temDivida())
								.map(Cliente::toString)
								.collect(Collectors.joining());
	}

	public String getClientesSemDividas() {
		return clientes.stream().filter(cliente -> !cliente.temDivida())
								.map(Cliente::toString)
								.collect(Collectors.joining());
	}

	public String listaMedicamentos() {
		return produtos.stream().filter(produto -> produto instanceof Medicamento)
								.map(Produto::toString)
								.collect(Collectors.joining());
		
	}

	public String listaPerfumarias() {
		return produtos.stream().filter(produto -> produto instanceof Perfumaria)
								.map(Produto::toString)
								.collect(Collectors.joining());
	}

	public String listaEquipMedicos() {
		return produtos.stream().filter(produto -> produto instanceof EquipamentoMedico)
								.map(Produto::toString)
								.collect(Collectors.joining());
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
