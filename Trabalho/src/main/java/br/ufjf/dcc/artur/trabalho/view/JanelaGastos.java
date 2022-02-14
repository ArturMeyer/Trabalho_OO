/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.view;

import br.ufjf.dcc.artur.trabalho.controller.AdicionarItem;
import java.awt.Dimension;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Artur Welerson Sott Meyer - 202065552C
 */
public class JanelaGastos extends JFrame {
    
    private JanelaPrincipal janelaPrincipal;

    private TextField txtNome;
    private TextField txtValor;
    private TextField txtDuracao;
    
    private JButton btnAdicionar;

    public JanelaGastos(JanelaPrincipal janelaPrincipal, String titulo) {
        super(titulo);
        this.janelaPrincipal = janelaPrincipal;
    }

    public void mostrar() {
        this.setSize(new Dimension(270,160));
        
        JPanel painel = new JPanel();
        painel.setSize(new Dimension(270,160));
        
        this.add(painel);
        
        txtNome = new TextField(20);
        txtValor = new TextField(20);
        txtDuracao = new TextField(20);
        
        JLabel lblNome = new JLabel("Nome:");
        JLabel lblValor = new JLabel("Valor:");
        JLabel lblDuracao = new JLabel("Duração:");
        
        lblNome.setPreferredSize(new Dimension(70, 20));
        lblValor.setPreferredSize(new Dimension(70, 20));
        lblDuracao.setPreferredSize(new Dimension(70, 20));
        
        painel.add(lblNome);
        painel.add(txtNome);
        painel.add(lblValor);
        painel.add(txtValor);
        painel.add(lblDuracao);
        painel.add(txtDuracao);
        
        btnAdicionar = new JButton("Adiconar");
        
        btnAdicionar.setPreferredSize(new Dimension(240, 30));
        
        btnAdicionar.addActionListener(new AdicionarItem(janelaPrincipal, this));
        
        painel.add(btnAdicionar);
       
        this.setVisible(true);
    }

    public TextField getTxtNome() {
        return txtNome;
    }

    public TextField getTxtValor() {
        return txtValor;
    }

    public TextField getTxtDuracao() {
        return txtDuracao;
    }
    
    

}
