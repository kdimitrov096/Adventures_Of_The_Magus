package GUI;

import javax.swing.*;

public class Main_Frame extends JFrame {

    private JPanel view;

    public Main_Frame(String title, int width, int height) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);
        pack();
        setSize(width, height);
        setVisible(true);
        requestFocus();

        //set up the look and feel to the current OS
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        setIconImage(new ImageIcon("data/Game_Parts/Images/UserView/Icon/gameicon.png").getImage());
        setTitle(title);

    }

    public void showView(JPanel p){
        view.removeAll();
        view.add(p);
        view.repaint();
        view.revalidate();
    }
}
