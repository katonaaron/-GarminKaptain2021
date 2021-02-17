package com.garmin.garminkaptain.data

data class PointOfInterest(
    val id: Long,
    val mapLocation: MapLocation,
    val name: String,
    val poiType: String,
    val reviews: List<Review>
) {
    val reviewSummary: ReviewSummary = ReviewSummary(
        reviews.map { it.rating }.average().takeIf { !it.isNaN() } ?: 0.0,
        reviews.size
    )
}

data class MapLocation(
    val latitude: Double,
    val longitude: Double
)

data class ReviewSummary(
    val averageRating: Double,
    val numberOfReviews: Int
)

data class Review(
    val id: Long,
    val rating: Double,
    val author: String,
    val title: String,
    val text: String,
    val dateCreated: Long
)

val poiList: List<PointOfInterest> = listOf(
    PointOfInterest(
        46067,
        MapLocation(37.8180564724432, -122.52704143524173),
        "Point Bonita",
        "Anchorage",
        listOf(
            Review(
                123,
                3.0,
                "John Cena",
                "Too frequently advertised",
                "This place appeared in a lot of commercials. Nice view but nothing special",
                1613511400
            )
        )
    ),
    PointOfInterest(
        12975,
        MapLocation(37.8770892291283, -122.503309249878),
        "Richardson Bay Marina",
        "Marina",
        listOf(
            Review(
                23423,
                5.0,
                "Va Ngog",
                "Good place",
                "Absolutely a hidden gem, a private neighborhood. Amazing view!!!",
                1613411400
            )
        )
    ),
    PointOfInterest(
        46085,
        MapLocation(37.82878469060811, -122.47633210712522),
        "Needles",
        "Anchorage",
        listOf(
            Review(
                223,
                1.0,
                "Ba Tman",
                "Nothing to see here",
                "Literally nothing",
                1612411400
            ),
            Review(
                223,
                1.0,
                "John John",
                "Don't come here",
                "-",
                1612401400
            )
        )
    ),
    PointOfInterest(
        19637,
        MapLocation(37.82077, -122.4786),
        "Golden Gate Bridge",
        "Bridge",
        listOf()
    ),
    PointOfInterest(
        60928,
        MapLocation(37.8325155338083, -122.47500389814363),
        "Horseshoe Cove",
        "Anchorage",
        listOf(
            Review(
                5223,
                5.0,
                "I Ronman",
                "My favourite place",
                "Come, visit it",
                1600411400
            ),
            Review(
                2235,
                4.0,
                "Cap Tainmerica",
                "I know a better place",
                "Its next to the opera house",
                1612401400
            )
        )
    ),
    PointOfInterest(
        39252,
        MapLocation(37.833886767314, -122.475371360779),
        "Presidio Yacht Club",
        "Marina",
        listOf(
            Review(
                22311,
                4.0,
                "Jack Johnson",
                "My favourite",
                "One of the coolest bars on the North Bay shore...! I will be going back very shortly",
                1602411400
            ),
            Review(
                22113,
                5.0,
                "Bit Bat Bet",
                "A place that must be visited",
                "What a cool historic building!  I was directed to go to the yacht club where I could grab a freshly made hamburger and enjoy one of the best views of the Golden Gate Bridge available!  They were right about both.  The food was delicious and the young lady who served me was about as nice as they come.  then there's a panoramic view of the Golden Gate Bridge right from the dining room.  If you're not with kids this would be the place to go to check out the bridge.",
                1512401400
            ),
            Review(
                2212113,
                1.0,
                "Bucket Boy",
                "Me no have boat",
                ":(",
                1512499400
            ),
            Review(
                2112113,
                2.0,
                "Wolfee",
                "Did not like it",
                "Didn't go inside, but surrounding area is fairly deserted and windy.",
                1512599400
            ),
            Review(
                312113,
                3.0,
                "Pablo Picasso",
                "Relaxed dock bar with live music and marine motives",
                "Recommend for music and marine lovers",
                1592411400
            )
        )
    ),
    PointOfInterest(
        25644,
        MapLocation(37.8673327691044, -122.435932159424),
        "Ayala Cove",
        "Anchorage",
        listOf()
//        ReviewSummary(4.7, 18)
    ),
    PointOfInterest(
        61865,
        MapLocation(37.850002964208095, -122.41632213957898),
        "Tide Rips",
        "Hazard",
        listOf()
    ),
    PointOfInterest(
        46713,
        MapLocation(37.827799573006274, -122.42648773017541),
        "Dangerous Rock",
        "Hazard",
        listOf()
    ),
    PointOfInterest(
        57109,
        MapLocation(37.87572310328571, -122.50570595169079),
        "Woodrum Marine Boat Repair/Carpentry",
        "Business",
        listOf()
    )
)

