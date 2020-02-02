package com.app.controllers;

import java.io.ByteArrayInputStream;
import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/download")
public class FileDownloadController {
	private static String folderLocation = "e:/images";

	@GetMapping
	public String showFiles(Model map) {
		System.out.println("in show files");
		File[] list = new File(folderLocation).listFiles();
		map.addAttribute("list", list);
		return "file_list";
	}

	@GetMapping("/{fileName}")
	@ResponseBody
	public void downloadFile(@PathVariable String fileName, HttpServletResponse resp, HttpServletRequest request) {
		try {
			File f1 = new File(folderLocation, fileName);
			System.out.println("abs path" + f1.getAbsolutePath());
			System.out.println("in file download " + request.getServletContext().getMimeType(f1.getName()));
			resp.setContentType(request.getServletContext().getMimeType(f1.getName()));
			byte[] data = FileUtils.readFileToByteArray(f1);
			IOUtils.write(data, resp.getOutputStream());
			 resp.flushBuffer();
		} catch (Exception e) {
			System.out.println("err in download " + e);
		}

	}

}
