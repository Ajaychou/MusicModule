package app.demo.musicmodule

import android.app.Application

class MusicModuleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initialiseMusicModule()
    }

    public fun initialiseMusicModule(): MusicModuleApp {
        return this
    }
}
