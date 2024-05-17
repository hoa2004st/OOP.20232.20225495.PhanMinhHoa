package hust.soict.dsai.aims.screen.manager;

import hust.soict.dsai.aims.disc.CompactDisc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends JFrame implements ActionListener {
    private Store store;
    private JMenuItem viewStore;
    private JMenuItem addBook;
    private JMenuItem addCD;
    private JMenuItem addDVD;
    private JButton confirmButton;
    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;
    private JTextField tf4;
    private JTextField tf5;
    public AddDigitalVideoDiscToStoreScreen (Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("AddDVDToStore");
        setSize(300,600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        viewStore = new JMenuItem("View store");
        viewStore.addActionListener(this);
        menu.add(viewStore);

        JMenu smUpdateStore = new JMenu("Update Store");
        addBook = new JMenuItem("Add Book");
        addBook.addActionListener(this);
        smUpdateStore.add(addBook);
        addCD = new JMenuItem("Add CD");
        addCD.addActionListener(this);
        smUpdateStore.add(addCD);
        addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(this);
        smUpdateStore.add(addDVD);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(11, 1, 0, 10));

        JLabel l1 = new JLabel("Enter id:");
        JLabel l2 = new JLabel("Enter title:");
        JLabel l3 = new JLabel("Enter category:");
        JLabel l4 = new JLabel("Enter cost:");
        JLabel l5 = new JLabel("Enter length:");
        JLabel[] labels = new JLabel[]{l1, l2, l3, l4,l5};

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        JTextField[] textFields = new JTextField[]{tf1, tf2, tf3, tf4, tf5};

        for (int i = 0; i < 5; i++){
            labels[i].setBounds(50, 50, 100, 30);
            center.add(labels[i]);
            textFields[i].setBounds(50, 50, 150, 20);
            center.add(textFields[i]);
        }

        confirmButton = new JButton("Confirm");//create button
        confirmButton.setBounds(130,100,100, 40);
        confirmButton.addActionListener(this);
        center.add(confirmButton);

        return center;
    }
    public static void main(String[] args){
        Store store = new Store();
        for (int i = 0; i < 12; i++) {
            DigitalVideoDisc dvd = new DigitalVideoDisc("Doi Hoa", "Nhac Rap", "Ultimit", 100);
            store.addMedia(dvd);
        }
        new AddDigitalVideoDiscToStoreScreen(store);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton){
            DigitalVideoDisc dvd = new DigitalVideoDisc(Integer.parseInt(tf1.getText()), tf2.getText(), tf3.getText(), Float.parseFloat(tf4.getText()), Integer.parseInt(tf5.getText()));
            store.addMedia(dvd);
            System.out.println("A new DVD is added to the store!");
            return;
        };
        if (e.getSource() == viewStore){
            dispose();
            new StoreManagerScreen(store).setVisible(true);
        };
        if (e.getSource() == addBook){
            new AddBookToStoreScreen(store).setVisible(true);
        };
        if (e.getSource() == addCD){
            new AddCompactDiscToStoreScreen(store).setVisible(true);
        };
        if (e.getSource() == addDVD){
            new AddDigitalVideoDiscToStoreScreen(store).setVisible(true);
        };
    }
}

