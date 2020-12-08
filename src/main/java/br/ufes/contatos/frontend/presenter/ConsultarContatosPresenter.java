package br.ufes.contatos.frontend.presenter;

import br.ufes.contatos.frontend.collection.ContatoCollection;
import br.ufes.contatos.frontend.model.Contato;
import br.ufes.contatos.frontend.presenter.command.EditarCommand;
import br.ufes.contatos.frontend.presenter.command.ExcluirCommand;
import br.ufes.contatos.frontend.service.ContatoService;
import br.ufes.contatos.frontend.view.ConsultarContatosView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;
import br.ufes.contatos.frontend.presenter.command.ICommandPresenter;

public class ConsultarContatosPresenter extends Observador{
    
    private ConsultarContatosView view;
    private ContatoCollection contatos;
    private ContatoService contatoService; 
    private DefaultTableModel tmContatos;
    private ICommandPresenter command;
    
    public ConsultarContatosPresenter(PrincipalPresenter principal) {
        this.view = new ConsultarContatosView();
        this.contatoService = new ContatoService();
        this.contatos = this.contatoService.getContatos();
        
        tmContatos = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Nome", "Telefone"}
        );
        
        this.preencheTabela();
        
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
                command = new ExcluirCommand(getContatoTabela(), contatoService, view);
                command.executar();
                preencheTabela();
            }
        });
        
        ConsultarContatosPresenter propria = this;  //Apenas para o action listener encontrar essa instância da classe 
        view.getBtnAlterar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                command = new EditarCommand(getContatoTabela(), propria);
                command.executar();
                preencheTabela();
            }
        });
                
        view.setVisible(true);
    }
    
    public void fechar() {
        this.view.dispose();
    }
    
    private void preencheTabela() {
        tmContatos.setNumRows(0);
        contatos = contatoService.getContatos();
        ListIterator<Contato> it = contatos.getContatos().listIterator();
        
        while (it.hasNext()) {
            Contato contato = it.next();
            tmContatos.addRow(new Object[]{contato.getNome(), contato.getTelefone()});
        }
        
        this.view.getTblContatos().setModel(tmContatos);
    }
    
    private Contato getContatoTabela(){
        int posicao = view.getTblContatos().getSelectedRow();
        return contatos.getContatos().get(posicao);
    }

    @Override
    public void atualizar() {
        this.preencheTabela();
    }

}
