package br.com.estacionamento.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.estacionamento.dao.MovimentoDao;
import br.com.estacionamento.model.Movimento;

public class FrameMovimento {
	
	private JLabel labelEntrada; 
	private JLabel labelPlacaEntrada;
	private JTextField textPlacaEntrada;
	private JLabel labelModeloEntrada;
	private JTextField textModeloEntrada;
	private JButton buttonEntrar; 
	private JScrollPane scrollTable;
	private JTable tabelaClientes;
	private DefaultTableModel tabelaClientesModelo;
	private JLabel labelSaida;
	private JLabel labelPlacaSaida;
	private JTextField textPlacaSaida;
	private JButton buttonBuscar;
	private JLabel labelModeloSaida;
	private JTextField textModeloSaida;
	private JLabel labelDataEntrada;
	private JTextField textDataEntrada;
	private JLabel labelHoraEntrada;
	private JTextField textHoraEntrada;
	private JLabel labelDataSaida;
	private JTextField textDataSaida;
	private JLabel labelHoraSaida;
	private JTextField textHoraSaida;
	private JLabel labelTempo;
	private JTextField textTempo;
	private JLabel labelValor;
	private JTextField textValor;
	private JButton buttonSaida;
	private JButton buttonFecharSistema;
	
	public void criarTela() {
		
		JFrame tela = new JFrame();
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Registro de entrada e saída de veículos");
		tela.setSize(740, 610);
		tela.setResizable(false);
		tela.setLayout(null);
		
		Font titulo = new Font("Arial", Font.BOLD, 20);
		
		labelEntrada = new JLabel("ENTRADA");
		labelEntrada.setBounds(30, 15, 100, 30); 
		//x-margin left, y- margin top, l- largura, h-altura
		labelEntrada.setFont(titulo);
		labelEntrada.setForeground(Color.GREEN);
		
		labelPlacaEntrada = new JLabel("PLACA:");
		labelPlacaEntrada.setBounds(30, 50, 100, 20);
		
		textPlacaEntrada = new JTextField();
		textPlacaEntrada.setBounds(20, 80, 270, 30);
		
		labelModeloEntrada = new JLabel("MODELO:");
		labelModeloEntrada.setBounds(320, 50, 100, 20);
		
		textModeloEntrada = new JTextField();
		textModeloEntrada.setBounds(310, 80, 270, 30);
		
		buttonEntrar = new JButton("ENTRAR");
		buttonEntrar.setBounds(600, 80, 100, 30);
		buttonEntrar.setBackground(Color.BLUE);
		buttonEntrar.setForeground(Color.WHITE);
		
		labelSaida = new JLabel("SAÍDA");
		labelSaida.setFont(titulo);
		labelSaida.setBounds(30, 280, 100, 30);
		labelSaida.setForeground(Color.GREEN);
		
		labelPlacaSaida = new JLabel("PLACA:");
		labelPlacaSaida.setBounds(30, 315, 100, 20);
		
		textPlacaSaida = new JTextField();
		textPlacaSaida.setBounds(20, 345, 115, 30);
		
		buttonBuscar = new JButton("BUSCAR");
		buttonBuscar.setBounds(145, 345, 100, 30);
		buttonBuscar.setBackground(Color.BLUE);
		buttonBuscar.setForeground(Color.WHITE);
		
		labelModeloSaida = new JLabel("MODELO:");
		labelModeloSaida.setBounds(30, 385, 100, 20);
		
		textModeloSaida = new JTextField();
		textModeloSaida.setBounds(20, 415, 115, 30);
		
		labelDataEntrada = new JLabel("DATA ENTRADA:");
		labelDataEntrada.setBounds(155, 385, 100, 20);
		
		textDataEntrada = new JTextField();
		textDataEntrada.setBounds(145, 415, 115, 30);
		
		labelHoraEntrada = new JLabel("HORA ENTRADA:");
		labelHoraEntrada.setBounds(280, 385, 100, 20);
		
		textHoraEntrada = new JTextField();
		textHoraEntrada.setBounds(270, 415, 115, 30);
		
		labelDataSaida = new JLabel("DATA SAÍDA:");
		labelDataSaida.setBounds(405, 385, 100, 20);
		
		textDataSaida = new JTextField();
		textDataSaida.setBounds(395, 415, 115, 30);
		
		labelHoraSaida = new JLabel("HORA SAÍDA:");
		labelHoraSaida.setBounds(530, 385, 100, 20);
		
		textHoraSaida = new JTextField();
		textHoraSaida.setBounds(520, 415, 115, 30);
		
		labelTempo = new JLabel("TEMPO:");
		labelTempo.setBounds(655, 385, 100, 20);
		
		textTempo = new JTextField();
		textTempo.setBounds(645, 415, 65, 30);
		
		labelValor = new JLabel("VALOR A PAGAR:");
		labelValor.setBounds(30, 490, 110, 20);
		
		textValor = new JTextField();
		textValor.setBounds(150, 475, 170, 50);
		
		buttonSaida = new JButton("EFETUAR SAÍDA");
		buttonSaida.setBounds(345, 475, 170, 50);
		buttonSaida.setBackground(Color.BLUE);
		buttonSaida.setForeground(Color.WHITE);
		
		buttonFecharSistema = new JButton("FECHAR SISTEMA");
		buttonFecharSistema.setBounds(540, 475, 170, 50);
		buttonFecharSistema.setBackground(Color.RED);
		buttonFecharSistema.setForeground(Color.WHITE);
		
		criarTabela();
		
		tela.getContentPane().add(labelEntrada);
		tela.getContentPane().add(labelPlacaEntrada);
		tela.getContentPane().add(textPlacaEntrada);
		tela.getContentPane().add(labelModeloEntrada);
		tela.getContentPane().add(textModeloEntrada);
		tela.getContentPane().add(buttonEntrar);
		tela.getContentPane().add(scrollTable);
		tela.getContentPane().add(labelSaida);
		tela.getContentPane().add(labelPlacaSaida);
		tela.getContentPane().add(textPlacaSaida);
		tela.getContentPane().add(buttonBuscar);
		tela.getContentPane().add(labelModeloSaida);
		tela.getContentPane().add(textModeloSaida);
		tela.getContentPane().add(labelDataEntrada);
		tela.getContentPane().add(textDataEntrada);
		tela.getContentPane().add(labelHoraEntrada);
		tela.getContentPane().add(textHoraEntrada);
		tela.getContentPane().add(labelDataSaida);
		tela.getContentPane().add(textDataSaida);
		tela.getContentPane().add(labelHoraSaida);
		tela.getContentPane().add(textHoraSaida);
		tela.getContentPane().add(labelTempo);
		tela.getContentPane().add(textTempo);
		tela.getContentPane().add(labelValor);
		tela.getContentPane().add(textValor);
		tela.getContentPane().add(buttonSaida);
		tela.getContentPane().add(buttonFecharSistema);
		
		tela.setVisible(true);
		
		buttonEntrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Movimento cliente = new Movimento();
				cliente.setCodigo(br.com.estacionamento.util.Util.gerarCodigo());
				cliente.setPlaca(textPlacaEntrada.getText().trim().toUpperCase());
				cliente.setModelo(textModeloEntrada.getText().trim().toUpperCase());
				cliente.setDataEntrada(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				cliente.setHoraEntrada(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
				cliente.setDataSaida("");
				cliente.setHoraSaida("");
				cliente.setTempo(0);
				cliente.setValorTotal(0);
				
				MovimentoDao dao = new MovimentoDao(cliente);
				dao.entrarCliente();
				
				JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");

			}
		});
		
		buttonBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String placa;
				
				placa = textPlacaSaida.getText().toUpperCase();
				MovimentoDao dao = new MovimentoDao();
				Movimento movimento = dao.buscarMovimento(placa);
				
				movimento.setDataSaida(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
				movimento.setHoraSaida(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")).toString());
				
				textModeloSaida.setText(movimento.getModelo());
				textDataEntrada.setText(movimento.getDataEntrada());
				textHoraEntrada.setText(movimento.getHoraEntrada());
				textDataSaida.setText(movimento.getDataSaida());
				textHoraSaida.setText(movimento.getHoraSaida());
				
				
			}
		});
		
		buttonFecharSistema.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				tela.setVisible(false);
				tela.dispose();
				
			}
		});
		
	}
	
	private void criarTabela() {
		
		tabelaClientesModelo = new DefaultTableModel();
		
		tabelaClientesModelo.addColumn("CÓDIGO");
		tabelaClientesModelo.addColumn("PLACA");
		tabelaClientesModelo.addColumn("MODELO");
		tabelaClientesModelo.addColumn("DATA ENTRADA");
		
		MovimentoDao movimentoDao = new MovimentoDao();
		ArrayList<Movimento> movimentos = movimentoDao.listarMovimentos();
		
		for (Movimento movimento : movimentos) {
			String[] vetorMovimento = {movimento.getCodigo(), movimento.getPlaca(), movimento.getModelo(), movimento.getDataEntrada()};
			tabelaClientesModelo.addRow(vetorMovimento);
		}
		
		
		tabelaClientes = new JTable(tabelaClientesModelo);
		
		tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(170);
		tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(170);
		tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(170);
		tabelaClientes.getColumnModel().getColumn(3).setPreferredWidth(170);
		
		
		tabelaClientes.getTableHeader().setReorderingAllowed(false);
		

		scrollTable = new JScrollPane(tabelaClientes);
		scrollTable.setBounds(20, 120, 680, 150);
	}
	
	
}
