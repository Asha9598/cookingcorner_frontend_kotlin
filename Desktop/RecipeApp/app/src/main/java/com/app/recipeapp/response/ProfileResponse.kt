package com.app.recipeapp.response

import com.app.recipeapp.entity.User

data class ProfileResponse(
    val success: Boolean? = null,
    val data: User? = null
)