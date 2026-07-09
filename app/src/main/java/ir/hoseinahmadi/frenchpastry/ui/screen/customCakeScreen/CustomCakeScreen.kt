package ir.hoseinahmadi.frenchpastry.ui.screen.customCakeScreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ir.hoseinahmadi.frenchpastry.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomCakeScreen(
    onBack: () -> Unit
) {
    val context = LocalContext.current
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var flavor by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Scaffold(

        topBar = {

            TopAppBar(

                title = {
                    Text("کیک سفارشی")
                },

                navigationIcon = {

                    IconButton(onClick = onBack) {

                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null
                        )

                    }

                }

            )

        }

    ) { padding ->

        Column(

            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),

            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {

            Image(

                painter = painterResource(R.drawable.img_cake_custom),

                contentDescription = null,

                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),

                contentScale = ContentScale.Crop

            )

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("نام مشتری") }
            )

            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("شماره تماس") }
            )

            OutlinedTextField(
                value = weight,
                onValueChange = { weight = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("وزن کیک") }
            )

            OutlinedTextField(
                value = flavor,
                onValueChange = { flavor = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("طعم کیک") }
            )

            OutlinedTextField(

                value = description,

                onValueChange = {
                    description = it
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),

                label = {
                    Text("توضیحات سفارش")
                }

            )

            Button(
                onClick = {

                    if (
                        name.trim().isEmpty() ||
                        phone.trim().isEmpty() ||
                        weight.trim().isEmpty() ||
                        flavor.trim().isEmpty() ||
                        description.trim().isEmpty()
                    ) {

                        Toast.makeText(
                            context,
                            "لطفاً تمام فیلدها را تکمیل کنید.",
                            Toast.LENGTH_SHORT
                        ).show()

                    } else {

                        Toast.makeText(
                            context,
                            "سفارش شما با موفقیت ثبت شد.",
                            Toast.LENGTH_SHORT
                        ).show()

                        onBack()

                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
            ) {
                Text("ثبت سفارش")
            }

        }

    }

}