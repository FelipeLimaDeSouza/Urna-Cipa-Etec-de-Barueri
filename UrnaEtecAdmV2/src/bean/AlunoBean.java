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
public class AlunoBean {
    
    private int aluno_id;
    private String aluno_nome;
    private String aluno_cpf;
    private String aluno_ra;
    private int aluno_turma;
    private String aluno_curso;
    private int aluno_status;
    
    public AlunoBean(){}
    
    public AlunoBean(int id, String nome, String cpf, String ra, int turma, String curso, int status){
    
        this.aluno_id = id;
        this.aluno_nome = nome;
        this.aluno_cpf = cpf;
        this.aluno_ra = ra;
        this.aluno_turma = turma;
        this.aluno_curso = curso;
        this.aluno_status = status;
    
    }

    /**
     * @return the aluno_id
     */
    public int getAluno_id() {
        return aluno_id;
    }

    /**
     * @param aluno_id the aluno_id to set
     */
    public void setAluno_id(int aluno_id) {
        this.aluno_id = aluno_id;
    }

    /**
     * @return the aluno_nome
     */
    public String getAluno_nome() {
        return aluno_nome;
    }

    /**
     * @param aluno_nome the aluno_nome to set
     */
    public void setAluno_nome(String aluno_nome) {
        this.aluno_nome = aluno_nome;
    }

    /**
     * @return the aluno_cpf
     */
    public String getAluno_cpf() {
        return aluno_cpf;
    }

    /**
     * @param aluno_cpf the aluno_cpf to set
     */
    public void setAluno_cpf(String aluno_cpf) {
        this.aluno_cpf = aluno_cpf;
    }

    /**
     * @return the aluno_ra
     */
    public String getAluno_ra() {
        return aluno_ra;
    }

    /**
     * @param aluno_ra the aluno_ra to set
     */
    public void setAluno_ra(String aluno_ra) {
        this.aluno_ra = aluno_ra;
    }

    /**
     * @return the aluno_turma
     */
    public int getAluno_turma() {
        return aluno_turma;
    }

    /**
     * @param aluno_turma the aluno_turma to set
     */
    public void setAluno_turma(int aluno_turma) {
        this.aluno_turma = aluno_turma;
    }

    /**
     * @return the aluno_curso
     */
    public String getAluno_curso() {
        return aluno_curso;
    }

    /**
     * @param aluno_curso the aluno_curso to set
     */
    public void setAluno_curso(String aluno_curso) {
        this.aluno_curso = aluno_curso;
    }

    /**
     * @return the aluno_status
     */
    public int getAluno_status() {
        return aluno_status;
    }

    /**
     * @param aluno_status the aluno_status to set
     */
    public void setAluno_status(int aluno_status) {
        this.aluno_status = aluno_status;
    }
    
}
