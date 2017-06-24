/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.EleicaoBean;
import java.sql.Date;
import java.util.ArrayList;
import model.EleicaoDAO;

/**
 *
 * @author user
 */
public class EleicaoController {
    
    EleicaoDAO ad;

    public EleicaoController() throws ClassNotFoundException {
        this.ad = new EleicaoDAO();
    }
    
    public int controllerFinalizaEleitores(){
    
        return ad.finalizaDaoEleitores();
    
    }
    
    public int controllerEncerraEleicao(int eleicao){
    
        return ad.encerraDaoEleicao(eleicao);
        
    }
    
    public ArrayList<EleicaoBean> controllerSelecionarEleicoes(){
    
        return ad.selecionarDaoEleicoes();
    
    }
    
    public ArrayList<EleicaoBean> controllerSelecionarEleicoesRel(){
    
        return ad.selecionarDaoEleicoesRel();
    
    }
    
    public EleicaoBean controllerSelecionarEleicaoId(int id){
    
        return ad.selecionarDaoEleicaoId(id);
    
    }
    
    public int controllerInserirEleicao(Date data){
    
        return ad.inserirDaoEleicao(data);
    
    }
    
    public int controllerValidaEleicao(Date data){
    
        return ad.validaDaoEleicao(data);
        
    }
    
    public int controllerValidaOutraEleicao(Date data){
    
        return ad.validaDaoOutraEleicao(data);
        
    }
    
}
