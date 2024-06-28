/**
 * -----------------------------------------------------
 * ES234211 - Programming Fundamental
 * Genap - 2023/2024
 * Group Capstone Project: Snake and Ladder Game
 * -----------------------------------------------------
 * Class    : D
 * Group    : 17
 * Members  :
 * 1. 5026231146 - Nicholas Evan Sitanggang
 * 2. 5026231195 - Ibrahim Amar Alfanani
 * 3. 5026221101 - Rosdiani Adiningsih
 * ------------------------------------------------------
 */
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.InputStream;
import java.util.Scanner;
import java.time.Duration;

public class AudioPlayer {
    private static Clip clip;

    public static void playSound(String soundFile) {//backsound properti kena ular,tangga,dll
        try {
            InputStream audioLink = AudioPlayer.class.getResourceAsStream("/" + soundFile);
            AudioInputStream audio = AudioSystem.getAudioInputStream(audioLink);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
            Thread.sleep(Duration.ofMillis(1500));//durasi suara bisa diubah
            clip.stop();
            clip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void playbackSound(String soundFile) {//backsound permainan sampe selesai
        try {
            InputStream audioLink = AudioPlayer.class.getResourceAsStream("/" + soundFile);
            AudioInputStream audio = AudioSystem.getAudioInputStream(audioLink);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
              clip.loop(Clip.LOOP_CONTINUOUSLY);
              clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void playSound2(String soundFile) {//backsound properti kena ular,tangga,dll
        try {
            InputStream audioLink = AudioPlayer.class.getResourceAsStream("/" + soundFile);
            AudioInputStream audio = AudioSystem.getAudioInputStream(audioLink);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
            Thread.sleep(Duration.ofMillis(5000));//durasi suara bisa diubah
            clip.stop();
            clip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    public static void playbackSound(String soundFile) {
//        try {
//            InputStream audioLink = AudioPlayer.class.getResourceAsStream("/" + soundFile);
//            AudioInputStream audio = AudioSystem.getAudioInputStream(audioLink);
//            clip = AudioSystem.getClip();
//            clip.open(audio);
//
//            Scanner scanner = new Scanner(System.in);
//            String input = "";
//
//            System.out.println("P=bergoyang Q=diam aja");
//            input = scanner.next();
//            input = input.toUpperCase();
//
//            if ("P".equals(input)) {
//                Thread musicThread = new Thread(() -> {
//                    clip.loop(Clip.LOOP_CONTINUOUSLY);
//                    while (true) {
//                        String threadInput = scanner.next().toUpperCase();
//                        if ("Q".equals(threadInput)) {
//                            clip.stop();
//                            break;
//                        }
//                    }
//                });
//                musicThread.start();
//            } else {
//                System.out.println();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }
}

