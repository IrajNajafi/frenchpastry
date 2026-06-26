package ir.hoseinahmadi.frenchpastry.util

data class NotificationItem(
    val title: String,
    val message: String
)

val notifications = listOf(
    NotificationItem(
        "🎉 جشنواره تابستانه",
        "تمام محصولات تا ۲۰٪ تخفیف"
    ),
    NotificationItem(
        "🥐 کروسان تازه",
        "کروسان کره‌ای دوباره موجود شد."
    ),
    NotificationItem(
        "🚚 ارسال رایگان",
        "برای خریدهای بالای ۵۰۰ هزار تومان"
    )
)