package com.app.recipeapp.response

import com.app.recipeapp.entity.Recipe

data class ListRecipeResponse(
    val success: Boolean? = null,
    val data: ArrayList<String>? = null
)