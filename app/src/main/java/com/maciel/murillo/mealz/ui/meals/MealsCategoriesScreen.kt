package com.maciel.murillo.mealz.ui.meals

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.maciel.murillo.mealz.R
import com.maciel.murillo.mealz.model.response.MealResponse
import com.maciel.murillo.mealz.ui.theme.MealzTheme

@Composable
fun MealsCategoriesScreen() {
    val viewModel: MealsCategoriesViewModel = viewModel()
    viewModel.getMeals()
    val categoriesState = viewModel.categoriesState.collectAsState()
    MealsCategoriesBody(
        categoriesState = categoriesState.value
    )
}

@Composable
fun MealsCategoriesBody(
    categoriesState: MealsCategoriesState
) {
    if (categoriesState is MealsCategoriesState.Success) {
        SuccessBody(categoriesState)
    } else {
        LoadingBody()
    }
}

@Composable
fun LoadingBody() {
    CircularProgressIndicator(
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun SuccessBody(categoriesState: MealsCategoriesState.Success) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp)
    ) {
        items(categoriesState.data.categories) { meal ->
            Category(meal = meal)
        }
    }
}

@Composable
fun Category(
    meal: MealResponse
) {
    Card(
        shape = RoundedCornerShape(size = 8.dp),
        elevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Row(

        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(meal.imageUrl)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.placeholder),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(CircleShape)
                    .size(88.dp)
                    .padding(4.dp)
            )
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = meal.name,
                    style = MaterialTheme.typography.h6
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzTheme {
//        MealsCategoriesScreen()
    }
}