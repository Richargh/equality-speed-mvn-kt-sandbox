package de.richargh.sandbox.equalityspeed

import java.util.*

class MyEntityInstanceOf(val id: Int, var name: String = "") {

    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if(other !is MyEntityInstanceOf) return false

        return equals(other)
    }

    fun equals(other: MyEntityInstanceOf): Boolean {
        return other.id == id
    }

    // if you overwrite equals, always overwrite hashCode as well
    override fun hashCode(): Int {
        return Objects.hash(id)
    }
}