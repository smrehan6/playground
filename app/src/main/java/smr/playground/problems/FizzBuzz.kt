package smr.playground.problems

fun fizzBuzz(){
    for (i in 1..100){
        var flag = true
        if(i%3==0){
            flag = false
            print("Fizz")
        }
        if(i%5==0){
            flag= false
            print("Buzz")
        }
        if(flag){
            print("$i")
        }
        println()
    }
}

fun main(){
    fizzBuzz()
}