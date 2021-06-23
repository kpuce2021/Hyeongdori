package com.kpu.domain;

public class UserVO {
	String PictureContent;
	String PictureDate;
	String PictureId;
	String PictureUrl;
	
	public String getPictureContent() {
		return PictureContent;
	}

	public void setPictureContent(String pictureContent) {
		PictureContent = pictureContent;
	}

	public String getPictureDate() {
		return PictureDate;
	}

	public void setPictureDate(String pictureDate) {
		PictureDate = pictureDate;
	}

	public String getPictureId() {
		return PictureId;
	}

	public void setPictureId(String pictureId) {
		PictureId = pictureId;
	}

	public String getPictureUrl() {
		return PictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		PictureUrl = pictureUrl;
	}

	public String toString() {
		return "["+PictureContent+"]"+", "+"["+PictureDate+"]"+"["+PictureId+"]"+"["+PictureUrl+"]";
	}
}
