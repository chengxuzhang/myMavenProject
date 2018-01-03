package com.qing.core.bean;

/**
 * @description 文件树基本信息
 *
 * @author 谢进伟
 *
 * @createDate 2016年2月11日 上午11:49:05
 */
public class TreeFile {
	
	/** 文件唯一标识 **/
	protected String uuid;
	/** 文件目录唯一标识 **/
	protected String dirUUID;
	/** 目录路径 **/
	protected String dirPath;
	/** 文件路径 **/
	protected String path;
	/** 是否是目录 **/
	protected boolean isDirectory;
	
	public TreeFile (String uuid , String dirUUID , String dirPath , String path , boolean isDirectory ){
		super();
		this.uuid = uuid;
		this.dirUUID = dirUUID;
		this.dirPath = dirPath;
		this.path = path;
		this.isDirectory = isDirectory;
	}
	
	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}
	
	/**
	 * @param uuid
	 *            the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	/**
	 * @return the dirUUID
	 */
	public String getDirUUID() {
		return dirUUID;
	}
	
	/**
	 * @param dirUUID
	 *            the dirUUID to set
	 */
	public void setDirUUID(String dirUUID) {
		this.dirUUID = dirUUID;
	}
	
	/**
	 * @return the dirPath
	 */
	public String getDirPath() {
		return dirPath;
	}
	
	/**
	 * @param dirPath
	 *            the dirPath to set
	 */
	public void setDirPath(String dirPath) {
		this.dirPath = dirPath;
	}
	
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	
	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	/**
	 * @return the isDirectory
	 */
	public boolean isDirectory() {
		return isDirectory;
	}
	
	/**
	 * @param isDirectory
	 *            the isDirectory to set
	 */
	public void setDirectory(boolean isDirectory) {
		this.isDirectory = isDirectory;
	}
}
