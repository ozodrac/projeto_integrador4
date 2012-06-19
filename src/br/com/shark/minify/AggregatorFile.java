package br.com.shark.minify;

public class AggregatorFile {

	private String fileName;
	private String filePath;
	private boolean toCompress;
	private long lastModified;

	public AggregatorFile(String fileName, String filePath, boolean toCompress, long lastModified) {
		setFileName(fileName);
		setFilePath(filePath);
		setToCompress(toCompress);
		setlastModified(lastModified);
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public boolean isToCompress() {
		return toCompress;
	}

	public void setToCompress(boolean compress) {
		this.toCompress = compress;
	}

	public long getlastModified() {
		return lastModified;
	}

	public void setlastModified(long lastModified) {
		this.lastModified = lastModified;
	}
}