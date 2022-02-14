/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.controller;

import br.ufjf.dcc.artur.trabalho.model.Dependente;
import br.ufjf.dcc.artur.trabalho.model.Financiamento;
import br.ufjf.dcc.artur.trabalho.model.GastoRendaMensal;
import br.ufjf.dcc.artur.trabalho.view.JanelaEdicao;
import br.ufjf.dcc.artur.trabalho.view.JanelaGastos;
import br.ufjf.dcc.artur.trabalho.view.JanelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * Artur Welerson Sott Meyer - 202065552C
 */
public class AdicionarItem implements ActionListener {

    private JanelaEdicao janela;
    private JanelaPrincipal janelaPrincipal;
    private JanelaGastos janelaGastos;

    private String tipo;

    public AdicionarItem(JanelaEdicao janela) {
        this.janela = janela;
    }

    public AdicionarItem(JanelaPrincipal janelaPrincipal, JanelaGastos janelaGastos) {
        this.janelaPrincipal = janelaPrincipal;
        this.janelaGastos = janelaGastos;
        this.tipo = "GastoDependente";
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            DefaultTableModel tblModel = null;
            if (janela != null) {
                tblModel = (DefaultTableModel) (janela.getTabela().getModel());
            }

            if (janela != null && janela.getTipoInformacao().equals("Gastos")) {

                String[] dados = {
                    janela.getJanelaPrincipal().getTxtNomeGasto().getText(),
                    "R$" + janela.getJanelaPrincipal().getTxtValorGasto().getText(),
                    janela.getJanelaPrincipal().getTxtDuracaoGasto().getText() + " meses"
                };

                janela.getJanelaPrincipal().getAdm().adicionarGasto(janela.getJanelaPrincipal().getTxtNomeGasto().getText(), Float.parseFloat(janela.getJanelaPrincipal().getTxtValorGasto().getText()), Integer.parseInt(janela.getJanelaPrincipal().getTxtDuracaoGasto().getText()));
                DefaultTableModel tblModelGastos = (DefaultTableModel) (janela.getJanelaPrincipal().getTblGastos().getModel());
                tblModelGastos.addRow(dados);
                janela.getJanelaPrincipal().getTblGastos().revalidate();
                tblModel.addRow(dados);

            } else if (janela != null && janela.getTipoInformacao().equals("Rendas")) {

                String[] dados = {janela.getJanelaPrincipal().getTxtNomeRenda().getText(),
                    "R$" + janela.getJanelaPrincipal().getTxtValorRenda().getText(),
                    janela.getJanelaPrincipal().getTxtDuracaoRenda().getText() + " meses"
                };

                janela.getJanelaPrincipal().getAdm().adicionarRenda(
                        janela.getJanelaPrincipal().getTxtNomeRenda().getText(),
                        Float.parseFloat(janela.getJanelaPrincipal().getTxtValorRenda().getText()),
                        Integer.parseInt(janela.getJanelaPrincipal().getTxtDuracaoRenda().getText())
                );

                DefaultTableModel tblModelRendas = (DefaultTableModel) (janela.getJanelaPrincipal().getTblRendas().getModel());
                tblModelRendas.addRow(dados);
                janela.getJanelaPrincipal().getTblRendas().revalidate();
                tblModel.addRow(dados);

            } else if (janela != null && janela.getTipoInformacao().equals("Dependentes")) {

                float totalGastos = 0;

                for (GastoRendaMensal el : janela.getJanelaPrincipal().getListaGastosDependente()) {
                    totalGastos += el.getValor();
                }

                DefaultTableModel tblModelInfo = (DefaultTableModel) janela.getJanelaPrincipal().getTblGastosDependente().getModel();

                tblModelInfo.setRowCount(0);

                janela.getTblInfo().revalidate();

                totalGastos += Float.parseFloat(janela.getJanelaPrincipal().getTxtMesadaDependente().getText());

                String codigo = janela.getJanelaPrincipal().getAdm().adicionarDependente(
                        janela.getJanelaPrincipal().getTxtNomeDepentendete().getText(),
                        Float.parseFloat(janela.getJanelaPrincipal().getTxtMesadaDependente().getText()),
                        janela.getJanelaPrincipal().getListaGastosDependente()
                );

                String[] dados = {janela.getJanelaPrincipal().getTxtNomeDepentendete().getText(),
                    "R$" + totalGastos,
                    codigo
                };

                DefaultTableModel tblModelDependentes = (DefaultTableModel) (janela.getJanelaPrincipal().getTblDependentes().getModel());
                tblModelDependentes.addRow(dados);
                janela.getJanelaPrincipal().getTblDependentes().revalidate();
                janela.getJanelaPrincipal().getTblGastosDependente().removeAll();
                tblModel.addRow(dados);

            } else if (janela != null && janela.getTipoInformacao().equals("Funcionarios")) {

                String codigo = janela.getJanelaPrincipal().getAdm().adicionarFuncionario(
                        janela.getJanelaPrincipal().getTxtNomeFuncionario().getText(),
                        Float.parseFloat(janela.getJanelaPrincipal().getTxtSalarioFuncionario().getText()),
                        Integer.parseInt(janela.getJanelaPrincipal().getTxtDuracaoFuncionario().getText()));

                String[] dados = {janela.getJanelaPrincipal().getTxtNomeFuncionario().getText(),
                    "R$" + janela.getJanelaPrincipal().getTxtSalarioFuncionario().getText(),
                    janela.getJanelaPrincipal().getTxtDuracaoFuncionario().getText() + " meses", codigo};

                DefaultTableModel tblModelFuncionarios = (DefaultTableModel) (janela.getJanelaPrincipal().getTblFuncionarios().getModel());
                tblModelFuncionarios.addRow(dados);
                janela.getJanelaPrincipal().getTblFuncionarios().revalidate();
                tblModel.addRow(dados);

            } else if (janela != null && janela.getTipoInformacao().equals("Financiamentos")) {

                int tipoJuros = 0;
                String txtJuros = "";

                if (janela.getJanelaPrincipal().getJurosComposto().isSelected()) {
                    tipoJuros = 2;
                    txtJuros = "Juros Composto";
                    if (janela.getJanelaPrincipal().getTxtJurosFinanciamento().getText().equals("0")) {
                        JOptionPane.showMessageDialog(janela, "Juros não pode ser 0!", "Erro", 0);
                        throw new Exception();
                    }
                } else if (janela.getJanelaPrincipal().getJurosSimples().isSelected()) {
                    tipoJuros = 1;
                    txtJuros = "Juros Simples";
                    if (janela.getJanelaPrincipal().getTxtJurosFinanciamento().getText().equals("0")) {
                        JOptionPane.showMessageDialog(janela, "Juros não pode ser 0!", "Erro", 0);
                        throw new Exception();
                    }
                } else if (janela.getJanelaPrincipal().getSemJuros().isSelected()) {
                    tipoJuros = 0;
                    txtJuros = "Sem Juros";
                    janela.getJanelaPrincipal().getTxtJurosFinanciamento().setText("0");
                }

                Financiamento novoFinanciamento = janela.getJanelaPrincipal().getAdm().adicionarFinanciamento(
                        janela.getJanelaPrincipal().getTxtNomeFinanciamento().getText(),
                        Float.parseFloat(janela.getJanelaPrincipal().getTxtValorFinanciamento().getText()),
                        Integer.parseInt(janela.getJanelaPrincipal().getTxtDuracaoFinanciamento().getText()),
                        Float.parseFloat(janela.getJanelaPrincipal().getTxtJurosFinanciamento().getText()),
                        tipoJuros);

                String[] dados = {
                    janela.getJanelaPrincipal().getTxtNomeFinanciamento().getText(),
                    "R$" + janela.getJanelaPrincipal().getTxtValorFinanciamento().getText(),
                    janela.getJanelaPrincipal().getTxtJurosFinanciamento().getText() + "%",
                    txtJuros,
                    "R$ " + Float.toString(novoFinanciamento.getValorParcelas()),
                    janela.getJanelaPrincipal().getTxtDuracaoFinanciamento().getText() + " meses"};

                DefaultTableModel tblModelFinanciamentos = (DefaultTableModel) (janela.getJanelaPrincipal().getTblFinanciamentos().getModel());
                tblModelFinanciamentos.addRow(dados);
                janela.getJanelaPrincipal().getTblFinanciamentos().revalidate();
                tblModel.addRow(dados);

            } else if (janela != null && janela.getTipoInformacao().equals("Investimentos")) {

                int tipoJuros = 0;
                String txtJuros = "";

                if (janela.getJanelaPrincipal().getTxtJurosInvestimento().getText().equals("0")) {
                    throw new Exception();
                }

                if (janela.getJanelaPrincipal().getJurosCompostoInvestimento().isSelected()) {
                    tipoJuros = 2;
                    txtJuros = "Juros Composto";
                } else if (janela.getJanelaPrincipal().getJurosSimplesInvestimento().isSelected()) {
                    tipoJuros = 1;
                    txtJuros = "Juros Simples";
                }

                janela.getJanelaPrincipal().getAdm().adicionarInvestimento(
                        janela.getJanelaPrincipal().getTxtNomeInvestimento().getText(),
                        Float.parseFloat(janela.getJanelaPrincipal().getTxtValorInvestimento().getText()),
                        Float.parseFloat(janela.getJanelaPrincipal().getTxtJurosInvestimento().getText()),
                        tipoJuros);

                String[] dados = {
                    janela.getJanelaPrincipal().getTxtNomeInvestimento().getText(),
                    "R$" + janela.getJanelaPrincipal().getTxtValorInvestimento().getText(),
                    janela.getJanelaPrincipal().getTxtJurosInvestimento().getText() + "%",
                    txtJuros};

                DefaultTableModel tblModelFinanciamentos = (DefaultTableModel) (janela.getJanelaPrincipal().getTblInvestimentos().getModel());
                tblModelFinanciamentos.addRow(dados);
                janela.getJanelaPrincipal().getTblInvestimentos().revalidate();
                tblModel.addRow(dados);

            } else if (tipo.equals("GastoDependente")) {

                String[] dados = {
                    janelaGastos.getTxtNome().getText(),
                    "R$" + janelaGastos.getTxtValor().getText(),
                    janelaGastos.getTxtDuracao().getText() + " meses"
                };

                janelaPrincipal.getListaGastosDependente().add(new GastoRendaMensal(
                        janelaGastos.getTxtNome().getText(),
                        Float.parseFloat(janelaGastos.getTxtValor().getText()),
                        Integer.parseInt(janelaGastos.getTxtDuracao().getText()))
                );

                DefaultTableModel tblModelGastos = (DefaultTableModel) (janelaPrincipal.getTblGastosDependente().getModel());
                tblModelGastos.addRow(dados);
                janelaPrincipal.getTblGastosDependente().revalidate();
                janelaGastos.setVisible(false);

            }

            if (janela != null) {
                janela.getTabela().revalidate();
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(janela, "Erro ao adicionar item!", "Erro", 0);
        }

    }

}
