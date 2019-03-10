package com.taotao.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.service.*;

@Controller
public class Picetureupload {
		@Autowired
		PictureService picetureService;
		@RequestMapping("/pic/upload")
		@ResponseBody
		public Map picUpload(MultipartFile uploadFile,HttpServletRequest request){
			System.out.println("picUpload");
			String savedDir = request.getSession().getServletContext().getRealPath("image");
			Map restrul =picetureService.uploadPicture(uploadFile,savedDir);
			System.out.println(savedDir);
			return restrul;
		}
}
