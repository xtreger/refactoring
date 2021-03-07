import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public abstract class SearchDialog extends JDialog implements ActionListener {
    EmployeeDetails parent;
    JButton search, cancel;
    JTextField searchField;

    public SearchDialog(EmployeeDetails parent, String key) {
        setTitle("Search by " + key);
        setModal(true);
        this.parent = parent;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JScrollPane scrollPane = new JScrollPane(searchPane(key));
        setContentPane(scrollPane);

        getRootPane().setDefaultButton(search);

        setSize(500, 190);
        setLocation(350, 250);
        setVisible(true);
    }// end SearchBySurnameDialog

    // initialize search container
    public Container searchPane(String key) {
        JPanel searchPanel = new JPanel(new GridLayout(3,1));
        JPanel textPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JLabel searchLabel;

        searchPanel.add(new JLabel("Search by " + key));

        textPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        textPanel.add(searchLabel = new JLabel("Enter " + key + ":"));
        searchLabel.setFont(this.parent.font1);
        textPanel.add(searchField = new JTextField(20));
        searchField.setFont(this.parent.font1);
        searchField.setDocument(new JTextFieldLimit(20));

        buttonPanel.add(search = new JButton("Search"));
        search.addActionListener(this);
        search.requestFocus();

        buttonPanel.add(cancel = new JButton("Cancel"));
        cancel.addActionListener(this);

        searchPanel.add(textPanel);
        searchPanel.add(buttonPanel);

        return searchPanel;
    }// end searchPane

    public abstract void actionPerformed(ActionEvent e);
}

