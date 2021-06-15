package dadostratados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Assunto;
import modelos.Editora;
import modelos.Livro;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rober
 */
public class LivrosDadosTratados {
    private Connection con;
    
    public LivrosDadosTratados(){
        this.con = new ConexaoJavaBanco().getConnection();
    }
    
    //Inserir Livro no banco de dados
    public void salvar(Livro livro){
        
        try{
            
            String sql = "insert into tb_livros(titulo, data_public, preco, num_pag"
                    + " assunto_id, editora_id, ISBN)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getDataPublic());
            stmt.setDouble(3, livro.getPreco());
            stmt.setInt(4, livro.getNumPag());
            stmt.setInt(5, livro.getAssunto().getId());
            stmt.setInt(6, livro.getEditora().getId());
            stmt.setString(7, livro.getISBN());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cadastrado!");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro: "+e);
        }
        
    }
    
    public Livro pesquisarISBN(String ISBN){
        
        try{
            
            String sql = "select * from tb_livros where ISBN = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, ISBN);
            ResultSet rs = stmt.executeQuery();
            
            Livro objLi = new Livro();
            if(rs.next()){
                objLi.setId(rs.getInt("id"));
                objLi.setTitulo(rs.getString("titulo"));
                                                
                SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");
                String dataBr = formatoBr.format(rs.getDate("data_public"));
                objLi.setDataPublic(dataBr);
                
                objLi.setPreco(rs.getDouble("preco"));
                objLi.setNumPag(rs.getInt("num_pag"));
                objLi.setISBN(rs.getString("ISBN"));
                
                Assunto objAs = new Assunto();
                Editora objEd = new Editora();
                
                objAs.setId(rs.getInt("assunto_id"));
                objEd.setId(rs.getInt("editora_id"));
                
                objLi.setAssunto(objAs);
                objLi.setEditora(objEd);
                
            }
            return objLi;
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro: "+e);
            return null;
        }
        
    }
    
    public List<Livro> listarPorTitulo(String titulo){
        List<Livro> lista = new ArrayList();
        
        try{
            
            String sql = "select L.id, L.titulo, L.data_public, L.preco, L.num_pag, "
                    + "L.ISBN, E.nome from tb_livros as L "                    
                    + "inner join tb_editoras as E on (L.editora_id = E.id) "
                    + "where L.titulo like ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, titulo);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Livro objLi = new Livro();
                Editora objEd = new Editora();
                
                objLi.setId(rs.getInt("L.id"));
                objLi.setTitulo(rs.getString("L.titulo"));
                objLi.setDataPublic(rs.getString("L.data_public"));
                objLi.setPreco(rs.getDouble("L.preco"));
                objLi.setNumPag(rs.getInt("L.num_pag"));
                objLi.setISBN(rs.getString("L.ISBN"));
                
                objEd.setNome(rs.getString("E.nome"));
                objLi.setEditora(objEd);
                
                lista.add(objLi);
            }
            return lista;
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro: "+e);
            return null;
        }
    }
}
