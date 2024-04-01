package org.pratice.banking.feature.files;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.pratice.banking.feature.files.dto.FileRespone;
import org.pratice.banking.utils.BaseRespone;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("/api/v1/file")
@RequiredArgsConstructor
public class FilesRestController {
    private final FileService fileService;
    @PostMapping(name = "", consumes = "multipart/form-data")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseRespone<FileRespone> uploadSingleFile(@RequestPart("file") MultipartFile file, HttpServletRequest httpServletRequest)
    {
       return BaseRespone.<FileRespone> creatSuccess()
               .setPaylot(fileService.uploadSingleFile(file,httpServletRequest));
    }
    @GetMapping("/download/{filename}")
    public ResponseEntity<?> serverImage(HttpServletRequest httpServletRequest,@PathVariable  String filename)
    {
        return fileService.serVerImage(httpServletRequest,filename);
    }
}
