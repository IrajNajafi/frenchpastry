package ir.hoseinahmadi.frenchpastry.util

import ir.hoseinahmadi.frenchpastry.R

object PastrySliderProvider {

    fun getSlider(productId: Int): List<Int> {
        return when (productId) {
            66 -> listOf(
                R.drawable.img_sh,
                R.drawable.img_she2,
                R.drawable.img_sh3
            )

            63 -> listOf(
                R.drawable.img_ko,
                R.drawable.img_ko2,
                R.drawable.img_ko3
            )

            38 -> listOf(
                R.drawable.img_za,
                R.drawable.img_za,
                R.drawable.img_za
            )

            30 -> listOf(
                R.drawable.img_na_sh,
                R.drawable.img_na2,
                R.drawable.img_na3
            )

            34 -> listOf(
                R.drawable.img_na_sh,
                R.drawable.img_na3,
                R.drawable.img_na2
            )

            else -> emptyList()
        }
    }
    fun getThumbnail(productId: Int): Int {
        return when(productId){
            66 -> R.drawable.img_sh
            63 -> R.drawable.img_ko
            38 -> R.drawable.img_za
            30 -> R.drawable.img_na_sh
            34 -> R.drawable.img_na_sh
            else -> R.drawable.img_fra
        }
    }
}