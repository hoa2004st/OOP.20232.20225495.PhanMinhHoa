package hust.soict.dsai.aims.screen.manager;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame implements ActionListener {
    private Store store;
    private JMenuItem viewStore;
    private JMenuItem addBook;
    private JMenuItem addCD;
    private JMenuItem addDVD;

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024,768);
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
        center.setLayout((new GridLayout(3, 3, 2, 2)));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < 9; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    public static void main(String[] args){
        Store store = new Store();
        for (int i = 0; i < 12; i++) {
            DigitalVideoDisc dvd = new DigitalVideoDisc("Doi Hoa", "Nhac Rap", "Ultimit", 100);
            store.addMedia(dvd);
        }
        new StoreManagerScreen(store);
    }

    public void actionPerformed(ActionEvent e) {
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
