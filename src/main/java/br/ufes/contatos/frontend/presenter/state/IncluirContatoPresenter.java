package br.ufes.contatos.frontend.presenter.state;

import br.ufes.contatos.frontend.model.Contato;
import br.ufes.contatos.frontend.presenter.ManterContatoPresenter;
import br.ufes.contatos.frontend.view.ManterContatoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IncluirContatoPresenter extends ManterContatosState {

    public IncluirContatoPresenter(ManterContatoPresenter principal) {
        super(new ManterContatoView(), principal);

        ManterContatoView view = (ManterContatoView) this.getView();

        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }

        });

        view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = view.getTxtNome().getText();
                String telefone = view.getTxtTelefone().getText();

                salvar(new Contato(nome, telefone));
            }
        });

        view.setVisible(true);
    }

    @Override
    public void salvar(Contato contato) {
        ManterContatoView view = (ManterContatoView) this.getView();

        this.getContatoService().saveContato(contato);

        JOptionPane.showMessageDialog(view,
                "Contato " + contato.getNome() + " salvo com sucesso!",
                "Salvo com sucesso",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public void fechar() {
        this.getView().dispose();
    }

}
