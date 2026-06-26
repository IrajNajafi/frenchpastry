package ir.hoseinahmadi.frenchpastry.ui.screen.address

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.android.gms.maps.model.CameraPosition
@SuppressLint("UnrememberedMutableState")

@Composable
fun GoogleMapSection(
    onLocationSelected: (LatLng, String) -> Unit
) {
    val context = LocalContext.current

    val initialLocation = LatLng(35.699739, 51.337658)

    val cameraState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(initialLocation, 16f)
    }

    val geocoder = remember { android.location.Geocoder(context) }

    fun getAddress(latLng: LatLng): String {
        return try {
            val geocoder = android.location.Geocoder(context)

            val result = geocoder.getFromLocation(
                latLng.latitude,
                latLng.longitude,
                1
            )

            result?.firstOrNull()?.getAddressLine(0)
                ?: "آدرس پیدا نشد"

        } catch (e: Exception) {
            e.printStackTrace()  // 👈 خیلی مهم
            "خطا در دریافت آدرس"
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {

        GoogleMap(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(22.dp)),
            cameraPositionState = cameraState,
            uiSettings = MapUiSettings(
                zoomControlsEnabled = true,
                compassEnabled = true,
                mapToolbarEnabled = true
            ),
            onMapClick = { latLng ->
                val address = getAddress(latLng)
                onLocationSelected(latLng, address)
            }
        ) {

            Marker(
                state = MarkerState(initialLocation),
                title = "موقعیت انتخابی"
            )
        }
    }
}