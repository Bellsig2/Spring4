package com.wookdongkang.s4.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	// fileSave
	// 파일을 저장
	public String fileSave(MultipartFile multipartFile, File file) throws IOException {
		if(!file.exists()) {
			file.mkdirs();
		}
		String fileName = UUID.randomUUID().toString();
		fileName = fileName + multipartFile.getOriginalFilename();
		
		file = new File(file, fileName);
		
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		/* multipartFile.transferTo(file); */
		return fileName;
	}
	
	  public void fileDelete(File file) { file.delete(); }
	

}
