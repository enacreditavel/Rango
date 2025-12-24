package com.unifacisa.ads.rango.product.core;

import java.io.InputStream;

public record RawImage(
        InputStream inputStream,
        String fileName
) {
}
