package com.taotao.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.taotao.common.utils.IDUtils;
@Service
public class PictureServiceImp implements PictureService{

	@Override
	public Map uploadPicture(MultipartFile uploadFile,String savedir) {
		// TODO Auto-generated method stub
		Map restul = new HashMap<>();
		String oldname = uploadFile.getOriginalFilename();
		String newname = IDUtils.genImageName();
	    newname = newname+oldname.substring(oldname.lastIndexOf("."));
	    String path= null;
		try {
			InputStream fileSourse = uploadFile.getInputStream();
			 path = savedir+"\\"+newname;
			File  file = new File(path);
			FileOutputStream fos = new FileOutputStream(file);
			byte b[] = new byte[1024];
			int n;
			while((n=fileSourse.read(b))!=-1){
				fos.write(b, 0, n);
			}
			fos.close();
			fileSourse.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			restul.put("error", 1);
			restul.put("message", "error");
			return restul;
		}
		restul.put("error", 0);
		restul.put("url", path);
	    return restul;
	}

}
