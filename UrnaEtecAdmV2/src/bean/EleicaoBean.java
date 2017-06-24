/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author user
 */
public class EleicaoBean {
    
    private int eleicao_id;
    private String eleicao_data;

    public EleicaoBean(){}
    
    public EleicaoBean(int id, Date data){
    
        this.eleicao_id = id;
        
        SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-yyyy");
        
        String date = sdt.format(data);
        
        this.eleicao_data = date;
        
    
    }
    
    /**
     * @return the eleicao_id
     */
    public int getEleicao_id() {
        return eleicao_id;
    }

    /**
     * @param eleicao_id the eleicao_id to set
     */
    public void setEleicao_id(int eleicao_id) {
        this.eleicao_id = eleicao_id;
    }

    /**
     * @return the eleicao_data
     */
    public String getEleicao_data() {
        return eleicao_data;
    }

    /**
     * @param eleicao_data the eleicao_data to set
     */
    public void setEleicao_data(Date eleicao_data) {
        
        SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-yyyy");
        
        String data = sdt.format(eleicao_data);
        
        this.eleicao_data = data;
    }
    
}
