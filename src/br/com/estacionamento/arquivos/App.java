package br.com.estacionamento.arquivos;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

import br.com.estacionamento.ui.FrameMovimento;

public class App {

	public static void main(String[] args) {
		
		try {
			//aparência do SO
//			UIManager.setLookAndFeel(
//		            UIManager.getSystemLookAndFeelClassName());
			
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}
		
		FrameMovimento telaCliente = new FrameMovimento();
		telaCliente.criarTela();
		
	}

}
