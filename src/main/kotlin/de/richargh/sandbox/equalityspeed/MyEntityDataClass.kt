package de.richargh.sandbox.equalityspeed

data class MyEntityDataClass(val id: Int) {
    // we cannot put this into the constructor because then the value would be used for equality comparison
    // data classes are really not made for Entities but they'll do for this example
    var name: String = ""
}