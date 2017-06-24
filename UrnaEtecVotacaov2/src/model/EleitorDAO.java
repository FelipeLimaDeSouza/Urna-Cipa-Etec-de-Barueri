/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utilitarios.Conexao;

/**
 *
 * @author user
 */
public class EleitorDAO {
    
    Connection con = null;
    
    public EleitorDAO () throws ClassNotFoundException{
    
        con = Conexao.abrirConexao();
        
    }
    
    public int validaDaoCpf(String cpf){
    
        int retorna = 0;
        
        String sql = "SELECT * FROM tb_aluno WHERE aluno_cpf = ? AND aluno_status = 1";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, cpf);
            
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
    
    public int retornaDaoId(String cpf){
    
        int retorna = 0;
        
        String sql = "SELECT * FROM tb_aluno WHERE aluno_cpf = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, cpf);
            
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            
            retorna = rs.getInt("aluno_id");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return retorna;
    
    }
    
    public int validaDaoVoto(int aluno, int eleicao){
    
        int retorna = 0;
        
        String sql = "select * from tb_voto where aluno_id_voto = ? and eleicao_id_voto = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, aluno);
            ps.setInt(2, eleicao);
            
            ResultSet rs = ps.executeQuery();
            
            rs.last();
            
            if(rs.getRow() > 0){
            
                retorna = 1;
            
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return retorna;
    
    }
    
    public int votarDao(int alu, int ele, int chapa){
    
        int retorna = 0;
        
        String sql = "INSERT INTO tb_voto(aluno_id_voto, eleicao_id_voto, voto_voto) VALUES(?, ?, ?)";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, alu);
            ps.setInt(2, ele);
            ps.setInt(3, chapa);
            
            ps.executeUpdate();
            
            retorna = 1;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return retorna;
    
    }
    
}
