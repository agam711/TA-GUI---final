package View;

import Entity.PraktikumEntity07220;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class PraktikanGUI07220 {

    JFrame Praktikan = new JFrame();
    JButton back, daftarbtn;
    JTextArea area = new JTextArea();
    JLabel datadiri, daftarpraktikum;
    JComboBox pilprak = new JComboBox(PraktikumEntity07220.nama);
    int cek = Allobjctrl07220.Praktikan.cekDaftarprak(Allobjctrl07220.Praktikan.PraktikanEntity().getNpm());

    public PraktikanGUI07220() {
        Praktikan.setSize(720, 600);
        Praktikan.setLayout(null);
        Praktikan.getContentPane().setBackground(Color.PINK);
        datadiri = new JLabel("Data Praktikan");
        datadiri.setFont(new Font("Times New Roman", Font.BOLD, 30));
        datadiri.setBounds(90, 30, 200, 30);
        Praktikan.add(datadiri);
        area.setBounds(30, 90, 400, 300);
        Praktikan.add(area);
        daftarpraktikum = new JLabel("Daftar Praktikum");
        daftarpraktikum.setBounds(450, 30, 250, 30);
        daftarpraktikum.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Praktikan.add(daftarpraktikum);
        pilprak.setBounds(450, 90, 230, 30);
        Praktikan.add(pilprak);
        daftarbtn = new JButton("Daftar");
        daftarbtn.setBounds(500, 200, 100, 30);
        daftarbtn.setBackground(Color.GREEN);
        Praktikan.add(daftarbtn);
        back = new JButton("back");
        back.setBounds(30, 500, 100, 30);
        back.setBackground(Color.red);
        Praktikan.add(back);
        Praktikan.setVisible(true);
        Praktikan.setLocationRelativeTo(null);
        Praktikan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (cek == -1) {
            JOptionPane.showMessageDialog(null, "Anda Belum Daftar Praktikum", "information", JOptionPane.INFORMATION_MESSAGE);
        } else if (cek == -2) {
            JOptionPane.showMessageDialog(null, "Anda Belun Daftar praktikum", "information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            area.setText(datapraktikan());
        }
        daftarbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int indexprak = pilprak.getSelectedIndex();
                Allobjctrl07220.Praktikan.daftarPraktikum(indexprak, Allobjctrl07220.Praktikan.getData(), false);
                area.setText(datapraktikan());
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Praktikan.dispose();
                GUI07220 men = new GUI07220();
            }
        });
    }

    public String datapraktikan() {
        int cek = Allobjctrl07220.Praktikan.cekDaftarprak(Allobjctrl07220.Praktikan.PraktikanEntity().getNpm());
        String cekverif;
        if (Allobjctrl07220.Praktikan.showDaftarprak(cek).isVerified() == false) {
            cekverif = "belum diverifikasi";
        } else {
            cekverif = "sudah diverifikasi";
        }
        String text = "Npm = " + Allobjctrl07220.Praktikan.showDaftarprak(cek).getPraktikan().getNpm() + "\n" + "Nama = " + Allobjctrl07220.Praktikan.showDaftarprak(cek).getPraktikan().getNama() + "\n"
                + "No Telp = " + Allobjctrl07220.Praktikan.showDaftarprak(cek).getPraktikan().getNo_telp() + "\n" + "Tanggal Lahir = " + new SimpleDateFormat("dd-MM-yyyy").
                format(Allobjctrl07220.Praktikan.showDaftarprak(cek).getPraktikan().getTglLahir()) + "\n" + "verifikasi = " + cekverif + "\n" + "Kelas = " + Allobjctrl07220.Praktikan.
                showDaftarprak(cek).getPraktikan().getKelas() + "\n" + "praktikum = " + PraktikumEntity07220.nama[Allobjctrl07220.Praktikan.showDaftarprak(cek).getIndexPraktikum()];
        return text;
    }
}
