package com.example.mercado

interface ViewMapper<P, V> {


    fun mapFromView(view: V) : P

    fun mapToView(presentation: P): V

}