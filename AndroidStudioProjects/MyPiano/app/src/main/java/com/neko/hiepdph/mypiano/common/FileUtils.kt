package com.neko.hiepdph.mypiano.common

import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import com.neko.hiepdph.mypiano.data.model.AudioFile

object FileUtils {

    fun getFileAudio(context: Context): MutableList<AudioFile> {
        val audioList = mutableListOf<AudioFile>()
        val contentResolver: ContentResolver = context.contentResolver
        val uri: Uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI

        val projection = arrayOf(
            MediaStore.Audio.Media.DATA,  // path to the file
            MediaStore.Audio.Media.TITLE,  // title of the file
            MediaStore.Audio.Media.DURATION  // title of the file
        )

        val cursor: Cursor? = contentResolver.query(
            uri, projection, null, null, null
        )

        cursor?.use {
            val dataIndex = it.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)
            val titleIndex = it.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)
            val duration = it.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION)

            while (it.moveToNext()) {
                val filePath = it.getString(dataIndex)
                val title = it.getString(titleIndex)
                val duration = it.getLong(duration)
                audioList.add(AudioFile(title, filePath, duration))
            }
        }

        return audioList
    }
}