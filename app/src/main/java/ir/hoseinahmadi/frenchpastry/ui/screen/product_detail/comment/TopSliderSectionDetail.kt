package ir.hoseinahmadi.frenchpastry.ui.screen.product_detail.comment


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import ir.hoseinahmadi.frenchpastry.R
import ir.hoseinahmadi.frenchpastry.util.PastryImages
import kotlinx.coroutines.delay


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TopSliderSectionDetail(
    images: List<Int>
) {
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xffF0F3FF))
            .height(220.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        ) {

            HorizontalPager(
                count = images.size,
                state = pagerState,
                contentPadding = PaddingValues(horizontal = 5.dp),
                modifier = Modifier.fillMaxWidth()
            ) { index ->

                Image(
                    painter = painterResource(images[index]),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(5.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {

                Row(
                    modifier = Modifier
                        .size(80.dp, 25.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xffF0F3FF)),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    HorizontalPagerIndicator(
                        pagerState = pagerState,
                        activeColor = Color.Black,
                        inactiveColor = Color(0xffD9D9D9),
                        indicatorWidth = 8.dp,
                        indicatorHeight = 8.dp,
                        indicatorShape = CircleShape
                    )
                }
            }

            LaunchedEffect(pagerState.currentPage) {
                delay(4000)
                val next = (pagerState.currentPage + 1) % images.size
                pagerState.animateScrollToPage(next)
            }
        }
    }
}
