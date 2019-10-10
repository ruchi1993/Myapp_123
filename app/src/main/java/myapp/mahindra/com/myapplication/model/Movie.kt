package myapp.mahindra.com.myapplication.model

class Movie {


        var name: String? = null
        var image: Int? = null
        var fav: String? = null

        constructor(name: String, image: Int,fav: String) {
            this.name = name
            this.image = image
            this.fav = fav
        }
}