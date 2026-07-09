package ir.hoseinahmadi.frenchpastry.ui.screen.discountItem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CardGiftcard
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyDiscountScreen(
    onBack: () -> Unit
) {

    val discounts = listOf(
        Discount(
            title = "20٪ تخفیف",
            code = "CAKE20",
            description = "برای خریدهای بالای ۵۰۰ هزار تومان",
            expire = "1405/05/20"
        ),
        Discount(
            title = "ارسال رایگان",
            code = "FREE",
            description = "برای اولین سفارش",
            expire = "1405/06/01"
        )
    )

    Scaffold(

        topBar = {
            // TopAppBar
        }

    ) { padding ->

        if (discounts.isEmpty()) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Icon(
                    Icons.Default.CardGiftcard,
                    contentDescription = null,
                    modifier = Modifier.size(90.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text("هنوز تخفیفی برای شما ثبت نشده است.")

            }

        } else {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(discounts) { item ->

                    DiscountItem(item)

                }

            }

        }

    }

}