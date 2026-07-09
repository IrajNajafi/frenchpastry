package ir.hoseinahmadi.frenchpastry

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.hoseinahmadi.frenchpastry.navigation.Screen
import ir.hoseinahmadi.frenchpastry.ui.screen.login.steepLogin
import ir.hoseinahmadi.frenchpastry.ui.theme.body1
import ir.hoseinahmadi.frenchpastry.ui.theme.body2
import ir.hoseinahmadi.frenchpastry.ui.theme.h6
import ir.hoseinahmadi.frenchpastry.util.Constants
import ir.hoseinahmadi.frenchpastry.util.PastryHelper
import ir.hoseinahmadi.frenchpastry.viewModel.DatStoreViewModel
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.sp
import ir.hoseinahmadi.frenchpastry.util.NotificationItem

@Composable
fun DrawerContent(
    navHostController: NavHostController,
    onClick: () -> Unit,
    datStoreViewModel: DatStoreViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    var showAbout by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth(0.85f)
            .fillMaxHeight()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(
                    onClick = { onClick() }
                ) {
                    Icon(
                        painterResource(id = R.drawable.close),
                        contentDescription = "",
                        Modifier.size(25.dp),
                        tint = Color.Black
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back_navigation_header),
                    contentDescription = "",
                    Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = Constants.USER_NAME,
                            color = Color.White,
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = PastryHelper.pastryByLocate(Constants.USER_PHONE),
                            color = Color.White,
                            style = MaterialTheme.typography.body1
                        )


                    }

                }
            }
            Spacer(modifier = Modifier.height(20.dp))

            TopItem(
                icon = painterResource(id = R.drawable.ic_user),
                title = "پروفایل کاربری",
                onClick = {
                    onClick()
                    navHostController.navigate(Screen.ProfileScreen.route)
                }
            )
            HorizontalDivider(
                thickness = 1.dp,
                color = Color.LightGray.copy(0.5f),
                modifier = Modifier.padding(vertical = 2.dp)
            )
            TopItem(
                icon = painterResource(id = R.drawable.ic_orders),
                title = "سفارش های من",
                onClick = {
                    Toast.makeText(context, "سفارش فعالی ندارید!", Toast.LENGTH_SHORT).show()
                }
            )
            HorizontalDivider(
                thickness = 1.dp,
                color = Color.LightGray.copy(0.5f),
                modifier = Modifier.padding(vertical = 2.dp)
            )

            val uriHandler = LocalUriHandler.current

            TopItem(
                icon = painterResource(id = R.drawable.ic_support),
                title = "پشتیبانی",
                onClick = {
                    try {
                        uriHandler.openUri("https://t.me/Hniejh")
                    } catch (e: Exception) {
                        Toast.makeText(context, "تلگرام یافت نشد", Toast.LENGTH_SHORT).show()
                    }
                }
            )
            HorizontalDivider(
                thickness = 1.dp,
                color = Color.LightGray.copy(0.5f),
                modifier = Modifier.padding(vertical = 2.dp)
            )


            TopItem(
                icon = painterResource(R.drawable.ic_about_us),
                title = "درباره ما"
            ) {
                showAbout = true
            }

            if (showAbout) {
                AboutUsBottomSheet(
                    onDismiss = {
                        showAbout = false
                    }
                )
            }
            HorizontalDivider(
                thickness = 1.dp,
                color = Color.LightGray.copy(0.5f),
                modifier = Modifier.padding(vertical = 2.dp)
            )


            TopItem(
                icon = painterResource(id = R.drawable.phon),
                title = "تماس با ما",
                onClick = {
                    try {
                        val intent = Intent(
                            Intent.ACTION_DIAL,
                            Uri.parse("tel:09036124101")
                        )
                        context.startActivity(intent)
                    } catch (e: Exception) {
                        Toast.makeText(
                            context,
                            "امکان برقراری تماس وجود ندارد",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            )
            HorizontalDivider(
                thickness = 1.dp,
                color = Color.LightGray.copy(0.5f),
                modifier = Modifier.padding(vertical = 2.dp)
            )

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    Toast.makeText(context, "آپدیتی وجود ندارد!", Toast.LENGTH_SHORT).show()
                }) {
                Row(
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 8.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_upgrade),
                            contentDescription = "",
                            Modifier.size(28.dp),
                            tint = Color.Black
                        )
                        Spacer(modifier = Modifier.width(7.dp))
                        Text(
                            text = "بروزرسانی نرم افزار",
                            style = MaterialTheme.typography.body2,
                            color = Color.Black
                        )

                    }

                    Text(
                        text = "۱.۰.۰",
                        style = MaterialTheme.typography.h6,
                        color = Color.DarkGray
                    )


                }
            }

            HorizontalDivider(
                thickness = 1.dp,
                color = Color.LightGray.copy(0.5f),
                modifier = Modifier.padding(vertical = 2.dp)
            )

            TopItem(
                icon = painterResource(id = R.drawable.ic_exit),
                title = "خروج از حساب کاربری",
                onClick = {
                    datStoreViewModel.saveUserName("")
                    datStoreViewModel.saveUserLogin(false)
                    datStoreViewModel.saveUserPhone("")
                    datStoreViewModel.saveUserApiKey("")
                    Constants.API_KEY = ""
                    Constants.CHECKED_LOGIN = false
                    Constants.USER_NAME = ""
                    onClick()
                    steepLogin.intValue = 1
                    navHostController.navigate(Screen.HomeScreen.route)
                }
            )

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_navigation),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(270.dp),
                    contentScale = ContentScale.FillBounds
                )

            }
        }

    }


}

@Composable
fun TopItem(
    icon: Painter,
    title: String,
    onClick: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth(),
        onClick = { onClick() }) {
        Row(
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                painter = icon, contentDescription = "",
                Modifier.size(28.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(7.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.body2,
                color = Color.Black
            )
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutUsBottomSheet(
    onDismiss: () -> Unit
) {

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = rememberModalBottomSheetState(),
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())

                .padding(20.dp)
        ) {

            Text(
                text = "درباره ما",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(16.dp))

            Text(
                text = """
به French Pastry  خوش آمدید.

ما با هدف ارائه تجربه‌ای متفاوت از خرید آنلاین شیرینی و دسرهای فرانسوی، این سامانه را طراحی کرده‌ایم تا کاربران بتوانند با دسترسی آسان به مجموعه‌ای متنوع از محصولات، سفارش خود را به‌صورت سریع، آسان و مطمئن ثبت کنند.

در French Pastry تلاش می‌کنیم با استفاده از مواد اولیه باکیفیت، دستورهای اصیل قنادی فرانسوی و رعایت استانداردهای تهیه، تولید و بسته‌بندی، محصولاتی با طعم و کیفیت مطلوب به مشتریان عزیز ارائه دهیم.

تمامی محصولات با دقت و حساسیت بالا آماده‌سازی شده و با هدف جلب رضایت مشتریان عرضه می‌شوند تا تجربه‌ای شیرین و خاطره‌انگیز از خرید آنلاین برای شما فراهم شود.

────────────────────────────

📌 توجه

این اپلیکیشن در قالب پروژه کارشناسی رشته مهندسی کامپیوتر طراحی و پیاده‌سازی شده است و با هدف نمایش فرآیند توسعه یک سامانه فروش آنلاین مبتنی بر سیستم‌عامل اندروید ارائه می‌شود.

در این پروژه از فناوری‌های روز اندروید از جمله Jetpack Compose، معماری MVVM، Hilt، Navigation، DataStore، Retrofit و سایر ابزارهای مرتبط استفاده شده است تا نمونه‌ای از یک اپلیکیشن مدرن و استاندارد ارائه گردد.

از اینکه French Pastry را برای مشاهده و ارزیابی انتخاب کرده‌اید، صمیمانه سپاسگزاریم.
""".trimIndent(),
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = 28.sp
            )
            Spacer(Modifier.height(24.dp))

            ElevatedCard(
                modifier = Modifier.fillMaxWidth()
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        Icons.Default.Phone,
                        contentDescription = null
                    )

                    Spacer(Modifier.width(12.dp))

                    Column {

                        Text(
                            "شماره تماس",
                            fontWeight = FontWeight.Bold
                        )

                        Text("09036124101")

                    }

                }

            }

            Spacer(Modifier.height(12.dp))

            ElevatedCard(
                modifier = Modifier.fillMaxWidth()
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        Icons.Default.Email,
                        contentDescription = null
                    )

                    Spacer(Modifier.width(12.dp))

                    Column {

                        Text(
                            "ایمیل",
                            fontWeight = FontWeight.Bold
                        )

                        Text("hnie.jh@gmail.com")

                    }

                }

            }

            Spacer(Modifier.height(12.dp))

            ElevatedCard(
                modifier = Modifier.fillMaxWidth()
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        Icons.Default.Code,
                        contentDescription = null
                    )

                    Spacer(Modifier.width(12.dp))

                    Column {

                        Text(
                            "GitHub",
                            fontWeight = FontWeight.Bold
                        )

                        Text("github.com/haniejh")

                    }

                }

            }

            Spacer(Modifier.height(24.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onDismiss
            ) {
                Text("بستن")
            }

            Spacer(Modifier.height(10.dp))

        }
    }
}
