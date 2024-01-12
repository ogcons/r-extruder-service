package hr.ogcs.rextruderservice.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class DocumentService {

    @Value("${word.document.image.width}")
    private int imageWidth;

    @Value("${word.document.image.height}")
    private int imageHeight;

    public byte[] generateCombinedWord(List<byte[]> plotBytesList) throws IOException {
        if (plotBytesList.isEmpty()) {
            throw new IllegalArgumentException("plotBytesList cannot be empty");
        }
        try (XWPFDocument document = new XWPFDocument()) {
            for (byte[] plotBytes : plotBytesList) {
                XWPFParagraph paragraph = document.createParagraph();
                XWPFRun run = paragraph.createRun();

                int imageFormat = Document.PICTURE_TYPE_PNG;
                String imageId = document.addPictureData(new ByteArrayInputStream(plotBytes), imageFormat);

                XWPFPicture picture = run.addPicture(new ByteArrayInputStream(plotBytes),
                        imageFormat, "image.png",
                        Units.toEMU(imageWidth), Units.toEMU(imageHeight));
                picture.getCTPicture().getBlipFill().getBlip().setEmbed(imageId);
            }

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            document.write(baos);

            return baos.toByteArray();
        } catch (Exception e) {
            log.error("Error during Word document generation: {}", e.getMessage());
            throw new IOException("Error during Word document generation", e);
        }
    }
}