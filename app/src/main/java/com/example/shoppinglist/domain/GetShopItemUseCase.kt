package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopItem(shopId: Int): ShopItem =
        shopListRepository.getShopItem(shopId)


}