import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import java.io.*;
import java.security.GeneralSecurityException;

import java.util.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;




public class DriveStartup {
   private static final String APPLICATION_NAME = "startup";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Arrays.asList(DriveScopes.DRIVE);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */


    public static void main(String... args) throws IOException, GeneralSecurityException {


    }

//    private static void compressionImage(Drive service) throws IOException {
//        java.io.File input = new java.io.File("img.jpg");
//        BufferedImage image = ImageIO.read(input);
//
//        java.io.File compressedImageFile = new java.io.File("compressed_image2.jpg");
//        OutputStream os = new FileOutputStream(compressedImageFile);
//
//        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
//        ImageWriter writer = (ImageWriter) writers.next();
//
//        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
//        writer.setOutput(ios);
//        ImageWriteParam param = writer.getDefaultWriteParam();
//
//        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
//        param.setCompressionQuality(0.1f);  // Change the quality value you prefer
//        writer.write(null, new IIOImage(image, null, null), param);
//
//        os.close();
//        ios.close();
//        writer.dispose();
//    }

    private static void downloadFile(Drive service) throws IOException {
        String fileId = "1ii3ybKFChv1VAQRQSQZeaBKDxjdE7Wvd";
        FileOutputStream outputStream = new FileOutputStream("img.jpg");
        System.out.println("Downloading...");
        service.files().get(fileId)
                .executeMediaAndDownloadTo(outputStream);
        System.out.println("Finish");
    }

//    private static void uploadFile(Drive service) throws IOException {
//        File fileMetadata = new File();
//        fileMetadata.setName("dvx.jpg");
//        java.io.File filePath = new java.io.File("photo1.jpeg");
//        FileContent mediaContent = new FileContent("image/jpeg", filePath);
//        File file = service.files().create(fileMetadata, mediaContent)
//                .setFields("id")
//                .execute();
//        System.out.println("File ID: " + file.getId());
//
//    }

    private static void uploadAndDownloadFile(Drive service) throws Exception {
        File fileMetadata = new File();
        fileMetadata.setName("dvx.jpg");
        java.io.File filePath = new java.io.File("photo1.jpeg");
        FileContent mediaContent = new FileContent("image/jpeg", filePath);
        File file = service.files().create(fileMetadata, mediaContent)
                .setFields("id")
                .execute();
        System.out.println("File ID: " + file.getId());
        String fileId = file.getId();
        FileOutputStream outputStream = new FileOutputStream("img.jpg");
        System.out.println("Downloading...");
        service.files().get(fileId)
                .executeMediaAndDownloadTo(outputStream);
        System.out.println("Finish");
    }

}