import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class Main extends JFrame {
 static int curr = 0;
 static JPanel panel;
 static JButton next;
 static JRadioButton button1;
 static String[] splitted;
 static String allP;
 static JButton result;
 static int count = 0;
 static JFrame frame;
 static boolean stats = false;
 static String [] Poss;
  public Main(){
    
    String [] ques = new String [10];
    String[] ans = new String[10];
    


    try{
    File myFile = new File("Questions");
    Scanner scan = new Scanner(myFile);
    File myFile2 = new File("Answers");
    Scanner can = new Scanner(myFile2);
    while(scan.hasNextLine()){
      for(int i = 0; i<ques.length;i++){
        ques[i] = scan.nextLine();
      }
    }
    while(can.hasNextLine()){
      for(int i = 0; i<ans.length;i++){
        ans[i] = can.nextLine();
      }
    }
    scan.close();
    can.close();
    }catch(FileNotFoundException e){
      System.out.println("errroooorrrrr");
    }
    
    
    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,400);

    JLabel label = new JLabel(ques[curr]);
    splitted = ans[curr].split("\\s+");
    button1 = new JRadioButton(splitted[0]);
    button1.setBounds(75,50,100,30);
    JRadioButton button2 = new JRadioButton(splitted[1]);
    button2.setBounds(75,100,100,30);
    JRadioButton button3 = new JRadioButton(splitted[2]);
    button3.setBounds(75,150,100,30);
    JRadioButton button4 = new JRadioButton(splitted[2]);
    button4.setBounds(75,200,100,30);
    JRadioButton button5 = new JRadioButton(splitted[3]);
    button5.setBounds(75,250,100,30);
    ButtonGroup choice = new ButtonGroup();
    choice.add(button1);
    choice.add(button2);
    choice.add(button3);
    choice.add(button4);
    choice.add(button5);
     

    
    panel = new JPanel();
    result = new JButton("Result");
    result.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        if(button1.isSelected()){
          allP = splitted[0];
          System.out.println(splitted[0]);
        }
        else if(button2.isSelected()){
          allP = splitted[1];
          System.out.println(splitted[1]);
        }
        else if(button3.isSelected()){
          allP = splitted[2];
          System.out.println(splitted[2]);
        }
        else if(button4.isSelected()){
          allP = splitted[3];
          System.out.println(splitted[3]);
        }
        else if(button5.isSelected()){
          allP = splitted[4];
          System.out.println(splitted[4]);
        }
        else{
          System.out.println("nothing");
        }

        Poss = new String[11];
        try{
          File fin = new File("Poss");
          Scanner look = new Scanner(fin);
          int j = 0;
          while(look.hasNextLine()){
           
            Poss[j] = look.nextLine();
            j++;
        }
        look.close();
        }catch(IOException b){
          System.out.println("errroooorrrrr");
        }
        try{
        FileWriter fileWrite = new FileWriter("Poss", true);
      PrintWriter printWrite = new PrintWriter(fileWrite);
      printWrite.println(allP);
      printWrite.close();
    }catch(IOException c){
      System.out.println("errroooorrrrr");
    }
      
      
        stats=true;
        check(stats);
       
      }
    });
    
    next = new JButton("Next");
    next.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        
        if(button1.isSelected()){
          allP = splitted[0];
          System.out.println(splitted[0]);
        }
        else if(button2.isSelected()){
          allP = splitted[1];
          System.out.println(splitted[1]);
        }
        else if(button3.isSelected()){
          allP = splitted[2];
          System.out.println(splitted[2]);
        }
        else if(button4.isSelected()){
          allP = splitted[3];
          System.out.println(splitted[3]);
        }
        else if(button5.isSelected()){
          allP = splitted[4];
          System.out.println(splitted[4]);
        }
        else{
          System.out.println("nothing");
        }
            try{
      FileWriter fileWrite = new FileWriter("Poss", true);
      PrintWriter printWrite = new PrintWriter(fileWrite);
      printWrite.println(allP);
      printWrite.close();
    }catch(IOException i){
      System.out.println("errroooorrrrr");
    }
        frame.dispose();
        new Main();
        
      }
    }); 
    if(curr<9){
      result.setEnabled(false);
    }
    else{
      next.setEnabled(false);
      
    }

    panel.add(next);
    panel.add(result);

    frame.add(button1);
    frame.add(button2);
    frame.add(button3);
    frame.add(button4);
    frame.add(button5);

   

    
    frame.getContentPane().add(BorderLayout.NORTH, label);
    frame.getContentPane().add(panel);
    frame.setVisible(true);

    curr++;
  }
  public static void check(boolean fat){
    String[] right = new String[10];
    if(fat==true){
      right[0] = "Float";
      right[1] = "Object";
      right[2] =  "lang";
      right[3] = "lang";
      right[4] = "Guru99";
      right[5] = "get";
      right[6] = "Actionperformed";
      right[7] = "getDocumentBase";
      right[8] = "main";
      right[9] = "JButtonGroup";
      for(int l = 0; l<=9;l++){
        if(right[l].equals(Poss[l])){
          count++;
        }
      }
    JOptionPane.showMessageDialog(frame, "Correct Answers= " + count);  
     
    }
  }
  public static void main(String[] args) {
    
      
    new Main();  
    String[] right = new String[10];  
        if(stats==true){
      right[0] = "Float";
      right[1] = "Object";
      right[2] =  "lang";
      right[3] = "lang";
      right[4] = "Guru99";
      right[5] = "get";
      right[6] = "Actionperformed";
      right[7] = "getDocumentBase";
      right[8] = "main";
      right[9] = "JButtonGroup";
    JOptionPane.showMessageDialog(frame, "You have " + count);  
     System.out.println(right[1]);
    }
    
  }
}
