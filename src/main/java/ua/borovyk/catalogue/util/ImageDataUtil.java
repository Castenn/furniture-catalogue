package ua.borovyk.catalogue.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageDataUtil {

    public static final String PRODUCT_IMAGE_PATH = "./src/main/ui/public/img/product";
    public static void saveProductImage(String name, String extension, byte[] content) {
        try {
            saveProductImageFile(name, extension, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteProductImage(String name, String extension) {
        try {
            Files.delete(getProductImagePath(name, extension));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void saveProductImageFile(String name, String extension, byte[] content) throws IOException {
        var imageFile = getProductImagePath(name, extension).toFile();
        if (imageFile.exists()) {
            imageFile.delete();
        }
        imageFile.createNewFile();
        Files.write(imageFile.toPath(), content);
    }

    private static Path getProductImagePath(String name, String extension) {
        return Path.of(PRODUCT_IMAGE_PATH + "/" + name + "." + extension);
    }

}
