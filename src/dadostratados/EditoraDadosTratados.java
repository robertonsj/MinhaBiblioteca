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
import modelos.Editora;

/**
 *
 * @author rober
 */
public class EditoraDadosTratados {

    private Connection con;

    public EditoraDadosTratados() {
        this.con = new ConexaoJavaBanco().getConnection();
    }

    //salvar editora no banco de dados
    public void salvar(Editora editora) {
        try {
            String sql = "insert into tb_editoras(nome, cnpj) values(?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, editora.getNome());
            stmt.setString(2, editora.getCNPJ());
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Editora cadastrada!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

    }

    //pesquisar editora por CNPJ
    public Editora pesquisarPorCNPJ(String cnpj) {

        try {

            String sql = "select * from tb_editoras where cnpj = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cnpj);

            ResultSet rs = stmt.executeQuery();

            Editora objEd = new Editora();
            if (rs.next()) {

                objEd.setId(rs.getInt("id"));
                objEd.setNome(rs.getString("nome"));
                objEd.setCNPJ(rs.getString("cnpj"));
            }
            return objEd;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }

    }

    //atualizar dados de uma editora
    public void atualizar(Editora editora) {
        try {
            String sql = "update tb_editoras set nome=?, cnpj=? where id=?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, editora.getNome());
            stmt.setString(2, editora.getCNPJ());
            stmt.setInt(3, editora.getId());
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Dados atualizados!");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //excluir editora do banco de dados    
    public void excluir(int id) {
        try {
            String sql = "delete from tb_editoras where id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Editora deletada!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //listar editoras registradas no banco
    public List<Editora> listarTodas() {
        List<Editora> lista = new ArrayList<>();
        try {

            String sql = "select * from tb_editoras";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Editora objEd = new Editora();
                objEd.setId(rs.getInt("id"));
                objEd.setNome(rs.getString("nome"));
                objEd.setCNPJ(rs.getString("cnpj"));

                lista.add(objEd);
            }

            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }

    }
    
    public List<Editora> listarPorNome(String nome) {
        List<Editora> lista = new ArrayList<>();
        try {

            String sql = "select * from tb_editoras where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Editora objEd = new Editora();
                objEd.setId(rs.getInt("id"));
                objEd.setNome(rs.getString("nome"));
                objEd.setCNPJ(rs.getString("cnpj"));

                lista.add(objEd);
            }

            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }

    }

}
