package br.ufes.contatos.frontend.presenter;

import br.ufes.contatos.frontend.collection.ContatoCollection;
import br.ufes.contatos.frontend.model.Contato;
import br.ufes.contatos.frontend.service.ContatoService;
import br.ufes.contatos.frontend.view.ManterContatoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManterContatoPresenter {

    private ManterContatoView view;
    private ContatoCollection contatos;
    private ContatoService contatoService = new ContatoService();

    public ManterContatoPresenter(ContatoCollection contatos) {
        this.contatos = contatos;
        view = new ManterContatoView();

        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }

        });

        view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvar();
            }
        });

        view.setVisible(true);
    }

    private void fechar() {
        view.dispose();
    }

    private void salvar() {
        String nome = view.getTxtNome().getText();
        String telefone = view.getTxtTelefone().getText();

        Contato contato = new Contato(nome, telefone);

        contatoService.saveContato(contato);
        //contatos.add(contato);

        JOptionPane.showMessageDialog(view,
                "Contato " + contato.getNome() + " salvo com sucesso!",
                "Salvo com sucesso",
                JOptionPane.INFORMATION_MESSAGE);
    }

}
