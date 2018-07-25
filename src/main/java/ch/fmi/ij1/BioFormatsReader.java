package ch.fmi.ij1;

import java.io.IOException;

import org.scijava.ItemIO;
import org.scijava.command.Command;
import org.scijava.log.LogService;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;

import ij.ImagePlus;
import loci.formats.FormatException;
import loci.plugins.BF;

@Plugin(type = Command.class, headless = true, menuPath = "FMI>Read Image (Bio-Formats)")
public class BioFormatsReader implements Command {
	@Parameter
	private LogService log;

	@Parameter(label = "File path")
	private String path;

	@Parameter(type = ItemIO.OUTPUT)
	private ImagePlus imp;

	@Override
	public void run() {
		try {
			ImagePlus[] imps = BF.openImagePlus(path);
			if (imps == null) {
				log.warn("Image could not be read from " + path);
				return;
			}
			imp = imps[0];
		} catch (RuntimeException e) {
			log.error("Exception while reading with Bio-Formats", e);
		}
		catch (FormatException exc) {
			exc.printStackTrace();
		}
		catch (IOException exc) {
			exc.printStackTrace();
		}
	}
}
