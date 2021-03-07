/*
 * 
 * This is a dialog for searching Employees by their surname.
 * 
 * */

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBySurnameDialog extends SearchDialog{
	EmployeeDetails parent;
	JButton search, cancel;
	JTextField searchField;
	// constructor for search by surname dialog

	public SearchBySurnameDialog(EmployeeDetails parent, String key) {
		super(parent, key);
	}

	// action listener for save and cancel button
	@Override
	public void actionPerformed(ActionEvent e) {
		// if option search, search for Employee
		if(e.getSource() == search){
			this.parent.searchBySurnameField.setText(searchField.getText());
			// search Employee by surname
			this.parent.searchEmployeeBySurname();
			dispose();// dispose dialog
		}// end if
		// else dispose dialog
		else if(e.getSource() == cancel)
			dispose();// dispose dialog
	}// end actionPerformed
}// end class SearchBySurnameDialog
