package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import _00_Intro_To_ArrayLists._02_GuestBook;

public class _02_LogSearch implements ActionListener{
	HashMap<Integer, String> database = new HashMap<Integer, String>();
	JFrame frame;
	JPanel panel;
	JButton add;
	JButton search;
	JButton view;
	JButton remove;
	public static void main(String[] args) {
		_02_LogSearch log = new _02_LogSearch();
		log.setup();
	}
	public _02_LogSearch() {
		frame = new JFrame();
		panel = new JPanel();
		add = new JButton("Add Entry");
		view = new JButton("View List");
		search = new JButton("Search by ID");
		remove = new JButton("Remove Entry");
	}
	void setup() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		add.addActionListener(this);
		view.addActionListener(this);
		search.addActionListener(this);
		remove.addActionListener(this);
		panel.add(view);
		panel.add(add);
		panel.add(search);
		panel.add(remove);
		frame.pack();
	}
    /*
     * Crate a HashMap of Integers for the keys and Strings for the values.
     * Create a GUI with three buttons.
     * Button 1: Add Entry
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      After an ID is entered, use another input dialog to ask the user
     *      to enter a name. Add this information as a new entry to your
     *      HashMap.
     * 
     * Button 2: Search by ID
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      If that ID exists, display that name to the user.
     *      Otherwise, tell the user that that entry does not exist.
     * 
     * Button 3: View List
     *      When this button is clicked, display the entire list in a message
     *      dialog in the following format:
     *      ID: 123  Name: Harry Howard
     *      ID: 245  Name: Polly Powers
     *      ID: 433  Name: Oliver Ortega
     *      etc...
     * 
     * When this is complete, add a fourth button to your window.
     * Button 4: Remove Entry
     *      When this button is clicked, prompt the user to enter an ID using
     *      an input dialog.
     *      If this ID exists in the HashMap, remove it. Otherwise, notify the
     *      user that the ID is not in the list.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==view) {
			
		} else if(e.getSource()==add) {
			database.put(Integer.getInteger(JOptionPane.showInputDialog("Enter an ID Number")), JOptionPane.showInputDialog("Enter your Data"));
			
		} else if(e.getSource()==search) {
			
		} else if(e.getSource()==remove) {
			
		}
	}

}
