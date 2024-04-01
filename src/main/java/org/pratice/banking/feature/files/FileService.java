package org.pratice.banking.feature.files;

import jakarta.servlet.http.HttpServletRequest;
import org.pratice.banking.feature.files.dto.FileRespone;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    List<FileRespone> uploadMultilpleFile(MultipartFile[] multipartFiles);
    FileRespone uploadSingleFile(MultipartFile multipartFile, HttpServletRequest httpServletRequest);
    void deleteFile(String filename);
    ResponseEntity<Resource> serVerImage(HttpServletRequest httpServletRequest, String filename);
}
