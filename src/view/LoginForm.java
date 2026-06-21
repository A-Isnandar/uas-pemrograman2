package view;

import dao.TransaksiDAOImpl;
import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {
    private JTextField txtUser;
    private JPasswordField txtPass;
    private JButton btnLogin;

    public LoginForm() {
        setTitle("Login - Counter HP");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Header Keren
        JLabel lblHeader = new JLabel("LOGIN SISTEM", SwingConstants.CENTER);
        lblHeader.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblHeader.setOpaque(true);
        lblHeader.setBackground(new Color(41, 128, 185));
        lblHeader.setForeground(Color.WHITE);
        lblHeader.setPreferredSize(new Dimension(100, 50));
        add(lblHeader, BorderLayout.NORTH);

        // Panel Input
        JPanel pnlInput = new JPanel(new GridLayout(2, 2, 10, 20));
        pnlInput.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        pnlInput.add(new JLabel("Username:"));
        txtUser = new JTextField();
        pnlInput.add(txtUser);
        pnlInput.add(new JLabel("Password:"));
        txtPass = new JPasswordField();
        pnlInput.add(txtPass);
        add(pnlInput, BorderLayout.CENTER);

        // Panel Tombol
        JPanel pnlBtn = new JPanel();
        btnLogin = new JButton("LOGIN SEKARANG");
        btnLogin.setBackground(new Color(39, 174, 96));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 12));
        pnlBtn.add(btnLogin);
        add(pnlBtn, BorderLayout.SOUTH);

        // Action Login
        btnLogin.addActionListener(e -> {
            if (new TransaksiDAOImpl().checkLogin(txtUser.getText(), new String(txtPass.getPassword()))) {
                new MainFrame().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Username/Password Salah!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        // MENGAKTIFKAN TEMA MODERN (NIMBUS) BIAR UI KEREN BANGET
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {}
        SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
    }
}