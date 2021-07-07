package com.kpu.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ImageResourceAccessImpl implements ImageResourceAccess {

	@Override
	public List<String> fileListMethod(String uploadPath) throws Exception {
		File path = new File(uploadPath);
		File[] fileList = path.listFiles();
		List<String> fileNameList = new ArrayList<String>();
		
		if(fileList.length > 0) {
			for(int i=0; i<fileList.length; i++) {
				System.out.println(fileList[i].getName());
				fileNameList.add(fileList[i].getName());
			}
		}
		
		Collections.sort(fileNameList);
		Collections.reverse(fileNameList);
		
		return fileNameList;
	}

	@Override
	public List<String> detectFileListMethod(String detectPath) throws Exception {
		File path = new File(detectPath);
		File[] fileList = path.listFiles();
		
		List<String> fileNameList = new ArrayList<String>();
		
		if(fileList.length > 0) {
			for(int i=0; i<fileList.length; i++) {
				String[] temp = fileList[i].getName().split("\\.");
				
				if(!temp[1].equals("txt")) {
					fileNameList.add(fileList[i].getName());
				}
			}
		}
		
		Collections.sort(fileNameList);
		Collections.reverse(fileNameList);
		
		return fileNameList;
	}

}
