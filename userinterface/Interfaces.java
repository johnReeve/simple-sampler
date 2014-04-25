/** A collection of User Interfaces
 *
 *  @author John Reeve
 *  @version 0
 */

package userinterface;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import userinterface.EditSampleInterface;
import userinterface.PlaySampleInterface;

import audio.AudioSampler;

public class Interfaces {

    private EditSampleInterface editSample;
    private PlaySampleInterface playSamples;

    public Interfaces(AudioSampler sampler) {

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

        playSamples = new PlaySampleInterface(sampler);
        //editSample  = new EditSampleInterface(sampler);
    }
}

