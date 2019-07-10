package com.example.remote

interface RemoteMapper<in R, out E> {

    fun mapFromRemote(remote: R): E

}