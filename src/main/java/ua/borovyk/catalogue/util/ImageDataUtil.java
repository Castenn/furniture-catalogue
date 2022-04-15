package ua.borovyk.catalogue.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.UUID;

public class ImageDataUtil {

    public static final String PRODUCT_IMAGE_PATH = "./src/main/resources/public/img/product";

    public static byte[] readProductImage(String name, String extension) throws IOException {
        return Files.readAllBytes(getProductImagePath(name, extension));
    }

    public static String saveProductImage(MultipartFile image) throws IOException {
        var name = UUID.fromString(image.getName());
        var content = image.getBytes();
        var originalFilename = image.getOriginalFilename();
        Objects.requireNonNull(originalFilename);
        var extension = originalFilename.substring(originalFilename.lastIndexOf('.') + 1);

        var imageFile = getProductImagePath(name.toString(), extension).toFile();
        if (imageFile.exists()) {
            imageFile.delete();
        }
        imageFile.createNewFile();
        Files.write(imageFile.toPath(), content);

        return name.toString();
    }

    private static Path getProductImagePath(String name, String extension) {
        return Path.of(PRODUCT_IMAGE_PATH + "/" + name + "." + extension);
    }

}
