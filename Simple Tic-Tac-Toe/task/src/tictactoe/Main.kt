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

fun printer() {
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
        if (whoWins(m) != ""){
            printer()
            println(whoWins(m))
            break
        }
        printer()
        try {
            val a = readln().split(' ')
            if (m[a[0].toInt() - 1][a[1].toInt() - 1] == ' ') {
                counter++
                if (counter % 2 == 0){
                m[a[0].toInt() - 1][a[1].toInt() - 1] = 'X'
                continue
                }
                else {
                    m[a[0].toInt() - 1][a[1].toInt() - 1] = 'O'
                    continue
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