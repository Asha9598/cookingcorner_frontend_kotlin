package com.app.recipeapp.response

import com.app.recipeapp.entity.User

data class UserResponse(
    val success: Boolean? = null,
    val data: User? = null,
    val token: String? = null
)