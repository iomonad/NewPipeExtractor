package org.schabi.newpipe.extractor.services.bandcamp.extractors;

import org.schabi.newpipe.extractor.Downloader;
import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandler;
import org.schabi.newpipe.extractor.search.SearchExtractor;
import org.schabi.newpipe.extractor.utils.Localization;

import java.io.IOException;

import javax.annotation.Nonnull;

public class BandcampSearchExtractor extends SearchExtractor {

    public BandcampSearchExtractor(StreamingService service, SearchQueryHandler linkHandler, Localization localization) {
        super(service, linkHandler, localization);
    }

    @Override
    public String getSearchSuggestion() throws ParsingException {
        return null;
    }

    @Nonnull
    @Override
    public InfoItemsPage<InfoItem> getInitialPage() throws IOException, ExtractionException {
        return null;
    }

    @Override
    public String getNextPageUrl() throws IOException, ExtractionException {
        return null;
    }

    @Override
    public InfoItemsPage<InfoItem> getPage(String pageUrl) throws IOException, ExtractionException {
        return null;
    }

    @Override
    public void onFetchPage(@Nonnull Downloader downloader) throws IOException, ExtractionException {

    }
}
