package ir.hoseinahmadi.frenchpastry.ui.screen.discountItem

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DiscountItem(
    item: Discount
) {

    val context = LocalContext.current

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = item.title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Spacer(Modifier.height(8.dp))

            Text("کد تخفیف: ${item.code}")

            Text(item.description)

            Text("اعتبار تا: ${item.expire}")

            Spacer(Modifier.height(12.dp))

            Button(
                onClick = {

                    val clipboard =
                        context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

                    clipboard.setPrimaryClip(
                        ClipData.newPlainText(
                            "discount",
                            item.code
                        )
                    )

                    Toast.makeText(
                        context,
                        "کد کپی شد.",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            ) {

                Text("کپی کد")

            }

        }

    }

}