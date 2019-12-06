package smr.playground.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_welcome.*
import kotlinx.android.synthetic.main.welcome_view.view.*
import smr.playground.R
import smr.playground.base.BaseActivity

class WelcomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        pager.adapter = DemoAdapter(Array(4) {
            DemoItem(
                "Hello World",
                "This is a sample text.\nSwipe to move the slider."
            )
        })
        TabLayoutMediator(tabLayout, pager) { _, _ -> }.attach()

    }

}

class DemoAdapter(private val dataSet: Array<DemoItem>) : RecyclerView.Adapter<DemoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DemoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.welcome_view, parent, false)
        return DemoViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: DemoViewHolder, position: Int) {
        val item = dataSet[position]
        holder.img.setImageResource(item.imageResIdRes)
        holder.txtTitle.text = item.title
        holder.txtSummary.text = item.summary
    }
}

class DemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val txtTitle = itemView.txtTitle
    val txtSummary = itemView.txtSummary
    val img = itemView.img
}

