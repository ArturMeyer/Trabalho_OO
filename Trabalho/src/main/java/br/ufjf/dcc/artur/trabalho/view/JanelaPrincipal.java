/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.artur.trabalho.view;

import br.ufjf.dcc.artur.trabalho.controller.AbrirJanelaGastos;
import br.ufjf.dcc.artur.trabalho.controller.AdicionarItem;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import br.ufjf.dcc.artur.trabalho.controller.ArquivoController;
import br.ufjf.dcc.artur.trabalho.controller.AtualizarDados;
import br.ufjf.dcc.artur.trabalho.controller.JSON;
import br.ufjf.dcc.artur.trabalho.model.Administrador;
import br.ufjf.dcc.artur.trabalho.controller.NovoAdministrador;
import br.ufjf.dcc.artur.trabalho.controller.LoginAdministrador;
import br.ufjf.dcc.artur.trabalho.controller.RemoverItem;
import br.ufjf.dcc.artur.trabalho.model.Administrador;
import br.ufjf.dcc.artur.trabalho.model.Dependente;
import br.ufjf.dcc.artur.trabalho.model.Funcionario;
import br.ufjf.dcc.artur.trabalho.model.GastoRendaMensal;
import br.ufjf.dcc.artur.trabalho.model.Financiamento;
import br.ufjf.dcc.artur.trabalho.model.Investimento;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Artur Welerson Sott Meyer - 202065552C
 */
public class JanelaPrincipal extends JFrame {

    private Administrador adm;
    private JTextField txtNome;
    private JTextField txtSenha;
    private JTextField txtSaldo;

    private Dependente dep;

    private Funcionario func;

    private JTabbedPane tabPainel;

    private JTable tblGastos;
    private JTable tblRendas;
    private JTable tblDependentes;
    private JTable tblFuncionarios;
    private JTable tblFinanciamentos;
    private JTable tblInvestimentos;

    private TableModel tblModelGastos;
    private TableModel tblModelRendas;
    private TableModel tblModelDependentes;
    private TableModel tblModelFuncionarios;
    private TableModel tblModelFinanciamentos;
    private TableModel tblModelInvestimentos;

    private TextField txtNomeGasto;
    private TextField txtValorGasto;
    private TextField txtDuracaoGasto;

    private TextField txtNomeRenda;
    private TextField txtValorRenda;
    private TextField txtDuracaoRenda;

    private TextField txtNomeFuncionario;
    private TextField txtSalarioFuncionario;
    private TextField txtDuracaoFuncionario;

    private TextField txtNomeFinanciamento;
    private TextField txtValorFinanciamento;
    private TextField txtJurosFinanciamento;
    private TextField txtDuracaoFinanciamento;
    private JRadioButton jurosSimples;
    private JRadioButton jurosComposto;
    private JRadioButton semJuros;

    private TextField txtNomeInvestimento;
    private TextField txtValorInvestimento;
    private TextField txtJurosInvestimento;
    private JRadioButton jurosSimplesInvestimento;
    private JRadioButton jurosCompostoInvestimento;

    private TextField txtNomeDepentendete;
    private TextField txtMesadaDependente;

    private JTable tblGastosDependente;

    private JButton btnAdicionarGasto;
    private JButton btnRemoverGasto;

    private List<GastoRendaMensal> listaGastosDependente;

    public JanelaPrincipal(Administrador adm) {
        super("Organizador Financeiro");
        this.adm = adm;
    }

    public JanelaPrincipal(Administrador adm, Dependente dep) {
        super("Organizador Financeiro");
        this.adm = adm;
        this.dep = dep;
    }

    public JanelaPrincipal(Administrador adm, Funcionario func) {
        super("Organizador Financeiro");
        this.adm = adm;
        this.func = func;
    }

    public void mostrar() {
        //this.setResizable(false);

        this.setLocation(0, 0);

        tabPainel = new JTabbedPane();
        this.add(tabPainel);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        if (func == null) {
            mostrarTabelas();
        } else {
            mostrarDadosFuncionário();
        }
        if (dep != null) {
            mostrarDadosDependente();
        } else if (func == null) {
            mostrarNovoGasto();
            mostrarNovaRenda();
            mostrarNovoDependente();
            mostrarNovoFuncionario();
            mostrarNovoFinanciamento();
            mostrarNovoInvetimento();
            mostrarSaldoFuturo();
            mostrarEditarDados();
        }
        pack();
        this.setVisible(true);

    }

    public void mostrarTabelas() {

        JPanel painelTabelas = new JPanel();

        painelTabelas.setLayout(new GridLayout(0, 3));

        tabPainel.add("Tabelas", painelTabelas);

        tblGastos = mostrarTabelaGastos();
        JScrollPane scrlGastos = new JScrollPane(tblGastos);
        scrlGastos.setBorder(BorderFactory.createTitledBorder("Gastos"));

        painelTabelas.add(scrlGastos);

        tblRendas = mostrarTabelaRendas();
        DefaultTableModel tblModelRendas = (DefaultTableModel) (tblRendas.getModel());
        JScrollPane scrlRendas = new JScrollPane(tblRendas);
        scrlRendas.setBorder(BorderFactory.createTitledBorder("Rendas"));

        painelTabelas.add(scrlRendas);

        tblDependentes = mostrarTabelaDependentes();
        DefaultTableModel tblModelDependentes = (DefaultTableModel) (tblDependentes.getModel());
        JScrollPane scrlDependentes = new JScrollPane(tblDependentes);
        scrlDependentes.setBorder(BorderFactory.createTitledBorder("Dependentes"));

        painelTabelas.add(scrlDependentes);

        tblFuncionarios = mostrarTabelaFuncionarios();
        DefaultTableModel tblModelFuncionarios = (DefaultTableModel) (tblFuncionarios.getModel());
        JScrollPane scrlFuncionarios = new JScrollPane(tblFuncionarios);
        scrlFuncionarios.setBorder(BorderFactory.createTitledBorder("Funcionários"));

        painelTabelas.add(scrlFuncionarios);

        tblFinanciamentos = mostrarTabelaFinanciamentos();
        DefaultTableModel tblModelFinanciamentos = (DefaultTableModel) (tblFinanciamentos.getModel());
        JScrollPane scrlFinanciamentos = new JScrollPane(tblFinanciamentos);
        scrlFinanciamentos.setBorder(BorderFactory.createTitledBorder("Financiamentos"));

        painelTabelas.add(scrlFinanciamentos);

        tblInvestimentos = mostrarTabelaInvestimentos();
        DefaultTableModel tblModelInvestimento = (DefaultTableModel) (tblInvestimentos.getModel());
        JScrollPane scrlInvestimentos = new JScrollPane(tblInvestimentos);
        scrlInvestimentos.setBorder(BorderFactory.createTitledBorder("Investimentos"));

        painelTabelas.add(scrlInvestimentos);

    }

    public void mostrarNovoGasto() {

        JanelaEdicao pnlGasto = new JanelaEdicao(mostrarTabelaGastos(), this, "Gastos");

        pnlGasto.setPreferredSize(new Dimension(260, 400));

        JPanel pnlInfos = new JPanel();

        txtNomeGasto = new TextField(30);
        JLabel lblNome = new JLabel("Nome");
        lblNome.setPreferredSize(new Dimension(50, 20));
        pnlInfos.add(lblNome);
        pnlInfos.add(txtNomeGasto);

        txtValorGasto = new TextField(30);
        JLabel lblValor = new JLabel("Valor");
        lblValor.setPreferredSize(new Dimension(50, 20));
        pnlInfos.add(lblValor);
        pnlInfos.add(txtValorGasto);

        txtDuracaoGasto = new TextField(30);
        JLabel lblDuracao = new JLabel("Duração");
        lblDuracao.setPreferredSize(new Dimension(50, 20));
        pnlInfos.add(lblDuracao);
        pnlInfos.add(txtDuracaoGasto);

        pnlInfos.setPreferredSize(new Dimension(310, 200));

        pnlInfos.setBorder(BorderFactory.createSoftBevelBorder(0));

        pnlGasto.getContainer().add(pnlInfos);

        tabPainel.add("Gastos", pnlGasto);

        pnlGasto.mostrar();
    }

    public void mostrarNovaRenda() {

        JanelaEdicao pnlRenda = new JanelaEdicao(mostrarTabelaRendas(), this, "Rendas");

        pnlRenda.setPreferredSize(new Dimension(260, 400));

        JPanel pnlInfos = new JPanel();

        txtNomeRenda = new TextField(30);
        JLabel lblNome = new JLabel("Nome");
        lblNome.setPreferredSize(new Dimension(50, 20));
        pnlInfos.add(lblNome);
        pnlInfos.add(txtNomeRenda);

        txtValorRenda = new TextField(30);
        JLabel lblValor = new JLabel("Valor");
        lblValor.setPreferredSize(new Dimension(50, 20));
        pnlInfos.add(lblValor);
        pnlInfos.add(txtValorRenda);

        txtDuracaoRenda = new TextField(30);
        JLabel lblDuracao = new JLabel("Duração");
        lblDuracao.setPreferredSize(new Dimension(50, 20));
        pnlInfos.add(lblDuracao);
        pnlInfos.add(txtDuracaoRenda);

        pnlInfos.setPreferredSize(new Dimension(310, 200));

        pnlInfos.setBorder(BorderFactory.createSoftBevelBorder(0));

        pnlRenda.getContainer().add(pnlInfos);

        tabPainel.add("Rendas", pnlRenda);

        pnlRenda.mostrar();
    }

    public void mostrarNovoDependente() {

        JanelaEdicao pnlDependentes = new JanelaEdicao(mostrarTabelaDependentes(), this, "Dependentes");

        pnlDependentes.setPreferredSize(new Dimension(260, 400));

        JPanel pnlInfos = new JPanel();

        txtNomeDepentendete = new TextField(30);
        JLabel lblNome = new JLabel("Nome");
        lblNome.setPreferredSize(new Dimension(50, 20));
        pnlInfos.add(lblNome);
        pnlInfos.add(txtNomeDepentendete);

        txtMesadaDependente = new TextField(30);
        JLabel lblValor = new JLabel("Mesada");
        lblValor.setPreferredSize(new Dimension(50, 20));
        pnlInfos.add(lblValor);
        pnlInfos.add(txtMesadaDependente);

        listaGastosDependente = new ArrayList<>();

        JPanel painelBtn = new JPanel();

        painelBtn.setLayout(new GridLayout(0, 2));

        btnAdicionarGasto = new JButton("Adicionar Gasto");
        btnAdicionarGasto.addActionListener(new AbrirJanelaGastos(this));
        painelBtn.add(btnAdicionarGasto);

        btnRemoverGasto = new JButton("Remover Gasto");
        btnRemoverGasto.addActionListener(new RemoverItem(this));
        painelBtn.add(btnRemoverGasto);

        tblGastosDependente = new JTable();
        DefaultTableModel tblModel = (DefaultTableModel) tblGastosDependente.getModel();
        tblModel.addColumn("Nome");
        tblModel.addColumn("Valor");
        tblModel.addColumn("Duração");
        JScrollPane scrll = new JScrollPane(tblGastosDependente);
        scrll.setPreferredSize(new Dimension(300, 100));
        scrll.setBorder(BorderFactory.createTitledBorder("Gastos"));
        pnlInfos.add(scrll);

        pnlInfos.setPreferredSize(new Dimension(310, 200));

        pnlInfos.setBorder(BorderFactory.createSoftBevelBorder(0));

        JScrollPane scrllInfo = new JScrollPane(pnlInfos);

        pnlDependentes.getContainer().add(scrllInfo);

        pnlInfos.add(painelBtn);

        tabPainel.add("Dependentes", pnlDependentes);

        pnlDependentes.mostrar();
    }

    public void mostrarNovoFuncionario() {

        JanelaEdicao pnlRenda = new JanelaEdicao(mostrarTabelaFuncionarios(), this, "Funcionarios");

        pnlRenda.setPreferredSize(new Dimension(260, 400));

        JPanel pnlInfos = new JPanel();

        txtNomeFuncionario = new TextField(30);
        JLabel lblNome = new JLabel("Nome");
        lblNome.setPreferredSize(new Dimension(50, 20));
        pnlInfos.add(lblNome);
        pnlInfos.add(txtNomeFuncionario);

        txtSalarioFuncionario = new TextField(30);
        JLabel lblValor = new JLabel("Salário");
        lblValor.setPreferredSize(new Dimension(50, 20));
        pnlInfos.add(lblValor);
        pnlInfos.add(txtSalarioFuncionario);

        txtDuracaoFuncionario = new TextField(30);
        JLabel lblDuracao = new JLabel("Duração");
        lblDuracao.setPreferredSize(new Dimension(50, 20));
        pnlInfos.add(lblDuracao);
        pnlInfos.add(txtDuracaoFuncionario);

        pnlInfos.setPreferredSize(new Dimension(310, 200));

        pnlInfos.setBorder(BorderFactory.createSoftBevelBorder(0));

        pnlRenda.getContainer().add(pnlInfos);

        tabPainel.add("Funcionarios", pnlRenda);

        pnlRenda.mostrar();
    }

    public void mostrarNovoFinanciamento() {

        JanelaEdicao pnlRenda = new JanelaEdicao(mostrarTabelaFinanciamentos(), this, "Financiamentos");

        pnlRenda.setPreferredSize(new Dimension(260, 400));

        JPanel pnlInfos = new JPanel();

        txtNomeFinanciamento = new TextField(30);
        JLabel lblNome = new JLabel("Nome");
        lblNome.setPreferredSize(new Dimension(50, 20));
        pnlInfos.add(lblNome);
        pnlInfos.add(txtNomeFinanciamento);

        txtValorFinanciamento = new TextField(30);
        JLabel lblValor = new JLabel("Valor");
        lblValor.setPreferredSize(new Dimension(50, 20));
        pnlInfos.add(lblValor);
        pnlInfos.add(txtValorFinanciamento);

        txtJurosFinanciamento = new TextField(30);
        JLabel lblJuros = new JLabel("Juros");
        lblJuros.setPreferredSize(new Dimension(50, 20));
        pnlInfos.add(lblJuros);
        pnlInfos.add(txtJurosFinanciamento);

        jurosSimples = new JRadioButton("Simples", false);
        jurosComposto = new JRadioButton("Composto", false);
        semJuros = new JRadioButton("Sem Juros", true);

        ButtonGroup radioBtns = new ButtonGroup();
        radioBtns.add(jurosSimples);
        radioBtns.add(jurosComposto);
        radioBtns.add(semJuros);

        JPanel pnlRadios = new JPanel();
        pnlRadios.add(jurosSimples);
        pnlRadios.add(jurosComposto);
        pnlRadios.add(semJuros);

        txtDuracaoFinanciamento = new TextField(30);
        JLabel lblDuracao = new JLabel("Duracao");
        lblDuracao.setPreferredSize(new Dimension(50, 20));
        pnlInfos.add(lblDuracao);
        pnlInfos.add(txtDuracaoFinanciamento);

        pnlInfos.add(pnlRadios);

        pnlInfos.setPreferredSize(new Dimension(310, 200));

        pnlInfos.setBorder(BorderFactory.createSoftBevelBorder(0));

        pnlRenda.getContainer().add(pnlInfos);

        tabPainel.add("Financiamentos", pnlRenda);

        pnlRenda.mostrar();
    }

    public void mostrarNovoInvetimento() {

        JanelaEdicao pnlRenda = new JanelaEdicao(mostrarTabelaInvestimentos(), this, "Investimentos");

        pnlRenda.setPreferredSize(new Dimension(260, 400));

        JPanel pnlInfos = new JPanel();

        txtNomeInvestimento = new TextField(30);
        JLabel lblNome = new JLabel("Nome");
        lblNome.setPreferredSize(new Dimension(50, 20));
        pnlInfos.add(lblNome);
        pnlInfos.add(txtNomeInvestimento);

        txtValorInvestimento = new TextField(30);
        JLabel lblValor = new JLabel("Valor");
        lblValor.setPreferredSize(new Dimension(50, 20));
        pnlInfos.add(lblValor);
        pnlInfos.add(txtValorInvestimento);

        txtJurosInvestimento = new TextField(30);
        JLabel lblJuros = new JLabel("Juros");
        lblJuros.setPreferredSize(new Dimension(50, 20));
        pnlInfos.add(lblJuros);
        pnlInfos.add(txtJurosInvestimento);

        jurosSimplesInvestimento = new JRadioButton("Simples", true);
        jurosCompostoInvestimento = new JRadioButton("Composto", false);

        ButtonGroup radioBtns = new ButtonGroup();
        radioBtns.add(jurosSimplesInvestimento);
        radioBtns.add(jurosCompostoInvestimento);

        JPanel pnlRadios = new JPanel();
        pnlRadios.add(jurosSimplesInvestimento);
        pnlRadios.add(jurosCompostoInvestimento);

        pnlInfos.add(pnlRadios);

        pnlInfos.setPreferredSize(new Dimension(310, 200));

        pnlInfos.setBorder(BorderFactory.createSoftBevelBorder(0));

        pnlRenda.getContainer().add(pnlInfos);

        tabPainel.add("Investimento", pnlRenda);

        pnlRenda.mostrar();
    }

    public void mostrarDadosDependente() {

        try {
            JPanel pnlMain = new JPanel();

            JTable tblDep = new JTable();
            DefaultTableModel tblModel = (DefaultTableModel) tblDep.getModel();
            tblModel.addColumn("Nome");
            tblModel.addColumn("Valor");
            tblModel.addColumn("Duração");

            if (dep.getGastos() != null) {
                for (GastoRendaMensal el : dep.getGastos()) {
                    String[] dados = {el.getNome(), Float.toString(el.getValor()), Integer.toString(el.getDuracao())};
                    tblModel.addRow(dados);
                }
            }

            JPanel pnl = new JPanel();
            pnl.setBorder(BorderFactory.createTitledBorder("Informações"));

            JLabel lblNome = new JLabel("Nome: " + dep.getNome());
            JLabel lblValor = new JLabel("Mesada: R$ " + Float.toString(dep.getMesada()));
            JLabel lblDuracao = new JLabel("Código: " + dep.getCodigo());

            pnl.add(lblNome);
            pnl.add(lblValor);
            pnl.add(lblDuracao);

            pnl.setPreferredSize(new Dimension(300, 440));

            lblNome.setPreferredSize(new Dimension(280, 30));
            lblValor.setPreferredSize(new Dimension(280, 30));
            lblDuracao.setPreferredSize(new Dimension(280, 30));

            pnlMain.add(pnl);

            JScrollPane scrll = new JScrollPane(tblDep);
            scrll.setBorder(BorderFactory.createTitledBorder("Gastos"));

            pnlMain.add(scrll);

            tabPainel.add("Dados Dependente", pnlMain);
        } catch (Exception e) {
        }

    }

    public void mostrarDadosFuncionário() {

        try {
            JPanel pnlMain = new JPanel();

            JPanel pnl = new JPanel();
            pnl.setBorder(BorderFactory.createTitledBorder("Informações"));

            JLabel lblNome = new JLabel("Nome: " + func.getNome());
            JLabel lblValor = new JLabel("Salário: R$ " + Float.toString(func.getSalario()));
            JLabel lblDuracao = new JLabel("Código: " + func.getCodigo());

            pnl.add(lblNome);
            pnl.add(lblValor);
            pnl.add(lblDuracao);

            pnl.setPreferredSize(new Dimension(300, 200));

            lblNome.setPreferredSize(new Dimension(280, 30));
            lblValor.setPreferredSize(new Dimension(280, 30));
            lblDuracao.setPreferredSize(new Dimension(280, 30));

            pnlMain.add(pnl);

            tabPainel.add("Dados Funcionário", pnlMain);
        } catch (Exception e) {
        }

    }

    public void mostrarEditarDados() {

        try {
            JPanel pnlMain = new JPanel();

            JPanel pnl = new JPanel();
            pnl.setBorder(BorderFactory.createTitledBorder("Dados"));

            JLabel lblNome = new JLabel("Nome: ");
            JLabel lblSenha = new JLabel("Senha: ");
            JLabel lblSaldo = new JLabel("Saldo: ");

            txtNome = new JTextField(20);
            txtSenha = new JTextField(20);
            txtSaldo = new JTextField(20);
            txtNome.setText(adm.getNome());
            txtSenha.setText(adm.getSenha());
            txtSaldo.setText(Float.toString(adm.getSaldo()));

            pnl.add(lblNome);
            pnl.add(txtNome);

            pnl.add(lblSenha);
            pnl.add(txtSenha);

            pnl.add(lblSaldo);
            pnl.add(txtSaldo);

            pnl.setPreferredSize(new Dimension(300, 150));

            lblNome.setPreferredSize(new Dimension(55, 30));
            lblSenha.setPreferredSize(new Dimension(55, 30));
            lblSaldo.setPreferredSize(new Dimension(55, 30));

            JButton botao = new JButton("Atualizar Dados");
            botao.addActionListener(new AtualizarDados(this));

            pnlMain.add(pnl);
            pnlMain.add(botao);

            tabPainel.add("Dados Administrador", pnlMain);
        } catch (Exception e) {
        }

    }

    public void mostrarSaldoFuturo() {

        JanelaCalculos janelaSaldoFuturo = new JanelaCalculos(this);

        janelaSaldoFuturo.mostrar();

        tabPainel.add("Calcular Saldo Futuro", janelaSaldoFuturo);

    }

    public JTable mostrarTabelaGastos() {

        JTable tblNovoGasto = new JTable(tblModelGastos);

        DefaultTableModel tblModelGastos = (DefaultTableModel) (tblNovoGasto.getModel());
        JScrollPane scrlGastos = new JScrollPane(tblNovoGasto);
        scrlGastos.setBorder(BorderFactory.createTitledBorder("Gastos"));

        tblModelGastos.addColumn("Nome");
        tblModelGastos.addColumn("Valor");
        tblModelGastos.addColumn("Duração");

        try {
            for (GastoRendaMensal el : adm.getGastos()) {

                String[] dados = {el.getNome(), "R$ " + Float.toString(el.getValor()), Integer.toString(el.getDuracao()) + " meses"};

                tblModelGastos.addRow(dados);
            }
        } catch (Exception e) {
        }

        return tblNovoGasto;

    }

    public JTable mostrarTabelaDependentes() {

        JTable tblNovoDependentes = new JTable(tblModelDependentes);

        DefaultTableModel tblModelDependentes = (DefaultTableModel) (tblNovoDependentes.getModel());
        JScrollPane scrlGastos = new JScrollPane(tblNovoDependentes);
        scrlGastos.setBorder(BorderFactory.createTitledBorder("Dependentes"));

        tblModelDependentes.addColumn("Nome");
        tblModelDependentes.addColumn("Valor");
        tblModelDependentes.addColumn("Código");

        try {
            for (Dependente el : adm.getDependentes().values()) {

                String[] dados = {el.getNome(), "R$ " + Float.toString(el.getMesada() + el.getGastoTotal()), el.getCodigo()};

                tblModelDependentes.addRow(dados);
            }

        } catch (Exception e) {
        }

        return tblNovoDependentes;

    }

    public JTable mostrarTabelaRendas() {

        JTable tblNovaRenda = new JTable(tblModelRendas);

        DefaultTableModel tblModelRendas = (DefaultTableModel) (tblNovaRenda.getModel());
        JScrollPane scrlGastos = new JScrollPane(tblNovaRenda);
        scrlGastos.setBorder(BorderFactory.createTitledBorder("Rendas"));

        tblModelRendas.addColumn("Nome");
        tblModelRendas.addColumn("Valor");
        tblModelRendas.addColumn("Duração");

        try {
            for (GastoRendaMensal el : adm.getRendas()) {

                String[] dados = {el.getNome(), "R$ " + Float.toString(el.getValor()), Integer.toString(el.getDuracao()) + " meses"};

                tblModelRendas.addRow(dados);
            }
        } catch (Exception e) {
        }

        return tblNovaRenda;

    }

    public JTable mostrarTabelaFuncionarios() {

        JTable tblNovoFuncionario = new JTable(tblModelFuncionarios);

        DefaultTableModel tblModelFuncionarios = (DefaultTableModel) (tblNovoFuncionario.getModel());
        JScrollPane scrlGastos = new JScrollPane(tblNovoFuncionario);
        scrlGastos.setBorder(BorderFactory.createTitledBorder("Funcionários"));

        tblModelFuncionarios.addColumn("Nome");
        tblModelFuncionarios.addColumn("Salário");
        tblModelFuncionarios.addColumn("Duração");
        tblModelFuncionarios.addColumn("Código");

        try {
            for (Funcionario el : adm.getFuncionarios().values()) {

                String[] dados = {el.getNome(), "R$ " + Float.toString(el.getSalario()), Integer.toString(el.getDuracao()) + " meses", el.getCodigo()};

                tblModelFuncionarios.addRow(dados);
            }
        } catch (Exception e) {
        }

        return tblNovoFuncionario;
    }

    public JTable mostrarTabelaFinanciamentos() {

        JTable tblNovoFuncionario = new JTable(tblModelFuncionarios);

        DefaultTableModel tblModelFinanciamentos = (DefaultTableModel) (tblNovoFuncionario.getModel());
        JScrollPane scrlGastos = new JScrollPane(tblNovoFuncionario);
        scrlGastos.setBorder(BorderFactory.createTitledBorder("Funcionários"));

        tblModelFinanciamentos.addColumn("Nome");
        tblModelFinanciamentos.addColumn("Valor");
        tblModelFinanciamentos.addColumn("Juros");
        tblModelFinanciamentos.addColumn("Tipo");
        tblModelFinanciamentos.addColumn("Parcelas");
        tblModelFinanciamentos.addColumn("Duração");

        try {
            for (Financiamento el : adm.getFinanciamentos()) {

                String tipoJuros = "";
                if (el.getTipoJuros() == 0) {
                    tipoJuros = "Sem Juros";
                } else if (el.getTipoJuros() == 1) {
                    tipoJuros = "Juros Simples";
                } else {
                    tipoJuros = "Juros Composto";
                }

                String[] dados = {el.getNome(), "R$ " + Float.toString(el.getValor()), Float.toString(el.getJuros() * 100) + "%", tipoJuros, "R$" + Float.toString(el.getValorParcelas()), Integer.toString(el.getDuracao()) + " meses"};

                tblModelFinanciamentos.addRow(dados);
            }

        } catch (Exception e) {
        }

        return tblNovoFuncionario;
    }

    public JTable mostrarTabelaInvestimentos() {

        JTable tblNovoFuncionario = new JTable(tblModelFuncionarios);

        DefaultTableModel tblModelInvestimento = (DefaultTableModel) (tblNovoFuncionario.getModel());
        JScrollPane scrlGastos = new JScrollPane(tblNovoFuncionario);
        scrlGastos.setBorder(BorderFactory.createTitledBorder("Investimentos"));

        tblModelInvestimento.addColumn("Nome");
        tblModelInvestimento.addColumn("Valor");
        tblModelInvestimento.addColumn("Juros");
        tblModelInvestimento.addColumn("Tipo");

        try {
            for (Investimento el : adm.getInvestimentos()) {

                String tipoJuros = "";
                if (el.getTipoJuros() == 1) {
                    tipoJuros = "Juros Simples";
                } else {
                    tipoJuros = "Juros Composto";
                }

                String[] dados = {el.getNome(), "R$ " + Float.toString(el.getValor()), Float.toString(el.getJuros() * 100) + "%", tipoJuros};

                tblModelInvestimento.addRow(dados);
            }
        } catch (Exception e) {
        }

        return tblNovoFuncionario;
    }

    public Administrador getAdm() {
        return adm;
    }

    public JTabbedPane getTabPainel() {
        return tabPainel;
    }

    public JTable getTblGastos() {
        return tblGastos;
    }

    public JTable getTblRendas() {
        return tblRendas;
    }

    public JTable getTblDependentes() {
        return tblDependentes;
    }

    public JTable getTblFuncionarios() {
        return tblFuncionarios;
    }

    public JTable getTblFinanciamentos() {
        return tblFinanciamentos;
    }

    public TableModel getTblModelGastos() {
        return tblModelGastos;
    }

    public TableModel getTblModelRendas() {
        return tblModelRendas;
    }

    public TableModel getTblModelDependentes() {
        return tblModelDependentes;
    }

    public TableModel getTblModelFuncionarios() {
        return tblModelFuncionarios;
    }

    public TableModel getTblModelFinanciamentos() {
        return tblModelFinanciamentos;
    }

    public TextField getTxtNomeGasto() {
        return txtNomeGasto;
    }

    public TextField getTxtValorGasto() {
        return txtValorGasto;
    }

    public TextField getTxtDuracaoGasto() {
        return txtDuracaoGasto;
    }

    public TextField getTxtNomeRenda() {
        return txtNomeRenda;
    }

    public TextField getTxtValorRenda() {
        return txtValorRenda;
    }

    public TextField getTxtDuracaoRenda() {
        return txtDuracaoRenda;
    }

    public TextField getTxtNomeDepentendete() {
        return txtNomeDepentendete;
    }

    public TextField getTxtMesadaDependente() {
        return txtMesadaDependente;
    }

    public JTable getTblGastosDependente() {
        return tblGastosDependente;
    }

    public List<GastoRendaMensal> getListaGastosDependente() {
        return listaGastosDependente;
    }

    public TextField getTxtNomeFuncionario() {
        return txtNomeFuncionario;
    }

    public TextField getTxtSalarioFuncionario() {
        return txtSalarioFuncionario;
    }

    public TextField getTxtDuracaoFuncionario() {
        return txtDuracaoFuncionario;
    }

    public TextField getTxtNomeFinanciamento() {
        return txtNomeFinanciamento;
    }

    public TextField getTxtValorFinanciamento() {
        return txtValorFinanciamento;
    }

    public TextField getTxtJurosFinanciamento() {
        return txtJurosFinanciamento;
    }

    public TextField getTxtDuracaoFinanciamento() {
        return txtDuracaoFinanciamento;
    }

    public JRadioButton getJurosSimples() {
        return jurosSimples;
    }

    public JRadioButton getJurosComposto() {
        return jurosComposto;
    }

    public JRadioButton getSemJuros() {
        return semJuros;
    }

    public JTable getTblInvestimentos() {
        return tblInvestimentos;
    }

    public TableModel getTblModelInvestimentos() {
        return tblModelInvestimentos;
    }

    public TextField getTxtNomeInvestimento() {
        return txtNomeInvestimento;
    }

    public TextField getTxtValorInvestimento() {
        return txtValorInvestimento;
    }

    public TextField getTxtJurosInvestimento() {
        return txtJurosInvestimento;
    }

    public JRadioButton getJurosSimplesInvestimento() {
        return jurosSimplesInvestimento;
    }

    public JRadioButton getJurosCompostoInvestimento() {
        return jurosCompostoInvestimento;
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTxtSenha() {
        return txtSenha;
    }

    public JTextField getTxtSaldo() {
        return txtSaldo;
    }

}
