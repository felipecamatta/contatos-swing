package br.ufes.contatos.frontend.view;

import javax.swing.*;

public class PrincipalView extends JFrame {

    public PrincipalView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mbPrincipal = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemIncluir = new javax.swing.JMenuItem();
        itemConsultar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestão de Contatos");

        jMenu1.setText("Opções");

        itemIncluir.setText("Incluir contatos");
        jMenu1.add(itemIncluir);

        itemConsultar.setText("Consultar contatos");
        jMenu1.add(itemConsultar);

        mbPrincipal.add(jMenu1);

        setJMenuBar(mbPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 739, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JMenuItem getItemConsultar() {
        return itemConsultar;
    }

    public JMenuItem getItemIncluir() {
        return itemIncluir;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemConsultar;
    private javax.swing.JMenuItem itemIncluir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar mbPrincipal;
    // End of variables declaration//GEN-END:variables
}
