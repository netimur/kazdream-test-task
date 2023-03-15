package com.netimur.kazdream.data.model.embeddedcity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cities")
data class EmbeddedCity(
    @PrimaryKey val name: String
)
