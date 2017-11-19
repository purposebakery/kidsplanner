package com.purposebakery.kidsplanner.model.objects

class Routine(var name : String, var tasks : MutableList<Task>) {

    fun addTask(task : Task) {
        tasks.add(task)
    }

    fun removeTask(task : Task) {
        tasks.remove(task)
    }
}