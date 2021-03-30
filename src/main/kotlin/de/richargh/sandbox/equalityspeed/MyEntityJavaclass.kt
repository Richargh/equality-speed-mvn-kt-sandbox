package de.richargh.sandbox.equalityspeed

import java.util.*

class MyEntityJavaclass(val id: Int, var name: String = "") {

    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        // way faster than !is
        if(this.javaClass != other?.javaClass) return false
        // required for the smart cast goodness
        return equals(other as MyEntityJavaclass)
    }

    fun equals(other: MyEntityJavaclass): Boolean {
        return other.id == id
    }

    // if you overwrite equals, always overwrite hashCode as well
    override fun hashCode(): Int {
        return Objects.hash(id)
    }
}