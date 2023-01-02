package tictactoe

import java.lang.IndexOutOfBoundsException

val m = MutableList(3) { MutableList(3) {' '} }
var counter = -1

fun whoWins(a: MutableList<MutableList<Char>>): String {
    var str = ""
    // diagonals
    if (a[0][0] == a[1][1] && a[0][0] == a[2][2] && a[0][0] != ' ') str += "${a[0][0]} wins"
    if (a[0][2] == a[1][1] && a[0][2] == a[2][0] && a[0][2] != ' ') str += "${a[0][2]} wins"
    // horizontal
    if (a[0][0] == a[0][1] && a[0][0] == a[0][2] && a[0][0] != ' ') str += "${a[0][0]} wins"
    if (a[1][0] == a[1][1] && a[1][0] == a[1][2] && a[1][0] != ' ') str += "${a[1][0]} wins"
    if (a[2][0] == a[2][1] && a[2][0] == a[2][2] && a[2][0] != ' ') str += "${a[2][0]} wins"
    // vertical
    if (a[0][0] == a[1][0] && a[0][0] == a[2][0] && a[0][0] != ' ') str += "${a[0][0]} wins"
    if (a[0][1] == a[1][1] && a[0][1] == a[2][1] && a[0][1] != ' ') str += "${a[0][1]} wins"
    if (a[0][2] == a[1][2] && a[0][2] == a[2][2] && a[0][2] != ' ') str += "${a[0][2]} wins"
    return str
}

fun gridPrinter() {
    println("---------")
    for (i in 0..2){
        print("|")
        for (j in 0..2){
            print(" " + m[i][j])
        }
        print(" |")
        println()
    }
    println("---------")
}

fun main() {
    while (true){
        // checks draw condition
        if ((whoWins(m) != "X wins" || whoWins(m) != "O wins") && counter == 8) { 
            gridPrinter()
            println("Draw")
            break
        } // checks who wins and prints grid 
        if (whoWins(m) != ""){
            gridPrinter()
            println(whoWins(m))
            break
        }
        gridPrinter()
        try {
            val a = readln().split(' ')
            if (m[a[0].toInt() - 1][a[1].toInt() - 1] == ' ') {
                counter++ 
                // checks whose turn it is and assign 'X' or 'O'
                if (counter % 2 == 0){
                m[a[0].toInt() - 1][a[1].toInt() - 1] = 'X'
                continue
                }
                else {
                    m[a[0].toInt() - 1][a[1].toInt() - 1] = 'O'
                }
            }
            else println("This cell is occupied! Choose another one!")
        } catch (e: NumberFormatException){
            println("You should enter numbers!")
        } catch (e: IndexOutOfBoundsException){
            println("Coordinates should be from 1 to 3!")
        }
    }
}
