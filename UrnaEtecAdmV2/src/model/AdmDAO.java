/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.AdmBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilitarios.Conexao;

/**
 *
 * @author user
 */
public class AdmDAO {
    
    Connection con = null;
    
    public AdmDAO () throws ClassNotFoundException{
    
        con = Conexao.abrirConexao();
        
    }
    
    public AdmBean admDaoLogar(String user, String senha){
    
        String sql = "SELECT * FROM TB_ADM WHERE ADM_USUARIO=? AND ADM_SENHA=?";
        
        AdmBean ab = new AdmBean();
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, user);
            ps.setString(2, senha);
            
            ResultSet rs = ps.executeQuery();
            
            rs.last();
            
            if(rs.getRow()!=1){
            
                ab.setAdm_id(0);
                
            }else{
            
                ab.setAdm_id(rs.getInt("adm_id"));
                ab.setAdm_usuario(rs.getString("adm_usuario"));
                
                return ab;
                
            }
        } catch (SQLException e) {
            
            System.out.println("Erro: "+e.getMessage());
            
        }
        
        return ab;
    
    }
    
}
