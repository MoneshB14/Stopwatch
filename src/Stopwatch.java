class Stopwatch extends javax.swing.JFrame {
    int Milliseconds =0;
    int Seconds=0;
    int Minutes=0;
    int Hours=0;
    
    boolean state=true;

    public Stopwatch() {
        initComponents();
    }  
    
    private void initComponents() {

        Hour = new javax.swing.JLabel();
        Minute = new javax.swing.JLabel();
        Second = new javax.swing.JLabel();
        Millisecond = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        getContentPane().setBackground(CommonConstants.primary_color);

        Hour.setForeground(CommonConstants.text_color);
        Hour.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        Hour.setText("00:");

        Minute.setForeground(CommonConstants.text_color);
        Minute.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        Minute.setText("00:");

        Second.setForeground(CommonConstants.text_color);
        Second.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        Second.setText("00:");

        Millisecond.setForeground(CommonConstants.text_color);
        Millisecond.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Millisecond.setText("00");

       
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

       
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton2.setText("Stop");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

       
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(Hour, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Minute, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Second, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Millisecond, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Hour, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Minute, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Second, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Millisecond, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }                      
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       state=true;
       Thread thread=new Thread(){
           public void run(){
               for(;;){
                   if(state==true){
                       try{
                         Thread.sleep(1);
                         if(Milliseconds>1000){
                             Milliseconds=0;
                             Seconds++;
                         }
                         if(Seconds>60){
                             Milliseconds=0;
                             Seconds=0;
                             Minutes++;
                         }
                         if(Minutes>60){
                             Milliseconds=0;
                             Seconds=0;
                             Minutes=0;
                             Hours++;
                         }
                         Millisecond.setText(":"+Milliseconds);
                         Milliseconds++;
                         Second.setText(":"+Seconds);
                         Minute.setText(":"+Minutes);
                         Hour.setText(""+Hours);
                       }
                       catch(Exception E){
                       }
                   }
                   else{
                       break;
                   }
               }
           }
       };
       thread.start();
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        state=false;
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        state=false;
        
        Hours=0;
        Minutes=0;
        Seconds=0;
        Milliseconds=0;
        
        Hour.setText("00 : ");
        Minute.setText("00 : ");
        Second.setText("00 : ");
        Millisecond.setText("00");
        
    }                                        

  
    public static void main(String args[]) {      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stopwatch().setVisible(true);
            }
        });
    }
    private javax.swing.JLabel Hour;
    private javax.swing.JLabel Millisecond;
    private javax.swing.JLabel Minute;
    private javax.swing.JLabel Second;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;             
   
}
