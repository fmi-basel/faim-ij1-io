package ch.fmi.ij1;

import ij.IJ;
import ij.ImagePlus;

import org.scijava.ItemIO;
import org.scijava.command.Command;
import org.scijava.log.LogService;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;

@Plugin(type = Command.class, headless = true, menuPath = "FMI>Read Image (IJ1)")
public class IJReader implements Command {
	@Parameter
	private LogService log;

	@Parameter(label = "File path")
	private String path;

	@Parameter(type = ItemIO.OUTPUT)
	private ImagePlus imp;

	@Override
	public void run() {
		try {
			imp = IJ.openImage(path);
			if (imp == null) log.warn("Image could not be read from " + path);
		} catch (RuntimeException e) {
			log.error("Exception while reading with IJ", e);
		}
	}
}
