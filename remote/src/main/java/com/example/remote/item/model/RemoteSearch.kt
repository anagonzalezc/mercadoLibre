package com.example.remote.item.model

import com.google.gson.annotations.SerializedName

class RemoteSearch(@SerializedName("results") val searches: List<RemoteItem>)