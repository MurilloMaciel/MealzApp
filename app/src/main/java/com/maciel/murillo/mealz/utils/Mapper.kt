package com.maciel.murillo.mealz.utils

interface Mapper<FROM, TO> {
    fun mapFrom(from: FROM): TO
}