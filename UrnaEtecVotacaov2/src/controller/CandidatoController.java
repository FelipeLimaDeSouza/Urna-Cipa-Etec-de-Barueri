/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.CandidatoBean;
import model.CandidatoDAO;

/**
 *
 * @author user
 */
public class CandidatoController {
    
    CandidatoDAO cd;
    
    public CandidatoController() throws ClassNotFoundException {
        this.cd = new CandidatoDAO();
    }
    
    public CandidatoBean controllerSelecionaCandidato(String chapa, int eleicao){
    
        return cd.selecionaDaoCandidato(chapa, eleicao);
    
    }
    
    public int controllerRetornaId(){
    
        return cd.retornaDaoEleicao();
    
    }
    
    public int controllerVotar(int numero, int ele, int alu){
    
        return cd.votarDao(numero, alu, ele);
    
    }
    
    
}
