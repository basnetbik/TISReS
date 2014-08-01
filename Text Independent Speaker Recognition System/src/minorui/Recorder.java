/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minorui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;
import java.io.*;



/**
 *
 * @author Dell
 */
public class Recorder {
    
 
    // record duration, in milliseconds
    static final long RECORD_TIME = 60000;  // 1 minute
 
    // path of the wav file
    File wavFile = new File("C:/Users/Dell/Desktop/MinorUI/data/temp.wav");
 
    // format of audio file
    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
 
    // the line from which audio data is captured
    TargetDataLine line;

//    public Recorder() {
//        try {
//            
//            format = getAudioFormat();
//            info = new DataLine.Info(TargetDataLine.class, format);
//            // checks if system supports the data line
//                if (!AudioSystem.isLineSupported(info)) {
//                    System.out.println("Line not supported");
//                    System.exit(0);
//                }
//                line = (TargetDataLine) AudioSystem.getLine(info);
//                line.open(format);
//                
//        } catch (LineUnavailableException ex) {
//            Logger.getLogger(Recorder.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
     boolean stopflag;

 
    /**
     * Defines an audio format
     */
    
    AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 8;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
                                             channels, signed, bigEndian);
        return format;
    }
 
    /**
     * Captures the sound and record into a WAV file
     */
    AudioFormat format;
    DataLine.Info info;
    void start() {
        try {
            format = getAudioFormat();
            info = new DataLine.Info(TargetDataLine.class, format);
            // checks if system supports the data line
                if (!AudioSystem.isLineSupported(info)) {
                    System.out.println("Line not supported");
                    System.exit(0);
                }
                line = (TargetDataLine) AudioSystem.getLine(info);
                line.open(format);
                
//        } catch (LineUnavailableException ex) {
//            Logger.getLogger(Recorder.class.getName()).log(Level.SEVERE, null, ex);
//        }
            
            line.start();   // start capturing
 
            System.out.println("Start capturing...");
 
            AudioInputStream ais = new AudioInputStream(line);
 
            System.out.println("Start recording...");
 
            // start recording
            
            AudioSystem.write(ais, fileType, wavFile);
//            System.out.println();
 
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Recorder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        System.out.println("test");
//        if (stopflag)
//            finish();
        
        
    }
 
    /**
     * Closes the target data line to finish capturing and recording
     */
    void finish() {
        line.stop();
//            System.out.println("Line stop statement executed");
        line.close();
        System.out.println("Finished");
//        System.out.println(recording.getState());
//        recording.setIsTerminating(true); // tell the thread to stop
//recording.join();
        
//        System.out.println(recording.getState());
    }
 
    /**
     * Entry to run the program
     */
//    public static void main(String[] args) {
//        
//        final Recorder recorder = new Recorder();
// 
//        // creates a new thread that waits for a specified
//        // of time before stopping
//        Thread stopper = new Thread(new Runnable() {
//            public void run() {
//                try {
//                    Thread.sleep(RECORD_TIME);
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace();
//                }
//                recorder.finish();
//            }
//        });
// 
//        stopper.start();
// 
//        // start recording
//        recorder.start();
//        
//    }
    
        
        
          Thread recording = new Thread(new Runnable() {
            public void run() {
               start();
               
            }
            
//            public void stop(){
//                System.out.println("Stop called");
//                finish();
//            }
        });
    
}
