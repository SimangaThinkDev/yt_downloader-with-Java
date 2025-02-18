import java.io.*;

public class YouTubeDownloader {
    public static void main(String[] args) {
        String videoUrl = "https://youtu.be/xTtL8E4LzTQ";
        String outputPath = "downloaded_video.mp4"; // Output file name

        try {
            ProcessBuilder pb = new ProcessBuilder(
                "yt-dlp", "-f", "best", "-o", outputPath, videoUrl);
            pb.redirectErrorStream(true);
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            process.waitFor();
            System.out.println("Download complete!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
// For High Quality Video
// yt-dlp -f "bv*+ba/b" "[Youtube-link]"


// For High Quality audio
// yt-dlp -f bestaudio --extract-audio --audio-format mp3 "[Youtube-link]"

// [pipx install yt-dlp] to run this in your linux machine
