package com.mono.pgm.Controller;

import com.mono.pgm.Model.FileOne;
import com.mono.pgm.Service.FileOneService;
import com.mono.pgm.Model.Pkg_info;
import com.mono.pgm.DbRepo.Pkg_info_repo;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@RestController
public class controller
{

    @Autowired
    private FileOneService fileSer;

    @Autowired
    private Pkg_info_repo repo;

    @GetMapping("/hi")
    public String hi()
    {
        return "hi!";
    }

    @PostMapping("/add-pkg_info")
    public ResponseEntity<?> addPkg_info(@RequestBody Pkg_info p)
    {
        Pkg_info save = this.repo.save(p);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/get-pkg_info/{name}")
    public ResponseEntity<?> fetchPkg_info(@PathVariable(required = true) String name)
    {
        Optional<Pkg_info> pkg = repo.findById(name);
        if (pkg.isPresent()) {
            return ResponseEntity.ok(pkg.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Collections.singletonMap("message","Package not found"));
        }
    }

    @PostMapping("/upload-pkg")
    public String uploadPkg(@RequestParam("thefile") MultipartFile file)throws IOException
    {
        return fileSer.addFileOne(file.getOriginalFilename(),file);
    }

    @GetMapping("/down-pkg/{title}")
    public void downloadPkg(@PathVariable String title, HttpServletResponse response) throws IOException
    {
        FileOne fl = fileSer.getFileOne(title);
        FileCopyUtils.copy(fl.getStr(),response.getOutputStream());
    }

}
