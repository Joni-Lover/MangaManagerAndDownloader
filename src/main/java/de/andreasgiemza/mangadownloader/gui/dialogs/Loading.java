package de.andreasgiemza.mangadownloader.gui.dialogs;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

/**
 *
 * @author Andreas Giemza <andreas@giemza.net>
 */
public class Loading extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;

	public Loading(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();

		setBackground(new Color(0, 0, 0, 0));
		setLocation(new Double((Toolkit.getDefaultToolkit().getScreenSize()
				.getWidth() / 2)
				- (getWidth() / 2)).intValue(), new Double((Toolkit
				.getDefaultToolkit().getScreenSize().getHeight() / 2)
				- (getHeight() / 2)).intValue());
	}

	public void startRunnable(Runnable runnable) {
		new Thread(runnable).start();

		setVisible(true);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */

	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		loadingImage = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setTitle("Loading");
		setUndecorated(true);
		setResizable(false);
		getContentPane().setLayout(new java.awt.GridLayout(1, 0));

		loadingImage.setBackground(new Color(0, 0, 0, 0));
		loadingImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		loadingImage.setIcon(new ImageIcon(getClass().getClassLoader()
				.getResource("images/loading.gif")));
		getContentPane().add(loadingImage);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel loadingImage;
	// End of variables declaration//GEN-END:variables
}
