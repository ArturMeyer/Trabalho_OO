/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import br.ufjf.dcc.artur.trabalho.controller.AdicionarItem;
import br.ufjf.dcc.artur.trabalho.controller.RemoverItem;
import br.ufjf.dcc.artur.trabalho.controller.Salvar;
import br.ufjf.dcc.artur.trabalho.controller.VerInformacoes;
import br.ufjf.dcc.artur.trabalho.model.Dependente;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Artur Welerson Sott Meyer - 202065552C
 */
public class JanelaEdicao extends JPanel {

    private JanelaPrincipal janelaPrincipal;

    private JTable tabela;
    
    private String tipoInformacao;

    private JPanel painelTxtBtn;
    private JPanel container;
    private JPanel pnlInfo;
    
    private JScrollPane scrlInfo;

    private JButton btnAdicionar;
    private JButton btnRemover;
    private JButton btnSalvar;
    
    private JLabel lblNome;
    private JLabel lblValor;
    private JLabel lblDuracao;
    private JLabel lblMesada;
    private JLabel lblCodigo;
    private JLabel lblJuros;
    private JLabel lblTipoJuros;
    private JLabel lblParcelas;
    private JTable tblInfo;

    public JanelaEdicao(JTable tabela, JanelaPrincipal janelaPrincipal, String tipoInformacao) {
        this.tabela = tabela;
        this.tabela.addMouseListener(new VerInformacoes(this));
        this.janelaPrincipal = janelaPrincipal;
        this.tipoInformacao = tipoInformacao;

        painelTxtBtn = new JPanel();
        painelTxtBtn.setLayout(new GridLayout(2, 0));
        container = new JPanel();
    }

    public void mostrar() {
        
        JPanel pnlBotoes = new JPanel();
        pnlBotoes.setLayout(new FlowLayout());

        btnAdicionar = new JButton("Adicionar");
        btnRemover = new JButton("Remover");
        //btnEditar = new JButton("Editar");
        btnSalvar = new JButton("Salvar");

        pnlBotoes.add(btnAdicionar);
        pnlBotoes.add(btnRemover);
        pnlBotoes.add(btnSalvar);

        btnAdicionar.addActionListener(new AdicionarItem(this));
        btnRemover.addActionListener(new RemoverItem(this));
        btnSalvar.addActionListener(new Salvar(this));

        btnAdicionar.setPreferredSize(new Dimension(180, 56));
        btnRemover.setPreferredSize(new Dimension(180, 56));
        btnSalvar.setPreferredSize(new Dimension(180, 56));

        pnlBotoes.setPreferredSize(new Dimension(220, 200));

        pnlBotoes.setBorder(BorderFactory.createSoftBevelBorder(0));

        container.add(pnlBotoes);

        painelTxtBtn.add(container);

        this.add(painelTxtBtn);

        JScrollPane srcl = new JScrollPane(tabela);

        pnlInfo = new JPanel();
        pnlInfo.setBorder(new EmptyBorder(10, 10, 10, 10));
        scrlInfo = new JScrollPane(pnlInfo);
        scrlInfo.setBorder(BorderFactory.createSoftBevelBorder(0));
        
        lblNome = new JLabel();
        lblValor = new JLabel();
        lblDuracao = new JLabel();
        lblMesada = new JLabel();
        lblCodigo = new JLabel();
        lblTipoJuros = new JLabel();
        lblJuros = new JLabel();
        lblParcelas = new JLabel();
        tblInfo = new JTable();
        
        JScrollPane scrllTbl = new JScrollPane(tblInfo);
        
        JPanel painelTbl = new JPanel();
        painelTbl.add(scrllTbl);
        
        JPanel lblPanel = new JPanel();
        
        lblPanel.setPreferredSize(new Dimension(300, 150));
        
        lblPanel.add(lblNome);
        lblPanel.add(lblValor);
        lblPanel.add(lblDuracao);
        lblPanel.add(lblMesada);
        lblPanel.add(lblCodigo);
        lblPanel.add(lblJuros);
        lblPanel.add(lblTipoJuros);
        lblPanel.add(lblParcelas);
        
        pnlInfo.add(lblPanel);
        pnlInfo.add(painelTbl);
        
        scrllTbl.setPreferredSize(new Dimension(200, 150));

        painelTxtBtn.add(scrlInfo);

        this.add(srcl);

    }

    public JPanel getPainelTxtBtn() {
        return painelTxtBtn;
    }

    public JTable getTabela() {
        return tabela;
    }

    public JButton getBtnAdicionar() {
        return btnAdicionar;
    }

    public JButton getBtnRemover() {
        return btnRemover;
    }

    public JPanel getContainer() {
        return container;
    }

    public JanelaPrincipal getJanelaPrincipal() {
        return janelaPrincipal;
    }

    public JScrollPane getPnlInfo() {
        return scrlInfo;
    }

    public String getTipoInformacao() {
        return tipoInformacao;
    }

    public JScrollPane getScrlInfo() {
        return scrlInfo;
    }

    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    public JLabel getLblNome() {
        return lblNome;
    }

    public JLabel getLblValor() {
        return lblValor;
    }

    public JLabel getLblDuracao() {
        return lblDuracao;
    }

    public JLabel getLblMesada() {
         return this.lblMesada;
    }

    public JLabel getLblCodigo() {
        return this.lblCodigo;
    }

    public JTable getTblInfo() {
        return this.tblInfo;
    }

    public JLabel getLblJuros() {
        return lblJuros;
    }

    public JLabel getLblTipoJuros() {
        return lblTipoJuros;
    }

    public JLabel getLblParcelas() {
        return lblParcelas;
    }
    
}
