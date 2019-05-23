package com.cg112.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileUp {
	   //硬盘路径（绝对路径和虚拟路径）
		public static final String DISK_PATH = "E:/cg112.com/headIcn";
		public static final String VIRTUL_PATH ="/path";
		//S表示文件分割符 “/”
		private static final String S = File.separator;
		
		//返回图片的虚拟路径,图片上传和更新
		public static String upImg(MultipartFile file,int id,String imgPath) throws IOException{
			//首先判断图片是否存在
			if (imgPath != null){//表示图片存在,
				//imgPath存储的是虚拟路径，要先转换成绝对路径
				String oldImg = imgPath.replace(VIRTUL_PATH, DISK_PATH);
				//删除图片
				File oldFile = new File(oldImg);
				oldFile.delete();
			}
			//给上传的新的图片命名//生成全球唯一名字
			String imgName = UUID.randomUUID().toString();
			//得到上传文件的名字 
			String orgName = file.getOriginalFilename();
			//取原来文件后缀名
			String hzname = orgName.substring(orgName.lastIndexOf("."));
		    //新图片的名字诞生
			String newName = imgName + hzname;
			
			//为每个user创建一个文件夹
					String uForder = DISK_PATH + S +"user"+S+id;
					//3.新建业务文件夹
					File foder = new File(uForder);
					if(!foder.exists()){
						foder.mkdirs();
					}
					
					//将页面上传的图片二进制流，写入文件中
		    String newImg = uForder + S + newName;
			File newFile = new File(newImg);
			if(!newFile.exists()){
				newFile.createNewFile();
				file.transferTo(newFile);
				//将新图片的绝对路径转为虚拟路径
				return imgPath = newImg.replace(DISK_PATH, VIRTUL_PATH);
			}
			
			return null;
		}
		
}
