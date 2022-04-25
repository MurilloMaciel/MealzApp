package com.maciel.murillo.mealz.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.maciel.murillo.mealz.R
import com.maciel.murillo.mealz.model.response.MealResponse
import com.maciel.murillo.mealz.ui.widgets.NetworkImage

@Composable
fun MealDetailsScreen(
    meal: MealResponse
) {
    Column() {
        Row() {
            Card() {
                NetworkImage(
                    imageUrl = meal.imageUrl,
                    modifier = Modifier.size(200.dp)
                )
            }
            Text(
                text = meal.name,
            )
        }
        Button(onClick = { /*TODO*/ }) {
            Text(
                text = stringResource(id = R.string.change_state_meal_image),
            )
        }
    }
}