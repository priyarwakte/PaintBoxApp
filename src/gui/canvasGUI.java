package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class canvasGUI extends JFrame {
   private canvasGUIController controller;
   int undoCount = 0;
   int redoCount = 0;
   Canvas canvas = new Canvas();
   JPanel contentPane;
   BorderLayout borderLayout1 = new BorderLayout();
   JPanel jPanel1 = new JPanel();
   JButton boxButton = new JButton(" Box ");
   JButton circleButton = new JButton(" Circle ");
   JButton undoButton = new JButton(" Undo ");
   JButton redoButton = new JButton(" Redo ");
   
   public canvasGUI() {
      super();
      try {
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         jbInit();
      } catch(Exception exception) {
         exception.printStackTrace();
      }
   }

   public canvasGUIController getController() {
      return controller;
   }
   
   private void jbInit() throws Exception {
      contentPane = (JPanel) getContentPane();
      contentPane.setLayout(borderLayout1);
      canvas.setBackground(Color.white);
      canvas.setVisible(true);
      setSize(new Dimension(900, 800));
      setTitle("Paint GUI");
      jPanel1.setPreferredSize(new Dimension(200, 300));
      contentPane.add(canvas, java.awt.BorderLayout.CENTER);
      contentPane.add(jPanel1, java.awt.BorderLayout.WEST);
      jPanel1.add(circleButton);
      jPanel1.add(boxButton);
      jPanel1.add(undoButton);
      jPanel1.add(redoButton);
      undoButton.setEnabled(false);
      redoButton.setEnabled(false);
      controller = new canvasGUIController();
      
      /* Button configuration */
      canvas.addMouseListener(new MouseAdapter() {
         //@Override
         public void mousePressed(MouseEvent e) {
        	Graphics g = canvas.getGraphics();
            controller.canvasClicked( (int) e.getPoint().getX(),
               (int) e.getPoint().getY(), g);
            undoButton.setEnabled(true);
            redoButton.setEnabled(false);
            undoCount++;
            redoCount = 0;
         }
      });
      //Adapter, observer and controller pattern
      circleButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 controller.circleButtonClicked();
         }
      });
      
      boxButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 controller.boxButtonClicked();
         }
      });
      
      undoButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 controller.undoButtonClicked();
        	 undoCount--;
        	 redoCount++;
        	 if(undoCount == 0)
        		 undoButton.setEnabled(false);
        	 redoButton.setEnabled(true);
         }
      });
      
      redoButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 controller.redoButtonClicked();
        	 undoButton.setEnabled(true);
        	 redoCount--;
        	 undoCount++;
        	 if(redoCount == 0)
        		 redoButton.setEnabled(false);
        	 undoButton.setEnabled(true);
         }
      });
   }
   
   public static void main(String args[])
   {
	   EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	            	canvasGUI window = new canvasGUI();
	                window.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });      
   }
}
