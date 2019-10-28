package org.schabi.newpipe.extractor.services.bandcamp.extractors;

import org.schabi.newpipe.extractor.Downloader;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.kiosk.KioskExtractor;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.stream.StreamInfoItem;
import org.schabi.newpipe.extractor.stream.StreamInfoItemsCollector;
import org.schabi.newpipe.extractor.utils.Localization;

import java.io.IOException;

import javax.annotation.Nonnull;

public class BandcampChartsExtractor extends KioskExtractor<StreamInfoItem> {

    private StreamInfoItemsCollector collector = null;
    private String nextPageUrl = null;

    public BandcampChartsExtractor(StreamingService service,
                                   ListLinkHandler linkHandler,
                                   String id,
                                   Localization local) {
        super(service, linkHandler, id, local);
    }

    @Override
    public void onFetchPage(@Nonnull Downloader downloader) { }

    @Nonnull
    @Override
    public String getName() { return getId(); }

    @Nonnull
    @Override
    public InfoItemsPage<StreamInfoItem> getInitialPage() throws IOException, ExtractionException {
        return null;
    }

    @Override
    public String getNextPageUrl() throws IOException, ExtractionException {
        return null;
    }

    @Override
    public InfoItemsPage<StreamInfoItem> getPage(String pageUrl) throws IOException, ExtractionException {
        if (pageUrl == null || pageUrl.isEmpty()) {
            throw new ExtractionException(new IllegalArgumentException("Page url is null or empty"));
        }

        StreamInfoItemsCollector collector = new StreamInfoItemsCollector(getServiceId());
        String nextpage = BandcampParsingHelpers.getStreamsFromUrl(collector, pageUrl);
        return new InfoItemsPage<>(collector, nextpage);
    }
}
