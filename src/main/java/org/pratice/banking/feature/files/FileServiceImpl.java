package org.pratice.banking.feature.files;
import jakarta.servlet.http.HttpServletRequest;
import org.pratice.banking.feature.files.dto.FileRespone;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
@Service
public class FileServiceImpl implements FileService{
    @Value("${file.storage_dir}")
    String filedir;
    private static final Set<String> SUPPORT_IMAGES_TYPE=
            Set.of(
                    MediaType.IMAGE_JPEG_VALUE,
                    MediaType.IMAGE_PNG_VALUE,
                    MediaType.IMAGE_GIF_VALUE
            );
    public String generateImageUrl(HttpServletRequest httpServletRequest,String filename)
    {
        return String.format("%s://%s:%d/images/%s",
                httpServletRequest.getScheme(),
                httpServletRequest.getServerName(),
                httpServletRequest.getServerPort(),
                filename
        );
    }
    public String generatUrlDownload(HttpServletRequest httpServletRequest,String filename)
    {
        return String.format("%s://%s:%d/api/v1/file/download/%s"
        ,httpServletRequest.getScheme(),
                httpServletRequest.getServerName(),
                httpServletRequest.getServerPort(),
                filename
        );
    }
    public String uploadfile(MultipartFile multipartFile)
    {
       String contentType=multipartFile.getContentType();
       if(!SUPPORT_IMAGES_TYPE.contains(contentType))
       {
           throw  new ResponseStatusException(HttpStatus.UNSUPPORTED_MEDIA_TYPE,"Invalid file type");
       }
        Path filelocation= Path.of(filedir);
        try {
            if (!Files.exists(filelocation)) {
                Files.createDirectories(filelocation);
            }
            String newfile= UUID.randomUUID()+"."+multipartFile.getOriginalFilename().split("\\.")[1];
            Path fullPath=filelocation.resolve(newfile);
            Files.copy(multipartFile.getInputStream(),fullPath, StandardCopyOption.REPLACE_EXISTING);
            return newfile;
        }catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Invalid file ");
            return null;
        }
    }
    @Override
    public List<FileRespone> uploadMultilpleFile(MultipartFile[] multipartFiles) {
       var newFile=new ArrayList<String>();
       for(var file:multipartFiles)
       {
           newFile.add(uploadfile(file));
       }
      return null;
    }
    @Override
    public FileRespone uploadSingleFile(MultipartFile multipartFile,HttpServletRequest httpServletRequest) {
        String filename=uploadfile(multipartFile);
        String fullUrl=generateImageUrl(httpServletRequest,filename);
        String dowloadUrl=generatUrlDownload(httpServletRequest,filename);
       return FileRespone.builder()
               .downloadUrl(dowloadUrl)
               .size(multipartFile.getSize())
               .fileType(multipartFile.getContentType())
               .filename(filename)
               .fullUrl(fullUrl)
               .build();
    }
    @Override
    public void deleteFile(String filename) {
        Path deleteFile=Path.of(filedir).resolve(filename);
        try {
            if (Files.exists(deleteFile)) {
                Files.delete(deleteFile);
            }
        }catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("invalid file to delete ");
        }
    }

    @Override
    public ResponseEntity<Resource> serVerImage(HttpServletRequest httpServletRequest, String filename) {
        try {
            Path imageUrl = Path.of(filedir).resolve(filename);
            Resource resource = new UrlResource(imageUrl.toUri());
            if(resource.exists())
            {
              return   ResponseEntity
                        .ok()
                        .contentType(MediaType.parseMediaType("image/jpeg"))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);

            }else{
                throw new RuntimeException("images url not found");
            }
        }catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        return null;
    }


}
