package br.ufes.contatos.frontend.presenter;

import br.ufes.contatos.frontend.collection.ContatoCollection;
import br.ufes.contatos.frontend.model.Contato;
import br.ufes.contatos.frontend.presenter.state.ManterPresenter;
import br.ufes.contatos.frontend.service.ContatoService;
import br.ufes.contatos.frontend.view.ConsultarContatosView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

public class ConsultarContatosPresenter {
    
    private ConsultarContatosView view;
    private ContatoCollection contatos;
    private ContatoService contatoService; 
    private DefaultTableModel tmContatos;
    
    public ConsultarContatosPresenter(PrincipalPresenter principal) {
        this.view = new ConsultarContatosView();
        this.contatoService = new ContatoService();
        this.contatos = this.contatoService.getContatos();
        
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
                excluir(getContatoTabela());
            }
        });
        
        view.getBtnAlterar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManterPresenter(getContatoTabela());
            }
        });
        
        
        view.setVisible(true);
    }
    
    public void fechar() {
        this.view.dispose();
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
    
    private Contato getContatoTabela(){
        int posicao = view.getTblContatos().getSelectedRow();
        return contatos.getContatos().get(posicao);
    }
    
    private void excluir(Contato contato){
        this.contatoService.deleteContato(contato);
    }
    
}
