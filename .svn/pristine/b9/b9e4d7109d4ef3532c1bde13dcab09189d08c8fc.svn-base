package br.com.shark.minify;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import br.com.shark.minify.JSMin;

public class JsAggregator extends Aggregator {

	private static final String FILE_EXTENSION = ".js";

	public JsAggregator(String... fileNames) {
		super(fileNames);
	}

	@Override
	protected String getContextPath() {
		return mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_JQUERY") + "/";
	}

	@Override
	protected String getRealPath() {
		return mapconfig.get("CONFIG-DIR_ROOT_REAL", "CONFIG-DIR_JQUERY") + "/";
	}

	@Override
	protected String getFinalFileName() {
		return super.getFinalFileName() + FILE_EXTENSION;
	}

	@Override
	protected void compress(File inputfile, FileOutputStream output) {
		try {
			JSMin jsmin = new JSMin(new FileInputStream(inputfile), output);
			jsmin.jsmin();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected String getHTMLTag(String file) {
		return "<script type=\"text/javascript\" language=\"JavaScript\" src=\"" + file
				+ "\" charset=\"" + mapconfig.get("CONFIG-SYS_CHARSET") + "\"></script>";
	}

}