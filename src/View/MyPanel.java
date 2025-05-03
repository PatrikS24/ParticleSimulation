package View;

import Controller.EmitterManager;
import Model.ParticleType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

public class MyPanel extends JPanel implements ActionListener {
    EmitterManager emitterManager;
    BufferedImage image;
    Timer timer;
    JButton clearButton;
    JComboBox<ParticleTextType> comboBox;
    ParticleTextType[] particleTypes = {new SparkTextType(), new EmberTextType(), new WaterHoseTextType()};

    MyPanel() {
        emitterManager = new EmitterManager(this);
        image = createBufferedImage();
        timer = new Timer(16,this);
        timer.start();
        clearButton = new JButton("Clear");
        comboBox = new JComboBox<>(particleTypes);
        this.add(comboBox);

        this.add(clearButton);

        clearButton.addActionListener(e -> emitterManager.clearEmitters());

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                ParticleTextType type = (ParticleTextType)comboBox.getSelectedItem();

                emitterManager.createEmitter(type.getType(), e.getX(),e.getY());
            }
        });
    }

    public BufferedImage createBufferedImage() {
        BufferedImage img = new BufferedImage(500, 500, TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2d.dispose();
        return img;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        emitterManager.updateImage(image);
        repaint();
    }
}
