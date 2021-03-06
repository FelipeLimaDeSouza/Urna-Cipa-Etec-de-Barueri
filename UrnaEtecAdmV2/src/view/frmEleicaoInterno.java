/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EleicaoController;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.swingx.prompt.PromptSupport;
/**
 *
 * @author user
 */
public class frmEleicaoInterno extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmEleicaoInterno
     */
    private static frmDiaEleicaoErro frmFilhoErro;
    private static frmDiaEleicaoSucesso frmFilhoSucesso;
    private static frmDiaEleicaoJaCadastrada frmFilhoEleicaoJaCad;
    public frmEleicaoInterno() {
        initComponents();
        
        PromptSupport.setPrompt("Ex: 20/11/2016", txtData);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT,txtData);
        
        txtData.setBorder(null);
        
    }
    
    public void limpaData(){
    
        txtData.setText("");
    
    }
    
    public void cadatrar(){
    
        String data = txtData.getText();
        
        if(data.length()<10){
        
            frmFilhoErro = new frmDiaEleicaoErro(this, true);
            frmFilhoErro.setVisible(true);
            txtData.setText("");
        
        }else{
        
            String[] dataSeparada = data.split("/");
            
            String dataFormatada = data.replaceAll("[ ./-]", "");
            
            SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
            
            String dataHoje = sdt.format(System.currentTimeMillis());
            
            boolean valida = campoNumerico(dataFormatada);
            
            if(valida == false){
            
                frmFilhoErro = new frmDiaEleicaoErro(this, true);
                frmFilhoErro.setVisible(true);
                txtData.setText("");
            
            }else{
                
                DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
                DateFormat dfh = new SimpleDateFormat("dd/MM/yyyy");
                dfh.setLenient(false);
                df.setLenient (false); // aqui o pulo do gato
                try {
                    df.parse(data);
                    dfh.parse(dataHoje);
                    // data válida
                    
                    LocalDate hoje = LocalDate.of(Integer.parseInt(dataSeparada[2]), 
                    Integer.parseInt(dataSeparada[1]), Integer.parseInt(dataSeparada[0]));
                    
                    EleicaoController ec = new EleicaoController();
                    Date dataI = Date.valueOf(hoje);
                    int retorna = ec.controllerValidaEleicao(dataI);

                    if(retorna == 1){
                        
                        int retornaOutra = ec.controllerValidaOutraEleicao(dataI);

                        if(retornaOutra == 0){
                        
                            int validaInsert = ec.controllerInserirEleicao(dataI);

                            if(validaInsert == 1){

                                frmFilhoSucesso = new frmDiaEleicaoSucesso(this, true);
                                frmFilhoSucesso.setVisible(true);
                                limpaData();

                            }
                        }else{
                        
                            frmFilhoEleicaoJaCad = new frmDiaEleicaoJaCadastrada(null, true);
                            frmFilhoEleicaoJaCad.setVisible(true);
                            
                            limpaData();
                            
                        }

                    }else{
                    
                        frmFilhoErro = new frmDiaEleicaoErro(this, true);
                        frmFilhoErro.setVisible(true);
                        limpaData();
                    
                    }
                    

                } catch (ParseException ex) {
                    // data inválida
                    frmFilhoErro = new frmDiaEleicaoErro(this, true);
                    frmFilhoErro.setVisible(true);
                    txtData.setText("");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(frmEleicaoInterno.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        }
    
    }
    
    private boolean campoNumerico(String campo){		
	return campo.matches("[0-9]{"+campo.length()+"}");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCadastrar = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        lblFundo = new javax.swing.JLabel();

        setBorder(null);
        getContentPane().setLayout(null);

        lblCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCadastrarMouseClicked(evt);
            }
        });
        getContentPane().add(lblCadastrar);
        lblCadastrar.setBounds(514, 230, 100, 34);

        txtData.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtData.setBorder(null);
        txtData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDataKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDataKeyReleased(evt);
            }
        });
        getContentPane().add(txtData);
        txtData.setBounds(244, 186, 218, 31);

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pu_adm_home.png"))); // NOI18N
        getContentPane().add(lblFundo);
        lblFundo.setBounds(0, 0, 700, 460);

        setBounds(-1, -23, 698, 478);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataKeyReleased
        
    }//GEN-LAST:event_txtDataKeyReleased
    
    private void lblCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadastrarMouseClicked
        
        cadatrar();
    }//GEN-LAST:event_lblCadastrarMouseClicked

    private void txtDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataKeyPressed
        String data = txtData.getText();
        if((evt.getKeyCode()==KeyEvent.VK_LEFT)||(evt.getKeyCode()==KeyEvent.VK_RIGHT)
                ||(evt.getKeyCode()==KeyEvent.VK_DOWN)||(evt.getKeyCode()==KeyEvent.VK_UP) || 
                (evt.getKeyCode()==KeyEvent.VK_BACK_SPACE)){
            
        }else if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            cadatrar();
        }else if(data.length()==2){
        
            data = data+"/";
            
            txtData.setText(data);
        
        }else if(data.length()==5){
        
            data = data+"/";
            
            txtData.setText(data);
        
        }else if(data.length()>9){
        
            data = data.substring(0, data.length()-1);
            
            txtData.setText(data);
            
        }
    }//GEN-LAST:event_txtDataKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCadastrar;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JTextField txtData;
    // End of variables declaration//GEN-END:variables
}
