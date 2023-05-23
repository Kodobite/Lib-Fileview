package io.kodebite.fileviewer.pdfView.link;

import io.kodebite.fileviewer.pdfView.model.LinkTapEvent;

public interface LinkHandler {

    /**
     * Called when link was tapped by user
     *
     * @param event current event
     */
    void handleLinkEvent(LinkTapEvent event);
}
