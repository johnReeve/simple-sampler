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
import audio.AudioSampler;

public class SamplePlayer  {

    private AudioSampler samples;

    public SamplePlayer () {

        samples = new AudioSampler();

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

        addMenuBarToFrame(frame);
        addComponentsToPane(frame.getContentPane());
        
        frame.setResizable(false);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    // system menu bar:
    private void addMenuBarToFrame(JFrame frame) {

        System.setProperty("apple.laf.useScreenMenuBar", "true");

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem item = new JMenuItem("Edit Sample or die");
        
        file.add(item);
        menuBar.add(file);
        frame.setJMenuBar(menuBar);
    }

    private void addComponentsToPane(Container pane) {

        // sampler play button layout:
        pane.setLayout(new GridLayout(0, 4, 10, 10));

        JPanel sampleButtons = new JPanel();
        for (int i=0; i < samples.numberOfSamples(); i++ ){
            pane.add(addPlayButton( Integer.toString(i), samples.getSampleName(i), Integer.toString(i) ));
        }
        
    }

    private JButton addPlayButton(String buttonTitle, String sampname, String command) {
        JButton button = new JButton();

        button.setLayout(new BorderLayout());

        JLabel buttonName = new JLabel( buttonTitle  );
        JLabel sampleName = new JLabel( sampname );

        button.add(BorderLayout.NORTH, buttonName );
        button.add(BorderLayout.SOUTH, sampleName);

        button.setPreferredSize(new Dimension(100, 100));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setActionCommand(command);
        button.addActionListener(new ActionListener() {     
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                samples.playSample(Integer.parseInt(cmd));
            }
        });
        return button;
    }
}