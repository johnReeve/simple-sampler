/** The Edit Sample Interface
 *
 *  @author John Reeve
 *  @version 0
 */

package userinterface;

import vars.AppStrings;
import javax.swing.*;
import java.awt.*;

public class EditSampleInterface {

    private JFrame frame;

    public void open () {
        System.out.println("EditSampleInterface open action ran");

        if (frame == null) {

            JFrame frame = new JFrame(AppStrings.EDIT_SAMPLE_FRAME_TITLE);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


            JButton button = new JButton("Button 1 (PAGE_START)");
            frame.getContentPane().add(button, BorderLayout.PAGE_START);

            frame.pack();
            frame.setVisible(true);
        }

    }

}

