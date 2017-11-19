package com.purposebakery.kidsplanner.modules.settings

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.wear.widget.WearableLinearLayoutManager
import android.support.wear.widget.WearableRecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.purposebakery.kidsplanner.R
import com.purposebakery.kidsplanner.generic.BaseActivity
import com.purposebakery.kidsplanner.utils.inflate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.settings_list_item.*


class SettingsActivity : BaseActivity() {

    enum class Setting {COLORS, ROUTINES, INFO}
    data class SettingElement(var setting : Setting, var title : Int, var image : Int)

    var list : WearableRecyclerView? = null
    var adapter : Adapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)

        list = findViewById(R.id.list)
        list?.isEdgeItemsCenteringEnabled = true
        list?.layoutManager = WearableLinearLayoutManager(this)

        val items : List<SettingElement> = listOf(
                SettingElement(Setting.ROUTINES, R.string.settings_routines, R.drawable.ic_repeat_white_24dp),
                SettingElement(Setting.COLORS, R.string.settings_color, R.drawable.ic_color_lens_white_24dp),
                SettingElement(Setting.INFO, R.string.settings_info, R.drawable.ic_info_white_24dp)
        )

        adapter = Adapter(items, listener = { settingElement -> Log.d("test", settingElement.setting.name) })
        list?.adapter = adapter
    }


    class Adapter(val items: List<SettingElement>, val listener: (SettingElement) -> Unit) : RecyclerView.Adapter<Adapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.settings_list_item))

        override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)

        override fun getItemCount() = items.size

        class ViewHolder(override val containerView: View?) : RecyclerView.ViewHolder(containerView), LayoutContainer {
            fun bind(item: SettingElement, listener: (SettingElement) -> Unit) = with(itemView) {
                title.setText(item.title)
                icon.setImageResource(item.image)
                setOnClickListener { listener(item) }
            }
        }
    }
}
