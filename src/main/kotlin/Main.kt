import kotlin.random.Random

// Function to generate a random 4-digit number
fun generateRandomNumber(): String {
    // Generate a sequence of random digits from 1 to 9
    val uniqueDigitsSet = generateSequence {
        Random.nextInt(1,9)
    }
        .distinct() // --> make sure each digit is unique
        .take(4) // --> take the first 4 digits
        .toSet() // --> convert the digits to a set to remove duplicates
    return uniqueDigitsSet.toString().replace(" ", "")
        .replace("[","")
        .replace("]","")
        .replace(",", "")

}

// function to check the number of correct and misplaced digits in a guess
fun checkGuess(number: String, guess: String) : String {
    var n = 0 // --> correct digits in the wrong position
    var m = 0 // --> correct digits in the correct position
    val numberChars: CharArray = number.toCharArray()
    val guessChars: CharArray = guess.toCharArray()
    for (j in 0..3) {
        for (k in 0..3) {
            if(guessChars[j] == numberChars[k]){ // if digits match
                n++ // increment the count of correct digits in the wrong position
            }
        }
    }
    for (i in 0..3) {
        if(guessChars[i] == numberChars[i]){ // if digits match in the same position
            m++ // increment the count of correct digits in the correct position
        }
    }
    // return a string with the counts of correct digits in the wrong and correct positions
    return "$n:$m"
}


fun main() {
    val numberToGuess = generateRandomNumber()
    var enteredGuess: String = "0"
    println("Enter a number of 4 digits to play the game!")
    // keep asking for guesses until the correct number is guessed
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