package com.neko.hiepdph.mypiano.common

import android.content.Context
import com.neko.hiepdph.mypiano.data.model.AutoPlayEntity
import com.neko.hiepdph.mypiano.data.model.Piano

object AutoPlaySong {
    private var starList: MutableList<AutoPlayEntity> = mutableListOf()
    private const val BREAK_SHORT_TIME = 500L
    private const val BREAK_LONG_TIME = 1000L

    fun getLitterStarNote(context: Context): MutableList<AutoPlayEntity> {
        starList = mutableListOf()
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                0,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                1,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                1,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                0,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )
        return starList
    }

    fun getAllOfMeNote(context: Context): MutableList<AutoPlayEntity> {
        starList = mutableListOf()
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                0,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                4,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                0,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                4,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )
        return starList
    }

    fun getHPBDSong(context: Context): MutableList<AutoPlayEntity> {
        starList = mutableListOf()
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                3,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                6,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                3,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )
        return starList
    }

    fun getJingleBellSong(context: Context): MutableList<AutoPlayEntity> {
        starList = mutableListOf<AutoPlayEntity>()
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                4,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )
        return starList
    }

    fun getBee5thSymSong(context: Context): MutableList<AutoPlayEntity> {
        starList = mutableListOf()
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                1,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                1,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                1,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                1,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )
        return starList
    }

    fun getCallMeMaybeSong(context: Context): MutableList<AutoPlayEntity> {
        starList = mutableListOf()
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )
        return starList
    }

    fun getKissTheRainSong(context: Context): MutableList<AutoPlayEntity> {
        starList = mutableListOf()
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                6,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                6,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                6,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                6,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                6,
                2,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                6,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                6,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                6,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                6,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                6,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                6,
                4,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                6,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                6,
                0,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                6,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                6,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                6,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                6,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                6,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )
        return starList
    }
    fun getLastChristmasSong(context: Context): MutableList<AutoPlayEntity> {
        starList= mutableListOf()
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.BLACK,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )
        return starList
    }

    fun getLetItGoSong(context: Context): MutableList<AutoPlayEntity> {
        starList = mutableListOf()
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                5,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                1,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                5,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                6,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                4,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )

        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                0,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                3,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                2,
                (BREAK_SHORT_TIME / (context.config.speed / 100f)).toLong()
            )
        )
        starList.add(
            AutoPlayEntity(
                Piano.PianoKeyType.WHITE,
                4,
                0,
                (BREAK_LONG_TIME /(context.config.speed / 100f)).toLong()
            )
        )
        return starList
    }
}