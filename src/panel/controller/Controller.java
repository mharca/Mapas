package panel.controller;
import java.awt.Desktop;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import panel.model.*;
import panel.view.*;

import java.util.*;

import javax.swing.JOptionPane;
public class Controller {
	View view;
	Model model;

	public Controller(View v, Model m){
		this.view = v;
		this.model = m;
		
		view.panelIncluir.addjbGravarListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			   Pessoa p = new Pessoa();
			   p.setNome (view.panelIncluir.getNome());
			   p.setPos(view.panelIncluir.getPos());
			   p.setTel(view.panelIncluir.getTel());
			   
			   System.out.println(p.getNome());
			   
			   		if(p.getNome() == "")
			   			JOptionPane.showMessageDialog(null,"Sem nome");
			   		else
			   			model.inserir(p);
			 

				view.panelIncluir.limparCampos();
			}
		});
		
		view.panelSair.addSairListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Saindo..");
				System.exit(0);
			}
		});
		
		view.panelListar.addjbPesquisaListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tel = new String();
				String pos = new String();
					System.out.print("Combo selecionado: " + view.panelListar.getCombo());
					tel = model.getTel(view.panelListar.getCombo());
					pos = model.getPos(view.panelListar.getCombo());
					
					model.montaHtml(view.panelListar.getCombo(), pos ,tel );
				
					File htmlFile = new File("mapa.html");
					try {
						Desktop.getDesktop().browse(htmlFile.toURI());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

			}
		});
		view.panelListar.addjbDeletarListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				model.deletar(view.panelListar.getCombo());

			}
		});
		view.panelListar.addjbListarListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				List<String> nomes=new ArrayList<String>();
				model.listar(nomes);
				view.panelListar.setCombo(nomes);
			}
		});
	}
}
