/*
 * 
 * This is the dialog for Employee search by ID
 * 
 * */

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchByIdDialog extends SearchDialog {
	EmployeeDetails parent;
	JButton search, cancel;
	JTextField searchField;

	public SearchByIdDialog(EmployeeDetails parent, String key) {
		super(parent, key);
	}
	// constructor for SearchByIdDialog 


	// action listener for save and cancel button
	@Override
	public void actionPerformed(ActionEvent e) {
		// if option search, search for Employee
		if (e.getSource() == search) {
			// try get correct valus from text field
			try {
				Double.parseDouble(searchField.getText());
				this.parent.searchByIdField.setText(searchField.getText());
				// search Employee by ID
				this.parent.searchEmployeeById();
				dispose();// dispose dialog
			}// end try
			catch (NumberFormatException num) {
				// display message and set colour to text field if entry is wrong
				searchField.setBackground(new Color(255, 150, 150));
				JOptionPane.showMessageDialog(null, "Wrong ID format!");
			}// end catch
		}// end if
		// else dispose dialog
		else if (e.getSource() == cancel)
			dispose();
	}// end actionPerformed
}// end class searchByIdDialog
