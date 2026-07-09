package ir.hoseinahmadi.frenchpastry.ui.screen.order

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import ir.hoseinahmadi.frenchpastry.ui.screen.product_detail.Header

@Composable
fun OrderStatusScreen(
    navHostController: NavHostController,
    status: String
) {

    val title = when (status) {
        "pending" -> "سفارش‌های در انتظار پرداخت"
        "review" -> "سفارش‌های در حال بررسی"
        "preparing" -> "سفارش‌های در حال آماده‌سازی"
        "delivered" -> "سفارش‌های تحویل داده شده"
        else -> "سفارش‌ها"
    }

    Scaffold(
        topBar = {
            Header(title = title)
        }
    ) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "هنوز سفارشی برای این بخش وجود ندارد.",
                style = MaterialTheme.typography.bodyLarge
            )

        }

    }
}