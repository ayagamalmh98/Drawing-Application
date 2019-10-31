package eg.edu.alexu.csd.oop.draw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;

public class g extends JFrame {

	Panel panel; 

	public static Color BackColor, ForeColor;
	public static Color Transparent;
	public static Color FillColor;

	public g() {
		setResizable(false);
		setMinimumSize(new Dimension(850, 800));
		initComponents();
		Transparent = new Color(1f, 0f, 0f, .5f);
		panel = new Panel();
		panel.setBounds(0, 50, 1851, 740);
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		Rectangle f = this.getBounds();
		getContentPane().add(panel, BorderLayout.CENTER);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1851, Short.MAX_VALUE)
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 740, Short.MAX_VALUE)
				);
		panel.setLayout(gl_panel);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(280, 0, 313, 50);
		jButton10 = new javax.swing.JButton();
		toolBar.add(jButton10);

		jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eg/edu/alexu/csd/oop/img/paint.png")));
		jButton10.setText("Back-Color");
		jButton10.setToolTipText("Pick a color to fill the shape with.");
		jButton10.setBorderPainted(false);
		jButton9 = new javax.swing.JButton();
		toolBar.add(jButton9);


		jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eg/edu/alexu/csd/oop/img/brush.png")));
		jButton9.setText("Border-Color");
		jButton9.setToolTipText("Pick a color for the border of the shape.");
		jButton9.setBorderPainted(false);
		jButton13 = new javax.swing.JButton();
		toolBar.add(jButton13);


		jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eg/edu/alexu/csd/oop/img/paint-bucket.png")));
		jButton13.setText("Fill-Color");
		jButton13.setBorderPainted(false);
		jButton13.setToolTipText("click on a shape on the canvas to fill it with the foreground color you pick.");

		JToolBar toolBar2 = new JToolBar();
		toolBar2.setBounds(600, 0, 300, 50);
		jButton14 = new javax.swing.JButton();
		toolBar2.add(jButton14);


		jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eg/edu/alexu/csd/oop/img/trash-can.png")));
		jButton14.setToolTipText("Delete");
		jButton14.setBorderPainted(false);
		jButton12 = new javax.swing.JButton();
		toolBar2.add(jButton12);

		jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eg/edu/alexu/csd/oop/img/resize1.png")));
		jButton12.setToolTipText("Resize");
		jButton12.setBorderPainted(false);
		jButton11 = new javax.swing.JButton();
		toolBar2.add(jButton11);

        
		jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eg/edu/alexu/csd/oop/img/drag.png")));
		jButton11.setToolTipText("Move");
		jButton11.setBorderPainted(false);
		jButton7 = new javax.swing.JButton();
		toolBar2.add(jButton7);

        
		jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eg/edu/alexu/csd/oop/img/undo.png")));
		jButton7.setToolTipText("Undo");
		jButton7.setBorderPainted(false);
		jButton6 = new javax.swing.JButton();
		toolBar2.add(jButton6);

        
		jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eg/edu/alexu/csd/oop/img/redo.png")));
		jButton6.setToolTipText("Redo");
		jButton6.setBorderPainted(false);
		getContentPane().setLayout(null);
		getContentPane().add(panel);
		getContentPane().add(jToolBar1);
		getContentPane().add(toolBar);
		getContentPane().add(toolBar2);
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});
		jButton11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton11ActionPerformed(evt);
			}
		});
		jButton12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton12ActionPerformed(evt);
			}
		});
		jButton14.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton14ActionPerformed(evt);
			}
		});
		jButton13.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton13ActionPerformed(evt);
			}
		});
		jButton9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton9ActionPerformed(evt);
			}
		});
		jButton10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton10ActionPerformed(evt);
			}
		});

		BackColor = new Color(255,255,255);
		ForeColor = panel.getForeground();
		panel.setVisible(true);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jMenuItem2 = new javax.swing.JMenuItem();
		jToolBar1 = new javax.swing.JToolBar();
		jToolBar1.setBounds(0, 0, 300, 50);
		jToolBar1.setBackground(UIManager.getColor("scrollbar"));
		jButton4 = new javax.swing.JButton();
		jButton4.setMaximumSize(new Dimension(40, 9));
		jButton4.setForeground(Color.BLACK);
		jButton1 = new javax.swing.JButton();
		jButton1.setMaximumSize(new Dimension(40, 9));
		jButton15 = new javax.swing.JButton();
		jButton15.setMaximumSize(new Dimension(40, 9));
		jButton2 = new javax.swing.JButton();
		jButton2.setMaximumSize(new Dimension(40, 9));
		jButton3 = new javax.swing.JButton();
		jButton3.setMaximumSize(new Dimension(40, 9));
		jButton5 = new javax.swing.JButton();
		jButton5.setMaximumSize(new Dimension(40, 9));
		jButton16 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu3 = new javax.swing.JMenu();
		jMenuItem5 = new javax.swing.JMenuItem();
		jMenuItem6 = new javax.swing.JMenuItem();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jMenuItem3 = new javax.swing.JMenuItem();

		jMenuItem2.setText("jMenuItem2");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Paint");

		jToolBar1.setRollover(true);

		jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eg/edu/alexu/csd/oop/img/line.png")));
		jButton4.setToolTipText("Draw a line");
		jButton4.setBorderPainted(false);

		this.pack();
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});
		jToolBar1.add(jButton4);


		jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eg/edu/alexu/csd/oop/img/ellipse.png")));
		jButton1.setToolTipText("Draw an Ellipse");
		jButton1.setBorderPainted(false);
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jToolBar1.add(jButton1);


		jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eg/edu/alexu/csd/oop/img/circle.png")));
		jButton15.setToolTipText("Draw a Circle");
		jButton15.setBorderPainted(false);

		jButton15.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton15ActionPerformed(evt);
			}
		});
		jToolBar1.add(jButton15);


		jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eg/edu/alexu/csd/oop/img/square.png")));
		jButton2.setToolTipText("Draw a square");
		jButton2.setBorderPainted(false);
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		jToolBar1.add(jButton2);


		jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eg/edu/alexu/csd/oop/img/rectangle.png")));
		jButton3.setToolTipText("Draw a rectangle");
		jButton3.setBorderPainted(false);
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		jToolBar1.add(jButton3);


		jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eg/edu/alexu/csd/oop/img/triangle.png")));
		jButton5.setToolTipText("Draw a triangle");
		jButton5.setBorderPainted(false);
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});
		jToolBar1.add(jButton5);

		jMenu3.setText("File");

		jMenuItem5.setText("Open");
		jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem5ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem5);


		jMenuItem6.setText("Save");
		jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem6ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem6);


		jMenuItem1.setText("Exit");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem1);

		jMenuBar1.add(jMenu3);

		jMenu2.setText("Plugins");


		jMenu2.add(jMenuItem3);

		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
		panel.myEngine.undo();
	}//GEN-LAST:event_jButton7ActionPerformed

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
		panel.myEngine.redo();
	}//GEN-LAST:event_jButton6ActionPerformed

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
		panel.setCurrentShapeType(ShapeTypes.Line);
	}//GEN-LAST:event_jButton4ActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		panel.setCurrentShapeType(ShapeTypes.Ellipse);
	}//GEN-LAST:event_jButton1ActionPerformed

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
		panel.setCurrentShapeType(ShapeTypes.Square);
	}//GEN-LAST:event_jButton2ActionPerformed

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
		panel.setCurrentShapeType(ShapeTypes.Rectangle);
	}//GEN-LAST:event_jButton3ActionPerformed

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
		panel.setCurrentShapeType(ShapeTypes.Triangle);
	}//GEN-LAST:event_jButton5ActionPerformed

	private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
		ForeColor = JColorChooser.showDialog(null, "Please Choose your Border Color", ForeColor);
	}//GEN-LAST:event_jButton9ActionPerformed

	private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
		BackColor = JColorChooser.showDialog(null, "Please Choose your Back Color", BackColor);
	}//GEN-LAST:event_jButton10ActionPerformed

	private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
		panel.resetAll();
		panel.moving = true;
	}//GEN-LAST:event_jButton11ActionPerformed

	private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
		panel.resetAll();
		panel.resize = true;
	}//GEN-LAST:event_jButton12ActionPerformed

	private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
		panel.resetAll();
		panel.recoloring = true;
		FillColor = JColorChooser.showDialog(null, "Please Choose your Fill Color", FillColor);
	}//GEN-LAST:event_jButton13ActionPerformed

	private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
		panel.resetAll();
		panel.deleting = true;
	}//GEN-LAST:event_jButton14ActionPerformed

	private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
		panel.setCurrentShapeType(ShapeTypes.Circle);
	}//GEN-LAST:event_jButton15ActionPerformed

	private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML File", "xml"));
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON File", "json"));
		fileChooser.setDialogTitle("Save as XML OR JSON File");

		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			if (file != null) {
				panel.myEngine.save(file.getAbsolutePath());
			}
		}
	}//GEN-LAST:event_jMenuItem6ActionPerformed

	private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML File", "xml"));
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON File", "json"));
		fileChooser.setDialogTitle("Load XML OR JSON File");

		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			if (file != null) {
				panel.myEngine.load(file.getAbsolutePath());
			}
			panel.repaint();

		}
	}//GEN-LAST:event_jMenuItem5ActionPerformed

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
		System.exit(0);
	}//GEN-LAST:event_jMenuItem1ActionPerformed

	/*  private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JAR File", "jar"));
        fileChooser.setDialogTitle("Load JAR file");

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (file != null) {
                try {
                    panel.myEngine.loadPlugin(new URL[]{file.toURI().toURL()});
                } catch (MalformedURLException ex) {
                    Logger.getLogger(g.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    } */

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
			java.util.logging.Logger.getLogger(g.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(g.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(g.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(g.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new g().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton10;
	private javax.swing.JButton jButton11;
	private javax.swing.JButton jButton12;
	private javax.swing.JButton jButton13;
	private javax.swing.JButton jButton14;
	private javax.swing.JButton jButton15;
	private javax.swing.JButton jButton16;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JButton jButton9;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem5;
	private javax.swing.JMenuItem jMenuItem6;
	private javax.swing.JToolBar jToolBar1;
}
