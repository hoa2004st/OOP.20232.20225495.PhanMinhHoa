package hust.soict.dsai.aims.screen.manager;

import hust.soict.dsai.aims.disc.CompactDisc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.disc.Playable;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel implements ActionListener {
    private Media media;
    JButton playButton;
    public MediaStore(Media media){
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable) {
            playButton = new JButton("Play");
            playButton.addActionListener(this);
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton){
            JFrame playFrame = new JFrame();
            playFrame.setBounds(0, 0, 400, 200);
            playFrame.setLocationRelativeTo(null);
            playFrame.setTitle("Playing...");

            JPanel playPanel = new JPanel();
            playPanel.setLayout(new GridLayout(2, 1, 5, 5));

            JLabel title = new JLabel();
            if (media instanceof CompactDisc) {
                title.setText("Playing CD: " + media.getTitle());
            } else if (media instanceof DigitalVideoDisc) {
                title.setText("Playing DVD: " + media.getTitle());
            }
            playPanel.add(title);
            JLabel length = new JLabel("Length: " + media.getLength());
            playPanel.add(length);

            playFrame.getContentPane().add(playPanel);
            playFrame.setVisible(true);
        };
    }

}
