fun plusMinus(arr: Array<Int>): Unit {
    val items = arr
    val size = items.size

    val counts = Counts(0,0,0)

    for (item in items) {
        when {
            item > 0 -> counts.positivesCount += 1
            item < 0 -> counts.negativesCount += 1
            else -> counts.zeroCount += 1
        }
    }

    val results = Result.builder(
        counts.positivesCount,
        counts.negativesCount,
        counts.zeroCount,
        size
    )
    results.printWithPrecision(6)
}

data class Counts(
    var positivesCount: Int,
    var negativesCount: Int,
    var zeroCount: Int
)

data class Result(
    val positives: Double,
    val negatives: Double,
    val zeros: Double
) {
    companion object {
        fun builder(
            positives: Int,
            negatives: Int,
            zeros: Int,
            size: Int
        ): Result {
            return Result(
                positives / size.toDouble(),
                negatives / size.toDouble(),
                zeros / size.toDouble()
            )
        }
    }

    fun printWithPrecision(
        precision: Int = 6
    ) {
        val format = "%.${precision}f"
        println(format.format(positives))
        println(format.format(negatives))
        println(format.format(zeros))
    }
}

fun main() {
    val input = intArrayOf(-4, 3, -9, 0, 4, 1).toTypedArray()

    val inputString = input.joinToString(",")

    println(inputString)

    plusMinus(input)
}


main()