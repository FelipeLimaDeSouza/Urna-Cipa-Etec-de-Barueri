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
public class CandidatoBean {
    
    private int aluno_id_candidato;
    private int eleicao_id_candidato;
    private String candidato_chapa;
    private String candidato_apelido;
    private String candidato_foto;

    public CandidatoBean(){}
    
    public CandidatoBean(int id, int eleicao, String chapa, String apelido){
    
        this.aluno_id_candidato = id;
        this.eleicao_id_candidato = eleicao;
        this.candidato_chapa = chapa;
        this.candidato_apelido = apelido;
    
    }
    
    /**
     * @return the aluno_id_candidato
     */
    public int getAluno_id_candidato() {
        return aluno_id_candidato;
    }

    /**
     * @param aluno_id_candidato the aluno_id_candidato to set
     */
    public void setAluno_id_candidato(int aluno_id_candidato) {
        this.aluno_id_candidato = aluno_id_candidato;
    }

    /**
     * @return the eleicao_id_candidato
     */
    public int getEleicao_id_candidato() {
        return eleicao_id_candidato;
    }

    /**
     * @param eleicao_id_candidato the eleicao_id_candidato to set
     */
    public void setEleicao_id_candidato(int eleicao_id_candidato) {
        this.eleicao_id_candidato = eleicao_id_candidato;
    }

    /**
     * @return the candidato_chapa
     */
    public String getCandidato_chapa() {
        return candidato_chapa;
    }

    /**
     * @param candidato_chapa the candidato_chapa to set
     */
    public void setCandidato_chapa(String candidato_chapa) {
        this.candidato_chapa = candidato_chapa;
    }

    /**
     * @return the candidato_apelido
     */
    public String getCandidato_apelido() {
        return candidato_apelido;
    }

    /**
     * @param candidato_apelido the candidato_apelido to set
     */
    public void setCandidato_apelido(String candidato_apelido) {
        this.candidato_apelido = candidato_apelido;
    }

    /**
     * @return the candidato_foto
     */
    public String getCandidato_foto() {
        return candidato_foto;
    }

    /**
     * @param candidato_foto the candidato_foto to set
     */
    public void setCandidato_foto(String candidato_foto) {
        this.candidato_foto = candidato_foto;
    }
    
}
