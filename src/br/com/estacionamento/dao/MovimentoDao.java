package br.com.estacionamento.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

import br.com.estacionamento.model.Movimento;

public class MovimentoDao {

	private Movimento movimento;

	private static final String LOCAL_ARQUIVO = "C:/Users/Luiza/movimentacao.ds1";

	public Movimento getMovimento() {
		return movimento;
	}

	public MovimentoDao(Movimento movimento) {
		this.movimento = movimento;
	}

	// construtor vazio
	public MovimentoDao() {

	}

	public void entrarCliente() {

		Path path = Paths.get(LOCAL_ARQUIVO);

		try {

			BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"), StandardOpenOption.WRITE,
					StandardOpenOption.APPEND);

			writer.write(movimento.toString());
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
				movimento.setTempo(vetorMovimento[7]);
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
			Movimento movimento = new Movimento();

			while (linha != null) {
				String[] vetorMovimento = linha.split(";");

				if (vetorMovimento[1].equals(placa)) {
					movimento.setCodigo(vetorMovimento[0]);
					movimento.setPlaca(vetorMovimento[1]);
					movimento.setModelo(vetorMovimento[2]);
					movimento.setDataEntrada(vetorMovimento[3]);
					movimento.setHoraEntrada(vetorMovimento[4]);
					movimento.setDataSaida(vetorMovimento[5]);
					movimento.setHoraSaida(vetorMovimento[6]);
					movimento.setTempo(vetorMovimento[7]);
					movimento.setValorTotal(Double.parseDouble(vetorMovimento[8]));
					
					break;
				}
				
				linha = reader.readLine();
			}

			reader.close();

			return movimento;

		} catch (Exception e) {
			System.out.println("Ocorreu um erro na tentativa de buscar o cliente");
			e.printStackTrace();

			return null;
		}

	}
	
	public String calcularTempo() {
		
		Movimento movimento = new Movimento();
		
		LocalTime tempoEntrada = LocalTime.parse(movimento.getHoraEntrada());
		LocalTime tempoSaida = LocalTime.parse(movimento.getHoraSaida());
		
		Duration tempo = Duration.between(tempoEntrada, tempoSaida);
		
		return tempo.toString();
		
	}

}
