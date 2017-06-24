/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.ClassificadosBean;
import java.util.ArrayList;
import model.ClassificadosDAO;

/**
 *
 * @author user
 */
public class ClassificadosController {
    
    ClassificadosDAO ad;

    public ClassificadosController() throws ClassNotFoundException {
        this.ad = new ClassificadosDAO();
    }
    
    public int controllerSelecionarTotal(int eleicao){
    
        return ad.selecionarDaoTotal(eleicao);
    
    }
    
    public int controllerValidaStatus(int eleicao){
    
        return ad.validaDaoEleicaoStatus(eleicao);
    
    }
    
    public int controllerSelecionarTotalValidos(int eleicao){
    
        return ad.selecionarDaoTotalValidos(eleicao);
    
    }
    
    public int controllerSelecionarTotalEleitores(){
    
        return ad.selecionarDaoTotalEleitores();
    
    }
    
    public int controllerSelecionarTotalBrancos(int eleicao){
    
        return ad.selecionarDaoTotalBrancos(eleicao);
    
    }
    
    public ArrayList<ClassificadosBean> controllerSelecionarCandidato(int eleicao){
    
        return ad.selecionarDaoCandidatos(eleicao);
    
    }
    
}
