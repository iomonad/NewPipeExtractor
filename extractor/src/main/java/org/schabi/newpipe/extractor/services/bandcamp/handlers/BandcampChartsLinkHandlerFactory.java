package org.schabi.newpipe.extractor.services.bandcamp.handlers;

import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;
import org.schabi.newpipe.extractor.utils.Parser;

import java.util.List;

public class BandcampChartsLinkHandlerFactory extends ListLinkHandlerFactory {

    private final String URL_PATTERN = "^https?://(www\\.|m\\.)?bandcamp.com/?g=all&s=(top|new)";

    @Override
    public String getUrl(String id, List<String> contentFilter, String sortFilter) {
        switch (id) {
            case "Top Charts": { return "https://bandcamp.com/?g=all&s=top"; }
            case "New Charts": { return "https://bandcamp.com/?g=all&s=new"; }
            default: { return "https://bandcamp.com/"; }
        }
    }

    @Override
    public String getId(String url) {
        /*
         * TODO: This should be fixed in the future
         */
        switch (url) {
            case "https://bandcamp.com/?g=all&s=top": { return "Top Charts"; }
            case "https://bandcamp.com/?g=all&s=new": { return "New Charts"; }
            default: { return "Top Charts"; }
        }
    }

    @Override
    public boolean onAcceptUrl(String url) {
        return Parser.isMatch(URL_PATTERN, url.toLowerCase());
    }
}
