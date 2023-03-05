import kotlin.random.Random

fun generateRandomNumber(): String {
    val uniqueDigitsSet = generateSequence {
        Random.nextInt(1,9)
    }
        .distinct()
        .take(4)
        .toSet()
    return uniqueDigitsSet.toString().replace(" ", "")
        .replace("[","")
        .replace("]","")
        .replace(",", "")

}

fun checkGuess(number: String, guess: String) : String {
    var n = 0
    var m = 0
    val numberChars: CharArray = number.toCharArray()
    val guessChars: CharArray = guess.toCharArray()
    for (j in 0..3) {
        for (k in 0..3) {
            if(guessChars[j] == numberChars[k]){
                n++
            }
        }
    }
    for (i in 0..3) {
        if(guessChars[i] == numberChars[i]){
            m++
        }
    }
    return "$n:$m"
}


fun main() {
    val numberToGuess = generateRandomNumber()
    var enteredGuess: String = "0"
    println("Enter a number of 4 digits to play the game!")
    while(numberToGuess != enteredGuess) {
        print("Your Guess: ")
        enteredGuess = readLine().toString()
        if(enteredGuess.length == 4) {
            if(numberToGuess == enteredGuess) {
                println("Congratulation! You guessed the right number!")
            } else {
                val result = checkGuess(numberToGuess, enteredGuess)
                println(result)
            }
        } else {
            println("Incorrect Input --> Please enter a number of 4 digits!")
        }
    }
}