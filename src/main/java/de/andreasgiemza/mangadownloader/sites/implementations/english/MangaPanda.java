package de.andreasgiemza.mangadownloader.sites.implementations.english;

import de.andreasgiemza.mangadownloader.sites.Site;
import de.andreasgiemza.mangadownloader.sites.extend.MangaPandaAndReader;
import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Andreas Giemza <andreas@giemza.net>
 */
public class MangaPanda extends MangaPandaAndReader implements Site, Serializable {

    public MangaPanda() {
        super("Manga Panda", "http://www.mangapanda.com", Arrays
                .asList("English"), true);
    }
}
