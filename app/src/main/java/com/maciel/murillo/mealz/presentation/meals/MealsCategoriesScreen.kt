package com.maciel.murillo.mealz.presentation.meals

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maciel.murillo.mealz.data.model.CategoryResponse
import com.maciel.murillo.mealz.presentation.theme.MealzTheme
import com.maciel.murillo.mealz.presentation.widgets.NetworkImage

@Composable
fun MealsCategoriesScreen(navigationCallback: (String) -> Unit) {
    val viewModel: MealsCategoriesViewModel = viewModel()
    viewModel.getMeals()
    val categoriesState = viewModel.categoriesState.collectAsState()
    MealsCategoriesBody(
        categoriesState = categoriesState.value,
        navigationCallback = navigationCallback
    )
}

@Composable
fun MealsCategoriesBody(
    categoriesState: MealsCategoriesState,
    navigationCallback: (String) -> Unit
) {
    if (categoriesState is MealsCategoriesState.Success) {
        SuccessBody(
            categoriesState = categoriesState,
            navigationCallback = navigationCallback,
        )
    } else {
        LoadingBody()
    }
}

@Composable
fun LoadingBody() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(36.dp)
        )
    }
}

@Composable
fun SuccessBody(
    categoriesState: MealsCategoriesState.Success,
    navigationCallback: (String) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp)
    ) {
        items(categoriesState.data.categories) { meal ->
            Category(
                category = meal,
                navigationCallback = navigationCallback,
            )
        }
    }
}

@Composable
fun Category(
    category: CategoryResponse,
    navigationCallback: (String) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }
    Card(
        shape = RoundedCornerShape(size = 8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clickable { navigationCallback(category.id) }
    ) {
        Row(
            modifier = Modifier.animateContentSize()
        ) {
            NetworkImage(
                imageUrl = category.imageUrl,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.8f)
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = category.name,
                    style = MaterialTheme.typography.h6
                )
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = category.description,
                        style = MaterialTheme.typography.subtitle2,
                        textAlign = TextAlign.Start,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = if (isExpanded) 10 else 3
                    )
                }
            }
            Icon(
                imageVector = if (isExpanded) {
                    Icons.Filled.KeyboardArrowUp
                } else {
                    Icons.Filled.KeyboardArrowDown
                },
                contentDescription = null,
                modifier = Modifier
                    .padding(16.dp)
                    .align(if (isExpanded) {
                        Alignment.Bottom
                    } else {
                        Alignment.CenterVertically
                    })
                    .clickable { isExpanded = !isExpanded }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzTheme {
        MealsCategoriesScreen {}
    }
}