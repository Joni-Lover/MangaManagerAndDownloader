package de.andreasgiemza.mangadownloader.sites.implementations.espa�ol;

import java.util.Arrays;

import de.andreasgiemza.mangadownloader.sites.Site;
import de.andreasgiemza.mangadownloader.sites.extend.MangaHere;

/**
 *
 * @author Andreas Giemza <andreas@giemza.net>
 */
public class MangaHereEspa�ol extends MangaHere implements Site {

	public MangaHereEspa�ol() {
		super("Manga Here (Espa�ol)", "http://es.mangahere.co", Arrays
				.asList("Espa�ol"), false);
	}
}
