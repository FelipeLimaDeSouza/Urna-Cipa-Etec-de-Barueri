/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.AlunoBean;
import bean.CandidatoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
    
    public CandidatoBean selecionarDaoAlunoCpf(String cpf){
    
        CandidatoBean cb = new CandidatoBean();
        
        String sql = "SELECT * FROM tb_aluno WHERE aluno_cpf = ? AND aluno_status";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, cpf);
            
            ResultSet rs = ps.executeQuery();
            
            rs.last();
            
            if(rs.getRow() != 1){
            
                cb.setAluno_id_candidato(0);
            
            }else{
            
                cb.setAluno_id_candidato(rs.getInt("aluno_id"));
                
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return cb;
    
    }
    
    public int validaDaoChapa(String chapa, int eleicao){
    
        int retorna = 0;
        
        String sql = "SELECT count(aluno_id_candidato) total FROM tb_candidato"
                + "INNER JOIN tb_eleicao on eleicao_id = eleicao_id_candidato "
                + " WHERE candidato_chapa = ? AND eleicao_id = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, chapa);
            ps.setInt(2, eleicao);
            
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            
            retorna = rs.getInt("total");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return retorna;
    
    }
    
    public ArrayList<CandidatoBean> selecionarDaoAlunos(int eleicao){
    
        ArrayList<CandidatoBean> list = new ArrayList<CandidatoBean>();
        
        CandidatoBean cb;
        
        String sql = "SELECT * FROM tb_candidato \n" +
                    "inner join tb_eleicao on eleicao_id = eleicao_id_candidato\n" +
                    "inner join tb_aluno on aluno_id = aluno_id_candidato\n" +
                    "WHERE eleicao_id_candidato = ? AND eleicao_status = 1 AND aluno_status = 1";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, eleicao);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
            
                cb = new CandidatoBean(rs.getInt("aluno_id_candidato"),
                        rs.getInt("eleicao_id_candidato"), 
                        rs.getString("candidato_chapa"), 
                        rs.getString("candidato_apelido"));
                list.add(cb);
            
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return list;
    
    }
    
    public int validaDaoCandidato(int eleicao, int id){
    
        int retorna = 0;
        
        String sql = "SELECT * FROM tb_candidato WHERE eleicao_id_candidato = ? AND aluno_id_candidato = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, eleicao);
            ps.setInt(2, id);
            
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
    
    public int inserirDaoCandidato(CandidatoBean cb){
    
        int retorna = 0;
        
        String sql = "INSERT INTO tb_candidato(aluno_id_candidato, eleicao_id_candidato, candidato_chapa, candidato_apelido,"
                + "candidato_foto) VALUES (?, ?, ?, ?, ?)";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, cb.getAluno_id_candidato());
            ps.setInt(2, cb.getEleicao_id_candidato());
            ps.setString(3, cb.getCandidato_chapa());
            ps.setString(4, cb.getCandidato_apelido());
            ps.setString(5, cb.getCandidato_foto());
            
            ps.executeUpdate();
            
            retorna = 1;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return retorna;
    
    }
    
}
