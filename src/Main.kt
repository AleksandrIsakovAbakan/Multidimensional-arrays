import kotlin.math.abs


fun main() {
    val array = arrayOf(arrayOf(5, 8, 15),
                        arrayOf(6, 4, 15),
                        arrayOf(55, 8, 3))
    println(array.contentDeepToString())
    println("Найти минимальный элемент в целочисленном массиве размера 3 х 3 : "
            + findMinimumElementInIntegerArray(array))
    println()

    val arrayTwo = arrayOf(arrayOf(5, 8, 15, 4, 8),
        arrayOf(6, 4, 15, 0, 4),
        arrayOf(55, 8, 3, 13, 40))
    println(arrayTwo.contentDeepToString())
    println("Найти элемент в этом массиве, который является средним(медиана): " + findElementInArrayThatIsMiddle(arrayTwo))
    println()

    val arrayThree = arrayOf(arrayOf(0,0,0,0,0),
        arrayOf(0,0,0,0,0),
        arrayOf(0,0,0,0,0),
        arrayOf(0,0,0,0,0),
        arrayOf(0,0,0,0,0)
    )
    println("Дана матрица размером 5 х 5. Заполнить ее единицами в таком порядке:\n" +
            "0 0 0 0 0\n" +
            "0 0 0 0 0\n" +
            "0 0 1 0 0\n" +
            "0 1 1 1 0\n" +
            "1 1 1 1 1")
    println(fillMatrixWithUnitsInOrder(arrayThree).contentDeepToString())
    println()

    arrayTwo[0][1] = 50
    arrayTwo[1][3] = 53
    println(arrayTwo.contentDeepToString())
    println("Дан набор целых чисел. Найти второе максимальное число: " + findSecondMaximumNumber(arrayTwo))
}

/*
1. Найти минимальный элемент в целочисленном массиве размера 3 х 3.
*/
fun findMinimumElementInIntegerArray(array: Array<Array<Int>>): Int {
    var result = 0
    for (a in array.indices){
        if (a == 0) {
            result = array[a].min()
        } else {
            val temp = array[a].min()
            if (result > temp) result = temp
        }
    }
    return result
}

/*
2. Создать матрицу размером 3 х 5.
Найти элемент в этом массиве, который является средним(медиана).
*/
fun findElementInArrayThatIsMiddle(array: Array<Array<Int>>): Int {
    var sum = 0.0
    var count = 0.0
    for (a in array.indices){
        sum += array[a].sum()
        count += array[a].count()
    }
    var resultI = 0
    var resultJ = 0
    var temp = 2_147_483_647.0
    for (i in array.indices){
        for (j in array[i].indices){
            if (abs((sum / count) - array[i][j]) < temp) {
                resultI = i
                resultJ = j
                temp = abs((sum / count) - array[i][j])
            }
        }
    }
    return array[resultI][resultJ]
}

/*
3. Дана матрица размером 5 х 5. Заполнить ее единицами в таком порядке:
0 0 0 0 0
0 0 0 0 0
0 0 1 0 0
0 1 1 1 0
1 1 1 1 1
*/
fun fillMatrixWithUnitsInOrder(matrix : Array<Array<Int>>): Array<Array<Int>>{
    for (a in matrix.indices){
        for (b in matrix[a].indices) if ((a == 2 && b == 2) || (a == 3 && b in 1..3) || a == 4) matrix[a][b] = 1
    }
    return matrix
}


/*
4. Дан набор целых чисел. Найти второе максимальное число.
*/
fun findSecondMaximumNumber(array: Array<Array<Int>>): Int{
    var max = 0
    for (a in array.indices) max = array[a].max()
    var maxTwo = 0
    for (a in array.indices){
        for (b in array[a].indices) if (array[a][b] > maxTwo && array[a][b] != max) maxTwo = array[a][b]
    }
    return maxTwo
}

/*
Примечания:
- Для вывода значений на экран используйте функцию println().
*/