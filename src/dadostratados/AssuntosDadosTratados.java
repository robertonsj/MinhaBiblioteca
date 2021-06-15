/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dadostratados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Assunto;

/**
 *
 * @author rober
 */
public class AssuntosDadosTratados {

    private Connection con;

    public AssuntosDadosTratados() {
        this.con = new ConexaoJavaBanco().getConnection();
    }

    //Inserir novo tipo de assunto para livros
    public void salvar(Assunto assunto) {
        try {
            String sql = "insert into tb_assuntos(assunto) values(?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, assunto.getAssunto());
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado(a)!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

    }

    public void excluir(int id) {
        try {
            String sql = "delete from tb_assuntos where id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluído(a)!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Retornar uma lista de Objs contendo os dados de autores e seus livros
    public List<Assunto> listarTodos() {
        List<Assunto> lista = new ArrayList<>();
        try {

            String sql = "select * from tb_assuntos";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Assunto objAs = new Assunto();

                objAs.setId(rs.getInt("id"));
                objAs.setAssunto(rs.getString("assunto"));

                lista.add(objAs);
            }

            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de sql: " + e);
            return null;
        }

    }

    public Assunto pesquisarAssuntoComQtd(String assunto) {
        try {
            String sql = "select A.id, A.assunto, count(L.titulo) as qtd from tb_livros as L "
                    + "inner join tb_assuntos as A on (L.assunto_id = A.id) "
                    + "where A.assunto = ?"
                    + "group by Assunto";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, assunto);
            ResultSet rs = stmt.executeQuery();

            Assunto as = new Assunto();
            if (rs.next()) {

                as.setId(rs.getInt("A.id"));
                as.setAssunto(rs.getString("A.assunto"));
                as.setQtdLivros(rs.getInt("qtd"));

            } else {
                as = pesquisarAssuntoSemQtd(assunto);
                //JOptionPane.showMessageDialog(null, "Não há registro de livro associado ao assunto!");
            }

            return as;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e);
            return null;
        }

    }

    public Assunto pesquisarAssuntoSemQtd(String assunto) {
        try {
            String sql = "select * from tb_assuntos where assunto = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, assunto);
            ResultSet rs = stmt.executeQuery();

            Assunto as = new Assunto();
            if (rs.next()) {

                as.setId(rs.getInt("id"));
                as.setAssunto(rs.getString("assunto"));
                as.setQtdLivros(0);
            }
            return as;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e);
            return null;
        }
    }

}
