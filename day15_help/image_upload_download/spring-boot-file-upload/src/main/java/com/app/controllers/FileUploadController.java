package com.app.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class FileUploadController {
	
	public static String uploadLocation=System.getProperty("user.dir")+"/uploads";
	@GetMapping
	public String showUploadForm() {
		System.out.println("in show upload form ");
		return "upload";
	}

	@PostMapping
	public String processUploadForm(@RequestParam MultipartFile[] contents, Model map) {
		System.out.println("in process upload "+uploadLocation);
		StringBuilder sb=new StringBuilder("Uploaded files : ");
		for(MultipartFile file : contents)
		{
			sb.append(file.getOriginalFilename());
			Path path=Paths.get(uploadLocation,file.getOriginalFilename());
			try {
				Files.write(path,file.getBytes());
			} catch (IOException e) {
				System.out.println("err in process file upload "+e);
			}
		}
		map.addAttribute("mesg", sb.toString());
		return "uploaded";
	}
}
