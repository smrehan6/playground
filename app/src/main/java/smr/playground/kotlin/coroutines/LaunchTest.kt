package smr.playground.kotlin.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class LaunchTest {

    suspend fun someWork() : Int {
        println("getting random int")
        delay(1000)
        return Random.nextInt()
    }

}

fun main(){
    GlobalScope.launch {
        val test = LaunchTest()
        val int = test.someWork()
        println("Got $int")
    }
}

