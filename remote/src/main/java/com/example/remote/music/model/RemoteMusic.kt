package com.example.remote.music.model

import com.google.gson.annotations.SerializedName

class RemoteMusic (@SerializedName("artistId") val artistId: String,
                   @SerializedName("artistName") val artistName: String,
                   @SerializedName("collectionName") val collectionName: String,
                   @SerializedName("trackName") val trackName: String,
                   @SerializedName("artworkUrl60") val photo: String,
                    @SerializedName( "previewUrl") val urlMusic:String)
