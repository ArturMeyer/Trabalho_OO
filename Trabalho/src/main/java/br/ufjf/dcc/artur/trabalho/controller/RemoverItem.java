/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.controller;

import br.ufjf.dcc.artur.trabalho.view.JanelaEdicao;
import br.ufjf.dcc.artur.trabalho.view.JanelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * Artur Welerson Sott Meyer - 202065552C
 */
public class RemoverItem implements ActionListener {

    private JanelaEdicao janela;
    private JanelaPrincipal janelaPrincipal;

    private String tipo;

    public RemoverItem(JanelaPrincipal janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
        this.tipo = "GastosDependente";
    }

    public RemoverItem(JanelaEdicao janela) {
        this.janela = janela;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            if (janela != null && janela.getTipoInformacao().equals("Gastos")) {
                DefaultTableModel tblModelGastos = (DefaultTableModel) (janela.getJanelaPrincipal().getTblGastos().getModel());
                tblModelGastos.removeRow(janela.getTabela().getSelectedRow());

                janela.getJanelaPrincipal().getAdm().removerGasto((janela.getTabela().getValueAt(janela.getTabela().getSelectedRow(), 0)).toString());

            } else if (janela != null && janela.getTipoInformacao().equals("Rendas")) {
                DefaultTableModel tblModelRendas = (DefaultTableModel) (janela.getJanelaPrincipal().getTblRendas().getModel());
                tblModelRendas.removeRow(janela.getTabela().getSelectedRow());

                janela.getJanelaPrincipal().getAdm().removerRenda((janela.getTabela().getValueAt(janela.getTabela().getSelectedRow(), 0)).toString());

            } else if (janela != null && janela.getTipoInformacao().equals("Dependentes")) {
                DefaultTableModel tblModelDependentes = (DefaultTableModel) (janela.getJanelaPrincipal().getTblDependentes().getModel());
                tblModelDependentes.removeRow(janela.getTabela().getSelectedRow());

                janela.getJanelaPrincipal().getAdm().removerDependente((janela.getTabela().getValueAt(janela.getTabela().getSelectedRow(), 2)).toString());

            } else if (janela != null && janela.getTipoInformacao().equals("Funcionarios")) {
                DefaultTableModel tblModelFuncionarios = (DefaultTableModel) (janela.getJanelaPrincipal().getTblFuncionarios().getModel());
                tblModelFuncionarios.removeRow(janela.getTabela().getSelectedRow());

                janela.getJanelaPrincipal().getAdm().removerFuncionario((janela.getTabela().getValueAt(janela.getTabela().getSelectedRow(), 3)).toString());

            } else if (janela != null && janela.getTipoInformacao().equals("Financiamentos")) {
                DefaultTableModel tblModelFinanciamentos = (DefaultTableModel) (janela.getJanelaPrincipal().getTblFinanciamentos().getModel());
                tblModelFinanciamentos.removeRow(janela.getTabela().getSelectedRow());

                janela.getJanelaPrincipal().getAdm().removerFinanciamento((janela.getTabela().getValueAt(janela.getTabela().getSelectedRow(), 0)).toString());

            } else if (janela != null && janela.getTipoInformacao().equals("Investimentos")) {
                DefaultTableModel tblModelInvestimentos = (DefaultTableModel) (janela.getJanelaPrincipal().getTblInvestimentos().getModel());
                tblModelInvestimentos.removeRow(janela.getTabela().getSelectedRow());

                janela.getJanelaPrincipal().getAdm().removerInvestimento((janela.getTabela().getValueAt(janela.getTabela().getSelectedRow(), 0)).toString());

            } else if (tipo.equals("GastosDependente")) {
                DefaultTableModel tblModelGastos = (DefaultTableModel) (janelaPrincipal.getTblGastosDependente().getModel());

                janelaPrincipal.getListaGastosDependente().remove(janelaPrincipal.getTblGastosDependente().getSelectedRow());

                tblModelGastos.removeRow(janelaPrincipal.getTblGastosDependente().getSelectedRow());
            }

            if (janela != null) {
                DefaultTableModel tblModel = (DefaultTableModel) (janela.getTabela().getModel());
                tblModel.removeRow(janela.getTabela().getSelectedRow());

                janela.getTabela().revalidate();
            }

        } catch (Exception erro) {
            System.out.println(erro);
            JOptionPane.showMessageDialog(janela, "Selecione um item para remover", "Erro", 0);
        }

    }

}
