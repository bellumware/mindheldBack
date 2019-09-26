package com.mindheld.components;

import static com.mindheld.constants.Constants.JPG;
import static com.mindheld.constants.Constants.PHOTOS_PATH;
import static com.mindheld.constants.Constants.PHOTOS_URL;
import static com.mindheld.constants.Constants.SUPPORT_FILES_PATH;
import static com.mindheld.constants.Constants.SUPPORT_FILES_URL;
import static com.mindheld.constants.Constants.PDF;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.mindheld.entity.Photo;

@Component("fileHandler")
public class FileHandler {

	private static final Log logger = LogFactory.getLog(FileHandler.class);

	public Photo stringBase64ToPhoto(String base64) {
		if (base64 == null || base64.isBlank())
			return null;
		var _return = new Photo();
		try {
			var photoName = UUID.randomUUID().toString();
			var outputPhoto = new File(PHOTOS_PATH + photoName + JPG);
			byte[] decodedBytes = Base64.getDecoder().decode(base64.split(",")[1]);
			FileUtils.writeByteArrayToFile(outputPhoto, decodedBytes);
			_return.setPath(PHOTOS_URL + photoName + JPG);
			logger.info("imaged created succesfully at " + _return.getPath());
		} catch (IOException e) {
			logger.error("Error saving imagefile from base64 string: \n" + e);
			e.printStackTrace();
		}
		return _return;
	}

	public void deleteImg(Photo photo) {
		if (photo != null) {
			var img = new File(photo.getPath().replace(PHOTOS_URL, PHOTOS_PATH));
			img.delete();
		}
	}
	
	public String stringBase64ToFile(String base64) {
		var _return = "";
		if (base64 == null || base64.isBlank())
			return _return;
		else if(base64.contains(SUPPORT_FILES_URL))
			return base64;
		try {
			var fileName = UUID.randomUUID().toString();
			var outputFile = new File(SUPPORT_FILES_PATH + fileName + PDF);
			byte[] decodedBytes = Base64.getDecoder().decode(base64);
			FileUtils.writeByteArrayToFile(outputFile, decodedBytes);
			_return = SUPPORT_FILES_URL + fileName + PDF;
			logger.info("file created succesfully at " + _return);
		} catch (IOException e) {
			logger.error("Error saving file from base64 string: \n" + e);
			e.printStackTrace();
		}
		return _return;
	}

	public static void main(String[] args) {

		String base64 = "";
		new FileHandler().stringBase64ToPhoto(base64);

	}
}
