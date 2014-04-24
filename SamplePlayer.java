/** SamplePlayer
 *  A simple player for audio samples
 *  @author John Reeve
 *  @version 0
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import vars.AppVars;
import vars.AppStrings;
import audio.AudioSample;

public class SamplePlayer  {

    private AudioSample samp;

    public SamplePlayer () {
        samp = new AudioSample();        
    }

    public static void main (String[] args) {
        System.out.println("started sample player");
        
        final SamplePlayer samplePlayer = new SamplePlayer();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                samplePlayer.createAndShowGUI();
            }
        });
    }

    private void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame(AppStrings.APPLICATION_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponentsToPane(frame.getContentPane());
        
        frame.setResizable(false);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    private void addComponentsToPane(Container pane) {

        pane.setLayout(new GridLayout(0, 4, 10, 10));

        JPanel sampleButtons = new JPanel();
        for (int i=0; i < AppVars.NUMBERS_OF_SAMPLES; i++ ){
            pane.add(addPlayButton( Integer.toString(i + 1), "play_" + Integer.toString(i)));
        }
        
    }

    private JButton addPlayButton(String text, String command) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(100, 100));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setActionCommand(command);
        button.addActionListener(new ActionListener() {     
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                samp.playSample();
            }
        });
        return button;
    }
}