/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LuckyTravel;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class GamePage extends javax.swing.JFrame {

    int[] money={10000,10000};
    //int[] dice={0,0,0,0,0,0};
    int dice;
    Random r=new Random();
    int place_p1=0,place_p2=0;
    int turn=0;
    // mod 16 sını alırım!!!
    int[] price={600,900,850,750,500,400,1000,1200,1300,1400,900,700,850,350,300,400};
  int[] upgrade={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    int[] saled={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
  int[] land_p1={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
  int[] land_p2={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
 int[] is_click={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
 int turn_p1=0;
 int turn_p2=0;
 int ab=0;
 int a;
 int bank_p1=0;
 int bank_p2=0;
 int tour_limit;
 int is_tour_selected=0;
    public GamePage() {
        initComponents();
        lbl_photo1.setIcon(new javax.swing.ImageIcon(getClass().getResource(ChooseCharacter.photo[0])));
        lbl_photo2.setIcon(new javax.swing.ImageIcon(getClass().getResource(ChooseCharacter.photo[1])));
        lbl_money1.setText(Integer.toString(money[0])+" TL");
        lbl_money2.setText(Integer.toString(money[1])+" TL");
        turn_pl.setText("Player 1");
        btn_upgrade.setVisible(false);
         turn_p1=1;
         lbl_bankp1.setText("0");
         lbl_bankp2.setText("0");
        // btn_16 enabled(false) yapılacak para üretilip otomatik atanacak
        
        
        //upgradeler price a eklenecek
        //bankadaki paraya 5 turda bir %10 vergi eklemesi yapılcak      
    }
    
  public void calculate_turn(){
     int g=turn_p1+turn_p2;
     
      if (tour_limit-g<=0) {
          JOptionPane.showMessageDialog(null,"Game Over , Winner Player is "+find_winner());
          java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FirstPage().setVisible(true);
            }
        });
          this.dispose();
      }
      else{
         lbl_tourlimit.setText(Integer.toString(tour_limit-g));
      }
  }
  
  public void new_game(){
      money[0]=4500;
      money[1]=4500;
      turn_p1=0;
      turn_p2=0;
  //   ghhjkjl
    //int[] dice={0,0,0,0,0,0};
 
     place_p1=0; place_p2=0;
     turn=0;
    // mod 16 sını alırım!!!
    //int[]price={600,900,850,750,500,400,1000,1200,1300,1400,900,700,850,350,300,400};
  int[] upgrade={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
      for (int i = 0; i <upgrade.length; i++) {
          upgrade[i]=0;
          saled[i]=0;
          land_p1[i]=0;
          land_p2[i]=0;
          is_click[i]=0;
         
          
      }
  
 
   ab=0;
   bank_p1=0;
   bank_p2=0;
   is_tour_selected=0;
   
  
   lbl_money1.setText(Integer.toString(money[0]));
   lbl_money2.setText(Integer.toString(money[1]));
   lbl_rentt.setText("");
   pl_p1.setText("");
  
   lbl_rent2.setText("");
   pll_p2.setText("");
   
   lbl_place.setText("");
   lbl_player.setText("");
   lbl_price.setText("");
   lbl_rent.setText("");
   lbl_tourlimit.setText("");
   lbl_dice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty.png")));
   // düzelmedi
   btn_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png")));
   btn_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png")));
   btn_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png")));
   btn_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png")));
   btn_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png")));
   btn_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png")));
   btn_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png")));
   btn_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png")));
   btn_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png")));
   btn_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png")));
   btn_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png")));
   btn_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png")));
   btn_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png")));
   btn_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png")));
   btn_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png")));
  }
  
  
  public String find_winner(){
      String winner = null;
      int point_p1=0;
      int point_p2=0;
      int land_counter_p1=0;
      int land_counter_p2=0;
      int price_calculator_p1=0;
      int price_calculator_p2=0;
      int money_calculator_p1=0;
      int money_calculator_p2=0;
      if (lbl_tourlimit.getText().equals("0")) {
          for (int i = 0; i <price.length; i++) {
              if (land_p1[i]==1) {
                  land_counter_p1++;
                  price_calculator_p1+=price[i];
                  
              }
              else if (land_p2[i]==1) {
                  land_counter_p2++;
                  price_calculator_p2+=price[i];
              }
          }
      }
      money_calculator_p1=price_calculator_p1+Integer.parseInt(lbl_bankp1.getText());
      money_calculator_p2=price_calculator_p2+Integer.parseInt(lbl_bankp2.getText());
      if (land_counter_p1>land_counter_p2) {
          point_p1++;
      }
      else{
          point_p2++;
      }
      if (price_calculator_p1>price_calculator_p2) {
          point_p1++;
      }
      else{
          point_p2++;
      }
          
      if (money_calculator_p1>money_calculator_p2) {
          point_p1++;
      }
      else{
          point_p2++;
      }
      
      if (point_p1>point_p2) {
          winner="Player 1";
      }
      else {
          winner="Player 2";
      }
      
      
      
      return winner;
  }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_photo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_money1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_rentt = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pl_p1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbl_photo2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_money2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_rent2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pll_p2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btn_1 = new javax.swing.JButton();
        btn_16 = new javax.swing.JButton();
        btn_15 = new javax.swing.JButton();
        btn_14 = new javax.swing.JButton();
        btn_2 = new javax.swing.JButton();
        btn_3 = new javax.swing.JButton();
        btn_4 = new javax.swing.JButton();
        btn_5 = new javax.swing.JButton();
        btn_7 = new javax.swing.JButton();
        btn_8 = new javax.swing.JButton();
        btn_9 = new javax.swing.JButton();
        btn_13 = new javax.swing.JButton();
        btn_12 = new javax.swing.JButton();
        btn_6 = new javax.swing.JButton();
        btn_10 = new javax.swing.JButton();
        btn_11 = new javax.swing.JButton();
        lbl_dice = new javax.swing.JLabel();
        btn_dice = new javax.swing.JButton();
        pl_p2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        pl_p3 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btn_upgrade = new javax.swing.JButton();
        btn_pas = new javax.swing.JButton();
        btn_buy = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        lbl_price = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lbl_rent = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lbl_player = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        lbl_place = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        turn_pl = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        lbl_tourlimit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lbl_bankp2 = new javax.swing.JLabel();
        btn_takep1 = new javax.swing.JButton();
        btn_takep2 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        txt_value1 = new javax.swing.JTextField();
        lbl_bankp1 = new javax.swing.JLabel();
        txt_value2 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        tour_limit1 = new javax.swing.JMenuItem();
        tour_limit2 = new javax.swing.JMenuItem();
        tour_limit3 = new javax.swing.JMenuItem();
        tour_limit4 = new javax.swing.JMenuItem();
        tour_limit5 = new javax.swing.JMenuItem();
        quit = new javax.swing.JMenuItem();
        menu_rules = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        jMenu5.setText("jMenu5");

        jMenuItem1.setText("jMenuItem1");

        jMenu8.setText("jMenu8");

        jMenu9.setText("File");
        jMenuBar2.add(jMenu9);

        jMenu10.setText("Edit");
        jMenuBar2.add(jMenu10);

        jMenu11.setText("jMenu11");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Player 1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Money");

        lbl_money1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Rent Amount");

        lbl_rentt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Location");

        pl_p1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lbl_rentt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_money1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(lbl_photo1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pl_p1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lbl_photo1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_money1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_rentt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pl_p1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Player 2", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Money");

        lbl_money2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Rent Amount");

        lbl_rent2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Location");

        pll_p2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pll_p2.setPreferredSize(new java.awt.Dimension(3, 17));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lbl_rent2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_money2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(lbl_photo2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pll_p2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lbl_photo2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_money2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_rent2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pll_p2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btn_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_1ActionPerformed(evt);
            }
        });

        btn_16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/money_1.png"))); // NOI18N
        btn_16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_16ActionPerformed(evt);
            }
        });

        btn_15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_15ActionPerformed(evt);
            }
        });

        btn_14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_14ActionPerformed(evt);
            }
        });

        btn_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_2ActionPerformed(evt);
            }
        });

        btn_3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_3ActionPerformed(evt);
            }
        });

        btn_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_4ActionPerformed(evt);
            }
        });

        btn_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_5ActionPerformed(evt);
            }
        });

        btn_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_7ActionPerformed(evt);
            }
        });

        btn_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_8ActionPerformed(evt);
            }
        });

        btn_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_9ActionPerformed(evt);
            }
        });

        btn_13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_13ActionPerformed(evt);
            }
        });

        btn_12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_12ActionPerformed(evt);
            }
        });

        btn_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_6ActionPerformed(evt);
            }
        });

        btn_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_10ActionPerformed(evt);
            }
        });

        btn_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_11ActionPerformed(evt);
            }
        });

        btn_dice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_dice.setText("Roll The Dice");
        btn_dice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_diceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btn_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(lbl_dice, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(btn_dice, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(btn_16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(btn_dice)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_dice, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pl_p2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pl_p2.setText("1");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("2");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("3");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("4");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("5");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("6");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("7");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("8");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("9");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("10");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("11");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("12");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("13");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("14");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("15");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("16");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("9");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("6");

        pl_p3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pl_p3.setText("1");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("14");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btn_upgrade.setText("UPGRADE");
        btn_upgrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_upgradeActionPerformed(evt);
            }
        });

        btn_pas.setText("PASS / NEXT");
        btn_pas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pasActionPerformed(evt);
            }
        });

        btn_buy.setText("BUY");
        btn_buy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buyActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Price");

        lbl_price.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Rent");

        lbl_rent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Player");

        lbl_player.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Place");

        lbl_place.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 204));
        jLabel35.setText("Turn :");

        turn_pl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        turn_pl.setForeground(new java.awt.Color(0, 0, 204));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 0, 0));
        jLabel36.setText("Remaining Tour :");

        lbl_tourlimit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_tourlimit.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_place, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_player, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(turn_pl, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(lbl_price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_rent, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_tourlimit, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_buy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_upgrade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_pas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_upgrade)
                    .addComponent(jLabel27)
                    .addComponent(jLabel29)
                    .addComponent(jLabel31)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_buy)
                            .addComponent(lbl_rent, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_pas)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_tourlimit, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_place, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                            .addComponent(lbl_player, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(turn_pl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bank.png"))); // NOI18N

        jLabel26.setText("Player 1 Money");

        btn_takep1.setText("Take(P1)");
        btn_takep1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_takep1ActionPerformed(evt);
            }
        });

        btn_takep2.setText("Take(P2)");
        btn_takep2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_takep2ActionPerformed(evt);
            }
        });

        jLabel30.setText("Player 2 Money");

        jLabel28.setText("TL");

        jLabel32.setText("TL");

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bank.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel20)
                        .addGap(90, 90, 90)
                        .addComponent(jLabel19)
                        .addGap(88, 88, 88)
                        .addComponent(jLabel18)
                        .addGap(94, 94, 94)
                        .addComponent(jLabel17)
                        .addGap(86, 86, 86)
                        .addComponent(jLabel16)
                        .addGap(96, 96, 96)
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(pl_p3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jLabel8)
                        .addGap(100, 100, 100)
                        .addComponent(jLabel9)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(jLabel11)
                        .addGap(94, 94, 94)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23)
                            .addComponent(pl_p2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbl_bankp2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel32))
                                    .addComponent(txt_value2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_takep2)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_value1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_takep1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_bankp1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28))
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel24))
                        .addGap(5, 5, 5)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel12)
                        .addGap(91, 91, 91)
                        .addComponent(jLabel13)
                        .addGap(88, 88, 88)
                        .addComponent(jLabel14)
                        .addGap(90, 90, 90)
                        .addComponent(jLabel21)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel26)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_bankp1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_value1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btn_takep1)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(jLabel18)
                                .addComponent(jLabel17)
                                .addComponent(jLabel16))
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel30)
                                .addGap(5, 5, 5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_bankp2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_value2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(btn_takep2))
                            .addComponent(jLabel2))
                        .addGap(5, 5, 5))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pl_p3)
                    .addComponent(jLabel8))
                .addGap(50, 50, 50)
                .addComponent(pl_p2)
                .addGap(83, 83, 83)
                .addComponent(jLabel23)
                .addGap(94, 94, 94)
                .addComponent(jLabel22)
                .addGap(93, 93, 93)
                .addComponent(jLabel25))
        );

        jMenu6.setText("Options");

        tour_limit1.setText("Tour Limit = 50");
        tour_limit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tour_limit1ActionPerformed(evt);
            }
        });
        jMenu6.add(tour_limit1);

        tour_limit2.setText("Tour Limit = 100");
        tour_limit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tour_limit2ActionPerformed(evt);
            }
        });
        jMenu6.add(tour_limit2);

        tour_limit3.setText("Tour Limit = 150");
        tour_limit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tour_limit3ActionPerformed(evt);
            }
        });
        jMenu6.add(tour_limit3);

        tour_limit4.setText("Tour Limit = 200");
        tour_limit4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tour_limit4ActionPerformed(evt);
            }
        });
        jMenu6.add(tour_limit4);

        tour_limit5.setText("Tour Limit = 250");
        tour_limit5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tour_limit5ActionPerformed(evt);
            }
        });
        jMenu6.add(tour_limit5);

        quit.setText("Quit");
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });
        jMenu6.add(quit);

        jMenuBar1.add(jMenu6);

        menu_rules.setText("Rules");
        menu_rules.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_rulesMouseClicked(evt);
            }
        });
        jMenuBar1.add(menu_rules);

        jMenu12.setText("Version 1.0");
        jMenuBar1.add(jMenu12);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_diceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_diceActionPerformed
        if (is_tour_selected==0) {
            JOptionPane.showMessageDialog(null,"You should choose the tour limit from Options");
        }
        else{
         btn_dice.setEnabled(false);
        ab=1;
        turn++;
        if (turn%2==1) {
              try{ 
            dice=r.nextInt(6);
            //JOptionPane.showMessageDialog(null,dice[i]);
            if (dice==1) {
            lbl_dice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dice_1.png")));
                if (place_p1!=16) {
            place_p1=(place_p1+1)%16;         
                }
                else{
                    place_p1=16;
                }
            
        
            
            }
            else if(dice==2){
            lbl_dice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dice_2.png")));
           if (place_p1!=16) {
            place_p1=(place_p1+2)%16;         
                }
                else{
                    place_p1=16;
                }
            
           
            }
             else if(dice==3){
            lbl_dice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dice_3.png")));
      if (place_p1!=16) {
            place_p1=(place_p1+3)%16;         
                }
                else{
                    place_p1=16;
                }
            
            
            }
             else if(dice==4){
            lbl_dice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dice_4.png")));
           if (place_p1!=16) {
            place_p1=(place_p1+4)%16;         
                }
                else{
                    place_p1=16;
                }
            
           
            }
             else if(dice==5){
            lbl_dice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dice_5.png")));
            if (place_p1!=16) {
            place_p1=(place_p1+5)%16;         
                }
                else{
                    place_p1=16;
                }
            
          
            }
             else {
            lbl_dice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dice_6.png")));
           if (place_p1!=16) {
            place_p1=(place_p1+6)%16;         
                }
                else{
                    place_p1=16;
                }
            
          
             }
        
            TimeUnit.MILLISECONDS.sleep(200);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
    // turn_pl.setText("Player 2");
     pl_p1.setText(Integer.toString(place_p1));
      
        }
        else{
              try{
           
           
           dice=r.nextInt(6);
          //JOptionPane.showMessageDialog(null,dice[i]);
            if (dice==1) {
            lbl_dice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dice_1.png"))); 
          if (place_p2!=16) {
            place_p2=(place_p2+1)%16;         
                }
                else{
                    place_p2=16;
                }
            
         
            }
            else if(dice==2){
            lbl_dice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dice_2.png")));
          if (place_p2!=16) {
            place_p2=(place_p2+2)%16;         
                }
                else{
                    place_p2=16;
                }
            
         
            }
            else if(dice==3){
            lbl_dice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dice_3.png")));
          if (place_p2!=16) {
            place_p2=(place_p2+3)%16;         
                }
                else{
                    place_p2=16;
                }
            
          
            }
            else if(dice==4){
            lbl_dice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dice_4.png")));
          if (place_p2!=16) {
            place_p2=(place_p2+4)%16;         
                }
                else{
                    place_p2=16;
                }
            
       
            }
            else if(dice==5){
            lbl_dice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dice_5.png")));
            if (place_p2!=16) {
            place_p2=(place_p2+5)%16;         
                }
                else{
                    place_p2=16;
                }
            
      
            }
            else {
            lbl_dice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dice_6.png")));
           if (place_p2!=16) {
            place_p2=(place_p2+6)%16;         
                }
                else{
                    place_p2=16;
                }
            
      
             }
        
            TimeUnit.MILLISECONDS.sleep(200);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
    
              if (place_p2==16 || place_p2==0) {
              pll_p2.setText(Integer.toString(16));   
            }
              else{
      pll_p2.setText(Integer.toString(place_p2));
        }
        }
              if (turn==1) {
      turn_pl.setText("Player 1");             
            }   
        }
        
        
    }//GEN-LAST:event_btn_diceActionPerformed

    private void btn_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_1ActionPerformed
       // if turn player 
       // kira oranları için ayrı bilgiler girilebilir(yeni dizi oluşturulabilir)
      //Upgrade ve buy aynı anda gözüküyor bu bir hata bunu çözmeliyiz
        
        if (turn%2==1 && place_p1==1) {
            lbl_place.setText("1");
          
            lbl_price.setText(Integer.toString(price[0])+" TL");
            lbl_rent.setText(Integer.toString((price[0]/10))+" TL");
           
        }
        else if(turn%2==0 && place_p2==1){
           lbl_place.setText("1");
        
           lbl_price.setText(Integer.toString(price[0])+" TL"); 
           lbl_rent.setText(Integer.toString((price[0]/10))+" TL");
     
        }
        if (land_p1[0]==1) {
           lbl_player.setText("Player 1");
        }
        else if(land_p2[0]==1){
            lbl_player.setText("Player 2");
        }
        int place=Integer.parseInt(lbl_place.getText());
        if (upgrade[place-1]>=1) {
            btn_buy.setVisible(false);
        }
        else{
            btn_buy.setVisible(true);
        }
        if ((lbl_player.getText().equals(turn_pl.getText()) && (land_p1[0]==1  || land_p2[0]==1))) {
           btn_upgrade.setVisible(true);
        }
        else{
            btn_upgrade.setVisible(false);
            
        }
              
    }//GEN-LAST:event_btn_1ActionPerformed

    private void btn_pasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pasActionPerformed
        if (ab==0) {
           // turn++;
            JOptionPane.showMessageDialog(null,"You should roll the dice!");
        }
        else{
            btn_dice.setEnabled(true);
        ab=0;
       lbl_dice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty.png")));
        
            
         
            
        
        if (turn%2==1) {
             turn_pl.setText("Player 2");
             turn_p2++;
        }
        else{
             turn_pl.setText("Player 1");
             turn_p1++;
        }
        int total_p1=0;
        for (int i = 0; i <land_p1.length; i++) {
            if (land_p1[i]==1) {
                total_p1=total_p1+price[i];
            }
        }
        lbl_rentt.setText(Integer.toString(total_p1/10));
        int total_p2=0;
        for (int i = 0; i <land_p2.length; i++) {
            if (land_p2[i]==1) {
                total_p2=total_p2+price[i];
            }
        }
        lbl_rent2.setText(Integer.toString(total_p2/10));
        
        
         int x=Integer.parseInt(pl_p1.getText());
         int y=Integer.parseInt(lbl_rentt.getText());
                 if (turn%2==1) {
                     if (pl_p1.getText().equals("0") || pl_p1.getText().equals("16")) {
                          a=r.nextInt(1200);
                          int response=JOptionPane.showConfirmDialog(this,"You earned "+a+" TL"+"\n YES)Add to my money "+"\n NO)Add to my bank(+%10 for 5 tour)","Money Award!",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                          if (response==JOptionPane.YES_OPTION) {
                          money[0]=money[0]+a;
                          lbl_money1.setText(Integer.toString(money[0]));   
                         }
                          else if (response==JOptionPane.NO_OPTION){
                              bank_p1=bank_p1+a;
                              lbl_bankp1.setText(Integer.toString(bank_p1));
                          }
                         
                          //deneme
                         
                     }
                     
        }
        else{
                     if (pll_p2.getText().equals("0")|| pll_p2.getText().equals("16")) {
                           a=r.nextInt(1200);
                                  int response=JOptionPane.showConfirmDialog(this,"You earned "+a+" TL"+"\n YES)Add to my money "+"\n NO)Add to my bank(+%35 for 5 tour)","Money Award!",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                         if (response==JOptionPane.YES_OPTION) {
                               money[1]=money[1]+a;
            lbl_money2.setText(Integer.toString(money[1]));
                         }
                         else if (response==JOptionPane.NO_OPTION){
                           bank_p2=bank_p2+a;
                           lbl_bankp2.setText(Integer.toString(bank_p2));
                             
                         }
                     }
           
        }
                 
                 
                 
                 // yes no sordurucaz
                  //  int response=JOptionPane.showConfirmDialog(this,"You earned "+a+" TL"+"\n YES)Add to my money "+"\n NO)Add to my bank(%10 for 5 tour)","Taksit",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (turn_p1%5==0 && turn_p2%5==0) {
                
                int m=Integer.parseInt(lbl_bankp1.getText());
             m=m+(m*35)/100;
             lbl_bankp1.setText(Integer.toString(m));
             
             int n=Integer.parseInt(lbl_bankp2.getText());
             n=n+(35*n)/100;
             lbl_bankp2.setText(Integer.toString(n));
             
            }
      
                 if (turn_p1%5==0) {
              money[0]=money[0]+y;
        }
                if (turn_p2%5==0) {
              money[1]=money[1]+Integer.parseInt(lbl_rent2.getText());
               
        }
          JOptionPane.showMessageDialog(null,turn_p1+" ,  "+turn_p2);
          lbl_money1.setText(Integer.toString(money[0])+" TL");
          lbl_money2.setText(Integer.toString(money[1])+" TL");
        
        }
        calculate_turn();
    }//GEN-LAST:event_btn_pasActionPerformed

    private void btn_upgradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_upgradeActionPerformed
       int placee=Integer.parseInt(lbl_place.getText());
//2.upgrade e özel  3.ye özel tasarlanmalı !!!
if (upgrade[placee-1]==1) {
            
        
        if (placee==1) {
            
        
             if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==1))) {
          
                 if (money[0]-200>0) {
                     money[0]=money[0]-200;
                       upgrade[0]=2;
                        price[0]=price[0]+200;
            btn_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));
            lbl_price.setText(Integer.toString(price[0])+" TL");
              lbl_rent.setText(Integer.toString((price[0]/10))+" TL");

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
          else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==1))){
                if (money[1]-200>0) {
                     money[1]=money[1]-200;
                       upgrade[0]=2;
                       price[0]=price[0]+200;
                          lbl_price.setText(Integer.toString(price[0])+" TL");
                            lbl_rent.setText(Integer.toString((price[0]/10))+" TL");
            btn_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }}}
                
        else if(placee==2){
             if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==2))) {
          
                 if (money[0]-200>0) {
                     money[0]=money[0]-200;
                       upgrade[0]=2;
                        price[1]=price[1]+200;
                           lbl_price.setText(Integer.toString(price[1])+" TL");
                             lbl_rent.setText(Integer.toString((price[1]/10))+" TL");
            btn_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==2))){
                if (money[1]-200>0) {
                     money[1]=money[1]-200;
                       upgrade[1]=2;
                        price[1]=price[1]+200;
                           lbl_price.setText(Integer.toString(price[1])+" TL");
                             lbl_rent.setText(Integer.toString((price[1]/10))+" TL");
            btn_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
                
            
        }}
        else if(placee==3){
        
             if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==3))) {
          
                 if (money[0]-200>0) {
                     money[0]=money[0]-200;
                       upgrade[2]=2;
                        price[2]=price[2]+200;
                           lbl_price.setText(Integer.toString(price[2])+" TL");
                             lbl_rent.setText(Integer.toString((price[2]/10))+" TL");
            btn_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==3))){
                if (money[1]-200>0) {
                     money[1]=money[1]-200;
                       upgrade[2]=2;
                        price[2]=price[2]+200;
                           lbl_price.setText(Integer.toString(price[2])+" TL");
                             lbl_rent.setText(Integer.toString((price[2]/10))+" TL");
            btn_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        else if(placee==4){
             
              if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==4))) {
          
                 if (money[0]-200>0) {
                     money[0]=money[0]-200;
                       upgrade[3]=2;
                        price[3]=price[3]+200;
                           lbl_price.setText(Integer.toString(price[3])+" TL");
                             lbl_rent.setText(Integer.toString((price[3]/10))+" TL");
            btn_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==4))){
                if (money[1]-200>0) {
                     money[1]=money[1]-200;
                       upgrade[3]=2;
                         price[3]=price[3]+200;
                            lbl_price.setText(Integer.toString(price[3])+" TL");
                              lbl_rent.setText(Integer.toString((price[3]/10))+" TL");
            btn_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        
        else if(placee==5){
            
        
              
               if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==5))) {
          
                 if (money[0]-200>0) {
                     money[0]=money[0]-200;
                       upgrade[4]=2;
                         price[4]=price[4]+200;
                            lbl_price.setText(Integer.toString(price[4])+" TL");
                              lbl_rent.setText(Integer.toString((price[4]/10))+" TL");
            btn_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==5))){
                if (money[1]-200>0) {
                     money[1]=money[1]-200;
                       upgrade[4]=2;
                         price[4]=price[4]+200;
                            lbl_price.setText(Integer.toString(price[4])+" TL");
                              lbl_rent.setText(Integer.toString((price[4]/10))+" TL");
            btn_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        
        else if(placee==6){
               
                if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==6))) {
          
                 if (money[0]-200>0) {
                     money[0]=money[0]-200;
                       upgrade[5]=2;
                         price[5]=price[5]+200;
                            lbl_price.setText(Integer.toString(price[5])+" TL");
                              lbl_rent.setText(Integer.toString((price[5]/10))+" TL");
            btn_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==6))){
                if (money[1]-200>0) {
                     money[1]=money[1]-200;
                       upgrade[5]=2;
                         price[5]=price[5]+200;
                            lbl_price.setText(Integer.toString(price[5])+" TL");
                              lbl_rent.setText(Integer.toString((price[5]/10))+" TL");
            btn_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        
        else if(placee==7){
       
                
                   if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==7))) {
          
                 if (money[0]-200>0) {
                     money[0]=money[0]-200;
                       upgrade[6]=2;
                         price[6]=price[6]+200;
                            lbl_price.setText(Integer.toString(price[6])+" TL");
                              lbl_rent.setText(Integer.toString((price[6]/10))+" TL");
            btn_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==7))){
                if (money[1]-200>0) {
                     money[1]=money[1]-200;
                       upgrade[6]=2;
                         price[6]=price[6]+200;
                            lbl_price.setText(Integer.toString(price[6])+" TL");
                              lbl_rent.setText(Integer.toString((price[6]/10))+" TL");
            btn_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        
        else if(placee==8){
                   
                      if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==8))) {
          
                 if (money[0]-200>0) {
                     money[0]=money[0]-200;
                       upgrade[7]=2;
                         price[7]=price[7]+200;
                            lbl_price.setText(Integer.toString(price[7])+" TL");
                              lbl_rent.setText(Integer.toString((price[7]/10))+" TL");
            btn_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==8))){
                if (money[1]-200>0) {
                     money[1]=money[1]-200;
                       upgrade[7]=2;
                         price[7]=price[7]+200;
                            lbl_price.setText(Integer.toString(price[7])+" TL");
                              lbl_rent.setText(Integer.toString((price[7]/10))+" TL");
            btn_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        
        else if(placee==9){
                      
                         if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==9))) {
          
                 if (money[0]-200>0) {
                     money[0]=money[0]-200;
                       upgrade[8]=2;
                         price[8]=price[8]+200;
                            lbl_price.setText(Integer.toString(price[8])+" TL");
                              lbl_rent.setText(Integer.toString((price[8]/10))+" TL");
            btn_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==9))){
                if (money[1]-200>0) {
                     money[1]=money[1]-200;
                       upgrade[8]=2;
                         price[8]=price[8]+200;
                            lbl_price.setText(Integer.toString(price[8])+" TL");
                              lbl_rent.setText(Integer.toString((price[8]/10))+" TL");
            btn_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        else if (placee==10) {
            
        
                         
                            if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==10))) {
          
                 if (money[0]-200>0) {
                     money[0]=money[0]-200;
                       upgrade[9]=2;
                         price[9]=price[9]+200;
                            lbl_price.setText(Integer.toString(price[9])+" TL");
                              lbl_rent.setText(Integer.toString((price[9]/10))+" TL");
            btn_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==10))){
                if (money[1]-200>0) {
                     money[1]=money[1]-200;
                       upgrade[9]=2;
                         price[9]=price[9]+200;
                            lbl_price.setText(Integer.toString(price[9])+" TL");
                              lbl_rent.setText(Integer.toString((price[9]/10))+" TL");
            btn_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        
        else if(placee==11){
                            
               if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==11))) {
          
                 if (money[0]-200>0) {
                     money[0]=money[0]-200;
                       upgrade[10]=2;
                         price[10]=price[10]+200;
                            lbl_price.setText(Integer.toString(price[10])+" TL");
                              lbl_rent.setText(Integer.toString((price[10]/10))+" TL");
            btn_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==11))){
                if (money[1]-200>0) {
                     money[1]=money[1]-200;
                       upgrade[10]=2;
                         price[10]=price[10]+200;
                            lbl_price.setText(Integer.toString(price[10])+" TL");
                              lbl_rent.setText(Integer.toString((price[10]/10))+" TL");
            btn_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        
        else if(placee==12){
               
                  if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==12))) {
          
                 if (money[0]-200>0) {
                     money[0]=money[0]-200;
                       upgrade[11]=2;
                         price[11]=price[11]+200;
                            lbl_price.setText(Integer.toString(price[11])+" TL");
                              lbl_rent.setText(Integer.toString((price[11]/10))+" TL");
            btn_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==12))){
                if (money[1]-200>0) {
                     money[1]=money[1]-200;
                       upgrade[11]=2;
                         price[11]=price[11]+200;
                            lbl_price.setText(Integer.toString(price[11])+" TL");
                              lbl_rent.setText(Integer.toString((price[11]/10))+" TL");
            btn_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        
        else if(placee==13){
                  
                     if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==13))) {
          
                 if (money[0]-200>0) {
                     money[0]=money[0]-200;
                       upgrade[12]=2;
                         price[12]=price[12]+200;
                            lbl_price.setText(Integer.toString(price[12])+" TL");
                              lbl_rent.setText(Integer.toString((price[12]/10))+" TL");
            btn_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==13))){
                if (money[1]-200>0) {
                     money[1]=money[1]-200;
                       upgrade[12]=2;
                         price[12]=price[12]+200;
                            lbl_price.setText(Integer.toString(price[12])+" TL");
                              lbl_rent.setText(Integer.toString((price[12]/10))+" TL");
            btn_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        
        else if(placee==14){
                     
                        if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==14))) {
          
                 if (money[0]-200>0) {
                     money[0]=money[0]-200;
                       upgrade[13]=2;
                         price[13]=price[13]+200;
                            lbl_price.setText(Integer.toString(price[13])+" TL");
                              lbl_rent.setText(Integer.toString((price[13]/10))+" TL");
            btn_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==14))){
                if (money[1]-200>0) {
                     money[1]=money[1]-200;
                       upgrade[13]=2;
                         price[13]=price[13]+200;
                            lbl_price.setText(Integer.toString(price[13])+" TL");
                              lbl_rent.setText(Integer.toString((price[13]/10))+" TL");
            btn_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        
        else if(placee==15){
                        
                           if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==15))) {
          
                 if (money[0]-200>0) {
                     money[0]=money[0]-200;
                       upgrade[14]=2;
                         price[14]=price[14]+200;
                            lbl_price.setText(Integer.toString(price[14])+" TL");
                              lbl_rent.setText(Integer.toString((price[14]/10))+" TL");
            btn_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==15))){
                if (money[1]-200>0) {
                     money[1]=money[1]-200;
                       upgrade[14]=2;
                         price[14]=price[14]+200;
                            lbl_price.setText(Integer.toString(price[14])+" TL");
                              lbl_rent.setText(Integer.toString((price[14]/10))+" TL");
            btn_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }
        }
}

else if (upgrade[placee-1]==2){
    
        if (placee==1) {
            
        
             if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==1))) {
          
                 if (money[0]-350>0) {
                     money[0]=money[0]-350;
                       upgrade[0]=3;
                         price[0]=price[0]+350;
                            lbl_price.setText(Integer.toString(price[0])+" TL");
                              lbl_rent.setText(Integer.toString((price[0]/10))+" TL");
            btn_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
          else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==1))){
                if (money[1]-350>0) {
                     money[1]=money[1]-350;
                       upgrade[0]=3;
                         price[0]=price[0]+350;
                            lbl_price.setText(Integer.toString(price[0])+" TL");
                              lbl_rent.setText(Integer.toString((price[0]/10))+" TL");
            btn_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }}}
                
        else if(placee==2){
             if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==2))) {
          
                 if (money[0]-350>0) {
                     money[0]=money[0]-350;
                       upgrade[0]=3;
                         price[1]=price[1]+350;
                            lbl_price.setText(Integer.toString(price[1])+" TL");
                              lbl_rent.setText(Integer.toString((price[1]/10))+" TL");
            btn_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==2))){
                if (money[1]-350>0) {
                     money[1]=money[1]-350;
                       upgrade[1]=3;
                         price[1]=price[1]+350;
                            lbl_price.setText(Integer.toString(price[1])+" TL");
                              lbl_rent.setText(Integer.toString((price[1]/10))+" TL");
            btn_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }       
        }}
        else if(placee==3){
        
             if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==3))) {
          
                 if (money[0]-350>0) {
                     money[0]=money[0]-350;
                       upgrade[2]=3;
                         price[2]=price[2]+350;
                            lbl_price.setText(Integer.toString(price[2])+" TL");
                              lbl_rent.setText(Integer.toString((price[2]/10))+" TL");
            btn_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==3))){
                if (money[1]-350>0) {
                     money[1]=money[1]-350;
                       upgrade[2]=3;
                         price[2]=price[2]+350;
                            lbl_price.setText(Integer.toString(price[2])+" TL");
                              lbl_rent.setText(Integer.toString((price[2]/10))+" TL");
            btn_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        else if(placee==4){
             
              if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==4))) {
          
                 if (money[0]-350>0) {
                     money[0]=money[0]-350;
                       upgrade[3]=3;
                         price[3]=price[3]+350;
                            lbl_price.setText(Integer.toString(price[3])+" TL");
                              lbl_rent.setText(Integer.toString((price[3]/10))+" TL");
            btn_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==4))){
                if (money[1]-350>0) {
                     money[1]=money[1]-350;
                       upgrade[3]=3;
                         price[3]=price[3]+350;
                            lbl_price.setText(Integer.toString(price[3])+" TL");
                              lbl_rent.setText(Integer.toString((price[3]/10))+" TL");
            btn_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        
        else if(placee==5){
            
        
              
               if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==5))) {
          
                 if (money[0]-350>0) {
                     money[0]=money[0]-350;
                       upgrade[4]=3;
                         price[4]=price[4]+350;
                            lbl_price.setText(Integer.toString(price[4])+" TL");
                              lbl_rent.setText(Integer.toString((price[4]/10))+" TL");
            btn_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==5))){
                if (money[1]-350>0) {
                     money[1]=money[1]-350;
                       upgrade[4]=3;
                         price[4]=price[4]+350;
                            lbl_price.setText(Integer.toString(price[4])+" TL");
                              lbl_rent.setText(Integer.toString((price[4]/10))+" TL");
            btn_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        
        else if(placee==6){
               
                if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==6))) {
          
                 if (money[0]-350>0) {
                     money[0]=money[0]-350;
                       upgrade[5]=3;
                         price[5]=price[5]+350;
                            lbl_price.setText(Integer.toString(price[5])+" TL");
                              lbl_rent.setText(Integer.toString((price[5]/10))+" TL");
            btn_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==6))){
                if (money[1]-350>0) {
                     money[1]=money[1]-350;
                       upgrade[5]=3;
                         price[5]=price[5]+350;
                            lbl_price.setText(Integer.toString(price[5])+" TL");
                              lbl_rent.setText(Integer.toString((price[5]/10))+" TL");
            btn_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        
        else if(placee==7){
       
                
                   if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==7))) {
          
                 if (money[0]-350>0) {
                     money[0]=money[0]-350;
                       upgrade[6]=3;
                         price[6]=price[6]+350;
                            lbl_price.setText(Integer.toString(price[6])+" TL");
                              lbl_rent.setText(Integer.toString((price[6]/10))+" TL");
            btn_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==7))){
                if (money[1]-350>0) {
                     money[1]=money[1]-350;
                       upgrade[6]=3;
                         price[6]=price[6]+350;
                            lbl_price.setText(Integer.toString(price[6])+" TL");
                              lbl_rent.setText(Integer.toString((price[6]/10))+" TL");
            btn_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        
        else if(placee==8){
                   
                      if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==8))) {
          
                 if (money[0]-350>0) {
                     money[0]=money[0]-350;
                       upgrade[7]=3;
                         price[7]=price[7]+350;
                            lbl_price.setText(Integer.toString(price[7])+" TL");
                              lbl_rent.setText(Integer.toString((price[7]/10))+" TL");
            btn_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==8))){
                if (money[1]-350>0) {
                     money[1]=money[1]-350;
                       upgrade[7]=3;
                         price[7]=price[7]+350;
                            lbl_price.setText(Integer.toString(price[7])+" TL");
                              lbl_rent.setText(Integer.toString((price[7]/10))+" TL");
            btn_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        
        else if(placee==9){
                      
                         if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==9))) {
          
                 if (money[0]-350>0) {
                     money[0]=money[0]-350;
                       upgrade[8]=3;
                         price[8]=price[8]+350;
                            lbl_price.setText(Integer.toString(price[8])+" TL");
                              lbl_rent.setText(Integer.toString((price[8]/10))+" TL");
            btn_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==9))){
                if (money[1]-350>0) {
                     money[1]=money[1]-350;
                       upgrade[8]=3;
                         price[8]=price[8]+350;
                            lbl_price.setText(Integer.toString(price[8])+" TL");
                              lbl_rent.setText(Integer.toString((price[8]/10))+" TL");
            btn_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        else if (placee==10) {
            
        
                         
                            if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==10))) {
          
                 if (money[0]-350>0) {
                     money[0]=money[0]-350;
                       upgrade[9]=3;
                         price[9]=price[9]+350;
                            lbl_price.setText(Integer.toString(price[9])+" TL");
                              lbl_rent.setText(Integer.toString((price[9]/10))+" TL");
            btn_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==10))){
                if (money[1]-350>0) {
                     money[1]=money[1]-350;
                       upgrade[9]=3;
                         price[9]=price[9]+350;
                            lbl_price.setText(Integer.toString(price[9])+" TL");
                              lbl_rent.setText(Integer.toString((price[9]/10))+" TL");
            btn_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        
        else if(placee==11){
                            
               if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==11))) {
          
                 if (money[0]-350>0) {
                     money[0]=money[0]-350;
                       upgrade[10]=3;
                         price[10]=price[10]+350;
                            lbl_price.setText(Integer.toString(price[10])+" TL");
                              lbl_rent.setText(Integer.toString((price[10]/10))+" TL");
            btn_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==11))){
                if (money[1]-350>0) {
                     money[1]=money[1]-350;
                       upgrade[10]=3;
                         price[10]=price[10]+350;
                            lbl_price.setText(Integer.toString(price[10])+" TL");
                              lbl_rent.setText(Integer.toString((price[10]/10))+" TL");
            btn_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        
        else if(placee==12){
               
                  if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==12))) {
          
                 if (money[0]-350>0) {
                     money[0]=money[0]-350;
                       upgrade[11]=3;
                         price[11]=price[11]+350;
                            lbl_price.setText(Integer.toString(price[11])+" TL");
                              lbl_rent.setText(Integer.toString((price[11]/10))+" TL");
            btn_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==12))){
                if (money[1]-350>0) {
                     money[1]=money[1]-350;
                       upgrade[11]=3;
                         price[11]=price[11]+350;
                            lbl_price.setText(Integer.toString(price[11])+" TL");
                              lbl_rent.setText(Integer.toString((price[11]/10))+" TL");
            btn_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        
        else if(placee==13){
                  
                     if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==13))) {
          
                 if (money[0]-350>0) {
                     money[0]=money[0]-350;
                       upgrade[12]=3;
                         price[12]=price[12]+350;
                            lbl_price.setText(Integer.toString(price[12])+" TL");
                              lbl_rent.setText(Integer.toString((price[12]/10))+" TL");
            btn_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==13))){
                if (money[1]-350>0) {
                     money[1]=money[1]-350;
                       upgrade[12]=3;
                         price[12]=price[12]+350;
                            lbl_price.setText(Integer.toString(price[12])+" TL");
                              lbl_rent.setText(Integer.toString((price[12]/10))+" TL");
            btn_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        
        else if(placee==14){
                     
                        if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==14))) {
          
                 if (money[0]-350>0) {
                     money[0]=money[0]-350;
                       upgrade[13]=3;
                         price[13]=price[13]+350;
                            lbl_price.setText(Integer.toString(price[13])+" TL");
                              lbl_rent.setText(Integer.toString((price[13]/10))+" TL");
            btn_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==14))){
                if (money[1]-350>0) {
                     money[1]=money[1]-350;
                       upgrade[13]=3;
                         price[13]=price[13]+350;
                            lbl_price.setText(Integer.toString(price[13])+" TL");
                              lbl_rent.setText(Integer.toString((price[13]/10))+" TL");
            btn_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        
        else if(placee==15){
                        
                           if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==15))) {
          
                 if (money[0]-350>0) {
                     money[0]=money[0]-350;
                       upgrade[14]=3;
                         price[14]=price[14]+350;
                            lbl_price.setText(Integer.toString(price[14])+" TL");
                              lbl_rent.setText(Integer.toString((price[14]/10))+" TL");
            btn_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==15))){
                if (money[1]-350>0) {
                     money[1]=money[1]-350;
                       upgrade[14]=3;
                         price[14]=price[14]+350;
                            lbl_price.setText(Integer.toString(price[14])+" TL");
                              lbl_rent.setText(Integer.toString((price[14]/10))+" TL");
            btn_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building2.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }
        }
    
            
        }
else if(upgrade[placee-1]>=3){
    JOptionPane.showMessageDialog(null,"Upgrades are Full!");
}
        /*
        else if (placee==16) {
            
        
                           
             if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==16))) {
          
                 if (money[0]-200>0) {
                     money[0]=money[0]-200;
                       upgrade[15]=2;
            btn_16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
        }
             
             else if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p2==16))){
                if (money[1]-200>0) {
                     money[1]=money[1]-200;
                       upgrade[15]=2;
            btn_16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building3.png")));

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"You Have not money enough for upgrade the building");
                 }
             }}
        */
        lbl_money1.setText(Integer.toString(money[0])+" TL");
        lbl_money2.setText(Integer.toString(money[1])+" TL");
        calculate_turn();
    }//GEN-LAST:event_btn_upgradeActionPerformed

    private void btn_buyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buyActionPerformed
       int place=Integer.parseInt(lbl_place.getText());
        
        if (place==1) {
             
             
              if (turn%2==1) {
           
             land_p1[0]=1;
                  if (money[0]-price[0]>0) {
                      money[0]=money[0]-price[0];
                    
                       btn_1.setBackground(Color.YELLOW);
                        btn_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                         upgrade[0]=1;
                       
                       
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }     
        }
        else{
           
             land_p2[0]=1;
                if (money[1]-price[0]>0) {
                      money[1]=money[1]-price[0];
                       btn_1.setBackground(Color.RED);
                        btn_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                         upgrade[0]=1;
                       
                       
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                     
                  }
        }
            
        }
        else if(place==2){
              //btn_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
             
                if (turn%2==1) {
           
             land_p1[1]=1;
                if (money[0]-price[1]>0) {
                      money[0]=money[0]-price[1];
                          btn_2.setBackground(Color.YELLOW);
                           btn_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                            upgrade[1]=1;
                       
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
               
        }
        else{
           
             land_p2[1]=1;
                if (money[1]-price[1]>0) {
                      money[1]=money[1]-price[1];
                       btn_2.setBackground(Color.RED);
                        btn_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                         upgrade[1]=1;
                     
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
        }
        }
        else if(place==3){
              btn_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
              
                if (turn%2==1) {
           
             land_p1[2]=1;
                if (money[0]-price[2]>0) {
                      money[0]=money[0]-price[2];
                         btn_3.setBackground(Color.YELLOW);
                          btn_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                          upgrade[2]=1;
                    
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
                
        }
        else{
           
             land_p2[2]=1;
                if (money[1]-price[2]>0) {
                      money[1]=money[1]-price[2];
                       btn_3.setBackground(Color.RED);
                        btn_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                        upgrade[2]=1;
                      
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
        }
        }
          else if(place==4){
             
              
                if (turn%2==1) {
           
             land_p1[3]=1;
                if (money[0]-price[3]>0) {
                      money[0]=money[0]-price[3];
                       btn_4.setBackground(Color.YELLOW);
                        btn_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                        upgrade[3]=1;
                     
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
                  
        }
        else{
           
             land_p2[3]=1;
                if (money[1]-price[3]>0) {
                      money[1]=money[1]-price[3];
                       btn_4.setBackground(Color.RED);
                        btn_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                        upgrade[3]=1;
                       
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
        }
        }
          else if(place==5){
             
             
                if (turn%2==1) {
           
             land_p1[4]=1;
                if (money[0]-price[4]>0) {
                      money[0]=money[0]-price[4];
                         btn_5.setBackground(Color.YELLOW);
                          btn_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                           upgrade[4]=1;
                          
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
                
        }
        else{
           
             land_p2[4]=1;
                if (money[1]-price[4]>0) {
                      money[1]=money[1]-price[4];
                       btn_5.setBackground(Color.RED);
                        btn_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                         upgrade[4]=1;
                        
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
        }
        }
          else if(place==6){
            
            
                if (turn%2==1) {
           
             land_p1[5]=1;
                if (money[0]-price[5]>0) {
                      money[0]=money[0]-price[5];
                      btn_6.setBackground(Color.YELLOW);
                        btn_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                          upgrade[5]=1;
                      
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
                   
        }
        else{
           
             land_p2[5]=1;
                if (money[1]-price[5]>0) {
                      money[1]=money[1]-price[5];
                       btn_6.setBackground(Color.RED);
                        btn_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                          upgrade[5]=1;
                       
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
        }
        }
          else if(place==7){
             
            
                if (turn%2==1) {
           
             land_p1[6]=1;
                if (money[0]-price[6]>0) {
                      money[0]=money[0]-price[6];
                          btn_7.setBackground(Color.YELLOW);
                           btn_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                             upgrade[6]=1;
                             
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
               
        }
        else{
           
             land_p2[6]=1;
                if (money[1]-price[6]>0) {
                      money[1]=money[1]-price[6];
                       btn_7.setBackground(Color.RED);
                        btn_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                          upgrade[6]=1;
                          
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
        }
        }
          else if(place==8){
             
            
                if (turn%2==1) {
           
             land_p1[7]=1;
                if (money[0]-price[7]>0) {
                      money[0]=money[0]-price[7];
                      
                   btn_8.setBackground(Color.YELLOW);
                    btn_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                      upgrade[7]=1;
                      
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
        }
        else{
           
             land_p2[7]=1;
                if (money[1]-price[7]>0) {
                      money[1]=money[1]-price[7];
                       btn_8.setBackground(Color.RED);
                        btn_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                          upgrade[7]=1;
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
        }
        }
          else if(place==9){
            
              
                if (turn%2==1) {
           
             land_p1[8]=1;
                if (money[0]-price[8]>0) {
                      money[0]=money[0]-price[8];
                       btn_9.setBackground(Color.YELLOW);
                         btn_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                         upgrade[8]=1;
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
                  
        }
        else{
           
             land_p2[8]=1;
                if (money[1]-price[8]>0) {
                      money[1]=money[1]-price[8];
                       btn_9.setBackground(Color.RED);
                        btn_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                        upgrade[8]=1;
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
        }
        }
          else if(place==10){
              
           
                if (turn%2==1) {
           
             land_p1[9]=1;
                if (money[0]-price[9]>0) {
                      money[0]=money[0]-price[9];
                       btn_10.setBackground(Color.YELLOW);
                       btn_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                          upgrade[9]=1;
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
                  
        }
        else{
           
             land_p2[9]=1;
                if (money[1]-price[9]>0) {
                      money[1]=money[1]-price[9];
                       btn_10.setBackground(Color.RED);
                        btn_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                           upgrade[9]=1;
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
        }
        }
          else if(place==11){
          
              upgrade[10]=1;
                if (turn%2==1) {
           
             land_p1[10]=1;
                if (money[0]-price[10]>0) {
                      money[0]=money[0]-price[10];
                       btn_11.setBackground(Color.YELLOW);
                           btn_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                           upgrade[10]=1;
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
                  
        }
        else{
           
             land_p2[10]=1;
                if (money[1]-price[10]>0) {
                      money[1]=money[1]-price[10];
                       btn_11.setBackground(Color.RED);
                        btn_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                        upgrade[10]=1;
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
        }
        }
          else if(place==12){
            
            
                if (turn%2==1) {
           
             land_p1[11]=1;
                if (money[0]-price[11]>0) {
                      money[0]=money[0]-price[11];
                       btn_12.setBackground(Color.YELLOW);
                         btn_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                           upgrade[11]=1;
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
                  
        }
        else{
           
             land_p2[11]=1;
                if (money[1]-price[11]>0) {
                      money[1]=money[1]-price[11];
                       btn_12.setBackground(Color.RED);
                        btn_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                          upgrade[11]=1;
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
        }
        }
          else if(place==13){
             
             
                if (turn%2==1) {
           
             land_p1[12]=1;
                if (money[0]-price[12]>0) {
                      money[0]=money[0]-price[12];
                       btn_13.setBackground(Color.YELLOW);
                        btn_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                         upgrade[12]=1;
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
                  
        }
        else{
           
             land_p2[12]=1;
                if (money[1]-price[12]>0) {
                      money[1]=money[1]-price[12];
                       btn_13.setBackground(Color.RED);
                        btn_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                         upgrade[12]=1;
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
        }
        }
          else if(place==14){
             
             
                if (turn%2==1) {
           
             land_p1[13]=1;
                if (money[0]-price[13]>0) {
                      money[0]=money[0]-price[13];
                        btn_14.setBackground(Color.YELLOW);
                         btn_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                          upgrade[13]=1;
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  } 
        }
        else{
           
             land_p2[13]=1;
                if (money[1]-price[13]>0) {
                      money[1]=money[1]-price[13];
                       btn_14.setBackground(Color.RED);
                        btn_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                         upgrade[13]=1;
                       
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
        }
        }
          else if(place==15){
              
            
                if (turn%2==1){
           
             land_p1[14]=1;
                if (money[0]-price[14]>0) {
                      money[0]=money[0]-price[14];
                       btn_15.setBackground(Color.YELLOW);
                       btn_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                         upgrade[14]=1;
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
        }
        else{
           
             land_p2[14]=1;
                if (money[1]-price[14]>0) {
                      money[1]=money[1]-price[14];
                       btn_15.setBackground(Color.RED);
                        btn_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                          upgrade[14]=1;
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
        }
        }
       
          /*
          else if(place==16){
             
            
                if (turn%2==1) {
           
             land_p1[15]=1;
                if (money[0]-price[15]>0) {
                      money[0]=money[0]-price[15];
                       btn_16.setBackground(Color.YELLOW);
                        btn_16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                          upgrade[15]=1;
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
        }
        else{
           
             land_p2[15]=1;
                if (money[1]-price[15]>0) {
                      money[1]=money[1]-price[15];
                       btn_16.setBackground(Color.RED);
                        btn_16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/building1.png")));
                          upgrade[15]=1;
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"You haven't money enough for buy this place");
                  }
        }
        }
        */
        
        lbl_money1.setText(Integer.toString(money[0])+" TL");
        lbl_money2.setText(Integer.toString(money[1])+" TL");
        
    }//GEN-LAST:event_btn_buyActionPerformed

    private void btn_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_2ActionPerformed
     
        if (turn%2==1 && place_p1==2) {
            lbl_place.setText("2");
           
            lbl_price.setText(Integer.toString(price[1])+" TL");
            lbl_rent.setText(Integer.toString((price[1]/10))+" TL");
        }
        else if(turn%2==0 && place_p2==2){
           lbl_place.setText("2");
      
           lbl_price.setText(Integer.toString(price[1])+" TL"); 
           lbl_rent.setText(Integer.toString((price[1]/10))+" TL");
        
        }
          if (land_p1[1]==1) {
           lbl_player.setText("Player 1");
        }
        else if(land_p2[1]==1){
            lbl_player.setText("Player 2");
        }
         int place=Integer.parseInt(lbl_place.getText());
        if (upgrade[place-1]>=1) {
            btn_buy.setVisible(false);
        }
        else{
            btn_buy.setVisible(true);
        }
     if ((lbl_player.getText().equals(turn_pl.getText()) && (land_p1[1]==1 || land_p2[1]==1))) {
           btn_upgrade.setVisible(true);
        }
        else{
            btn_upgrade.setVisible(false);
            
        }
              
    }//GEN-LAST:event_btn_2ActionPerformed

    private void btn_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_3ActionPerformed
        
        if (turn%2==1 && place_p1==3) {
            lbl_place.setText("3");
          
            lbl_price.setText(Integer.toString(price[2])+" TL");
            lbl_rent.setText(Integer.toString((price[2]/10))+" TL");
        }
        else if(turn%2==0 && place_p2==3){
           lbl_place.setText("3");
        
           lbl_price.setText(Integer.toString(price[2])+" TL"); 
           lbl_rent.setText(Integer.toString((price[2]/10))+" TL");
        }
          if (land_p1[2]==1) {
           lbl_player.setText("Player 1");
        }
        else if(land_p2[2]==1){
            lbl_player.setText("Player 2");
        }
               int place=Integer.parseInt(lbl_place.getText());
        if (upgrade[place-1]>=1) {
            btn_buy.setVisible(false);
        }
        else{
            btn_buy.setVisible(true);
        }
        if ((lbl_player.getText().equals(turn_pl.getText()) && (land_p1[2]==1  || land_p2[2]==1))) {
           btn_upgrade.setVisible(true);
        }
        else{
            btn_upgrade.setVisible(false);
            
        }
    }//GEN-LAST:event_btn_3ActionPerformed

    private void btn_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_4ActionPerformed
      
        if (turn%2==1 && place_p1==4) {
            lbl_place.setText("4");
         
            lbl_price.setText(Integer.toString(price[3])+" TL");
            lbl_rent.setText(Integer.toString((price[3]/10))+" TL");
        }
        else if(turn%2==0 && place_p2==4){
           lbl_place.setText("4");
      
           lbl_price.setText(Integer.toString(price[3])+" TL"); 
           lbl_rent.setText(Integer.toString((price[3]/10))+" TL");
        }
          if (land_p1[3]==1) {
           lbl_player.setText("Player 1");
        }
        else if(land_p2[3]==1){
            lbl_player.setText("Player 2");
        }
            int place=Integer.parseInt(lbl_place.getText());
        if (upgrade[place-1]>=1) {
            btn_buy.setVisible(false);
        }
        else{
            btn_buy.setVisible(true);
        }     
        if ((lbl_player.getText().equals(turn_pl.getText()) && (land_p1[3]==1  || land_p2[3]==1))) {
           btn_upgrade.setVisible(true);
        }
        else{
            btn_upgrade.setVisible(false);
            
        }
    }//GEN-LAST:event_btn_4ActionPerformed

    private void btn_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_5ActionPerformed
       
        if (turn%2==1 && place_p1==5) {
            lbl_place.setText("5");
          
            lbl_price.setText(Integer.toString(price[4])+" TL");
            lbl_rent.setText(Integer.toString((price[4]/10))+" TL");
        }
        else if(turn%2==0 && place_p2==5){
           lbl_place.setText("5");

           lbl_price.setText(Integer.toString(price[4])+" TL"); 
           lbl_rent.setText(Integer.toString((price[4]/10))+" TL");
        }
          if (land_p1[4]==1) {
           lbl_player.setText("Player 1");
        }
        else if(land_p2[4]==1){
            lbl_player.setText("Player 2");
        }
          int place=Integer.parseInt(lbl_place.getText());
        if (upgrade[place-1]>=1) {
            btn_buy.setVisible(false);
        }
        else{
            btn_buy.setVisible(true);
        } 
        if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==5  || place_p2==5) && (land_p1[4]==1 || land_p2[4]==1))) {
           btn_upgrade.setVisible(true);
        }
        else{
            btn_upgrade.setVisible(false);
            
        }
    }//GEN-LAST:event_btn_5ActionPerformed

    private void btn_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_6ActionPerformed
        
        if (turn%2==1 && place_p1==6) {
            lbl_place.setText("6");
        
            lbl_price.setText(Integer.toString(price[5])+" TL");
            lbl_rent.setText(Integer.toString((price[5]/10))+" TL");
        }
        else if(turn%2==0 && place_p2==6){
           lbl_place.setText("6");

           lbl_price.setText(Integer.toString(price[5])+" TL"); 
           lbl_rent.setText(Integer.toString((price[5]/10))+" TL");
        }
        
          if (land_p1[5]==1) {
           lbl_player.setText("Player 1");
        }
        else if(land_p2[5]==1){
            lbl_player.setText("Player 2");
        }
           int place=Integer.parseInt(lbl_place.getText());
        if (upgrade[place-1]>=1) {
            btn_buy.setVisible(false);
        }
        else{
            btn_buy.setVisible(true);
        }  
        if ((lbl_player.getText().equals(turn_pl.getText()) && (land_p1[5]==1 || land_p2[5]==1))) {
           btn_upgrade.setVisible(true);
        }
        else{
            btn_upgrade.setVisible(false);
            
        }
    }//GEN-LAST:event_btn_6ActionPerformed

    private void btn_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_7ActionPerformed
     
        if (turn%2==1 && place_p1==7) {
            lbl_place.setText("7");
          
            lbl_price.setText(Integer.toString(price[6])+" TL");
            lbl_rent.setText(Integer.toString((price[6]/10))+" TL");
        }
        else if(turn%2==0 && place_p2==7){
           lbl_place.setText("7");
       
           lbl_price.setText(Integer.toString(price[6])+" TL"); 
           lbl_rent.setText(Integer.toString((price[6]/10))+" TL");
        }
          if (land_p1[6]==1) {
           lbl_player.setText("Player 1");
        }
        else if(land_p2[6]==1){
            lbl_player.setText("Player 2");
        }
         int place=Integer.parseInt(lbl_place.getText());
        if (upgrade[place-1]>=1) {
            btn_buy.setVisible(false);
        }
        else{
            btn_buy.setVisible(true);
        }      
        if ((lbl_player.getText().equals(turn_pl.getText()) && (land_p1[6]==1 || land_p2[6]==1))) {
           btn_upgrade.setVisible(true);
        }
        else{
            btn_upgrade.setVisible(false);
            
        }
    }//GEN-LAST:event_btn_7ActionPerformed

    private void btn_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_8ActionPerformed
          
        if (turn%2==1 && place_p1==8) {
            lbl_place.setText("8");
          
            lbl_price.setText(Integer.toString(price[7])+" TL");
            lbl_rent.setText(Integer.toString((price[7]/10))+" TL");
          }
          else if(turn%2==0 && place_p2==8){
           lbl_place.setText("8");
         
           lbl_price.setText(Integer.toString(price[7])+" TL"); 
           lbl_rent.setText(Integer.toString((price[7]/10))+" TL");
        }
        
          if (land_p1[7]==1) {
           lbl_player.setText("Player 1");
        }
        else if(land_p2[7]==1){
            lbl_player.setText("Player 2");
        }
       int place=Integer.parseInt(lbl_place.getText());
        if (upgrade[place-1]>=1) {
            btn_buy.setVisible(false);
        }
        else{
            btn_buy.setVisible(true);
        }       
        if ((lbl_player.getText().equals(turn_pl.getText()) && (land_p1[7]==1 || land_p2[7]==1))) {
           btn_upgrade.setVisible(true);
        }
        else{
            btn_upgrade.setVisible(false);
            
        }
    }//GEN-LAST:event_btn_8ActionPerformed

    private void btn_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_9ActionPerformed
         
        if (turn%2==1 && place_p1==9) {
            lbl_place.setText("9");
          
            lbl_price.setText(Integer.toString(price[8])+" TL");
            lbl_rent.setText(Integer.toString((price[8]/10))+" TL");
        }
        else if(turn%2==0 && place_p2==9){
           lbl_place.setText("9");
      
           lbl_price.setText(Integer.toString(price[8])+" TL"); 
           lbl_rent.setText(Integer.toString((price[8]/10))+" TL");
        }
          if (land_p1[8]==1) {
           lbl_player.setText("Player 1");
        }
        else if(land_p2[8]==1){
            lbl_player.setText("Player 2");
        }
           int place=Integer.parseInt(lbl_place.getText());
        if (upgrade[place-1]>=1) {
            btn_buy.setVisible(false);
        }
        else{
            btn_buy.setVisible(true);
        }  
        if ((lbl_player.getText().equals(turn_pl.getText()) && (land_p1[8]==1 || land_p2[8]==1))) {
           btn_upgrade.setVisible(true);
        }
        else{
            btn_upgrade.setVisible(false);
            
        }
    }//GEN-LAST:event_btn_9ActionPerformed

    private void btn_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_10ActionPerformed
        
        if (turn%2==1 && place_p1==10) {
            lbl_place.setText("10");
          
            lbl_price.setText(Integer.toString(price[9])+" TL");
            lbl_rent.setText(Integer.toString((price[9]/10))+" TL");
        }
        else if(turn%2==0 && place_p2==10){
           lbl_place.setText("10");
          
           lbl_price.setText(Integer.toString(price[9])+" TL"); 
           lbl_rent.setText(Integer.toString((price[9]/10))+" TL");
        }
          if (land_p1[9]==1) {
           lbl_player.setText("Player 1");
        }
        else if(land_p2[9]==1){
            lbl_player.setText("Player 2");
        }
             int place=Integer.parseInt(lbl_place.getText());
        if (upgrade[place-1]>=1) {
            btn_buy.setVisible(false);
        }
        else{
            btn_buy.setVisible(true);
        } 
        if ((lbl_player.getText().equals(turn_pl.getText()) && (land_p1[9]==1  || land_p2[9]==1))) {
           btn_upgrade.setVisible(true);
        }
        else{
            btn_upgrade.setVisible(false);
            
        }
    }//GEN-LAST:event_btn_10ActionPerformed

    private void btn_11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_11ActionPerformed
        
        if (turn%2==1 && place_p1==11) {
            lbl_place.setText("11");
          
            lbl_price.setText(Integer.toString(price[10])+" TL");
            lbl_rent.setText(Integer.toString((price[10]/10))+" TL");
        }
        else if(turn%2==0 && place_p2==11){
           lbl_place.setText("11");
          
           lbl_price.setText(Integer.toString(price[10])+" TL"); 
           lbl_rent.setText(Integer.toString((price[10]/10))+" TL");
        }
          if (land_p1[10]==1) {
           lbl_player.setText("Player 1");
        }
        else if(land_p2[10]==1){
            lbl_player.setText("Player 2");
        }
        int place=Integer.parseInt(lbl_place.getText());
        if (upgrade[place-1]>=1) {
            btn_buy.setVisible(false);
        }
        else{
            btn_buy.setVisible(true);
        } 
              if ((lbl_player.getText().equals(turn_pl.getText()) && (land_p1[10]==1  || land_p2[10]==1))) {
           btn_upgrade.setVisible(true);
        }
        else{
            btn_upgrade.setVisible(false);
            
        }
    }//GEN-LAST:event_btn_11ActionPerformed

    private void btn_12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_12ActionPerformed
       
        if (turn%2==1 && place_p1==12) {
            lbl_place.setText("12");
            
            lbl_price.setText(Integer.toString(price[11])+" TL");
            lbl_rent.setText(Integer.toString((price[11]/10))+" TL");
        }
        else if(turn%2==0 && place_p2==12){
           lbl_place.setText("12");
      
           lbl_price.setText(Integer.toString(price[11])+" TL"); 
           lbl_rent.setText(Integer.toString((price[11]/10))+" TL");
        }
          if (land_p1[11]==1) {
           lbl_player.setText("Player 1");
        }
        else if(land_p2[11]==1){
            lbl_player.setText("Player 2");
        }
            int place=Integer.parseInt(lbl_place.getText());
        if (upgrade[place-1]>=1) {
            btn_buy.setVisible(false);
        }
        else{
            btn_buy.setVisible(true);
        }   
        if ((lbl_player.getText().equals(turn_pl.getText()) && (land_p1[11]==1  || land_p2[11]==1))) {
           btn_upgrade.setVisible(true);
        }
        else{
            btn_upgrade.setVisible(false);
            
        }
    }//GEN-LAST:event_btn_12ActionPerformed

    private void btn_13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_13ActionPerformed
      
        if (turn%2==1 && place_p1==13) {
            lbl_place.setText("13");
          
            lbl_price.setText(Integer.toString(price[12])+" TL");
            lbl_rent.setText(Integer.toString((price[12]/10))+" TL");
        }
        else if(turn%2==0 && place_p2==13){
           lbl_place.setText("13");
        
           lbl_price.setText(Integer.toString(price[12])+" TL"); 
           lbl_rent.setText(Integer.toString((price[12]/10))+" TL");
        }
          if (land_p1[12]==1) {
           lbl_player.setText("Player 1");
        }
        else if(land_p2[12]==1){
            lbl_player.setText("Player 2");
        }
          int place=Integer.parseInt(lbl_place.getText());
        if (upgrade[place-1]>=1) {
            btn_buy.setVisible(false);
        }
        else{
            btn_buy.setVisible(true);
        }
          if ((lbl_player.getText().equals(turn_pl.getText()) && (land_p1[12]==1  ||  land_p2[12]==1))) {
           btn_upgrade.setVisible(true);
        }
        else{
            btn_upgrade.setVisible(false);
            
        }
    }//GEN-LAST:event_btn_13ActionPerformed

    private void btn_14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_14ActionPerformed
      
        if (turn%2==1 && place_p1==14) {
            lbl_place.setText("14");
          
            lbl_price.setText(Integer.toString(price[13])+" TL");
            lbl_rent.setText(Integer.toString((price[13]/10))+" TL");
        }
        else if(turn%2==0 && place_p2==14){
           lbl_place.setText("14");
          
           lbl_price.setText(Integer.toString(price[13])+" TL"); 
           lbl_rent.setText(Integer.toString((price[13]/10))+" TL");
        }
          if (land_p1[13]==1) {
           lbl_player.setText("Player 1");
        }
        else if(land_p2[13]==1){
            lbl_player.setText("Player 2");
        }
        int place=Integer.parseInt(lbl_place.getText());
        if (upgrade[place-1]>=1) {
            btn_buy.setVisible(false);
        }
        else{
            btn_buy.setVisible(true);
        }
        if ((lbl_player.getText().equals(turn_pl.getText()) && (land_p1[13]==1  || land_p2[13]==1))) {
           btn_upgrade.setVisible(true);
        }
        else{
            btn_upgrade.setVisible(false);
            
        }
              
    }//GEN-LAST:event_btn_14ActionPerformed

    private void btn_15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_15ActionPerformed
        
        if (turn%2==1 && place_p1==15) {
            lbl_place.setText("15");
         
            lbl_price.setText(Integer.toString(price[14])+" TL");
            lbl_rent.setText(Integer.toString((price[14]/10))+" TL");
        }
        else if(turn%2==0 && place_p2==15){
           lbl_place.setText("15");
          
           lbl_price.setText(Integer.toString(price[14])+" TL"); 
           lbl_rent.setText(Integer.toString((price[14]/10))+" TL");
        }
          if (land_p1[14]==1) {
           lbl_player.setText("Player 1");
        }
        else if(land_p2[14]==1){
            lbl_player.setText("Player 2");
        }
          int place=Integer.parseInt(lbl_place.getText());
        if (upgrade[place-1]>=1) {
            btn_buy.setVisible(false);
        }
        else{
            btn_buy.setVisible(true);
        }
              if ((lbl_player.getText().equals(turn_pl.getText()) && (land_p1[14]==1 || land_p2[14]==1))) {
           btn_upgrade.setVisible(true);
        }
        else{
            btn_upgrade.setVisible(false);
            
        }
    }//GEN-LAST:event_btn_15ActionPerformed

    private void btn_16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_16ActionPerformed
       /*
        if (turn%2==1 && (place_p1==16 || pl_p1.getText().equals("0"))) {
            lbl_place.setText("16");
          
            lbl_price.setText(Integer.toString(price[15])+" TL");
            lbl_rent.setText(Integer.toString((price[15]/10)));
        }
        else if(turn%2==0 && place_p2==16 || pll_p2.getText().equals("0")){
           lbl_place.setText("16");
          
           lbl_price.setText(Integer.toString(price[15])+" TL"); 
           lbl_rent.setText(Integer.toString((price[15]/10))+" TL");
        }
          if (land_p1[15]==1) {
           lbl_player.setText("Player 1");
        }
        else if(land_p2[15]==1){
            lbl_player.setText("Player 2");
        }
              int place=Integer.parseInt(lbl_place.getText());
        if (upgrade[place-1]>=1) {
            btn_buy.setVisible(false);
        }
        else{
            btn_buy.setVisible(true);
        }   
        if ((lbl_player.getText().equals(turn_pl.getText()) && (place_p1==16 || place_p2==16))) {
           btn_upgrade.setVisible(true);
        }
        else{
            btn_upgrade.setVisible(false);
            
        }
        */
       /*
       1 temmuzda yorumlandı
       is_click[15]=1;
        if (is_click[15]==1) {
             int a=r.nextInt(1500);
        if (turn%2==1 && (place_p1==16 || pl_p1.getText().equals("0"))) {
            money[0]=money[0]+a;
            lbl_money1.setText(Integer.toString(money[0]));
        }
        else if(turn%2==0 && (place_p2==16 || pll_p2.getText().equals("0"))){
            money[1]=money[1]+a;
            lbl_money2.setText(Integer.toString(money[1]));
            
        }
        }
       */
      
    }//GEN-LAST:event_btn_16ActionPerformed

    private void btn_takep1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_takep1ActionPerformed
       try{
           
       
        if (turn_pl.getText().equals("Player 1")) {
             int n=Integer.parseInt(txt_value1.getText());
         int c=Integer.parseInt(lbl_bankp1.getText());
         
         if (c-n>=0) {
             JOptionPane.showMessageDialog(null,"Successful!");
       money[0]=money[0]+n;
      
       lbl_bankp1.setText(Integer.toString(c-n));
        }
         else{
            JOptionPane.showMessageDialog(null,"You havent money enough!");
         }
        }
        else{
           JOptionPane.showMessageDialog(null,"You should wait for your turn!");
        }
       }catch(Exception e){
            JOptionPane.showMessageDialog(null,e); 
       }
       
      lbl_money1.setText(Integer.toString(money[0]));
      txt_value1.setText("");
    }//GEN-LAST:event_btn_takep1ActionPerformed

    private void btn_takep2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_takep2ActionPerformed
try{
        if (turn_pl.getText().equals("Player 2")) {
                int n=Integer.parseInt(txt_value2.getText());
         int c=Integer.parseInt(lbl_bankp2.getText());
         
         if (c-n>=0) {
             JOptionPane.showMessageDialog(null,"Successful!");
       money[1]=money[1]+n;
      
       lbl_bankp2.setText(Integer.toString(c-n));
        }
         else{
            JOptionPane.showMessageDialog(null,"You havent money enough!");
         }
        }
        else{
            JOptionPane.showMessageDialog(null,"You should wait for your turn!");
        }
}catch(Exception e){
      JOptionPane.showMessageDialog(null,e);
}
lbl_money2.setText(Integer.toString(money[1]));
txt_value2.setText("");
    }//GEN-LAST:event_btn_takep2ActionPerformed

    private void tour_limit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tour_limit3ActionPerformed
    tour_limit=150;      
    is_tour_selected=1;
    lbl_tourlimit.setText("150");
    }//GEN-LAST:event_tour_limit3ActionPerformed

    private void tour_limit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tour_limit1ActionPerformed
    tour_limit=5;
    is_tour_selected=1;
    lbl_tourlimit.setText("50");
    }//GEN-LAST:event_tour_limit1ActionPerformed

    private void quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitActionPerformed
    this.dispose();
    }//GEN-LAST:event_quitActionPerformed

    private void tour_limit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tour_limit2ActionPerformed
    tour_limit=100;
    is_tour_selected=1;
    lbl_tourlimit.setText("100");
    }//GEN-LAST:event_tour_limit2ActionPerformed

    private void tour_limit4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tour_limit4ActionPerformed
    tour_limit=200;
    is_tour_selected=1;
    lbl_tourlimit.setText("200");
    }//GEN-LAST:event_tour_limit4ActionPerformed

    private void tour_limit5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tour_limit5ActionPerformed
    tour_limit=250;
    is_tour_selected=1;
    lbl_tourlimit.setText("250");
    }//GEN-LAST:event_tour_limit5ActionPerformed

    private void menu_rulesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_rulesMouseClicked
       JOptionPane.showMessageDialog(null,"1)You should choose the tour limit before start the game"+"\n"+"2)You must start the game with roll the dice"+"\n"+"3)When you come to 16 , you will take money(0-1200 random value) and you can add this to your money or to your bank");
    }//GEN-LAST:event_menu_rulesMouseClicked

    
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
            java.util.logging.Logger.getLogger(GamePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GamePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GamePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GamePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GamePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_1;
    private javax.swing.JButton btn_10;
    private javax.swing.JButton btn_11;
    private javax.swing.JButton btn_12;
    private javax.swing.JButton btn_13;
    private javax.swing.JButton btn_14;
    private javax.swing.JButton btn_15;
    private javax.swing.JButton btn_16;
    private javax.swing.JButton btn_2;
    private javax.swing.JButton btn_3;
    private javax.swing.JButton btn_4;
    private javax.swing.JButton btn_5;
    private javax.swing.JButton btn_6;
    private javax.swing.JButton btn_7;
    private javax.swing.JButton btn_8;
    private javax.swing.JButton btn_9;
    private javax.swing.JButton btn_buy;
    private javax.swing.JButton btn_dice;
    private javax.swing.JButton btn_pas;
    private javax.swing.JButton btn_takep1;
    private javax.swing.JButton btn_takep2;
    private javax.swing.JButton btn_upgrade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbl_bankp1;
    private javax.swing.JLabel lbl_bankp2;
    private javax.swing.JLabel lbl_dice;
    private javax.swing.JLabel lbl_money1;
    private javax.swing.JLabel lbl_money2;
    private javax.swing.JLabel lbl_photo1;
    private javax.swing.JLabel lbl_photo2;
    private javax.swing.JLabel lbl_place;
    private javax.swing.JLabel lbl_player;
    private javax.swing.JLabel lbl_price;
    private javax.swing.JLabel lbl_rent;
    private javax.swing.JLabel lbl_rent2;
    private javax.swing.JLabel lbl_rentt;
    private javax.swing.JLabel lbl_tourlimit;
    private javax.swing.JMenu menu_rules;
    private javax.swing.JLabel pl_p1;
    private javax.swing.JLabel pl_p2;
    private javax.swing.JLabel pl_p3;
    private javax.swing.JLabel pll_p2;
    private javax.swing.JMenuItem quit;
    private javax.swing.JMenuItem tour_limit1;
    private javax.swing.JMenuItem tour_limit2;
    private javax.swing.JMenuItem tour_limit3;
    private javax.swing.JMenuItem tour_limit4;
    private javax.swing.JMenuItem tour_limit5;
    private javax.swing.JLabel turn_pl;
    private javax.swing.JTextField txt_value1;
    private javax.swing.JTextField txt_value2;
    // End of variables declaration//GEN-END:variables
}
