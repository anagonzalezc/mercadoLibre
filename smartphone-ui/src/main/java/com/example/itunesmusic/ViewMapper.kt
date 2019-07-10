package com.example.itunesmusic

interface ViewMapper<in P, out V> {

    fun mapToView(presentation: P): V

}