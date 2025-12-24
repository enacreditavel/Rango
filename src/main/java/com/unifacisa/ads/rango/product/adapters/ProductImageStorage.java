package com.unifacisa.ads.rango.product.adapters;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.unifacisa.ads.rango.product.core.ports.out.ProductImageStoragePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductImageStorage implements ProductImageStoragePort {
    private final Cloudinary cloudinary;

    public ProductImageStorage(@Value("${cloudinary.cloud_name}") String cloudName,
                               @Value("${cloudinary.api_key}") String apiKey,
                               @Value("${cloudinary.api_secret}") String apiSecret) {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret
        ));
    }

    @Override
    public String upload(InputStream fileStream, String fileName) {
        try {
            Map uploadResult = cloudinary.uploader().upload(fileStream,
                    ObjectUtils.asMap("public_id", fileName)); // "public_id" define o nome no Cloudinary
            log.info("Image uploaded successfully: " + uploadResult.get("url"));
            return (String) uploadResult.get("url"); // Retorna a URL pública (http/https)
        } catch (IOException e) {
            throw new RuntimeException("Erro ao subir imagem para o Cloudinary", e);
        }
    }
}

