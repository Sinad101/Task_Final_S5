package com.example.task_final_s5.database

class UserRepository(private val userDao: UserDao) {
    fun insert(user: User) {
        userDao.insert(user)
    }

    fun checkUser(email: String, password: String) {
        userDao.checkUser(email, password)
    }
}