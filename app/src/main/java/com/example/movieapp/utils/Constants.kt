package com.example.movieapp.utils

class Constants {

    companion object {
        const val TABLE_NAME = "BOOKMARK_TABLE"
        const val cast = "CAST"
        const val movie = "MOVIE"

        const val API_KEY = "4efac9f6367d7856761d7adc75499200"
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val ImageBaseURL = "https://image.tmdb.org/t/p/original"
        const val ImageBaseURLw780 = "https://image.tmdb.org/t/p/w780"
        const val ImageBaseURLw500 = "https://image.tmdb.org/t/p/w500"

        const val Popular = "Popular"
        const val TopRated = "TopRated"
        const val Bookmarks = "Bookmarks"

        fun getGenreMap(): HashMap<Int, String> {
            val genreMap = HashMap<Int, String>()
            genreMap[28] = "Action 🤠 "
            genreMap[12] = "Adventure 🏕 "
            genreMap[16] = "Animation 🎥 "
            genreMap[35] = "Comedy 🤣 "
            genreMap[80] = "Crime 👮‍♂️ "
            genreMap[99] = "Documentary 📃 "
            genreMap[18] = "Drama 😨 "
            genreMap[10751] = "Family 👪 "
            genreMap[14] = "Fantasy 🧙‍♂️ "
            genreMap[36] = "History 💾 "
            genreMap[27] = "Horror 👻 "
            genreMap[10402] = "Music 🎶 "
            genreMap[9648] = "Mystery 🕵️‍♀️ "
            genreMap[10749] = "Romance 💏"
            genreMap[878] = "Science Fiction 🚀 "
            genreMap[53] = "Thriller 🗡 "
            genreMap[10752] = "War ⚔ "
            genreMap[37] = "Western 🤵 "
            genreMap[10770] = "TV Movie 📺 "
            return genreMap
        }
    }

}