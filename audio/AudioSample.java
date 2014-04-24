/** A single Audio Sample
 *
 *  @author John Reeve
 *  @version 0
 */

package audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class AudioSample {

    private static final int    EXTERNAL_BUFFER_SIZE = 128000;

    private static String strFilename = "./data/tie.wav";
    private String sampleTitle = "Tie Fighter";

    private File                soundFile;
    private AudioFormat         audioFormat;
    private AudioInputStream    audioInputStream;
    private SourceDataLine      line;
    private DataLine.Info       info;

    private Clip                clip;

    public AudioSample(){
        System.out.printf("InitSample: %s\n", strFilename);
        soundFile = new File(strFilename);

        try {
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

/////////////////// 

        //Keeping this because I need to:
            // Transcode bad formats
            // Playback longer samples

        // audioFormat = audioInputStream.getFormat();
        // info = new DataLine.Info(SourceDataLine.class, audioFormat);

        // // if (!AudioSystem.isLineSupported(info)) {
        // //     System.out.println("BUT Format IS NOT SUPPORTED!!!");
        // //     // This is the PCM format we want to transcode to.
        // //     // The parameters here are audio format details that you
        // //     // shouldn't need to understand for casual use.
        // //     AudioFormat pcm = new AudioFormat(
        // //                                 440000, //audioFormat.getSampleRate(), 
        // //                                 16, 
        // //                                 audioFormat.getChannels(), 
        // //                                 true,
        // //                                 false);

        // //     // Get a wrapper stream around the input stream that does the
        // //     // transcoding for us.
        // //     audioInputStream = AudioSystem.getAudioInputStream(pcm, audioInputStream);

        // //     // Update the format and info variables for the transcoded data
        // //     audioFormat = audioInputStream.getFormat();
        // //     info = new DataLine.Info(SourceDataLine.class, audioFormat);
        // // }
            
        // try {
        //     line = (SourceDataLine) AudioSystem.getLine(info);
        //     line.open(audioFormat);
        // }
        // catch (LineUnavailableException e) {
        //     e.printStackTrace();
        //     System.exit(1);
        // }
        // catch (Exception e) {
        //     e.printStackTrace();
        //     System.exit(1);
        // }

        // line.start();

        // int nBytesRead = 0;
        // byte[]  abData = new byte[EXTERNAL_BUFFER_SIZE];
        // while (nBytesRead != -1)
        // {
        //     try
        //     {
        //         nBytesRead = audioInputStream.read(abData, 0, abData.length);
        //     }
        //     catch (IOException e)
        //     {
        //         e.printStackTrace();
        //     }
        //     if (nBytesRead >= 0)
        //     {
        //         int nBytesWritten = line.write(abData, 0, nBytesRead);
        //     }
        // }

        // /*
        //   Wait until all data are played.
        //   This is only necessary because of the bug noted below.
        //   (If we do not wait, we would interrupt the playback by
        //   prematurely closing the line and exiting the VM.)
         
        //   Thanks to Margie Fitch for bringing me on the right
        //   path to this solution.
        // */
        // line.drain();

        // /*
        //   All data are played. We can close the shop.
        // */
        // line.close();
    }    

    /** plays the sample */
    public void playSample () {
        if( clip.isRunning() ) {
            clip.stop();
        }
        clip.setFramePosition( 0 );
        clip.start();
        System.out.printf("Playing sample: %s\n", strFilename);
    }
}