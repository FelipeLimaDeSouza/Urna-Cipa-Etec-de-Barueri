/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.EleicaoBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utilitarios.Conexao;

/**
 *
 * @author user
 */
public class EleicaoDAO {
    
    Connection con = null;
    
    public EleicaoDAO () throws ClassNotFoundException{
    
        con = Conexao.abrirConexao();
        
    }
    
    public int finalizaDaoEleitores(){
    
        int retorna = 0;
        
        String sql1 = "UPDATE tb_aluno SET aluno_turma = 0, aluno_status = 0 WHERE aluno_turma = 3";
        String sql2 = "UPDATE tb_aluno SET aluno_turma = 3 WHERE aluno_turma = 2";
        String sql3 = "UPDATE tb_aluno SET aluno_turma = 2 WHERE aluno_turma = 1";
        
        try {
            
            PreparedStatement ps1 = con.prepareStatement(sql1);
            PreparedStatement ps2 = con.prepareStatement(sql2);
            PreparedStatement ps3 = con.prepareStatement(sql3);
            
            ps1.executeUpdate();
            ps2.executeUpdate();
            ps3.executeUpdate();
            
            retorna = 1;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
        return retorna;
        
    }
    
    public int encerraDaoEleicao(int eleicao){
    
        int retorna = 0;
        
        String sql = "UPDATE tb_eleicao SET eleicao_status = 0 WHERE eleicao_id = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, eleicao);
            
            ps.executeUpdate();
            
            retorna = 1;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return retorna;
    
    }
    
    public int validaDaoEleicao(Date data){
    
        int retorna = 0;
        
        String sql = "select curdate() <= ? dat";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setDate(1, data);
            
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            
            retorna = rs.getInt("dat");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return retorna;
        
    }
    
    public int validaDaoOutraEleicao(Date data){
    
        int retorna = 0;
        
        String sql = "select count(eleicao_id) total from tb_eleicao\n" +
                       "where eleicao_data = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setDate(1, data);
            
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            
            retorna = rs.getInt("total");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return retorna;
        
    }
    
    public int inserirDaoEleicao(Date data){
    
        int retorna = 0;
        
        String sql = "INSERT INTO tb_eleicao(eleicao_data) VALUES(?)";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setDate(1, data);
            
            ps.executeUpdate();
            
            retorna = 1;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return retorna;
        
    }
    
    public ArrayList<EleicaoBean> selecionarDaoEleicoes(){
    
        ArrayList<EleicaoBean> list = new ArrayList<EleicaoBean>();
        
        EleicaoBean eb;
        
        String sql = "SELECT * from tb_eleicao where eleicao_data >= curdate() and eleicao_status = 1 order by eleicao_data";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
            
                eb = new EleicaoBean(rs.getInt("eleicao_id"),
                        rs.getDate("eleicao_data"));
                
                list.add(eb);
            
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return list;
    
    }
    
    public ArrayList<EleicaoBean> selecionarDaoEleicoesRel(){
    
        ArrayList<EleicaoBean> list = new ArrayList<EleicaoBean>();
        
        EleicaoBean eb;
        
        String sql = "SELECT * FROM tb_eleicao order by eleicao_data";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
            
                eb = new EleicaoBean(rs.getInt("eleicao_id"),
                        rs.getDate("eleicao_data"));
                
                list.add(eb);
            
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return list;
    
    }
    
    public EleicaoBean selecionarDaoEleicaoId(int id){
    
        EleicaoBean eb = new EleicaoBean();
        
        String sql = "SELECT * FROM tb_eleicao WHERE eleicao_id = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            
            eb.setEleicao_id(rs.getInt("eleicao_id"));
            eb.setEleicao_data(rs.getDate("eleicao_data"));
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return eb;
        
    }
    
}
