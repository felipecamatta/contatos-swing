package br.ufes.contatos.frontend.presenter;

import br.ufes.contatos.frontend.collection.ContatoCollection;
import br.ufes.contatos.frontend.model.Contato;
import br.ufes.contatos.frontend.view.ConsultarContatosView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

public class ConsultarContatosPresenter {

    private ConsultarContatosView view;
    private ContatoCollection contatos;
    private DefaultTableModel tmContatos;

    public ConsultarContatosPresenter(ContatoCollection contatos) {
        this.contatos = contatos;

        view = new ConsultarContatosView();

        tmContatos = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Nome", "Telefone"}
        );

        view.getTblContatos().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        tmContatos.setNumRows(0);
        ListIterator<Contato> it = contatos.getContatos().listIterator();

        while (it.hasNext()) {
            Contato contato = it.next();
            tmContatos.addRow(new Object[]{contato.getNome(), contato.getTelefone()});
        }

        view.getTblContatos().setModel(tmContatos);

        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });

      
        view.setVisible(true);

    }

    private void fechar() {
        view.dispose();
    }

}
