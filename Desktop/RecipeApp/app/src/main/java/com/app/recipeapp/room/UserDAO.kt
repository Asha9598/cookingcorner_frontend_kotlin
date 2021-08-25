package com.app.recipeapp.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.app.recipeapp.entity.User

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun register(user: List<User>)

    @Query("SELECT * FROM User WHERE username=:username and password=:password")
    fun login(username: String, password: String): List<User>

    @Query("SELECT * FROM user WHERE username=:username")
    fun viewProfile(username: String): List<User>

    @Delete
    fun deleteProfile(user: User)

    @Update
    fun updateProfile(user: User)


}