import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotePad extends JFrame implements ActionListener {

    JTextArea textArea;
    JSpinner fontSizeSpinner;
    JScrollPane scrollPane;
    JComboBox comboBox;
    JButton colorButton;
    NotePad() {

        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setTitle("Note Pad");



        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial",Font.PLAIN,20));
        textArea.setBorder(BorderFactory.createLineBorder(Color.black,2));


        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10,40,970,700);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);

        fontSizeSpinner = new JSpinner();
        fontSizeSpinner.setBounds(490,2,90,30);
        fontSizeSpinner.setValue(20);
        fontSizeSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN,(int)fontSizeSpinner.getValue()));
            }
        });
        add(fontSizeSpinner);

        colorButton = new JButton("Choose Color");
        colorButton.setBounds(600,2,120,30);
        colorButton.addActionListener(this);
        add(colorButton);

        String [] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        comboBox = new JComboBox(fonts);
        comboBox.setBounds(750,2,200,30);
        comboBox.addActionListener(this);
        comboBox.setSelectedItem("Arial");
        add(comboBox);



    }


    public static void main(String[] args) {

        new NotePad();

    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource()==comboBox){
            textArea.setFont(new Font((String) comboBox.getSelectedItem(),Font.PLAIN,(int)fontSizeSpinner.getValue()));
        }
        if(e.getSource()==colorButton){
            Color clr = JColorChooser.showDialog(null,"Pick a Color",Color.black);
            textArea.setForeground(clr);
        }
    }
}
