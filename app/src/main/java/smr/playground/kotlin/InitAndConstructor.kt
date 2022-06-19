package smr.playground.kotlin

class InitAndConstructor  {

    var name : String? = null

    constructor() {
        println("primary")
    }

    constructor(name: String) {
        this.name = name
        println("secondary")
    }

    init {
        println("first")
    }

    init {
        println("second")
    }

    init {
        println("third")
    }
}