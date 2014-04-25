/** The Play Sample Interface
 *
 *  @author John Reeve
 *  @version 0
 */

package userinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import vars.AppVars;
import vars.AppStrings;

import audio.AudioSampler;

public class PlaySampleInterface {

    private AudioSampler sampler;
    private JFrame frame;

    public PlaySampleInterface (AudioSampler s) {

        sampler = s;

        //Create and set up the window.
        frame = new JFrame(AppStrings.APPLICATION_TITLE);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addMenuBarToFrame();
        addComponentsToPane(frame.getContentPane());
        
        frame.setResizable(false);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    private void addMenuBarToFrame() {

        System.setProperty("apple.laf.useScreenMenuBar", "true");

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem item = new JMenuItem("Edit Sample");


        item.addActionListener(new ActionListener() {     
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                //ui.openEditSampleInterface();
            }
        });
        file.add(item);
        menuBar.add(file);
        frame.setJMenuBar(menuBar);
    }

    private void addComponentsToPane(Container pane) {

        // sampler play button layout:
        pane.setLayout(new GridLayout(0, 4, 10, 10));

        for (int i=0; i < sampler.numberOfSamples(); i++ ){
            pane.add(addPlayButton( Integer.toString(i + 1), sampler.getSampleName(i), Integer.toString(i) ));
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
                sampler.playSample(Integer.parseInt(cmd));
            }
        });
        return button;
    }

}

