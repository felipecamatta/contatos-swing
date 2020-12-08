/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.contatos.frontend.presenter.command;

import br.ufes.contatos.frontend.model.Contato;
import br.ufes.contatos.frontend.service.ContatoService;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
public class ExcluirCommand implements ICommandPresenter{

    private Contato contato;
    private ContatoService contatoService;
    private JFrame view;

    public ExcluirCommand(Contato contato, ContatoService contatoService, JFrame view) {
        this.contato = contato;
        this.contatoService = contatoService;
        this.view = view;
    }
    
    
    
    @Override
    public void executar() {
        excluir();
    }
    
    private void excluir(){
        try{
            this.contatoService.deleteContato(contato);
            JOptionPane.showMessageDialog(view,
                "Contato " + contato.getNome() + " removido com sucesso!",
                "Exclusão concluida",
                JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(view,e.getMessage(),
                "Erro na exclusão",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
