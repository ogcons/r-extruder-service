package hr.ogcs.rextruderservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Profile("mock")
@Component
public class RProcessMock implements RProcessor {
    @Value("${rscript.uploadDir}")
    private String uploadDir;

    @Override
    public Process execute(String command, String outputFileName, Path destinationPath) throws IOException {

        String targetFilenamePng = Paths.get(uploadDir, outputFileName).toString();

        // Creates blank image
        BufferedImage img = new BufferedImage(256, 256,
                BufferedImage.TYPE_INT_RGB);
        File f = new File(targetFilenamePng);

        ImageIO.write(img, "PNG", f);

        Files.move(f.toPath(), destinationPath);

        // returning dummy process
        // nslookup is one of the commands that works on Windows and Unix machines
        return new ProcessBuilder("nslookup", "localhost").start();

    }

}