package com.rvery.data.datasource.remote.model

import com.fasterxml.jackson.annotation.JsonProperty



data class PictureOfCatData(
    @JsonProperty("created_at") val createdAt: String? = null,
    @JsonProperty("height") val height: Int? = null,
    @JsonProperty("id") val id: String? = null,
    @JsonProperty("original_filename") val originalFilename: String? = null,
    @JsonProperty("sub_id") val subId: String? = null,
    @JsonProperty("url") val url: String? = null,
    @JsonProperty("width") val width: Int? = null
)