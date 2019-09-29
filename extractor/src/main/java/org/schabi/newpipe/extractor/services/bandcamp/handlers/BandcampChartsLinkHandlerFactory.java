package org.schabi.newpipe.extractor.services.bandcamp.handlers;

import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;

import java.util.List;

public class BandcampChartsLinkHandlerFactory extends ListLinkHandlerFactory {

    @Override
    public String getUrl(String id, List<String> contentFilter, String sortFilter) throws ParsingException {
        switch (id) {
            case "Top Charts": { return "https://bandcamp.com/?g=all&s=top"; }
            case "New Charts": { return "https://bandcamp.com/?g=all&s=new"; }
            default: { return "https://bandcamp.com/"; }
        }
    }

    @Override
    public String getId(String url) throws ParsingException {
        return null;
    }

    @Override
    public boolean onAcceptUrl(String url) throws ParsingException {
        return false;
    }
}
