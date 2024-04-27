package _00_Intro_To_ArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	ArrayList<String> list = new ArrayList<String>();
	JFrame frame;
	JPanel panel;
	JButton add;
	JButton view;
    /*
     * Create a GUI with two buttons. One button reads "Add Name" and the other
     * button reads "View Names". When the add name button is clicked, display
     * an input dialog that asks the user to enter a name. Add that name to an
     * ArrayList. When the "View Names" button is clicked, display a message
     * dialog that displays all the names added to the list. Format the list as
     * follows:
     * Guest #1: Bob Banders
     * Guest #2: Sandy Summers
     * Guest #3: Greg Ganders
     * Guest #4: Donny Doners
     */
public static void main(String[] args) {
	_02_GuestBook book = new _02_GuestBook();
	book.setup();
}
public _02_GuestBook() {
	frame = new JFrame();
	panel = new JPanel();
	add = new JButton("Add");
	view = new JButton("View");
}
void setup() {
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(panel);
	add.addActionListener(this);
	view.addActionListener(this);
	panel.add(view);
	panel.add(add);
	frame.pack();
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==view) {
		if(list.size()==0) {
			JOptionPane.showMessageDialog(null, "No guests on the guest list!");
		} else {
		String guestList = "";
		int i = 1;
		for(String s : list) {
			guestList+=("GUEST #"+i+": "+s+"\n");
			i++;
		}
		JOptionPane.showMessageDialog(null, guestList);
		}
	}
	if(e.getSource()==add) {
		list.add(JOptionPane.showInputDialog("Guest Name?"));
	}
}
}
