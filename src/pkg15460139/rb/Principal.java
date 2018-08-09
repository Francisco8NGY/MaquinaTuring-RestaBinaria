/*
 Francisco Vazquez Delgado
 */
package pkg15460139.rb;

import javax.swing.JOptionPane;

/**
 *
 * @author Francisco
 */
public class Principal extends javax.swing.JFrame {
//Declaramos la matrices de comportamiento y las variables a utilizar
  int [][] estado={{0,0,0,0,1},{1,2,1,2,3},{2,2,2,2,3},{3,3,3,3,4},{4,4,4,5,6},{4,5,5,5,6}};
  char[][] simbolo1={{'0','0','1','1',' '},{'0','0','1','1',' '},{'0','0','1','1',' '},{'0','0','1','1',' '},{'0','0','1','1',' '},{'0','0','1','1',' '}};
  char[][] simbolo2={{'0','1','0','1',' '},{'0','1','0','1',' '},{'1','0','1','0',' '},{'0','1','0','1',' '},{'0','1','0','1',' '},{'0','1','0','1',' '}};    
  char[][] simbolo3={{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '},{'0','1','1','0',' '},{'1','0','0','1','1'}};
  int[][] desplazamiento={{1,1,1,1,-1},{-1,-1,-1,-1,1},{-1,-1,-1,-1,1},{1,1,1,1,-1},{-1,-1,-1,-1,1},{-1,-1,-1,-1,0}};  
  int aceptacion=6;
  int state=0;
  int puntero=1;
  
    public Principal() {
        initComponents();
        
    }
   
    void Proceso(String binario1,String binario2){
        //Metodo que nos genera el comportamiento de la resta
        //En esta parte validamos y nos sercioramos de que las cadenas este en el mismo tamaño
         if(binario1.length()==binario2.length()){
        char[] cinta1=new char[binario1.length()+2];
        char[] cinta2=new char[binario1.length()+2];
        char[] cinta3=new char[binario1.length()+2];
        int contador=0;
             
         //llenamos la primera cinta
        for (int i = 0; i < cinta1.length; i++) {
            if (i == 0 || i == cinta1.length - 1) {
                cinta1[i] = ' ';
            } else {
                cinta1[i] = binario1.charAt(contador);
                contador++;
            }
        }
        //llenamos la segunda cinta
        contador=0;
        for (int i = 0; i < cinta2.length; i++) {
            if (i == 0 || i == cinta2.length - 1) {
                cinta2[i] = ' ';
            } else {
                cinta2[i] = binario2.charAt(contador);
                contador++;
            }
        }
       //llenas la cintar3 con espacios en blanco
        for (int i = 0; i < cinta3.length; i++) {
           cinta3[i]=' ';
        }
            System.out.println("Resulatado de la cianta 1");
        for(int i=0; i<cinta1.length; i++){
            System.out.print(" [ "+cinta1[i] +" ] ");
        }
            System.out.println("Resultado de la cinta 2");
                for(int i=0; i<cinta2.length; i++){
            System.out.print(" [ "+cinta2[i] +" ] ");
        }     
         //En esta parte generamos el ciclo con el cual recorremos la matriz y se hacen los cambios que la matriz nos determina
           try{
                do {
                    System.out.println("estado sin ca  "+state);
               
                   txtArea.setText(txtArea.getText()+"Estado: "+String.valueOf(state)+"\n");
                    
                    System.out.println("segundo puntero  "+punetero2(cinta1[puntero],cinta2[puntero]));
                    txtArea.setText(txtArea.getText()+"Valor del puntero 2  en la matriz: "+punetero2(cinta1[puntero],cinta2[puntero])+"\n");
                    cinta2[puntero]=simbolo2[state][punetero2(cinta1[puntero],cinta2[puntero])];
                    cinta3[puntero]=simbolo3[state][punetero2(cinta1[puntero],cinta2[puntero])];
                    txtArea.setText(txtArea.getText()+"Cinta1: "+cinta1[puntero]+"\n");
                    txtArea.setText(txtArea.getText()+"Cinta2: "+cinta2[puntero]+"\n");
                    txtArea.setText(txtArea.getText()+"Cinta3: "+cinta3[puntero]+"\n");
                    
                    System.out.println("cinta3 : "+cinta3[puntero]);
                    int des=desplazamiento[state][punetero2(cinta1[puntero],cinta2[puntero])];
                    txtArea.setText(txtArea.getText()+"Desplazamiento: "+des+"\n");
                    state=estado[state][punetero2(cinta1[puntero],cinta2[puntero])];
                    txtArea.setText(txtArea.getText()+"Nuevo Valor del estado: "+state+"\n");
                    System.out.println("valor actual  "+puntero);
                    txtArea.setText(txtArea.getText()+"Valor actual del puntero :"+puntero+"\n");
                    
                    System.out.println("des  "+des);
                    puntero=puntero+des;
                    txtArea.setText(txtArea.getText()+"Valor del puntero mas desplazamiento: "+puntero+"\n");   
                    System.out.println("puntero  "+puntero);
                     txtArea.setText(txtArea.getText()+"-----------------------------------------"+"\n");
                     System.out.println(state);
                    System.out.println("----------------------------------------------------------------");
                    if(state==6){//estado de aceptacion
                System.out.println("Cadena aceptada");
                        for(int i=0; i<cinta3.length; i++){
                            System.out.print(cinta3[i]+" ");
                        }
                        //imprimimos el resultado
                     for(int i=0; i<cinta3.length; i++){
                            txtResultado.setText(txtResultado.getText()+" "+cinta3[i]);
                        }    
                        
                break;
            }        
                      
            } while (state!=-1);
            
                }catch(Exception e){
                    
                   JOptionPane.showMessageDialog(null,"La cadena contiene simbolos invalidos segundo requisito");
               } 
                
             
         }else{
             JOptionPane.showMessageDialog(null,"Cadenas no son del mismo tamaño como pirmer requisito");
         }
      
    }
    int punetero2(char num1,char num2){
         //funcion para poder obtener el segundo puntero
        int resultado =-1;
        if(num1=='0' && num2=='0'){
           
            resultado= 0;
           
        }
        else if(num1=='0' && num2=='1'){
            resultado= 1;
          
        }
        else if(num1=='1' && num2=='0'){
            resultado= 2;
       
        }
        else if(num1=='1' && num2=='1'){
            resultado= 3;
            
        }
        
        else if(num1==' ' && num2==' '){
            resultado= 4;
            
        }
        return resultado;
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtBinario1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtBinario2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtResultado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        jLabel10.setText("jLabel10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCalcular.setText("Calcular");
        btnCalcular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCalcularMouseClicked(evt);
            }
        });

        jLabel1.setText("Ingrese el numero binario :");

        jLabel2.setText("Ingrese el numero binario: ");

        jLabel3.setText("Resultado: ");

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        jLabel4.setText("Instituto Tecnologico de colima");

        jLabel5.setText("Lenguajes y autómatas I");

        jLabel6.setText("Departamento de sistemas Computacionales");

        jLabel7.setText("Maquina de Turing");

        jLabel8.setText("Resta Binaria");

        jLabel9.setText("Francisco Vazquez Delgado");

        jLabel11.setText("15460139");

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
        });
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addGap(67, 67, 67))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtBinario1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                            .addComponent(txtBinario2))
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtResultado)
                                        .addGap(62, 62, 62))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(196, 196, 196)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(11, 11, 11)
                .addComponent(jLabel5)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBinario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtBinario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalcular)
                    .addComponent(btnLimpiar)
                    .addComponent(btnSalir))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCalcularMouseClicked
        // Boton Calcular
        String cadena1=txtBinario1.getText();
        String cadena2=txtBinario2.getText();
        Proceso(cadena1,cadena2);
    }//GEN-LAST:event_btnCalcularMouseClicked

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        // Boton limpiar
        txtBinario1.setText(null);
        txtBinario2.setText(null);
        txtResultado.setText(null);
        txtArea.setText(null);
        puntero=1;
        state=0;
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        // boton limpiar
        System.exit(0);
    }//GEN-LAST:event_btnSalirMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtBinario1;
    private javax.swing.JTextField txtBinario2;
    private javax.swing.JTextField txtResultado;
    // End of variables declaration//GEN-END:variables
}
