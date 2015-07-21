/*
 * Copyright (c) 2013. Jive Software
 *  
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *  
 *       http://www.apache.org/licenses/LICENSE-2.0
 *  
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 */

package com.jivesoftware.sdk.definition.api.tile.style;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 */
public class TileData<T extends TileContentItem> {
	/*
	{
		data: {
			"title":"Open Todos",
			"contents":[
				{"text":"1"},
				{"text":"2"},
				{"text":"3"}
			],
			"config":{
				"listStyle":"contentList"
			}
		}
	}
	*/
	private String title;
	private List<T> contents = new ArrayList<T>();
	private TileAction action = new TileAction();
	private String displayName;
	private String description;
	private String style;
	private Map<String, String> icons = new HashMap<String, String>();
	private Map<String, String> config = new HashMap<String, String>();

	public TileData(TileStyle style) {
		this.style = style.name();

	}
	public TileData(String style) {
		this.style = style;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<T> getContents() {
		return contents;
	}

	public void setContents(List<T> contents) {
		this.contents = contents;
	}

	public TileAction getAction() {
		return action;
	}

	public void setAction(TileAction action) {
		this.action = action;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Map<String, String> getIcons() {
		return icons;
	}

	public void setIcons(Map<String, String> icons) {
		this.icons = icons;
	}


	public Map<String, String> getConfig() {
		return config;
	}

	public void setConfig(Map<String, String> config) {
		this.config = config;
	}
}

