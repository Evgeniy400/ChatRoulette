package com.example.chatroulette.db

import com.example.chatroulette.model.Profile

/* Заглушка, исполняющая роль базы данных
* */
class ProfileBase {
    var ankets = listOf(
        Profile(
            "Анджелина Джоли",
            "Лос-Анджелесс",
            photo = "https://cdnn1.img.sputniknewslv.com/img/1384/58/13845867_665:125:2290:1913_1920x0_80_0_0_ee3aae97048ef80c561bc91d362e8410.jpg"
        ),
        Profile(
            "Зендея",
            "Окленд",
            photo = "https://hips.hearstapps.com/hmg-prod/images/zendaya-attends-the-red-carpet-of-the-movie-dune-during-the-news-photo-1631632151.jpg?resize=480%3A*"
        ),
        Profile(
            "Эль Фэннинг",
            "Коньерс",
            photo = "https://assets.vogue.ru/photos/5dc539ace5b1fb0009352c2e/master/w_1600%2Cc_limit/w990.jpg"
        )
    )
        private set

    var profile = Profile()

    companion object {
        private var db: ProfileBase? = null

        fun getProfileBase() = db ?: ProfileBase().also {
            db = it
        }
    }
}