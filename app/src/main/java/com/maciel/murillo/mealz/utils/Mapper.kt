package com.maciel.murillo.mealz.utils

interface Mapper<FROM, TO> {
    operator fun invoke(from: FROM): TO
}