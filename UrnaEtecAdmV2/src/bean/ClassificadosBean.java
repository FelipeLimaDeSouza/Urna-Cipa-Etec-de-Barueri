/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author user
 */
public class ClassificadosBean {
    
    private String chapa;
    private String apelido;
    private int qtd_votos;
    private double qtd_total;
    private double qtd_eleitores;
    
    public ClassificadosBean(){}
    
    public ClassificadosBean(String cand_chapa, String cand_apelido, int votos, double total, double eleitores){
    
        this.chapa = cand_chapa;
        this.apelido = cand_apelido;
        this.qtd_votos = votos;
        this.qtd_total = total;
        this.qtd_eleitores = eleitores;
    
    }

    /**
     * @return the chapa
     */
    public String getChapa() {
        return chapa;
    }

    /**
     * @param chapa the chapa to set
     */
    public void setChapa(String chapa) {
        this.chapa = chapa;
    }

    /**
     * @return the apelido
     */
    public String getApelido() {
        return apelido;
    }

    /**
     * @param apelido the apelido to set
     */
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    /**
     * @return the qtd_votos
     */
    public int getQtd_votos() {
        return qtd_votos;
    }

    /**
     * @param qtd_votos the qtd_votos to set
     */
    public void setQtd_votos(int qtd_votos) {
        this.qtd_votos = qtd_votos;
    }

    /**
     * @return the qtd_total
     */
    public double getQtd_total() {
        return qtd_total;
    }

    /**
     * @param qtd_total the qtd_total to set
     */
    public void setQtd_total(double qtd_total) {
        this.qtd_total = qtd_total;
    }

    /**
     * @return the qtd_eleitores
     */
    public double getQtd_eleitores() {
        return qtd_eleitores;
    }

    /**
     * @param qtd_eleitores the qtd_eleitores to set
     */
    public void setQtd_eleitores(double qtd_eleitores) {
        this.qtd_eleitores = qtd_eleitores;
    }
    
}
