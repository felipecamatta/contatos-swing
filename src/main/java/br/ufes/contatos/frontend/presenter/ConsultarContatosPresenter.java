package br.ufes.contatos.frontend.presenter;

import br.ufes.contatos.frontend.presenter.state.RemoverContatoPresenter;
import br.ufes.contatos.frontend.presenter.state.ManterContatosState;
import br.ufes.contatos.frontend.collection.ContatoCollection;
import br.ufes.contatos.frontend.model.Contato;
import br.ufes.contatos.frontend.presenter.state.EdicaoContatoPresenter;
import br.ufes.contatos.frontend.view.ConsultarContatosView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

public class ConsultarContatosPresenter extends ManterContatosState {
    
    private ContatoCollection contatos;
    private DefaultTableModel tmContatos;
    
    public ConsultarContatosPresenter(ManterContatoPresenter principal) {
        super(new ConsultarContatosView(), principal);
        this.contatos = this.getContatoService().getContatos();
        
        ConsultarContatosView view = (ConsultarContatosView) this.getView();
        
        tmContatos = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Nome", "Telefone"}
        );
        
        this.preencheTabela(view);
        
        view.getTblContatos().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });
        
        view.getBtnExcluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int posicao = view.getTblContatos().getSelectedRow();
                excluir(contatos.getContatos().get(posicao));
            }
        });
        
        view.setVisible(true);
    }
    
    @Override
    public void fechar() {
        this.getView().dispose();
    }
    
    private void preencheTabela(ConsultarContatosView view) {
        tmContatos.setNumRows(0);
        ListIterator<Contato> it = contatos.getContatos().listIterator();
        
        while (it.hasNext()) {
            Contato contato = it.next();
            tmContatos.addRow(new Object[]{contato.getNome(), contato.getTelefone()});
        }
        
        view.getTblContatos().setModel(tmContatos);
    }
    
    @Override
    public void editar(Contato contato) {
        this.getControlador().setEstado(new EdicaoContatoPresenter(this.getControlador()));
    }
    
    @Override
    public void excluir(Contato contato) {
        this.getControlador().setEstado(new RemoverContatoPresenter(this.getView(), contato, this.getControlador()));
    }
    
}
