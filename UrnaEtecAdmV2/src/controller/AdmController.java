/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.AdmBean;
import model.AdmDAO;

/**
 *
 * @author user
 */
public class AdmController {
    
    AdmDAO ad;

    public AdmController() throws ClassNotFoundException {
        this.ad = new AdmDAO();
    }
    
    public AdmBean controllerAdmLogar(String user, String senha){
    
        return ad.admDaoLogar(user, senha);
    
    }
    
}
