package ir.hoseinahmadi.frenchpastry.ui.screen.home.amazing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ir.hoseinahmadi.frenchpastry.data.model.home.PastryItem

@Composable
fun AmazingOfferSection(
    navHostController: NavHostController,
    item: List<PastryItem>
) {
    Spacer(modifier = Modifier.height(10.dp))

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 3.dp)
            .background(Color(0xff532379))
    ) {

        item {
            AmazingItemStart()
        }

        itemsIndexed(item) { index, pastryItem ->
            AmazingItem(
                navHostController = navHostController,
                item = pastryItem,
                index = index
            )
        }

        item {
            AmazingItemShowMore()
        }
    }
}