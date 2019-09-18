package core;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Ammar Yasser
 */
public class Passwords extends javax.swing.JFrame {

    private int xOnScreen, yOnScreen, x, y;
    private final int w, h;
    private final Icon iconShowDark = new ImageIcon(getClass().getResource("/images/icons8_Show_Password_25px_1.png"));
    private final Icon iconShowLight = new ImageIcon(getClass().getResource("/images/icons8_Show_Password_25px.png"));
    private final Icon iconWiFi = new ImageIcon(getClass().getResource("/images/icons8_Wi-Fi_30px.png"));
    private final Icon iconWiFiLock = new ImageIcon(getClass().getResource("/images/icons8_Wi-Fi_Lock_30px.png"));
    private final String osName;
    private static String rootPass;
    private ArrayList<Network> listOfNetworks;

    public Passwords() {
        initComponents();
        osName = System.getProperty("os.name");
        contentpane.setVerticalScrollBar(scrollBar);
        w = panel.getWidth();
        h = 40;
        copyLabel.setVisible(false);
        refresh();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollBar = new javax.swing.JScrollBar();
        container = new javax.swing.JPanel();
        titleBar = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        closeLabel = new javax.swing.JLabel();
        refreshLabel = new javax.swing.JLabel();
        contentpane = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        passPanel = new javax.swing.JPanel();
        passLabel = new javax.swing.JLabel();
        copyLabel = new javax.swing.JLabel();

        scrollBar.setUnitIncrement(30);
        scrollBar.setValueIsAdjusting(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Wi-Fi Passwords");
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        container.setBackground(new java.awt.Color(255, 255, 255));

        titleBar.setBackground(new java.awt.Color(45, 125, 154));
        titleBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        titleBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                titleBarMouseDragged(evt);
            }
        });
        titleBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titleBarMousePressed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Wi-Fi_Logo_40px.png"))); // NOI18N
        titleLabel.setText("Passwords");
        titleLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        titleLabel.setIconTextGap(5);

        closeLabel.setForeground(new java.awt.Color(255, 255, 255));
        closeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Multiply_30px.png"))); // NOI18N
        closeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLabelMouseClicked(evt);
            }
        });

        refreshLabel.setForeground(new java.awt.Color(255, 255, 255));
        refreshLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        refreshLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Sync_30px.png"))); // NOI18N
        refreshLabel.setToolTipText("Refresh Wi-Fi networks");
        refreshLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout titleBarLayout = new javax.swing.GroupLayout(titleBar);
        titleBar.setLayout(titleBarLayout);
        titleBarLayout.setHorizontalGroup(
            titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleBarLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refreshLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(closeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        titleBarLayout.setVerticalGroup(
            titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(closeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(refreshLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        contentpane.setBorder(null);
        contentpane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setPreferredSize(new java.awt.Dimension(400, 0));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        contentpane.setViewportView(panel);

        passPanel.setBackground(titleBar.getBackground());

        passLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        passLabel.setForeground(new java.awt.Color(255, 255, 255));
        passLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passLabel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                passLabelPropertyChange(evt);
            }
        });

        copyLabel.setForeground(new java.awt.Color(255, 255, 255));
        copyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Copy_30px.png"))); // NOI18N
        copyLabel.setToolTipText("Copy to Clipboard");
        copyLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        copyLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                copyLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout passPanelLayout = new javax.swing.GroupLayout(passPanel);
        passPanel.setLayout(passPanelLayout);
        passPanelLayout.setHorizontalGroup(
            passPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(passLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(copyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        passPanelLayout.setVerticalGroup(
            passPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(passLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(copyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(passPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contentpane)
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contentpane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(passPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeLabelMouseClicked
    private void refreshLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshLabelMouseClicked
        panel.removeAll();
        passLabel.setBackground(titleBar.getBackground());
        passLabel.setText("");
        copyLabel.setVisible(false);
        refresh();
    }//GEN-LAST:event_refreshLabelMouseClicked

    private void titleBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleBarMouseDragged
        int xDist = evt.getXOnScreen() - xOnScreen,
                yDist = evt.getYOnScreen() - yOnScreen;
        this.setLocation(xOnScreen + xDist - x, yOnScreen + yDist - y);
    }//GEN-LAST:event_titleBarMouseDragged
    private void titleBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleBarMousePressed
        xOnScreen = evt.getXOnScreen();
        yOnScreen = evt.getYOnScreen();
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_titleBarMousePressed

    private void passLabelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_passLabelPropertyChange
        passPanel.setBackground(titleBar.getBackground());
        copyLabel.setVisible(true);
    }//GEN-LAST:event_passLabelPropertyChange
    private void copyLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyLabelMouseClicked
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(passLabel.getText()), null);
        passPanel.setBackground(new Color(100, 200, 100));
        copyLabel.setVisible(false);
    }//GEN-LAST:event_copyLabelMouseClicked

    private void refresh() {
        if (osName.startsWith("Windows")) {
            refreshInWindows();
        } else if (osName.equals("Linux")) {
            refreshInLinux();
        }
        fillNetworks(listOfNetworks);
    }

    private void refreshInWindows() {
        try {
            Process p = new ProcessBuilder("cmd.exe", "/c", "netsh wlan show profiles").start();
            Scanner sc = new Scanner(new InputStreamReader(p.getInputStream()));

            if (!sc.hasNextLine()) {
                JOptionPane.showMessageDialog(this, "You don't have any known Wi-Fi network", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                listOfNetworks = new ArrayList<>();
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    // Get Name of current network
                    if (line.startsWith("    All User Profile     : ")) {
                        String name = line.replace("    All User Profile     : ", ""), password = "";
                        // Get Password of current network
                        p = new ProcessBuilder("cmd.exe", "/c", "netsh wlan show profiles name=\"" + name + "\" key=clear").start();
                        Scanner pSc = new Scanner(new InputStreamReader(p.getInputStream()));
                        while (pSc.hasNextLine()) {
                            line = pSc.nextLine();
                            if (line.startsWith("    Key Content            : ")) {
                                password = line.replace("    Key Content            : ", "");
                                break;
                            }
                        }
                        listOfNetworks.add(new Network(name, password, !password.equals("")));
                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "ERROR: " + ex.getMessage(), "Error", HEIGHT);
        }
    }

    private void refreshInLinux() {
        try {
            // Get rootPass
            if (rootPass == null) {
                rootPass = JOptionPane.showInputDialog(this, "Please enter root's password to perform the process", JOptionPane.QUESTION_MESSAGE);
            }
            // Get Wi-Fi known networks
            Process p = new ProcessBuilder("bash", "-c", "sudo -S grep -r psk= '/etc/NetworkManager/system-connections/'").start();
            new PrintWriter(new OutputStreamWriter(p.getOutputStream()), true).println(rootPass + "\n\r");
            Scanner sc = new Scanner(new InputStreamReader(p.getInputStream()));

            if (!sc.hasNextLine()) {
                JOptionPane.showMessageDialog(this, "You don't have any known Wi-Fi network", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                listOfNetworks = new ArrayList<>();
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    // Get Name of current network
                    if (line.startsWith("/etc/NetworkManager/system-connections/")) {

                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "ERROR: " + ex.getMessage(), "Error", HEIGHT);
        }
    }

    private void fillNetworks(ArrayList<Network> listOfNetworks) {
        listOfNetworks.forEach((network) -> {
            int rowsNo = panel.getComponentCount();
            JPanel rowPanel = createRow(panel, network.getName(), network.isLocked());
            rowPanel.setBounds(0, h * rowsNo, w, h);
            panel.add(rowPanel, rowsNo);
            panel.setPreferredSize(new Dimension(w, h * rowsNo));
            panel.repaint();
            contentpane.validate();
        });
    }

    private JPanel createRow(JPanel parent, String name, boolean locked) {
        JPanel rowPNL = new JPanel();
        rowPNL.setSize(w, h);
        rowPNL.setBackground(Color.WHITE);
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                rowPNL.setBackground(Color.WHITE);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                rowPNL.setBackground(new Color(200, 225, 225));
            }
        };
        rowPNL.addMouseListener(mouseAdapter);

        JLabel iconLBL = new JLabel(locked ? iconWiFiLock : iconWiFi);
        iconLBL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        JLabel nameLBL = new JLabel(name);
        nameLBL.setFont(new Font("Calibri", 0, 18)); // NOI18N

        JLabel showLBL = new JLabel(iconShowDark);
        showLBL.setName("network_" + parent.getComponentCount());
        showLBL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showLBL.setCursor(new Cursor(Cursor.HAND_CURSOR));
        showLBL.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                mouseAdapter.mouseExited(e);
                JLabel label = (JLabel) e.getSource();
                label.setIcon(iconShowDark);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                mouseAdapter.mouseEntered(e);
                JLabel label = (JLabel) e.getSource();
                label.setIcon(iconShowLight);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                String name = ((JLabel) e.getSource()).getName();
                int id = Integer.parseInt(name.substring(name.indexOf('_') + 1));
                Network network = listOfNetworks.get(id);
                String pass = network.getPassword();
                passLabel.setText(pass);
                if (!network.isLocked()) {
                    copyLabel.setVisible(false);
                }
            }
        });

        GroupLayout rowPNL_Layout = new GroupLayout(rowPNL);
        rowPNL.setLayout(rowPNL_Layout);
        rowPNL_Layout.setHorizontalGroup(
                rowPNL_Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(rowPNL_Layout.createSequentialGroup()
                                .addComponent(iconLBL, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(nameLBL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(showLBL, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
        );
        rowPNL_Layout.setVerticalGroup(
                rowPNL_Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(iconLBL, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(nameLBL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(showLBL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        if (!locked) {
            showLBL.setVisible(false);
        }
        return rowPNL;
    }

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
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
            java.util.logging.Logger.getLogger(Passwords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new Passwords().setVisible(true);
        });
    }

    //<editor-fold defaultstate="collapsed" desc="Variables declaration - do not modify">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel closeLabel;
    private javax.swing.JPanel container;
    private javax.swing.JScrollPane contentpane;
    private javax.swing.JLabel copyLabel;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPanel passPanel;
    private javax.swing.JLabel refreshLabel;
    private javax.swing.JScrollBar scrollBar;
    private javax.swing.JPanel titleBar;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>

}

class Network {

    private final String name, password;
    private final boolean locked;

    public Network(String name, String password, boolean locked) {
        this.name = name;
        this.password = password;
        this.locked = locked;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLocked() {
        return locked;
    }

}
