package com.purposebakery.kidsplanner.model

import android.content.ContextWrapper
import com.pixplicity.easyprefs.library.Prefs
import com.purposebakery.kidsplanner.model.objects.Icon
import com.purposebakery.kidsplanner.model.objects.Routine
import com.purposebakery.kidsplanner.model.objects.Task

object Model {

    val PREFS_KEY_MODEL = "PREFS_KEY_MODEL"

    var routines : MutableList<Routine> = mutableListOf()

    fun get() : List<Routine> {
        return routines
    }

    fun load() {
        //val rawJson = Prefs.getString(PREFS_KEY_MODEL, "[]")

        routines.clear()

        addTestData(routines)

    }

    fun save() {

    }

    fun addTestData(routines : MutableList<Routine>){
        val routine1 = Routine("morning", mutableListOf())
        routine1.addTask(Task(Icon.HYGIENE_BRUSH_TEETH))
        routine1.addTask(Task(Icon.HOME_EAT))
        routine1.addTask(Task(Icon.CHORES_TRASH))
        routine1.addTask(Task(Icon.CHORES_TIDY_UP))
        routine1.addTask(Task(Icon.FREE_OUTSIDE))

        routines.add(routine1)

        val routine2 = Routine("evening", mutableListOf())
        routine2.addTask(Task(Icon.HYGIENE_BRUSH_TEETH))
        routine2.addTask(Task(Icon.FREE_MOBILE))
        routine2.addTask(Task(Icon.HOME_PRAY))

        routines.add(routine2)

    }

    private fun
}
