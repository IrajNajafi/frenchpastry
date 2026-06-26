package ir.hoseinahmadi.frenchpastry.util


import ir.hoseinahmadi.frenchpastry.R

object PastryImages {

    private val images = intArrayOf(
        R.drawable.img_sh,
        R.drawable.img_ko,
        R.drawable.img_za,
        R.drawable.img_na_sh,
        R.drawable.img_na1
    )

    operator fun get(index: Int): Int {
        return images[index % images.size]
    }
}