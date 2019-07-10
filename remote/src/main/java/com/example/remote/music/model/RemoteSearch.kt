package com.example.remote.music.model

import com.google.gson.annotations.SerializedName

class RemoteSearch(@SerializedName("results") val search: List<RemoteMusic>)