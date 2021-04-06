package com.example.data.item.repository
import com.google.gson.annotations.SerializedName

data class InstallmentsRemote (
    @SerializedName("quantity") val quantity: Int?,
    @SerializedName("amount") val amount: Float?,
    @SerializedName("rate") val rate: Int?

)