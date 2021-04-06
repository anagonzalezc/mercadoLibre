package com.example.remote.item.model

import com.google.gson.annotations.SerializedName

class RemoteItem (@SerializedName("id") val id: String,
                  @SerializedName("title") val title: String,
                  @SerializedName("price") val price: Float,
                  @SerializedName("condition") val condition: String,
                  @SerializedName("thumbnail") val thumbnail: String,
                  @SerializedName( "permalink") val permalink:String,
                  @SerializedName( "available_quantity") val available_quantity:String,
                  @SerializedName( "installments") val installments:InstallmentsRemote?,
                  @SerializedName( "interest") val insterest:String)



