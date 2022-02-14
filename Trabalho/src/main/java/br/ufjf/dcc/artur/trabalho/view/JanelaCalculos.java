/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.view;

import br.ufjf.dcc.artur.trabalho.controller.CalcularMeta;
import br.ufjf.dcc.artur.trabalho.controller.CalcularSaldoFuturo;
import br.ufjf.dcc.artur.trabalho.controller.VerInformacoesMes;
import br.ufjf.dcc.artur.trabalho.model.Mes;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextField;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Artur Welerson Sott Meyer - 202065552C
 */
public class JanelaCalculos extends JPanel {

    private JanelaPrincipal janelaPrincipal;

    private JTable tabelaMeses;

    private TableModel tabelaMesesModel;

    private JButton calcularSaldo;
    private JButton calcularMeta;
    
    private JTextField txtMeses;
    private JTextField txtMeta;

    private Map<Integer, Mes> meses = new HashMap<>();

    public JanelaCalculos(JanelaPrincipal janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
    }

    public void mostrar() {

        mostrarTabela();

        this.setVisible(true);

    }

    public void mostrarTabela() {

        calcularSaldo = new JButton("Calcular Saldo");
        calcularSaldo.addActionListener(new CalcularSaldoFuturo(this));
        
        calcularMeta = new JButton("Calcular Meta");
        calcularMeta.addActionListener(new CalcularMeta(this));

        txtMeses = new JTextField(10);
        JLabel lblMeses = new JLabel("Meses:");
        lblMeses.setPreferredSize(new Dimension(50, 20));
        
        txtMeta = new JTextField(10);
        JLabel lblMeta = new JLabel("Meta:");
        lblMeses.setPreferredSize(new Dimension(50, 20));

        JPanel pnlCalculo = new JPanel();
        pnlCalculo.add(lblMeses);
        pnlCalculo.add(txtMeses);
        pnlCalculo.add(calcularSaldo);
        pnlCalculo.add(lblMeta);
        pnlCalculo.add(txtMeta);
        pnlCalculo.add(calcularMeta);

        tabelaMeses = new JTable(tabelaMesesModel);
        DefaultTableModel tblModel = (DefaultTableModel) (tabelaMeses.getModel());
        tblModel.addColumn("Mês");
        tblModel.addColumn("Saldo");
        tabelaMeses.addMouseListener(new VerInformacoesMes(this));

        JScrollPane scrll = new JScrollPane(tabelaMeses);
        
        JPanel pnlGeral = new JPanel();
        pnlGeral.setLayout(new BorderLayout());
        pnlGeral.add(BorderLayout.NORTH, pnlCalculo);
        pnlGeral.add(BorderLayout.SOUTH, scrll);
        
        this.add(pnlGeral);

    }

    public JanelaPrincipal getJanelaPrincipal() {
        return janelaPrincipal;
    }

    public JTable getTabelaMeses() {
        return tabelaMeses;
    }

    public TableModel getTabelaMesesModel() {
        return tabelaMesesModel;
    }

    public JButton getCalcularSaldo() {
        return calcularSaldo;
    }

    public JTextField getTxtMeses() {
        return txtMeses;
    }

    public Map<Integer, Mes> getMeses() {
        return meses;
    }

    public JButton getCalcularMeta() {
        return calcularMeta;
    }

    public JTextField getTxtMeta() {
        return txtMeta;
    }

    
    
}

