/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.CandidatoBean;
import java.util.ArrayList;
import model.CandidatoDAO;

/**
 *
 * @author user
 */
public class CandidatoController {
    
    CandidatoDAO ad;

    public CandidatoController() throws ClassNotFoundException {
        this.ad = new CandidatoDAO();
    }
    
    public CandidatoBean controllerSelecionarCandidatoCpf(String cpf){
    
        return ad.selecionarDaoAlunoCpf(cpf);
    
    }
    
    public int controllerValidaCandidato(int eleicao, int id){
    
        return ad.validaDaoCandidato(eleicao, id);
    
    }
    
    public int controllerInserirCandidato(CandidatoBean cb){
    
        return ad.inserirDaoCandidato(cb);
    
    }
    
    public ArrayList<CandidatoBean> controllerSelecionarCandidatos(int eleicao){
    
        return ad.selecionarDaoAlunos(eleicao);
    
    }
    
    public int validaDaoChapa(String chapa, int eleicao){
    
        return ad.validaDaoChapa(chapa, eleicao);
    
    }
    
}
