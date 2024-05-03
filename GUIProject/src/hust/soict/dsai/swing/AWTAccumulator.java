package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends  Frame{
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0;


    public AWTAccumulator() {
        super();
        setLayout(new GridLayout(2, 2));

        add(new Label("Enter an Integer: "));

        tfInput = new TextField(10);
        add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        add(new Label("The Accumulated Sum is: "));

        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);

        setTitle("AWT Accumulator");
        setSize(350, 120);
        setVisible(true);
    }

    public class TFInputListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            tfInput.setText("");
            tfOutput.setText(sum + "");
        }
    }

    public static void main(String[] args) {
        new AWTAccumulator();
    }
}
