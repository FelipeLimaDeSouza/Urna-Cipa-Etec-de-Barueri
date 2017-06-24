/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.ClassificadosBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utilitarios.Conexao;

/**
 *
 * @author user
 */
public class ClassificadosDAO {
    
    Connection con = null;
    
    public ClassificadosDAO () throws ClassNotFoundException{
    
        con = Conexao.abrirConexao();
        
    }
    
    public int validaDaoEleicaoStatus(int eleicao){
    
        int retorna = 0;
        
        String sql = "SELECT * FROM tb_eleicao WHERE eleicao_id = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, eleicao);
            
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            
            retorna = rs.getInt("eleicao_status");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return retorna;
    
    }
    
    public int selecionarDaoTotalValidos(int eleicao){
    
        int total = 0;
    
        String sql = "select count(voto_voto) total from tb_voto where eleicao_id_voto = ? "
                + "and voto_voto > 0";

        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, eleicao);
            
            ResultSet rs = ps.executeQuery();
            
            rs.last();
            
            if(rs.getRow()<1){
            
                total = 0;
            
            }else{
            
                total = rs.getInt("total");
            
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return total;
    
    }
    
    public int selecionarDaoTotal(int eleicao){
    
        int total = 0;
    
        String sql = "select count(voto_voto) total from tb_voto where eleicao_id_voto = ?";

        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, eleicao);
            
            ResultSet rs = ps.executeQuery();
            
            rs.last();
            
            if(rs.getRow()<1){
            
                total = 0;
            
            }else{
            
                total = rs.getInt("total");
            
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return total;
    
    }
    
    public int selecionarDaoTotalBrancos(int eleicao){
    
        int total = 0;
    
        String sql = "select count(voto_voto) total from tb_voto\n" +
                    "inner join tb_eleicao on eleicao_id = eleicao_id_voto\n" +
                    "where eleicao_id = ? and voto_voto = 0 ";

        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, eleicao);
            
            ResultSet rs = ps.executeQuery();
            
            rs.last();
            
            if(rs.getRow()<1){
            
                total = 0;
            
            }else{
            
                total = rs.getInt("total");
            
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return total;
    
    }
    
    public int selecionarDaoTotalEleitores(){
    
        int total = 0;
        
        String sql = "SELECT count(aluno_id) total FROM tb_aluno";

        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            rs.last();
            
            if(rs.getRow()<1){
            
                total = 0;
            
            }else{
            
                total = rs.getInt("total");
            
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return total;
    
    }
    
    public int selecionaDaoVotosValida(int eleicao){
    
        int retorna = 0;
        
        String sql = "select count(voto_voto) total from tb_voto where eleicao_id_voto = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, eleicao);
            
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            
            retorna = rs.getInt("total");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return retorna;
    
    }
    
    public ArrayList<ClassificadosBean> selecionarDaoCandidatos(int eleicao){
    
        ArrayList<ClassificadosBean> list = new ArrayList<ClassificadosBean>();
        
        ClassificadosBean cb;
        
        String sql = "select candidato_chapa, candidato_apelido, count(voto_voto) total from tb_candidato\n" +
                    "inner join tb_eleicao on eleicao_id = eleicao_id_candidato\n" +
                    "inner join tb_voto on eleicao_id_voto = eleicao_id\n" +
                    "where eleicao_id = ? and candidato_chapa = voto_voto \n" +
                    "group by candidato_chapa\n" +
                    "order by total desc";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, eleicao);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
            
                cb = new ClassificadosBean(rs.getString("candidato_chapa"), 
                        rs.getString("candidato_apelido"), 
                        rs.getInt("total"), 0, 0);
                
                list.add(cb);
                
            }
            
            int valida = selecionaDaoVotosValida(eleicao);
            
            if(valida>0){
            
                String sql2 = "select candidato_chapa, candidato_apelido, 0 total \n" +
                    "from tb_voto \n" +
                    "inner join tb_eleicao on eleicao_id = eleicao_id_voto\n" +
                    "inner join tb_candidato on eleicao_id_candidato = eleicao_id\n" +
                    "where eleicao_id_voto = ? AND candidato_chapa not in \n" +
                    "(select voto_voto from tb_voto)\n" +
                    "group by candidato_chapa\n" +
                    "order by total desc";
                    
                PreparedStatement ps2 = con.prepareStatement(sql2);

                ps2.setInt(1, eleicao);

                ResultSet rs2 = ps2.executeQuery();

                while(rs2.next()){

                    cb = new ClassificadosBean(rs2.getString("candidato_chapa"), 
                            rs2.getString("candidato_apelido"), 
                            rs2.getInt("total"), 0, 0);

                    list.add(cb);

                }
            
            }else{
            
                String sql2 = "select candidato_chapa, candidato_apelido, 0 total \n" +
                            "from tb_candidato where eleicao_id_candidato = ?";
            
                PreparedStatement ps2 = con.prepareStatement(sql2);

                ps2.setInt(1, eleicao);

                ResultSet rs2 = ps2.executeQuery();

                while(rs2.next()){

                    cb = new ClassificadosBean(rs2.getString("candidato_chapa"), 
                            rs2.getString("candidato_apelido"), 
                            rs2.getInt("total"), 0, 0);

                    list.add(cb);

                }
                
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return list;
    
    }
    
}
