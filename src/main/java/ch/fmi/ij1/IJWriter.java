package ch.fmi.ij1;

import ij.ImagePlus;
import ij.io.FileSaver;

import org.scijava.ItemIO;
import org.scijava.command.Command;
import org.scijava.log.LogService;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;

@Plugin(type = Command.class, headless = true, menuPath = "FMI>Write TIFF Image (IJ1)")
public class IJWriter implements Command {
	@Parameter
	private LogService log;

	@Parameter(label = "Input image")
	private ImagePlus imp;

	@Parameter(label = "File path")
	private String path;

	@Parameter(type = ItemIO.OUTPUT)
	private boolean saved;

	@Override
	public void run() {
		/*
		try (ImageWriter writer = new ImageWriter()) {
			writer.changeOutputFile(path);
			writer.saveBytes(0, (byte[]) imp.getProcessor().getPixels());
		} catch (FormatException | IOException exc) {
			log.error(exc);
		}
		*/
		log.info("Saving image to " + path);
		saved = new FileSaver(imp).saveAsTiff(path);
	}
}
