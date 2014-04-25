/** SamplePlayer
 *  A simple player for audio samples
 *  @author John Reeve
 *  @version 0
 *
 */

import javax.swing.SwingUtilities;

import audio.AudioSampler;
import userinterface.Interfaces;

public class SamplePlayer  {

    private AudioSampler    samples;
    private Interfaces      ui;

    public static void main (String[] args) {
        System.out.println("started sample player");
        
        final SamplePlayer samplePlayer = new SamplePlayer();

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                samplePlayer.setupApp();
            }
        });
    }

    public void setupApp(){
        samples = new AudioSampler();
        ui      = new Interfaces(samples);
    }

}