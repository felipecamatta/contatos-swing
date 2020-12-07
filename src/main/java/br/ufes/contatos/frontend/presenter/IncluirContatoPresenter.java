package br.ufes.contatos.frontend.presenter;

import br.ufes.contatos.frontend.model.Contato;
import br.ufes.contatos.frontend.view.IncluirContatoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IncluirContatoPresenter extends ManterContatosState{


    public IncluirContatoPresenter(ManterContatoPresenter principal) {
        super(new IncluirContatoView(), principal);
        
        IncluirContatoView view = (IncluirContatoView) this.getView();

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
    public void fechar() {
        this.getView().dispose();
    }

    @Override
    public void salvar(Contato contato) {
        IncluirContatoView view = (IncluirContatoView) this.getView();
        

        this.getContatoService().saveContato(contato);
        //contatos.add(contato);

        JOptionPane.showMessageDialog(view,
                "Contato " + contato.getNome() + " salvo com sucesso!",
                "Salvo com sucesso",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void excluir(Contato contato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
