package de.andreasgiemza.mangadownloader.sites.implementations.espa�olenglishscanlationgroups;

import de.andreasgiemza.mangadownloader.sites.Site;
import de.andreasgiemza.mangadownloader.sites.extend.FoOlSlide;
import java.util.Arrays;

/**
 *
 * @author Andreas Giemza <andreas@giemza.net>
 */
public class Caf�ConLenin extends FoOlSlide implements Site {

	public Caf�ConLenin() {
		super("Caf� con Lenin", "http://cafeconlenin.com", Arrays.asList(
				"Espa�ol", "English"), false, "http://reader.cafeconlenin.com",
				"/directory/");
	}
}
