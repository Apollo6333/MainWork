//André Luiz de Souza Nunes
//Arthur Henrique Damann
//João Vinícius Rosá

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private List<Advogado> advogados = new ArrayList<>();
    private List<Secretaria> secretarias = new ArrayList<>();
    private List<Pessoa> pessoas = new ArrayList<>();
    private List<Juridica> juridicas = new ArrayList<>();
    private List<Fisica> fisicas = new ArrayList<>();
    private List<Vara> varas = new ArrayList<>();
    private List<Tribunal> tribunais = new ArrayList<>();
    private List<Custo> custos = new ArrayList<>();
    private List<Audiencia> audiencias = new ArrayList<>();
    private Map<String, Processo> processos = new HashMap<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Senado Federal");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Advogados", createAdvogadoPanel());
        tabbedPane.addTab("Secretaria", createSecretariaPanel());
        tabbedPane.addTab("Pessoas", createPessoaPanel());
        tabbedPane.addTab("Juridicas", createJuridicaPanel());
        tabbedPane.addTab("Fisicas", createFisicaPanel());
        tabbedPane.addTab("Varas", createVaraPanel());
        tabbedPane.addTab("Tribunais", createTribunalPanel());
        tabbedPane.addTab("Custos", createCustoPanel());
        tabbedPane.addTab("Processos", createProcessoPanel());
        tabbedPane.addTab("Audiencias", createAudienciaPanel());

        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel createAdvogadoPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        DefaultListModel<String> advogadoListModel = new DefaultListModel<>();
        JList<String> advogadoList = new JList<>(advogadoListModel);

        JScrollPane scrollPane = new JScrollPane(advogadoList);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Advogado");
        JButton deleteButton = new JButton("Deleta Advogado");
        JButton listButton = new JButton("Listar Todos Advogados");
        JButton vincularProcessoButton = new JButton("Vincular Processo");
        JButton processosAdvogadoButton = new JButton("Processos do Advogado");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = JOptionPane.showInputDialog("Insira Login:");
                String senha = JOptionPane.showInputDialog("Insira senha:");
                String registroOAB = JOptionPane.showInputDialog("Insira o registro OAB:");

                Advogado advogado = new Advogado(login, senha, registroOAB);
                advogados.add(advogado);
                advogadoListModel.addElement(advogado.getLogin());
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = advogadoList.getSelectedIndex();
                if (selectedIndex != -1) {
                    advogados.remove(selectedIndex);
                    advogadoListModel.remove(selectedIndex);
                }
            }
        });

        vincularProcessoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vincularProcessoAdvogado();
            }
        });

        processosAdvogadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarProcessosAdvogado();
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarTodosAdvogados();
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(listButton);
        buttonPanel.add(vincularProcessoButton);
        buttonPanel.add(processosAdvogadoButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createSecretariaPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        DefaultListModel<String> secretariaListModel = new DefaultListModel<>();
        JList<String> secretariaList = new JList<>(secretariaListModel);

        JScrollPane scrollPane = new JScrollPane(secretariaList);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Secretaria");
        JButton deleteButton = new JButton("Deleta Secretaria");
        JButton listButton = new JButton("Listar Todos secretarios");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = JOptionPane.showInputDialog("Insira Login:");
                String senha = JOptionPane.showInputDialog("Insira senha:");
                String numeroCT = JOptionPane.showInputDialog("Insira o numero CT:");

                Secretaria secretaria = new Secretaria(login, senha, numeroCT);
                secretarias.add(secretaria);
                secretariaListModel.addElement(secretaria.getLogin());
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = secretariaList.getSelectedIndex();
                if (selectedIndex != -1) {
                    secretarias.remove(selectedIndex);
                    secretariaListModel.remove(selectedIndex);
                }
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarTodosSecretarios();
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(listButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createPessoaPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        DefaultListModel<String> pessoaListModel = new DefaultListModel<>();
        JList<String> pessoaList = new JList<>(pessoaListModel);

        JScrollPane scrollPane = new JScrollPane(pessoaList);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Pessoa");
        JButton deleteButton = new JButton("Deleta Pessoa");
        JButton listButton = new JButton("Listar Todas Pessoas");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Insira nome:");
                boolean isCliente = JOptionPane.showConfirmDialog(null, "É um cliente?", "Cliente confirmado",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

                Pessoa pessoa = new Pessoa(nome, isCliente);
                pessoas.add(pessoa);
                pessoaListModel.addElement(pessoa.getNome());
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = pessoaList.getSelectedIndex();
                if (selectedIndex != -1) {
                    pessoas.remove(selectedIndex);
                    pessoaListModel.remove(selectedIndex);
                }
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarTodasPessoas();
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(listButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createJuridicaPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        DefaultListModel<String> juridicaListModel = new DefaultListModel<>();
        JList<String> juridicaList = new JList<>(juridicaListModel);

        JScrollPane scrollPane = new JScrollPane(juridicaList);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Juridica");
        JButton deleteButton = new JButton("Deleta Juridica");
        JButton listButton = new JButton("Listar Todas Juridicas");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Insira nome:");
                boolean isCliente = JOptionPane.showConfirmDialog(null, "É um cliente?", "Cliente confirmado",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                String cnpj = JOptionPane.showInputDialog("Insira o CNPJ:");

                Juridica juridica = new Juridica(nome, isCliente, cnpj);
                juridicas.add(juridica);
                juridicaListModel.addElement(juridica.getNome());
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = juridicaList.getSelectedIndex();
                if (selectedIndex != -1) {
                    juridicas.remove(selectedIndex);
                    juridicaListModel.remove(selectedIndex);
                }
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarTodasJuridicas();
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(listButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createFisicaPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        DefaultListModel<String> fisicaListModel = new DefaultListModel<>();
        JList<String> fisicaList = new JList<>(fisicaListModel);

        JScrollPane scrollPane = new JScrollPane(fisicaList);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Fisica");
        JButton deleteButton = new JButton("Deleta Fisica");
        JButton listButton = new JButton("Listar Todas Fisicas");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Insira o nome:");
                boolean isCliente = JOptionPane.showConfirmDialog(null, "É um cliente?", "Cliente confirmado",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                String cpf = JOptionPane.showInputDialog("Insira o CPF:");

                Fisica fisica = new Fisica(nome, isCliente, cpf);
                fisicas.add(fisica);
                fisicaListModel.addElement(fisica.getNome());
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = fisicaList.getSelectedIndex();
                if (selectedIndex != -1) {
                    fisicas.remove(selectedIndex);
                    fisicaListModel.remove(selectedIndex);
                }
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarTodasFisicas();
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(listButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createVaraPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        DefaultListModel<String> varaListModel = new DefaultListModel<>();
        JList<String> varaList = new JList<>(varaListModel);

        JScrollPane scrollPane = new JScrollPane(varaList);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Vara");
        JButton deleteButton = new JButton("Deleta Vara");
        JButton listButton = new JButton("Listar Todas Varas");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Insira nome:");

                Vara vara = new Vara(nome);
                varas.add(vara);
                varaListModel.addElement(vara.getNome());
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = varaList.getSelectedIndex();
                if (selectedIndex != -1) {
                    varas.remove(selectedIndex);
                    varaListModel.remove(selectedIndex);
                }
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarTodasVaras();
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(listButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createTribunalPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        DefaultListModel<Tribunal> tribunalListModel = new DefaultListModel<>();
        JList<Tribunal> tribunalList = new JList<>(tribunalListModel);

        JScrollPane scrollPane = new JScrollPane(tribunalList);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Tribunal");
        JButton deleteButton = new JButton("Deleta Tribunal");
        JButton listButton = new JButton("Listar Todos Tribunais");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Insira nome:");

                if (nome != null && !nome.isEmpty()) {
                    Tribunal tribunal = new Tribunal(nome, new ArrayList<>());
                    tribunais.add(tribunal);
                    tribunalListModel.addElement(tribunal); // Adicione diretamente o objeto Tribunal
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = tribunalList.getSelectedIndex();

                if (selectedIndex != -1) {
                    tribunalListModel.remove(selectedIndex);
                }
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarTodosTribunais();
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(listButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createCustoPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        DefaultListModel<String> custoListModel = new DefaultListModel<>();
        JList<String> custoList = new JList<>(custoListModel);

        JScrollPane scrollPane = new JScrollPane(custoList);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Custo");
        JButton deleteButton = new JButton("Deleta Custo");
        JButton listButton = new JButton("Listar Todos Custos");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = JOptionPane.showInputDialog("Insira data (YYYY-MM-DD):");
                String descricao = JOptionPane.showInputDialog("Insira descricao:");
                double valor = Double.parseDouble(JOptionPane.showInputDialog("Insira valor:"));

                Custo custo = new Custo(data, descricao, valor);
                custos.add(custo);
                custoListModel.addElement(custo.getDescricao());
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = custoList.getSelectedIndex();
                if (selectedIndex != -1) {
                    custos.remove(selectedIndex);
                    custoListModel.remove(selectedIndex);
                }
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarTodosCustos();
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(listButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createProcessoPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        DefaultListModel<String> processoListModel = new DefaultListModel<>();
        JList<String> processoList = new JList<>(processoListModel);

        JScrollPane scrollPane = new JScrollPane(processoList);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add processo");
        JButton buscarProcessoButton = new JButton("Buscar Processo");
        JButton processosAndamentoButton = new JButton("Processos em Andamento");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(JOptionPane.showInputDialog("Insira o código do processo:"));
                String tribunalNome = JOptionPane.showInputDialog("Insira o nome do tribunal:");
                Tribunal tribunal = encontrarTribunalPorNome(tribunalNome);

                if (tribunal == null) {
                    JOptionPane.showMessageDialog(null, "Tribunal não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String descricao = JOptionPane.showInputDialog("Insira a descrição:");
                boolean concluido = JOptionPane.showConfirmDialog(null, "O processo está concluído?",
                        "Status do processo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

                // Solicitar secretaria
                String secretariaNome = JOptionPane.showInputDialog("Insira o nome da secretaria:");
                Usuario secretariaa = encontrarUsuarioPorNome(secretariaNome);

                if (secretariaa == null) {
                    JOptionPane.showMessageDialog(null, "Secretaria não encontrada.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Solicitar advogado responsável
                String advogadoNome = JOptionPane.showInputDialog("Insira o nome do advogado responsável:");
                Usuario aadvogadoResponsavel = encontrarUsuarioPorNome(advogadoNome);

                if (aadvogadoResponsavel == null || !(aadvogadoResponsavel instanceof Advogado)) {
                    JOptionPane.showMessageDialog(null, "Advogado responsável não encontrado.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Processo processo = new Processo(codigo, tribunal, descricao, secretariaa, aadvogadoResponsavel,
                        concluido);
                processos.put(Integer.toString(processo.getCodigo()), processo);
                processoListModel.addElement(Integer.toString(processo.getCodigo()));
            }
        });

        buscarProcessoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProcessoPorProtocolo();
            }
        });

        processosAndamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarProcessosEmAndamento();
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(buscarProcessoButton);
        buttonPanel.add(processosAndamentoButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private void buscarProcessoPorProtocolo() {
        String numeroProtocolo = JOptionPane.showInputDialog("Insira o número do protocolo do processo:");
        if (processos.containsKey(numeroProtocolo)) {
            Processo processo = processos.get(numeroProtocolo);
            // Exiba as informações do processo como preferir
            JOptionPane.showMessageDialog(null, "Processo encontrado:\nNúmero do Protocolo: " + processo.getCodigo() +
                    "\nTribunal: " + processo.getTribunal() + "\nDescrição: " + processo.getDescricao(),
                    "Processo Encontrado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Processo não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JPanel createAudienciaPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        DefaultListModel<String> audienciaListModel = new DefaultListModel<>();
        JList<String> audienciaList = new JList<>(audienciaListModel);

        JScrollPane scrollPane = new JScrollPane(audienciaList);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Audiencia");
        JButton deleteButton = new JButton("Deleta Audiencia");
        JButton listButton = new JButton("Listar Todas Audiencias");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = JOptionPane.showInputDialog("Insira data (YYYY-MM-DD):");
                String recomendacaoTribunal = JOptionPane.showInputDialog("Insira recomendacao de tribunal:");

                Audiencia audiencia = new Audiencia(data, recomendacaoTribunal);
                audiencias.add(audiencia);
                audienciaListModel.addElement(audiencia.getData());
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = audienciaList.getSelectedIndex();
                if (selectedIndex != -1) {
                    audiencias.remove(selectedIndex);
                    audienciaListModel.remove(selectedIndex);
                }
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarTodasAudiencias();
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(listButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private void listarTodosAdvogados() {
        StringBuilder lista = new StringBuilder();
        lista.append("Advogados:\n");
        for (Advogado advogado : advogados) {
            lista.append(advogado.getLogin()).append(", OAB: ").append(advogado.getRegistroOAB()).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString(), "Lista de Todos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void listarTodosSecretarios() {
        StringBuilder lista = new StringBuilder();
        lista.append("Secretarios:\n");
        for (Secretaria secretaria : secretarias) {
            lista.append(secretaria.getLogin()).append(", número CT: ").append(secretaria.getNumeroCT()).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString(), "Lista de Todos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void listarTodasPessoas() {
        StringBuilder lista = new StringBuilder();
        lista.append("\nPessoas:\n");
        for (Pessoa pessoa : pessoas) {
            lista.append(pessoa.getNome()).append(" (").append(pessoa.isCliente() ? "Cliente" : "Não Cliente")
                    .append(")\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString(), "Lista de Todos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void listarTodasJuridicas() {
        StringBuilder lista = new StringBuilder();
        lista.append("\nJuridicas:\n");
        for (Juridica juridica : juridicas) {
            lista.append(juridica.getNome()).append(" (").append(juridica.isCliente() ? "Cliente" : "Não Cliente")
                    .append("), CNPJ: ").append(juridica.getCnpj()).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString(), "Lista de Todos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void listarTodasFisicas() {
        StringBuilder lista = new StringBuilder();
        lista.append("\nFisicas:\n");
        for (Fisica fisica : fisicas) {
            lista.append(fisica.getNome()).append(" (").append(fisica.isCliente() ? "Cliente" : "Não Cliente")
                    .append("), CPF: ").append(fisica.getCpf()).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString(), "Lista de Todos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void listarTodasVaras() {
        StringBuilder lista = new StringBuilder();
        lista.append("\nVaras:\n");
        for (Vara vara : varas) {
            lista.append(vara.getNome()).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString(), "Lista de Todos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void listarTodosTribunais() {
        StringBuilder lista = new StringBuilder();
        lista.append("\nTribunais:\n");
        for (Tribunal tribunal : tribunais) {
            lista.append("Nome: " + tribunal.getNome()).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString(), "Lista de Todos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void listarTodosCustos() {
        StringBuilder lista = new StringBuilder();
        lista.append("\nCustos:\n");
        for (Custo custo : custos) {
            lista.append("Data: ").append(custo.getData()).append(", Descrição: ").append(custo.getDescricao())
                    .append(", Valor: ").append(custo.getValor()).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString(), "Lista de Todos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void listarProcessosEmAndamento() {
        String listaEmAndamento = montarListaEmAndamento();

        if (!listaEmAndamento.isEmpty()) {
            exibirMensagem("Processos em Andamento", listaEmAndamento, JOptionPane.INFORMATION_MESSAGE);
        } else {
            exibirMensagem("Aviso", "Não há processos em andamento.", JOptionPane.WARNING_MESSAGE);
        }
    }

    private String montarListaEmAndamento() {
        StringBuilder listaEmAndamento = new StringBuilder();
        listaEmAndamento.append("Processos em Andamento:\n");

        for (Processo processo : processos.values()) {
            if (!processo.isConcluido()) {
                listaEmAndamento.append("Número do Protocolo: ").append(processo.getCodigo())
                        .append(", Tribunal: ").append(processo.getTribunal())
                        .append(", Descrição: ").append(processo.getDescricao()).append("\n");
            }
        }

        return listaEmAndamento.toString();
    }

    private void exibirMensagem(String titulo, String mensagem, int tipoMensagem) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, tipoMensagem);
    }

    private void listarTodasAudiencias() {
        StringBuilder lista = new StringBuilder();
        lista.append("\nAudiências:\n");
        for (Audiencia audiencia : audiencias) {
            lista.append("Data: ").append(audiencia.getData()).append(", Recomendação Tribunal: ")
                    .append(audiencia.getRecomendacaoTribunal()).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString(), "Lista de Todos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void vincularProcessoAdvogado() {
        // Solicitar número do protocolo
        String numeroProtocolo = JOptionPane.showInputDialog("Insira o número do protocolo do processo:");

        // Verificar se o processo existe no mapa
        if (processos.containsKey(numeroProtocolo)) {
            // Solicitar OAB do advogado
            String registroOAB = JOptionPane.showInputDialog("Insira o registro OAB do advogado:");

            // Encontrar advogado correspondente ao OAB
            Advogado advogado = encontrarAdvogadoPorOAB(registroOAB);

            // Verificar se o advogado existe
            if (advogado != null) {
                // Vincular processo ao advogado
                Processo processo = processos.get(numeroProtocolo);
                advogado.vincularProcesso(processo);

                JOptionPane.showMessageDialog(null, "Processo vinculado ao advogado com sucesso.", "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Advogado não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Processo não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Advogado encontrarAdvogadoPorOAB(String registroOAB) {
        for (Advogado advogado : advogados) {
            if (advogado.getRegistroOAB().equals(registroOAB)) {
                return advogado;
            }
        }
        return null;
    }

    private void listarProcessosAdvogado() {
        // Solicitar OAB do advogado
        String registroOAB = JOptionPane.showInputDialog("Insira o registro OAB do advogado:");

        // Encontrar advogado correspondente ao OAB
        Advogado advogado = encontrarAdvogadoPorOAB(registroOAB);

        // Verificar se o advogado existe
        if (advogado != null) {
            // Obter lista de processos vinculados ao advogado
            List<Processo> processosAdvogado = advogado.getProcessosVinculados();

            // Construir mensagem com os processos
            StringBuilder mensagem = new StringBuilder("Processos vinculados ao advogado:\n");
            for (Processo processo : processosAdvogado) {
                mensagem.append("Número do Protocolo: ").append(processo.getCodigo()).append("\n");
            }

            JOptionPane.showMessageDialog(null, mensagem.toString(), "Processos do Advogado",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Advogado não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Tribunal encontrarTribunalPorNome(String nome) {
        for (Tribunal tribunal : tribunais) {
            if (tribunal.getNome().equals(nome)) {
                return tribunal;
            }
        }
        return null;
    }

    private Usuario encontrarUsuarioPorNome(String nome) {
        for (Advogado advogado : advogados) {
            if (advogado.getLogin().equals(nome)) {
                return advogado;
            }
        }
        for (Secretaria secretaria : secretarias) {
            if (secretaria.getLogin().equals(nome)) {
                return secretaria;
            }
        }
        return null;
    }
}
