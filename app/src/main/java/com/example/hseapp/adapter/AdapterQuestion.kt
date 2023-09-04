import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hseapp.R
import com.example.hseapp.dataclass.Data

class AdapterQuestion : RecyclerView.Adapter<AdapterQuestion.ViewHolder>() {

    private var questions: List<Data> = listOf()

    fun setQuestions(questions: List<Data>) {
        this.questions = questions
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val question = questions[position]
        holder.questionText.text = question.attributes.pertanyaan

        holder.radiogroup.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.yes_radio_button) {
                // Jika "Ya" dipilih, tampilkan kode bahaya dan keterangan
                holder.dangerLayout.visibility = View.VISIBLE
            } else {
                // Jika "Tidak" dipilih, sembunyikan kode bahaya dan keterangan
                holder.dangerLayout.visibility = View.GONE
            }

        }
    }
    override fun getItemCount(): Int {
        return questions.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val questionText: TextView = itemView.findViewById(R.id.question_text)
        val radiogroup : RadioGroup = itemView.findViewById(R.id.radio_group)
        val dangerLayout: LinearLayout = itemView.findViewById(R.id.danger_layout)
    }
}