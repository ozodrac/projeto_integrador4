package br.com.shark.minify;

import java.io.File;
import java.io.FileOutputStream;

import br.com.shark.minify.CSSMin;

public class CssAggregator extends Aggregator {

	private static final String FILE_EXTENSION = ".css";

	public CssAggregator(String... fileNames) {
		super(fileNames);
	}

	@Override
	protected String getContextPath() {
		return mapconfig.get("CONFIG-DIR_ROOT", "CONFIG-DIR_CSS") + "/";
	}

	@Override
	protected String getRealPath() {
		return mapconfig.get("CONFIG-DIR_ROOT_REAL", "CONFIG-DIR_CSS") + "/";
	}

	@Override
	protected String getFinalFileName() {
		return super.getFinalFileName() + FILE_EXTENSION;
	}

	@Override
	protected void compress(File inputfile, FileOutputStream output) {
		try {
			CSSMin.run(inputfile, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected String getHTMLTag(String file) {
		return "<link rel=\"stylesheet\" type=\"text/css\" href=\"" + file
				+ "\" />";
	}

}