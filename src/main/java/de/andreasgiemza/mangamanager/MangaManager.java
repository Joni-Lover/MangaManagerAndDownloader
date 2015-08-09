package de.andreasgiemza.mangamanager;

import de.andreasgiemza.mangadownloader.gui.dialogs.Loading;
import de.andreasgiemza.mangamanager.addsubscription.AddSubscription;
import static de.andreasgiemza.mangamanager.data.ChapterForSubscription.UNREAD;
import de.andreasgiemza.mangamanager.data.Subscription;
import de.andreasgiemza.mangamanager.data.SubscriptionsList;
import de.andreasgiemza.mangamanager.mangadetails.MangaDetails;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Andreas Giemza <andreas@giemza.net>
 */
public class MangaManager extends javax.swing.JFrame {

    private final List<Subscription> subscriptions = new LinkedList<>();
    private final SubscriptionsTableModel subscriptionsTableModel = new SubscriptionsTableModel(subscriptions);

    private final MangaManager mangaManager = this;

    public MangaManager() {
        initComponents();

        setLocation(
                new Double((Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2) - (getWidth() / 2)).intValue(),
                new Double((Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2) - (getHeight() / 2)).intValue()
        );

        subscriptions.addAll(SubscriptionsList.load());
        subscriptionsTableModel.fireTableDataChanged();

        subscriptionsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    Subscription selectedSubscription = ((SubscriptionsTableModel) subscriptionsTable.getModel()).getSubscription(subscriptionsTable.convertRowIndexToModel(row));

                    MangaDetails mangaDetails = new MangaDetails(mangaManager, true, selectedSubscription);
                    mangaDetails.setVisible(true);

                    subscriptionsTableModel.fireTableDataChanged();
                    SubscriptionsList.save(subscriptions);
                }
            }
        });
    }

    public boolean addSubscription(Subscription subscription, boolean selected) {
        if (subscriptions.contains(subscription)) {
            return false;
        }

        subscriptions.add(subscription);
        subscriptionsTableModel.fireTableDataChanged();

        return true;
    }

    private Subscription getSelectedSite() {
        int selectedRow = subscriptionsTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a subscription!",
                    "Info", JOptionPane.INFORMATION_MESSAGE);

            return null;
        }

        return ((SubscriptionsTableModel) subscriptionsTable.getModel()).getSubscription(subscriptionsTable.convertRowIndexToModel(selectedRow));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        subscriptionsScrollPane = new javax.swing.JScrollPane();
        subscriptionsTable = new javax.swing.JTable();
        updateButton = new javax.swing.JButton();
        removeSubscriptionButton = new javax.swing.JButton();
        addSubscriptionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MangaManager");

        subscriptionsTable.setAutoCreateRowSorter(true);
        subscriptionsTable.setModel(subscriptionsTableModel);
        subscriptionsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        subscriptionsScrollPane.setViewportView(subscriptionsTable);

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        removeSubscriptionButton.setText("Remove subscription");
        removeSubscriptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSubscriptionButtonActionPerformed(evt);
            }
        });

        addSubscriptionButton.setText("Add subscription");
        addSubscriptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSubscriptionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subscriptionsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(removeSubscriptionButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addSubscriptionButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(subscriptionsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addSubscriptionButton)
                    .addComponent(removeSubscriptionButton)
                    .addComponent(updateButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addSubscriptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSubscriptionButtonActionPerformed
        AddSubscription addSubscription = new AddSubscription(this, true);
        addSubscription.setVisible(true);

        SubscriptionsList.save(subscriptions);
    }//GEN-LAST:event_addSubscriptionButtonActionPerformed

    private void removeSubscriptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSubscriptionButtonActionPerformed
        Subscription subscription = getSelectedSite();

        if (subscription == null) {
            return;
        }

        int result = JOptionPane.showConfirmDialog(
                this,
                "Do you really want to remove " + subscription.getManga().getTitle() + "?",
                "Remove subscription",
                JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            subscriptions.remove(subscription);
            subscriptionsTableModel.fireTableDataChanged();

            SubscriptionsList.save(subscriptions);
        }
    }//GEN-LAST:event_removeSubscriptionButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        final Loading loading = new Loading(this, true, getX(), getY(),
                getWidth(), getHeight());
        loading.startRunnable(new Runnable() {

            @Override
            public void run() {
                for (Subscription subscription : subscriptions) {
                    try {
                        subscription.getNewChapters(subscription.getSite().getChapterList(subscription.getManga()), UNREAD);
                    } catch (Exception ex) {
                    }
                }

                loading.dispose();
            }
        });

        subscriptionsTableModel.fireTableDataChanged();
        SubscriptionsList.save(subscriptions);
    }//GEN-LAST:event_updateButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Windows is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MangaManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MangaManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSubscriptionButton;
    private javax.swing.JButton removeSubscriptionButton;
    private javax.swing.JScrollPane subscriptionsScrollPane;
    private javax.swing.JTable subscriptionsTable;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

}
