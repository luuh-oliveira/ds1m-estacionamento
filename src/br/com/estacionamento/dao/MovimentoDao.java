package br.com.estacionamento.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import br.com.estacionamento.model.Movimento;

public class MovimentoDao {

	private Movimento cliente;

	private static final String LOCAL_ARQUIVO = "C:/Users/Luiza/movimentacao.ds1";

	public Movimento getCliente() {
		return cliente;
	}

	public MovimentoDao(Movimento cliente) {
		this.cliente = cliente;
	}

	// construtor vazio
	public MovimentoDao() {

	}

	public void entrarCliente() {

		Path path = Paths.get(LOCAL_ARQUIVO);

		try {

			BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"), StandardOpenOption.WRITE,
					StandardOpenOption.APPEND);

			writer.write(cliente.toString());
			writer.newLine();
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ocorreu um erro!");
		}
	}

	public ArrayList<Movimento> listarMovimentos() {

		Path path = Paths.get(LOCAL_ARQUIVO);

		try {

			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));

			String linha = reader.readLine();
			ArrayList<Movimento> movimentos = new ArrayList<>();

			while (linha != null) {
				String[] vetorMovimento = linha.split(";");

				Movimento movimento = new Movimento();
				movimento.setCodigo(vetorMovimento[0]);
				movimento.setPlaca(vetorMovimento[1]);
				movimento.setModelo(vetorMovimento[2]);
				movimento.setDataEntrada(vetorMovimento[3]);
				movimento.setHoraEntrada(vetorMovimento[4]);
				movimento.setDataSaida(vetorMovimento[5]);
				movimento.setHoraSaida(vetorMovimento[6]);
				movimento.setTempo(Integer.parseInt(vetorMovimento[7]));
				movimento.setValorTotal(Double.parseDouble(vetorMovimento[8]));

				movimentos.add(movimento);

				linha = reader.readLine();
			}

			System.out.println(movimentos);

			reader.close();

			return movimentos;

		} catch (Exception e) {
			System.out.println("Ocorreu um erro na tentativa de ler o arquivo");
			e.printStackTrace();

			return null;
		}

	}

	public Movimento buscarMovimento(String placa) {

		Path path = Paths.get(LOCAL_ARQUIVO);

		try {

			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));

			String linha = reader.readLine();
			Movimento cliente = new Movimento();

			while (linha != null) {
				String[] vetorMovimento = linha.split(";");

				if (vetorMovimento[1].equals(cliente.getPlaca())) {
					cliente.setCodigo(vetorMovimento[0]);
					cliente.setPlaca(vetorMovimento[1]);
					cliente.setModelo(vetorMovimento[2]);
					cliente.setDataEntrada(vetorMovimento[3]);
					cliente.setHoraEntrada(vetorMovimento[4]);
					cliente.setDataSaida(vetorMovimento[5]);
					cliente.setHoraSaida(vetorMovimento[6]);
					cliente.setTempo(Integer.parseInt(vetorMovimento[7]));
					cliente.setValorTotal(Double.parseDouble(vetorMovimento[8]));
					
					break;
				}
				
				linha = reader.readLine();
			}

			reader.close();

			return cliente;

		} catch (Exception e) {
			System.out.println("Ocorreu um erro na tentativa de buscar o cliente");
			e.printStackTrace();

			return null;
		}

	}
	
	

}
