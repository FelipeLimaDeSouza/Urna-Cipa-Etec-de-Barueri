/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.EleitorDAO;

/**
 *
 * @author user
 */
public class EleitorController {
    
    EleitorDAO ad;

    public EleitorController() throws ClassNotFoundException {
        this.ad = new EleitorDAO();
    }
    
    public int controllerValidaCpf(String cpf){
    
        return ad.validaDaoCpf(cpf);
    
    }
    
    public int controllerVotar(int alu, int ele, int chapa){
    
        return ad.votarDao(alu, ele, chapa);
    
    }
    
    public int controllerValidaVoto(int eleicao, int aluno){
    
        return ad.validaDaoVoto(aluno, eleicao);
    
    }
    
    public int controllerRetornaId(String cpf){
    
        return ad.retornaDaoId(cpf);
    
    }
    
}
