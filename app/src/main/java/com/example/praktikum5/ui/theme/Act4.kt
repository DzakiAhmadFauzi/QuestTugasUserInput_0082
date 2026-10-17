package com.example.praktikum5.ui.theme

import android.app.DatePickerDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikum5.R
import java.util.Calendar

@Composable
fun Act4() {
    val context = LocalContext.current

    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tanggalLahir by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }
    var android by remember { mutableStateOf(false) }
    var uiux by remember { mutableStateOf(false) }
    var web by remember { mutableStateOf(false) }
    var dropdown by remember { mutableStateOf(false) }

    val calendar = Calendar.getInstance()

    Scaffold(
        containerColor = colorResource(R.color.page_background)
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Image(
                painter = painterResource(R.drawable.header_neon),
                contentDescription = stringResource(R.string.header_description),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(R.dimen.header_height)),
                contentScale = ContentScale.Crop
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(R.dimen.card_top_padding)),
                shape = RoundedCornerShape(
                    topStart = dimensionResource(R.dimen.card_corner),
                    topEnd = dimensionResource(R.dimen.card_corner)
                ),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(R.color.card_white)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = dimensionResource(R.dimen.card_elevation)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                        .padding(
                            horizontal = dimensionResource(R.dimen.card_padding),
                            vertical = dimensionResource(R.dimen.content_padding)
                        ),
                    verticalArrangement = Arrangement.spacedBy(
                        dimensionResource(R.dimen.field_spacing)
                    )
                ) {
                    Text(
                        text = stringResource(R.string.form_title),
                        modifier = Modifier.fillMaxWidth(),
                        color = colorResource(R.color.title_purple),
                        fontSize = dimensionResource(R.dimen.title_size).value.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = stringResource(R.string.form_subtitle),
                        modifier = Modifier.fillMaxWidth(),
                        color = colorResource(R.color.text_secondary),
                        fontSize = dimensionResource(R.dimen.subtitle_size).value.sp,
                        textAlign = TextAlign.Center
                    )

                    Spacer(Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = namaDepan,
                            onValueChange = { namaDepan = it },
                            placeholder = {
                                Text(stringResource(R.string.first_name))
                            },
                            modifier = Modifier
                                .weight(1f)
                                .height(56.dp),
                            singleLine = true,
                            shape = RoundedCornerShape(
                                dimensionResource(R.dimen.input_corner)
                            )
                        )

                        OutlinedTextField(
                            value = namaBelakang,
                            onValueChange = { namaBelakang = it },
                            placeholder = {
                                Text(stringResource(R.string.last_name))
                            },
                            modifier = Modifier
                                .weight(1f)
                                .height(56.dp),
                            singleLine = true,
                            shape = RoundedCornerShape(
                                dimensionResource(R.dimen.input_corner)
                            )
                        )
                    }

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        placeholder = {
                            Text(stringResource(R.string.email))
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        ),
                        shape = RoundedCornerShape(
                            dimensionResource(R.dimen.input_corner)
                        )
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedButton(
                            onClick = {
                                DatePickerDialog(
                                    context,
                                    { _, year, month, day ->
                                        tanggalLahir = "%02d/%02d/%04d".format(
                                            day,
                                            month + 1,
                                            year
                                        )
                                    },
                                    calendar.get(Calendar.YEAR),
                                    calendar.get(Calendar.MONTH),
                                    calendar.get(Calendar.DAY_OF_MONTH)
                                ).show()
                            },
                            modifier = Modifier
                                .weight(1f)
                                .height(56.dp),
                            shape = RoundedCornerShape(
                                dimensionResource(R.dimen.input_corner)
                            ),
                            contentPadding = PaddingValues(horizontal = 8.dp)
                        ) {
                            Text(
                                text = tanggalLahir.ifBlank {
                                    stringResource(R.string.birth_date)
                                },
                                modifier = Modifier.weight(1f),
                                maxLines = 1,
                                fontSize = 12.sp
                            )
                            Text("▦", fontSize = 20.sp)
                        }

                        Box(modifier = Modifier.weight(1f)) {
                            OutlinedButton(
                                onClick = { dropdown = true },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(56.dp),
                                shape = RoundedCornerShape(
                                    dimensionResource(R.dimen.input_corner)
                                ),
                                contentPadding = PaddingValues(horizontal = 8.dp)
                            ) {
                                Text(
                                    text = experience.ifBlank {
                                        stringResource(R.string.experience)
                                    },
                                    modifier = Modifier.weight(1f),
                                    maxLines = 1,
                                    fontSize = 12.sp
                                )
                                Text("▾", fontSize = 20.sp)
                            }

                            DropdownMenu(
                                expanded = dropdown,
                                onDismissRequest = { dropdown = false }
                            ) {
                                listOf(
                                    R.string.beginner,
                                    R.string.intermediate,
                                    R.string.advanced
                                ).forEach { option ->
                                    val optionText = stringResource(option)

                                    DropdownMenuItem(
                                        text = { Text(optionText) },
                                        onClick = {
                                            experience = optionText
                                            dropdown = false
                                        }
                                    )
                                }
                            }
                        }
                    }

                    Text(
                        text = stringResource(R.string.skills_title),
                        fontWeight = FontWeight.Bold,
                        fontSize = dimensionResource(R.dimen.label_size).value.sp
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SkillCheckbox(
                            label = stringResource(R.string.skill_android),
                            checked = android,
                            onCheckedChange = { android = it }
                        )

                        SkillCheckbox(
                            label = stringResource(R.string.skill_uiux),
                            checked = uiux,
                            onCheckedChange = { uiux = it }
                        )

                        SkillCheckbox(
                            label = stringResource(R.string.skill_web),
                            checked = web,
                            onCheckedChange = { web = it }
                        )
                    }

                    Spacer(Modifier.height(8.dp))

