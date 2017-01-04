
package com.github.mozvip.transmission.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Torrent {

	public static final int STOPPED = 4;

	@JsonProperty
	private long downloadedEver;
	@JsonProperty("hashString")
	private String hashString;
	@JsonProperty("doneDate")
	private long doneDate;
	@JsonProperty("downloadDir")
	private String downloadDir;
	@JsonProperty("error")
	private Integer error;
	@JsonProperty("errorString")
	private String errorString;
	@JsonProperty("eta")
	private Integer eta;
	@JsonProperty("id")
	private long id;
	@JsonProperty("isFinished")
	private Boolean isFinished;
	@JsonProperty("isStalled")
	private Boolean isStalled;
	@JsonProperty("leftUntilDone")
	private Integer leftUntilDone;
	@JsonProperty("metadataPercentComplete")
	private Integer metadataPercentComplete;
	@JsonProperty("peersConnected")
	private Integer peersConnected;
	@JsonProperty("peersGettingFromUs")
	private Integer peersGettingFromUs;
	@JsonProperty("peersSendingToUs")
	private Integer peersSendingToUs;
	@JsonProperty("percentDone")
	private Double percentDone;
	@JsonProperty("queuePosition")
	private Integer queuePosition;
	@JsonProperty("rateDownload")
	private Integer rateDownload;
	@JsonProperty("rateUpload")
	private Integer rateUpload;
	@JsonProperty("recheckProgress")
	private Integer recheckProgress;
	@JsonProperty("seedRatioLimit")
	private Integer seedRatioLimit;
	@JsonProperty("seedRatioMode")
	private Integer seedRatioMode;
	@JsonProperty("sizeWhenDone")
	private Integer sizeWhenDone;
	@JsonProperty("status")
	private int status;
	@JsonProperty("trackers")
	private List<Tracker> trackers = null;
	@JsonProperty("uploadRatio")
	private Double uploadRatio;
	@JsonProperty("uploadedEver")
	private Integer uploadedEver;
	@JsonProperty("webseedsSendingToUs")
	private Integer webseedsSendingToUs;
	@JsonProperty("name")
	private String name;

	private List<TorrentFile> files;

	public long getDownloadedEver() {
		return downloadedEver;
	}

	public void setDownloadedEver(long downloadedEver) {
		this.downloadedEver = downloadedEver;
	}

	public long getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(long doneDate) {
		this.doneDate = doneDate;
	}

	public List<TorrentFile> getFiles() {
		return files;
	}

	public void setFiles(List<TorrentFile> files) {
		this.files = files;
	}

	@JsonProperty("downloadDir")
	public String getDownloadDir() {
		return downloadDir;
	}

	@JsonProperty("downloadDir")
	public void setDownloadDir(String downloadDir) {
		this.downloadDir = downloadDir;
	}

	@JsonProperty("error")
	public Integer getError() {
		return error;
	}

	@JsonProperty("error")
	public void setError(Integer error) {
		this.error = error;
	}

	public String getHashString() {
		return hashString;
	}

	public void setHashString(String hashString) {
		this.hashString = hashString;
	}

	@JsonProperty("errorString")
	public String getErrorString() {
		return errorString;
	}

	@JsonProperty("errorString")
	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}

	@JsonProperty("eta")
	public Integer getEta() {
		return eta;
	}

	@JsonProperty("eta")
	public void setEta(Integer eta) {
		this.eta = eta;
	}

	@JsonProperty("id")
	public long getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(long id) {
		this.id = id;
	}

	@JsonProperty("isFinished")
	public Boolean getIsFinished() {
		return isFinished;
	}

	@JsonProperty("isFinished")
	public void setIsFinished(Boolean isFinished) {
		this.isFinished = isFinished;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("isStalled")
	public Boolean getIsStalled() {
		return isStalled;
	}

	@JsonProperty("isStalled")
	public void setIsStalled(Boolean isStalled) {
		this.isStalled = isStalled;
	}

	@JsonProperty("leftUntilDone")
	public Integer getLeftUntilDone() {
		return leftUntilDone;
	}

	@JsonProperty("leftUntilDone")
	public void setLeftUntilDone(Integer leftUntilDone) {
		this.leftUntilDone = leftUntilDone;
	}

	@JsonProperty("metadataPercentComplete")
	public Integer getMetadataPercentComplete() {
		return metadataPercentComplete;
	}

	@JsonProperty("metadataPercentComplete")
	public void setMetadataPercentComplete(Integer metadataPercentComplete) {
		this.metadataPercentComplete = metadataPercentComplete;
	}

	@JsonProperty("peersConnected")
	public Integer getPeersConnected() {
		return peersConnected;
	}

	@JsonProperty("peersConnected")
	public void setPeersConnected(Integer peersConnected) {
		this.peersConnected = peersConnected;
	}

	@JsonProperty("peersGettingFromUs")
	public Integer getPeersGettingFromUs() {
		return peersGettingFromUs;
	}

	@JsonProperty("peersGettingFromUs")
	public void setPeersGettingFromUs(Integer peersGettingFromUs) {
		this.peersGettingFromUs = peersGettingFromUs;
	}

	@JsonProperty("peersSendingToUs")
	public Integer getPeersSendingToUs() {
		return peersSendingToUs;
	}

	@JsonProperty("peersSendingToUs")
	public void setPeersSendingToUs(Integer peersSendingToUs) {
		this.peersSendingToUs = peersSendingToUs;
	}

	@JsonProperty("percentDone")
	public Double getPercentDone() {
		return percentDone;
	}

	@JsonProperty("percentDone")
	public void setPercentDone(Double percentDone) {
		this.percentDone = percentDone;
	}

	@JsonProperty("queuePosition")
	public Integer getQueuePosition() {
		return queuePosition;
	}

	@JsonProperty("queuePosition")
	public void setQueuePosition(Integer queuePosition) {
		this.queuePosition = queuePosition;
	}

	@JsonProperty("rateDownload")
	public Integer getRateDownload() {
		return rateDownload;
	}

	@JsonProperty("rateDownload")
	public void setRateDownload(Integer rateDownload) {
		this.rateDownload = rateDownload;
	}

	@JsonProperty("rateUpload")
	public Integer getRateUpload() {
		return rateUpload;
	}

	@JsonProperty("rateUpload")
	public void setRateUpload(Integer rateUpload) {
		this.rateUpload = rateUpload;
	}

	@JsonProperty("recheckProgress")
	public Integer getRecheckProgress() {
		return recheckProgress;
	}

	@JsonProperty("recheckProgress")
	public void setRecheckProgress(Integer recheckProgress) {
		this.recheckProgress = recheckProgress;
	}

	@JsonProperty("seedRatioLimit")
	public Integer getSeedRatioLimit() {
		return seedRatioLimit;
	}

	@JsonProperty("seedRatioLimit")
	public void setSeedRatioLimit(Integer seedRatioLimit) {
		this.seedRatioLimit = seedRatioLimit;
	}

	@JsonProperty("seedRatioMode")
	public Integer getSeedRatioMode() {
		return seedRatioMode;
	}

	@JsonProperty("seedRatioMode")
	public void setSeedRatioMode(Integer seedRatioMode) {
		this.seedRatioMode = seedRatioMode;
	}

	@JsonProperty("sizeWhenDone")
	public Integer getSizeWhenDone() {
		return sizeWhenDone;
	}

	@JsonProperty("sizeWhenDone")
	public void setSizeWhenDone(Integer sizeWhenDone) {
		this.sizeWhenDone = sizeWhenDone;
	}

	@JsonProperty("status")
	public int getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(int status) {
		this.status = status;
	}

	@JsonProperty("trackers")
	public List<Tracker> getTrackers() {
		return trackers;
	}

	@JsonProperty("trackers")
	public void setTrackers(List<Tracker> trackers) {
		this.trackers = trackers;
	}

	@JsonProperty("uploadRatio")
	public Double getUploadRatio() {
		return uploadRatio;
	}

	@JsonProperty("uploadRatio")
	public void setUploadRatio(Double uploadRatio) {
		this.uploadRatio = uploadRatio;
	}

	@JsonProperty("uploadedEver")
	public Integer getUploadedEver() {
		return uploadedEver;
	}

	@JsonProperty("uploadedEver")
	public void setUploadedEver(Integer uploadedEver) {
		this.uploadedEver = uploadedEver;
	}

	@JsonProperty("webseedsSendingToUs")
	public Integer getWebseedsSendingToUs() {
		return webseedsSendingToUs;
	}

	@JsonProperty("webseedsSendingToUs")
	public void setWebseedsSendingToUs(Integer webseedsSendingToUs) {
		this.webseedsSendingToUs = webseedsSendingToUs;
	}

}
