/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.controller;

import br.ufjf.dcc.artur.trabalho.model.Dependente;
import br.ufjf.dcc.artur.trabalho.model.GastoRendaMensal;
import br.ufjf.dcc.artur.trabalho.view.JanelaEdicao;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * Artur Welerson Sott Meyer - 202065552C
 */
public class VerInformacoes implements MouseListener {

    private JanelaEdicao janela;

    public VerInformacoes(JanelaEdicao janela) {
        this.janela = janela;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            if (janela.getTipoInformacao().equals("Gastos") || janela.getTipoInformacao().equals("Rendas")) {

                int linha = janela.getTabela().getSelectedRow();

                janela.getLblNome().setText("Nome: " + (janela.getTabela().getValueAt(linha, 0)).toString());
                janela.getLblValor().setText("Valor: " + (janela.getTabela().getValueAt(linha, 1)).toString());
                janela.getLblDuracao().setText("Duração: " + (janela.getTabela().getValueAt(linha, 2)).toString());

                janela.getLblNome().setPreferredSize(new Dimension(300, 20));
                janela.getLblValor().setPreferredSize(new Dimension(300, 20));
                janela.getLblDuracao().setPreferredSize(new Dimension(300, 20));

            } else if (janela.getTipoInformacao().equals("Dependentes")) {

                int linha = janela.getTabela().getSelectedRow();

                Dependente dep = janela.getJanelaPrincipal().getAdm().getDependenteCodigo(janela.getTabela().getValueAt(linha, 2).toString());

                janela.getLblNome().setText("Nome: " + (janela.getTabela().getValueAt(linha, 0)).toString());
                janela.getLblMesada().setText("Mesada: R$ " + dep.getMesada());
                janela.getLblCodigo().setText("Código: " + dep.getCodigo());

                janela.getLblNome().setPreferredSize(new Dimension(300, 20));
                janela.getLblMesada().setPreferredSize(new Dimension(320, 20));
                janela.getLblCodigo().setPreferredSize(new Dimension(300, 20));

                DefaultTableModel tblModel = (DefaultTableModel) janela.getTblInfo().getModel();

                tblModel.setRowCount(0);
                tblModel.setColumnCount(0);

                if (dep.getGastos() != null) {

                    tblModel.addColumn("Nome");
                    tblModel.addColumn("Valor");
                    tblModel.addColumn("Duração");

                    for (GastoRendaMensal el : dep.getGastos()) {
                        String[] dados = {el.getNome(), "R$ " + Float.toString(el.getValor()), Integer.toString(el.getDuracao()) + " meses"};
                        tblModel.addRow(dados);
                    }
                }

            } else if (janela.getTipoInformacao().equals("Funcionarios")) {

                int linha = janela.getTabela().getSelectedRow();

                janela.getLblNome().setText("Nome: " + (janela.getTabela().getValueAt(linha, 0)).toString());
                janela.getLblValor().setText("Salário: " + (janela.getTabela().getValueAt(linha, 1)).toString());
                janela.getLblDuracao().setText("Duração: " + (janela.getTabela().getValueAt(linha, 2)).toString());
                janela.getLblCodigo().setText("Código: " + (janela.getTabela().getValueAt(linha, 3)).toString());

                janela.getLblNome().setPreferredSize(new Dimension(300, 20));
                janela.getLblValor().setPreferredSize(new Dimension(300, 20));
                janela.getLblDuracao().setPreferredSize(new Dimension(300, 20));
                janela.getLblCodigo().setPreferredSize(new Dimension(310, 20));

            } else if (janela.getTipoInformacao().equals("Financiamentos")) {

                int linha = janela.getTabela().getSelectedRow();

                janela.getLblNome().setText("Nome: " + (janela.getTabela().getValueAt(linha, 0)).toString());
                janela.getLblValor().setText("Valor: " + (janela.getTabela().getValueAt(linha, 1)).toString());
                janela.getLblJuros().setText("Juros: " + (janela.getTabela().getValueAt(linha, 2)).toString());
                janela.getLblTipoJuros().setText("Tipo de Juros: " + (janela.getTabela().getValueAt(linha, 3)).toString());
                janela.getLblParcelas().setText("Parcelas: " + (janela.getTabela().getValueAt(linha, 4)).toString());
                janela.getLblDuracao().setText("Duração: " + (janela.getTabela().getValueAt(linha, 5)).toString());

                janela.getLblNome().setPreferredSize(new Dimension(300, 20));
                janela.getLblValor().setPreferredSize(new Dimension(300, 20));
                janela.getLblDuracao().setPreferredSize(new Dimension(300, 20));
                janela.getLblTipoJuros().setPreferredSize(new Dimension(300, 20));
                janela.getLblParcelas().setPreferredSize(new Dimension(300, 20));
                janela.getLblJuros().setPreferredSize(new Dimension(320, 20));

            } else if (janela.getTipoInformacao().equals("Investimentos")) {

                int linha = janela.getTabela().getSelectedRow();

                janela.getLblNome().setText("Nome: " + (janela.getTabela().getValueAt(linha, 0)).toString());
                janela.getLblValor().setText("Valor: " + (janela.getTabela().getValueAt(linha, 1)).toString());
                janela.getLblJuros().setText("Juros: " + (janela.getTabela().getValueAt(linha, 2)).toString());
                janela.getLblTipoJuros().setText("Tipo de Juros: " + (janela.getTabela().getValueAt(linha, 3)).toString());
                
                janela.getLblNome().setPreferredSize(new Dimension(300, 20));
                janela.getLblValor().setPreferredSize(new Dimension(300, 20));
                janela.getLblTipoJuros().setPreferredSize(new Dimension(300, 20));
                janela.getLblJuros().setPreferredSize(new Dimension(330, 20));

            }
        } catch (Exception erro) {
            System.out.println(erro);
            JOptionPane.showMessageDialog(janela, "Selecione um item para visualizar", "Erro", 0);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

}
