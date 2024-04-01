package org.pratice.banking.feature.files.dto;

import lombok.Builder;

@Builder
public record FileRespone(
        String filename,
        String fullUrl,
        String downloadUrl,
        String fileType,
        float size) {
}
