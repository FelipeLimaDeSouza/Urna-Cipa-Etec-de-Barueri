/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.CandidatoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utilitarios.Conexao;

/**
 *
 * @author user
 */
public class CandidatoDAO {
    
    Connection con = null;
    
    public CandidatoDAO () throws ClassNotFoundException{
    
        con = Conexao.abrirConexao();
        
    }
    
    public int retornaDaoEleicao(){
    
        int retorna = 0;
        
        String sql = "SELECT * FROM tb_eleicao where eleicao_data >= CURDATE() "
                + "and eleicao_status = 1 ORDER BY eleicao_data asc limit 1";
    
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            rs.last();
            
            if(rs.getRow() == 1){
            
                retorna = rs.getInt("eleicao_id");
            
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return retorna;
        
    }
    
    public int votarDao(int numero, int alu_id, int ele_id){
    
        int retorna = 0;
        
        String sql = "INSERT INTO tb_voto(eleicao_id_voto, aluno_id_voto, voto_voto)"
                + "VALUES(?, ?, ?)";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, ele_id);
            ps.setInt(2, alu_id);
            ps.setInt(3, numero);
            
            ps.executeUpdate();
            
            retorna = 1;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return retorna;
    
    }
    
    public CandidatoBean selecionaDaoCandidato(String chapa, int eleicao){
        
        CandidatoBean cb = new CandidatoBean();
        
        int retorna = verificaDaoCandidato(chapa, eleicao);
        
        if(retorna == 1){

            String sql = "SELECT * FROM tb_candidato WHERE candidato_chapa = ? AND eleicao_id_candidato = ?";

            try {

                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, chapa);
                ps.setInt(2, eleicao);

                ResultSet rs = ps.executeQuery();

                rs.next();

                cb.setId(rs.getInt("aluno_id_candidato"));
                cb.setImagem(rs.getString("candidato_foto"));
                cb.setNome(rs.getString("candidato_apelido"));

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }else{
        
            cb = null;
        
        }
        return cb;
    }
    
    public int verificaDaoCandidato(String chapa, int eleicao){
    
        int retorna = 0;
        
        String sql = "SELECT * FROM tb_candidato WHERE candidato_chapa = ? AND eleicao_id_candidato = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, chapa);
            ps.setInt(2, eleicao);
            
            ResultSet rs = ps.executeQuery();
            
            rs.last();
            
            if(rs.getRow()>0){
            
                retorna = 1;
            
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return retorna;
    
    }
    
    
}
