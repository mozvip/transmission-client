package com.github.mozvip.transmission;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransmissionRequestArguments {
	
	private String[] fields;
	private List<Long> ids;
	private String metainfo;
	private String filename;
	@JsonProperty("delete-local-data")
	private boolean deleteLocalData;

	public String[] getFields() {
		return fields;
	}
	public void setFields(String[] fields) {
		this.fields = fields;
	}
	public List<Long> getIds() {
		return ids;
	}
	public void setIds(List<Long> ids) {
		this.ids = ids;
	}
	public String getMetainfo() {
		return metainfo;
	}
	public void setMetainfo(String metainfo) {
		this.metainfo = metainfo;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public boolean isDeleteLocalData() {
		return deleteLocalData;
	}
	public void setDeleteLocalData(boolean deleteLocalData) {
		this.deleteLocalData = deleteLocalData;
	}

}
