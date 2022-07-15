package com.sist.dao;
/*
 *   MNO                                                NUMBER
 CNO                                                NUMBER
 TITLE                                              VARCHAR2(500)
 SINGER                                             VARCHAR2(500)
 ALBUM                                              VARCHAR2(500)
 POSTER                                             VARCHAR2(260)
 IDCREMENT                                          NUMBER
 STATE                                              VARCHAR2(20)
 */
public class MusicVO {
    private int mno,cno,idcrement;
    private String title,singer,album,state,poster;
    
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getIdcrement() {
		return idcrement;
	}
	public void setIdcrement(int idcrement) {
		this.idcrement = idcrement;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
   
}
