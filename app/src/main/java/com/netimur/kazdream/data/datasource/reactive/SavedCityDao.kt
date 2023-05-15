package com.netimur.kazdream.data.datasource.reactive

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.netimur.kazdream.data.model.embeddedcity.EmbeddedCity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class SavedCityDao {
    @Query("SELECT * FROM cities ORDER BY name ASC")
    abstract fun getCities(): Flow<List<String>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun addCity(city: EmbeddedCity)
}