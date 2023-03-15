package com.netimur.kazdream.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.netimur.kazdream.data.model.embeddedcity.EmbeddedCity

@Dao
interface EmbeddedCityDao {
    @Query("SELECT * FROM cities ORDER BY name ASC")
    fun getCities(): List<EmbeddedCity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCity(city: EmbeddedCity)
}