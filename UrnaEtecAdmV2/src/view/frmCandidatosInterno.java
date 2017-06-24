/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.CandidatoBean;
import bean.EleicaoBean;
import controller.CandidatoController;
import controller.EleicaoController;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.prompt.PromptSupport;
import utilitarios.ManipularImagem;

/**
 *
 * @author user
 */
public class frmCandidatosInterno extends javax.swing.JInternalFrame {

    private String caminhoImagem;
    private BufferedImage imagem;
    private static frmDiaEleitorErro frmFilho;
    private static frmDiaCandidatoJaCadastrado frmFilhoCanCad;
    private static frmDiaCandidatoInserido frmFilhoInserido;
    private static frmDiaErroInserirCandidato frmFilhoErro;
    private static frmDiaNaoSelecionouArquivo frmFilhoNenhumArquivo;
    private static frmDiaEleDstv frmFilhoDstv;
    private static frmDiaChapaJaCadastrada frmFilhoChapa;
    public frmCandidatosInterno() {
        initComponents();
        PromptSupport.setPrompt("Sem pontos ou traços", txtCPF);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT,txtCPF);
        
        txtCPF.setBorder(null);
        
    }
    
    public void carregaCombos(){
    
        try {
            
            cmbFiltrarEleicao.removeAllItems();
            cmbSelecionarEleicao.removeAllItems();
            
            EleicaoController ec = new EleicaoController();
            
            ArrayList<EleicaoBean> list = ec.controllerSelecionarEleicoes();
            
            cmbSelecionarEleicao.addItem("Selecione uma Eleição");
            
            for (int i = 0; i < list.size(); i++) {
                cmbSelecionarEleicao.addItem(list.get(i).getEleicao_data());
                if(list.size()>=0){
                
                    cmbFiltrarEleicao.addItem(list.get(i).getEleicao_data());
                
                }
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
    }
    
    public void carregaTabela(int index){
    
        try {
            
            EleicaoController ec = new EleicaoController();
            
            ArrayList<EleicaoBean> eleicao = ec.controllerSelecionarEleicoes();
            
            CandidatoController cc = new CandidatoController();
            
            ArrayList<CandidatoBean> list = cc.controllerSelecionarCandidatos(eleicao.get(index).getEleicao_id());
            
            EleicaoBean eb = ec.controllerSelecionarEleicaoId(eleicao.get(index).getEleicao_id());
            
            DefaultTableModel dtm = (DefaultTableModel) tblCandidatos.getModel();
            
            dtm.setNumRows(0);
            
            for (int i = 0; i < list.size(); i++) {

                dtm.addRow(new Object[]{list.get(i).getCandidato_chapa(),
                    list.get(i).getCandidato_apelido(), eb.getEleicao_data()});

            }
            
        } catch (Exception e) {
            //System.out.println(e.getMessage());
        }
    
    }

    public void limparCampos(){
        
        lblImagem.setIcon(null);
        txtCPF.setText("");
        txtApelido.setText("");
        txtChapa.setText("");
        caminhoImagem = null;
        cmbSelecionarEleicao.setSelectedIndex(0);
        if(cmbFiltrarEleicao.getItemCount()>0){
            cmbFiltrarEleicao.setSelectedIndex(0);
            carregaTabela(0);
        }
        txtApelido.requestFocus();
    
    }
    
    private boolean campoNumerico(String campo){		
	return campo.matches("[0-9]{"+campo.length()+"}");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtApelido = new javax.swing.JTextField();
        txtChapa = new javax.swing.JTextField();
        lblImagem = new javax.swing.JLabel();
        cmbSelecionarEleicao = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCandidatos = new javax.swing.JTable();
        cmbFiltrarEleicao = new javax.swing.JComboBox<>();
        lblCadastrar = new javax.swing.JLabel();
        lblSelecionarFoto = new javax.swing.JLabel();
        txtCPF = new javax.swing.JTextField();
        lblFundo = new javax.swing.JLabel();

        setBorder(null);
        getContentPane().setLayout(null);

        txtApelido.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtApelido.setBorder(null);
        getContentPane().add(txtApelido);
        txtApelido.setBounds(160, 48, 180, 33);

        txtChapa.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtChapa.setBorder(null);
        getContentPane().add(txtChapa);
        txtChapa.setBounds(160, 94, 180, 33);

        lblImagem.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblImagem);
        lblImagem.setBounds(372, 46, 174, 138);

        cmbSelecionarEleicao.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cmbSelecionarEleicao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma Eleição", "28/11/2016" }));
        cmbSelecionarEleicao.setToolTipText("");
        cmbSelecionarEleicao.setBorder(null);
        getContentPane().add(cmbSelecionarEleicao);
        cmbSelecionarEleicao.setBounds(158, 186, 180, 33);

        tblCandidatos.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tblCandidatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chapa", "Apelido", "Eleição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCandidatos.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tblCandidatos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 310, 580, 140);

        cmbFiltrarEleicao.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cmbFiltrarEleicao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "28/11/2016" }));
        cmbFiltrarEleicao.setToolTipText("");
        cmbFiltrarEleicao.setBorder(null);
        cmbFiltrarEleicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFiltrarEleicaoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbFiltrarEleicao);
        cmbFiltrarEleicao.setBounds(60, 270, 220, 32);

        lblCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCadastrarMouseClicked(evt);
            }
        });
        getContentPane().add(lblCadastrar);
        lblCadastrar.setBounds(526, 236, 100, 34);

        lblSelecionarFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSelecionarFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSelecionarFotoMouseClicked(evt);
            }
        });
        getContentPane().add(lblSelecionarFoto);
        lblSelecionarFoto.setBounds(372, 186, 174, 33);

        txtCPF.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCPF.setBorder(null);
        txtCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCPFKeyPressed(evt);
            }
        });
        getContentPane().add(txtCPF);
        txtCPF.setBounds(160, 138, 180, 33);

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pu_adm_candidatos.png"))); // NOI18N
        getContentPane().add(lblFundo);
        lblFundo.setBounds(0, 0, 700, 462);

        setBounds(3, -24, 697, 486);
    }// </editor-fold>//GEN-END:initComponents

    private void lblSelecionarFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelecionarFotoMouseClicked
        JFileChooser fc = new JFileChooser();
        fc.setBorder(null);
        fc.setLocale(null);
        fc.setDialogTitle("Selecione uma imagem");
        int res = fc.showOpenDialog(null);
        
        if (res == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();

            try {
                
                imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath());
                
                ImageIcon icon = new ImageIcon(imagem);
                Image image = icon.getImage().getScaledInstance(lblImagem.getWidth(), 
                    lblImagem.getHeight(), Image.SCALE_SMOOTH);

                lblImagem.setIcon(new ImageIcon(image));
                
                String caminho = "candidatos/";
                caminhoImagem = caminho;
                    
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        } else {
            frmFilhoNenhumArquivo = new frmDiaNaoSelecionouArquivo(null, true);
            frmFilhoNenhumArquivo.setVisible(true);
        }
    }//GEN-LAST:event_lblSelecionarFotoMouseClicked

    private void lblCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadastrarMouseClicked
        String chapa = txtChapa.getText();
        String apelido = txtApelido.getText();
        String cpf = txtCPF.getText();
        boolean validaChapaNum = campoNumerico(chapa);
        int index = cmbSelecionarEleicao.getSelectedIndex();
        if((chapa.equals(""))||(apelido.equals(""))||(caminhoImagem==null)
                ||(index==0)||(cpf.equals(""))||(cpf.length()<11)||(validaChapaNum == false)){
        
            frmFilho = new frmDiaEleitorErro(null, true);
            frmFilho.setVisible(true);
        
        }else{
            
            try {
                
                CandidatoController ac = new CandidatoController();
                
                EleicaoController ec = new EleicaoController();
                
                ArrayList<EleicaoBean> list = ec.controllerSelecionarEleicoes();
                
                CandidatoBean cb = ac.controllerSelecionarCandidatoCpf(cpf);
                
                if(cb.getAluno_id_candidato() == 0){
                
                    frmFilhoDstv = new frmDiaEleDstv(null, true);
                    frmFilhoDstv.setVisible(true);
                    
                    limparCampos();
                
                }else{
                    
                    String caminho = caminhoImagem+txtApelido.getText()+".jpg";
                    File outputfile = new File(caminho);
                    ImageIO.write(imagem, "jpg", outputfile);
                
                    int id = list.get(index-1).getEleicao_id();
                    
                    cb.setEleicao_id_candidato(id);
                    cb.setCandidato_apelido(apelido);
                    cb.setCandidato_chapa(chapa);
                    cb.setCandidato_foto(caminho);
                    
                    int validaCandidato = ac.controllerValidaCandidato(cb.getEleicao_id_candidato(), 
                            cb.getAluno_id_candidato());
                    
                    if(validaCandidato == 1){
                    
                        frmFilhoCanCad = new frmDiaCandidatoJaCadastrado(null, true);
                        frmFilhoCanCad.setVisible(true);
        
                        carregaCombos();
                        carregaTabela(0);
                        limparCampos();
                        
                    
                    }else{
                        
                        int validaChapa = ac.validaDaoChapa(chapa, id);
                    
                        if(validaChapa < 1){
                    
                            int valida = ac.controllerInserirCandidato(cb);

                            if(valida == 1){

                                frmFilhoInserido = new frmDiaCandidatoInserido(null, true);
                                frmFilhoInserido.setVisible(true);


                                limparCampos();

                            }else{

                                frmFilhoErro = new frmDiaErroInserirCandidato(null, true);
                                frmFilhoErro.setVisible(true);


                                limparCampos();

                            }
                        
                        }else{
                        
                        
                            frmFilhoChapa = new frmDiaChapaJaCadastrada(null, true);
                            frmFilhoChapa.setVisible(true);
                            
                            limparCampos();
                        
                        }
                        
                    }
                
                }
                
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            
        }
        
    }//GEN-LAST:event_lblCadastrarMouseClicked

    private void txtCPFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPFKeyPressed
        String cpf = txtCPF.getText();
        if((evt.getKeyCode()==KeyEvent.VK_LEFT)||(evt.getKeyCode()==KeyEvent.VK_RIGHT)
                ||(evt.getKeyCode()==KeyEvent.VK_DOWN)||(evt.getKeyCode()==KeyEvent.VK_UP) || 
                (evt.getKeyCode()==KeyEvent.VK_BACK_SPACE)){
            
        }else{
            
            int qtd = cpf.length();

            if(qtd > 10){

                cpf = cpf.substring(0, cpf.length()-1);

                txtCPF.setText(cpf);

            }
        }
    }//GEN-LAST:event_txtCPFKeyPressed

    private void cmbFiltrarEleicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFiltrarEleicaoActionPerformed
        int index = cmbFiltrarEleicao.getSelectedIndex();
        carregaTabela(index);
    }//GEN-LAST:event_cmbFiltrarEleicaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbFiltrarEleicao;
    private javax.swing.JComboBox<String> cmbSelecionarEleicao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCadastrar;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblSelecionarFoto;
    private javax.swing.JTable tblCandidatos;
    private javax.swing.JTextField txtApelido;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtChapa;
    // End of variables declaration//GEN-END:variables
}
