/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.contatos.frontend.presenter;

import br.ufes.contatos.frontend.model.Contato;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
public class RemoverContatoPresenter extends ManterContatosState{

    public RemoverContatoPresenter(JFrame view, Contato contato, ManterContatoPresenter principal) {
        super(view, principal);
        this.excluir(contato);
        JOptionPane.showMessageDialog(view, "Contato de "+contato.getNome()+ " excluido com sucesso!", "Excluir Contato", 0);
        principal.setEstado(new ConsultarContatosPresenter(principal));
        this.fechar();
        
    }

    @Override
    public void salvar(Contato contato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fechar() {
        this.getView().dispose();
    }

    @Override
    public void excluir(Contato contato) {
        this.getContatoService().deleteContato(contato);
    }
    
}
