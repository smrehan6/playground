package smr.playground.kotlin.coroutines

import kotlinx.coroutines.*

class AsyncWithContext {

    private suspend fun sequentialExample() {
        val one = doLongRunningTaskOne()
        val two = doLongRunningTaskTwo()
        val result = one + two
    }

    private suspend fun sequentialExample2() {
        val a = withContext(Dispatchers.Main) { doLongRunningTaskOne() }
        val b = withContext(Dispatchers.IO) { doLongRunningTaskOne() }
        val c = withContext(Dispatchers.Default) { doLongRunningTaskTwo() }
        val d = withContext(Dispatchers.Unconfined) { doLongRunningTaskTwo() }
    }

    private suspend fun parallelExample() = GlobalScope.launch {
        val one = async { doLongRunningTaskOne() }
        val two = async { doLongRunningTaskTwo() }
        val result = one.await() + two.await()
    }

    private suspend fun doLongRunningTaskOne(): String {
        delay(5000)
        return "One"
    }

    private suspend fun doLongRunningTaskTwo(): String {
        delay(5000)
        return "Two"
    }
}