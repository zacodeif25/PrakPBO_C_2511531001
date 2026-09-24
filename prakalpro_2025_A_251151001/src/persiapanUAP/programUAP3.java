package persiapanUAP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class programUAP3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtHasil;
	private JTextField txtNama;
	private JTextField txtUmur;
	
	private void pesanPeringatan (String Pesan) {
		JOptionPane.showMessageDialog(this, Pesan, "Peringatan", JOptionPane.WARNING_MESSAGE );
	}
	private void pesanKesalahan (String Pesan) {
		JOptionPane.showMessageDialog(this, Pesan, "Kesalahan", JOptionPane.ERROR_MESSAGE);
	}
	
	String nama;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					programUAP3 frame = new programUAP3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public programUAP3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UJI KELAYAKAN UNTUK PEMBUATAN SIM");
		lblNewLabel.setBounds(76, 10, 210, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAMA :");
		lblNewLabel_1.setBounds(22, 45, 76, 12);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("UMUR :");
		lblNewLabel_2.setBounds(22, 74, 44, 12);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Apakah Anda Sudah memiliki SIM C?");
		lblNewLabel_3.setBounds(22, 96, 168, 22);
		contentPane.add(lblNewLabel_3);

		JComboBox cbOperator = new JComboBox();
		cbOperator.setModel(new DefaultComboBoxModel(new String[] {"S", "B"}));
		cbOperator.setBounds(210, 97, 76, 22);
		contentPane.add(cbOperator);
		
		
		txtHasil = new JTextField();
		txtHasil.setBounds(22, 155, 292, 119);
		contentPane.add(txtHasil);
		txtHasil.setColumns(10);
		
		txtNama = new JTextField();
		txtNama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtNama.setBounds(108, 42, 96, 18);
		contentPane.add(txtNama);
		txtNama.setColumns(10);
		
		JButton btnProses = new JButton("PROSES");
		btnProses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String namaInput = txtNama.getText().trim();
			     String umurInput = txtUmur.getText().trim();
				if (txtNama.getText().trim().isEmpty()){
					pesanPeringatan("Silakan Masukkan nama anda terlebih dahulu");}
				else if (txtUmur.getText().trim().isEmpty()) {
					pesanPeringatan("Silakan Masukkan umur anda terlbih dahulu");}
				else {
					 try {
			                int umur = Integer.parseInt(umurInput);
			                int a = cbOperator.getSelectedIndex();
			                String hasil = "";

			                if (a == 0 && umur < 17) {
			                    hasil = "Nama : " + namaInput + "\n" +" Status : Anda Belum Cukup Umur untuk punya SIM";
			                } else if (a == 1 && umur < 17) {
			                    hasil = "Nama : " + namaInput + "\nStatus : Anda Belum Cukup Umur untuk bawa motor";
			                } else if (a == 1 && umur >= 17) {
			                    hasil = "Nama : " + namaInput + "\nStatus : Anda Harus Segera Membuat SIM";
			                } else if (a == 0 && umur >= 17) {
			                    hasil = "Nama : " + namaInput + "\nStatus : Anda Sudah Dewasa dan Boleh Bawa Motor";
			                }

			                txtHasil.setText(hasil);

			            } catch (NumberFormatException ex) {
			                pesanKesalahan("Umur harus berupa angka!");
			            }
			        }
				}
			}
		);
		btnProses.setBounds(122, 128, 84, 20);
		contentPane.add(btnProses);

		
		txtUmur = new JTextField();
		txtUmur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		txtUmur.setBounds(108, 71, 96, 18);
		contentPane.add(txtUmur);
		txtUmur.setColumns(10);

	}
}
