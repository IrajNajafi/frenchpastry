package ir.hoseinahmadi.frenchpastry


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ir.hoseinahmadi.frenchpastry.navigation.Screen
import ir.hoseinahmadi.frenchpastry.util.Constants

@Composable
fun MyTopBar(
    navHostController: NavHostController,
    onClick: () ->Unit
) {
    var showNotification by remember { mutableStateOf(false) }

    val item = listOf(
        Screen.HomeScreen.route,
        Screen.CategoryScreen.route,
        Screen.BasketScreen.route,
        Screen.PastryScreen.route,
        Screen.ProfileScreen.route
    )

    val backEntry = navHostController.currentBackStackEntryAsState()
    val show = backEntry.value?.destination?.route in item

    AnimatedVisibility(
        visible = show && Constants.CHECKED_LOGIN,
        enter = fadeIn(),
        exit = fadeOut(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(horizontal = 5.dp, vertical = 2.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { onClick() }) {
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = "",
                    tint = Color.Black
                )
            }

            Image(
                painter = painterResource(id = R.drawable.black_logo),
                contentDescription = "",
                Modifier.size(82.dp, 48.dp),
            )

            IconButton(
                onClick = {
                    showNotification = true
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_alert),
                    contentDescription = null,
                    modifier = Modifier.size(22.dp),
                    tint = Color.Black
                )
            }

            if (showNotification) {
                NotificationBottomSheet(
                    onDismiss = {
                        showNotification = false
                    }
                )
            }

        }
    }


}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationBottomSheet(
    onDismiss: () -> Unit
) {

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = rememberModalBottomSheetState()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "اعلان‌ها",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(20.dp))

            NotificationItem(
                "🎉 جشنواره تابستانه",
                "تمام شیرینی‌های فرانسوی تا ۲۰٪ تخفیف"
            )

            Divider()

            NotificationItem(
                "🥐 کروسان تازه",
                "کروسان کره‌ای امروز پخت شده است."
            )

            Divider()

            NotificationItem(
                "🚚 ارسال رایگان",
                "برای خریدهای بالای ۵۰۰ هزار تومان"
            )

            Spacer(Modifier.height(25.dp))
        }
    }
}

@Composable
private fun NotificationItem(
    title: String,
    desc: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = null,
            tint = Color(0xFFE5A000)
        )

        Column(
            modifier = Modifier.padding(start = 12.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            Text(
                text = title,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = desc,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}