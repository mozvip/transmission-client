
package fr.mozvip.transmission.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "announce",
    "id",
    "scrape",
    "tier"
})
public class Tracker {

    @JsonProperty("announce")
    private String announce;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("scrape")
    private String scrape;
    @JsonProperty("tier")
    private Integer tier;

    @JsonProperty("announce")
    public String getAnnounce() {
        return announce;
    }

    @JsonProperty("announce")
    public void setAnnounce(String announce) {
        this.announce = announce;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("scrape")
    public String getScrape() {
        return scrape;
    }

    @JsonProperty("scrape")
    public void setScrape(String scrape) {
        this.scrape = scrape;
    }

    @JsonProperty("tier")
    public Integer getTier() {
        return tier;
    }

    @JsonProperty("tier")
    public void setTier(Integer tier) {
        this.tier = tier;
    }

}
