/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.AlunoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utilitarios.Conexao;

/**
 *
 * @author user
 */
public class AlunoDAO {
    
    Connection con = null;
    
    public AlunoDAO () throws ClassNotFoundException{
    
        con = Conexao.abrirConexao();
        
    }
    
    public int validaDaoAluno(String cpf, String ra){
    
        int retorna = 0;
        
        String sql = "SELECT * FROM tb_aluno WHERE aluno_cpf = ? OR aluno_ra = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, cpf);
            ps.setString(2, ra);
            
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
    
    public int inserirAlunoDao(AlunoBean ab){
    
        int retorna = 0;
        
        String sql = "INSERT INTO tb_aluno(aluno_nome, aluno_cpf, aluno_ra, aluno_turma, aluno_curso)"
                + "VALUES(?, ?, ?, ?, ?)";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, ab.getAluno_nome());
            ps.setString(2, ab.getAluno_cpf());
            ps.setString(3, ab.getAluno_ra());
            ps.setInt(4, ab.getAluno_turma());
            ps.setString(5, ab.getAluno_curso());
            
            ps.executeUpdate();
            
            retorna = 1;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return retorna;
    
    }
    
    public ArrayList<AlunoBean> selecionarDaoAlunos(){
    
        ArrayList<AlunoBean> list = new ArrayList<AlunoBean>();
        AlunoBean ab;
        
        String sql = "SELECT * FROM tb_aluno where aluno_status = 1";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
            
                ab = new AlunoBean(rs.getInt("aluno_id"), 
                        rs.getString("aluno_nome"), 
                        rs.getString("aluno_cpf"), 
                        rs.getString("aluno_ra"), 
                        rs.getInt("aluno_turma"), 
                        rs.getString("aluno_curso"), 
                        rs.getInt("aluno_status"));
                
                list.add(ab);
            
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return list;
    
    }
    
    public ArrayList<AlunoBean> selecionarDaoAlunoExc(String cpf, String ra){
    
        ArrayList<AlunoBean> list = new ArrayList<AlunoBean>();
        AlunoBean ab;
        
        String sql = "SELECT * FROM tb_aluno WHERE aluno_cpf LIKE '"+cpf+"%' "
                + "OR aluno_ra LIKE '"+ra+"%'";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
            
                ab = new AlunoBean(rs.getInt("aluno_id"), 
                        rs.getString("aluno_nome"), 
                        rs.getString("aluno_cpf"), 
                        rs.getString("aluno_ra"), 
                        rs.getInt("aluno_turma"), 
                        rs.getString("aluno_curso"), 
                        rs.getInt("aluno_status"));
                
                list.add(ab);
            
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return list;
    
    }
    
}
