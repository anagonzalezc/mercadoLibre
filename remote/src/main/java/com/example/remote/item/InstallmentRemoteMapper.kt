package com.example.remote.item

import com.example.data.item.model.InstallmentsEntity
import com.example.remote.RemoteMapper
import com.example.remote.item.model.InstallmentsRemote
import javax.inject.Inject

class InstallmentRemoteMapper @Inject constructor() :
    RemoteMapper<InstallmentsRemote, InstallmentsEntity> {
    override fun mapFromRemote(remote: InstallmentsRemote): InstallmentsEntity {
        return InstallmentsEntity(
            remote.quantity,
            remote.amount,
            remote.rate
        )
    }
}
