package ir.hoseinahmadi.frenchpastry.ui.screen.home.popular

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import ir.hoseinahmadi.frenchpastry.data.model.home.PastryItem

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PopularProductSection(
    navHostController: NavHostController,
    item: List<PastryItem>
) {
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        maxItemsInEachRow = 2,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        item.forEachIndexed { index, pastryItem ->
            PopularItem(
                navHostController = navHostController,
                item = pastryItem,
                index = index
            )
        }
    }
}