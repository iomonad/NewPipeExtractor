package org.schabi.newpipe.extractor.services.bandcamp.extractors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.exceptions.ReCaptchaException;
import org.schabi.newpipe.extractor.stream.StreamInfoItemsCollector;

import java.io.IOException;

import javax.annotation.Nonnull;

public class BandcampParsingHelpers {

    @Nonnull
    public static String getStreamsFromUrl(StreamInfoItemsCollector collector,
                                           String url) throws ReCaptchaException, IOException, ParsingException {
        String page = NewPipe.getDownloader().download(url);
        Document document;

        try { document = Jsoup.parse(page); } catch (Exception e) {
            throw new ParsingException("Cannot parse HTML body", e);
        }
        for (final Element li: document.children()) {
            collector.commit(new BandcampStreamInfoItemExtractor(li));
        }
        return ""; // NEXT URL
    }
}