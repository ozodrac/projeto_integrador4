package br.com.shark.minify;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.shark.XML.Map;
import br.com.shark.XML.MapConfig;
import br.com.shark.util.Functions;

/**
 * This class aggregate files so instead of having several files, only one file
 * will be generated.
 * 
 * @author Luciano Sampaio
 * @version 1.0 .
 * 
 */
public abstract class Aggregator {
	/**
	 * The folder where the aggregated file will be saved.
	 */
	private static final String OUTPUT_FOLDER = "compressed/";
	/**
	 * The list of files that will be aggregated and added to the final file.
	 */
	protected List<AggregatorFile> listFiles = new ArrayList<AggregatorFile>();
	/**
	 * The object that handled localized br.com.AgendaEletronica.messages.
	 */
	protected ResourceBundle messages;
	protected Map mapconfig;

	/**
	 * This constructor accepts several files in just one call.
	 * 
	 * @param fileNames
	 *            The files that will be aggregated.
	 */
	public Aggregator(String... fileNames) {
		for (String fileName : fileNames) {
			add(fileName);
		}

		mapconfig = MapConfig.getInstance();

		// br.com.AgendaEletronica.messages =
		// ResourceBundle.getBundle("resourcesBundle/MessagesBundleAggregator",
		// AppConfig.getLocale());
	}

	/**
	 * Get the web path of a file on the server's hard drive, in other words,
	 * the path that a browser can access.
	 * 
	 * @return The web path of a file on the server's hard drive.
	 */
	protected String getContextPath() {
		return mapconfig.get("CONFIG-DIR_ROOT");
	}

	/**
	 * Get the real path of a file on the server's hard drive.
	 * 
	 * @return The real path of a file on the server's hard drive.
	 */
	protected String getRealPath() {
		return mapconfig.get("CONFIG-DIR_ROOT_REAL");
	}

	/**
	 * Get the default(true) value if the user doesn't supply with any.
	 * 
	 * @return true.
	 */
	protected boolean getDefaultToCompress() {
		return true;
	}

	/**
	 * @param fileNames
	 *            The files that will be aggregated.
	 * @return An instance of the class, so the methods can be chained.
	 */
	public Aggregator add(String fileName) {
		return add(fileName, getRealPath());
	}

	/**
	 * @param fileNames
	 *            The files that will be aggregated.
	 * @param filePath
	 *            The path of the file on the server.
	 * @return An instance of the class, so the methods can be chained.
	 */
	public Aggregator add(String fileName, String filePath) {
		return add(fileName, filePath, getDefaultToCompress());
	}

	/**
	 * @param fileNames
	 *            The files that will be aggregated.
	 * @param toCompress
	 *            If the file should be compressed or just aggregated with the
	 *            other.
	 * @return An instance of the class, so the methods can be chained.
	 */
	public Aggregator add(String fileName, boolean toCompress) {
		return add(fileName, getRealPath(), toCompress);
	}

	/**
	 * @param fileNames
	 *            The files that will be aggregated.
	 * @param filePath
	 *            The path of the file on the server.
	 * @param toCompress
	 *            If the file should be compressed or just aggregated with the
	 *            other.
	 * @return An instance of the class, so the methods can be chained.
	 */
	public Aggregator add(String fileName, String filePath, boolean toCompress) {
		// Check if the file exists.
		File file = new File(filePath + fileName);
		if (file.exists()) {
			listFiles.add(new AggregatorFile(fileName, filePath, toCompress,
					file.lastModified()));
		} else {
			String errorMessage = String.format(
					messages.getString("FILE_NOT_FOUND"), file.getName());
			throw new IllegalArgumentException(errorMessage);
		}

		return this;
	}

	/**
	 * Iterates over all the files and aggregated them together into just one
	 * file.
	 * 
	 * @return The html tag.
	 */
	public String run() {
		String aggregatedFilePathAndName = OUTPUT_FOLDER + getFinalFileName();

		String filePathOnServer = getRealPath() + aggregatedFilePathAndName;
		String filePathOnWeb = getContextPath() + aggregatedFilePathAndName;

		FileOutputStream output = null;
		try {
			File file = new File(filePathOnServer);
			// If the file already exists, we don't need to re-create it,
			// we just use it and safe time.
			if (!file.exists()) {
				output = new FileOutputStream(file);
				String lineSeparator = System.getProperty("line.separator");
				// Iterate over the list of files.
				for (AggregatorFile currentFile : listFiles) {
					File inputfile = new File(currentFile.getFilePath()
							+ currentFile.getFileName());

					// Check if the file should be compressed.
					if (currentFile.isToCompress()) {
						compress(inputfile, output);
					} else {
						notCompress(inputfile, output);
					}
					// To make sure there is at least one line between files to
					// avoid errors.
					output.write(lineSeparator.getBytes());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		// Clean the list for the next values(files).
		listFiles = new ArrayList<AggregatorFile>();

		// Generate the html tag.
		return getHTMLTag(filePathOnWeb);
	}

	/**
	 * Iterates over all the files, getting the names and the last time they
	 * were modified, based on these information, it generate a hash code which
	 * will be the name of the file.
	 * 
	 * @return The aggregated file name.
	 */
	protected String getFinalFileName() {
		StringBuilder sb = new StringBuilder();
		// Iterate over all the files that will be aggregated together.
		for (AggregatorFile AggregatedFile : listFiles) {
			String fileNameAndPath = AggregatedFile.getFilePath()
					+ AggregatedFile.getFileName();
			long lastModified = AggregatedFile.getlastModified();
			// If the file was modified, the final name will be different, so we
			// know we should
			// create a new one.
			sb.append(fileNameAndPath + lastModified);
		}

		// Hash the names of all the files and create the final file name with
		// the hash code of all the file's names.
		// The Math.abs is just to make sure only positive numbers will be
		// returned.
		return Integer.toString(Math.abs(sb.toString().hashCode()));
	}

	/**
	 * Compress the file and add it to the aggregated file.
	 * 
	 * @param inputfile
	 *            The original file that will be used as a source.
	 * @param output
	 *            The outputStream that will get the aggregated file.
	 */
	protected abstract void compress(File inputfile, FileOutputStream output);

	/**
	 * Just add the file to the aggregated file.
	 * 
	 * @param inputfile
	 *            The original file that will be used as a source.
	 * @param output
	 *            The outputStream that will get the aggregated file.
	 */
	protected void notCompress(File inputfile, FileOutputStream output) {
		try {
			String contentOfFile = Functions.readFileToString(inputfile);
			output.write(contentOfFile.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Generate the html tag and puts the file name and path so the browser can
	 * request it.
	 * 
	 * @param file
	 * @return The html tag.
	 */
	protected abstract String getHTMLTag(String file);

}