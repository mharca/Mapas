package panel.view;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import panel.model.*;

public class PanelListar extends JPanel{

	JButton jbAtualizaButton;
	JButton jbEndereco;
	JButton jbDeletar;
	JLabel jlPesquisa;
	JPanel jpButton;
	JComboBox<List<String>> jc;
	
	public PanelListar(){
		jpButton = new JPanel();
		jc = new JComboBox();
		jbAtualizaButton = new JButton("Atualizar lista");
		jbEndereco = new JButton("Mostrar no mapa");
		jbDeletar = new JButton("Excluir");
		jlPesquisa = new JLabel("Nome: ");
		//jc.addItem("bob");
		
		//this.setLayout(new GridLayout(2,5));
		//jpButton.setLayout(new FlowLayout());
		add(jlPesquisa);
		add(jc);
		add(jbAtualizaButton);
		add(jbEndereco);
		add(jbDeletar);
		
		add(jpButton);
		
	}
	public void addjbDeletarListener(ActionListener listener){
		jbDeletar.addActionListener(listener);
	}
	
	public void addjbListarListener(ActionListener listener){
		jbAtualizaButton.addActionListener(listener);
	}
	
	public void addjbPesquisaListener(ActionListener listener){
		jbEndereco.addActionListener(listener);
		
	}
	
	public void setCombo(List<String> s){
			jc.setModel(new DefaultComboBoxModel(s.toArray()));
	}
	public String getCombo()
	{
		String s = new String();
		try{
		s = jc.getSelectedItem().toString();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Nome vazio.");
			//e.printStackTrace();
			
		}
		return s;
	}
}
