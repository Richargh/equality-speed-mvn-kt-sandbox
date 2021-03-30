package de.richargh.sandbox.equalityspeed

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestReporter
import java.text.DecimalFormat
import kotlin.system.measureTimeMillis

class EqualityTest {

    private val entityCount = 1_000_000
    private val df = DecimalFormat("#.######")

    @Test
    fun `compare Entities with InstanceOf and log average equality speed`(testReporter: TestReporter){
        // arrange
        val entities1 = (1..entityCount).map { id -> MyEntityInstanceOf(id) }
        val entities2 = (1..entityCount).map { id -> MyEntityInstanceOf(id) }
        // act
        var areEqual = false
        val totalElapsedTime = measureTimeMillis {
            areEqual = entities1 == entities2
        }
        val averageElapsedTime = df.format(totalElapsedTime.toDouble() / entityCount)
        // assert
        testReporter.publishEntry("EqualityCompare with InstanceOf took per element on average $averageElapsedTime")
        assertThat(areEqual).isTrue()
    }

    @Test
    fun `compare Entities with JavaClass and log average equality speed`(testReporter: TestReporter){
        // arrange
        val entities1 = (1..entityCount).map { id -> MyEntityJavaclass(id) }
        val entities2 = (1..entityCount).map { id -> MyEntityJavaclass(id) }
        // act
        var areEqual = false
        val totalElapsedTime = measureTimeMillis {
            areEqual = entities1 == entities2
        }
        val averageElapsedTime = df.format(totalElapsedTime.toDouble() / entityCount)
        // assert
        testReporter.publishEntry("EqualityCompare with JavaClass took per element on average $averageElapsedTime")
        assertThat(areEqual).isTrue()
    }

    @Test
    fun `compare Entities as a data class and log average equality speed`(testReporter: TestReporter){
        // arrange
        val entities1 = (1..entityCount).map { id -> MyEntityDataClass(id) }
        val entities2 = (1..entityCount).map { id -> MyEntityDataClass(id) }
        // act
        var areEqual = false
        val totalElapsedTime = measureTimeMillis {
            areEqual = entities1 == entities2
        }
        val averageElapsedTime = df.format(totalElapsedTime.toDouble() / entityCount)
        // assert
        testReporter.publishEntry("EqualityCompare with data class took per element on average $averageElapsedTime")
        assertThat(areEqual).isTrue()
    }
}