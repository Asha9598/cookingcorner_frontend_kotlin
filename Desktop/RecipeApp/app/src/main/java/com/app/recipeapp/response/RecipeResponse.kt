package com.app.recipeapp.response

import com.app.recipeapp.entity.Recipe

data class RecipeResponse(
    val success: Boolean? = null,
    val data: Recipe? = null
)