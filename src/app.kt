fun main(){
    println("First task - Calcuating factorials:")

    println("0!= ${fact(0)}")
    println("1!= ${fact(1)}")
    println("3!= ${fact(3)}")
    println("5!= ${fact(5)}")

    println("Recursive implementation:")

    println("0!= ${fact_recurs(0)}")
    println("1!= ${fact_recurs(1)}")
    println("3!= ${fact_recurs(3)}")
    println("5!= ${fact_recurs(5)}")

    println("Second task - Palindroms:")

    println(String.format("Искать такси - ${palindrome("Искать такси")}"))
    println(String.format("Искал такси - ${palindrome("Искал такси")}"))
    println(String.format("А роза упала на лапу Азора - ${palindrome("А роза упала на лапу Азора")}"))
    println(String.format("А роза упала на лапу Зора - ${palindrome("А роза упала на лапу Зора")}"))

}

fun fact(a: Int): Int {
    var res = 1
    if ((a == 0) || (a == 1)) {
        res = 1
    } else {
        for (i in 1..a) {
            res *= i
        }
    }

    return res
}

fun fact_recurs(a: Int): Int{
    var res = 1
    if ((a == 0) || (a == 1)) {
        res = 1
    } else {
        res = a * fact_recurs (a-1)
    }

    return res
}

data class Result(
    val isPalindrome: String,
    val idx: List<Int> = emptyList()
)


fun palindrome(_str: String): Result {
    val _str = _str.toLowerCase()
    var idx1 = 0
    var idx2 = _str.length - 1

    while (idx2 > idx1) {
        if (_str[idx1] == ' ') {
            idx1++
            continue
        }
        if (_str[idx2] == ' ') {
            idx2--
            continue
        }
        if (_str[idx1] != _str[idx2])
            return Result (" не палиндром", listOf(idx1 + 1, idx2 + 1))
        ++idx1
        --idx2
    }

    return Result (" палиндром")

}