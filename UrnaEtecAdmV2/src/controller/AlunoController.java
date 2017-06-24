/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.AlunoBean;
import java.util.ArrayList;
import model.AlunoDAO;

/**
 *
 * @author user
 */
public class AlunoController {
    
    AlunoDAO ad;

    public AlunoController() throws ClassNotFoundException {
        this.ad = new AlunoDAO();
    }
    
    public int controllerValidaAluno(String cpf, String ra){
    
        return ad.validaDaoAluno(cpf, ra);
    
    }
    
    public int controllerInsereAluno(AlunoBean ab){
    
        return ad.inserirAlunoDao(ab);
    
    }
    
    public ArrayList<AlunoBean> controllerSelecionaAluno(){
    
        return ad.selecionarDaoAlunos();
    
    }
    
    public ArrayList<AlunoBean> controllerSelecionaAlunoExc(String cpf, String ra){
    
        return ad.selecionarDaoAlunoExc(cpf, ra);
    
    }
    
}
