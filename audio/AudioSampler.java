/** A collection of AudioSamples
 *
 *  @author John Reeve
 *  @version 0
 */

package audio;

import vars.AppVars;
import vars.AppStrings;
import audio.AudioSample;

public class AudioSampler {

    private AudioSample[] samples;

    public AudioSampler () {

        samples = new AudioSample[AppVars.NUMBERS_OF_SAMPLES];

        samples[0] = new AudioSample("./data/tie.wav");
        samples[1] = new AudioSample("./data/tie.wav");
        samples[2] = new AudioSample("./data/tie.wav");

        samples[0].setSampleTitle("TIE 1");
        samples[1].setSampleTitle("TIE 2");
        samples[2].setSampleTitle("TIE 3");


    }

    public int numberOfSamples () {
        return samples.length;
    }

    public String getSampleName (int slotNumber) {
        try {
            if (samples[slotNumber] != null) {
                return samples[slotNumber].getSampleTitle();
            } else {
                return AppStrings.DEFAULT_SAMPLE_NAME;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return AppStrings.DEFAULT_SAMPLE_NAME;
        }
    }

    public void playSample(int slotNumber) {
        try {
            if (samples[slotNumber] != null) {
                samples[slotNumber].playSample();
            }            
        } catch (Exception e) {
            e.printStackTrace();            
        }
    }
}