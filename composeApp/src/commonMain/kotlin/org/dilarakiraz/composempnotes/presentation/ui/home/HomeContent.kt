package org.dilarakiraz.composempnotes.presentation.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.dilarakiraz.composempnotes.data.model.Product

@Composable
fun HomeContent(
    query: MutableState<String>,
    products: List<Product>,
    onQueryChange: (String) -> Unit,
    onSearch: () -> Unit,
    onClearSearch: () -> Unit,
) {
    BoxWithConstraints {
        val maxWidth = this.maxWidth
        var cols = 2
        var modifier = Modifier.fillMaxWidth()

        if (maxWidth > 840.dp) {
            cols = 3
            modifier = Modifier.widthIn(max = 1080.dp)
        }

        val scrollState = rememberLazyGridState()
        val coroutineScope = rememberCoroutineScope()

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {

            SearchBarComponent(
                query = query.value,
                onQueryChange = onQueryChange,
                onSearch = onSearch,
                onClearSearch = onClearSearch,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(cols),
                state = scrollState,
                contentPadding = PaddingValues(16.dp),
                modifier = modifier
            ) {
                items(items = products, key = { it.id.toString() }) { product ->
                    ProductCard(product = product)
                }
            }
        }
    }
}