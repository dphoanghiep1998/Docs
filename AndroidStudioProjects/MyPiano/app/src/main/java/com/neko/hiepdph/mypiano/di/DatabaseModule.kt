package com.neko.hiepdph.mypiano.di


import android.content.Context
import androidx.room.Room
import com.neko.hiepdph.mypiano.common.Constant
import com.neko.hiepdph.mypiano.data.db.AppDatabase
import com.neko.hiepdph.mypiano.data.db.dao.KeyRecordDao
import com.neko.hiepdph.mypiano.data.db.dao.MicRecordDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {

        return Room.databaseBuilder(context, AppDatabase::class.java, Constant.APP_DB)
            .fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideMicRecordDao(appDatabase: AppDatabase): MicRecordDao {
        return appDatabase.micRecordDao
    }

    @Provides
    fun provideKeyRecordDao(appDatabase: AppDatabase): KeyRecordDao {
        return appDatabase.keyRecordDao
    }


}