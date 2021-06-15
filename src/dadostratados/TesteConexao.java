/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dadostratados;

import javax.swing.JOptionPane;

/**
 *
 * @author rober
 */
public class TesteConexao {

    public static void main(String[] args) {
        try {
            new ConexaoJavaBanco().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

    }

}
