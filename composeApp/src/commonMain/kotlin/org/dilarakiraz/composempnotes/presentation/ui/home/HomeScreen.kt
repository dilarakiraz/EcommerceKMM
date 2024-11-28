package org.dilarakiraz.composempnotes.presentation.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import org.dilarakiraz.composempnotes.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
) {
    val query = remember { mutableStateOf("") }
    val products = homeViewModel.products.collectAsState()

    LaunchedEffect(query.value) {
        if (query.value.isNotEmpty()) {
            homeViewModel.searchProducts(query.value)
        } else homeViewModel.clearSearch()
    }


    HomeContent(
        query = query,
        products = products.value,
        onQueryChange = { query.value = it },
        onSearch = { homeViewModel.searchProducts(query.value) },
        onClearSearch = {
            query.value = ""
            homeViewModel.clearSearch()
        }
    )
}