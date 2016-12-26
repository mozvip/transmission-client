
package fr.mozvip.transmission.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "removed",
    "torrents"
})
public class Arguments {

    @JsonProperty("removed")
    private List<Object> removed = null;
    @JsonProperty("torrents")
    private List<Torrent> torrents = null;
    @JsonProperty("torrent-added")
    private Torrent torrentAdded = null;
    @JsonProperty("torrent-duplicate")
	private Torrent torrentDuplicate;

    @JsonProperty("removed")
    public List<Object> getRemoved() {
        return removed;
    }

    @JsonProperty("removed")
    public void setRemoved(List<Object> removed) {
        this.removed = removed;
    }

    @JsonProperty("torrents")
    public List<Torrent> getTorrents() {
        return torrents;
    }

    @JsonProperty("torrents")
    public void setTorrents(List<Torrent> torrents) {
        this.torrents = torrents;
    }

	public Torrent getTorrentAdded() {
		return torrentAdded;
	}

	public void setTorrentAdded(Torrent torrentAdded) {
		this.torrentAdded = torrentAdded;
	}

	public Torrent getTorrentDuplicate() {
		return torrentDuplicate;
	}

	public void setTorrentDuplicate(Torrent torrentDuplicate) {
		this.torrentDuplicate = torrentDuplicate;
	}

}
