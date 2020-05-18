package com.pinyougou.manager.controller;

import com.pinyougou.util.AliyunOSSClientUtil;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class UploadController {
	
	
	@Autowired
	AliyunOSSClientUtil aliyunOSSClientUtil;
	
	@RequestMapping("/upload")
	public Result upload(MultipartFile file){
		
		try{
			
			String name = aliyunOSSClientUtil.uploadImg2Oss(file);
			String imgIrl = aliyunOSSClientUtil.getImgUrl(name);
			
			return new Result(true,imgIrl);
			
		}catch(Exception e){
			e.printStackTrace();
			return new Result(false,"上传失败");
		}
		
	}

}
