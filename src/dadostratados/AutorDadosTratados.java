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
import modelos.Autor;
import modelos.Editora;
import modelos.Livro;
import modelos.LivrosAutores;

/**
 *
 * @author rober
 */
public class AutorDadosTratados {
    private Connection con;
    
    public AutorDadosTratados(){
        this.con = new ConexaoJavaBanco().getConnection();
    }
    
    public void salvar(Autor autor) {
        try {
            String sql = "insert into tb_autores(nome, nacionalidade) values(?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, autor.getNome());
            stmt.setString(2, autor.getNacionalidade());
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado(a)!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

    }
    
    public void excluir(int id) {
        try {
            String sql = "delete from tb_autores where id=?";
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
    public List<LivrosAutores> listarAutoresLivros() {
        List<LivrosAutores> lista = new ArrayList<>();
        try {

            String sql = "select A.id as Id, A.nome as Autor, L.titulo as Título "
                    + "from tb_livrosautores as LA "
                    + "inner join tb_autores as A on (LA.autor_id = A.id) "
                    + "inner join tb_livros as L on (LA.livro_id = L.id)";
            
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Livro objLi = new Livro();
                Autor objAu = new Autor();
                LivrosAutores objLA = new LivrosAutores();
                                
                objAu.setId(rs.getInt("Id"));
                objAu.setNome(rs.getString("Autor"));                
                objLi.setTitulo(rs.getString("Título"));
                
                objLA.setAutor(objAu);
                objLA.setLivro(objLi);

                lista.add(objLA);
            }

            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de sql: " + e);
            return null;
        }

    }
    
    //Exibir autor(es) e título(s) a partir do nome do autor ou parte dele;
    public List<LivrosAutores> listarPorNome(String nome) {
        List<LivrosAutores> lista = new ArrayList<>();
        try {

            String sql = "select A.id as Id, A.nome as Autor, L.titulo as Título "
                    + "from tb_livrosautores as LA "
                    + "inner join tb_autores as A on (LA.autor_id = A.id) "
                    + "inner join tb_livros as L on (LA.livro_id = L.id) "
                    + "where A.nome like ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Livro objLi = new Livro();
                Autor objAu = new Autor();
                LivrosAutores objLA = new LivrosAutores();
                                
                objAu.setId(rs.getInt("Id"));
                objAu.setNome(rs.getString("Autor"));                
                objLi.setTitulo(rs.getString("Título"));
                
                objLA.setAutor(objAu);
                objLA.setLivro(objLi);

                lista.add(objLA);
            }

            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de sql: " + e);
            return null;
        }

    }
    
    //Exibir autor(es) e título a partir do ISBN da obra;
    public List<LivrosAutores> listarPorISBN(String ISBN) {
        List<LivrosAutores> lista = new ArrayList<>();
        try {

            String sql = "select A.id as Id, A.nome as Autor, L.titulo as Título "
                    + "from tb_livrosautores as LA "
                    + "inner join tb_autores as A on (LA.autor_id = A.id) "
                    + "inner join tb_livros as L on (LA.livro_id = L.id) "
                    + "where L.ISBN like ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, ISBN);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Livro objLi = new Livro();
                Autor objAu = new Autor();
                LivrosAutores objLA = new LivrosAutores();
                                
                objAu.setId(rs.getInt("Id"));
                objAu.setNome(rs.getString("Autor"));                
                objLi.setTitulo(rs.getString("Título"));
                
                objLA.setAutor(objAu);
                objLA.setLivro(objLi);

                lista.add(objLA);
            }

            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de sql: " + e);
            return null;
        }

    }
    
    public Autor pesquisarPorNome(String nome){
        
        try{
            
            String sql = "select * from tb_autores where nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            Autor objAu = new Autor();
            if(rs.next()){                
                objAu.setId(rs.getInt("id"));
                objAu.setNome(rs.getString("nome"));
                objAu.setNacionalidade(rs.getString("nacionalidade"));                
            }
            return objAu;
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+e);
            return null;
        }
        
    }
    
}
