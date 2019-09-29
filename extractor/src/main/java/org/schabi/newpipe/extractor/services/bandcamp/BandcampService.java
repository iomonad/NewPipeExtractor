package org.schabi.newpipe.extractor.services.bandcamp;

import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.SuggestionExtractor;
import org.schabi.newpipe.extractor.channel.ChannelExtractor;
import org.schabi.newpipe.extractor.comments.CommentsExtractor;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.kiosk.KioskExtractor;
import org.schabi.newpipe.extractor.kiosk.KioskList;
import org.schabi.newpipe.extractor.linkhandler.LinkHandler;
import org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;
import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandler;
import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.playlist.PlaylistExtractor;
import org.schabi.newpipe.extractor.search.SearchExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampChartsExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampSearchExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.handlers.BandcampChartsLinkHandlerFactory;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.subscription.SubscriptionExtractor;
import org.schabi.newpipe.extractor.utils.Localization;

import java.io.IOException;

import static java.util.Collections.singletonList;
import static org.schabi.newpipe.extractor.StreamingService.ServiceInfo.MediaCapability.AUDIO;

public class BandcampService extends StreamingService {

    public BandcampService(int id) {
        super(id, "Bandcamp", singletonList(AUDIO));
    }

    @Override
    public LinkHandlerFactory getStreamLHFactory() {
        return null;
    }

    @Override
    public ListLinkHandlerFactory getChannelLHFactory() {
        return null;
    }

    @Override
    public ListLinkHandlerFactory getPlaylistLHFactory() {
        return null;
    }

    @Override
    public SearchQueryHandlerFactory getSearchQHFactory() {
        return null;
    }

    @Override
    public ListLinkHandlerFactory getCommentsLHFactory() {
        return null;
    }

    @Override
    public SearchExtractor getSearchExtractor(SearchQueryHandler query, Localization localization) {
        return new BandcampSearchExtractor(this, query, localization);
    }

    @Override
    public SuggestionExtractor getSuggestionExtractor(Localization localization) {
        return null;
    }

    @Override
    public SubscriptionExtractor getSubscriptionExtractor() {
        return null;
    }

    @Override
    public KioskList getKioskList() throws ExtractionException {
        KioskList.KioskExtractorFactory chartFactory = new KioskList.KioskExtractorFactory() {
            @Override
            public KioskExtractor createNewKiosk(StreamingService streamingService,
                                                 String url,
                                                 String id,
                                                 Localization local)
                    throws ExtractionException {
                return new BandcampChartsExtractor(BandcampService.this,
                        new BandcampChartsLinkHandlerFactory().fromUrl(url), id, local);
            }
        };

        KioskList list = new KioskList(getServiceId());

        final BandcampChartsLinkHandlerFactory lh = new BandcampChartsLinkHandlerFactory();
        try {
            list.addKioskEntry(chartFactory, lh, "Top Charts");
            list.addKioskEntry(chartFactory, lh, "New Charts");
            list.setDefaultKiosk("Top Charts");
        } catch (Exception e) {
            throw new ExtractionException(e);
        }
        return list;
    }

    @Override
    public ChannelExtractor getChannelExtractor(ListLinkHandler linkHandler, Localization localization) throws ExtractionException {
        return null;
    }

    @Override
    public PlaylistExtractor getPlaylistExtractor(ListLinkHandler linkHandler, Localization localization) throws ExtractionException {
        return null;
    }

    @Override
    public StreamExtractor getStreamExtractor(LinkHandler linkHandler, Localization localization) throws ExtractionException {
        return null;
    }

    @Override
    public CommentsExtractor getCommentsExtractor(ListLinkHandler linkHandler, Localization localization) throws ExtractionException {
        return null;
    }
}
