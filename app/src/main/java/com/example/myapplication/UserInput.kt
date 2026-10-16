package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class UserInput : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FormBiodataScreen(modifier = Modifier)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormBiodataScreen(modifier: Modifier) {
    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tglLahir by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }

    var isAndroidChecked by remember { mutableStateOf(false) }
    var isUiUxChecked by remember { mutableStateOf(false) }
    var isWebChecked by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.header_height))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.banner_image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(200.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    shape = RoundedCornerShape(
                        topStart = dimensionResource(id = R.dimen.corner_radius_card),
                        topEnd = dimensionResource(id = R.dimen.corner_radius_card)
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(id = R.color.background_card)
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = dimensionResource(id = R.dimen.elevation_card)
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(dimensionResource(id = R.dimen.padding_large)),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(id = R.string.title_form),
                            style = MaterialTheme.typography.headlineSmall,
                            color = colorResource(id = R.color.purple_title)
                        )

                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))

                        Text(
                            text = stringResource(id = R.string.subtitle_form),
                            style = MaterialTheme.typography.bodyMedium,
                            color = colorResource(id = R.color.text_subtitle)
                        )

                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
                        ) {
                            OutlinedTextField(
                                value = namaDepan,
                                onValueChange = { namaDepan = it },
                                label = { Text(stringResource(id = R.string.hint_nama_depan)) },
                                modifier = Modifier.weight(1f),
                                shape = RoundedCornerShape(12.dp)
                            )
                            OutlinedTextField(
                                value = namaBelakang,
                                onValueChange = { namaBelakang = it },
                                label = { Text(stringResource(id = R.string.hint_nama_belakang)) },
                                modifier = Modifier.weight(1f),
                                shape = RoundedCornerShape(12.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))

                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text(stringResource(id = R.string.hint_email)) },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        )

                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
                        ) {
                            OutlinedTextField(
                                value = tglLahir,
                                onValueChange = { tglLahir = it },
                                label = { Text(stringResource(id = R.string.hint_tgl_lahir)) },
                                modifier = Modifier.weight(1f),
                                shape = RoundedCornerShape(12.dp),
                                trailingIcon = {
                                    Icon(
                                        painter = painterResource(id = android.R.drawable.ic_menu_my_calendar),
                                        contentDescription = null
                                    )
                                }
                            )
                            OutlinedTextField(
                                value = experience,
                                onValueChange = { experience = it },
                                label = { Text(stringResource(id = R.string.hint_experience)) },
                                modifier = Modifier.weight(1f),
                                shape = RoundedCornerShape(12.dp),
                                trailingIcon = {
                                    Icon(
                                        painter = painterResource(id = android.R.drawable.ic_input_add),
                                        contentDescription = null
                                    )
                                }
                            )
                        }

                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))

                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Text(
                                text = stringResource(id = R.string.label_pilih_skill),
                                color = colorResource(id = R.color.black),
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }

                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Checkbox(
                                    checked = isAndroidChecked,
                                    onCheckedChange = { isAndroidChecked = it }
                                )
                                Text(text = stringResource(id = R.string.skill_android))
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Checkbox(
                                    checked = isUiUxChecked,
                                    onCheckedChange = { isUiUxChecked = it }
                                )
                                Text(text = stringResource(id = R.string.skill_uiux))
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Checkbox(
                                    checked = isWebChecked,
                                    onCheckedChange = { isWebChecked = it }
                                )
                                Text(text = stringResource(id = R.string.skill_web))
                            }
                        }

                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_large)))

                        Button(
                            onClick = { /* Aksi klik tombol */ },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.button_bg)
                            )
                        ) {
                            Text(
                                text = stringResource(id = R.string.btn_proceed),
                                color = colorResource(id = R.color.text_subtitle)
                            )
                        }
                    }
                }
            }
        }
    }
}