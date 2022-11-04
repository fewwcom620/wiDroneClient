package me.friwi.tello4j;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ffmpegProcessor {
    public static void stream() {
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd-HH.mm.ss.SSS");
        long timestamp = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();

        Path errorFile = Paths.get(format.format(calendar.getTime()) + ".txt");
//        Path outputFile = Paths.get("D:/workspace/javaSCSample/output.txt");

        String cmd = "ffmpeg.exe";
//        "-f dshow -i video=\"Integrated Camera\" -vcodec libx264 -preset:v ultrafast -tune:v zerolatency -f flv rtmp://127.0.0.1/live/3"
        try {
            ProcessBuilder pb = new ProcessBuilder(cmd,
                    "-i", "udp://0.0.0.0:11111",
                    "-f", "flv", "rtmp://127.0.0.1:8000/live/7");

            pb.redirectError(errorFile.toFile());


            Process process = pb.start();

//            process.getErrorStream()

            Thread.sleep(60000);
            process.destroy();
            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);
        } catch (IOException | InterruptedException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }
}
