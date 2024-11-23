package org.dilarakiraz.composempnotes

import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.flow
import org.dilarakiraz.composempnotes.apiClient.httpClient
import org.dilarakiraz.composempnotes.data.Product

class HomeRepository {
    suspend fun getProductsApi(): List<Product> {
        val response = httpClient.get("https://fakestoreapi.com/products")
        return response.body()
    }

    fun getProducts() = flow {
        emit(getProductsApi())
    }
}