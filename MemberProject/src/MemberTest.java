import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MemberTest extends WindowAdapter {
	JFrame f;
	TextField Tid, Tpwd, Tfd;
	Checkbox doctor, user;
	Calendar date = Calendar.getInstance();
	Font btn_nomal;

	MemberTest() {
		f = new JFrame("���� ���� ���� �ý���");
		f.setSize(350, 500);
		f.getContentPane().setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f)); // ������ ���� ����
		f.setLayout(null);
		f.setResizable(false); // âũ�����

		JLabel Lid = new JLabel("���̵� :");
		JLabel Lpwd = new JLabel("��й�ȣ : ");
		JButton btn_login = new JButton("����");
		JButton btn_join = new JButton("ȸ������");
		JButton btn_find = new JButton("���̵�/��й�ȣã��");
		JTextField Tfd = new JTextField(46);
		JTextField Tid = new JTextField(20);
		JTextField Tpwd = new JTextField(20);
		Lid.setFont(btn_nomal);
		Lpwd.setFont(btn_nomal);

		Lid.setBounds(42, 300, 45, 25);
		Lpwd.setBounds(30, 335, 60, 25);
		Tid.setBounds(90, 300, 140, 25);
		Tpwd.setBounds(90, 335, 140, 25);
		btn_login.setBounds(240, 300, 60, 60);
		btn_join.setBounds(60, 370, 80, 25);
		btn_find.setBounds(160, 370, 140, 25);
		Tfd.setBounds(18, 420, 300, 25);// x, y, w,h

		Tfd.setEditable(false); // �ؽ�Ʈ�ʵ忡 �Է¸���
		f.add(Lid);
		f.add(Lpwd);
		f.add(Tid);
		f.add(Tpwd);
		f.add(btn_login);
		f.add(Tfd);
		f.add(btn_join);
		f.add(btn_find);
		btn_join.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		btn_find.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		btn_login.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.98f));
		btn_nomal = new Font("�����ٸ����", Font.PLAIN, 12);
		btn_join.setFont(btn_nomal);
		btn_find.setFont(btn_nomal);
		btn_login.setFont(btn_nomal);




		btn_login.addActionListener(new ActionListener() { // �α��� ��ư
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// -------------------------[�α��� ����]
				MemberDAO oct = new MemberDAO();
				if (Tid.getText().isEmpty()) {
					Tfd.setText("  ���̵� �Է����ּ���.");
				} else if (Tpwd.getText().isEmpty()) {
					Tfd.setText("  ��й�ȣ�� �Է����ּ���.");
				} else {
					ArrayList<MemberVo> list = oct.list(Tid.getText());
					if (list.size() == 0) {
						Tfd.setText("  ���̵�� ��й�ȣ�� Ȯ�����ּ���.");
					} else {
						MemberVo data = (MemberVo) list.get(0);
						if (data.getU_pwd().equals(Tpwd.getText())) {
							f.dispose();
							Login SP = new Login();
							SP.main_hospital(data);
						}
					}

				}
			}
		});
		btn_join.addActionListener(new ActionListener() { // ȸ�� ���� ��ư
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.dispose();
				membership TP = new membership();
				TP.join_choice();
			}
		});

		f.setVisible(true); // â�� ȭ�鿡 ��Ÿ�� ������ ����
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		// f.setVisible(true)�� ����ϰԵǸ� ���μ����� ���� �Ȳ����� ��찡 �����Ƿ� ���� ���� �ڵ带 �Է����־����.
	}



	public static void main(String args[]) {
		MemberTest ff = new MemberTest();

	}
	
    public void windowClosed(WindowEvent e) {
    	f.dispose();
    }
}