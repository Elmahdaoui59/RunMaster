package com.running.run.location

import android.location.Location
import com.running.core.domain.location.LocationWithAltitude


fun Location.toLocationWithAltitude(): LocationWithAltitude {
    return LocationWithAltitude(
        location = com.running.core.domain.location.Location(
            lat = latitude,
            long = longitude
        ),
        altitude = altitude
    )
}