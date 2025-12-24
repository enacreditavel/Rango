package com.unifacisa.ads.rango.product.core.ports.out;

import java.io.InputStream;

public interface ProductImageStoragePort {
    String upload(InputStream fileStream, String fileName);
}
